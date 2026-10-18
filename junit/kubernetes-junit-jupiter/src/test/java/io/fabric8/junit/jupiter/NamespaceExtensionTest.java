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
package io.fabric8.junit.jupiter;

import io.fabric8.junit.jupiter.api.KubernetesTest;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class NamespaceExtensionTest {

  @Test
  @DisplayName("beforeAll fails with a message naming the kubernetesClientBuilderCustomizer if it has no no-arg constructor")
  void invalidKubernetesClientBuilderCustomizer() {
    final ExtensionContext context = mock(ExtensionContext.class, CALLS_REAL_METHODS);
    doReturn(Optional.of(InvalidCustomizerKubernetesTest.class)).when(context).getTestClass();
    final NamespaceExtension extension = new NamespaceExtension();
    assertThatThrownBy(() -> extension.beforeAll(context))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(NoNoArgConstructorCustomizer.class.getName())
        .hasMessageContaining("no-arg constructor");
  }

  @KubernetesTest(createEphemeralNamespace = false, kubernetesClientBuilderCustomizer = NoNoArgConstructorCustomizer.class)
  static final class InvalidCustomizerKubernetesTest {
  }

  static final class NoNoArgConstructorCustomizer implements Consumer<KubernetesClientBuilder> {

    NoNoArgConstructorCustomizer(String unused) {
    }

    @Override
    public void accept(KubernetesClientBuilder kubernetesClientBuilder) {
      // NO-OP
    }
  }
}
