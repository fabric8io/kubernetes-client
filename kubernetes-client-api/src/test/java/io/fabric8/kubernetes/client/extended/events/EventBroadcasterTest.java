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

import io.fabric8.kubernetes.api.model.MicroTime;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.events.v1.Event;
import io.fabric8.kubernetes.api.model.events.v1.EventBuilder;
import io.fabric8.kubernetes.api.model.events.v1.EventSeries;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.entry;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class EventBroadcasterTest {

  private static final Instant START = Instant.parse("2024-01-01T10:00:00Z");

  private MutableClock clock;
  private RecordingSink sink;
  private EventBroadcaster broadcaster;
  private EventRecorder recorder;
  private final AtomicInteger barriers = new AtomicInteger();

  @BeforeEach
  void setUp() {
    clock = new MutableClock(START);
    sink = new RecordingSink();
    broadcaster = new EventBroadcasterBuilder()
        .withSink(sink)
        .withClock(clock)
        .withHostname("node-1")
        .withSleepDuration(Duration.ofMillis(1))
        .build();
    recorder = broadcaster.newRecorder("example.com/my-controller");
  }

  @AfterEach
  void tearDown() {
    broadcaster.shutdown();
  }

  private static Pod pod() {
    return new PodBuilder()
        .withNewMetadata()
        .withName("my-pod")
        .withNamespace("my-namespace")
        .withUid("pod-uid")
        .withResourceVersion("42")
        .endMetadata()
        .build();
  }

  private void awaitCreated(int count) {
    awaitUntil(() -> sink.created.size() >= count);
    assertThat(sink.created).hasSize(count);
  }

  private void awaitPatched(int count) {
    awaitUntil(() -> sink.patched.size() >= count);
    assertThat(sink.patched).hasSize(count);
  }

  private static void awaitUntil(BooleanSupplier condition) {
    await().atMost(10, TimeUnit.SECONDS).until(condition::getAsBoolean);
  }

  /**
   * Events are delivered in order by a single thread, so waiting for a later event to be recorded proves that every
   * event recorded before it has already been processed. That is what lets a test assert that an event was
   * <em>not</em> written to the sink without waiting for a timeout to elapse.
   * <p>
   * Each barrier uses a fresh reason, so that barriers are not repeats of one another and always produce a create.
   */
  private void awaitQuiescence() {
    final int createdBefore = sink.created.size();
    recorder.event(pod(), EventType.NORMAL, "Barrier" + barriers.incrementAndGet(), "Barrier", "barrier");
    awaitCreated(createdBefore + 1);
  }

  private static boolean isBarrier(Event event) {
    return event.getReason() != null && event.getReason().startsWith("Barrier");
  }

  @Nested
  @DisplayName("when a controller records an event about an object")
  class RecordingAnEvent {

    @BeforeEach
    void startRecording() {
      broadcaster.startRecordingToSink();
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "Started the pod");
      awaitCreated(1);
    }

    @Test
    @DisplayName("the event is created in the namespace of the object it is about")
    void createsInTheNamespaceOfTheObject() {
      assertThat(sink.created.get(0).getMetadata().getNamespace()).isEqualTo("my-namespace");
    }

    @Test
    @DisplayName("the event is named after the object it is about, suffixed with the time it happened")
    void namesTheEventAfterTheObject() {
      assertThat(sink.created.get(0).getMetadata().getName())
          .isEqualTo("my-pod." + Long.toHexString(START.getEpochSecond() * 1_000_000_000L));
    }

    @Test
    @DisplayName("the object the event is about is fully referenced, so that consumers can select on it")
    void referencesTheObject() {
      assertThat(sink.created.get(0).getRegarding()).satisfies(regarding -> {
        assertThat(regarding.getKind()).isEqualTo("Pod");
        assertThat(regarding.getApiVersion()).isEqualTo("v1");
        assertThat(regarding.getName()).isEqualTo("my-pod");
        assertThat(regarding.getNamespace()).isEqualTo("my-namespace");
        assertThat(regarding.getUid()).isEqualTo("pod-uid");
        assertThat(regarding.getResourceVersion()).isEqualTo("42");
      });
    }

    @Test
    @DisplayName("the type, reason, action and note given by the caller are recorded verbatim")
    void recordsWhatTheCallerAsked() {
      assertThat(sink.created.get(0)).satisfies(event -> {
        assertThat(event.getType()).isEqualTo("Normal");
        assertThat(event.getReason()).isEqualTo("Started");
        assertThat(event.getAction()).isEqualTo("Starting");
        assertThat(event.getNote()).isEqualTo("Started the pod");
      });
    }

    @Test
    @DisplayName("the event is attributed to the controller and to the instance of it that recorded it")
    void attributesTheEventToTheReporter() {
      assertThat(sink.created.get(0)).satisfies(event -> {
        assertThat(event.getReportingController()).isEqualTo("example.com/my-controller");
        assertThat(event.getReportingInstance()).isEqualTo("example.com/my-controller-node-1");
      });
    }

    @Test
    @DisplayName("the event is timestamped with microsecond precision, as the API requires of an eventTime")
    void timestampsTheEvent() {
      assertThat(sink.created.get(0).getEventTime().getTime()).isEqualTo("2024-01-01T10:00:00.000000Z");
    }

    @Test
    @DisplayName("a first occurrence is not part of a series")
    void doesNotStartASeries() {
      assertThat(sink.created.get(0).getSeries()).isNull();
    }
  }

  @Nested
  @DisplayName("when the same event happens again")
  class RepeatingEvents {

    @BeforeEach
    void startRecording() {
      broadcaster.startRecordingToSink();
    }

    private void recordStarted(String note) {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", note);
    }

    @Test
    @DisplayName("the second occurrence is folded into a series on the recorded event rather than recorded again")
    void foldsTheSecondOccurrenceIntoASeries() {
      recordStarted("first");
      awaitCreated(1);
      clock.advance(Duration.ofSeconds(5));
      recordStarted("second");
      awaitPatched(1);

      assertThat(sink.created).hasSize(1);
      assertThat(sink.patches.get(0))
          .isEqualTo("{\"series\":{\"count\":2,\"lastObservedTime\":\"2024-01-01T10:00:05.000000Z\"}}");
    }

    @Test
    @DisplayName("occurrences beyond the second are only counted, so that a hot loop does not hammer the API server")
    void countsFurtherOccurrencesWithoutWriting() {
      recordStarted("first");
      awaitCreated(1);
      recordStarted("second");
      awaitPatched(1);
      recordStarted("third");
      recordStarted("fourth");
      awaitQuiescence();

      assertThat(sink.patched).hasSize(1);
    }

    @Test
    @DisplayName("counting further occurrences does not retroactively alter the event already written")
    void doesNotMutateTheEventAlreadyWritten() {
      recordStarted("first");
      awaitCreated(1);
      recordStarted("second");
      awaitPatched(1);
      recordStarted("third");
      awaitQuiescence();

      assertThat(sink.patched.get(0).getSeries().getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("events that differ only by their note are the same event, so a varying message still aggregates")
    void treatsEventsDifferingOnlyByNoteAsRepeats() {
      recordStarted("started, attempt 1");
      awaitCreated(1);
      recordStarted("started, attempt 2");
      awaitPatched(1);

      assertThat(sink.created).hasSize(1);
    }

    @Test
    @DisplayName("events that differ by reason are distinct events, each recorded on its own")
    void keepsEventsWithDifferentReasonsApart() {
      recordStarted("first");
      awaitCreated(1);
      recorder.event(pod(), EventType.NORMAL, "Pulled", "Pulling", "first");
      awaitCreated(2);

      assertThat(sink.patched).isEmpty();
    }

    @Test
    @DisplayName("events about different objects are distinct events, even with the same reason")
    void keepsEventsAboutDifferentObjectsApart() {
      recordStarted("first");
      awaitCreated(1);
      final Pod other = new PodBuilder(pod()).editMetadata().withName("other-pod").withUid("other-uid").endMetadata()
          .build();
      recorder.event(other, EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(2);

      assertThat(sink.patched).isEmpty();
    }

    @Test
    @DisplayName("events from different controllers are distinct events, so replicas do not aggregate onto each other")
    void keepsEventsFromDifferentReportersApart() {
      recordStarted("first");
      awaitCreated(1);
      broadcaster.newRecorder("example.com/other-controller")
          .event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(2);

      assertThat(sink.patched).isEmpty();
    }
  }

  @Nested
  @DisplayName("when a series stops being updated")
  class FinishingSeries {

    @BeforeEach
    void startRecording() {
      broadcaster.startRecordingToSink();
    }

    @Test
    @DisplayName("the final count is written out once the series has gone quiet")
    void writesTheFinalCount() {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "second");
      awaitPatched(1);
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "third");
      awaitQuiescence();

      clock.advance(Duration.ofMinutes(7));
      broadcaster.finishSeries();

      assertThat(sink.patched).hasSize(2);
      assertThat(sink.patched.get(1).getSeries().getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("the series is forgotten afterwards, so that a later occurrence starts a fresh event")
    void forgetsTheFinishedSeries() {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "second");
      awaitPatched(1);

      clock.advance(Duration.ofMinutes(7));
      broadcaster.finishSeries();

      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "much later");
      awaitCreated(2);
    }

    @Test
    @DisplayName("a singleton event old enough to be stale is forgotten without being written again")
    void forgetsStaleSingletonEvents() {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);

      clock.advance(Duration.ofMinutes(7));
      broadcaster.finishSeries();

      assertThat(sink.patched).isEmpty();
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "much later");
      awaitCreated(2);
    }

    @Test
    @DisplayName("an ongoing series is refreshed, so its count on the server does not lag indefinitely")
    void refreshesOngoingSeries() {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "second");
      awaitPatched(1);
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "third");
      awaitQuiescence();

      broadcaster.refreshExistingEventSeries();

      assertThat(sink.patched).hasSize(2);
      assertThat(sink.patched.get(1).getSeries().getCount()).isEqualTo(3);
      // the series is still live, so a further occurrence keeps counting up rather than starting over
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "fourth");
      awaitQuiescence();
      broadcaster.refreshExistingEventSeries();
      assertThat(sink.patched.get(2).getSeries().getCount()).isEqualTo(4);
    }
  }

  @Nested
  @DisplayName("when writing an event to the API server fails")
  class HandlingFailures {

    @BeforeEach
    void startRecording() {
      broadcaster.startRecordingToSink();
    }

    @Test
    @DisplayName("an unreachable server is retried, because the event has not been rejected, only lost in transit")
    void retriesWhenTheServerCannotBeReached() {
      sink.createFailures.add(new KubernetesClientException("connection refused"));
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
    }

    @Test
    @DisplayName("an event the server rejects is abandoned, since sending the same thing again would fail the same way")
    void abandonsRejectedEvents() {
      sink.createFailures.add(rejection(HttpURLConnection.HTTP_BAD_REQUEST));
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitQuiescence();

      assertThat(sink.created).allMatch(EventBroadcasterTest::isBarrier);
    }

    @Test
    @DisplayName("giving up after the configured number of attempts stops the retry loop rather than blocking forever")
    void givesUpAfterTheConfiguredNumberOfAttempts() {
      final RecordingSink failing = new RecordingSink();
      for (int i = 0; i < 3; i++) {
        failing.createFailures.add(new KubernetesClientException("connection refused"));
      }
      try (EventBroadcaster limited = new EventBroadcasterBuilder()
          .withSink(failing)
          .withClock(clock)
          .withHostname("node-1")
          .withSleepDuration(Duration.ofMillis(1))
          .withMaxTriesPerEvent(2)
          .build()) {
        limited.startRecordingToSink();
        limited.newRecorder("example.com/my-controller")
            .event(pod(), EventType.NORMAL, "Started", "Starting", "first");
        limited.newRecorder("example.com/my-controller")
            .event(pod(), EventType.NORMAL, "Other", "Doing", "second");
        awaitUntil(() -> !failing.created.isEmpty());

        // the first event burned both of its attempts and was dropped; the second was recorded on its first
        assertThat(failing.created).extracting(event -> event.getReason()).containsExactly("Other");
        assertThat(failing.createFailures).isEmpty();
      }
    }

    @Test
    @DisplayName("a series whose event has been deleted is re-created rather than lost")
    void recreatesASeriesWhoseEventIsGone() {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
      sink.patchFailures.add(rejection(HttpURLConnection.HTTP_NOT_FOUND));
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "second");
      awaitCreated(2);

      assertThat(sink.created.get(1).getSeries().getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("a series that loses the race to create its event is retried, so the count is not silently dropped")
    void retriesWhenAnotherWriterCreatedTheEventFirst() {
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
      sink.patchFailures.add(rejection(HttpURLConnection.HTTP_NOT_FOUND));
      sink.createFailures.add(rejection(HttpURLConnection.HTTP_CONFLICT));
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "second");
      awaitPatched(1);

      assertThat(sink.patched.get(0).getSeries().getCount()).isEqualTo(2);
    }

    private KubernetesClientException rejection(int code) {
      final Status status = new StatusBuilder().withCode(code).withMessage("rejected").build();
      return new KubernetesClientException("rejected", code, status);
    }
  }

  @Nested
  @DisplayName("when the event cannot be assembled")
  class RejectingBadInput {

    @BeforeEach
    void startRecording() {
      broadcaster.startRecordingToSink();
    }

    @Test
    @DisplayName("an event about an object with no name is dropped, as the API server would reject the reference")
    void dropsEventsAboutUnnamedObjects() {
      recorder.event(new PodBuilder().withNewMetadata().endMetadata().build(),
          EventType.NORMAL, "Started", "Starting", "first");
      awaitQuiescence();

      assertThat(sink.created).allMatch(EventBroadcasterTest::isBarrier);
    }

    @Test
    @DisplayName("an event with no type is dropped, since tooling only understands Normal and Warning")
    void dropsUntypedEvents() {
      recorder.event(pod(), null, "Started", "Starting", "first");
      awaitQuiescence();

      assertThat(sink.created).allMatch(EventBroadcasterTest::isBarrier);
    }
  }

  @Nested
  @DisplayName("when the object the event is about is cluster scoped")
  class ClusterScopedObjects {

    @Test
    @DisplayName("the event is created in the default namespace, since an event always lives in one")
    void fallsBackToTheDefaultNamespace() {
      broadcaster.startRecordingToSink();
      final Namespace namespace = new NamespaceBuilder().withNewMetadata().withName("my-namespace").endMetadata()
          .build();
      recorder.event(namespace, EventType.WARNING, "Terminating", "Terminating", "going away");
      awaitCreated(1);

      assertThat(sink.created.get(0).getMetadata().getNamespace()).isEqualTo(EventBroadcaster.DEFAULT_NAMESPACE);
      assertThat(sink.created.get(0).getRegarding().getNamespace()).isNull();
    }
  }

  @Nested
  @DisplayName("when a related object and annotations are given")
  class OptionalFields {

    @Test
    @DisplayName("both are carried onto the recorded event")
    void carriesThemOntoTheEvent() {
      broadcaster.startRecordingToSink();
      final Pod related = new PodBuilder(pod()).editMetadata().withName("related-pod").endMetadata().build();
      recorder.event(pod(), related, Collections.singletonMap("example.com/trace-id", "abc"),
          EventType.WARNING, "Failed", "Creating", "could not create");
      awaitCreated(1);

      assertThat(sink.created.get(0).getRelated().getName()).isEqualTo("related-pod");
      assertThat(sink.created.get(0).getMetadata().getAnnotations())
          .containsExactly(entry("example.com/trace-id", "abc"));
    }
  }

  @Nested
  @DisplayName("when the queue of recorded events overflows")
  class Overflowing {

    @Test
    @DisplayName("events are dropped rather than blocking the controller that recorded them")
    void dropsEventsInsteadOfBlocking() {
      final CountDownLatch release = new CountDownLatch(1);
      final AtomicInteger delivered = new AtomicInteger();
      try (EventBroadcaster tiny = new EventBroadcasterBuilder()
          .withSink(sink)
          .withClock(clock)
          .withHostname("node-1")
          .withMaxQueuedEvents(1)
          .build()) {
        // the only handler blocks, so nothing drains the queue beyond the one event it took
        tiny.startEventWatcher(event -> {
          try {
            release.await();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          delivered.incrementAndGet();
        });
        final EventRecorder tinyRecorder = tiny.newRecorder("example.com/my-controller");
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
          for (int i = 0; i < 10_000; i++) {
            tinyRecorder.event(pod(), EventType.NORMAL, "Started", "Starting", "note " + i);
          }
        });
      } finally {
        release.countDown();
      }

      // at most the one event in the handler plus the one buffered can have survived; the rest were dropped
      assertThat(delivered.get()).isLessThanOrEqualTo(2);
    }
  }

  @Nested
  @DisplayName("when watching events instead of recording them")
  class WatchingEvents {

    @Test
    @DisplayName("a registered handler sees every recorded event, without any of them reaching the sink")
    void handlersSeeEventsWithoutASink() {
      final List<Event> seen = new CopyOnWriteArrayList<>();
      broadcaster.startEventWatcher(seen::add);
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitUntil(() -> !seen.isEmpty());

      assertThat(seen).singleElement()
          .satisfies(event -> assertThat(event.getReason()).isEqualTo("Started"));
      assertThat(sink.created).isEmpty();
    }

    @Test
    @DisplayName("a deregistered handler stops seeing events")
    void deregisteredHandlersStopSeeingEvents() {
      final List<Event> seen = new CopyOnWriteArrayList<>();
      final Runnable stop = broadcaster.startEventWatcher(seen::add);
      broadcaster.startRecordingToSink();
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
      stop.run();
      recorder.event(pod(), EventType.NORMAL, "Pulled", "Pulling", "second");
      awaitCreated(2);

      assertThat(seen).hasSize(1);
    }

    @Test
    @DisplayName("a handler that throws does not stop the other handlers from seeing the event")
    void aFailingHandlerDoesNotBreakTheOthers() {
      broadcaster.startEventWatcher(event -> {
        throw new IllegalStateException("boom");
      });
      broadcaster.startRecordingToSink();
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");
      awaitCreated(1);
    }
  }

  @Nested
  @DisplayName("lifecycle")
  class Lifecycle {

    @Test
    @DisplayName("recording to the sink may only be started once")
    void startsRecordingOnlyOnce() {
      broadcaster.startRecordingToSink();
      assertThatIllegalStateException().isThrownBy(broadcaster::startRecordingToSink);
    }

    @Test
    @DisplayName("recording to the sink cannot be started after a shutdown")
    void refusesToStartAfterShutdown() {
      broadcaster.shutdown();
      assertThatIllegalStateException().isThrownBy(broadcaster::startRecordingToSink);
    }

    @Test
    @DisplayName("shutting down twice is harmless, so close and shutdown can be combined freely")
    void shutsDownIdempotently() {
      broadcaster.startRecordingToSink();
      broadcaster.shutdown();
      broadcaster.close();
    }

    @Test
    @DisplayName("an event recorded after shutdown is dropped rather than kept for a broadcaster that will never run")
    void dropsEventsRecordedAfterShutdown() {
      broadcaster.startRecordingToSink();
      broadcaster.shutdown();
      recorder.event(pod(), EventType.NORMAL, "Started", "Starting", "first");

      assertThat(sink.created).isEmpty();
    }
  }

  @Nested
  @DisplayName("builder")
  class Building {

    @Test
    @DisplayName("a sink is required, since a broadcaster with nowhere to record to is useless")
    void requiresASink() {
      assertThatNullPointerException().isThrownBy(() -> new EventBroadcasterBuilder().build());
    }

    @Test
    @DisplayName("timings and limits have to be positive, as zero or less would busy loop or drop everything")
    void rejectsNonPositiveSettings() {
      final EventBroadcasterBuilder builder = new EventBroadcasterBuilder();
      assertThatIllegalArgumentException().isThrownBy(() -> builder.withMaxQueuedEvents(0));
      assertThatIllegalArgumentException().isThrownBy(() -> builder.withMaxTriesPerEvent(0));
      assertThatIllegalArgumentException().isThrownBy(() -> builder.withSleepDuration(Duration.ZERO));
      assertThatIllegalArgumentException().isThrownBy(() -> builder.withFinishTime(Duration.ofSeconds(-1)));
      assertThatIllegalArgumentException().isThrownBy(() -> builder.withRefreshTime(Duration.ZERO));
    }
  }

  @Nested
  @DisplayName("event names")
  class EventNames {

    @Test
    @DisplayName("a name derived from a valid object name is used as is, so events sort next to their object")
    void derivesTheNameFromTheObject() {
      assertThat(EventBroadcaster.generateEventName("my-pod", START)).startsWith("my-pod.");
    }

    @Test
    @DisplayName("a name the API server would reject falls back to a random one, so the event is not lost")
    void fallsBackToARandomName() {
      final String name = EventBroadcaster.generateEventName("Not_A_Valid_Name", START);

      assertThat(name).doesNotContain("Not_A_Valid_Name");
      assertThat(KubernetesResourceUtil.isValidSubdomainName(name)).isTrue();
    }

    @Test
    @DisplayName("two occurrences at different times get different names, so neither overwrites the other")
    void namesDifferByTime() {
      assertThat(EventBroadcaster.generateEventName("my-pod", START))
          .isNotEqualTo(EventBroadcaster.generateEventName("my-pod", START.plusNanos(1)));
    }
  }

  @Nested
  @DisplayName("series patch")
  class SeriesPatch {

    @Test
    @DisplayName("only the series is patched, so a concurrent change to the rest of the event is preserved")
    void patchesOnlyTheSeries() {
      final Event event = new EventBuilder()
          .withNewMetadata().withName("my-pod.1").withNamespace("my-namespace").endMetadata()
          .withReason("Started")
          .withSeries(new EventSeries(3, new MicroTime("2024-01-01T10:00:05.000000Z")))
          .build();

      assertThat(EventBroadcaster.seriesPatch(event))
          .isEqualTo("{\"series\":{\"count\":3,\"lastObservedTime\":\"2024-01-01T10:00:05.000000Z\"}}");
    }
  }

  private static final class RecordingSink implements EventSink {

    private final List<Event> created = Collections.synchronizedList(new ArrayList<>());
    private final List<Event> patched = Collections.synchronizedList(new ArrayList<>());
    private final List<String> patches = Collections.synchronizedList(new ArrayList<>());
    private final Queue<KubernetesClientException> createFailures = new ConcurrentLinkedQueue<>();
    private final Queue<KubernetesClientException> patchFailures = new ConcurrentLinkedQueue<>();

    @Override
    public Event create(Event event) {
      final KubernetesClientException failure = createFailures.poll();
      if (failure != null) {
        throw failure;
      }
      final Event stored = new EventBuilder(event).build();
      created.add(stored);
      return stored;
    }

    @Override
    public Event patch(Event event, String patch) {
      final KubernetesClientException failure = patchFailures.poll();
      if (failure != null) {
        throw failure;
      }
      final Event stored = new EventBuilder(event).build();
      patched.add(stored);
      patches.add(patch);
      return stored;
    }
  }

  /** A clock the tests move by hand, so that aggregation windows can be crossed without waiting for them. */
  private static final class MutableClock extends Clock {

    private volatile Instant instant;

    private MutableClock(Instant instant) {
      this.instant = instant;
    }

    private void advance(Duration duration) {
      instant = instant.plus(duration);
    }

    @Override
    public ZoneId getZone() {
      return ZoneOffset.UTC;
    }

    @Override
    public Clock withZone(ZoneId zone) {
      return this;
    }

    @Override
    public Instant instant() {
      return instant;
    }
  }
}
