/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.extended.events;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.MicroTime;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.events.v1.Event;
import io.fabric8.kubernetes.api.model.events.v1.EventBuilder;
import io.fabric8.kubernetes.api.model.events.v1.EventSeries;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Receives events from the {@link EventRecorder}s it hands out and delivers them to an {@link EventSink}, a port of
 * the {@code EventBroadcaster} of the go client's {@code tools/events} package.
 * <p>
 * Recording an event only puts it on a bounded queue, so that a controller is never slowed down, and never broken, by
 * the recording of an event. A single daemon thread drains that queue and passes each event to the registered
 * handlers; when the queue is full events are dropped and logged rather than blocking the caller.
 * <p>
 * The handler installed by {@link #startRecordingToSink()} is where the aggregation of the Kubernetes event model
 * happens. Events that differ only by their note are <em>isomorphic</em>: the first one is created, and the repeats
 * are folded into its {@code series}, which is what makes {@code kubectl describe} report a repeating event once with
 * a count rather than filling the event list with copies of it. A series is only flushed to the API server
 * periodically ({@link EventBroadcasterBuilder#withRefreshTime(java.time.Duration)}) and once it stops being updated
 * ({@link EventBroadcasterBuilder#withFinishTime(java.time.Duration)}), so the count of an ongoing series lags behind
 * on the server by design.
 * <p>
 * Typical use:
 *
 * <pre>{@code
 * try (EventBroadcaster broadcaster = EventBroadcaster.newBroadcaster(client)) {
 *   broadcaster.startRecordingToSink();
 *   EventRecorder recorder = broadcaster.newRecorder("my-controller");
 *   recorder.event(pod, EventType.NORMAL, "Started", "Starting", "Started the pod");
 * }
 * }</pre>
 *
 * Register the handlers, by calling {@link #startRecordingToSink()}, before recording events: an event recorded while
 * no handler is registered is discarded, exactly as it is by the go client.
 */
public class EventBroadcaster implements Closeable {

  private static final Logger logger = LoggerFactory.getLogger(EventBroadcaster.class);

  /** Events about a cluster scoped object have to live in some namespace; Kubernetes uses this one. */
  public static final String DEFAULT_NAMESPACE = "default";

  /**
   * Kubernetes {@code MicroTime}s are RFC 3339 timestamps with microsecond precision. Note that the underlying clock
   * may be coarser than that, in which case the trailing digits are simply zero.
   */
  private static final DateTimeFormatter MICRO_TIME = DateTimeFormatter
      .ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
      .withZone(ZoneOffset.UTC);

  /** Tolerates both the {@code Z} Kubernetes emits and a numeric offset, unlike {@link Instant#parse(CharSequence)}. */
  private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

  /** How much of the sleep between retries is randomized, so that clients do not resynchronize on an outage. */
  private static final double SLEEP_JITTER_FACTOR = 0.25;

  private final EventSink sink;
  private final Clock clock;
  private final String hostname;
  private final int maxTriesPerEvent;
  private final long sleepMillis;
  private final long finishMillis;
  private final long refreshMillis;

  private final BlockingQueue<Event> queue;
  private final List<Consumer<Event>> handlers = new CopyOnWriteArrayList<>();
  private final Thread worker;

  /** The events recorded so far, by the identity that makes two of them isomorphic. Guarded by {@link #cacheLock}. */
  private final Map<EventKey, Event> eventCache = new HashMap<>();
  private final Object cacheLock = new Object();

  private ScheduledExecutorService scheduler;
  private Runnable stopRecordingToSink;
  private boolean started;
  private volatile boolean shutdown;

  EventBroadcaster(EventBroadcasterBuilder builder) {
    this.sink = builder.getSink();
    this.clock = builder.getClock();
    this.hostname = builder.getHostname();
    this.maxTriesPerEvent = builder.getMaxTriesPerEvent();
    this.sleepMillis = builder.getSleepDuration().toMillis();
    this.finishMillis = builder.getFinishTime().toMillis();
    this.refreshMillis = builder.getRefreshTime().toMillis();
    this.queue = new ArrayBlockingQueue<>(builder.getMaxQueuedEvents());
    this.worker = Utils.daemonThreadFactory(this).newThread(this::distribute);
    this.worker.start();
  }

  /**
   * Creates a broadcaster recording to the {@code events.k8s.io/v1} API group of the given client, with the defaults
   * of the go client. Use {@link EventBroadcasterBuilder} to override them.
   *
   * @param client to record events with
   * @return the broadcaster, on which {@link #startRecordingToSink()} still has to be called
   */
  public static EventBroadcaster newBroadcaster(KubernetesClient client) {
    return new EventBroadcasterBuilder().withKubernetesClient(client).build();
  }

  /**
   * Returns a recorder that records events on behalf of the given controller. The reporting instance is derived from
   * the controller name and the host name, which for a controller running in a pod is the pod name.
   *
   * @param reportingController the name of the controller recording the events, conventionally a domain prefixed
   *        path such as {@code example.com/my-controller}
   * @return a recorder feeding this broadcaster
   */
  public EventRecorder newRecorder(String reportingController) {
    Objects.requireNonNull(reportingController, "reportingController must not be null");
    return newRecorder(reportingController, reportingController + "-" + hostname);
  }

  /**
   * Returns a recorder that records events on behalf of the given controller and instance of it.
   *
   * @param reportingController the name of the controller recording the events
   * @param reportingInstance the name of the particular instance of that controller, which distinguishes the
   *        replicas of a controller from one another
   * @return a recorder feeding this broadcaster
   */
  public EventRecorder newRecorder(String reportingController, String reportingInstance) {
    Objects.requireNonNull(reportingController, "reportingController must not be null");
    Objects.requireNonNull(reportingInstance, "reportingInstance must not be null");
    return new RecorderImpl(reportingController, reportingInstance);
  }

  /**
   * Starts delivering recorded events to the sink, aggregating repeats into event series. May only be called once.
   */
  public synchronized void startRecordingToSink() {
    if (shutdown) {
      throw new IllegalStateException("event broadcaster has been shut down");
    }
    if (started) {
      throw new IllegalStateException("event broadcaster already started");
    }
    started = true;
    stopRecordingToSink = startEventWatcher(this::recordToSink);
    scheduler = new ScheduledThreadPoolExecutor(1, Utils.daemonThreadFactory(this));
    scheduler.scheduleWithFixedDelay(
        () -> guarded("refresh event series", this::refreshExistingEventSeries),
        refreshMillis, refreshMillis, TimeUnit.MILLISECONDS);
    scheduler.scheduleWithFixedDelay(
        () -> guarded("finish event series", this::finishSeries),
        finishMillis, finishMillis, TimeUnit.MILLISECONDS);
  }

  /**
   * Starts passing recorded events to the given handler, without involving the sink. Useful to observe events in
   * tests, or to process them in some other way.
   * <p>
   * Handlers are invoked one after the other on the single thread draining the queue, so a handler that blocks holds
   * up every other handler, and eventually causes events to be dropped.
   *
   * @param eventHandler to pass events to; it must not mutate the event it is given, which is shared with the other
   *        handlers
   * @return a handle that deregisters the handler when run
   */
  public Runnable startEventWatcher(Consumer<Event> eventHandler) {
    Objects.requireNonNull(eventHandler, "eventHandler must not be null");
    handlers.add(eventHandler);
    return () -> handlers.remove(eventHandler);
  }

  /**
   * Starts logging recorded events, at info level.
   *
   * @return a handle that stops the logging when run
   */
  public Runnable startLogging() {
    return startEventWatcher(event -> logger.info("Event occurred: {}", describe(event)));
  }

  /**
   * Stops the broadcaster. Queued events that have not been delivered yet are discarded, and an event recorded after
   * this point is dropped. Idempotent.
   */
  public synchronized void shutdown() {
    if (shutdown) {
      return;
    }
    shutdown = true;
    if (stopRecordingToSink != null) {
      stopRecordingToSink.run();
      stopRecordingToSink = null;
    }
    if (scheduler != null) {
      scheduler.shutdownNow();
      scheduler = null;
    }
    // unblocks the worker whether it is waiting for an event or sleeping between retries
    worker.interrupt();
  }

  @Override
  public void close() {
    shutdown();
  }

  private void distribute() {
    while (!shutdown) {
      final Event event;
      try {
        event = queue.take();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }
      for (Consumer<Event> handler : handlers) {
        try {
          handler.accept(event);
        } catch (Exception e) {
          logger.error("Event handler failed to process event: {}", describe(event), e);
        }
      }
    }
  }

  private void publish(Event event) {
    if (shutdown) {
      logger.warn("Unable to record event: broadcaster has been shut down, dropped event: {}", describe(event));
      return;
    }
    if (!queue.offer(event)) {
      logger.error("Unable to record event: too many queued events, dropped event: {}", describe(event));
    }
  }

  /**
   * Records the event, or folds it into the series of the isomorphic event already recorded. Only the event that
   * starts a series, and the one that turns a singleton into a series, are written here; the further repeats are
   * counted in the cache and flushed by {@link #refreshExistingEventSeries()} and {@link #finishSeries()}.
   */
  void recordToSink(Event event) {
    final Event toRecord;
    synchronized (cacheLock) {
      final EventKey key = new EventKey(event);
      final Event isomorphic = eventCache.get(key);
      if (isomorphic == null) {
        eventCache.put(key, event);
        toRecord = copy(event);
      } else if (isomorphic.getSeries() != null) {
        final EventSeries series = isomorphic.getSeries();
        // the count of an event read back from the server is not guaranteed to be set
        series.setCount(series.getCount() == null ? 2 : series.getCount() + 1);
        series.setLastObservedTime(microTimeNow());
        return;
      } else {
        isomorphic.setSeries(new EventSeries(2, microTimeNow()));
        // record a copy, so that the server's response cannot interfere with the cached aggregation state
        toRecord = copy(isomorphic);
      }
    }
    attemptRecording(toRecord);
  }

  /** Flushes the count reached so far by the series still being updated, so that they do not go stale on the server. */
  void refreshExistingEventSeries() {
    // as in the go client, the cache is held for the whole sweep, so recording an event waits behind it
    synchronized (cacheLock) {
      for (Map.Entry<EventKey, Event> entry : eventCache.entrySet()) {
        final Event event = entry.getValue();
        if (event.getSeries() != null) {
          final RecordAttempt attempt = recordEvent(event);
          if (!attempt.retry && attempt.recorded != null) {
            entry.setValue(attempt.recorded);
          }
        }
      }
    }
  }

  /**
   * Writes the final count of the series that have stopped being updated and forgets them, along with the singleton
   * events old enough that a repeat of them should start a new event rather than extend the recorded one.
   */
  void finishSeries() {
    final Instant cutoff = clock.instant().minusMillis(finishMillis);
    synchronized (cacheLock) {
      final Iterator<Map.Entry<EventKey, Event>> events = eventCache.entrySet().iterator();
      while (events.hasNext()) {
        final Event event = events.next().getValue();
        final EventSeries series = event.getSeries();
        if (series == null) {
          if (isBefore(event.getEventTime(), cutoff)) {
            events.remove();
          }
        } else if (isBefore(series.getLastObservedTime(), cutoff) && !recordEvent(event).retry) {
          events.remove();
        }
      }
    }
  }

  private void attemptRecording(Event event) {
    for (int tries = 1; tries <= maxTriesPerEvent; tries++) {
      if (!recordEvent(event).retry) {
        return;
      }
      if (tries == maxTriesPerEvent) {
        break;
      }
      if (!sleepBeforeRetry()) {
        return;
      }
    }
    logger.error("Unable to write event (retry limit exceeded!): {}", describe(event));
  }

  /**
   * Writes the event once. An event that is part of a series is patched onto the event already recorded for it, and
   * created instead if that event turns out to be gone.
   */
  private RecordAttempt recordEvent(Event event) {
    final boolean isEventSeries = event.getSeries() != null;
    if (isEventSeries) {
      try {
        return RecordAttempt.recorded(sink.patch(event, seriesPatch(event)));
      } catch (KubernetesClientException e) {
        if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND) {
          return failed(e, event, true);
        }
        // the event we were extending has been removed, fall through and create it again
      }
    }
    try {
      final ObjectMeta metadata = event.getMetadata();
      if (metadata != null) {
        // a resource version left over from a previous write would make the creation fail
        metadata.setResourceVersion(null);
      }
      return RecordAttempt.recorded(sink.create(event));
    } catch (KubernetesClientException e) {
      return failed(e, event, isEventSeries);
    }
  }

  private RecordAttempt failed(KubernetesClientException e, Event event, boolean isEventSeries) {
    if (e.getCode() == HttpURLConnection.HTTP_CONFLICT) {
      if (isEventSeries) {
        // the patch failed because the event did not exist yet, and the creation then failed because by now it does:
        // another writer created it in between, so patching it will work on the next try
        return RecordAttempt.retry();
      }
      logger.debug("Server rejected event (will not retry!): {}", describe(event), e);
      return RecordAttempt.abandoned();
    }
    if (e.getCode() > 0) {
      // the server answered and rejected the event: sending the same thing again would be rejected again
      logger.error("Server rejected event (will not retry!): {}", describe(event), e);
      return RecordAttempt.abandoned();
    }
    // no response status, so the server was never reached; hold on to the event and keep trying
    logger.error("Unable to write event (may retry after sleeping): {}", describe(event), e);
    return RecordAttempt.retry();
  }

  /**
   * @return {@code false} if the wait was cut short, because the broadcaster is shutting down
   */
  private boolean sleepBeforeRetry() {
    final long delay = (long) (sleepMillis * (1 + SLEEP_JITTER_FACTOR * Math.random()));
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return false;
    }
    return !shutdown;
  }

  private void guarded(String description, Runnable task) {
    try {
      task.run();
    } catch (Exception e) {
      // a scheduled task that throws is never run again, and these two keep the event cache bounded
      logger.error("Failed to {}", description, e);
    }
  }

  /**
   * Builds the strategic merge patch that adds the current state of the series to the recorded event, the equivalent
   * of the two way merge patch the go client computes between the event with and without its series.
   */
  static String seriesPatch(Event event) {
    return Serialization.asJson(Collections.singletonMap("series", event.getSeries()));
  }

  private MicroTime microTimeNow() {
    return new MicroTime(MICRO_TIME.format(clock.instant()));
  }

  private static boolean isBefore(MicroTime time, Instant cutoff) {
    if (time == null || time.getTime() == null) {
      // an event we cannot date cannot be aged out on its timestamp; drop it rather than leak it
      return true;
    }
    try {
      return TIMESTAMP.parse(time.getTime(), Instant::from).isBefore(cutoff);
    } catch (DateTimeParseException e) {
      logger.debug("Could not parse event timestamp {}, treating the event as expired", time.getTime(), e);
      return true;
    }
  }

  private static Event copy(Event event) {
    return new EventBuilder(event).build();
  }

  static String describe(Event event) {
    final ObjectReference regarding = event.getRegarding();
    return String.format("regarding %s %s/%s, type %s, reason %s, action %s, note %s",
        regarding == null ? null : regarding.getKind(),
        regarding == null ? null : regarding.getNamespace(),
        regarding == null ? null : regarding.getName(),
        event.getType(), event.getReason(), event.getAction(), event.getNote());
  }

  /**
   * The host name to report events under. For a controller running in a pod this is the pod name, which is what
   * distinguishes the events of one replica from those of another.
   */
  static String hostname() {
    final String fromEnv = Utils.getEnvVar("HOSTNAME", null);
    if (Utils.isNotNullOrEmpty(fromEnv)) {
      return fromEnv;
    }
    try {
      return InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException e) {
      logger.debug("Could not determine the host name to report events under", e);
      return "unknown";
    }
  }

  private final class RecorderImpl implements EventRecorder {

    private final String reportingController;
    private final String reportingInstance;

    private RecorderImpl(String reportingController, String reportingInstance) {
      this.reportingController = reportingController;
      this.reportingInstance = reportingInstance;
    }

    @Override
    public void event(HasMetadata regarding, HasMetadata related, Map<String, String> annotations, EventType type,
        String reason, String action, String note) {
      if (type == null) {
        logger.error("Unsupported event type: null, will not report event with reason {}", reason);
        return;
      }
      final ObjectReference refRegarding = reference(regarding);
      if (refRegarding == null) {
        logger.error("Could not construct reference, will not report event with type {} and reason {}: {}",
            type.getValue(), reason, note);
        return;
      }
      final ObjectReference refRelated = related == null ? null : reference(related);
      if (related != null && refRelated == null) {
        logger.debug("Could not construct reference to the related object of event with reason {}", reason);
      }
      publish(makeEvent(refRegarding, refRelated, annotations, type, reason, action, note));
    }

    private Event makeEvent(ObjectReference refRegarding, ObjectReference refRelated, Map<String, String> annotations,
        EventType type, String reason, String action, String note) {
      final Instant now = clock.instant();
      final String namespace = Utils.isNullOrEmpty(refRegarding.getNamespace())
          ? DEFAULT_NAMESPACE
          : refRegarding.getNamespace();
      return new EventBuilder()
          .withNewMetadata()
          .withName(generateEventName(refRegarding.getName(), now))
          .withNamespace(namespace)
          .withAnnotations(annotations == null ? null : new LinkedHashMap<>(annotations))
          .endMetadata()
          .withEventTime(new MicroTime(MICRO_TIME.format(now)))
          .withReportingController(reportingController)
          .withReportingInstance(reportingInstance)
          .withAction(action)
          .withReason(reason)
          .withRegarding(refRegarding)
          .withRelated(refRelated)
          .withNote(note)
          .withType(type.getValue())
          .build();
    }
  }

  /**
   * Names an event after the object it is about plus the time it happened, following the convention of the go client.
   * The name of the object may not be a valid name for an event, in which case a random name is used instead, since a
   * name the API server rejects would lose the event entirely.
   */
  static String generateEventName(String regardingName, Instant time) {
    final long unixNano = time.getEpochSecond() * 1_000_000_000L + time.getNano();
    final String name = regardingName + "." + Long.toHexString(unixNano);
    return KubernetesResourceUtil.isValidSubdomainName(name) ? name : UUID.randomUUID().toString();
  }

  static ObjectReference reference(HasMetadata resource) {
    if (resource == null) {
      return null;
    }
    final ObjectMeta metadata = resource.getMetadata();
    if (metadata == null || Utils.isNullOrEmpty(metadata.getName())) {
      return null;
    }
    return new ObjectReferenceBuilder()
        .withApiVersion(resource.getApiVersion())
        .withKind(resource.getKind())
        .withName(metadata.getName())
        .withNamespace(metadata.getNamespace())
        .withUid(metadata.getUid())
        .withResourceVersion(metadata.getResourceVersion())
        .build();
  }

  /**
   * Identifies the events that are repeats of one another and should therefore be aggregated into a single event with
   * a series. Everything but the note takes part, so that the same thing happening again with a slightly different
   * wording still counts as a repeat.
   */
  private static final class EventKey {

    private final String type;
    private final String action;
    private final String reason;
    private final String reportingController;
    private final String reportingInstance;
    private final ObjectReference regarding;
    private final ObjectReference related;

    private EventKey(Event event) {
      this.type = event.getType();
      this.action = event.getAction();
      this.reason = event.getReason();
      this.reportingController = event.getReportingController();
      this.reportingInstance = event.getReportingInstance();
      this.regarding = event.getRegarding();
      this.related = event.getRelated();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof EventKey)) {
        return false;
      }
      final EventKey other = (EventKey) o;
      return Objects.equals(type, other.type)
          && Objects.equals(action, other.action)
          && Objects.equals(reason, other.reason)
          && Objects.equals(reportingController, other.reportingController)
          && Objects.equals(reportingInstance, other.reportingInstance)
          && Objects.equals(regarding, other.regarding)
          && Objects.equals(related, other.related);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type, action, reason, reportingController, reportingInstance, regarding, related);
    }
  }

  /** The outcome of a single write to the sink. */
  private static final class RecordAttempt {

    private static final RecordAttempt RETRY = new RecordAttempt(null, true);
    private static final RecordAttempt ABANDONED = new RecordAttempt(null, false);

    private final Event recorded;
    private final boolean retry;

    private RecordAttempt(Event recorded, boolean retry) {
      this.recorded = recorded;
      this.retry = retry;
    }

    private static RecordAttempt recorded(Event event) {
      return new RecordAttempt(event, false);
    }

    private static RecordAttempt retry() {
      return RETRY;
    }

    private static RecordAttempt abandoned() {
      return ABANDONED;
    }
  }
}
