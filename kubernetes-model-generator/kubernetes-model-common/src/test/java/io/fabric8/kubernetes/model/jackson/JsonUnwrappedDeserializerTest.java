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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NONE;
import static org.assertj.core.api.Assertions.assertThat;

class JsonUnwrappedDeserializerTest {

  private ObjectMapper mapper;

  @BeforeEach
  void initMapper() {
    mapper = new ObjectMapper();
  }

  @Nested
  class Deserialize {

    @Test
    @DisplayName("Single @JsonUnwrapped polymorphic type")
    void singleJsonWrappedPolymorphicField() throws JsonProcessingException {
      final RootClass result = mapper.readValue("{" +
          "\"stringField\": \"string-field-value\", " +
          "\"extendedField\": \"extended-field-value\", " +
          "\"nestedField\": \"nested-field-value\"" +
          "}", RootClass.class);
      assertThat(result)
          // Verify normal fields works along to the json-wrapped fields
          .hasFieldOrPropertyWithValue("stringField", "string-field-value")
          // Verify interfaces are supported at root level
          .extracting(RootClass::getRootInterface)
          .isNotNull()
          .asInstanceOf(InstanceOfAssertFactories.type(RootImplementation.class))
          .hasFieldOrPropertyWithValue("extendedField", "extended-field-value")
          // Verify nested interfaces are also supported
          .extracting(RootImplementation::getNestedInterface)
          .isNotNull()
          .asInstanceOf(InstanceOfAssertFactories.type(NestedImplementation.class))
          .hasFieldOrPropertyWithValue("nestedField", "nested-field-value");
    }

    @Test
    @DisplayName("Single @JsonUnwrapped polymorphic field with missing data")
    void singleJsonWrappedPolymorphicFieldWithMissingDataForUnwrapped() throws JsonProcessingException {
      final RootClass result = mapper.readValue("{" +
          "\"stringField\": \"string-field-value\"" +
          "}", RootClass.class);
      assertThat(result)
          // Verify normal fields works along to the json-wrapped fields
          .hasFieldOrPropertyWithValue("stringField", "string-field-value")
          // Verify interfaces are supported at root level
          .extracting(RootClass::getRootInterface)
          .isNull();
    }

    @Test
    @DisplayName("Multiple @JsonUnwrapped fields")
    void multipleJsonUnwrappedFields() throws JsonProcessingException {
      final MultipleJsonUnwrapped result = mapper.readValue("{" +
          "\"foo\": \"foo-value\"," +
          "\"bar\": \"bar-value\"," +
          "\"control\": \"pass\"" +
          "}", MultipleJsonUnwrapped.class);
      assertThat(result)
          .hasFieldOrPropertyWithValue("foo.foo", "foo-value")
          .hasFieldOrPropertyWithValue("bar.bar", "bar-value")
          .hasFieldOrPropertyWithValue("control", "pass");
    }

    @Test
    @DisplayName("Multiple polymorphic fields")
    void multiplePolymorphicFields() throws JsonProcessingException {
      final MultiplePolymorphicFields result = mapper.readValue("{" +
          "\"foo\": {\"foo\": \"foo-value\"}," +
          "\"bar\": {\"bar\": \"bar-value\"}," +
          "\"control\": \"pass\"" +
          "}", MultiplePolymorphicFields.class);
      assertThat(result)
          .hasFieldOrPropertyWithValue("foo.foo", "foo-value")
          .hasFieldOrPropertyWithValue("bar.bar", "bar-value")
          .hasFieldOrPropertyWithValue("control", "pass");
    }

    @Test
    @DisplayName("Multiple @JsonUnwrapped polymorphic fields")
    void multipleJsonUnwrappedPolymorphicFields() throws JsonProcessingException {
      final MultipleJsonUnwrappedPolymorphicFields result = mapper.readValue("{" +
          "\"foo\": \"foo-value\"," +
          "\"bar\": \"bar-value\"," +
          "\"control\": \"pass\"" +
          "}", MultipleJsonUnwrappedPolymorphicFields.class);
      assertThat(result)
          .hasFieldOrPropertyWithValue("foo.foo", "foo-value")
          .hasFieldOrPropertyWithValue("bar.bar", "bar-value")
          .hasFieldOrPropertyWithValue("control", "pass");
    }

  }

  @Data
  public static class MultipleJsonUnwrapped {
    @JsonUnwrapped
    private FooImpl foo;
    @JsonUnwrapped
    private BarImpl bar;
    private String control;
  }

  @Data
  public static class MultiplePolymorphicFields {
    private Foo foo;
    private Bar bar;
    private String control;
  }

  @Data
  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class MultipleJsonUnwrappedPolymorphicFields {
    @JsonUnwrapped
    private Foo foo;
    @JsonUnwrapped
    private Bar bar;
    private String control;
  }

  @JsonSubTypes(@JsonSubTypes.Type(FooImpl.class))
  @JsonTypeInfo(use = DEDUCTION)
  public interface Foo {
    String getFoo();
  }

  @JsonSubTypes(@JsonSubTypes.Type(BarImpl.class))
  @JsonTypeInfo(use = DEDUCTION)
  public interface Bar {
    String getBar();
  }

  @Data
  @NoArgsConstructor
  @JsonTypeInfo(use = NONE)
  public static class FooImpl implements Foo {
    private String foo;
  }

  @Data
  @NoArgsConstructor
  @JsonTypeInfo(use = NONE)
  public static class BarImpl implements Bar {
    private String bar;
  }

  @Data
  @NoArgsConstructor
  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootClass {

    private String stringField;

    @JsonUnwrapped
    private RootInterface rootInterface;

  }

  @JsonSubTypes(@JsonSubTypes.Type(RootImplementation.class))
  @JsonTypeInfo(use = DEDUCTION)
  interface RootInterface {

  }

  @Data
  @NoArgsConstructor
  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootImplementation implements RootInterface {

    private String extendedField;
    @JsonUnwrapped
    private NestedInterface nestedInterface;
  }

  @JsonSubTypes(@JsonSubTypes.Type(NestedImplementation.class))
  @JsonTypeInfo(use = DEDUCTION)
  interface NestedInterface {

  }

  @Data
  @NoArgsConstructor
  public static class NestedImplementation implements NestedInterface {
    private String nestedField;
  }
}
