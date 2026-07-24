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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KubeAPIServerConfigBuilderTest {

  @Test
  @DisplayName("default startupTimeout is 120 seconds")
  void defaultStartupTimeoutIs120Seconds() {
    var config = KubeAPIServerConfigBuilder.anAPIServerConfig().build();

    assertThat(config.getStartupTimeout()).isEqualTo(120_000);
  }

  @Test
  @DisplayName("explicit startupTimeout via builder overrides default")
  void explicitStartupTimeoutOverridesDefault() {
    var config = KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withStartupTimeout(42_000)
        .build();

    assertThat(config.getStartupTimeout()).isEqualTo(42_000);
  }

  @Test
  @DisplayName("parseEnvValue parses integer strings correctly")
  void parseEnvValueInteger() {
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Integer.class, "180000"))
        .isEqualTo(180_000);
  }

  @Test
  @DisplayName("parseEnvValue parses boolean 'true' correctly")
  void parseEnvValueBooleanTrue() {
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Boolean.class, "true"))
        .isTrue();
  }

  @Test
  @DisplayName("parseEnvValue parses boolean 'false' correctly")
  void parseEnvValueBooleanFalse() {
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Boolean.class, "false"))
        .isFalse();
  }

  @Test
  @DisplayName("parseEnvValue returns string values unchanged")
  void parseEnvValueString() {
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(String.class, "some-value"))
        .isEqualTo("some-value");
  }

  @Test
  @DisplayName("parseEnvValue throws NumberFormatException for non-numeric integer input")
  void parseEnvValueInvalidInteger() {
    assertThatThrownBy(() -> KubeAPIServerConfigBuilder.parseEnvValue(Integer.class, "not-a-number"))
        .isInstanceOf(NumberFormatException.class);
  }

  @Test
  @DisplayName("parseEnvValue parses boolean case-insensitively")
  void parseEnvValueBooleanCaseInsensitive() {
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Boolean.class, "TRUE"))
        .isTrue();
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Boolean.class, "True"))
        .isTrue();
  }

  @Test
  @DisplayName("parseEnvValue throws NumberFormatException for empty integer string")
  void parseEnvValueEmptyInteger() {
    assertThatThrownBy(() -> KubeAPIServerConfigBuilder.parseEnvValue(Integer.class, ""))
        .isInstanceOf(NumberFormatException.class);
  }

  @Test
  @DisplayName("parseEnvValue treats non-canonical boolean values as false")
  void parseEnvValueNonCanonicalBoolean() {
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Boolean.class, "yes"))
        .isFalse();
    assertThat(KubeAPIServerConfigBuilder.parseEnvValue(Boolean.class, "1"))
        .isFalse();
  }

  @Test
  @DisplayName("parseEnvValue throws for unsupported types")
  void parseEnvValueUnsupportedType() {
    assertThatThrownBy(() -> KubeAPIServerConfigBuilder.parseEnvValue(Long.class, "42"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Unsupported type");
  }
}
