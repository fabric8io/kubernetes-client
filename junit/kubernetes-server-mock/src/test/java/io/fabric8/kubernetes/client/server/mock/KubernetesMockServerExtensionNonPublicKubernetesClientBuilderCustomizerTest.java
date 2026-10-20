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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, kubernetesClientBuilderCustomizer = KubernetesMockServerExtensionNonPublicKubernetesClientBuilderCustomizerTest.PrivateConstructorCustomizer.class)
class KubernetesMockServerExtensionNonPublicKubernetesClientBuilderCustomizerTest {

  KubernetesClient client;

  @Test
  @DisplayName("kubernetesClientBuilderCustomizer can be a non-public class with a non-public no-arg constructor")
  void kubernetesClient() {
    assertThat(client.getConfiguration())
        .returns(1337, Config::getRequestTimeout);
  }

  static final class PrivateConstructorCustomizer implements Consumer<KubernetesClientBuilder> {

    private PrivateConstructorCustomizer() {
    }

    @Override
    public void accept(KubernetesClientBuilder kubernetesClientBuilder) {
      kubernetesClientBuilder.editOrNewConfig().withRequestTimeout(1337).endConfig();
    }
  }
}
