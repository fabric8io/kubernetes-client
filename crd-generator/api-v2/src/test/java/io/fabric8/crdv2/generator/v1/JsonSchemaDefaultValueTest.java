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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.LongNode;
import io.fabric8.generator.annotation.Default;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @JsonProperty(defaultValue = "1337L")
    long defaultValueForLong;

    @JsonProperty(defaultValue = "13.37")
    float defaultValueForFloat;

    @JsonProperty(defaultValue = "13.37d")
    double defaultValueForDouble;
  }

  @Test
  @DisplayName("JsonProperty default value should take precedence over Default annotation")
  void precedence() {
    assertThat(JsonSchema.from(ClassInTest.class).getProperties())
        .extracting("precedence._default")
        .asInstanceOf(InstanceOfAssertFactories.type(JsonNode.class))
        .extracting(JsonNode::asText)
        .isEqualTo("precedence-from-json-property");
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
        .isInstanceOf(LongNode.class)
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
        .isInstanceOf(DoubleNode.class)
        .extracting(JsonNode::asDouble)
        .isEqualTo(13.37);
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
}
