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
package io.fabric8.kubernetes.api.model.apiextensions.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import io.fabric8.zjsonpatch.JsonDiff;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConversionReviewTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void testDeserializationAndSerialization() throws Exception {
    // Given
    final String originalJson = Helper.loadJson("/valid-conversionreview.json");
    final ConversionReview conversionReview = mapper.readValue(originalJson, ConversionReview.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson),
        mapper.readTree(mapper.writeValueAsString(conversionReview)));
    // Then
    assertThat(diff).isEmpty();
  }
}
