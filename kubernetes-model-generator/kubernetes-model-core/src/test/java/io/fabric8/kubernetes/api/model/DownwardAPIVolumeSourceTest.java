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

class DownwardAPIVolumeSourceTest {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void deserializationWithOctalValueShouldWorkAsExpected() throws IOException {
    // Given
    InputStream inputStream = getClass().getResourceAsStream("/downwardapivolumesource.json");

    // When
    DownwardAPIVolumeSource downwardAPIVolumeSource = objectMapper.readValue(inputStream, DownwardAPIVolumeSource.class);

    // Then
    assertThat(downwardAPIVolumeSource)
        .hasFieldOrPropertyWithValue("defaultMode", Integer.valueOf("0555", 8))
        .extracting(DownwardAPIVolumeSource::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(DownwardAPIVolumeFile.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("path", "labels")
        .hasFieldOrPropertyWithValue("fieldRef.fieldPath", "metadata.labels")
        .hasFieldOrPropertyWithValue("mode", Integer.valueOf("0555", 8));
  }
}
