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
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

    assertNotNull("Handlers did not return a valid list of resources", load);

    try {
      List<HasMetadata> hasMetadata = load.get();

      assertNotNull("Handlers did not return a valid resource", hasMetadata);
      Assert.assertTrue("Handler did not return expected single resource", 1 == hasMetadata.size());
      assertEquals("hasMetadata found did not match the expected name of the test input", "viewer", hasMetadata.get(0).getMetadata().getName());
    } catch (NullPointerException e) {
      fail("No handler found for specified resource");
    }
  }
}
