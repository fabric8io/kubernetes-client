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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class ClusterRoleTest {

  KubernetesClient client;

  @Test
  void testLoadFromFile() {
    ClusterRole kubernetesClusterRole = client.rbac().clusterRoles()
        .load(getClass().getResourceAsStream("/test-clusterrole.yml")).item();

    assertNotNull(kubernetesClusterRole);
  }

  @Test
  void testHandlersLoadFromFile() {

    NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load = client
        .load(getClass().getResourceAsStream("/test-clusterrole.yml"));

    assertNotNull(load);

    List<HasMetadata> hasMetadata = load.items();

    assertNotNull(hasMetadata);
    assertEquals(1, hasMetadata.size());
    assertEquals("viewer", hasMetadata.get(0).getMetadata().getName());
  }
}
