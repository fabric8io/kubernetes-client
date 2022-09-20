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
package io.fabric8.crd.generator.v1;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.crd.example.annotated.Annotated;
import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.example.extraction.DeeplyNestedSchemaSwaps;
import io.fabric8.crd.example.extraction.Extraction;
import io.fabric8.crd.example.extraction.IncorrectExtraction;
import io.fabric8.crd.example.extraction.IncorrectExtraction2;
import io.fabric8.crd.example.extraction.MultipleSchemaSwaps;
import io.fabric8.crd.example.json.ContainingJson;
import io.fabric8.crd.example.person.Person;
import io.fabric8.crd.generator.utils.Types;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.sundr.model.TypeDef;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class JsonSchemaTest {

  @Test
  void shouldCreateJsonSchemaFromClass() {
    TypeDef person = Types.typeDefFrom(Person.class);
    JSONSchemaProps schema = JsonSchema.from(person);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 7);
    final List<String> personTypes = properties.get("type").getEnum().stream().map(JsonNode::asText)
        .collect(Collectors.toList());
    assertEquals(2, personTypes.size());
    assertTrue(personTypes.contains("crazy"));
    assertTrue(personTypes.contains("crazier"));
    final Map<String, JSONSchemaProps> addressProperties = properties.get("addresses").getItems()
        .getSchema().getProperties();
    assertEquals(5, addressProperties.size());
    final List<String> addressTypes = addressProperties.get("type").getEnum().stream()
        .map(JsonNode::asText)
        .collect(Collectors.toList());
    assertEquals(2, addressTypes.size());
    assertTrue(addressTypes.contains("home"));
    assertTrue(addressTypes.contains("work"));

    final TypeDef def = Types.typeDefFrom(Basic.class);
    schema = JsonSchema.from(def);
    assertNotNull(schema);
    properties = schema.getProperties();
    assertNotNull(properties);
    assertEquals(2, properties.size());
    Map<String, JSONSchemaProps> spec = properties.get("spec").getProperties();
    assertEquals("integer", spec.get("myInt").getType());
    assertEquals("integer", spec.get("myLong").getType());
    Map<String, JSONSchemaProps> status = properties.get("status").getProperties();
    assertEquals("string", status.get("message").getType());
  }

  @Test
  void shouldAugmentPropertiesSchemaFromAnnotations() {
    TypeDef annotated = Types.typeDefFrom(Annotated.class);
    JSONSchemaProps schema = JsonSchema.from(annotated);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    final JSONSchemaProps specSchema = properties.get("spec");
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(specSchema, 11);

    // check descriptions are present
    assertTrue(spec.containsKey("from-field"));
    JSONSchemaProps prop = spec.get("from-field");
    assertEquals("from-field-description", prop.getDescription());
    assertTrue(spec.containsKey("from-getter"));
    prop = spec.get("from-getter");
    assertEquals("from-getter-description", prop.getDescription());

    // fields without description annotation shouldn't have them
    assertTrue(spec.containsKey("unnamed"));
    assertNull(spec.get("unnamed").getDescription());
    assertTrue(spec.containsKey("emptySetter"));
    assertNull(spec.get("emptySetter").getDescription());
    assertTrue(spec.containsKey("anEnum"));

    final JSONSchemaProps min = spec.get("min");
    assertEquals(-5.0, min.getMinimum());
    assertNull(min.getMaximum());
    assertNull(min.getPattern());
    assertNull(min.getNullable());

    final JSONSchemaProps max = spec.get("max");
    assertEquals(5.0, max.getMaximum());
    assertNull(max.getMinimum());
    assertNull(max.getPattern());
    assertNull(max.getNullable());

    final JSONSchemaProps pattern = spec.get("singleDigit");
    assertEquals("\\b[1-9]\\b", pattern.getPattern());
    assertNull(pattern.getMinimum());
    assertNull(pattern.getMaximum());
    assertNull(pattern.getNullable());

    final JSONSchemaProps nullable = spec.get("nullable");
    assertTrue(nullable.getNullable());
    assertNull(nullable.getMinimum());
    assertNull(nullable.getMaximum());
    assertNull(nullable.getPattern());

    // check required list, should register properties with their modified name if needed
    final List<String> required = specSchema.getRequired();
    assertEquals(3, required.size());
    assertTrue(required.contains("emptySetter"));
    assertTrue(required.contains("emptySetter2"));
    assertTrue(required.contains("from-getter"));

    // check the enum values
    final JSONSchemaProps anEnum = spec.get("anEnum");
    final List<JsonNode> enumValues = anEnum.getEnum();
    assertEquals(2, enumValues.size());
    enumValues.stream().map(JsonNode::textValue).forEach(s -> assertTrue("oui".equals(s) || "non".equals(s)));

    // check ignored fields
    assertFalse(spec.containsKey("ignoredFoo"));
    assertFalse(spec.containsKey("ignoredBar"));
  }

  @Test
  void shouldProduceKubernetesPreserveFields() {
    TypeDef containingJson = Types.typeDefFrom(ContainingJson.class);
    JSONSchemaProps schema = JsonSchema.from(containingJson);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    final JSONSchemaProps specSchema = properties.get("spec");
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(specSchema, 3);

    // check preserve unknown fields is present
    assertTrue(spec.containsKey("free"));
    JSONSchemaProps freeField = spec.get("free");

    assertTrue(freeField.getXKubernetesPreserveUnknownFields());

    assertTrue(spec.containsKey("field"));
    JSONSchemaProps field = spec.get("field");

    assertNull(field.getXKubernetesPreserveUnknownFields());

    assertTrue(spec.containsKey("foo"));
    JSONSchemaProps fooField = spec.get("foo");

    assertTrue(fooField.getXKubernetesPreserveUnknownFields());
  }

  @Test
  void shouldExtractPropertiesSchemaFromExtractValueAnnotation() {
    TypeDef extraction = Types.typeDefFrom(Extraction.class);
    JSONSchemaProps schema = JsonSchema.from(extraction);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    final JSONSchemaProps specSchema = properties.get("spec");
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(specSchema, 2);

    // check typed SchemaFrom
    JSONSchemaProps foo = spec.get("foo");
    Map<String, JSONSchemaProps> fooProps = foo.getProperties();
    assertNotNull(fooProps);

    // you can change everything
    assertEquals("integer", fooProps.get("BAZ").getType());
    assertTrue(foo.getRequired().contains("BAZ"));

    // you can exclude fields
    assertNull(fooProps.get("baz"));

    // check typed SchemaSwap
    JSONSchemaProps bar = spec.get("bar");
    Map<String, JSONSchemaProps> barProps = bar.getProperties();
    assertNotNull(barProps);
    assertTrue(bar.getXKubernetesPreserveUnknownFields());

    // you can change everything
    assertEquals("integer", barProps.get("BAZ").getType());
    assertTrue(bar.getRequired().contains("BAZ"));

    // you can exclude fields
    assertNull(barProps.get("baz"));
  }

  @Test
  void shouldExtractPropertiesSchemaFromSchemaSwapAnnotations() {
    TypeDef extraction = Types.typeDefFrom(MultipleSchemaSwaps.class);
    JSONSchemaProps schema = JsonSchema.from(extraction);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    final JSONSchemaProps specSchema = properties.get("spec");
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(specSchema, 4);

    // 'first' is replaced by SchemaSwap from int to string
    JSONSchemaProps first = spec.get("first");
    assertPropertyHasType(first, "shouldBeString", "string");

    // 'second' is replaced by the same SchemaSwap that is applied multiple times
    JSONSchemaProps second = spec.get("second");
    assertPropertyHasType(second, "shouldBeString", "string");

    // 'third' is replaced by another SchemaSwap
    JSONSchemaProps third = spec.get("third");
    assertPropertyHasType(third, "shouldBeInt", "integer");

    // 'fourth' is replaced by another SchemaSwap and its property deleted
    JSONSchemaProps fourth = spec.get("fourth");
    Map<String, JSONSchemaProps> properties4 = fourth.getProperties();
    assertNotNull(properties);
    assertTrue(properties4.isEmpty());
  }

  @Test
  void shouldApplySchemaSwapsMultipleTimesInDeepClassHierarchy() {
    TypeDef extraction = Types.typeDefFrom(DeeplyNestedSchemaSwaps.class);
    JSONSchemaProps schema = JsonSchema.from(extraction);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(properties.get("spec"), 2);

    assertPropertyHasType(spec.get("myObject"), "shouldBeString", "string");
    Map<String, JSONSchemaProps> level1 = assertSchemaHasNumberOfProperties(spec.get("level1"), 3);

    assertPropertyHasType(level1.get("myObject"), "shouldBeString", "string");
    List<Map<String, JSONSchemaProps>> levels2 = new ArrayList<>();
    levels2.add(assertSchemaHasNumberOfProperties(level1.get("level2a"), 3));
    levels2.add(assertSchemaHasNumberOfProperties(level1.get("level2b"), 3));

    for (Map<String, JSONSchemaProps> level2 : levels2) {
      assertPropertyHasType(level2.get("myObject1"), "shouldBeString", "string");
      assertPropertyHasType(level2.get("myObject2"), "shouldBeString", "string");

      Map<String, JSONSchemaProps> level3 = assertSchemaHasNumberOfProperties(level2.get("level3"), 2);
      assertPropertyHasType(level3.get("myObject1"), "shouldBeString", "string");
      assertPropertyHasType(level3.get("myObject2"), "shouldBeString", "string");
    }
  }

  @Test
  void shouldThrowIfSchemaSwapHasUnmatchedField() {
    TypeDef incorrectExtraction = Types.typeDefFrom(IncorrectExtraction.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(incorrectExtraction));
    assertEquals(
        "Unmatched SchemaSwaps: @SchemaSwap(originalType=io.fabric8.crd.example.extraction.ExtractionSpec, fieldName=\"FOO\", targetType=io"
            + ".fabric8.crd.example.extraction.FooExtractor) on io.fabric8.crd.example.extraction.IncorrectExtraction",
        exception.getMessage());
  }

  @Test
  void shouldThrowIfSchemaSwapHasUnmatchedClass() {
    TypeDef incorrectExtraction2 = Types.typeDefFrom(IncorrectExtraction2.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(incorrectExtraction2));
    assertEquals(
        "Unmatched SchemaSwaps: @SchemaSwap(originalType=io.fabric8.crd.example.basic.BasicSpec, fieldName=\"bar\", targetType=io.fabric8.crd"
            + ".example.extraction.FooExtractor) on io.fabric8.crd.example.extraction.IncorrectExtraction2",
        exception.getMessage());
  }

  private static Map<String, JSONSchemaProps> assertSchemaHasNumberOfProperties(JSONSchemaProps specSchema, int expected) {
    Map<String, JSONSchemaProps> spec = specSchema.getProperties();
    assertEquals(expected, spec.size());
    return spec;
  }

  private static void assertPropertyHasType(JSONSchemaProps spec, String name, String expectedType) {
    Map<String, JSONSchemaProps> properties = spec.getProperties();
    assertNotNull(properties);
    JSONSchemaProps property = properties.get(name);
    assertNotNull(property, "Property " + name + " should exist");
    assertEquals(expectedType, property.getType(), "Property " + name + " should have expected type");
  }
}
