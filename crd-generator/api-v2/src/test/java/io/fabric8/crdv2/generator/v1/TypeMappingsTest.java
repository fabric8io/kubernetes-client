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
package io.fabric8.crdv2.generator.v1;

import io.fabric8.crdv2.example.types.TypeMappingsSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The OpenAPI type of every property is whatever Jackson reports for it, so a Jackson upgrade or a
 * change in the registered modules can silently change the generated CRDs. These cases pin it down.
 */
class TypeMappingsTest {

  private static final Map<String, JSONSchemaProps> PROPERTIES = JsonSchema.from(TypeMappingsSpec.class).getProperties();

  @ParameterizedTest(name = "{0} maps to {1}")
  @MethodSource("targetTypeCases")
  @DisplayName("Java types map to their OpenAPI counterparts")
  void targetType(String propertyName, String expectedType) {
    assertThat(PROPERTIES)
        .withFailMessage("Expected %s to be %s, but was %s", propertyName, expectedType,
            PROPERTIES.containsKey(propertyName) ? PROPERTIES.get(propertyName).getType() : "absent")
        .extractingByKey(propertyName)
        .extracting(JSONSchemaProps::getType)
        .isEqualTo(expectedType);
  }

  @ParameterizedTest(name = "{0} has format {1}")
  @MethodSource("targetFormatCases")
  @DisplayName("Java types only declare a format their serialized values match")
  void targetFormat(String propertyName, String expectedFormat) {
    assertThat(PROPERTIES)
        .withFailMessage("Expected %s to have format %s, but was %s", propertyName, expectedFormat,
            PROPERTIES.containsKey(propertyName) ? PROPERTIES.get(propertyName).getFormat() : "absent")
        .extractingByKey(propertyName)
        .extracting(JSONSchemaProps::getFormat)
        .isEqualTo(expectedFormat);
  }

  /**
   * The API server rejects values that don't match a date-time (RFC 3339, offset required) or date format, so only
   * the types that always write a matching value keep one, see AbstractJsonSchema#writesFormat. The API server
   * behavior is verified in crd-generator-test's GeneratedCRDsOnApiServerTest.
   */
  static Stream<Arguments> targetFormatCases() {
    return Stream.of(
        Arguments.of("date", "date-time"),
        Arguments.of("localDate", "date"),
        Arguments.of("localDateTime", null),
        Arguments.of("localTime", null),
        Arguments.of("zonedDateTime", "date-time"),
        Arguments.of("offsetDateTime", "date-time"),
        Arguments.of("offsetTime", null),
        Arguments.of("yearMonth", null),
        Arguments.of("monthDay", null),
        Arguments.of("timestamp", "date-time"),
        Arguments.of("sqlDate", "date-time"),
        Arguments.of("sqlTime", null),
        Arguments.of("calendar", "date-time"),
        Arguments.of("instant", "date-time"),
        Arguments.of("duration", null),
        Arguments.of("period", null),
        Arguments.of("optionalInstant", "date-time"),
        Arguments.of("optionalDuration", null),
        Arguments.of("uuid", "uuid"),
        Arguments.of("aString", null),
        Arguments.of("aInt", null));
  }

  static Stream<Arguments> targetTypeCases() {
    return Stream.of(
        Arguments.of("date", "string"),
        Arguments.of("localDate", "string"),
        Arguments.of("localDateTime", "string"),
        Arguments.of("localTime", "string"),
        Arguments.of("zonedDateTime", "string"),
        Arguments.of("offsetDateTime", "string"),
        Arguments.of("offsetTime", "string"),
        Arguments.of("yearMonth", "string"),
        Arguments.of("monthDay", "string"),
        Arguments.of("instant", "string"),
        Arguments.of("duration", "string"),
        Arguments.of("period", "string"),
        Arguments.of("timestamp", "string"), // to review, see #8109
        Arguments.of("sqlDate", "string"),
        Arguments.of("sqlTime", "string"),
        Arguments.of("calendar", "string"),
        Arguments.of("optionalInstant", "string"),
        Arguments.of("optionalDuration", "string"),
        Arguments.of("aShort", "integer"),
        Arguments.of("aShortObj", "integer"),
        Arguments.of("aInt", "integer"),
        Arguments.of("aIntegerObj", "integer"),
        Arguments.of("aLong", "integer"),
        Arguments.of("aLongObj", "integer"),
        Arguments.of("aDouble", "number"),
        Arguments.of("aDoubleObj", "number"),
        Arguments.of("aFloat", "number"),
        Arguments.of("aFloatObj", "number"),
        Arguments.of("aNumber", "number"),
        Arguments.of("aBigInteger", "integer"),
        Arguments.of("aBigDecimal", "number"),
        Arguments.of("aBoolean", "boolean"),
        Arguments.of("aBooleanObj", "boolean"),
        Arguments.of("aChar", "string"),
        Arguments.of("aCharacterObj", "string"),
        Arguments.of("aCharArray", "array"),
        Arguments.of("aCharSequence", "string"),
        Arguments.of("aString", "string"),
        Arguments.of("aStringArray", "array"),
        Arguments.of("aByte", "integer"),
        Arguments.of("aByteObj", "integer"),
        Arguments.of("aByteArray", "array"), // to review, should be string (base64), see #8109
        Arguments.of("uuid", "string"));
  }
}
