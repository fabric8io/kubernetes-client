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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.util.Objects;

class MockServerKubeconfigTest {

  @BeforeEach
  void setKubeConfigProperty() {
    System.setProperty("kubeconfig", Objects.requireNonNull(getClass().getResource("/testkubeconfig")).getFile());
  }

  @Test
  void mockServerShouldNotPickTokenAndNameContextIfKubeConfigFound() {
    // Given
    KubernetesMockServer server = new KubernetesMockServer();

    // When
    KubernetesClient client = server.createClient();

    // Then
    Assertions.assertNotNull(client);
    Assertions.assertNull(client.getConfiguration().getOauthToken());
    Assertions.assertNull(client.getConfiguration().getCurrentContext());
    Assertions.assertTrue(client.getConfiguration().getContexts().isEmpty());
  }

  @AfterEach
  public void cleanup() {
    System.clearProperty("kubeconfig");
  }
}
