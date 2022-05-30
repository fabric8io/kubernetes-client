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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JettyHttpClientFactoryTest {

  @Test
  @DisplayName("createHttpClient instantiates a JettyHttpClient")
  void createHttpClientInstantiatesJettyHttpClient() {
    // When
    try (var result = new JettyHttpClientFactory().createHttpClient(Config.empty())) {
      // Then
      assertThat(result).isNotNull().isInstanceOf(JettyHttpClient.class);
    }
  }

  @Test
  @DisplayName("newBuilder instantiates a JettyHttpClientBuilder")
  void newBuilderInstantiatesJettyHttpClientBuilder() {
    // When
    final var result = new JettyHttpClientFactory().newBuilder();
    // Then
    assertThat(result).isNotNull().isInstanceOf(JettyHttpClientBuilder.class);
  }
}
