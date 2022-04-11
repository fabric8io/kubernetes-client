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

import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatefulSetIT {

  static KubernetesClient client;

  Namespace namespace;

  @BeforeAll
  public static void init() {
    client.load(StatefulSetIT.class.getResourceAsStream("/statefulset-it.yml")).create();
  }

  @AfterAll
  public static void cleanup() {
    client.load(StatefulSetIT.class.getResourceAsStream("/statefulset-it.yml")).withGracePeriod(0L).delete();
  }

  @Test
  void load() {
    StatefulSet aStatefulSet = client.apps().statefulSets()
      .load(getClass().getResourceAsStream("/test-statefulset.yml")).get();
    assertThat(aStatefulSet).isNotNull();
    assertEquals("web", aStatefulSet.getMetadata().getName());
  }

  @Test
  void get() {
    StatefulSet ss1 = client.apps().statefulSets().withName("ss-get").get();
    assertNotNull(ss1);
  }

  @Test
  void list() {
    StatefulSetList statefulSetList = client.apps().statefulSets().list();
    assertThat(statefulSetList).isNotNull();
    assertTrue(statefulSetList.getItems().size() >= 1);
  }

  @Test
  void update() {
    ReadyEntity<StatefulSet> statefulSetReady = new ReadyEntity<>(StatefulSet.class, client, "ss-update", namespace.getMetadata().getName());
    StatefulSet ss1 = client.apps().statefulSets().withName("ss-update").scale(5);
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetReady);
    assertEquals(5, ss1.getSpec().getReplicas().intValue());
  }

  @Test
  void delete() {
    ReadyEntity<StatefulSet> statefulSetReady = new ReadyEntity<>(StatefulSet.class, client, "ss-delete", namespace.getMetadata().getName());
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetReady);
    boolean bDeleted = client.apps().statefulSets().withName("ss-delete ").delete();
    assertTrue(bDeleted);
  }

}
