/**
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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.events.v1beta1.Event;
import io.fabric8.kubernetes.api.model.events.v1beta1.EventBuilder;
import io.fabric8.kubernetes.api.model.events.v1beta1.EventList;
import io.fabric8.kubernetes.api.model.events.v1beta1.EventListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class V1beta1EventsTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @Test
  void testList() {
    // Given
    server.expect().get().withPath("/apis/events.k8s.io/v1beta1/namespaces/default/events")
        .andReturn(HttpURLConnection.HTTP_OK, new EventListBuilder()
            .addToItems(new EventBuilder().withNewMetadata().withName("event1").endMetadata().build())
            .build())
        .once();

    // When
    EventList eventList = client.events().v1beta1().events().inNamespace("default").list();

    // Then
    assertThat(eventList).isNotNull();
    assertThat(eventList.getItems()).hasSize(1);
    assertThat(eventList.getItems().get(0)).hasFieldOrPropertyWithValue("metadata.name", "event1");
  }

  @Test
  void testGet() {
    // Given
    server.expect().get().withPath("/apis/events.k8s.io/v1beta1/namespaces/default/events/event1")
        .andReturn(HttpURLConnection.HTTP_OK, new EventBuilder()
            .withNewMetadata().withName("event1").endMetadata()
            .build())
        .once();

    // When
    Event e1 = client.events().v1beta1().events().inNamespace("default").withName("event1").get();

    // Then
    assertThat(e1)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "event1");
  }

  @Test
  void testDelete() {
    // Given
    server.expect().delete().withPath("/apis/events.k8s.io/v1beta1/namespaces/default/events/e1")
        .andReturn(HttpURLConnection.HTTP_OK, new StatusBuilder().withStatus("Success").build())
        .once();

    // When
    boolean isDeleted = client.events().v1beta1().events().inNamespace("default").withName("e1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }
}
