/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class ClusterRoleTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testLoadFromFile() {
    KubernetesClient client = server.getClient();
    ClusterRole kubernetesClusterRole = client.rbac().clusterRoles().load(getClass().getResourceAsStream("/test-clusterrole.yml")).get();

    assertNotNull(kubernetesClusterRole);
  }

  @Test
  public void testHandlersLoadFromFile() {
    KubernetesClient client = server.getClient();

    ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> load = client.load(getClass().getResourceAsStream("/test-clusterrole.yml"));

    assertNotNull(load);

    try {
      List<HasMetadata> hasMetadata = load.get();

      assertNotNull(hasMetadata);
      assertEquals(hasMetadata.size(), 1);
      assertEquals(hasMetadata.get(0).getMetadata().getName(), "viewer");
    } catch (NullPointerException e) {
      fail("No handler found for specified resource");
    }
  }
}
