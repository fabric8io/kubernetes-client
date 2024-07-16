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
package io.fabric8.kubernetes.schema.generator;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SchemaUtilsTest {

  private GeneratorSettings.GeneratorSettingsBuilder generatorSettingsBuilder;

  @BeforeEach
  void setUp(@TempDir File tempDir) {
    generatorSettingsBuilder = GeneratorSettings.builder()
        .outputDirectory(tempDir);
  }

  @ParameterizedTest
  @CsvSource({
      "#/definitions/io.k8s.api.core.v1.Pod, Pod",
      "#/definitions/io.k8s.api.core.v1.PodList, PodList",
      "#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ListMeta, ListMeta"
  })
  void refToClassName(String ref, String expected) {
    final var result = SchemaUtils.refToClassName(ref);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource({
      "io.k8s.api.core.v1, io.fabric8.kubernetes.api.model",
      "io.k8s.api.core.v2, io.fabric8.kubernetes.api.model.core.v2",
      "io.k8s.api.networking.v1, io.fabric8.kubernetes.api.model.networking.v1",
      "io.k8s.apimachinery, io.k8s.apimachinery"
  })
  void toModelPackage(String packageName, String expected) {
    final var settings = generatorSettingsBuilder
        .packageMapping("io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.api.core", "io.fabric8.kubernetes.api.model.core")
        .packageMapping("io.k8s.api.networking", "io.fabric8.kubernetes.api.model.networking")
        .build();
    final var result = new SchemaUtils(settings).toModelPackage(packageName);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource({
      "a-variable, aVariable",
      "private, _private",
      "continue, _continue",
      "import, _import",
      "return, _return",
      "return-, _return",
      "--return-, _return"
  })
  void sanitizeVariable(String variable, String expected) {
    assertEquals(expected, SchemaUtils.sanitizeVariable(variable));
  }

  @ParameterizedTest
  @CsvSource({
      "AVariable, getAVariable",
      "aVariable, getAVariable",
      "available, getAvailable",
      "x-kubernetes-validations, getXKubernetesValidations",
      "items, getItems"
  })
  void getterName(String variable, String expected) {
    final var result = SchemaUtils.getterName(variable);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource({
      "AVariable, setAVariable",
      "aVariable, setAVariable",
      "available, setAvailable",
      "x-kubernetes-validations, setXKubernetesValidations",
      "items, setItems"
  })
  void setterName(String variable, String expected) {
    final var result = SchemaUtils.setterName(variable);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource({
      "io.fabric8.kubernetes.api.model.MicroTime, io.fabric8.kubernetes.api.model.MicroTimeSerDes.Serializer.class",
      "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Serializer.class",
  })
  void serializerForJavaClass(String javaClass, String expected) {
    assertEquals(expected, SchemaUtils.serializerForJavaClass(javaClass));
  }

  @Nested
  class SchemaToClassName {

    private SchemaUtils schemaUtils;
    private AtomicReference<String> addImport;
    private Consumer<String> importConsumer;

    @BeforeEach
    void setUp() {
      schemaUtils = new SchemaUtils(generatorSettingsBuilder
          .packageMapping(
              "io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
          .packageMapping("io.k8s.apimachinery.pkg.apis.meta.v1", "io.fabric8.kubernetes.api.model")
          .build());
      addImport = new AtomicReference<>();
      importConsumer = addImport::set;
    }

    @Test
    void arrays() {
      final var schema = new ArraySchema();
      schema.items(new StringSchema());
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("List<String>", result);
      assertEquals("java.util.List", addImport.get());
    }

    @Test
    void mapOfObjects() {
      final var schema = new MapSchema();
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("Map<String, Object>", result);
      assertEquals("java.util.Map", addImport.get());
    }

    @Test
    void mapOfIntegers() {
      final var schema = new MapSchema();
      schema.additionalProperties(new IntegerSchema());
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("Map<String, Integer>", result);
      assertEquals("java.util.Map", addImport.get());
    }

    @Test
    void date() {
      final var schema = new DateSchema();
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("String", result);
      assertNull(addImport.get());
    }

    @Test
    void dateTime() {
      final var schema = new DateTimeSchema();
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("String", result);
      assertNull(addImport.get());
    }

    @Test
    // TODO: Special handling for MicroTime class (with custom serializer and deserializer)
    // Fabric8 has a special (legacy) handling for MicroTime, we might consider removing this
    // completely and use OffsetDateTime as for the rest of temporal types
    void microTime() {
      final var schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.MicroTime");
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("MicroTime", result);
      assertEquals("io.fabric8.kubernetes.api.model.MicroTime", addImport.get());
    }

    @Test
    void string() {
      final var schema = new StringSchema();
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("String", result);
      assertNull(addImport.get());
    }

    @Test
    void integer() {
      final var schema = new IntegerSchema();
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("Integer", result);
      assertNull(addImport.get());
    }

    @Test
    void _long() {
      final var schema = new NumberSchema();
      schema.setFormat("int64");
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("Long", result);
      assertNull(addImport.get());
    }

    @Test
    void _double() {
      final var schema = new NumberSchema();
      schema.setFormat("double");
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("Double", result);
      assertNull(addImport.get());
    }

    @Test
    void ref() {
      final var schema = new ObjectSchema();
      schema.set$ref("#/definitions/io.k8s.api.core.v1.Pod");
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("Pod", result);
      assertEquals("io.fabric8.kubernetes.api.model.Pod", addImport.get());
    }

    @Test
    void intOrString() {
      final var schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString");
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("IntOrString", result);
      assertEquals("io.fabric8.kubernetes.api.model.IntOrString", addImport.get());
    }

    @Test
    void jsonNode() {
      final var schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1.JSON");
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("JsonNode", result);
      assertEquals("com.fasterxml.jackson.databind.JsonNode", addImport.get());
    }

    @Test
    void plainObject() {
      final var schema = new ObjectSchema();
      final var result = schemaUtils.schemaToClassName(importConsumer, schema);
      assertEquals("KubernetesResource", result);
      assertEquals("io.fabric8.kubernetes.api.model.KubernetesResource", addImport.get());
    }

  }

  @Nested
  class PropertyOrder {

    @Test
    void nullSchema() {
      final var result = SchemaUtils.propertyOrder(null);
      assertEquals(1, result.size());
      assertEquals(true, result.get("isEmpty"));
    }

    @Test
    void emptySchema() {
      final var result = SchemaUtils.propertyOrder(new ObjectSchema());
      assertEquals(1, result.size());
      assertEquals(true, result.get("isEmpty"));
    }

    @Test
    void withProperties() {
      // Given
      final var schema = new ObjectSchema();
      schema.properties(new LinkedHashMap<>());
      schema.getProperties().put("propZ", new StringSchema());
      schema.getProperties().put("prop1", new StringSchema());
      schema.getProperties().put("kind", new StringSchema());
      schema.getProperties().put("metadata", new ObjectSchema());
      schema.getProperties().put("items", new ArraySchema());
      schema.getProperties().put("apiVersion", new StringSchema());
      // When
      final var result = SchemaUtils.propertyOrder(schema);
      // Then
      assertEquals(false, result.get("isEmpty"));
      assertEquals(List.of("apiVersion", "kind", "metadata", "propZ", "prop1", "items"), result.get("properties"));
    }
  }
}
