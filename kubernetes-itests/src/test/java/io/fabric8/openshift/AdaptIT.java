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
package io.fabric8.openshift;

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class AdaptIT {
  @Test
  public void testAdaptToOpenShift() throws IOException {
    // Given
    String clusterUrl = ClusterEntity.getClusterUrl();
    Config config = getConfig(clusterUrl, "developer", "developer");
    KubernetesClient kubernetesClient = new DefaultKubernetesClient(config);

    // When + Then
    assertNotNull(kubernetesClient.adapt(OpenShiftClient.class));
  }

  @Test
  public void testIsAdaptable() throws IOException {
    // Given
    String clusterUrl = ClusterEntity.getClusterUrl();
    Config config = getConfig(clusterUrl, "developer", "developer");
    KubernetesClient kubernetesClient = new DefaultKubernetesClient(config);

    // When + Then
    assertTrue(kubernetesClient.isAdaptable(OpenShiftClient.class));
  }

  private Config getConfig(String clusterUrl, String username, String password) {
    return new ConfigBuilder()
      .withMasterUrl(clusterUrl)
      .withUsername(username)
      .withPassword(password)
      .build();
  }
}
