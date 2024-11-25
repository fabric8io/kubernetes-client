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
package io.fabric8.java.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import io.fabric8.java.generator.nodes.GeneratorResult.ClassResult;
import io.fabric8.java.generator.nodes.JArray;
import io.fabric8.java.generator.nodes.JCRObject;
import io.fabric8.java.generator.nodes.JEnum;
import io.fabric8.java.generator.nodes.JMap;
import io.fabric8.java.generator.nodes.JObject;
import io.fabric8.java.generator.nodes.JPrimitive;
import io.fabric8.java.generator.nodes.ValidationProperties;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.fabric8.java.generator.CRGeneratorRunner.groupToPackage;
import static io.fabric8.java.generator.nodes.Keywords.JAVA_LANG_INTEGER;
import static io.fabric8.java.generator.nodes.Keywords.JAVA_LANG_LONG;
import static io.fabric8.java.generator.nodes.Keywords.JAVA_LANG_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneratorTest {

  static final Config defaultConfig = new Config();

  @Test
  void testCorrectInterpolationOfPackage() {
    // Act
    final var packageName = groupToPackage("test.org");

    // Assert
    assertThat(packageName).isEqualTo("org.test");
  }

  @Test
  void testCR() {
    // Arrange
    final var cro = new JCRObject(
        "v1alpha1",
        "Type",
        "g",
        "v",
        "Namespaced",
        Map.of(),
        List.of(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    final var res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> {
          assertThat(classResult.getName()).isEqualTo("Type");
          assertPackageDeclaration(classResult, "v1alpha1");
        });
  }

  @Test
  void testNamespacedCR() {
    // Arrange
    final var cro = new JCRObject(
        null,
        "Type",
        "g",
        "v",
        "Namespaced",
        Map.of(),
        List.of(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    final var res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "Type")
            .hasValueSatisfying(declaration -> assertThat(declaration.getImplementedTypes()).singleElement()
                .satisfies(
                    type -> assertThat(type.getNameWithScope()).isEqualTo("io.fabric8.kubernetes.api.model.Namespaced"))));
  }

  @Test
  void testClusterScopeCR() {
    // Arrange
    final var cro = new JCRObject(
        null,
        "Type",
        "g",
        "v",
        "Cluster",
        Map.of(),
        List.of(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    final var res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "Type")
            .hasValueSatisfying(type -> assertThat(type.getImplementedTypes()).isEmpty()));
  }

  @Test
  void testCRWithoutNamespace() {
    // Arrange
    final var cro = new JCRObject(
        null,
        "Type",
        "g",
        "v",
        "Namespaced",
        Map.of(),
        List.of(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    final var res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "Type"));
  }

  @Test
  void testPrimitive() {
    // Arrange
    final var primitive = new JPrimitive(
        "test",
        defaultConfig,
        null,
        Boolean.FALSE,
        null,
        null);

    // Act
    final var res = primitive.generateJava();

    // Assert
    assertThat(primitive.getType()).isEqualTo("test");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  @Test
  void testPrimitiveWithNumericValidationConstraints() {
    // Arrange
    final var expectedMaximum = 3.14d;
    final var expectedMinimum = 0.0d;
    final var validationProperties = ValidationProperties.Builder
        .getInstance()
        .withMaximum(expectedMaximum)
        .withMinimum(expectedMinimum)
        .build();
    final var primitive = new JPrimitive(
        "test",
        defaultConfig,
        null,
        Boolean.FALSE,
        null,
        validationProperties);

    // Act
    final var res = primitive.generateJava();

    // Assert
    assertThat(primitive.getType()).isEqualTo("test");
    assertThat(res.getTopLevelClasses()).isEmpty();
    assertThat(primitive.getMaximum()).isEqualTo(expectedMaximum);
    assertThat(primitive.getMinimum()).isEqualTo(expectedMinimum);
    assertThat(primitive.getPattern()).isNull();
  }

  @Test
  void testPrimitiveWithAlphanumericValidationConstraints() {
    // Arrange
    final var expectedPattern = ".*whatever.*";
    final var validationProperties = ValidationProperties.Builder
        .getInstance()
        .withPattern(expectedPattern)
        .build();
    final var primitive = new JPrimitive(
        "test",
        defaultConfig,
        null,
        Boolean.FALSE,
        null,
        validationProperties);

    // Act
    final var res = primitive.generateJava();

    // Assert
    assertThat(primitive.getType()).isEqualTo("test");
    assertThat(res.getTopLevelClasses()).isEmpty();
    assertThat(primitive.getPattern()).isEqualTo(expectedPattern);
    assertThat(primitive.getMaximum()).isNull();
    assertThat(primitive.getMinimum()).isNull();
  }

  @Test
  void testArrayOfPrimitives() {
    // Arrange
    final var array = new JArray(
        new JPrimitive(
            "primitive",
            defaultConfig,
            null,
            Boolean.FALSE,
            null,
            null),
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = array.generateJava();

    // Assert
    assertThat(array.getType()).isEqualTo("java.util.List<primitive>");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  @Test
  void testMapOfPrimitives() {
    // Arrange
    final var map = new JMap(
        new JPrimitive(
            "primitive",
            defaultConfig,
            null,
            Boolean.FALSE,
            null,
            null),
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = map.generateJava();

    // Assert
    assertThat(map.getType()).isEqualTo("java.util.Map<java.lang.String, primitive>");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  @Test
  void testEmptyObject() {
    // Arrange
    final var obj = new JObject(
        "v1alpha1",
        "t",
        null,
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("v1alpha1.T");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T"));
  }

  @Test
  void testEmptyObjectWithoutNamespace() {
    // Arrange
    final var obj = new JObject(
        null,
        "t",
        null,
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("T");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T"));
  }

  @Test
  void testObjectOfPrimitives() {
    // Arrange
    final var newBool = new JSONSchemaProps();
    newBool.setType("boolean");
    final var obj = new JObject(
        "v1alpha1",
        "t",
        Map.of("o1", newBool),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("v1alpha1.T");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> {
              assertThat(declaration.getFields()).hasSize(1);
              assertThat(declaration.getFieldByName("o1")).isPresent();
            }));
  }

  @Test
  void testObjectWithRequiredField() {
    // Arrange
    final var newBool = new JSONSchemaProps();
    newBool.setType("boolean");
    final var obj = new JObject(
        "v1alpha1",
        "t",
        Map.of("o1", newBool),
        List.of("o1"),
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> assertThat(declaration.getFieldByName("o1")).isPresent()
                .hasValueSatisfying(field -> assertThat(field.getAnnotationByName("Required")).isPresent())));
  }

  @Test
  void testObjectWithAndWithoutGeneratedAnnotation() {
    // Arrange
    final var obj1 = new JObject(
        "v1alpha1",
        "t",
        Map.of(),
        List.of(),
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);
    final var obj2 = new JObject(
        "v1alpha1",
        "t",
        Map.of(),
        List.of(),
        false,
        new Config(null, null, false, Map.of()),
        null,
        Boolean.FALSE,
        null);
    final var generatedAnnotationName = AbstractJSONSchema2Pojo.newGeneratedAnnotation().getNameAsString();

    // Act
    final var res1 = obj1.generateJava();
    final var res2 = obj2.generateJava();

    // Assert
    assertThat(res1.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(
                declaration -> assertThat(declaration.getAnnotationByName(generatedAnnotationName)).isPresent()));
    assertThat(res2.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(
                declaration -> assertThat(declaration.getAnnotationByName(generatedAnnotationName)).isNotPresent()));
  }

  @Test
  void testDefaultEnum() {
    // Arrange
    final var jEnum = new JEnum(
        "t",
        JAVA_LANG_STRING,
        List.of(new TextNode("foo"), new TextNode("bar"), new TextNode("baz")),
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = jEnum.generateJava();

    // Assert
    assertThat(jEnum.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement()
        .satisfies(classResult -> assertEnumByName(classResult, "T")
            .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
                declaration -> assertThat(declaration.getName()).hasToString("FOO"),
                declaration -> assertThat(declaration.getName()).hasToString("BAR"),
                declaration -> assertThat(declaration.getName()).hasToString("BAZ"))));
  }

  @Test
  void testLongEnum() {
    // Arrange
    final var jEnum = new JEnum(
        "t",
        JAVA_LANG_LONG,
        List.of(new TextNode("1"), new TextNode("2"), new TextNode("3")),
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = jEnum.generateJava();

    // Assert
    assertThat(jEnum.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement()
        .satisfies(classResult -> assertEnumByName(classResult, "T")
            .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
                declaration -> {
                  assertThat(declaration.getName()).hasToString("V__1");
                  assertThat(declaration.getArgument(0)).hasToString("1L");
                },
                declaration -> {
                  assertThat(declaration.getName()).hasToString("V__2");
                  assertThat(declaration.getArgument(0)).hasToString("2L");
                },
                declaration -> {
                  assertThat(declaration.getName()).hasToString("V__3");
                  assertThat(declaration.getArgument(0)).hasToString("3L");
                })));
  }

  @Test
  void testIntEnum() {
    // Arrange
    final var jEnum = new JEnum(
        "t",
        JAVA_LANG_INTEGER,
        List.of(new TextNode("1"), new TextNode("2"), new TextNode("3")),
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = jEnum.generateJava();

    // Assert
    assertThat(jEnum.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement()
        .satisfies(classResult -> assertEnumByName(classResult, "T")
            .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
                declaration -> {
                  assertThat(declaration.getName()).hasToString("V__1");
                  assertThat(declaration.getArgument(0)).hasToString("1");
                },
                declaration -> {
                  assertThat(declaration.getName()).hasToString("V__2");
                  assertThat(declaration.getArgument(0)).hasToString("2");
                },
                declaration -> {
                  assertThat(declaration.getName()).hasToString("V__3");
                  assertThat(declaration.getArgument(0)).hasToString("3");
                })));
  }

  @Test
  void testNotUppercaseEnum() {
    // Arrange
    final var jEnum = new JEnum(
        "t",
        JAVA_LANG_STRING,
        List.of(new TextNode("foo"), new TextNode("bar"), new TextNode("baz")),
        new Config(false, null, null, Map.of()),
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = jEnum.generateJava();

    // Assert
    assertThat(jEnum.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement()
        .satisfies(classResult -> assertEnumByName(classResult, "T")
            .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
                declaration -> assertThat(declaration.getName()).hasToString("foo"),
                declaration -> assertThat(declaration.getName()).hasToString("bar"),
                declaration -> assertThat(declaration.getName()).hasToString("baz"))));
  }

  @Test
  void testArrayOfObjects() {
    // Arrange
    final var array = new JArray(
        new JObject(
            null,
            "t",
            null,
            null,
            false,
            defaultConfig,
            null,
            Boolean.FALSE,
            null),
        defaultConfig,
        null,
        false,
        null);

    // Act
    final var res = array.generateJava();

    // Assert
    assertThat(array.getType()).isEqualTo("java.util.List<T>");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T"));
  }

  @Test
  void testMapOfObjects() {
    // Arrange
    final var map = new JMap(
        new JObject(
            null,
            "t",
            null,
            null,
            false,
            defaultConfig,
            null,
            Boolean.FALSE,
            null),
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = map.generateJava();

    // Assert
    assertThat(map.getType()).isEqualTo("java.util.Map<java.lang.String, T>");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T"));
  }

  @Test
  void testObjectOfObjects() {
    // Arrange
    final var newObj = new JSONSchemaProps();
    newObj.setType("object");
    final var obj = new JObject(
        null,
        "t",
        Map.of("o1", newObj),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> assertClassByName(classResult, "O1"),
        classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> assertThat(declaration.getFieldByName("o1")).isPresent()));
  }

  @Test
  void testObjectWithPreservedFields() {
    // Arrange
    final var obj = new JObject(
        null,
        "t",
        null,
        null,
        true,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> assertThat(declaration.getFieldByName("additionalProperties")).isPresent()));
  }

  @Test
  void testConfigToGeneratePreservedUnknownFields() {
    // Arrange
    final var obj = new JObject(
        null,
        "t",
        null,
        null,
        false,
        new Config(null, null, null, true, Map.of(), List.of(), null, null, null),
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> assertThat(declaration.getFieldByName("additionalProperties")).isPresent()));
  }

  @Test
  void testObjectWithSpecialFieldNames() {
    // Arrange
    final var newObj = new JSONSchemaProps();
    newObj.setType("string");
    final var obj = new JObject(
        null,
        "t",
        Map.of("description", newObj),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> assertThat(declaration.getFieldByName("description")).isPresent()));
  }

  @Test
  void testObjectNullableFieldsManagement() {
    // Arrange
    final var nullableObj = new JSONSchemaProps();
    nullableObj.setType("object");
    nullableObj.setNullable(Boolean.TRUE);
    final var nonNullableObj = new JSONSchemaProps();
    nonNullableObj.setType("object");
    nonNullableObj.setNullable(Boolean.FALSE);
    final var obj = new JObject(
        null,
        "t",
        Map.of("o1", nullableObj, "o2", nonNullableObj),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> assertClassByName(classResult, "O1"),
        classResult -> assertClassByName(classResult, "O2"),
        classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> {
              assertThat(declaration.getFields()).hasSize(2);
              assertThat(declaration.getFieldByName("o1")).isPresent().hasValueSatisfying(field -> {
                assertThat(field.getAnnotations()).hasSize(3);
                assertAnnotationValue(field, "com.fasterxml.jackson.annotation.JsonSetter",
                    "nulls = com.fasterxml.jackson.annotation.Nulls.SET");
                assertAnnotationValue(field, "com.fasterxml.jackson.annotation.JsonProperty", "\"o1\"");
                assertAnnotationValue(field, "io.fabric8.generator.annotation.Nullable", null);
              });
              assertThat(declaration.getFieldByName("o2")).isPresent().hasValueSatisfying(field -> {
                assertThat(field.getAnnotations()).hasSize(2);
                assertAnnotationValue(field, "com.fasterxml.jackson.annotation.JsonSetter",
                    "nulls = com.fasterxml.jackson.annotation.Nulls.SKIP");
                assertAnnotationValue(field, "com.fasterxml.jackson.annotation.JsonProperty", "\"o2\"");
              });
            }));
  }

  @Test
  void testObjectWithAdditionalPropertiesTrue() {
    // Arrange
    final var obj = new JSONSchemaProps();
    obj.setType("object");
    obj.setAdditionalProperties(new JSONSchemaPropsOrBool(true, null));
    final var jobj = new JObject(
        null,
        "t",
        Map.of("o1", obj),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = jobj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> {
              assertThat(declaration.getFields()).hasSize(1);
              assertFieldElementType(declaration, "o1", "io.fabric8.kubernetes.api.model.AnyType");
            }));
  }

  @Test
  void testClassNamesDisambiguationWithPackageNesting() {
    // Arrange
    final var newObj1 = new JSONSchemaProps();
    newObj1.setType("object");
    final var newObj2 = new JSONSchemaProps();
    newObj2.setType("object");
    newObj2.setProperties(Map.of("o1", newObj1, "o2", newObj1, "o3", newObj1));
    final var obj = new JObject(
        "v1alpha1",
        "t",
        Map.of("o1", newObj1, "o2", newObj2),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> {
          assertPackageDeclaration(classResult, "v1alpha1.t");
          assertClassByName(classResult, "O1");
        }, classResult -> {
          assertPackageDeclaration(classResult, "v1alpha1.t.o2");
          assertClassByName(classResult, "O1");
        }, classResult -> {
          assertPackageDeclaration(classResult, "v1alpha1.t.o2");
          assertClassByName(classResult, "O2");
        }, classResult -> {
          assertPackageDeclaration(classResult, "v1alpha1.t.o2");
          assertClassByName(classResult, "O3");
        }, classResult -> {
          assertPackageDeclaration(classResult, "v1alpha1.t");
          assertClassByName(classResult, "O2").hasValueSatisfying(declaration -> {
            assertThat(declaration.getFields()).hasSize(3);
            assertFieldElementType(declaration, "o1", "v1alpha1.t.o2.O1");
            assertFieldElementType(declaration, "o2", "v1alpha1.t.o2.O2");
            assertFieldElementType(declaration, "o3", "v1alpha1.t.o2.O3");
          });
        }, classResult -> {
          assertPackageDeclaration(classResult, "v1alpha1");
          assertClassByName(classResult, "T")
              .hasValueSatisfying(declaration -> {
                assertThat(declaration.getFields()).hasSize(2);
                assertFieldElementType(declaration, "o1", "v1alpha1.t.O1");
                assertFieldElementType(declaration, "o2", "v1alpha1.t.O2");
              });
        });
  }

  @Test
  void testObjectDefaultFieldsManagement() {
    // Arrange
    final var jsonContent = "{\"limits\":{\"memory\":\"1024Mi\",\"cpu\":\"\"},\"requests\":{\"memory\":\"1024Mi\",\"cpu\":\"1\"}}";
    final var defaultValue = Serialization.unmarshal(jsonContent, JsonNode.class);
    final var objWithDefaultValues = new JSONSchemaProps();
    objWithDefaultValues.setType("object");
    objWithDefaultValues.setDefault(defaultValue);
    final var objWithoutDefaultValues = new JSONSchemaProps();
    objWithoutDefaultValues.setType("object");
    final var obj = new JObject(
        null,
        "t",
        Map.of("o1", objWithDefaultValues, "o2", objWithoutDefaultValues),
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> assertClassByName(classResult, "O1"),
        classResult -> assertClassByName(classResult, "O2"),
        classResult -> assertClassByName(classResult, "T")
            .hasValueSatisfying(declaration -> {
              assertThat(declaration.getFields()).hasSize(2);
              assertThat(declaration.getFieldByName("o1")).isPresent()
                  .hasValueSatisfying(field -> assertThat(field.getVariables()).singleElement()
                      .satisfies(declarator -> assertThat(declarator.getInitializer()).isPresent()));
              assertThat(declaration.getFieldByName("o2")).isPresent()
                  .hasValueSatisfying(field -> assertThat(field.getVariables()).singleElement()
                      .satisfies(declarator -> assertThat(declarator.getInitializer()).isNotPresent()));
            }));
  }

  @Test
  void testExactlyMoreThanOneDuplicatedFieldFailsWithException() {
    // Arrange
    final var duplicatedFieldObject = new JSONSchemaProps();
    duplicatedFieldObject.setType("boolean");
    duplicatedFieldObject.setDescription("This field is JUST FOR testing purposes.");
    duplicatedFieldObject.setDescription("Deprecated: This field is JUST FOR testing purposes.");
    final var props = Map.of("test_Dup", duplicatedFieldObject, "test Dup", duplicatedFieldObject, "test.Dup",
        duplicatedFieldObject);

    // Assert
    assertThatThrownBy(
        // Act
        () -> new JObject(null, "t", props, null, false, defaultConfig, null, Boolean.FALSE, null))
        .as("An exception is expected to be thrown when an object contains more that one duplicated field")
        .isInstanceOf(JavaGeneratorException.class);
  }

  @Test
  void testExactlyDuplicatedFieldNotMarkedAsDeprecatedFailsWithException() {
    // Arrange
    final var duplicatedFieldObject = new JSONSchemaProps();
    duplicatedFieldObject.setType("boolean");
    duplicatedFieldObject.setDescription("This field is JUST FOR testing purposes.");
    final var props = Map.of("testDup", duplicatedFieldObject, "test-Dup", duplicatedFieldObject);

    // Assert
    assertThatThrownBy(
        // Act
        () -> new JObject(null, "t", props, null, false, defaultConfig, null, Boolean.FALSE, null))
        .as("An exception is expected to be thrown when an object contains one duplicated field that is not marked as deprecated")
        .isInstanceOf(JavaGeneratorException.class);
  }

  @Test
  void testExistingJavaTypeObject() {
    // Arrange
    final var config = Config.builder().existingJavaTypes(Map.of("v1alpha1.T", "org.test.ExistingJavaType")).build();
    final var obj = new JObject(
        "v1alpha1",
        "T",
        null,
        null,
        false,
        config,
        null,
        Boolean.FALSE,
        null);

    // Act
    final var res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("org.test.ExistingJavaType");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  private static OptionalAssert<ClassOrInterfaceDeclaration> assertClassByName(ClassResult classResult,
      String expectedClassName) {
    assertThat(classResult.getName()).isEqualTo(expectedClassName);
    return assertThat(classResult.getClassByName(expectedClassName)).isPresent();
  }

  @SuppressWarnings("SameParameterValue")
  private static OptionalAssert<EnumDeclaration> assertEnumByName(ClassResult classResult,
      String expectedClassName) {
    assertThat(classResult.getName()).isEqualTo(expectedClassName);
    return assertThat(classResult.getEnumByName(expectedClassName)).isPresent();
  }

  private static void assertAnnotationValue(FieldDeclaration field, String annotationName, String expectedMemberValue) {
    assertThat(field.getAnnotationByName(annotationName)).isPresent()
        .hasValueSatisfying(annotationExpr -> {
          if (expectedMemberValue != null) {
            assertThat(annotationExpr).isInstanceOf(SingleMemberAnnotationExpr.class);
            final var annotation = (SingleMemberAnnotationExpr) annotationExpr;
            assertThat(annotation.getMemberValue()).hasToString(expectedMemberValue);
          } else {
            assertThat(annotationExpr).isInstanceOf(NormalAnnotationExpr.class);
          }
        });
  }

  private static void assertFieldElementType(ClassOrInterfaceDeclaration declaration, String fieldName,
      String expectedElementType) {
    assertThat(declaration.getFieldByName(fieldName)).isPresent()
        .hasValueSatisfying(field -> assertThat(field.getElementType().asString())
            .isEqualTo(expectedElementType));
  }

  private static void assertPackageDeclaration(ClassResult classResult, String expectedPackageName) {
    assertThat(classResult.getPackageDeclaration()).isPresent()
        .hasValueSatisfying(declaration -> assertThat(declaration.getNameAsString()).isEqualTo(expectedPackageName));
  }
}
