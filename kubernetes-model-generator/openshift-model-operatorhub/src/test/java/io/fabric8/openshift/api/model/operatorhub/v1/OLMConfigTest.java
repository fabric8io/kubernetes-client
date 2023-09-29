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
package io.fabric8.openshift.api.model.operatorhub.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class OLMConfigTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(OLMConfig.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/test-olmconfig.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final OLMConfig olmConfig = mapper.readValue(originalJson, OLMConfig.class);
    final String serializedJson = mapper.writeValueAsString(olmConfig);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(olmConfig)
        .hasFieldOrPropertyWithValue("metadata.name", "cluster")
        .extracting(OLMConfig::getSpec)
        .hasFieldOrPropertyWithValue("features.disableCopiedCSVs", true);
  }

  @Test
  void builder() {
    // Given
    OLMConfigBuilder olmConfigBuilder = new OLMConfigBuilder()
        .withNewMetadata()
        .withName("cluster")
        .endMetadata()
        .withNewSpec()
        .withNewFeatures()
        .withDisableCopiedCSVs(true)
        .endFeatures()
        .endSpec();

    // When
    OLMConfig olmConfig = olmConfigBuilder.build();

    // Then
    assertThat(olmConfig)
        .hasFieldOrPropertyWithValue("metadata.name", "cluster")
        .extracting(OLMConfig::getSpec)
        .hasFieldOrPropertyWithValue("features.disableCopiedCSVs", true);
  }
}
