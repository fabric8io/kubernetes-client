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
package io.fabric8.istio.api.networking.v1beta1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ProxyConfigTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new ProxyConfig().getApiVersion()).isEqualTo("networking.istio.io/v1beta1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new ProxyConfig().getPlural()).isEqualTo("proxyconfigs");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new ProxyConfig().getKind()).isEqualTo("ProxyConfig");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(ProxyConfig.class.getInterfaces()).contains(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/proxyconfig-valid.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ProxyConfig proxyConfig = mapper.readValue(originalJson, ProxyConfig.class);
    final String serializedJson = mapper.writeValueAsString(proxyConfig);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(proxyConfig)
        .hasFieldOrPropertyWithValue("metadata.name", "per-workload-proxyconfig")
        .hasFieldOrPropertyWithValue("spec.selector.matchLabels", Collections.singletonMap("app", "ratings"))
        .hasFieldOrPropertyWithValue("spec.concurrency", 0)
        .hasFieldOrPropertyWithValue("spec.image.imageType", "debug");
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    ProxyConfigBuilder proxyConfigBuilder = new ProxyConfigBuilder()
        .withNewMetadata()
        .withName("per-workload-proxyconfig")
        .endMetadata()
        .withNewSpec()
        .withNewSelector()
        .addToMatchLabels(Collections.singletonMap("app", "ratings"))
        .endTypeSelector()
        .withNewImage().withImageType("debug").endImage()
        .withConcurrency(0)
        .endSpec();
    // When
    ProxyConfig proxyConfig = proxyConfigBuilder.build();

    // Then
    assertThat(proxyConfig)
        .hasFieldOrPropertyWithValue("metadata.name", "per-workload-proxyconfig")
        .hasFieldOrPropertyWithValue("spec.selector.matchLabels", Collections.singletonMap("app", "ratings"))
        .hasFieldOrPropertyWithValue("spec.concurrency", 0)
        .hasFieldOrPropertyWithValue("spec.image.imageType", "debug");
  }
}
