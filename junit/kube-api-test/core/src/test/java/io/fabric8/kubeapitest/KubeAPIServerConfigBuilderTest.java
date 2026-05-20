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

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KubeAPIServerConfigBuilderTest {

  // Default raised from 60s to 120s under #7834: the 2.6s idle startup of
  // kube-apiserver scales ~20× under -T 1C + forkCount=1C CI contention,
  // landing right on the 60s boundary. 120s gives a 2× buffer; the
  // KUBE_API_TEST_STARTUP_TIMEOUT env var still lets users tune it.
  @Test
  void defaultStartupTimeoutIs120Seconds() {
    var config = KubeAPIServerConfigBuilder.anAPIServerConfig().build();

    assertThat(config.getStartupTimeout()).isEqualTo(120_000);
  }

  @Test
  void explicitStartupTimeoutOverridesDefault() {
    var config = KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withStartupTimeout(42_000)
        .build();

    assertThat(config.getStartupTimeout()).isEqualTo(42_000);
  }
}
