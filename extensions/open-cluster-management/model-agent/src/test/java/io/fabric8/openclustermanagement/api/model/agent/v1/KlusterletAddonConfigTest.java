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
package io.fabric8.openclustermanagement.api.model.agent.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KlusterletAddonConfigTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-klusterletaddonconfig.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final KlusterletAddonConfig kac = mapper.readValue(originalJson, KlusterletAddonConfig.class);
    final String serializedJson = mapper.writeValueAsString(kac);
    final KlusterletAddonConfig kacFromSerializedJson = mapper.readValue(serializedJson, KlusterletAddonConfig.class);

    // Then
    assertNotNull(kac);
    assertNotNull(serializedJson);
    assertNotNull(kacFromSerializedJson);
    assertEquals(kac.getMetadata().getName(), kacFromSerializedJson.getMetadata().getName());
    assertTrue(kac.getSpec().getApplicationManager().getEnabled());
    assertTrue(kac.getSpec().getPolicyController().getEnabled());
    assertTrue(kac.getSpec().getSearchCollector().getEnabled());
    assertTrue(kac.getSpec().getIamPolicyController().getEnabled());
    assertTrue(kac.getSpec().getCertPolicyController().getEnabled());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigBuilder klusterletAddonConfigBuilder = new io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigBuilder()
        .withNewMetadata()
        .withName("test-kac")
        .endMetadata()
        .withNewSpec()
        .withNewApplicationManager()
        .withEnabled(true)
        .endApplicationManager()
        .withNewPolicyController()
        .withEnabled(true)
        .endPolicyController()
        .withNewSearchCollector()
        .withEnabled(true)
        .endSearchCollector()
        .withNewCertPolicyController()
        .withEnabled(true)
        .endCertPolicyController()
        .withNewIamPolicyController()
        .withEnabled(true)
        .endIamPolicyController()
        .endSpec();

    // When
    KlusterletAddonConfig kac = klusterletAddonConfigBuilder.build();

    // Then
    assertNotNull(kac);
    assertEquals("test-kac", kac.getMetadata().getName());
    assertTrue(kac.getSpec().getApplicationManager().getEnabled());
    assertTrue(kac.getSpec().getPolicyController().getEnabled());
    assertTrue(kac.getSpec().getSearchCollector().getEnabled());
    assertTrue(kac.getSpec().getIamPolicyController().getEnabled());
    assertTrue(kac.getSpec().getCertPolicyController().getEnabled());
  }
}
