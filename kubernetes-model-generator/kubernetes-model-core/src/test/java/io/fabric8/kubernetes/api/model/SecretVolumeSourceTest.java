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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.jackson.GoCompatibilityModule;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SecretVolumeSourceTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
    objectMapper.registerModule(new GoCompatibilityModule());
  }

  @Test
  void deserializationWithOctalValueShouldWorkAsExpected() throws IOException {
    // Given
    final String originalJson = Helper.loadJson("/secretvolumesource.json");

    // When
    SecretVolumeSource secretVolumeSource = objectMapper.readValue(originalJson, SecretVolumeSource.class);

    // Then
    assertThat(secretVolumeSource)
        .hasFieldOrPropertyWithValue("defaultMode", Integer.valueOf("0555", 8))
        .hasFieldOrPropertyWithValue("secretName", "conf")
        .extracting(SecretVolumeSource::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(KeyToPath.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("key", "key1")
        .hasFieldOrPropertyWithValue("path", "target")
        .hasFieldOrPropertyWithValue("mode", Integer.valueOf("0555", 8));
  }
}
