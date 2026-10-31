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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The API server prunes whatever a structural schema doesn't describe, so content the generator can't fully describe
 * has to be marked with {@code x-kubernetes-preserve-unknown-fields}. The API server behavior is verified in
 * crd-generator-test's GeneratedCRDsOnApiServerTest.
 */
class PreservedContentTest {

  @Nested
  @DisplayName("Free-form values")
  class FreeForm {

    private final Map<String, JSONSchemaProps> properties = JsonSchema.from(FreeFormSpec.class).getProperties();

    @Test
    @DisplayName("An Object property accepts any JSON value, not only objects")
    void objectProperty() {
      assertAcceptsAnyValue(properties.get("any"));
    }

    @Test
    @DisplayName("An Optional<Object> property accepts any JSON value")
    void optionalObjectProperty() {
      assertAcceptsAnyValue(properties.get("optionalAny"));
    }

    @Test
    @DisplayName("A List<Object> is an array whose items accept any JSON value")
    void objectList() {
      assertThat(properties.get("anyList").getType()).isEqualTo("array");
      assertAcceptsAnyValue(properties.get("anyList").getItems().getSchema());
    }

    @Test
    @DisplayName("A raw List is an array whose items accept any JSON value")
    void rawList() {
      assertThat(properties.get("rawList").getType()).isEqualTo("array");
      assertAcceptsAnyValue(properties.get("rawList").getItems().getSchema());
    }

    @Test
    @DisplayName("A raw Set is an array whose items accept any JSON value")
    void rawSet() {
      assertThat(properties.get("rawSet").getType()).isEqualTo("array");
      assertAcceptsAnyValue(properties.get("rawSet").getItems().getSchema());
    }

    @Test
    @DisplayName("An Object property declared after one with @JsonSerialize(as) still accepts any JSON value")
    void objectPropertyAfterSerializedAs() {
      assertAcceptsAnyValue(JsonSchema.from(SerializedAsFirstSpec.class).getProperties().get("plain"));
    }

    @Test
    @DisplayName("An Object property with @JsonSerialize(as) gets that type's schema, whatever precedes it")
    void objectSerializedAsPojo() {
      assertDescribes(JsonSchema.from(SerializedAsFirstSpec.class).getProperties().get("serializedAs"), "name");
      assertDescribes(JsonSchema.from(SerializedAsLastSpec.class).getProperties().get("serializedAs"), "name");
      assertDescribes(JsonSchema.from(SerializedAsLastSpec.class).getProperties().get("serializedAsOther"), "count");
    }

    @Test
    @DisplayName("Object properties with @JsonSerialize(as) can be nested without a false cyclic reference")
    void nestedSerializedAs() {
      final JSONSchemaProps outer = JsonSchema.from(NestedSerializedAsSpec.class).getProperties().get("outer");
      assertDescribes(outer, "inner");
      assertDescribes(outer.getProperties().get("inner"), "name");
    }
  }

  @Nested
  @DisplayName("Optional properties")
  class Optionals {

    private final Map<String, JSONSchemaProps> properties = JsonSchema.from(OptionalsSpec.class).getProperties();

    @Test
    @DisplayName("An Optional<Map> gets the map's schema")
    void optionalMap() {
      assertThat(properties.get("labels"))
          .returns("object", JSONSchemaProps::getType)
          .extracting(p -> p.getAdditionalProperties().getSchema().getType())
          .isEqualTo("string");
    }

    @Test
    @DisplayName("Nested Optional properties are not mistaken for a cyclic reference")
    void nestedOptionals() {
      assertThat(properties.get("outer").getProperties().get("inner").getProperties())
          .containsOnlyKeys("name");
    }
  }

  @Nested
  @DisplayName("Polymorphic values keep their subtype content")
  class Polymorphic {

    private final Map<String, JSONSchemaProps> properties = JsonSchema.from(PolymorphicSpec.class).getProperties();

    @Test
    @DisplayName("A base type with only @JsonTypeInfo preserves unknown fields")
    void typeInfoOnly() {
      assertPreservesSubtypeContent(properties.get("typeInfoOnly"));
    }

    @Test
    @DisplayName("A base type with only @JsonSubTypes preserves unknown fields")
    void subTypesOnly() {
      assertPreservesSubtypeContent(properties.get("subTypesOnly"));
    }

    @Test
    @DisplayName("A concrete type inheriting @JsonTypeInfo from an interface preserves the type id Jackson writes")
    void inheritedFromInterface() {
      assertPreservesSubtypeContent(properties.get("dog"));
    }

    @Test
    @DisplayName("@JsonTypeInfo on a property preserves unknown fields on its value")
    void propertyLevel() {
      assertPreservesSubtypeContent(properties.get("pet"));
    }

    @Test
    @DisplayName("@JsonTypeInfo on a field with a getter preserves unknown fields on its value")
    void propertyLevelOnFieldWithGetter() {
      assertPreservesSubtypeContent(properties.get("fieldAnnotatedPet"));
    }

    @Test
    @DisplayName("@JsonTypeInfo on a List property preserves unknown fields on its items")
    void propertyLevelOnList() {
      assertThat(properties.get("pets").getXKubernetesPreserveUnknownFields()).isNull();
      assertPreservesSubtypeContent(properties.get("pets").getItems().getSchema());
    }

    @Test
    @DisplayName("@JsonTypeInfo on a Map property preserves unknown fields on its values")
    void propertyLevelOnMap() {
      assertThat(properties.get("petsByName").getXKubernetesPreserveUnknownFields()).isNull();
      assertPreservesSubtypeContent(properties.get("petsByName").getAdditionalProperties().getSchema());
    }

    @Test
    @DisplayName("A subtype opting out with @JsonTypeInfo(use = NONE) prunes unknown fields")
    void optOutOnSubtype() {
      assertThat(properties.get("optedOut").getXKubernetesPreserveUnknownFields()).isNull();
    }

    @Test
    @DisplayName("A property opting out with @JsonTypeInfo(use = NONE) prunes unknown fields despite its type's")
    void optOutOnProperty() {
      assertThat(properties.get("optedOutProperty").getXKubernetesPreserveUnknownFields()).isNull();
    }

    @Test
    @DisplayName("A type without polymorphic annotations prunes unknown fields")
    void notPolymorphic() {
      assertThat(properties.get("plainPet").getXKubernetesPreserveUnknownFields()).isNull();
    }
  }

  private static void assertAcceptsAnyValue(JSONSchemaProps schema) {
    assertThat(schema)
        .returns(null, JSONSchemaProps::getType)
        .returns(true, JSONSchemaProps::getXKubernetesPreserveUnknownFields);
  }

  private static void assertDescribes(JSONSchemaProps schema, String... properties) {
    assertThat(schema)
        .returns("object", JSONSchemaProps::getType)
        .returns(null, JSONSchemaProps::getXKubernetesPreserveUnknownFields)
        .extracting(JSONSchemaProps::getProperties)
        .satisfies(p -> assertThat(p).containsOnlyKeys(properties));
  }

  private static void assertPreservesSubtypeContent(JSONSchemaProps schema) {
    assertThat(schema)
        .returns("object", JSONSchemaProps::getType)
        .returns(true, JSONSchemaProps::getXKubernetesPreserveUnknownFields)
        .extracting(JSONSchemaProps::getProperties)
        .satisfies(p -> assertThat(p).containsKey("name"));
  }

  @SuppressWarnings("rawtypes")
  public static class FreeFormSpec {
    public Object any;
    public Optional<Object> optionalAny;
    public List<Object> anyList;
    public List rawList;
    public Set rawSet;
  }

  /**
   * jackson-module-jsonSchema builds one schema per declared type and reuses it for every later property of that type,
   * so the order of Object properties decides which schema they share.
   */
  public static class SerializedAsFirstSpec {
    @JsonSerialize(as = Named.class)
    public Object serializedAs;
    public Object plain;
  }

  public static class SerializedAsLastSpec {
    public Object plain;
    @JsonSerialize(as = Named.class)
    public Object serializedAs;
    @JsonSerialize(as = Counted.class)
    public Object serializedAsOther;
  }

  public static class NestedSerializedAsSpec {
    @JsonSerialize(as = SerializedAsHolder.class)
    public Object outer;
  }

  public static class SerializedAsHolder {
    @JsonSerialize(as = Named.class)
    public Object inner;
  }

  public static class Counted {
    public int count;
  }

  public static class OptionalsSpec {
    public Optional<Map<String, String>> labels;
    public Optional<Outer> outer;
  }

  public static class Outer {
    public Optional<Named> inner;
  }

  public static class Named {
    public String name;
  }

  public static class PolymorphicSpec {
    public TypeInfoOnly typeInfoOnly;
    public SubTypesOnly subTypesOnly;
    public Dog dog;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes(@JsonSubTypes.Type(value = Cat.class, name = "cat"))
    public Pet pet;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes(@JsonSubTypes.Type(value = Cat.class, name = "cat"))
    private Pet fieldAnnotatedPet;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes(@JsonSubTypes.Type(value = Cat.class, name = "cat"))
    public List<Pet> pets;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes(@JsonSubTypes.Type(value = Cat.class, name = "cat"))
    public Map<String, Pet> petsByName;
    public OptedOut optedOut;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
    public TypeInfoOnly optedOutProperty;
    public Pet plainPet;

    public Pet getFieldAnnotatedPet() {
      return fieldAnnotatedPet;
    }

    public void setFieldAnnotatedPet(Pet fieldAnnotatedPet) {
      this.fieldAnnotatedPet = fieldAnnotatedPet;
    }
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
  public static class TypeInfoOnly {
    public String name;
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
  public static class OptedOut extends TypeInfoOnly {
    public int extra;
  }

  @JsonSubTypes(@JsonSubTypes.Type(value = SubTypesOnlyImpl.class, name = "impl"))
  public static class SubTypesOnly {
    public String name;
  }

  public static class SubTypesOnlyImpl extends SubTypesOnly {
    public int extra;
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
  @JsonSubTypes(@JsonSubTypes.Type(value = Dog.class, name = "dog"))
  public interface Animal {
  }

  public static class Dog implements Animal {
    public String name;
  }

  public static class Pet {
    public String name;
  }

  public static class Cat extends Pet {
    public int lives;
  }
}
