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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.databind.JsonNode;

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

  @ParameterizedTest(name = "{0} {1} map to {2} with format {3}")
  @MethodSource("nestedCases")
  @DisplayName("Collection items and map values map like properties of their type")
  void nested(String propertyName, String nesting, String expectedType, String expectedFormat) {
    final JSONSchemaProps property = PROPERTIES.get(propertyName);
    final JSONSchemaProps nested = "items".equals(nesting) ? property.getItems().getSchema()
        : property.getAdditionalProperties().getSchema();

    assertThat(nested)
        .extracting(JSONSchemaProps::getType, JSONSchemaProps::getFormat)
        .containsExactly(expectedType, expectedFormat);
  }

  @Test
  @DisplayName("Month lists its names, like the enum Jackson writes it as")
  void monthIsAnEnum() {
    assertThat(PROPERTIES.get("month").getEnum())
        .extracting(JsonNode::asString)
        .containsExactly("APRIL", "AUGUST", "DECEMBER", "FEBRUARY", "JANUARY", "JULY", "JUNE", "MARCH", "MAY",
            "NOVEMBER", "OCTOBER", "SEPTEMBER");
  }

  /**
   * n bytes are 4 * ceil(n / 3) base64 characters, so the bounds never reject a value within the byte limits.
   */
  @ParameterizedTest(name = "{0} has minLength {1} and maxLength {2}")
  @MethodSource("sizeCases")
  @DisplayName("@Size on a binary type bounds the length of its base64 string, not the number of items")
  void sizeBounds(String propertyName, Long expectedMinLength, Long expectedMaxLength) {
    assertThat(PROPERTIES.get(propertyName))
        .extracting(JSONSchemaProps::getMinLength, JSONSchemaProps::getMaxLength, JSONSchemaProps::getMinItems,
            JSONSchemaProps::getMaxItems)
        .containsExactly(expectedMinLength, expectedMaxLength, null, null);
  }

  static Stream<Arguments> sizeCases() {
    return Stream.of(
        Arguments.of("sizedByteArray", 4L, 1368L),
        Arguments.of("sizedByteBuffer", 4L, 8L),
        // its serializer writes a plain string, which @Size bounds as is
        Arguments.of("stringSerializedBytes", null, 3L));
  }

  @Test
  @DisplayName("@Size on a binary type argument bounds the length of the base64 items")
  void typeUseSizeBoundsBase64Items() {
    assertThat(PROPERTIES.get("sizedByteBufferList").getItems().getSchema())
        .extracting(JSONSchemaProps::getType, JSONSchemaProps::getFormat, JSONSchemaProps::getMaxLength)
        .containsExactly("string", "byte", 4L);
  }

  /**
   * The API server rejects values that don't match a date-time (RFC 3339, offset required) or date format, so only
   * the types that always write a matching value keep one, see AbstractJsonSchema#writesFormat. The API server
   * behavior is verified in crd-generator-test's GeneratedCRDsOnApiServerTest.
   * <p>
   * Binary and integer types get the format controller-gen gives their Go counterparts ([]byte, int32, int64).
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
        Arguments.of("sqlDate", "date"),
        Arguments.of("sqlTime", null),
        Arguments.of("calendar", "date-time"),
        Arguments.of("instant", "date-time"),
        Arguments.of("duration", null),
        Arguments.of("period", null),
        Arguments.of("optionalInstant", "date-time"),
        Arguments.of("optionalDuration", null),
        Arguments.of("year", null),
        Arguments.of("month", null),
        Arguments.of("uuid", "uuid"),
        Arguments.of("aString", null),
        Arguments.of("aCharArray", null),
        Arguments.of("locale", null),
        Arguments.of("qname", null),
        Arguments.of("otherQname", null),
        Arguments.of("aShort", null),
        Arguments.of("aShortObj", null),
        Arguments.of("aInt", "int32"),
        Arguments.of("aIntegerObj", "int32"),
        Arguments.of("optionalInteger", "int32"),
        Arguments.of("optionalInt", "int32"),
        Arguments.of("atomicInteger", "int32"),
        Arguments.of("aLong", "int64"),
        Arguments.of("aLongObj", "int64"),
        Arguments.of("optionalLong", "int64"),
        Arguments.of("atomicLong", "int64"),
        Arguments.of("aBigInteger", null),
        Arguments.of("aDouble", null),
        Arguments.of("aDoubleObj", null),
        Arguments.of("aFloat", null),
        Arguments.of("aFloatObj", null),
        Arguments.of("aNumber", null),
        Arguments.of("aBigDecimal", null),
        Arguments.of("aByte", null),
        Arguments.of("aByteObj", null),
        Arguments.of("aByteArray", "byte"),
        Arguments.of("byteBuffer", "byte"),
        Arguments.of("optionalByteArray", "byte"),
        Arguments.of("sizedByteArray", "byte"),
        Arguments.of("sizedByteBuffer", "byte"),
        // a serializer other than Jackson's writes something else than base64
        Arguments.of("stringSerializedBytes", null));
  }

  static Stream<Arguments> nestedCases() {
    return Stream.of(
        Arguments.of("intArray", "items", "integer", "int32"),
        Arguments.of("integerList", "items", "integer", "int32"),
        Arguments.of("longArray", "items", "integer", "int64"),
        Arguments.of("longMap", "values", "integer", "int64"),
        Arguments.of("byteArrayList", "items", "string", "byte"),
        Arguments.of("byteArrayMap", "values", "string", "byte"),
        // Jackson writes these as arrays of numbers, like Go's [N]byte
        Arguments.of("boxedByteArray", "items", "integer", null),
        Arguments.of("byteList", "items", "integer", null),
        Arguments.of("numberSerializedBytes", "items", "integer", null),
        Arguments.of("qnameList", "items", "string", null),
        Arguments.of("qnameMap", "values", "string", null));
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
        Arguments.of("timestamp", "string"),
        Arguments.of("sqlDate", "string"),
        Arguments.of("sqlTime", "string"),
        Arguments.of("calendar", "string"),
        Arguments.of("optionalInstant", "string"),
        Arguments.of("optionalDuration", "string"),
        Arguments.of("year", "string"),
        Arguments.of("month", "string"),
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
        Arguments.of("optionalInteger", "integer"),
        Arguments.of("optionalInt", "integer"),
        Arguments.of("optionalLong", "integer"),
        Arguments.of("atomicInteger", "integer"),
        Arguments.of("atomicLong", "integer"),
        Arguments.of("intArray", "array"),
        Arguments.of("longArray", "array"),
        Arguments.of("integerList", "array"),
        Arguments.of("longMap", "object"),
        Arguments.of("aBoolean", "boolean"),
        Arguments.of("aBooleanObj", "boolean"),
        Arguments.of("aChar", "string"),
        Arguments.of("aCharacterObj", "string"),
        Arguments.of("aCharArray", "string"),
        Arguments.of("aCharSequence", "string"),
        Arguments.of("aString", "string"),
        Arguments.of("aStringArray", "array"),
        Arguments.of("locale", "string"),
        Arguments.of("qname", "string"),
        Arguments.of("otherQname", "string"),
        Arguments.of("qnameList", "array"),
        Arguments.of("qnameMap", "object"),
        Arguments.of("aByte", "integer"),
        Arguments.of("aByteObj", "integer"),
        Arguments.of("aByteArray", "string"),
        Arguments.of("byteBuffer", "string"),
        Arguments.of("optionalByteArray", "string"),
        Arguments.of("byteArrayList", "array"),
        Arguments.of("byteArrayMap", "object"),
        Arguments.of("boxedByteArray", "array"),
        Arguments.of("byteList", "array"),
        Arguments.of("sizedByteArray", "string"),
        Arguments.of("sizedByteBuffer", "string"),
        Arguments.of("sizedByteBufferList", "array"),
        Arguments.of("stringSerializedBytes", "string"),
        Arguments.of("numberSerializedBytes", "array"),
        Arguments.of("uuid", "string"));
  }
}
