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

package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReplicationControllerIT {

  static KubernetesClient client;

  Namespace namespace;

  @BeforeAll
  public static void init() {
    client.load(ReplicationControllerIT.class.getResourceAsStream("/replicationcontroller-it.yml")).create();
  }

  @AfterAll
  public static void cleanup() {
    client.load(ReplicationControllerIT.class.getResourceAsStream("/replicationcontroller-it.yml")).withGracePeriod(0L).delete();
  }

  @Test
  void load() {
    ReplicationController aReplicationController = client.replicationControllers().inNamespace(namespace.getMetadata().getName())
      .load(getClass().getResourceAsStream("/test-replicationcontroller.yml")).get();

    assertThat(aReplicationController).isNotNull();
    assertEquals("nginx", aReplicationController.getMetadata().getName());
    assertEquals(3, (int) aReplicationController.getSpec().getReplicas());
  }

  @Test
  void get() {
    ReplicationController rc1 = client.replicationControllers().inNamespace(namespace.getMetadata().getName()).withName("rc-get").get();
    assertNotNull(rc1);
  }

  @Test
  void list() {
    ReplicationControllerList aRcList = client.replicationControllers().inNamespace(namespace.getMetadata().getName()).list();
    assertThat(aRcList).isNotNull();
    assertTrue(aRcList.getItems().size() >= 1);
  }

  @Test
  void update() {
    ReplicationController rc1 = client.replicationControllers().inNamespace(namespace.getMetadata().getName()).withName("rc-update").scale(5);
    assertEquals(5, rc1.getSpec().getReplicas().intValue());
  }

  @Test
  void delete() {
    assertTrue(client.replicationControllers().inNamespace(namespace.getMetadata().getName()).withName("rc-delete").delete());
  }

}
