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
}
