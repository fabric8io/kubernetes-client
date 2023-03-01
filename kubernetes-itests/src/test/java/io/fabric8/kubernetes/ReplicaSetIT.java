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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/replicaset-it.yml")
class ReplicaSetIT {

  KubernetesClient client;

  @Test
  void load() {
    ReplicaSet replicaSet = client.apps().replicaSets()
        .load(getClass().getResourceAsStream("/test-replicaset.yml")).item();
    assertThat(replicaSet).isNotNull();
    assertEquals("frontend", replicaSet.getMetadata().getName());
  }

  @Test
  void get() {
    ReplicaSet replicaset1 = client.apps().replicaSets().withName("replicaset-get").get();
    assertNotNull(replicaset1);
  }

  @Test
  void list() {
    ReplicaSetList replicaSetList = client.apps().replicaSets().list();
    assertThat(replicaSetList).isNotNull();
    assertTrue(replicaSetList.getItems().size() >= 1);
  }

  @Test
  void update() {
    client.apps().replicaSets().withName("replicaset-update")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    ReplicaSet replicaset1 = client.apps().replicaSets().withName("replicaset-update").edit(r -> new ReplicaSetBuilder(r)
        .editMetadata().withResourceVersion(null).endMetadata()
        .editSpec().withReplicas(2).endSpec().build());
    assertThat(replicaset1).isNotNull();
    assertEquals(2, replicaset1.getSpec().getReplicas().intValue());
  }

  @Test
  void delete() {
    client.apps().replicaSets().withName("replicaset-delete")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.apps().replicaSets().withName("replicaset-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

}
