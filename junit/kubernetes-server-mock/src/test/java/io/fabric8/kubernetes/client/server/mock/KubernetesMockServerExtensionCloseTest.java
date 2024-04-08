/*
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
import io.fabric8.kubernetes.client.impl.KubernetesClientImpl;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServerExtensionCloseTest.PreDestroyResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PreDestroyResource.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableKubernetesMockClient
class KubernetesMockServerExtensionCloseTest {
  static KubernetesMockServer staticMockServer;
  static KubernetesClient staticClient;

  KubernetesMockServer mockServer;
  KubernetesClient client;

  @Test
  void shouldNotNull() {
    Assertions.assertNotNull(mockServer);
    Assertions.assertNotNull(client);
    Assertions.assertNotNull(staticMockServer);
    Assertions.assertNotNull(staticClient);
  }

  static class PreDestroyResource implements TestInstancePreDestroyCallback {

    @Override
    public void preDestroyTestInstance(ExtensionContext context) throws Exception {
      final KubernetesMockServerExtensionCloseTest test = context.getTestInstances().get()
          .findInstance(KubernetesMockServerExtensionCloseTest.class).get();
      final KubernetesClientImpl staticClient0 = (KubernetesClientImpl) staticClient;
      final KubernetesClientImpl client0 = (KubernetesClientImpl) test.client;
      // Should close both static and non-static clients.
      assertThat(staticClient0.getClosed()).isCompleted();
      assertThat(client0.getClosed()).isCompleted();
    }
  }
}
