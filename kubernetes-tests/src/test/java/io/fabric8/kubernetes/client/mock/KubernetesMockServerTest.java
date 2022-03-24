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

import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class KubernetesMockServerTest {

  KubernetesClient client;
  KubernetesMockServer server;

  @Test
  void testReset() {
    client.configMaps().create(new ConfigMapBuilder().withNewMetadata().withName("x").endMetadata().build());
    VersionInfo info = client.getKubernetesVersion();
    assertEquals("0", info.getMajor());

    server.reset();

    info = client.getKubernetesVersion();
    assertEquals("0", info.getMajor());
    assertNull(client.configMaps().withName("x").get());
  }

  @Test
  void testOpenShiftSupport() {
    server.setUnsupported("openshift.io");
    assertFalse(client.isAdaptable(OpenShiftClient.class));
    assertFalse(client.adapt(OpenShiftClient.class).isSupported());
    assertFalse(client.supports(Route.class));
    assertTrue(client.supports(Pod.class));
    server.reset();
    assertTrue(client.adapt(OpenShiftClient.class).isSupported());
  }

}
