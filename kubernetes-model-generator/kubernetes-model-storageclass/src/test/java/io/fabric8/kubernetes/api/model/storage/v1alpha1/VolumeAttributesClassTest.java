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
package io.fabric8.kubernetes.api.model.storage.v1alpha1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class VolumeAttributesClassTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(VolumeAttributesClass.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-v1alpha1-volumeattributesclass.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final VolumeAttributesClass volumeAttributesClass = mapper.readValue(originalJson, VolumeAttributesClass.class);
    final String serializedJson = mapper.writeValueAsString(volumeAttributesClass);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(volumeAttributesClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "silver")
        .hasFieldOrPropertyWithValue("driverName", "pd.csi.storage.example.io")
        .hasFieldOrPropertyWithValue("parameters.provisioned-iops", "3000")
        .hasFieldOrPropertyWithValue("parameters.provisioned-throughput", "50");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    VolumeAttributesClassBuilder volumeAttributesClassBuilder = new VolumeAttributesClassBuilder()
        .withNewMetadata()
        .withName("silver")
        .endMetadata()
        .withDriverName("pd.csi.storage.example.io")
        .addToParameters("provisioned-iops", "3000")
        .addToParameters("provisioned-throughput", "50");
    // When
    VolumeAttributesClass volumeAttributesClass = volumeAttributesClassBuilder.build();

    // Then
    assertThat(volumeAttributesClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "silver")
        .hasFieldOrPropertyWithValue("driverName", "pd.csi.storage.example.io")
        .hasFieldOrPropertyWithValue("parameters.provisioned-iops", "3000")
        .hasFieldOrPropertyWithValue("parameters.provisioned-throughput", "50");
  }
}
