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
package io.fabric8.openclustermanagement.api.model.operator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.operator.v1.Klusterlet;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KlusterletTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-klusterlet.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Klusterlet klusterlet = mapper.readValue(originalJson, Klusterlet.class);
    final String serializedJson = mapper.writeValueAsString(klusterlet);
    final Klusterlet klusterletFromSerializedJson = mapper.readValue(serializedJson, Klusterlet.class);

    // Then
    assertNotNull(klusterlet);
    assertNotNull(serializedJson);
    assertNotNull(klusterletFromSerializedJson);
    assertEquals(klusterlet.getMetadata().getName(), klusterletFromSerializedJson.getMetadata().getName());
    assertEquals("quay.io/open-cluster-management/registration", klusterlet.getSpec().getRegistrationImagePullSpec());
    assertEquals("quay.io/open-cluster-management/work", klusterlet.getSpec().getWorkImagePullSpec());
    assertEquals("cluster1", klusterlet.getSpec().getClusterName());
    assertEquals("open-cluster-management-agent", klusterlet.getSpec().getNamespace());
    assertEquals(1, klusterlet.getSpec().getExternalServerURLs().size());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    KlusterletBuilder klusterletBuilder = new KlusterletBuilder()
        .withNewMetadata()
        .withName("klusterlet")
        .endMetadata()
        .withNewSpec()
        .withRegistrationImagePullSpec("quay.io/open-cluster-management/registration")
        .withWorkImagePullSpec("quay.io/open-cluster-management/work")
        .withClusterName("cluster1")
        .withNamespace("open-cluster-management-agent")
        .addNewExternalServerURL()
        .withUrl("https://localhost")
        .endExternalServerURL()
        .endSpec();

    // When
    Klusterlet klusterlet = klusterletBuilder.build();

    // Then
    assertNotNull(klusterlet);
    assertEquals("klusterlet", klusterlet.getMetadata().getName());
    assertEquals("quay.io/open-cluster-management/registration", klusterlet.getSpec().getRegistrationImagePullSpec());
    assertEquals("quay.io/open-cluster-management/work", klusterlet.getSpec().getWorkImagePullSpec());
    assertEquals("cluster1", klusterlet.getSpec().getClusterName());
    assertEquals("open-cluster-management-agent", klusterlet.getSpec().getNamespace());
    assertEquals(1, klusterlet.getSpec().getExternalServerURLs().size());
  }
}
