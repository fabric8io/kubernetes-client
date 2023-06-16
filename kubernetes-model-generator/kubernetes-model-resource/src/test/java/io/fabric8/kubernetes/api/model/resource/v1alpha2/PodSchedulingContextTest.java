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
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class PodSchedulingContextTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-podscheduling.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final PodSchedulingContext podSchedulingContext = mapper.readValue(originalJson, PodSchedulingContext.class);
    final String serializedJson = mapper.writeValueAsString(podSchedulingContext);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(podSchedulingContext)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-podscheduling")
        .hasFieldOrPropertyWithValue("spec.potentialNodes", Collections.singletonList("potential-nodes-value"))
        .hasFieldOrPropertyWithValue("spec.selectedNode", "selected-node-value");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PodSchedulingContextBuilder podSchedulingBuilder = new PodSchedulingContextBuilder()
        .withNewMetadata()
        .withName("test-podscheduling")
        .endMetadata()
        .withNewSpec()
        .addToPotentialNodes("potential-nodes-value")
        .withSelectedNode("selected-node-value")
        .endSpec();

    // When
    PodSchedulingContext podSchedulingContext = podSchedulingBuilder.build();

    // Then
    assertThat(podSchedulingContext)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-podscheduling")
        .hasFieldOrPropertyWithValue("spec.potentialNodes", Collections.singletonList("potential-nodes-value"))
        .hasFieldOrPropertyWithValue("spec.selectedNode", "selected-node-value");
  }
}
