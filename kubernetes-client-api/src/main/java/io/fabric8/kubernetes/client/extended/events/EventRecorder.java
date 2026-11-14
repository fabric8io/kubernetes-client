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

import java.util.Map;

/**
 * Records {@code events.k8s.io/v1} events on behalf of a controller, the equivalent of the {@code EventRecorder} of
 * the go client's {@code tools/events} package.
 * <p>
 * Obtain one from {@link EventBroadcaster#newRecorder(String)}. Recording an event never blocks and never fails the
 * caller: the event is handed to the broadcaster's queue, and everything after that (aggregation into a series,
 * writing to the API server, retrying) happens on the broadcaster's own thread. An event that cannot be queued
 * because the queue is full, or that is malformed, is logged and dropped.
 */
public interface EventRecorder {

  /**
   * Records an event about {@code regarding}, with no related object and no annotations.
   *
   * @param regarding the object the event is about
   * @param type of the event, see {@link EventType}
   * @param reason a short, machine understandable, UpperCamelCase string explaining why the event was emitted; it is
   *        what consumers switch on, so keep it stable
   * @param action the action taken or failed regarding the object, also short and machine understandable
   * @param note a human readable description; the API server rejects notes longer than 1024 characters
   */
  default void event(HasMetadata regarding, EventType type, String reason, String action, String note) {
    event(regarding, null, type, reason, action, note);
  }

  /**
   * Records an event about {@code regarding}, with no annotations.
   *
   * @param regarding the object the event is about
   * @param related a secondary object the event also concerns, may be {@code null}; for example the pod a
   *        replica set event is about
   * @param type of the event, see {@link EventType}
   * @param reason a short, machine understandable, UpperCamelCase string explaining why the event was emitted
   * @param action the action taken or failed regarding the object
   * @param note a human readable description
   */
  default void event(HasMetadata regarding, HasMetadata related, EventType type, String reason, String action,
      String note) {
    event(regarding, related, null, type, reason, action, note);
  }

  /**
   * Records an event about {@code regarding}.
   *
   * @param regarding the object the event is about
   * @param related a secondary object the event also concerns, may be {@code null}
   * @param annotations to set on the recorded event, may be {@code null}
   * @param type of the event, see {@link EventType}
   * @param reason a short, machine understandable, UpperCamelCase string explaining why the event was emitted
   * @param action the action taken or failed regarding the object
   * @param note a human readable description
   */
  void event(HasMetadata regarding, HasMetadata related, Map<String, String> annotations, EventType type,
      String reason, String action, String note);
}
