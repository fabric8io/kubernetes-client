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
package io.fabric8.kubeapitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KubeAPIServerConfigBuilderTest {

  private static KubeAPIServerConfigBuilder builderWithEnv(Map<String, String> env) {
    return KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withEnvReader(env::get);
  }

  @Test
  @DisplayName("default startupTimeout is 120 seconds")
  void defaultStartupTimeoutIs120Seconds() {
    var config = builderWithEnv(Map.of()).build();

    assertThat(config.getStartupTimeout()).isEqualTo(120_000);
  }

  @Test
  @DisplayName("explicit startupTimeout via builder overrides default")
  void explicitStartupTimeoutOverridesDefault() {
    var config = builderWithEnv(Map.of())
        .withStartupTimeout(42_000)
        .build();

    assertThat(config.getStartupTimeout()).isEqualTo(42_000);
  }

  @Test
  @DisplayName("parseStrictBoolean parses 'true' correctly")
  void parseStrictBooleanTrue() {
    assertThat(KubeAPIServerConfigBuilder.parseStrictBoolean("true")).isTrue();
  }

  @Test
  @DisplayName("parseStrictBoolean parses 'false' correctly")
  void parseStrictBooleanFalse() {
    assertThat(KubeAPIServerConfigBuilder.parseStrictBoolean("false")).isFalse();
  }

  @Test
  @DisplayName("parseStrictBoolean parses case-insensitively")
  void parseStrictBooleanCaseInsensitive() {
    assertThat(KubeAPIServerConfigBuilder.parseStrictBoolean("TRUE")).isTrue();
    assertThat(KubeAPIServerConfigBuilder.parseStrictBoolean("True")).isTrue();
    assertThat(KubeAPIServerConfigBuilder.parseStrictBoolean("FALSE")).isFalse();
  }

  @Test
  @DisplayName("parseStrictBoolean rejects non-canonical values")
  void parseStrictBooleanRejectsNonCanonical() {
    assertThatThrownBy(() -> KubeAPIServerConfigBuilder.parseStrictBoolean("yes"))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> KubeAPIServerConfigBuilder.parseStrictBoolean("1"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("parseStrictBoolean rejects empty string")
  void parseStrictBooleanRejectsEmpty() {
    assertThatThrownBy(() -> KubeAPIServerConfigBuilder.parseStrictBoolean(""))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("build rejects non-positive startupTimeout from builder API")
  void buildRejectsNonPositiveStartupTimeout() {
    assertThatThrownBy(() -> builderWithEnv(Map.of())
        .withStartupTimeout(0)
        .build())
        .isInstanceOf(KubeAPITestException.class)
        .hasMessageContaining("positive");
  }

  @Test
  @DisplayName("build rejects negative startupTimeout from builder API")
  void buildRejectsNegativeStartupTimeout() {
    assertThatThrownBy(() -> builderWithEnv(Map.of())
        .withStartupTimeout(-500)
        .build())
        .isInstanceOf(KubeAPITestException.class)
        .hasMessageContaining("positive");
  }

  @Test
  @DisplayName("env var KUBE_API_TEST_STARTUP_TIMEOUT overrides default")
  void envVarStartupTimeoutOverridesDefault() {
    var config = builderWithEnv(Map.of(
        KubeAPIServerConfigBuilder.KUBE_API_TEST_STARTUP_TIMEOUT, "180000")).build();

    assertThat(config.getStartupTimeout()).isEqualTo(180_000);
  }

  @Test
  @DisplayName("env var KUBE_API_TEST_OFFLINE_MODE is parsed as boolean")
  void envVarOfflineModeOverridesDefault() {
    var config = builderWithEnv(Map.of(
        KubeAPIServerConfigBuilder.KUBE_API_TEST_OFFLINE_MODE, "true")).build();

    assertThat(config.isOfflineMode()).isTrue();
  }

  @Test
  @DisplayName("explicit builder value takes precedence over env var")
  void explicitValueTakesPrecedenceOverEnvVar() {
    var config = builderWithEnv(Map.of(
        KubeAPIServerConfigBuilder.KUBE_API_TEST_STARTUP_TIMEOUT, "999000"))
        .withStartupTimeout(42_000)
        .build();

    assertThat(config.getStartupTimeout()).isEqualTo(42_000);
  }

  @Test
  @DisplayName("invalid env var KUBE_API_TEST_STARTUP_TIMEOUT throws KubeAPITestException")
  void invalidEnvVarStartupTimeoutThrows() {
    assertThatThrownBy(() -> builderWithEnv(Map.of(
        KubeAPIServerConfigBuilder.KUBE_API_TEST_STARTUP_TIMEOUT, "not-a-number")).build())
        .isInstanceOf(KubeAPITestException.class)
        .hasMessageContaining("KUBE_API_TEST_STARTUP_TIMEOUT")
        .hasMessageContaining("not-a-number");
  }

  @Test
  @DisplayName("non-canonical env var KUBE_API_TEST_OFFLINE_MODE throws KubeAPITestException")
  void nonCanonicalEnvVarBooleanThrows() {
    assertThatThrownBy(() -> builderWithEnv(Map.of(
        KubeAPIServerConfigBuilder.KUBE_API_TEST_OFFLINE_MODE, "yes")).build())
        .isInstanceOf(KubeAPITestException.class)
        .hasMessageContaining("KUBE_API_TEST_OFFLINE_MODE")
        .hasMessageContaining("yes");
  }
}
