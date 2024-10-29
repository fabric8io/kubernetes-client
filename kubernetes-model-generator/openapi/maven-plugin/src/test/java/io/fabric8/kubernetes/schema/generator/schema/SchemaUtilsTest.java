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
package io.fabric8.kubernetes.schema.generator.schema;

import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import io.fabric8.kubernetes.schema.generator.ImportManager;
import io.fabric8.kubernetes.schema.generator.ImportOrderComparator;
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
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
      "#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ListMeta, ListMeta",
      "#/components/schemas/io.k8s.api.core.v1.toCapitalize, ToCapitalize",
      "io.k8s.api.core.v1.ToBeMapped, Mapped",
      "#/components/schemas/io.k8s.api.core.v1.ToBeMapped, Mapped",
      "#/definitions/io.k8s.api.core.v1.ToBeMapped, Mapped"
  })
  void refToClassName(String ref, String expected) {
    final var properties = new Properties();
    properties.put("io.k8s.api.core.v1.ToBeMapped", "Mapped");
    final var schemaUtils = new SchemaUtils(generatorSettingsBuilder.refToClassNameMappings(properties).build());
    assertEquals(expected, schemaUtils.refToClassName(ref));
  }

  @ParameterizedTest
  @CsvSource({
      "io.k8s.api.core.v1, io.fabric8.kubernetes.api.model",
      "io.k8s.api.core.v2, io.fabric8.kubernetes.api.model.core.v2",
      "io.k8s.api.networking.v1, io.fabric8.kubernetes.api.model.networking.v1",
      "io.k8s.apimachinery, io.k8s.apimachinery"
  })
  void toModelPackage(String packageName, String expected) {
    final GeneratorSettings settings = generatorSettingsBuilder
        .packageMapping("io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.api.core", "io.fabric8.kubernetes.api.model.core")
        .packageMapping("io.k8s.api.networking", "io.fabric8.kubernetes.api.model.networking")
        .build();
    final String result = new SchemaUtils(settings).toModelPackage(packageName);
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
      "--return-, _return",
      "items, itemList",
      "items--, itemList",
      "edge--, _private"
  })
  void sanitizeFieldName(String variable, String expected) {
    assertEquals(expected, new SchemaUtils(generatorSettingsBuilder
        .fieldNameMapping("items", "itemList")
        .fieldNameMapping("edge", "private")
        .build()).sanitizeFieldName(variable));
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
    final String result = SchemaUtils.getterName(variable);
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
    final String result = SchemaUtils.setterName(variable);
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
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  class InterfaceSchemas {

    @Test
    void classType() {
      final ObjectSchema schema = new ObjectSchema();
      schema.setExtensions(Map.of("x-kubernetes-fabric8-type", "interface"));
      assertThat(SchemaUtils.classType(schema)).isEqualTo("interface");
    }

    @Test
    void isInterface() {
      final ObjectSchema schema = new ObjectSchema();
      schema.setExtensions(Map.of("x-kubernetes-fabric8-type", "interface"));
      assertTrue(SchemaUtils.isInterface(schema));
    }

    @Test
    void hasInterfaceFields() {
      final var schema = new ObjectSchema();
      schema.setExtensions(Map.of("x-kubernetes-fabric8-interface-fields", "field1,field2"));
      assertTrue(SchemaUtils.hasInterfaceFields(schema));
    }

    @ParameterizedTest(name = "{index}: x-kubernetes-fabric8-interface-fields={0}")
    @MethodSource("interfaceFieldsData")
    void interfaceFields(String extensionValue, String... expected) {
      final var schema = new ObjectSchema();
      schema.setExtensions(Collections.singletonMap("x-kubernetes-fabric8-interface-fields", extensionValue));
      assertThat(SchemaUtils.interfaceFields(schema))
          .containsExactlyInAnyOrder(expected);
    }

    Stream<Arguments> interfaceFieldsData() {
      return Stream.of(
          Arguments.of("field1,field2", new String[] { "field1", "field2" }),
          Arguments.of("field2,field1", new String[] { "field1", "field2" }),
          Arguments.of("", new String[0]),
          Arguments.of(null, new String[0]));
    }

    @ParameterizedTest(name = "{index}: x-kubernetes-fabric8-interface-implementation={0}")
    @MethodSource("interfaceImplementationData")
    void interfaceImplementation(String extensionValue, String... expected) {
      final var schema = new ObjectSchema();
      schema.setExtensions(new HashMap<>());
      schema.getExtensions().put("x-kubernetes-fabric8-type", "interface");
      schema.getExtensions().put("x-kubernetes-fabric8-implementation", extensionValue);
      assertThat(new SchemaUtils(generatorSettingsBuilder.build()).interfaceImplementation(schema))
          .containsExactly(expected);
    }

    Stream<Arguments> interfaceImplementationData() {
      return Stream.of(
          Arguments.of("InterfaceImpl,AnotherInterfaceImpl", new String[] { "AnotherInterfaceImpl", "InterfaceImpl" }),
          Arguments.of("AnotherInterfaceImpl,InterfaceImpl", new String[] { "AnotherInterfaceImpl", "InterfaceImpl" }),
          Arguments.of("", new String[0]),
          Arguments.of(null, new String[0]));
    }

    @ParameterizedTest(name = "{index}: x-kubernetes-fabric8-interface-implements={0}")
    @CsvSource({
        "InterfaceClass, InterfaceClass",
        ", ",
    })
    void interfaceImplemented(String extensionValue, String expected) {
      final var schema = new ObjectSchema();
      schema.setExtensions(Collections.singletonMap("x-kubernetes-fabric8-implements", extensionValue));
      assertThat(new SchemaUtils(generatorSettingsBuilder.build()).interfaceImplemented(schema))
          .isEqualTo(expected);
    }

  }

  @Nested
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  class EnumSchemas {

    @Test
    void classType() {
      final ObjectSchema schema = new ObjectSchema();
      schema.setExtensions(Map.of("x-kubernetes-fabric8-type", "enum"));
      assertThat(SchemaUtils.classType(schema)).isEqualTo("enum");
    }

    @Test
    void isEnum() {
      final ObjectSchema schema = new ObjectSchema();
      schema.setExtensions(Map.of("x-kubernetes-fabric8-type", "enum"));
      assertTrue(SchemaUtils.isEnum(schema));
    }

    @ParameterizedTest(name = "{index}: x-kubernetes-fabric8-enum-values={0}")
    @MethodSource("enumValuesData")
    void enumValues(String extensionValue, String... expected) {
      final var schema = new ObjectSchema();
      schema.setExtensions(new HashMap<>());
      schema.getExtensions().put("x-kubernetes-fabric8-type", "enum");
      schema.getExtensions().put("x-kubernetes-fabric8-enum-values", extensionValue);
      assertThat(SchemaUtils.enumValues(schema))
          .containsExactly(expected);
    }

    Stream<Arguments> enumValuesData() {
      return Stream.of(
          Arguments.of("ONE(0),TWO(1),THREE(3)", new String[] { "ONE(0)", "THREE(3)", "TWO(1)" }),
          Arguments.of("A,B,C,Z", new String[] { "A", "B", "C", "Z" }),
          Arguments.of("", new String[0]),
          Arguments.of(null, new String[0]));
    }

  }

  @Nested
  class SchemaToClassName {

    private SchemaUtils schemaUtils;
    private ImportManager importManager;

    @BeforeEach
    void setUp() {
      schemaUtils = new SchemaUtils(generatorSettingsBuilder
          .packageMapping(
              "io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
          .packageMapping("io.k8s.apimachinery.pkg.apis.meta.v1", "io.fabric8.kubernetes.api.model")
          .build());
      importManager = new ImportManager() {
        private final Collection<String> imports = new TreeSet<>(new ImportOrderComparator());

        @Override
        public String getPackageName() {
          return "";
        }

        @Override
        public Collection<String> getImports() {
          return imports;
        }
      };
    }

    @Test
    void arrays() {
      final ArraySchema schema = new ArraySchema();
      schema.items(new StringSchema());
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("List<String>", result);
      assertEquals("java.util.List", importManager.getImports().iterator().next());
    }

    @Test
    void mapOfObjects() {
      final MapSchema schema = new MapSchema();
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Map<String, Object>", result);
      assertEquals(2, importManager.getImports().size());
      assertTrue(importManager.getImports().contains("java.util.Map"));
      assertTrue(importManager.getImports().contains("java.util.LinkedHashMap"));
    }

    @Test
    void mapOfIntegers() {
      final MapSchema schema = new MapSchema();
      schema.additionalProperties(new IntegerSchema());
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Map<String, Integer>", result);
      assertEquals(2, importManager.getImports().size());
      assertTrue(importManager.getImports().contains("java.util.Map"));
      assertTrue(importManager.getImports().contains("java.util.LinkedHashMap"));
    }

    @Test
    void date() {
      final DateSchema schema = new DateSchema();
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("String", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Test
    void dateTime() {
      final DateTimeSchema schema = new DateTimeSchema();
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("String", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Test
    // TODO: Special handling for MicroTime class (with custom serializer and deserializer)
    // Fabric8 has a special (legacy) handling for MicroTime, we might consider removing this
    // completely and use OffsetDateTime as for the rest of temporal types
    void microTime() {
      final ObjectSchema schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.MicroTime");
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("MicroTime", result);
      assertEquals("io.fabric8.kubernetes.api.model.MicroTime", importManager.getImports().iterator().next());
    }

    @Test
    void string() {
      final StringSchema schema = new StringSchema();
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("String", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Test
    void integer() {
      final IntegerSchema schema = new IntegerSchema();
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Integer", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Test
    void _long() {
      final NumberSchema schema = new NumberSchema();
      schema.setFormat("int64");
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Long", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Test
    void _double() {
      final NumberSchema schema = new NumberSchema();
      schema.setFormat("double");
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Double", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Nested
    class Ref {

      @Test
      void refFromDefault() {
        final ObjectSchema schema = new ObjectSchema();
        schema.set$ref("#/definitions/io.k8s.api.core.v1.Pod");
        final String result = schemaUtils.schemaToClassName(importManager, schema);
        assertEquals("Pod", result);
        assertEquals("io.fabric8.kubernetes.api.model.Pod", importManager.getImports().iterator().next());
      }

      @Test
      void refWithCollidingImport() {
        // Colliding import
        importManager.addImport("io.fabric8.kubernetes.api.model.ObjectReference");
        final ObjectSchema schema = new ObjectSchema();
        schema.set$ref("#/definitions/io.fabric8.kubernetes.api.model.gatewayapi.v1.ObjectReference");
        final String result = schemaUtils.schemaToClassName(importManager, schema);
        assertEquals("io.fabric8.kubernetes.api.model.gatewayapi.v1.ObjectReference", result);
        assertEquals(1, importManager.getImports().size());
        assertEquals("io.fabric8.kubernetes.api.model.ObjectReference", importManager.getImports().iterator().next());
      }

      @Test
      void refWithSameImport() {
        // Same import
        importManager.addImport("io.fabric8.kubernetes.api.model.gatewayapi.v1.ObjectReference");
        final ObjectSchema schema = new ObjectSchema();
        schema.set$ref("#/definitions/io.fabric8.kubernetes.api.model.gatewayapi.v1.ObjectReference");
        final String result = schemaUtils.schemaToClassName(importManager, schema);
        assertEquals("ObjectReference", result);
        assertEquals("io.fabric8.kubernetes.api.model.gatewayapi.v1.ObjectReference",
            importManager.getImports().iterator().next());
        assertEquals(1, importManager.getImports().size());
      }

    }

    @Test
    void intOrString() {
      final ObjectSchema schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString");
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("IntOrString", result);
      assertEquals("io.fabric8.kubernetes.api.model.IntOrString", importManager.getImports().iterator().next());
    }

    @Test
    void jsonNode() {
      final ObjectSchema schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1.JSON");
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("JsonNode", result);
      assertEquals("com.fasterxml.jackson.databind.JsonNode", importManager.getImports().iterator().next());
    }

    @Test
    void plainObject() {
      final ObjectSchema schema = new ObjectSchema();
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Object", result);
      assertTrue(importManager.getImports().isEmpty());
    }

    @Test
    void mappingDefault() {
      final ObjectSchema schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta");
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("ObjectMeta", result);
      assertEquals("io.fabric8.kubernetes.api.model.ObjectMeta", importManager.getImports().iterator().next());
    }

    @Test
    void mappingConfiguredInSettings() {
      final Properties properties = new Properties();
      properties.put("io.k8s.api.core.v1.ToBeMapped", "io.fabric8.kubernetes.api.model.Mapped");
      final ObjectSchema schema = new ObjectSchema();
      schema.set$ref("io.k8s.api.core.v1.ToBeMapped");
      schemaUtils = new SchemaUtils(generatorSettingsBuilder.refToJavaTypeMappings(properties).build());
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Mapped", result);
      assertEquals("io.fabric8.kubernetes.api.model.Mapped", importManager.getImports().iterator().next());
    }

    @Test
    void configuredInSettingsTakesPrecedence() {
      final Properties properties = new Properties();
      properties.put("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta",
          "io.fabric8.kubernetes.api.model.Mapped");
      final ObjectSchema schema = new ObjectSchema();
      schema.set$ref("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta");
      schemaUtils = new SchemaUtils(generatorSettingsBuilder.refToJavaTypeMappings(properties).build());
      final String result = schemaUtils.schemaToClassName(importManager, schema);
      assertEquals("Mapped", result);
      assertEquals("io.fabric8.kubernetes.api.model.Mapped", importManager.getImports().iterator().next());
    }

  }

  @Nested
  class PropertyOrder {

    @Test
    void nullSchema() {
      final Map<String, Object> result = SchemaUtils.propertyOrder(null);
      assertEquals(1, result.size());
      assertEquals(true, result.get("isEmpty"));
    }

    @Test
    void emptySchema() {
      final Map<String, Object> result = SchemaUtils.propertyOrder(new ObjectSchema());
      assertEquals(1, result.size());
      assertEquals(true, result.get("isEmpty"));
    }

    @Test
    void withProperties() {
      // Given
      final ObjectSchema schema = new ObjectSchema();
      schema.properties(new LinkedHashMap<>());
      schema.getProperties().put("propZ", new StringSchema());
      schema.getProperties().put("prop1", new StringSchema());
      schema.getProperties().put("kind", new StringSchema());
      schema.getProperties().put("metadata", new ObjectSchema());
      schema.getProperties().put("items", new ArraySchema());
      schema.getProperties().put("apiVersion", new StringSchema());
      // When
      final Map<String, Object> result = SchemaUtils.propertyOrder(schema);
      // Then
      assertEquals(false, result.get("isEmpty"));
      assertEquals(Arrays.asList("apiVersion", "kind", "metadata", "propZ", "prop1", "items"), result.get("properties"));
    }
  }
}
