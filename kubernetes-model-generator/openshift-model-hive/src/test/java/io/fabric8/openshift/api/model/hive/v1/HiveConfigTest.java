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
package io.fabric8.openshift.api.model.hive.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class HiveConfigTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-hiveconfig.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final HiveConfig hiveConfig = mapper.readValue(originalJson, HiveConfig.class);
    final String serializedJson = mapper.writeValueAsString(hiveConfig);
    final HiveConfig hiveConfigFromSerializedJson = mapper.readValue(serializedJson, HiveConfig.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(hiveConfig)
        .isNotNull()
        .isEqualTo(hiveConfigFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "hive")
        .extracting("spec.managedDomains").asList()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("gcp.credentialsSecretRef.name", "gcp-creds")
        .hasFieldOrPropertyWithValue("domains", Collections.singletonList("hive.example.com"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    HiveConfigBuilder hiveConfigBuilder = new HiveConfigBuilder()
        .withNewMetadata()
        .withName("hive")
        .endMetadata()
        .withNewSpec()
        .addNewManagedDomain()
        .withNewGcp()
        .withNewCredentialsSecretRef("gcp-creds")
        .endGcp()
        .addToDomains("hive.example.com")
        .endManagedDomain()
        .endSpec();

    // When
    HiveConfig hiveConfig = hiveConfigBuilder.build();

    // Then
    assertThat(hiveConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "hive")
        .extracting("spec.managedDomains").asList()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("gcp.credentialsSecretRef.name", "gcp-creds")
        .hasFieldOrPropertyWithValue("domains", Collections.singletonList("hive.example.com"));
    ;
  }
}
