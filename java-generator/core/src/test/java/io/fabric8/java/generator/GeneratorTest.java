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
package io.fabric8.java.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import io.fabric8.java.generator.nodes.*;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    static final JObjectOptions dummyOptions = new JObjectOptions(false, "", "");

    @BeforeEach
    void beforeEach() {
        AbstractJSONSchema2Pojo.resetClassNames();
    }

    @Test
    void testCorrectInterpolationOfPackage() {
        // Arrange
        CRGeneratorRunner runner = new CRGeneratorRunner();

        // Act
        String packageName = runner.getPackage("test.org");

        // Assert
        assertEquals("org.test", packageName);
    }

    @Test
    void testCR() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
        JCRObject cro = new JCRObject("t", "g", "v", true, true);

        // Act
        GeneratorResult res = cro.generateJava(cu);

        // Assert
        assertEquals(1, res.getTopLevelClasses().size());
        assertEquals("t", res.getTopLevelClasses().get(0));
    }

    @Test
    void testPrimitive() {
        // Arrange
        JPrimitive primitive = new JPrimitive("test");

        // Act
        GeneratorResult res = primitive.generateJava(new CompilationUnit());

        // Assert
        assertEquals("test", primitive.getType());
        assertEquals(0, res.getTopLevelClasses().size());
    }

    @Test
    void testArrayOfPrimitives() {
        // Arrange
        JArray array = new JArray(new JPrimitive("primitive"));

        // Act
        GeneratorResult res = array.generateJava(new CompilationUnit());

        // Assert
        assertEquals("java.util.List<primitive>", array.getType());
        assertEquals(0, res.getTopLevelClasses().size());
    }

    @Test
    void testMapOfPrimitives() {
        // Arrange
        JMap map = new JMap(new JPrimitive("primitive"));

        // Act
        GeneratorResult res = map.generateJava(new CompilationUnit());

        // Assert
        assertEquals("java.util.Map<java.lang.String, primitive>", map.getType());
        assertEquals(0, res.getTopLevelClasses().size());
    }

    @Test
    void testEmptyObject() {
        // Arrange
        JObject obj = new JObject("t", null, null, dummyOptions);

        // Act
        GeneratorResult res = obj.generateJava(new CompilationUnit());

        // Assert
        assertEquals("T", obj.getType());
        assertEquals(1, res.getTopLevelClasses().size());
        assertEquals("T", res.getTopLevelClasses().get(0));
    }

    @Test
    void testObjectOfPrimitives() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
        Map<String, JSONSchemaProps> props = new HashMap<>();
        JSONSchemaProps newBool = new JSONSchemaProps();
        newBool.setType("boolean");
        props.put("o1", newBool);
        JObject obj = new JObject("t", props, null, dummyOptions);

        // Act
        GeneratorResult res = obj.generateJava(cu);

        // Assert
        assertEquals("T", obj.getType());
        assertEquals(1, res.getTopLevelClasses().size());
        assertEquals("T", res.getTopLevelClasses().get(0));

        Optional<ClassOrInterfaceDeclaration> clz = cu.getClassByName("T");
        assertTrue(clz.isPresent());
        assertEquals(1, clz.get().getFields().size());
        assertTrue(clz.get().getFieldByName("o1").isPresent());
    }

    @Test
    void testObjectWithRequiredField() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
        Map<String, JSONSchemaProps> props = new HashMap<>();
        JSONSchemaProps newBool = new JSONSchemaProps();
        newBool.setType("boolean");
        props.put("o1", newBool);
        List<String> req = new ArrayList<>(1);
        req.add("o1");
        JObject obj = new JObject("t", props, req, dummyOptions);

        // Act
        GeneratorResult res = obj.generateJava(cu);

        // Assert
        Optional<ClassOrInterfaceDeclaration> clz = cu.getClassByName("T");
        assertTrue(clz.get().getFieldByName("o1").get().getAnnotationByName("NotNull").isPresent());
    }

    @Test
    void testEnum() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
        Map<String, JSONSchemaProps> props = new HashMap<>();
        JSONSchemaProps newEnum = new JSONSchemaProps();
        newEnum.setType("string");
        List<JsonNode> enumValues = new ArrayList<>();
        enumValues.add(new TextNode("foo"));
        enumValues.add(new TextNode("bar"));
        enumValues.add(new TextNode("baz"));
        props.put("e1", newEnum);
        JEnum enu = new JEnum("t", enumValues);

        // Act
        GeneratorResult res = enu.generateJava(cu);

        // Assert
        assertEquals("T", enu.getType());
        assertEquals(1, res.getInnerClasses().size());
        assertEquals("T", res.getInnerClasses().get(0));

        Optional<EnumDeclaration> en = cu.getEnumByName("T");
        assertTrue(en.isPresent());
        assertEquals(3, en.get().getEntries().size());
        assertEquals("foo", en.get().getEntries().get(0).getName().asString());
        assertEquals("bar", en.get().getEntries().get(1).getName().asString());
        assertEquals("baz", en.get().getEntries().get(2).getName().asString());
    }

    @Test
    void testArrayOfObjects() {
        // Arrange
        JArray array = new JArray(new JObject("t", null, null, dummyOptions));

        // Act
        GeneratorResult res = array.generateJava(new CompilationUnit());

        // Assert
        assertEquals("java.util.List<T>", array.getType());
        assertEquals(1, res.getTopLevelClasses().size());
        assertEquals("T", res.getTopLevelClasses().get(0));
    }

    @Test
    void testMapOfObjects() {
        // Arrange
        JMap map = new JMap(new JObject("t", null, null, dummyOptions));

        // Act
        GeneratorResult res = map.generateJava(new CompilationUnit());

        // Assert
        assertEquals("java.util.Map<java.lang.String, T>", map.getType());
        assertEquals(1, res.getTopLevelClasses().size());
        assertEquals("T", res.getTopLevelClasses().get(0));
    }

    @Test
    void testObjectOfObjects() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
        Map<String, JSONSchemaProps> props = new HashMap<>();
        JSONSchemaProps newObj = new JSONSchemaProps();
        newObj.setType("object");
        props.put("o1", newObj);
        JObject obj = new JObject("t", props, null, dummyOptions);

        // Act
        GeneratorResult res = obj.generateJava(cu);

        // Assert
        assertEquals(2, res.getTopLevelClasses().size());
        assertEquals("O1", res.getTopLevelClasses().get(0));
        assertEquals("T", res.getTopLevelClasses().get(1));

        Optional<ClassOrInterfaceDeclaration> clzT = cu.getClassByName("T");
        assertTrue(clzT.isPresent());
        assertEquals(1, clzT.get().getFields().size());
        assertTrue(clzT.get().getFieldByName("o1").isPresent());
        Optional<ClassOrInterfaceDeclaration> clzO1 = cu.getClassByName("O1");
        assertTrue(clzO1.isPresent());
    }

    @Test
    void testObjectWithPreservedFields() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
        JObject obj = new JObject("t", null, null, new JObjectOptions(true, "", ""));

        // Act
        GeneratorResult res = obj.generateJava(cu);

        // Assert
        assertEquals(1, res.getTopLevelClasses().size());
        assertEquals("T", res.getTopLevelClasses().get(0));

        Optional<ClassOrInterfaceDeclaration> clzT = cu.getClassByName("T");
        assertTrue(clzT.isPresent());
        assertTrue(clzT.get().getFieldByName("additionalProperties").isPresent());
    }

    @Test
    void testClassNamesDisambiguation() {
        // Arrange
        CompilationUnit cu = new CompilationUnit();
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
        JObject obj = new JObject("t", props, null, dummyOptions);

        // Act
        GeneratorResult res = obj.generateJava(cu);

        // Assert
        assertEquals(6, res.getTopLevelClasses().size());
        // The order here is not important
        assertEquals("O1", res.getTopLevelClasses().get(0));
        assertEquals("O10", res.getTopLevelClasses().get(1));
        assertEquals("O20", res.getTopLevelClasses().get(2));
        assertEquals("O3", res.getTopLevelClasses().get(3));
        assertEquals("O2", res.getTopLevelClasses().get(4));
        assertEquals("T", res.getTopLevelClasses().get(5));

        Optional<ClassOrInterfaceDeclaration> clzT = cu.getClassByName("T");
        assertTrue(clzT.isPresent());
        assertEquals(2, clzT.get().getFields().size());
        assertTrue(clzT.get().getFieldByName("o1").isPresent());
        Optional<ClassOrInterfaceDeclaration> clzO1 = cu.getClassByName("O1");
        assertTrue(clzO1.isPresent());
        Optional<ClassOrInterfaceDeclaration> clzO2 = cu.getClassByName("O2");
        assertTrue(clzO2.isPresent());
        assertTrue(clzO2.get().getFieldByName("o1").isPresent());
        assertTrue(clzO2.get().getFieldByName("o2").isPresent());
        assertTrue(clzO2.get().getFieldByName("o3").isPresent());
    }
}
