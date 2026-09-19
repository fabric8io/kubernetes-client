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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.generator.annotation.Default;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.BooleanNode;
import tools.jackson.databind.node.DoubleNode;
import tools.jackson.databind.node.FloatNode;
import tools.jackson.databind.node.IntNode;
import tools.jackson.databind.node.LongNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JsonSchemaDefaultValueTest {

  private static final class ClassInTest {
    @JsonProperty(defaultValue = "precedence-from-json-property")
    @Default("precedence-from-default-annotation")
    String precedence;

    @JsonProperty
    @Default("string-from-default-annotation")
    String defaultAnnotationForString;

    @JsonProperty(defaultValue = "true")
    Boolean defaultValueForBoxedBoolean;

    @JsonProperty
    @Default("true")
    Boolean defaultAnnotationForBoxedBoolean;

    @JsonProperty(defaultValue = "true")
    boolean defaultValueForBoolean;

    @JsonProperty
    @Default("true")
    boolean defaultAnnotationForBoolean;

    @JsonProperty(defaultValue = "1337")
    int defaultValueForInt;

    @JsonProperty(defaultValue = "1337")
    long defaultValueForLong;

    @JsonProperty(defaultValue = "13.37")
    float defaultValueForFloat;

    @JsonProperty(defaultValue = "13.37")
    double defaultValueForDouble;

    @JsonProperty(defaultValue = "invalid")
    double invalidDefaultValueForDouble;

    @JsonProperty
    @Default("[]")
    double[] defaultValueForDoubleArray;
  }

  @Test
  @DisplayName("Default annotation should take precedence over JsonProperty")
  void precedence() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("precedence._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .extracting(JsonNode::asText)
        .isEqualTo("precedence-from-default-annotation");
  }

  @Test
  @DisplayName("Default annotation for String")
  void stringFromDefaultAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultAnnotationForString._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .extracting(JsonNode::asText)
        .isEqualTo("string-from-default-annotation");
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for boxed Boolean")
  void booleanBoxedFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForBoxedBoolean._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(BooleanNode.class)
        .extracting(JsonNode::asBoolean)
        .isEqualTo(true);
  }

  @Test
  @DisplayName("Default annotation for boxed Boolean")
  void booleanBoxedFromDefaultAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultAnnotationForBoxedBoolean._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(BooleanNode.class)
        .extracting(JsonNode::asBoolean)
        .isEqualTo(true);
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for boolean")
  void booleanFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForBoolean._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(BooleanNode.class)
        .extracting(JsonNode::asBoolean)
        .isEqualTo(true);
  }

  @Test
  @DisplayName("Default annotation for boolean")
  void booleanFromDefaultAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultAnnotationForBoolean._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(BooleanNode.class)
        .extracting(JsonNode::asBoolean)
        .isEqualTo(true);
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for int")
  void intFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForInt._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(IntNode.class)
        .extracting(JsonNode::asInt)
        .isEqualTo(1337);
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for long")
  void longFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForLong._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(LongNode.class)
        .extracting(JsonNode::asLong)
        .isEqualTo(1337L);
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for float")
  void floatFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForFloat._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(FloatNode.class)
        .extracting(JsonNode::asText)
        .isEqualTo("13.37");
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for double")
  void doubleFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForDouble._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(DoubleNode.class)
        .extracting(JsonNode::asDouble)
        .isEqualTo(13.37);
  }

  @Test
  @DisplayName("JsonProperty defaultValue annotation for double array")
  void doubleArrayFromJsonPropertyAnnotation() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("defaultValueForDoubleArray._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(ArrayNode.class)
        .extracting(JsonNode::toPrettyString)
        .isEqualTo("[ ]");
  }

  @Test
  @DisplayName("JsonProperty invalid defaultValue annotation not used")
  void invalidDefaultFromJsonPropertyAnnotationNotUsed() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("invalidDefaultValueForDouble._default")
        .isNull();
  }

  // --- Edge case test models ---

  private enum Color {
    RED,
    GREEN,
    BLUE
  }

  private enum RenamedColor {
    @JsonProperty("rouge")
    RED,
    @JsonProperty("vert")
    GREEN,
    @JsonProperty("bleu")
    BLUE
  }

  private static final class NestedObject {
    @JsonProperty
    String name;
    @JsonProperty
    int value;
  }

  private static final class EdgeCaseDefaults {
    @JsonProperty
    @Default("RED")
    Color enumDefault;

    @JsonProperty
    @Default("rouge")
    RenamedColor renamedEnumDefault;

    @JsonProperty
    @Default("{\"name\":\"test\",\"value\":42}")
    NestedObject complexObjectDefault;

    @JsonProperty
    @Default("[1.5, 2.5, 3.5]")
    double[] nonEmptyArrayDefault;

    @JsonProperty
    @Default("[\"a\", \"b\", \"c\"]")
    List<String> nonEmptyListDefault;

    @JsonProperty
    @Default("string with \"quotes\" and \\ backslash")
    String specialCharsDefault;
  }

  @Test
  @DisplayName("Default value for enum should serialize correctly")
  void defaultValueForEnum() {
    assertThat(JsonSchema.from(EdgeCaseDefaults.class).getProperties())
        .extracting("enumDefault._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .extracting(JsonNode::asText)
        .isEqualTo("RED");
  }

  @Test
  @DisplayName("Default value for renamed enum should use serialized name")
  void defaultValueForRenamedEnum() {
    assertThat(JsonSchema.from(EdgeCaseDefaults.class).getProperties())
        .extracting("renamedEnumDefault._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .extracting(JsonNode::asText)
        .isEqualTo("rouge");
  }

  @Test
  @DisplayName("Default value for complex object should serialize as JSON")
  void defaultValueForComplexObject() {
    assertThat(JsonSchema.from(EdgeCaseDefaults.class).getProperties())
        .extracting("complexObjectDefault._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(ObjectNode.class)
        .satisfies(node -> {
          assertThat(node.get("name").asText()).isEqualTo("test");
          assertThat(node.get("value").asInt()).isEqualTo(42);
        });
  }

  @Test
  @DisplayName("Default value for non-empty array should contain elements")
  void defaultValueForNonEmptyArray() {
    assertThat(JsonSchema.from(EdgeCaseDefaults.class).getProperties())
        .extracting("nonEmptyArrayDefault._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(ArrayNode.class)
        .satisfies(node -> {
          assertThat(node.size()).isEqualTo(3);
          assertThat(node.get(0).asDouble()).isEqualTo(1.5);
          assertThat(node.get(1).asDouble()).isEqualTo(2.5);
          assertThat(node.get(2).asDouble()).isEqualTo(3.5);
        });
  }

  @Test
  @DisplayName("Default value for non-empty list should contain elements")
  void defaultValueForNonEmptyList() {
    assertThat(JsonSchema.from(EdgeCaseDefaults.class).getProperties())
        .extracting("nonEmptyListDefault._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .isInstanceOf(ArrayNode.class)
        .satisfies(node -> {
          assertThat(node.size()).isEqualTo(3);
          assertThat(node.get(0).asText()).isEqualTo("a");
          assertThat(node.get(1).asText()).isEqualTo("b");
          assertThat(node.get(2).asText()).isEqualTo("c");
        });
  }

  @Test
  @DisplayName("Default value with special characters in string should be preserved")
  void defaultValueWithSpecialChars() {
    assertThat(JsonSchema.from(EdgeCaseDefaults.class).getProperties())
        .extracting("specialCharsDefault._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .extracting(JsonNode::asText)
        .isEqualTo("string with \"quotes\" and \\ backslash");
  }

}
