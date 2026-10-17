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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.events.v1.Event;
import io.fabric8.kubernetes.api.model.events.v1.EventList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.Objects;

/**
 * {@link EventSink} writing to the {@code events.k8s.io/v1} API group of a cluster.
 * <p>
 * Recording therefore needs {@code create} and {@code patch} on {@code events} in the {@code events.k8s.io} API
 * group.
 */
public class KubernetesEventSink implements EventSink {

  private final KubernetesClient client;

  public KubernetesEventSink(KubernetesClient client) {
    this.client = Objects.requireNonNull(client, "client must not be null");
  }

  @Override
  public Event create(Event event) {
    return events(event).resource(event).create();
  }

  @Override
  public Event patch(Event event, String patch) {
    return events(event).withName(event.getMetadata().getName())
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE), patch);
  }

  private NonNamespaceOperation<Event, EventList, Resource<Event>> events(Event event) {
    final ObjectMeta metadata = event.getMetadata();
    final String namespace = metadata == null ? null : metadata.getNamespace();
    if (Utils.isNullOrEmpty(namespace)) {
      throw new KubernetesClientException("Cannot record an event with an empty namespace");
    }
    return client.events().v1().events().inNamespace(namespace);
  }
}
