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
package io.fabric8.openclustermanagement.api.model.discovery;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfig;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DiscoveryConfigTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-discoveryconfig.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final DiscoveryConfig discoveryConfig = mapper.readValue(originalJson, DiscoveryConfig.class);
    final String serializedJson = mapper.writeValueAsString(discoveryConfig);
    final DiscoveryConfig discoveryConfigFromSerializedJson = mapper.readValue(serializedJson, DiscoveryConfig.class);

    // Then
    assertNotNull(discoveryConfig);
    assertNotNull(serializedJson);
    assertNotNull(discoveryConfigFromSerializedJson);
    assertEquals(discoveryConfig.getMetadata().getName(), discoveryConfigFromSerializedJson.getMetadata().getName());
    assertEquals("ocm-api-token", discoveryConfig.getSpec().getCredential());
    assertEquals(7, discoveryConfig.getSpec().getFilters().getLastActive());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    DiscoveryConfigBuilder subscriptionBuilder = new DiscoveryConfigBuilder()
        .withNewMetadata()
        .withName("sample_discovery")
        .endMetadata()
        .withNewSpec()
        .withCredential("ocm-api-token")
        .withNewFilters()
        .withLastActive(7)
        .endFilters()
        .endSpec();

    // When
    DiscoveryConfig subscription = subscriptionBuilder.build();

    // Then
    assertNotNull(subscription);
    assertEquals("sample_discovery", subscription.getMetadata().getName());
    assertEquals("ocm-api-token", subscription.getSpec().getCredential());
    assertEquals(7, subscription.getSpec().getFilters().getLastActive());
  }
}
