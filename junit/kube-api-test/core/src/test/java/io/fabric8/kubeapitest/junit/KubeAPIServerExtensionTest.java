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
package io.fabric8.kubeapitest.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KubeAPIServerExtensionTest {

  @EnableKubeAPIServer(startupTimeout = 180_000)
  private static class WithCustomTimeout {
  }

  @EnableKubeAPIServer
  private static class WithDefaults {
  }

  @Test
  @DisplayName("annotationToConfig sets startupTimeout when annotation specifies a positive value")
  void startupTimeoutFromAnnotation() {
    var annotation = WithCustomTimeout.class.getAnnotation(EnableKubeAPIServer.class);
    var extension = new KubeAPIServerExtension();
    var config = extension.annotationToConfig(annotation);

    assertThat(config.getStartupTimeout()).isEqualTo(180_000);
  }

  @Test
  @DisplayName("annotationToConfig uses builder default when annotation startupTimeout is not set")
  void defaultStartupTimeoutFromAnnotation() {
    var annotation = WithDefaults.class.getAnnotation(EnableKubeAPIServer.class);
    var extension = new KubeAPIServerExtension();
    var config = extension.annotationToConfig(annotation);

    assertThat(config.getStartupTimeout()).isEqualTo(120_000);
  }
}
