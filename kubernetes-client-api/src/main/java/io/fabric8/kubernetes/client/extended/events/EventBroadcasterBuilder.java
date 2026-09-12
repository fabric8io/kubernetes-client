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

import io.fabric8.kubernetes.client.KubernetesClient;

import java.time.Clock;
import java.time.Duration;
import java.util.Objects;

/**
 * Builds an {@link EventBroadcaster}. The defaults are those of the go client; most callers only need to set the
 * sink, for which {@link #withKubernetesClient(KubernetesClient)} is the shorthand.
 */
public class EventBroadcasterBuilder {

  /** Events queued but not yet delivered, beyond which recording an event drops it instead of blocking. */
  public static final int DEFAULT_MAX_QUEUED_EVENTS = 1000;

  /** Attempts made to write one event before giving up on it. */
  public static final int DEFAULT_MAX_TRIES_PER_EVENT = 12;

  /** Base wait between those attempts, to which up to 25% of jitter is added. */
  public static final Duration DEFAULT_SLEEP_DURATION = Duration.ofSeconds(10);

  /** How long a series may go without a repeat before it is written out one last time and forgotten. */
  public static final Duration DEFAULT_FINISH_TIME = Duration.ofMinutes(6);

  /** How often the count of the series still being updated is flushed to the API server. */
  public static final Duration DEFAULT_REFRESH_TIME = Duration.ofMinutes(30);

  private EventSink sink;
  private Clock clock = Clock.systemUTC();
  private String hostname;
  private int maxQueuedEvents = DEFAULT_MAX_QUEUED_EVENTS;
  private int maxTriesPerEvent = DEFAULT_MAX_TRIES_PER_EVENT;
  private Duration sleepDuration = DEFAULT_SLEEP_DURATION;
  private Duration finishTime = DEFAULT_FINISH_TIME;
  private Duration refreshTime = DEFAULT_REFRESH_TIME;

  /**
   * Records to the {@code events.k8s.io/v1} API group of the given client. Shorthand for
   * {@code withSink(new KubernetesEventSink(client))}.
   *
   * @param client to record events with
   * @return this builder
   */
  public EventBroadcasterBuilder withKubernetesClient(KubernetesClient client) {
    return withSink(new KubernetesEventSink(client));
  }

  /**
   * @param sink to deliver events to
   * @return this builder
   */
  public EventBroadcasterBuilder withSink(EventSink sink) {
    this.sink = sink;
    return this;
  }

  /**
   * @param clock to timestamp events with, mainly useful to make aggregation testable
   * @return this builder
   */
  public EventBroadcasterBuilder withClock(Clock clock) {
    this.clock = Objects.requireNonNull(clock, "clock must not be null");
    return this;
  }

  /**
   * @param hostname to derive the reporting instance of {@link EventBroadcaster#newRecorder(String)} from; defaults
   *        to the {@code HOSTNAME} environment variable, which for a controller running in a pod is the pod name
   * @return this builder
   */
  public EventBroadcasterBuilder withHostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

  /**
   * @param maxQueuedEvents recorded but not yet delivered, beyond which further events are dropped
   * @return this builder
   */
  public EventBroadcasterBuilder withMaxQueuedEvents(int maxQueuedEvents) {
    this.maxQueuedEvents = positive(maxQueuedEvents, "maxQueuedEvents");
    return this;
  }

  /**
   * @param maxTriesPerEvent attempts to write one event before giving up on it
   * @return this builder
   */
  public EventBroadcasterBuilder withMaxTriesPerEvent(int maxTriesPerEvent) {
    this.maxTriesPerEvent = positive(maxTriesPerEvent, "maxTriesPerEvent");
    return this;
  }

  /**
   * @param sleepDuration base wait between those attempts
   * @return this builder
   */
  public EventBroadcasterBuilder withSleepDuration(Duration sleepDuration) {
    this.sleepDuration = positive(sleepDuration, "sleepDuration");
    return this;
  }

  /**
   * @param finishTime how long a series may go without a repeat before it is written out and forgotten
   * @return this builder
   */
  public EventBroadcasterBuilder withFinishTime(Duration finishTime) {
    this.finishTime = positive(finishTime, "finishTime");
    return this;
  }

  /**
   * @param refreshTime how often the count of the series still being updated is flushed to the API server
   * @return this builder
   */
  public EventBroadcasterBuilder withRefreshTime(Duration refreshTime) {
    this.refreshTime = positive(refreshTime, "refreshTime");
    return this;
  }

  /**
   * @return the broadcaster, already draining its queue but not yet recording anywhere; call
   *         {@link EventBroadcaster#startRecordingToSink()} next
   */
  public EventBroadcaster build() {
    Objects.requireNonNull(sink, "a sink is required, set one with withSink or withKubernetesClient");
    if (hostname == null) {
      hostname = EventBroadcaster.hostname();
    }
    return new EventBroadcaster(this);
  }

  EventSink getSink() {
    return sink;
  }

  Clock getClock() {
    return clock;
  }

  String getHostname() {
    return hostname;
  }

  int getMaxQueuedEvents() {
    return maxQueuedEvents;
  }

  int getMaxTriesPerEvent() {
    return maxTriesPerEvent;
  }

  Duration getSleepDuration() {
    return sleepDuration;
  }

  Duration getFinishTime() {
    return finishTime;
  }

  Duration getRefreshTime() {
    return refreshTime;
  }

  private static int positive(int value, String name) {
    if (value <= 0) {
      throw new IllegalArgumentException(name + " must be greater than zero, but was " + value);
    }
    return value;
  }

  private static Duration positive(Duration value, String name) {
    Objects.requireNonNull(value, name + " must not be null");
    if (value.isZero() || value.isNegative()) {
      throw new IllegalArgumentException(name + " must be greater than zero, but was " + value);
    }
    return value;
  }
}
