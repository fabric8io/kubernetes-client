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
package io.fabric8.kubernetes;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DisableAutoConfigurationIT {
  KubernetesClient client;

  @Test
  @DisplayName("with autoConfigure=false, then client should not load kubeconfig contents")
  void givenConfigWithAutoConfigureDisabled_shouldNotLoadLocalKubeConfig() {
    // Given + When
    client = new KubernetesClientBuilder().withConfig(new ConfigBuilder()
        .withAutoConfigure(false)
        .withRequestRetryBackoffLimit(0)
        .build()).build();

    // Then
    assertThat(client.getConfiguration())
        .hasFieldOrPropertyWithValue("namespace", null)
        .hasFieldOrPropertyWithValue("masterUrl", "https://kubernetes.default.svc/")
        .hasFieldOrPropertyWithValue("contexts", Collections.emptyList())
        .hasFieldOrPropertyWithValue("currentContext", null)
        .hasFieldOrPropertyWithValue("username", null)
        .hasFieldOrPropertyWithValue("clientCertFile", null)
        .hasFieldOrPropertyWithValue("clientKeyFile", null)
        .hasFieldOrPropertyWithValue("clientCertData", null)
        .hasFieldOrPropertyWithValue("caCertFile", null)
        .hasFieldOrPropertyWithValue("caCertData", null);
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(() -> client.pods().list())
        .withMessageContaining("Operation: [list]  for kind: [Pod]  with name: [null]  in namespace: [null]  failed.");
  }

  @Test
  @DisplayName("kubernetes.disable.autoConfig=true, then client should not load kubeconfig contents")
  void givenDisableAutoConfigPropertyTrue_shouldNotLoadLocalKubeConfig() {
    try {
      // Given
      System.setProperty(Config.KUBERNETES_DISABLE_AUTO_CONFIG_SYSTEM_PROPERTY, "true");
      client = new KubernetesClientBuilder().withConfig(new ConfigBuilder()
          .withRequestRetryBackoffLimit(0)
          .build()).build();

      // When + Then
      assertThat(client.getConfiguration())
          .hasFieldOrPropertyWithValue("namespace", null)
          .hasFieldOrPropertyWithValue("masterUrl", "https://kubernetes.default.svc/")
          .hasFieldOrPropertyWithValue("contexts", Collections.emptyList())
          .hasFieldOrPropertyWithValue("currentContext", null)
          .hasFieldOrPropertyWithValue("username", null)
          .hasFieldOrPropertyWithValue("clientCertFile", null)
          .hasFieldOrPropertyWithValue("clientKeyFile", null)
          .hasFieldOrPropertyWithValue("clientCertData", null)
          .hasFieldOrPropertyWithValue("caCertFile", null)
          .hasFieldOrPropertyWithValue("caCertData", null);
      assertThatExceptionOfType(KubernetesClientException.class)
          .isThrownBy(() -> client.pods().list())
          .withMessageContaining("Operation: [list]  for kind: [Pod]  with name: [null]  in namespace: [null]  failed.");
    } finally {
      System.clearProperty(Config.KUBERNETES_DISABLE_AUTO_CONFIG_SYSTEM_PROPERTY);
    }
  }
}
