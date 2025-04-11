package io.fabric8.crdv2.generator.v1;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.crdv2.example.jsonschema.JsonSchemaAnno;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonSchemaAnnotationTest {

  JSONSchemaProps schema;

  @BeforeEach
  void setup() {
    schema = JsonSchema.from(JsonSchemaAnno.class);
    assertNotNull(schema);
  }

  @Test
  void testCustomizedType() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("customizedType");
    assertEquals("string", target.getType());
  }

  @Test
  void testExternalDocumentation() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("documentedExternally");
    assertNull(target.getType()); // type not defined in @JSONSchema
    assertNotNull(target.getExternalDocs());
    assertEquals("https://example.com/docs.txt", target.getExternalDocs().getUrl());
  }

  @Test
  void testStrictArrayItemSchema() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("strictItems");
    assertEquals("array", target.getType());
    assertEquals(Boolean.FALSE, target.getAdditionalItems().getAllows());
    assertNotNull(target.getItems());
    JSONSchemaProps items = target.getItems().getSchema();
    assertEquals("object", items.getType());
    assertEquals(Boolean.FALSE, items.getAdditionalProperties().getAllows());
    assertTrue(items.getProperties().keySet().containsAll(List.of("field1", "field2")));
  }

  @Test
  void testLaxArrayItemSchema() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("laxItems");
    assertEquals("array", target.getType());
    assertEquals(Boolean.TRUE, target.getAdditionalItems().getAllows());
    assertNotNull(target.getItems());
    List<JSONSchemaProps> itemsSchemas = target.getItems().getJSONSchemas();
    assertEquals(2, itemsSchemas.size());
    assertTrue(itemsSchemas.stream().allMatch(s -> s.getProperties().keySet().containsAll(List.of("field1", "field2"))));

    assertEquals(Boolean.TRUE, itemsSchemas.get(0).getAdditionalProperties().getAllows());
    assertNull(itemsSchemas.get(0).getAdditionalProperties().getSchema());
    assertEquals(itemsSchemas.get(0), itemsSchemas.get(1).getAdditionalProperties().getSchema());
    assertNull(itemsSchemas.get(1).getAdditionalProperties().getAllows());
  }

  @Test
  void testOverriddenProperties() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("overriddenProperties");
    assertEquals("object", target.getType());
    assertEquals(Set.of("field3", "field4"), target.getProperties().keySet());
    assertEquals("Has properties that are replaced by referencing type", target.getDescription());
  }

  @Test
  void testObjectEnumerationWithDefault() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("objectEnumeration");
    ObjectNode expected1 = JsonNodeFactory.instance.objectNode().put("field1", "allowedValue1").put("field2", 1);
    ObjectNode expected2 = JsonNodeFactory.instance.objectNode().put("field1", "allowedValue2").put("field2", 2);
    assertEquals(expected1, target.getDefault());
    assertEquals(List.of(expected1, expected2), target.getEnum());
  }

  @Test
  void testDependencies() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("dependentProperties");
    JSONSchemaPropsOrStringArray field1Deps = target.getDependencies().get("field1");
    assertNull(field1Deps.getSchema());
    assertEquals(List.of("field2"), field1Deps.getProperty());
    JSONSchemaPropsOrStringArray field2Deps = target.getDependencies().get("field2");
    assertNull(field2Deps.getProperty());
    assertEquals("integer", field2Deps.getSchema().getType());
    assertEquals(Boolean.TRUE, field2Deps.getSchema().getNullable());
    assertEquals(Double.valueOf(0), field2Deps.getSchema().getMinimum());
    assertNull(field2Deps.getSchema().getExclusiveMinimum());
    assertEquals(Double.valueOf(100), field2Deps.getSchema().getMaximum());
    assertEquals(Boolean.TRUE, field2Deps.getSchema().getExclusiveMaximum());
  }

}

