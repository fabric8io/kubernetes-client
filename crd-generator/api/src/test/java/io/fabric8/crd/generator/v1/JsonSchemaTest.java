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
package io.fabric8.crd.generator.v1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.fabric8.crd.example.annotated.Annotated;
import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.example.extraction.CollectionCyclicSchemaSwap;
import io.fabric8.crd.example.extraction.CyclicSchemaSwap;
import io.fabric8.crd.example.extraction.DeeplyNestedSchemaSwaps;
import io.fabric8.crd.example.extraction.Extraction;
import io.fabric8.crd.example.extraction.IncorrectExtraction;
import io.fabric8.crd.example.extraction.IncorrectExtraction2;
import io.fabric8.crd.example.extraction.MultipleSchemaSwaps;
import io.fabric8.crd.example.extraction.NestedSchemaSwap;
import io.fabric8.crd.example.json.ContainingJson;
import io.fabric8.crd.example.person.Person;
import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.kubernetes.api.model.AnyType;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRule;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseSpec;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.fabric8.crd.generator.CRDGenerator.YAML_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonSchemaTest {

  @Test
  void shouldCreateAnyTypeWithoutProperties() {
    JSONSchemaProps schema = JsonSchema.from(AnyType.class);
    assertSchemaHasNumberOfProperties(schema, 0);
    assertTrue(schema.getXKubernetesPreserveUnknownFields());
  }

  @Test
  void shouldCreateJsonSchemaFromClass() {
    JSONSchemaProps schema = JsonSchema.from(Person.class);
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

    schema = JsonSchema.from(Basic.class);
    assertNotNull(schema);
    properties = schema.getProperties();
    assertNotNull(properties);
    assertEquals(2, properties.size());
    Map<String, JSONSchemaProps> spec = properties.get("spec").getProperties();
    assertEquals("integer", spec.get("myInt").getType());
    assertEquals("integer", spec.get("myLong").getType());
    assertEquals("number", spec.get("myDouble").getType());
    assertEquals("number", spec.get("myFloat").getType());
    Map<String, JSONSchemaProps> status = properties.get("status").getProperties();
    assertEquals("string", status.get("message").getType());
  }

  @Test
  void shouldAugmentPropertiesSchemaFromAnnotations() throws JsonProcessingException {
    JSONSchemaProps schema = JsonSchema.from(Annotated.class);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    final JSONSchemaProps specSchema = properties.get("spec");
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(specSchema, 15);

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
    assertNull(min.getDefault());
    assertEquals(-5.0, min.getMinimum());
    assertNull(min.getMaximum());
    assertNull(min.getPattern());
    assertNull(min.getNullable());

    final JSONSchemaProps max = spec.get("max");
    assertNull(max.getDefault());
    assertEquals(5.0, max.getMaximum());
    assertNull(max.getMinimum());
    assertNull(max.getPattern());
    assertNull(max.getNullable());

    final JSONSchemaProps pattern = spec.get("singleDigit");
    assertNull(pattern.getDefault());
    assertEquals("\\b[1-9]\\b", pattern.getPattern());
    assertNull(pattern.getMinimum());
    assertNull(pattern.getMaximum());
    assertNull(pattern.getNullable());

    final JSONSchemaProps nullable = spec.get("nullable");
    assertNull(nullable.getDefault());
    assertTrue(nullable.getNullable());
    assertNull(nullable.getMinimum());
    assertNull(nullable.getMaximum());
    assertNull(nullable.getPattern());

    final JSONSchemaProps defaultValue = spec.get("defaultValue");
    assertEquals("my-value", YAML_MAPPER.writeValueAsString(defaultValue.getDefault()).trim());
    assertNull(defaultValue.getNullable());
    assertNull(defaultValue.getMinimum());
    assertNull(defaultValue.getMaximum());
    assertNull(defaultValue.getPattern());

    final JSONSchemaProps defaultValue2 = spec.get("defaultValue2");
    assertEquals("my-value2", YAML_MAPPER.writeValueAsString(defaultValue2.getDefault()).trim());
    assertNull(defaultValue2.getNullable());
    assertNull(defaultValue2.getMinimum());
    assertNull(defaultValue2.getMaximum());
    assertNull(defaultValue2.getPattern());

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

    final JSONSchemaProps k8sValidationProps = spec.get("kubernetesValidationRule");
    final List<ValidationRule> k8sValidationRulesSingle = k8sValidationProps.getXKubernetesValidations();
    assertNotNull(k8sValidationRulesSingle);
    assertEquals(1, k8sValidationRulesSingle.size());
    assertEquals("self.startwith('prefix-')", k8sValidationRulesSingle.get(0).getRule());
    assertEquals("kubernetesValidationRule must start with prefix 'prefix-'", k8sValidationRulesSingle.get(0).getMessage());
    assertNull(k8sValidationRulesSingle.get(0).getMessageExpression());
    assertNull(k8sValidationRulesSingle.get(0).getReason());
    assertNull(k8sValidationRulesSingle.get(0).getFieldPath());
    assertNull(k8sValidationRulesSingle.get(0).getOptionalOldSelf());

    final JSONSchemaProps kubernetesValidationsRepeated = spec.get("kubernetesValidationRules");
    final List<ValidationRule> kubernetesValidationsRepeatedRules = kubernetesValidationsRepeated.getXKubernetesValidations();
    assertNotNull(kubernetesValidationsRepeatedRules);
    assertEquals(3, kubernetesValidationsRepeatedRules.size());
    assertEquals("first.rule", kubernetesValidationsRepeatedRules.get(0).getRule());
    assertNull(kubernetesValidationsRepeatedRules.get(0).getFieldPath());
    assertNull(kubernetesValidationsRepeatedRules.get(0).getReason());
    assertNull(kubernetesValidationsRepeatedRules.get(0).getMessage());
    assertNull(kubernetesValidationsRepeatedRules.get(0).getMessageExpression());
    assertNull(kubernetesValidationsRepeatedRules.get(0).getOptionalOldSelf());
    assertEquals("second.rule", kubernetesValidationsRepeatedRules.get(1).getRule());
    assertNull(kubernetesValidationsRepeatedRules.get(1).getFieldPath());
    assertNull(kubernetesValidationsRepeatedRules.get(1).getReason());
    assertNull(kubernetesValidationsRepeatedRules.get(1).getMessage());
    assertNull(kubernetesValidationsRepeatedRules.get(1).getMessageExpression());
    assertNull(kubernetesValidationsRepeatedRules.get(1).getOptionalOldSelf());
  }

  @Test
  void shouldProduceKubernetesPreserveFields() {
    JSONSchemaProps schema = JsonSchema.from(ContainingJson.class);
    assertNotNull(schema);
    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    final JSONSchemaProps specSchema = properties.get("spec");
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(specSchema, 3);

    // check preserve unknown fields is present
    assertTrue(spec.containsKey("free"));
    JSONSchemaProps freeField = spec.get("free");

    assertNull(freeField.getType());
    assertTrue(freeField.getXKubernetesPreserveUnknownFields());

    assertTrue(spec.containsKey("field"));
    JSONSchemaProps field = spec.get("field");

    assertEquals("integer", field.getType());
    assertNull(field.getXKubernetesPreserveUnknownFields());

    assertTrue(spec.containsKey("foo"));
    JSONSchemaProps fooField = spec.get("foo");

    assertEquals("object", fooField.getType());
    assertTrue(fooField.getXKubernetesPreserveUnknownFields());
  }

  @Test
  void shouldExtractPropertiesSchemaFromExtractValueAnnotation() {
    JSONSchemaProps schema = JsonSchema.from(Extraction.class);
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
    JSONSchemaProps schema = JsonSchema.from(MultipleSchemaSwaps.class);
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
    JSONSchemaProps schema = JsonSchema.from(DeeplyNestedSchemaSwaps.class);
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
  void shouldApplyCyclicSchemaSwaps() {
    JSONSchemaProps schema = JsonSchema.from(CyclicSchemaSwap.class);
    assertNotNull(schema);

    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(properties.get("spec"), 3);

    // the collection should emit a single level then terminate with void
    assertNull(spec.get("roots").getItems().getSchema().getProperties().get("level").getProperties().get("level"));

    assertPropertyHasType(spec.get("myObject"), "value", "integer");

    // the field should emit a single level then terminate with void
    assertNull(spec.get("root").getProperties().get("level").getProperties().get("level"));
  }

  public static class PreserveUnknown {

    @JsonIgnore
    private Map<String, Object> values = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.values;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.values.put(name, value);
    }

    public Map<String, Object> getValues() {
      return values;
    }

    public void setValues(Map<String, Object> values) {
      this.values = values;
    }

  }

  @Test
  void testPreserveUnknown() {
    JSONSchemaProps schema = JsonSchema.from(PreserveUnknown.class);
    assertNotNull(schema);
    assertEquals(0, schema.getProperties().size());
    assertEquals(Boolean.TRUE, schema.getXKubernetesPreserveUnknownFields());
  }

  // implicitly uses AnySchema
  private static class MySerializer extends StdSerializer<Object> {

    public MySerializer() {
      super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {

    }

  }

  public static class AnyTestTypes {
    @JsonSerialize(using = MySerializer.class)
    public Object value;
    public Node nodeValue;
  }

  @Test
  void testAnySchemaTypes() {
    JSONSchemaProps schema = JsonSchema.from(AnyTestTypes.class);
    assertNotNull(schema);
    assertNull(schema.getProperties().get("nodeValue").getType());
    assertEquals(Boolean.TRUE, schema.getProperties().get("nodeValue").getXKubernetesPreserveUnknownFields());
    assertEquals(Boolean.TRUE, schema.getProperties().get("value").getXKubernetesPreserveUnknownFields());
  }

  @Test
  void testLeaseSpec() {
    JSONSchemaProps schema = JsonSchema.from(LeaseSpec.class);
    assertNotNull(schema);
    JSONSchemaProps renewTime = schema.getProperties().get("renewTime");
    assertEquals("string", renewTime.getType());
    assertEquals("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", renewTime.getPattern());
    assertEquals("date-time", renewTime.getFormat());
  }

  @Test
  void testServicePort() {
    JSONSchemaProps schema = JsonSchema.from(ServicePort.class);
    assertNotNull(schema);
    JSONSchemaProps targetPort = schema.getProperties().get("targetPort");
    assertEquals(2, targetPort.getAnyOf().size());
    assertEquals(true, targetPort.getXKubernetesIntOrString());
  }

  private static class MapProperty {

    public Map<Long, Boolean> map;

  }

  @Test
  void testMapProperty() {
    JSONSchemaProps schema = JsonSchema.from(MapProperty.class);
    assertNotNull(schema);
    JSONSchemaProps map = schema.getProperties().get("map");
    assertTrue(map.getProperties().isEmpty());
    assertEquals("boolean", map.getAdditionalProperties().getSchema().getType());
  }

  private static class Cyclic1 {

    public Cyclic1 parent;

  }

  private static class Cyclic2 {

    public Cyclic2 parent[];

  }

  private static class Cyclic3 {

    public Map<String, Cyclic3> parent;

  }

  @Test
  void testCyclicProperties() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(Cyclic1.class));
    assertEquals("Found a cyclic reference involving the field of type io.fabric8.crd.generator.v1.JsonSchemaTest$Cyclic1 starting a field parent >>\n"
        + "io.fabric8.crd.generator.v1.JsonSchemaTest$Cyclic1.parent", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(Cyclic2.class));
    assertEquals("Found a cyclic reference involving the field of type io.fabric8.crd.generator.v1.JsonSchemaTest$Cyclic2 starting a field parent >>\n"
        + "io.fabric8.crd.generator.v1.JsonSchemaTest$Cyclic2.parent", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(Cyclic3.class));
    assertEquals("Found a cyclic reference involving the field of type io.fabric8.crd.generator.v1.JsonSchemaTest$Cyclic3 starting a field parent >>\n"
        + "io.fabric8.crd.generator.v1.JsonSchemaTest$Cyclic3.parent", exception.getMessage());
  }

  @SchemaSwap(originalType = Cyclic3.class, fieldName = "parent")
  private static class Cyclic4 {

    public Cyclic3 parent;
    public int value;

  }

  @Test
  void testSchemaSwapZeroDepth() {
    JSONSchemaProps schema = JsonSchema.from(Cyclic4.class);
    assertNotNull(schema);
    JSONSchemaProps parent = schema.getProperties().get("parent");
    assertTrue(parent.getProperties().isEmpty());
  }

  @Test
  void shouldApplyCollectionCyclicSchemaSwaps() {
    JSONSchemaProps schema = JsonSchema.from(CollectionCyclicSchemaSwap.class);
    assertNotNull(schema);

    Map<String, JSONSchemaProps> properties = assertSchemaHasNumberOfProperties(schema, 2);
    Map<String, JSONSchemaProps> spec = assertSchemaHasNumberOfProperties(properties.get("spec"), 2);

    assertPropertyHasType(spec.get("myObject"), "value", "integer");
    Map<String, JSONSchemaProps> level1 = assertSchemaHasNumberOfProperties(spec.get("levels").getItems().getSchema(), 2);

    assertPropertyHasType(level1.get("myObject"), "value", "integer");
    Map<String, JSONSchemaProps> level2 = assertSchemaHasNumberOfProperties(level1.get("levels").getItems().getSchema(), 2);

    assertPropertyHasType(level2.get("myObject"), "value", "integer");
    Map<String, JSONSchemaProps> level3 = assertSchemaHasNumberOfProperties(level2.get("levels").getItems().getSchema(), 2);

    assertPropertyHasType(level3.get("myObject"), "value", "integer");
    // should terminate at the 3rd level with any - this is probably not quite the behavior we want
    // targeting collection properties with a non-collection terminal seems problematic
    JSONSchemaProps terminal = level3.get("levels");
    assertNull(terminal.getItems());
    assertTrue(terminal.getXKubernetesPreserveUnknownFields());
    assertSchemaHasNumberOfProperties(terminal, 0);
  }

  @Test
  void shouldThrowIfSchemaSwapHasUnmatchedField() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(IncorrectExtraction.class));
    assertEquals(
        "Unmatched SchemaSwaps: @SchemaSwap(originalType=io.fabric8.crd.example.extraction.ExtractionSpec, fieldName=\"FOO\", targetType=io"
            + ".fabric8.crd.example.extraction.FooExtractor) on io.fabric8.crd.example.extraction.IncorrectExtraction",
        exception.getMessage());
  }

  @Test
  void shouldThrowIfSchemaSwapHasUnmatchedClass() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(IncorrectExtraction2.class));
    assertEquals(
        "Unmatched SchemaSwaps: @SchemaSwap(originalType=io.fabric8.crd.example.basic.BasicSpec, fieldName=\"bar\", targetType=io.fabric8.crd"
            + ".example.extraction.FooExtractor) on io.fabric8.crd.example.extraction.IncorrectExtraction2",
        exception.getMessage());
  }

  @Test
  void shouldThrowIfSchemaSwapNested() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> JsonSchema.from(NestedSchemaSwap.class));
    assertEquals(
        "Nested SchemaSwap: @SchemaSwap(originalType=io.fabric8.crd.example.extraction.NestedSchemaSwap$End, fieldName=\"value\", targetType=java.lang.Void) "
            + "on io.fabric8.crd.example.extraction.NestedSchemaSwap$Intermediate",
        exception.getMessage());
  }

  @io.fabric8.generator.annotation.ValidationRule(value = "base", messageExpression = "something", reason = "FieldValueForbidden")
  private static class Base {
    public String value;
  }

  @io.fabric8.generator.annotation.ValidationRule(value = "parent", messageExpression = "something else", reason = "FieldValueForbidden")
  private static class Parent extends Base {

  }

  @Test
  void testValidationRuleHierarchy() {
    JSONSchemaProps schema = JsonSchema.from(Parent.class);
    assertNotNull(schema);
    assertEquals(2, schema.getXKubernetesValidations().size());
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
