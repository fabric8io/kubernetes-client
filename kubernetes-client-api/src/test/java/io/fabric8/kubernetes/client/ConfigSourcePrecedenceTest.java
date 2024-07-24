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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConfigSourcePrecedenceTest {
  @Nested
  @DisplayName("With provided kubeconfig property")
  class KubeConfigSource {
    @BeforeEach
    void setUp() {
      System.setProperty("kubeconfig",
          Utils.filePath(ConfigSourcePrecedenceTest.class.getResource("/config-source-precedence/kube-config")));
    }

    @Test
    @DisplayName("then use kubeconfig attributes in Config")
    void whenNoOtherSourceProvided_thenUseKubeConfig() {
      // Given
      Config config = new ConfigBuilder().build();

      // When + Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
          .hasFieldOrPropertyWithValue("namespace", "namespace-from-kubeconfig")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token-from-kubeconfig");
    }

    @Test
    @DisplayName("And User configuration via builder, then User Configuration via builder takes precedence")
    void whenUserConfigurationOverridesSomeFields_thenUserConfigurationGivenPrecedence() {
      // Given
      Config config = new ConfigBuilder()
          .withMasterUrl("https://user-configuration-override:8443")
          .withNamespace("namespace-from-user")
          .build();

      // When + Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://user-configuration-override:8443/")
          .hasFieldOrPropertyWithValue("namespace", "namespace-from-user")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token-from-kubeconfig");
    }

    @Test
    @DisplayName("And System Properties configured, then System Properties take precedence")
    void whenSystemPropertiesUsedForSomeFields_thenSystemPropertiesGivenPrecedence() {
      try {
        // Given
        System.setProperty("kubernetes.master", "https://user-configuration-override:8443");
        System.setProperty("kubernetes.auth.token", "token-overridden");

        // When
        Config config = new ConfigBuilder().build();

        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("masterUrl", "https://user-configuration-override:8443/")
            .hasFieldOrPropertyWithValue("namespace", "namespace-from-kubeconfig")
            .hasFieldOrPropertyWithValue("autoOAuthToken", "token-overridden");
      } finally {
        System.clearProperty("kubernetes.master");
        System.clearProperty("kubernetes.namespace");
        System.clearProperty("kubernetes.auth.token");
      }
    }

    @Test
    @DisplayName("And Service Account mounted, then kubeconfig takes precedence")
    void whenServiceAccountPropertyConfigured_thenDoNotUseServiceAccount() {
      try {
        // Given
        System.setProperty("kubernetes.auth.serviceAccount.token",
            Utils.filePath(ConfigSourcePrecedenceTest.class.getResource("/config-source-precedence/serviceaccount/token")));
        System.setProperty("kubenamespace",
            Utils.filePath(ConfigSourcePrecedenceTest.class.getResource("/config-source-precedence/serviceaccount/namespace")));
        Config config = new ConfigBuilder().build();

        // When + Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("namespace", "namespace-from-kubeconfig")
            .hasFieldOrPropertyWithValue("autoOAuthToken", "token-from-kubeconfig");
      } finally {
        System.clearProperty("kubernetes.auth.serviceAccount.token");
        System.clearProperty("kubenamespace");
      }
    }
  }

  @Nested
  @DisplayName("With ServiceAccount mounted")
  class InsideKubernetesCluster {
    @BeforeEach
    void setUp() {
      System.setProperty("kubeconfig", "/dev/null");
      System.setProperty("kubernetes.auth.serviceAccount.token",
          Utils.filePath(ConfigSourcePrecedenceTest.class.getResource("/config-source-precedence/serviceaccount/token")));
      System.setProperty("kubenamespace",
          Utils.filePath(ConfigSourcePrecedenceTest.class.getResource("/config-source-precedence/serviceaccount/namespace")));
    }

    @Test
    @DisplayName("then use ServiceAccount attributes in Config")
    void whenNoOtherSourceProvided_thenUseServiceAccount() {
      // Given
      Config config = new ConfigBuilder().build();

      // When + Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("namespace", "namespace-from-mounted-serviceaccount")
          .extracting(Config::getAutoOAuthToken)
          .asString()
          .contains("token-from-mounted-serviceaccount");
    }

    @Test
    @DisplayName("And User configuration via builder, then User Configuration takes precedence")
    void whenUserConfigurationOverridesSomeFields_thenUserConfigurationGivenPrecedence() {
      // Given
      Config config = new ConfigBuilder()
          .withMasterUrl("https://user-configuration-override:8443")
          .withNamespace("namespace-from-user")
          .build();

      // When + Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://user-configuration-override:8443/")
          .hasFieldOrPropertyWithValue("namespace", "namespace-from-user")
          .extracting(Config::getAutoOAuthToken)
          .asString()
          .contains("token-from-mounted-serviceaccount");
    }

    @Test
    @DisplayName("And System Properties configured, then System Properties takes precedence")
    void whenSystemPropertiesUsedForSomeFields_thenSystemPropertiesGivenPrecedence() {
      try {
        System.setProperty("kubernetes.master", "https://properties-configuration-override:8443");
        System.setProperty("kubernetes.auth.token", "token-from-properties");
        Config config = new ConfigBuilder().build();

        // When + Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("masterUrl", "https://properties-configuration-override:8443/")
            .hasFieldOrPropertyWithValue("autoOAuthToken", "token-from-properties")
            .hasFieldOrPropertyWithValue("namespace", "namespace-from-mounted-serviceaccount");
      } finally {
        System.clearProperty("kubernetes.master");
        System.clearProperty("kubernetes.namespace");
        System.clearProperty("kubernetes.auth.token");
      }
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubernetes.auth.serviceAccount.token");
      System.clearProperty("kubenamespace");
      System.clearProperty("kubeconfig");
    }
  }

  @Nested
  @DisplayName("With Provided System Properties")
  class SystemPropertiesSource {
    @BeforeEach
    void setUp() {
      System.setProperty("kubernetes.master", "https://property-configuration-override:8443");
      System.setProperty("kubernetes.namespace", "namespace-set-via-properties");
      System.setProperty("kubernetes.auth.token", "token-set-via-properties");
    }

    @Test
    @DisplayName("then read from System properties")
    void whenNoOtherSourceProvided_thenUseSystemProperties() {
      assertThat(new ConfigBuilder().build())
          .hasFieldOrPropertyWithValue("masterUrl", "https://property-configuration-override:8443/")
          .hasFieldOrPropertyWithValue("namespace", "namespace-set-via-properties")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token-set-via-properties");
    }

    @Test
    @DisplayName("And User configuration via builder, then User Configuration via builder takes precedence")
    void whenUserConfigurationOverridesSomeFields_thenUserConfigurationGivenPrecedence() {
      // Given
      Config config = new ConfigBuilder()
          .withMasterUrl("https://user-configuration-override:8443")
          .withNamespace("namespace-overridden-by-user")
          .build();

      // When + Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://user-configuration-override:8443/")
          .hasFieldOrPropertyWithValue("namespace", "namespace-overridden-by-user")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token-set-via-properties");
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubernetes.master");
      System.clearProperty("kubernetes.namespace");
      System.clearProperty("kubernetes.auth.token");
    }
  }
}
