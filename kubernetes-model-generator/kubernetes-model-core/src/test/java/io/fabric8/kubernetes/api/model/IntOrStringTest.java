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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntOrStringTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new JsonMapper();
  }

  @Test
  void testIntOrStringJson() throws IOException {
    IntOrString is = new IntOrString(3000);
    String json = mapper.writeValueAsString(is);
    IntOrString is2 = mapper.readValue(json, IntOrString.class);
    assertThat(is).isEqualTo(is2);

    is = new IntOrString("3000");
    json = mapper.writeValueAsString(is);
    is2 = mapper.readValue(json, IntOrString.class);
    assertThat(is).isEqualTo(is2);
  }

  @Test
  void setValue_whenIntValueProvided_shouldSetIntVal() throws JacksonException {
    // Given
    IntOrString is = new IntOrString();

    // When
    is.setValue(5000);

    // Then
    assertThat(is.getValue()).isInstanceOf(Integer.class);
    assertThat(mapper.writeValueAsString(is)).isEqualTo("5000");
  }

  @Test
  void setValue_whenStringValueProvided_shouldSetStrVal() throws JacksonException {
    // Given
    IntOrString is = new IntOrString();

    // When
    is.setValue("900");

    // Then
    assertThat(is.getValue()).isInstanceOf(String.class);
    assertThat(mapper.writeValueAsString(is)).isEqualTo("\"900\"");
  }

  @Test
  void builder_withIntVal_shouldSetIntValAndKind() {
    // Given + When
    IntOrString intOrString = new IntOrStringBuilder().withValue(89).build();

    // Then
    assertThat(intOrString)
        .hasFieldOrPropertyWithValue("value", 89);
  }

  @Test
  void builder_withStrVal_shouldSetStrValAndKind() {
    // Given + When
    IntOrString intOrString = new IntOrStringBuilder().withValue("89").build();

    // Then
    assertThat(intOrString)
        .hasFieldOrPropertyWithValue("value", "89");
  }

  @Test
  void builder_withEmpty_shouldSetNullValue() {
    // Given
    IntOrStringBuilder intOrStringBuilder = new IntOrStringBuilder();
    // When
    final IntOrString result = intOrStringBuilder.build();
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("value", null);
  }

  @Test
  void builder_withBoolean_shouldThrowException() {
    // Given
    IntOrStringBuilder intOrStringBuilder = new IntOrStringBuilder().withValue(true);
    // When
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, intOrStringBuilder::build);
    // Then
    assertThat(illegalArgumentException)
        .hasMessage("Either integer or string value needs to be provided");
  }
}
