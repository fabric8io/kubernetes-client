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
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConfigMapVolumeSourceTest {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void deserializationWithOctalValueShouldWorkAsExpected() throws IOException {
    // Given
    InputStream inputStream = getClass().getResourceAsStream("/configmapvolumesource.json");

    // When
    ConfigMapVolumeSource configMapVolumeSource = objectMapper.readValue(inputStream, ConfigMapVolumeSource.class);

    // Then
    assertThat(configMapVolumeSource)
        .hasFieldOrPropertyWithValue("defaultMode", Integer.valueOf("0555", 8))
        .hasFieldOrPropertyWithValue("name", "conf")
        .extracting(ConfigMapVolumeSource::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(KeyToPath.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("key", "key1")
        .hasFieldOrPropertyWithValue("path", "target")
        .hasFieldOrPropertyWithValue("mode", Integer.valueOf("0555", 8));
  }
}
