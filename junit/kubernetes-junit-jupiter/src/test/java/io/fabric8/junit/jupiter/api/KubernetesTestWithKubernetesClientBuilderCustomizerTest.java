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
package io.fabric8.junit.jupiter.api;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@KubernetesTest(createEphemeralNamespace = false, kubernetesClientBuilderCustomizer = KubernetesTestWithKubernetesClientBuilderCustomizerTest.CustomConfig.class)
class KubernetesTestWithKubernetesClientBuilderCustomizerTest {

  private static KubernetesClient staticKubernetesClient;
  private KubernetesClient kubernetesClient;

  @Test
  @DisplayName("static KubernetesClient is built from the KubernetesClientBuilder customized by kubernetesClientBuilderCustomizer")
  void staticKubernetesClient() {
    assertThat(staticKubernetesClient.getConfiguration())
        .returns("https://customized.example.com:6443/", Config::getMasterUrl)
        .returns(1337, Config::getRequestTimeout);
  }

  @Test
  @DisplayName("KubernetesClient is built from the KubernetesClientBuilder customized by kubernetesClientBuilderCustomizer")
  void kubernetesClient() {
    assertThat(kubernetesClient.getConfiguration())
        .returns("https://customized.example.com:6443/", Config::getMasterUrl)
        .returns(1337, Config::getRequestTimeout);
  }

  @Nested
  class NestedTest {

    @Test
    @DisplayName("nested test classes use the kubernetesClientBuilderCustomizer of the enclosing @KubernetesTest")
    void kubernetesClient() {
      assertThat(kubernetesClient.getConfiguration())
          .returns("https://customized.example.com:6443/", Config::getMasterUrl)
          .returns(1337, Config::getRequestTimeout);
    }
  }

  public static final class CustomConfig implements Consumer<KubernetesClientBuilder> {

    @Override
    public void accept(KubernetesClientBuilder kubernetesClientBuilder) {
      kubernetesClientBuilder.editOrNewConfig()
          .withAutoConfigure(false)
          .withMasterUrl("https://customized.example.com:6443")
          .withRequestTimeout(1337)
          .endConfig();
    }
  }
}
