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
import io.fabric8.kubernetes.api.model.apps.DaemonSet;
import io.fabric8.kubernetes.api.model.apps.DaemonSetBuilder;
import io.fabric8.kubernetes.api.model.apps.DaemonSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@LoadKubernetesManifests("/daemonset-it.yml")
class DaemonSetIT {

  KubernetesClient client;

  @Test
  void get() {
    DaemonSet daemonSet = client.apps().daemonSets().withName("daemonset-get").get();
    assertThat(daemonSet).isNotNull();
  }

  @Test
  void list() {
    DaemonSetList aDaemonSetList = client.apps().daemonSets().list();
    assertNotNull(aDaemonSetList);
    assertTrue(aDaemonSetList.getItems().size() >= 1);
  }

  @Test
  void update() {
    DaemonSet daemonSet = client.apps().daemonSets().withName("daemonset-update").edit(c -> new DaemonSetBuilder(c)
        .editMetadata().withResourceVersion(null).endMetadata()
        .editSpec().editTemplate().editSpec().editContainer(0)
        .withImage("quay.io/fluentd_elasticsearch/fluentd:v3.0.0")
        .endContainer().endSpec().endTemplate().endSpec()
        .build());

    assertNotNull(daemonSet);
    assertEquals("quay.io/fluentd_elasticsearch/fluentd:v3.0.0",
        daemonSet.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
  }

  @Test
  void delete() {
    assertTrue(client.apps().daemonSets().withName("daemonset-delete").delete().size() == 1);
  }
}
