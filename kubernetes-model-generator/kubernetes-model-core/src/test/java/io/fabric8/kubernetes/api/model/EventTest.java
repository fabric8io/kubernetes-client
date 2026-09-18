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

import io.fabric8.kubernetes.model.util.Helper;
import io.fabric8.zjsonpatch.JsonDiff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new JsonMapper();
  }

  @Test
  void testEventSerializationDeserialization() throws JacksonException {
    // Given
    final String originalJson = Helper.loadJson("/valid-event.json");
    final Event event = mapper.readValue(originalJson, Event.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson), mapper.readTree(mapper.writeValueAsString(event)));
    // Then
    assertThat(diff).isEmpty();
  }
}
