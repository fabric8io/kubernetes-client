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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JsonUnwrappedDeserializerTest {

  private static final String EXPECTED_VALUE_A = "Value A";
  private static final String EXPECTED_VALUE_B = "Value B";
  private static final String EXPECTED_VALUE_C = "Value C";

  private ObjectMapper mapper;

  @BeforeEach
  void initMapper() {
    mapper = new ObjectMapper();
  }

  @Nested
  class Deserialize {

    @Test
    @DisplayName("Single @JsonUnwrapped polymorphic type")
    void singleInterfaceWithJsonWrapped() throws JsonProcessingException {
      RootClass instance = mapper.readValue("{ \"stringField\": \"" + EXPECTED_VALUE_A + "\", "
          + "\"extendedField\": \"" + EXPECTED_VALUE_B + "\", "
          + "\"nestedField\": \"" + EXPECTED_VALUE_C + "\" }", RootClass.class);
      // Verify normal fields works along to the json-wrapped fields
      assertEquals(EXPECTED_VALUE_A, instance.stringField);

      // Verify interfaces are supported at root level
      assertNotNull(instance.rootInterface, "Interface was not deserialized!");
      assertInstanceOf(RootImplementation.class, instance.rootInterface);
      RootImplementation rootImplementation = ((RootImplementation) instance.rootInterface);
      assertEquals(EXPECTED_VALUE_B, rootImplementation.extendedField);

      // Verify nested interfaces are also supported
      assertInstanceOf(NestedImplementation.class, rootImplementation.nestedInterface);
      assertEquals(EXPECTED_VALUE_C, ((NestedImplementation) rootImplementation.nestedInterface).nestedField);
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

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootClass {

    private String stringField;

    @JsonUnwrapped
    private RootInterface rootInterface;

    public RootClass() {

    }

    public String getStringField() {
      return stringField;
    }

    public void setStringField(String stringField) {
      this.stringField = stringField;
    }

    public RootInterface getRootInterface() {
      return rootInterface;
    }

    public void setRootInterface(RootInterface rootInterface) {
      this.rootInterface = rootInterface;
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(RootImplementation.class))
  @JsonTypeInfo(use = DEDUCTION)
  interface RootInterface {

  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootImplementation implements RootInterface {

    private String extendedField;
    @JsonUnwrapped
    private NestedInterface nestedInterface;

    public RootImplementation() {

    }

    public String getExtendedField() {
      return extendedField;
    }

    public void setExtendedField(String extendedField) {
      this.extendedField = extendedField;
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(NestedImplementation.class))
  @JsonTypeInfo(use = DEDUCTION)
  interface NestedInterface {

  }

  public static class NestedImplementation implements NestedInterface {
    private String nestedField;

    public NestedImplementation() {

    }

    public String getNestedField() {
      return nestedField;
    }

    public void setNestedField(String nestedField) {
      this.nestedField = nestedField;
    }
  }
}
