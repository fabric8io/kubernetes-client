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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(crud = true)
class KubernetesMockServerExtensionTests {

  KubernetesClient client;

  @Test
  void testExample() {
    Assertions.assertNotNull(client);
    Assertions.assertNull(client.getConfiguration().getOauthToken());
    Assertions.assertNull(client.getConfiguration().getCurrentContext());
    Assertions.assertTrue(client.getConfiguration().getContexts().isEmpty());
  }

  @Test
  @DisplayName("KubernetesMockServerExtension uses KubernetesMixedDispatcher and provides expectation for GET /version")
  void testGetKubernetesVersion() {
    // When
    final VersionInfo result = client.getKubernetesVersion();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("major", "0")
        .hasFieldOrPropertyWithValue("minor", "0");
  }
}
