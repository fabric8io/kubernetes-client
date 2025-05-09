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

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.crdv2.example.jsonschema.JsonSchemaAnno;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    assertEquals(Set.of("field1", "field2"), itemsSchemas.get(0).getProperties().keySet());
    assertEquals(Set.of("field1", "field2"), itemsSchemas.get(1).getProperties().keySet());

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
  void testObjectEnumerationWithDefaultAndExample() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("objectEnumeration");
    ObjectNode expected1 = JsonNodeFactory.instance.objectNode().put("field1", "allowedValue1").put("field2", 1);
    ObjectNode expected2 = JsonNodeFactory.instance.objectNode().put("field1", "allowedValue2").put("field2", 2);
    assertEquals(expected1, target.getDefault());
    assertEquals(expected2, target.getExample());
    assertEquals(List.of(expected1, expected2), target.getEnum());
  }

  @Test
  void testDependencies() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("dependentProperties");
    JSONSchemaPropsOrStringArray field1Deps = target.getDependencies().get("field1");
    assertNull(field1Deps.getSchema());
    assertEquals(List.of("field2"), field1Deps.getProperty());
    JSONSchemaPropsOrStringArray field2Deps = target.getDependencies().get("field2");
    assertEquals(Collections.emptyList(), field2Deps.getProperty());
    assertEquals("integer", field2Deps.getSchema().getType());
    assertEquals(Boolean.TRUE, field2Deps.getSchema().getNullable());
    assertEquals(Double.valueOf(0), field2Deps.getSchema().getMinimum());
    assertNull(field2Deps.getSchema().getExclusiveMinimum());
    assertEquals(Double.valueOf(100), field2Deps.getSchema().getMaximum());
    assertEquals(Boolean.TRUE, field2Deps.getSchema().getExclusiveMaximum());
  }

  static class RecursiveTypeChecker {
    final AtomicInteger count = new AtomicInteger(0);
    final BiConsumer<JSONSchemaProps, JSONSchemaProps> assertion;

    RecursiveTypeChecker(BiConsumer<JSONSchemaProps, JSONSchemaProps> assertion) {
      this.assertion = assertion;
    }

    Stream<JSONSchemaProps> itemsToSchemas(JSONSchemaProps schema) {
      return Optional.ofNullable(schema.getItems())
          .map(items -> Stream
              .concat(
                  Optional.ofNullable(items.getJSONSchemas())
                      .map(List::stream)
                      .orElseGet(Stream::empty),
                  Stream.of(items.getSchema()))
              .filter(Objects::nonNull))
          .orElseGet(Stream::empty);
    }

    void accept(JSONSchemaProps schema, boolean checkProperties) {
      List<JSONSchemaProps> directSchemas = Stream.of(
          schema.getAllOf().stream(),
          schema.getAnyOf().stream(),
          Stream.of(schema.getNot()),
          schema.getOneOf().stream(),
          checkProperties ? itemsToSchemas(schema) : Stream.<JSONSchemaProps> empty(),
          checkProperties ? schema.getProperties().values().stream() : Stream.<JSONSchemaProps> empty())
          .flatMap(Function.identity())
          .filter(Objects::nonNull)
          .collect(Collectors.toList());

      for (JSONSchemaProps s : directSchemas) {
        assertion.accept(s, schema);
        accept(s, true);
        count.incrementAndGet();
      }
    }
  }

  @Test
  void testStructuralSchemaJunctorRemovedTypes() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("structural");
    RecursiveTypeChecker checker = new RecursiveTypeChecker((childSchema, parentSchema) -> {
      // Type is allowed with a schema having `x-kubernetes-int-or-string: true`
      if (!Boolean.TRUE.equals(parentSchema.getXKubernetesIntOrString())) {
        assertNull(childSchema.getType());
      }
    });
    checker.accept(target, false);
    assertEquals(20, checker.count.get());
  }

  @Test
  void testStructuralSchemaJunctorPropertiesCopied() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("structural");
    assertEquals(9, target.getProperties().size());
    assertEquals("string", target.getProperties().get("string1").getType());
    assertEquals("string", target.getProperties().get("string2").getType());
    assertEquals("string", target.getProperties().get("string3").getType());
    assertEquals("object", target.getProperties().get("structural3").getType());
    assertEquals("array", target.getProperties().get("string4").getType());
    assertEquals("string", target.getProperties().get("string4").getItems().getSchema().getType());
    assertEquals("string", target.getProperties().get("string5").getType());
    assertEquals("string", target.getProperties().get("string6").getType());
    assertEquals("string", target.getProperties().get("string7").getType());
  }

  @Test
  void testStructuralSchemaJunctorIntOrString() {
    JSONSchemaProps target = schema.getProperties().get("spec").getProperties().get("structural");
    assertEquals(2, target.getOneOf().size());
    JSONSchemaProps intOrStringSchema = target.getOneOf().get(1).getProperties().get("intOrString7");
    assertNull(intOrStringSchema.getType());
    assertEquals(Boolean.TRUE, intOrStringSchema.getXKubernetesIntOrString());
    assertEquals(2, intOrStringSchema.getAnyOf().size());
    assertEquals("integer", intOrStringSchema.getAnyOf().get(0).getType());
    assertEquals("string", intOrStringSchema.getAnyOf().get(1).getType());
  }

}
