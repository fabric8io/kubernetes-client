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
package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.Quantity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NodeMetricsTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void shouldNotImplementNamespacedInterface() {
    assertThat(Namespaced.class.isAssignableFrom(NodeMetrics.class)).isFalse();
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-nodemetric.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final NodeMetrics nodeMetrics = mapper.readValue(originalJson, NodeMetrics.class);
    final String serializedJson = mapper.writeValueAsString(nodeMetrics);
    final NodeMetrics nodeMetricsFromSerializedJson = mapper.readValue(serializedJson, NodeMetrics.class);

    // Then
    assertThat(nodeMetrics).isNotNull();
    assertThat(serializedJson).isNotNull();
    assertThat(nodeMetricsFromSerializedJson).isNotNull();
    assertThat(nodeMetrics).isEqualTo(nodeMetricsFromSerializedJson);
  }

  @Test
  void builderShouldCreateObject() throws ParseException {
    // Given
    NodeMetricsBuilder nodeMetricsBuilder = new NodeMetricsBuilder()
        .withNewMetadata().withName("minikube").endMetadata()
        .withTimestamp("2021-12-23T16:05:09Z")
        .withWindow(Duration.parse("30s"))
        .withUsage(Collections.singletonMap("cpu", new Quantity("134994244n")));

    // When
    NodeMetrics nodeMetrics = nodeMetricsBuilder.build();

    // Then
    assertThat(nodeMetrics)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "minikube")
        .hasFieldOrPropertyWithValue("timestamp", "2021-12-23T16:05:09Z")
        .hasFieldOrPropertyWithValue("window", Duration.parse("30s"))
        .hasFieldOrPropertyWithValue("usage", Collections.singletonMap("cpu", new Quantity("134994244n")));
  }
}
