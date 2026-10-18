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
package io.fabric8.volcano.test.crud;

import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.volcano.api.model.scheduling.v1beta1.NamespaceQueue;
import io.fabric8.volcano.api.model.scheduling.v1beta1.NamespaceQueueBuilder;
import io.fabric8.volcano.client.VolcanoClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class NamespaceQueueTest {
  VolcanoClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("create sends the NamespaceQueue to the namespaced namespacequeues endpoint")
  void create() throws InterruptedException {
    NamespaceQueue created = client.namespaceQueues().inNamespace("team-a").resource(newNamespaceQueue("batch")).create();

    assertThat(created).hasFieldOrPropertyWithValue("metadata.name", "batch");
    assertThat(server.getLastRequest().getPath())
        .isEqualTo("/apis/scheduling.volcano.sh/v1beta1/namespaces/team-a/namespacequeues");
  }

  @Test
  @DisplayName("get through v1beta1() returns the NamespaceQueue with its parent, capability and dequeue strategy")
  void get() {
    client.namespaceQueues().inNamespace("team-a").resource(newNamespaceQueue("test-get")).create();

    NamespaceQueue namespaceQueue = client.v1beta1().namespaceQueues().inNamespace("team-a").withName("test-get").get();

    assertThat(namespaceQueue.getSpec())
        .hasFieldOrPropertyWithValue("parent", "cluster/default")
        .hasFieldOrPropertyWithValue("priority", 1)
        .hasFieldOrPropertyWithValue("dequeueStrategy", "fifo");
    assertThat(namespaceQueue.getSpec().getCapability()).containsEntry("cpu", new Quantity("2"));
  }

  @Test
  @DisplayName("list only returns the NamespaceQueues of the requested namespace")
  void list() {
    client.namespaceQueues().inNamespace("team-a").resource(newNamespaceQueue("in-team-a")).create();
    client.namespaceQueues().inNamespace("team-b").resource(newNamespaceQueue("in-team-b")).create();

    assertThat(client.namespaceQueues().inNamespace("team-a").list().getItems())
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "in-team-a");
  }

  @Test
  @DisplayName("delete removes the NamespaceQueue")
  void delete() {
    client.namespaceQueues().inNamespace("team-a").resource(newNamespaceQueue("test-delete")).create();

    assertThat(client.namespaceQueues().inNamespace("team-a").withName("test-delete").delete()).hasSize(1);
    assertThat(client.namespaceQueues().inNamespace("team-a").withName("test-delete").get()).isNull();
  }

  private static NamespaceQueue newNamespaceQueue(String name) {
    return new NamespaceQueueBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withParent("cluster/default")
        .addToCapability("cpu", new Quantity("2"))
        .withPriority(1)
        .withDequeueStrategy("fifo")
        .endSpec()
        .build();
  }
}
