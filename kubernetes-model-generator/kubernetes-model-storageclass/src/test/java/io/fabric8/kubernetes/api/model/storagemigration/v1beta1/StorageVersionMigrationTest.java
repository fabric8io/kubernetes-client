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
package io.fabric8.kubernetes.api.model.storagemigration.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class StorageVersionMigrationTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(StorageVersionMigration.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void apiGroup() {
    assertThat(new StorageVersionMigration().getApiVersion()).isEqualTo("storagemigration.k8s.io/v1beta1");
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-v1beta1-storageversionmigration.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final StorageVersionMigration volumeAttributesClass = mapper.readValue(originalJson, StorageVersionMigration.class);
    final String serializedJson = mapper.writeValueAsString(volumeAttributesClass);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(volumeAttributesClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.resource.group", "groupValue")
        .hasFieldOrPropertyWithValue("spec.resource.resource", "resourceValue");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    StorageVersionMigrationBuilder storageVersionMigrationBuilder = new StorageVersionMigrationBuilder()
        .withNewMetadata()
        .withName("nameValue")
        .endMetadata()
        .withNewSpec()
        .withNewResource("groupValue", "resourceValue")
        .endSpec();
    // When
    StorageVersionMigration storageVersionMigration = storageVersionMigrationBuilder.build();

    // Then
    assertThat(storageVersionMigration)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.resource.group", "groupValue")
        .hasFieldOrPropertyWithValue("spec.resource.resource", "resourceValue");
  }
}
