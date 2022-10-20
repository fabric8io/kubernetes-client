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
package io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddon;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddonBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservabilityAddonTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-observabilityaddon.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ObservabilityAddon observabilityAddon = mapper.readValue(originalJson, ObservabilityAddon.class);
    final String serializedJson = mapper.writeValueAsString(observabilityAddon);
    final ObservabilityAddon oaFromSerializedJson = mapper.readValue(serializedJson, ObservabilityAddon.class);

    // Then
    assertNotNull(observabilityAddon);
    assertNotNull(serializedJson);
    assertNotNull(oaFromSerializedJson);
    assertEquals(observabilityAddon.getMetadata().getName(), oaFromSerializedJson.getMetadata().getName());
    assertEquals(30, observabilityAddon.getSpec().getInterval());
    assertTrue(observabilityAddon.getSpec().getEnableMetrics());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ObservabilityAddonBuilder observabilityAddonBuilder = new ObservabilityAddonBuilder()
        .withNewMetadata()
        .withName("observability-addon")
        .endMetadata()
        .withNewSpec()
        .withEnableMetrics(true)
        .withInterval(10)
        .endSpec();

    // When
    ObservabilityAddon observabilityAddon = observabilityAddonBuilder.build();

    // Then
    assertNotNull(observabilityAddon);
    assertEquals("observability-addon", observabilityAddon.getMetadata().getName());
    assertEquals(10, observabilityAddon.getSpec().getInterval());
    assertTrue(observabilityAddon.getSpec().getEnableMetrics());
  }
}
