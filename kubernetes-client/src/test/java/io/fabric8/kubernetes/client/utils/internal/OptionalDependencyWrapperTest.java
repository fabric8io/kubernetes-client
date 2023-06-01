/**
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
package io.fabric8.kubernetes.client.utils.internal;

import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.jupiter.api.Test;

import static io.fabric8.kubernetes.client.utils.internal.OptionalDependencyWrapper.wrapRunWithOptionalDependency;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalDependencyWrapperTest {

  @Test
  void testWrapRunWithOptionalDependencyHasAllDependenciesShouldNotThrowException() {
    final boolean result = wrapRunWithOptionalDependency(() -> true,
        "I have no optional dependencies");

    assertThat(result).isEqualTo(true);
  }

  @Test
  void testWrapRunWithOptionalDependencyUsesDependencyShouldThrowException() {
    final KubernetesClientException exception = assertThrows(KubernetesClientException.class,
        () -> wrapRunWithOptionalDependency(() -> {
          throw new NoClassDefFoundError("com.1337.invalid.IDontExist");
        }, "IDontExist class is provided by some optional package"));

    assertThat(exception.getMessage()).isEqualTo(
        "IDontExist class is provided by some optional package, an optional dependency. To use this functionality you must explicitly add this dependency to the classpath.");
  }
}
