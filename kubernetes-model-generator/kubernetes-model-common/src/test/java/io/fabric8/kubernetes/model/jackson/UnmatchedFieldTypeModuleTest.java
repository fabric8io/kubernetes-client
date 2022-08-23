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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UnmatchedFieldTypeModuleTest {

  private ObjectMapper objectMapper;
  private UnmatchedFieldTypeModule unmatchedFieldTypeModule;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
    unmatchedFieldTypeModule = new UnmatchedFieldTypeModule(false, false);
    objectMapper.registerModule(unmatchedFieldTypeModule);
  }

  @Test
  @DisplayName("readValue, with unknown fields, values are set in additionalProperties map")
  void readValueWithUnknownFields() throws JsonProcessingException {
    // Given
    final String json = "{" +
        "\"stringValue\": \"v1\"," +
        "\"booleanValue\": true," +
        "\"intValue\": 1337," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final ExampleWithAnySetter result = objectMapper.readValue(json, ExampleWithAnySetter.class);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("stringValue", "v1")
        .hasFieldOrPropertyWithValue("booleanValue", true)
        .hasFieldOrPropertyWithValue("intValue", 1337)
        .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue");
  }

  @Test
  @DisplayName("readValue, with unmatched type fields, values are set in additionalProperties map")
  void readValueWithUnmatchedTypeFields() throws JsonProcessingException {
    // Given
    final String json = "{" +
        "\"stringValue\": \"v1\"," +
        "\"booleanValue\": true," +
        "\"intValue\": \"${intValue}\"," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final ExampleWithAnySetter result = objectMapper.readValue(json, ExampleWithAnySetter.class);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("stringValue", "v1")
        .hasFieldOrPropertyWithValue("booleanValue", true)
        .hasFieldOrPropertyWithValue("intValue", null)
        .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue")
        .hasFieldOrPropertyWithValue("additionalProperties.intValue", "${intValue}");
  }

  @Test
  @DisplayName("readValue, with unmatched type nested fields, values are set in additionalProperties map")
  void readValueWithUnmatchedTypeNestedFields() throws JsonProcessingException {
    // Given
    final String json = "{" +
        "\"stringValue\": \"v1\"," +
        "\"booleanValue\": true," +
        "\"intValue\": 1337," +
        "\"nested\": {\"intValue\": \"${intValue}\", \"stringValue\": \"nestedString\"}," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final ExampleWithAnySetter result = objectMapper.readValue(json, ExampleWithAnySetter.class);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("stringValue", "v1")
        .hasFieldOrPropertyWithValue("booleanValue", true)
        .hasFieldOrPropertyWithValue("intValue", 1337)
        .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue")
        .hasFieldOrPropertyWithValue("nested.stringValue", "nestedString")
        .hasFieldOrPropertyWithValue("nested.additionalProperties.intValue", "${intValue}");
  }

  @Test
  @DisplayName("readValue, with no anySetter, should throw Exception")
  void readValueWithNoAnySetterShouldThrowException() {
    // Given
    final String json = "{\"value\": false}";
    // When
    final MismatchedInputException result = assertThrows(MismatchedInputException.class,
        () -> objectMapper.readValue(json, Example.class));
    // Then
    assertThat(result).hasMessageStartingWith("Cannot deserialize value of type `int` from Boolean value");
  }

  @Test
  @DisplayName("readValue, with restrict to templates and unmatched type,  should throw Exception")
  void readValueWithRestrictToTemplatesAndUnmatchedTypeFields() {
    // Given
    unmatchedFieldTypeModule.setRestrictToTemplates(true);
    final String json = "{" +
        "\"stringValue\": \"v1\"," +
        "\"booleanValue\": true," +
        "\"intValue\": \"${intValue}\"," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final MismatchedInputException result = assertThrows(MismatchedInputException.class,
        () -> objectMapper.readValue(json, ExampleWithAnySetter.class));
    // Then
    assertThat(result).hasMessageStartingWith("Cannot deserialize value of type `int` from String");
  }

  @Test
  @DisplayName("writeValueAsString, with additionalProperties overriding fields, additionalProperties are serialized and fields ignored")
  void writeValueAsStringWithAdditionalPropertiesOverridingFields() throws JsonProcessingException {
    // Given
    final ExampleWithAnySetter exampleWithAnySetter = new ExampleWithAnySetter();
    exampleWithAnySetter.setIntValue(1337);
    exampleWithAnySetter.setStringValue("the-string");
    exampleWithAnySetter.setBooleanValue(true);
    exampleWithAnySetter.setNested(new ExampleWithAnySetter());
    exampleWithAnySetter.getNested().setStringValue("ignored");
    exampleWithAnySetter.getAdditionalProperties().put("unknownField", "unknownValue");
    exampleWithAnySetter.getAdditionalProperties().put("intValue", "${intValue}");
    exampleWithAnySetter.getAdditionalProperties().put("nested", "${nested}");
    // When
    final String result = objectMapper.writeValueAsString(exampleWithAnySetter);
    // Then
    assertThat(result).isEqualTo("{" +
        "\"stringValue\":\"the-string\"," +
        "\"booleanValue\":true," +
        "\"intValue\":\"${intValue}\"," +
        "\"unknownField\":\"unknownValue\"," +
        "\"nested\":\"${nested}\"" +
        "}");
  }

  @Test
  @DisplayName("writeValueAsString, with additionalProperties overriding fields and enabled log, should log warning")
  void writeValueAsStringWithAdditionalPropertiesOverridingFieldsShouldLogWarning() throws JsonProcessingException {
    try (MockedStatic<LoggerFactory> lfMock = mockStatic(LoggerFactory.class)) {
      // Given
      unmatchedFieldTypeModule.setLogWarnings(true);
      final ExampleWithAnySetter exampleWithAnySetter = new ExampleWithAnySetter();
      exampleWithAnySetter.setIntValue(1337);
      exampleWithAnySetter.setStringValue("the-string");
      exampleWithAnySetter.setBooleanValue(true);
      exampleWithAnySetter.getAdditionalProperties().put("intValue", "I'll trigger a warning");
      final Logger mockLogger = mock(Logger.class, RETURNS_DEEP_STUBS);
      lfMock.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLogger);
      // When
      objectMapper.writeValueAsString(exampleWithAnySetter);
      // Then
      verify(mockLogger, times(1))
          .warn("Value in field '{}' ignored in favor of value in additionalProperties ({}) for {}",
              "intValue", "I'll trigger a warning",
              "io.fabric8.kubernetes.model.jackson.UnmatchedFieldTypeModuleTest$ExampleWithAnySetter");
    }
  }

  @Test
  @DisplayName("writeValueAsString, with additionalProperties overriding fields and disabled log, should NOT log warning")
  void writeValueAsStringWithAdditionalPropertiesOverridingFieldsShouldNotLogWarning() throws JsonProcessingException {
    try (MockedStatic<LoggerFactory> lfMock = mockStatic(LoggerFactory.class)) {
      // Given
      final ObjectMapper om = new ObjectMapper();
      final UnmatchedFieldTypeModule module = new UnmatchedFieldTypeModule();
      om.registerModule(module);
      module.setLogWarnings(false);
      final ExampleWithAnySetter exampleWithAnySetter = new ExampleWithAnySetter();
      exampleWithAnySetter.setIntValue(1337);
      exampleWithAnySetter.setStringValue("the-string");
      exampleWithAnySetter.setBooleanValue(true);
      exampleWithAnySetter.getAdditionalProperties().put("intValue", "I'll trigger a warning");
      final Logger mockLogger = mock(Logger.class, RETURNS_DEEP_STUBS);
      lfMock.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLogger);
      // When
      om.writeValueAsString(exampleWithAnySetter);
      // Then
      verify(mockLogger, never())
          .warn("Value in field '{}' ignored in favor of value in additionalProperties ({}) for {}",
              "intValue", "I'll trigger a warning",
              "io.fabric8.kubernetes.model.jackson.UnmatchedFieldTypeModuleTest$ExampleWithAnySetter");
    }
  }

  private static class Example {
    public int value;
  }

  @SuppressWarnings("unused")
  private static class ExampleWithAnySetter {

    public String stringValue;
    public Boolean booleanValue;
    public Integer intValue;
    public ExampleWithAnySetter nested;
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getStringValue() {
      return stringValue;
    }

    public void setStringValue(String stringValue) {
      this.stringValue = stringValue;
    }

    public Boolean getBooleanValue() {
      return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
      this.booleanValue = booleanValue;
    }

    public Integer getIntValue() {
      return intValue;
    }

    public void setIntValue(int intValue) {
      this.intValue = intValue;
    }

    public ExampleWithAnySetter getNested() {
      return nested;
    }

    public void setNested(ExampleWithAnySetter nested) {
      this.nested = nested;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
      return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
      this.additionalProperties.put(name, value);
    }

  }
}
