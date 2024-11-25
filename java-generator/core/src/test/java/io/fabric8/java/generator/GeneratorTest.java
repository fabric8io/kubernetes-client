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
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import io.fabric8.java.generator.nodes.GeneratorResult;
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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    String packageName = groupToPackage("test.org");

    // Assert
    assertThat(packageName).isEqualTo("org.test");
  }

  @Test
  void testCR() {
    // Arrange
    JCRObject cro = new JCRObject(
        "v1alpha1",
        "Type",
        "g",
        "v",
        "Namespaced",
        Collections.emptyMap(),
        Collections.emptyList(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    GeneratorResult res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement().satisfies(classResult -> {
      assertThat(classResult.getName()).isEqualTo("Type");
      assertThat(classResult.getPackageDeclaration()).isPresent()
          .hasValueSatisfying(packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1"));
    });
  }

  @Test
  void testNamespacedCR() {
    // Arrange
    JCRObject cro = new JCRObject(
        null,
        "Type",
        "g",
        "v",
        "Namespaced",
        Collections.emptyMap(),
        Collections.emptyList(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    GeneratorResult res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses().get(0).getClassByName("Type")).isPresent()
        .hasValueSatisfying(type -> assertThat(type.getImplementedTypes().get(0).getNameWithScope())
            .isEqualTo("io.fabric8.kubernetes.api.model.Namespaced"));
  }

  @Test
  void testClusterScopeCR() {
    // Arrange
    JCRObject cro = new JCRObject(
        null,
        "Type",
        "g",
        "v",
        "Cluster",
        Collections.emptyMap(),
        Collections.emptyList(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    GeneratorResult res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses().get(0).getClassByName("Type")).isPresent()
        .hasValueSatisfying(type -> assertThat(type.getImplementedTypes()).isEmpty());
  }

  @Test
  void testCRWithoutNamespace() {
    // Arrange
    JCRObject cro = new JCRObject(
        null,
        "Type",
        "g",
        "v",
        "Namespaced",
        Collections.emptyMap(),
        Collections.emptyList(),
        false,
        "",
        true,
        true,
        "t",
        "ts",
        defaultConfig);

    // Act
    GeneratorResult res = cro.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertThat(classResult.getName()).isEqualTo("Type"));
  }

  @Test
  void testPrimitive() {
    // Arrange
    JPrimitive primitive = new JPrimitive(
        "test",
        defaultConfig,
        null,
        Boolean.FALSE,
        null,
        null);

    // Act
    GeneratorResult res = primitive.generateJava();

    // Assert
    assertThat(primitive.getType()).isEqualTo("test");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  @Test
  void testPrimitiveWithNumericValidationConstraints() {
    // Arrange
    final Double expectedMaximum = 3.14;
    final Double expectedMinimum = 0.0;
    ValidationProperties validationProperties = ValidationProperties.Builder
        .getInstance()
        .withMaximum(expectedMaximum)
        .withMinimum(expectedMinimum)
        .build();
    JPrimitive primitive = new JPrimitive(
        "test",
        defaultConfig,
        null,
        Boolean.FALSE,
        null,
        validationProperties);

    // Act
    GeneratorResult res = primitive.generateJava();

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
    final String expectedPattern = ".*whatever.*";
    ValidationProperties validationProperties = ValidationProperties.Builder
        .getInstance()
        .withPattern(expectedPattern)
        .build();
    JPrimitive primitive = new JPrimitive(
        "test",
        defaultConfig,
        null,
        Boolean.FALSE,
        null,
        validationProperties);

    // Act
    GeneratorResult res = primitive.generateJava();

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
    JArray array = new JArray(
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
    GeneratorResult res = array.generateJava();

    // Assert
    assertThat(array.getType()).isEqualTo("java.util.List<primitive>");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  @Test
  void testMapOfPrimitives() {
    // Arrange
    JMap map = new JMap(
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
    GeneratorResult res = map.generateJava();

    // Assert
    assertThat(map.getType()).isEqualTo("java.util.Map<java.lang.String, primitive>");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }

  @Test
  void testEmptyObject() {
    // Arrange
    JObject obj = new JObject(
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
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("v1alpha1.T");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertThat(classResult.getName()).isEqualTo("T"));
  }

  @Test
  void testEmptyObjectWithoutNamespace() {
    // Arrange
    JObject obj = new JObject(
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
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("T");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertThat(classResult.getName()).isEqualTo("T"));
  }

  @Test
  void testObjectOfPrimitives() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps newBool = new JSONSchemaProps();
    newBool.setType("boolean");
    props.put("o1", newBool);
    JObject obj = new JObject(
        "v1alpha1",
        "t",
        props,
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("v1alpha1.T");
    assertThat(res.getTopLevelClasses()).singleElement().satisfies(classResult -> {
      assertThat(classResult.getName()).isEqualTo("T");
      assertThat(classResult.getClassByName("T")).isPresent().hasValueSatisfying(clz -> {
        assertThat(clz.getFields()).hasSize(1);
        assertThat(clz.getFieldByName("o1")).isPresent();
      });
    });
  }

  @Test
  void testObjectWithRequiredField() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps newBool = new JSONSchemaProps();
    newBool.setType("boolean");
    props.put("o1", newBool);
    List<String> req = new ArrayList<>(1);
    req.add("o1");
    JObject obj = new JObject(
        "v1alpha1",
        "t",
        props,
        req,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses().get(0).getClassByName("T")).isPresent()
        .hasValueSatisfying(clz -> assertThat(clz.getFieldByName("o1")).isPresent()
            .hasValueSatisfying(o1Field -> assertThat(o1Field.getAnnotationByName("Required")).isPresent()));
  }

  @Test
  void testObjectWithAndWithoutGeneratedAnnotation() {
    // Arrange
    JObject obj1 = new JObject(
        "v1alpha1",
        "t",
        new HashMap<>(),
        new ArrayList<>(),
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);
    Config config = new Config(null, null, false, new HashMap<>());
    JObject obj2 = new JObject(
        "v1alpha1",
        "t",
        new HashMap<>(),
        new ArrayList<>(),
        false,
        config,
        null,
        Boolean.FALSE,
        null);
    String generatedAnnotationName = AbstractJSONSchema2Pojo.newGeneratedAnnotation().getNameAsString();

    // Act
    GeneratorResult res1 = obj1.generateJava();
    GeneratorResult res2 = obj2.generateJava();

    // Assert
    assertThat(res1.getTopLevelClasses().get(0).getClassByName("T")).isPresent()
        .hasValueSatisfying(clz -> assertThat(clz.getAnnotationByName(generatedAnnotationName)).isPresent());
    assertThat(res2.getTopLevelClasses().get(0).getClassByName("T")).isPresent()
        .hasValueSatisfying(clz -> assertThat(clz.getAnnotationByName(generatedAnnotationName)).isNotPresent());
  }

  @Test
  void testDefaultEnum() {
    // Arrange
    JSONSchemaProps newEnum = new JSONSchemaProps();
    newEnum.setType("string");
    List<JsonNode> enumValues = new ArrayList<>();
    enumValues.add(new TextNode("foo"));
    enumValues.add(new TextNode("bar"));
    enumValues.add(new TextNode("baz"));
    JEnum enu = new JEnum(
        "t",
        JAVA_LANG_STRING,
        enumValues,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = enu.generateJava();

    // Assert
    assertThat(enu.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement().satisfies(classResult -> {
      assertThat(classResult.getName()).isEqualTo("T");
      assertThat(classResult.getEnumByName("T")).isPresent()
          .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
              ecd -> assertThat(ecd.getName().asString()).isEqualTo("FOO"),
              ecd -> assertThat(ecd.getName().asString()).isEqualTo("BAR"),
              ecd -> assertThat(ecd.getName().asString()).isEqualTo("BAZ")));
    });
  }

  @Test
  void testLongEnum() {
    // Arrange
    JSONSchemaProps newEnum = new JSONSchemaProps();
    newEnum.setType("integer");
    List<JsonNode> enumValues = new ArrayList<>();
    enumValues.add(new TextNode("1"));
    enumValues.add(new TextNode("2"));
    enumValues.add(new TextNode("3"));
    JEnum enu = new JEnum(
        "t",
        JAVA_LANG_LONG,
        enumValues,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = enu.generateJava();

    // Assert
    assertThat(enu.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement().satisfies(classResult -> {
      assertThat(classResult.getName()).isEqualTo("T");
      assertThat(classResult.getEnumByName("T")).isPresent()
          .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
              ecd -> {
                assertThat(ecd.getName().asString()).isEqualTo("V__1");
                assertThat(ecd.getArgument(0).toString()).isEqualTo("1L");
              },
              ecd -> {
                assertThat(ecd.getName().asString()).isEqualTo("V__2");
                assertThat(ecd.getArgument(0).toString()).isEqualTo("2L");
              },
              ecd -> {
                assertThat(ecd.getName().asString()).isEqualTo("V__3");
                assertThat(ecd.getArgument(0).toString()).isEqualTo("3L");
              }));
    });
  }

  @Test
  void testIntEnum() {
    // Arrange
    JSONSchemaProps newEnum = new JSONSchemaProps();
    newEnum.setType("integer");
    newEnum.setFormat("int32");
    List<JsonNode> enumValues = new ArrayList<>();
    enumValues.add(new TextNode("1"));
    enumValues.add(new TextNode("2"));
    enumValues.add(new TextNode("3"));
    JEnum enu = new JEnum(
        "t",
        JAVA_LANG_INTEGER,
        enumValues,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = enu.generateJava();

    // Assert
    assertThat(enu.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement().satisfies(classResult -> {
      assertThat(classResult.getName()).isEqualTo("T");
      assertThat(classResult.getEnumByName("T")).isPresent()
          .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
              ecd -> {
                assertThat(ecd.getName().asString()).isEqualTo("V__1");
                assertThat(ecd.getArgument(0).toString()).isEqualTo("1");
              },
              ecd -> {
                assertThat(ecd.getName().asString()).isEqualTo("V__2");
                assertThat(ecd.getArgument(0).toString()).isEqualTo("2");
              },
              ecd -> {
                assertThat(ecd.getName().asString()).isEqualTo("V__3");
                assertThat(ecd.getArgument(0).toString()).isEqualTo("3");
              }));
    });
  }

  @Test
  void testNotUppercaseEnum() {
    // Arrange
    JSONSchemaProps newEnum = new JSONSchemaProps();
    newEnum.setType("string");
    List<JsonNode> enumValues = new ArrayList<>();
    enumValues.add(new TextNode("foo"));
    enumValues.add(new TextNode("bar"));
    enumValues.add(new TextNode("baz"));
    JEnum enu = new JEnum(
        "t",
        JAVA_LANG_STRING,
        enumValues,
        new Config(false, null, null, new HashMap<>()),
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = enu.generateJava();

    // Assert
    assertThat(enu.getType()).isEqualTo("T");
    assertThat(res.getInnerClasses()).singleElement().satisfies(classResult -> {
      assertThat(classResult.getName()).isEqualTo("T");
      assertThat(classResult.getEnumByName("T")).isPresent()
          .hasValueSatisfying(enumDeclaration -> assertThat(enumDeclaration.getEntries()).satisfiesExactly(
              ecd -> assertThat(ecd.getName().asString()).isEqualTo("foo"),
              ecd -> assertThat(ecd.getName().asString()).isEqualTo("bar"),
              ecd -> assertThat(ecd.getName().asString()).isEqualTo("baz")));
    });
  }

  @Test
  void testArrayOfObjects() {
    // Arrange
    JArray array = new JArray(
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
    GeneratorResult res = array.generateJava();

    // Assert
    assertThat(array.getType()).isEqualTo("java.util.List<T>");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertThat(classResult.getName()).isEqualTo("T"));
  }

  @Test
  void testMapOfObjects() {
    // Arrange
    JMap map = new JMap(
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
    GeneratorResult res = map.generateJava();

    // Assert
    assertThat(map.getType()).isEqualTo("java.util.Map<java.lang.String, T>");
    assertThat(res.getTopLevelClasses()).singleElement()
        .satisfies(classResult -> assertThat(classResult.getName()).isEqualTo("T"));
  }

  @Test
  void testObjectOfObjects() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps newObj = new JSONSchemaProps();
    newObj.setType("object");
    props.put("o1", newObj);
    JObject obj = new JObject(
        null,
        "t",
        props,
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("O1");
          assertThat(classResult.getClassByName("O1")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent()
              .hasValueSatisfying(clz -> assertThat(clz.getFieldByName("o1")).isPresent());
        });
  }

  @Test
  void testObjectWithPreservedFields() {
    // Arrange
    JObject obj = new JObject(
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
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement().satisfies(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent().hasValueSatisfying(
              coiDeclaration -> assertThat(coiDeclaration.getFieldByName("additionalProperties")).isPresent());
        });
  }

  @Test
  void testConfigToGeneratePreservedUnknownFields() {
    // Arrange
    Config config = new Config(null, null, null, true, new HashMap<>(), new ArrayList<>(), null, null, null);
    JObject obj = new JObject(
        null,
        "t",
        null,
        null,
        false,
        config,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement().satisfies(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent().hasValueSatisfying(
              coiDeclaration -> assertThat(coiDeclaration.getFieldByName("additionalProperties")).isPresent());
        });
  }

  @Test
  void testObjectWithSpecialFieldNames() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps newObj = new JSONSchemaProps();
    newObj.setType("string");
    props.put("description", newObj);

    JObject obj = new JObject(
        null,
        "t",
        props,
        null,
        false,
        defaultConfig,
        null,
        Boolean.FALSE,
        null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement().satisfies(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent().hasValueSatisfying(
              coiDeclaration -> assertThat(coiDeclaration.getFieldByName("description")).isPresent());
        });
  }

  @Test
  void testObjectNullableFieldsManagement() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps nullableObj = new JSONSchemaProps();
    nullableObj.setType("object");
    nullableObj.setNullable(Boolean.TRUE);
    props.put("o1", nullableObj);

    JSONSchemaProps nonNullableObj = new JSONSchemaProps();
    nonNullableObj.setType("object");
    nonNullableObj.setNullable(Boolean.FALSE);
    props.put("o2", nonNullableObj);

    JObject obj = new JObject(null, "t", props, null, false, defaultConfig, null, Boolean.FALSE, null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("O1");
          assertThat(classResult.getClassByName("O1")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("O2");
          assertThat(classResult.getClassByName("O2")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent()
              .hasValueSatisfying(clz -> {
                assertThat(clz.getFields()).hasSize(2);
                assertThat(clz.getFieldByName("o1")).isPresent().hasValueSatisfying(o1Field -> {
                  assertThat(o1Field.getAnnotations()).hasSize(3);
                  assertThat(o1Field.getAnnotationByName("com.fasterxml.jackson.annotation.JsonSetter")).isPresent()
                      .hasValueSatisfying(annotationExpr -> {
                        assertThat(annotationExpr).isInstanceOf(SingleMemberAnnotationExpr.class);
                        SingleMemberAnnotationExpr annotation = (SingleMemberAnnotationExpr) annotationExpr;
                        assertThat(annotation.getMemberValue().toString())
                            .isEqualTo("nulls = com.fasterxml.jackson.annotation.Nulls.SET");
                      });
                  assertThat(o1Field.getAnnotationByName("com.fasterxml.jackson.annotation.JsonProperty")).isPresent()
                      .hasValueSatisfying(annotationExpr -> {
                        assertThat(annotationExpr).isInstanceOf(SingleMemberAnnotationExpr.class);
                        SingleMemberAnnotationExpr annotation = (SingleMemberAnnotationExpr) annotationExpr;
                        assertThat(annotation.getMemberValue().toString()).isEqualTo("\"o1\"");
                      });
                  assertThat(o1Field.getAnnotationByName("io.fabric8.generator.annotation.Nullable")).isPresent();
                });
                assertThat(clz.getFieldByName("o2")).isPresent().hasValueSatisfying(o2Field -> {
                  assertThat(o2Field.getAnnotations()).hasSize(2);
                  assertThat(o2Field.getAnnotationByName("com.fasterxml.jackson.annotation.JsonSetter")).isPresent()
                      .hasValueSatisfying(annotationExpr -> {
                        assertThat(annotationExpr).isInstanceOf(SingleMemberAnnotationExpr.class);
                        SingleMemberAnnotationExpr annotation = (SingleMemberAnnotationExpr) annotationExpr;
                        assertThat(annotation.getMemberValue().toString())
                            .isEqualTo("nulls = com.fasterxml.jackson.annotation.Nulls.SKIP");
                      });
                  assertThat(o2Field.getAnnotationByName("com.fasterxml.jackson.annotation.JsonProperty")).isPresent()
                      .hasValueSatisfying(annotationExpr -> {
                        assertThat(annotationExpr).isInstanceOf(SingleMemberAnnotationExpr.class);
                        SingleMemberAnnotationExpr annotation = (SingleMemberAnnotationExpr) annotationExpr;
                        assertThat(annotation.getMemberValue().toString()).isEqualTo("\"o2\"");
                      });
                });
              });
        });
  }

  @Test
  void testObjectWithAdditionalPropertiesTrue() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps obj = new JSONSchemaProps();
    obj.setType("object");
    obj.setAdditionalProperties(new JSONSchemaPropsOrBool(true, null));
    props.put("o1", obj);

    JObject jobj = new JObject(null, "t", props, null, false, defaultConfig, null, Boolean.FALSE, null);

    // Act
    GeneratorResult res = jobj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).singleElement().satisfies(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent().hasValueSatisfying(clz -> {
            assertThat(clz.getFields()).hasSize(1);
            assertThat(clz.getFieldByName("o1")).isPresent()
                .hasValueSatisfying(o1Field -> assertThat(o1Field.getElementType().asString())
                    .isEqualTo("io.fabric8.kubernetes.api.model.AnyType"));
          });
        });
  }

  @Test
  void testClassNamesDisambiguationWithPackageNesting() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();
    JSONSchemaProps newObj1 = new JSONSchemaProps();
    JSONSchemaProps newObj2 = new JSONSchemaProps();
    newObj1.setType("object");
    newObj2.setType("object");
    Map<String, JSONSchemaProps> obj2Props = new HashMap<>();
    obj2Props.put("o1", newObj1);
    obj2Props.put("o2", newObj1);
    obj2Props.put("o3", newObj1);
    newObj2.setProperties(obj2Props);
    props.put("o1", newObj1);
    props.put("o2", newObj2);
    JObject obj = new JObject("v1alpha1", "t", props, null, false, defaultConfig, null, Boolean.FALSE, null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("O1");
          assertThat(classResult.getPackageDeclaration()).isPresent()
              .hasValueSatisfying(
                  packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1.t"));
          assertThat(classResult.getClassByName("O1")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("O1");
          assertThat(classResult.getPackageDeclaration()).isPresent()
              .hasValueSatisfying(
                  packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1.t.o2"));
          assertThat(classResult.getClassByName("O1")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("O2");
          assertThat(classResult.getPackageDeclaration()).isPresent()
              .hasValueSatisfying(
                  packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1.t.o2"));
          assertThat(classResult.getClassByName("O2")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("O3");
          assertThat(classResult.getPackageDeclaration()).isPresent()
              .hasValueSatisfying(
                  packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1.t.o2"));
          assertThat(classResult.getClassByName("O3")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("O2");
          assertThat(classResult.getPackageDeclaration()).isPresent()
              .hasValueSatisfying(
                  packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1.t"));
          assertThat(classResult.getClassByName("O2")).isPresent().hasValueSatisfying(clz -> {
            assertThat(clz.getFields()).hasSize(3);
            assertThat(clz.getFieldByName("o1")).isPresent()
                .hasValueSatisfying(o1Field -> assertThat(o1Field.getElementType().asString()).isEqualTo("v1alpha1.t.o2.O1"));
            assertThat(clz.getFieldByName("o2")).isPresent()
                .hasValueSatisfying(o2Field -> assertThat(o2Field.getElementType().asString()).isEqualTo("v1alpha1.t.o2.O2"));
            assertThat(clz.getFieldByName("o3")).isPresent()
                .hasValueSatisfying(o3Field -> assertThat(o3Field.getElementType().asString()).isEqualTo("v1alpha1.t.o2.O3"));
          });
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getPackageDeclaration()).isPresent()
              .hasValueSatisfying(packageDeclaration -> assertThat(packageDeclaration.getNameAsString()).isEqualTo("v1alpha1"));
          assertThat(classResult.getClassByName("T")).isPresent()
              .hasValueSatisfying(clz -> {
                assertThat(clz.getFields()).hasSize(2);
                assertThat(clz.getFieldByName("o1")).isPresent()
                    .hasValueSatisfying(o1Field -> assertThat(o1Field.getElementType().asString()).isEqualTo("v1alpha1.t.O1"));
                assertThat(clz.getFieldByName("o2")).isPresent()
                    .hasValueSatisfying(o2Field -> assertThat(o2Field.getElementType().asString()).isEqualTo("v1alpha1.t.O2"));
              });
        });
  }

  @Test
  void testObjectDefaultFieldsManagement() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();

    JSONSchemaProps objWithDefaultValues = new JSONSchemaProps();
    objWithDefaultValues.setType("object");
    String jsonContent = "{\"limits\":{\"memory\":\"1024Mi\",\"cpu\":\"\"},\"requests\":{\"memory\":\"1024Mi\",\"cpu\":\"1\"}}";
    JsonNode defaultValue = Serialization.unmarshal(jsonContent, JsonNode.class);
    objWithDefaultValues.setDefault(defaultValue);
    props.put("o1", objWithDefaultValues);

    JSONSchemaProps objWithoutDefaultValues = new JSONSchemaProps();
    objWithoutDefaultValues.setType("object");
    props.put("o2", objWithoutDefaultValues);

    JObject obj = new JObject(null, "t", props, null, false, defaultConfig, null, Boolean.FALSE, null);

    // Act
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(res.getTopLevelClasses()).satisfiesExactly(
        classResult -> {
          assertThat(classResult.getName()).isEqualTo("O1");
          assertThat(classResult.getClassByName("O1")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("O2");
          assertThat(classResult.getClassByName("O2")).isPresent();
        }, classResult -> {
          assertThat(classResult.getName()).isEqualTo("T");
          assertThat(classResult.getClassByName("T")).isPresent()
              .hasValueSatisfying(clz -> {
                assertThat(clz.getFields()).hasSize(2);
                assertThat(clz.getFieldByName("o1")).isPresent()
                    .hasValueSatisfying(o1Field -> assertThat(o1Field.getVariable(0)).isNotNull()
                        .satisfies(variableDeclarator -> assertThat(variableDeclarator.getInitializer()).isPresent()));
                assertThat(clz.getFieldByName("o2")).isPresent()
                    .hasValueSatisfying(o2Field -> assertThat(o2Field.getVariable(0)).isNotNull()
                        .satisfies(variableDeclarator -> assertThat(variableDeclarator.getInitializer()).isNotPresent()));
              });
        });
  }

  @Test
  void testExactlyMoreThanOneDuplicatedFieldFailsWithException() {
    // Arrange
    Map<String, JSONSchemaProps> props = new HashMap<>();

    JSONSchemaProps duplicatedFieldObject = new JSONSchemaProps();
    duplicatedFieldObject.setType("boolean");
    duplicatedFieldObject.setDescription("This field is JUST FOR testing purposes.");
    props.put("test_Dup", duplicatedFieldObject);
    duplicatedFieldObject.setDescription("Deprecated: This field is JUST FOR testing purposes.");
    props.put("test Dup", duplicatedFieldObject);
    props.put("test.Dup", duplicatedFieldObject);

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
    Map<String, JSONSchemaProps> props = new HashMap<>();

    JSONSchemaProps duplicatedFieldObject = new JSONSchemaProps();
    duplicatedFieldObject.setType("boolean");
    duplicatedFieldObject.setDescription("This field is JUST FOR testing purposes.");
    props.put("testDup", duplicatedFieldObject);
    props.put("test-Dup", duplicatedFieldObject);

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
    Config config = Config.builder()
        .existingJavaTypes(Collections.singletonMap("v1alpha1.T", "org.test.ExistingJavaType")).build();
    JObject obj = new JObject(
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
    GeneratorResult res = obj.generateJava();

    // Assert
    assertThat(obj.getType()).isEqualTo("org.test.ExistingJavaType");
    assertThat(res.getTopLevelClasses()).isEmpty();
  }
}
