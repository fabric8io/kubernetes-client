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

import io.fabric8.kubernetes.api.model.events.v1.Event;
import io.fabric8.kubernetes.client.KubernetesClientException;

/**
 * Writes fully built events somewhere, the equivalent of the {@code EventSink} of the go client's {@code tools/events}
 * package. Extracted from {@link EventBroadcaster} so that the assembly and aggregation of events can be tested and
 * replaced independently of their delivery.
 * <p>
 * Implementations must respect the namespace embedded in the event, and must signal failures by throwing a
 * {@link KubernetesClientException}: the broadcaster decides whether to retry from
 * {@link KubernetesClientException#getCode()}, treating a response status as final and the absence of one (code
 * {@code -1}, meaning the server was never reached) as worth retrying. An exception of any other type is not
 * interpreted and abandons the event.
 */
public interface EventSink {

  /**
   * Creates the event.
   *
   * @param event to create
   * @return the event as returned by the server
   * @throws KubernetesClientException if the event could not be created
   */
  Event create(Event event);

  /**
   * Patches an already recorded event, used to update the {@code series} of an event that keeps repeating.
   *
   * @param event whose name and namespace identify the event to patch
   * @param patch a strategic merge patch
   * @return the event as returned by the server
   * @throws KubernetesClientException if the event could not be patched; a {@code 404} tells the broadcaster the
   *         event has since been removed, so that it re-creates it rather than giving up
   */
  Event patch(Event event, String patch);
}
