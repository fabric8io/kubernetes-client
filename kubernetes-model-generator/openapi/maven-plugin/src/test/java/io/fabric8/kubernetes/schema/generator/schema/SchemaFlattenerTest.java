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

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchemaFlattenerTest {

  private OpenAPI openAPI;

  @BeforeEach
  void setUp() {
    openAPI = new OpenAPI(SpecVersion.V31);
    openAPI.setComponents(new Components());
    openAPI.setPaths(new Paths());
    openAPI.getComponents().addSchemas("Common", new ObjectSchema()
        .addProperty("name", new StringSchema()));
    openAPI.getComponents().addSchemas("Root", new ObjectSchema()
        .addProperty("child", new ObjectSchema()
            .addProperty("name", new StringSchema())
            .addProperty("child", new ObjectSchema()
                .addProperty("name", new StringSchema())
                .addProperty("child", new ObjectSchema()
                    .addProperty("name", new StringSchema())))));
    openAPI.getComponents().addSchemas("GRoot", new ObjectSchema()
        .title("")
        .addProperty("child", new ObjectSchema()
            .addProperty("gName", new StringSchema())
            .addProperty("child", new ObjectSchema()
                .addProperty("gName", new StringSchema())
                .addProperty("child", new ObjectSchema()
                    .addProperty("gName", new StringSchema())
                    .addProperty("common", new ObjectSchema()
                        .addProperty("name", new StringSchema()))))));
    openAPI.getComponents().addSchemas("Array", new ObjectSchema()
        .addProperty("child", new ArraySchema()
            .items(new ObjectSchema()
                .addProperty("aName", new StringSchema())
                .addProperty("child", new ObjectSchema()
                    .addProperty("aName", new StringSchema())
                    .addProperty("common", new ObjectSchema()
                        .addProperty("name", new StringSchema()))))));
    openAPI.getComponents().addSchemas("Map", new ObjectSchema()
        .addProperty("child", new MapSchema()
            .additionalProperties(new ObjectSchema()
                .addProperty("mName", new StringSchema())
                .addProperty("child", new ObjectSchema()
                    .addProperty("mName", new StringSchema())
                    .addProperty("child", new ObjectSchema()
                        .addProperty("mName", new StringSchema())
                        .addProperty("common", new ObjectSchema()
                            .addProperty("name", new StringSchema())))))));
    openAPI.getComponents().addSchemas("CommonArray", new ObjectSchema()
        .addProperty("child", new ArraySchema()
            .items(new ObjectSchema()
                .addProperty("name", new StringSchema()))));
    openAPI.getComponents().addSchemas("com.example.with.package.Root", new ObjectSchema()
        .addProperty("child", new ObjectSchema()
            .addProperty("withPackageName", new StringSchema())
            .addProperty("child", new ObjectSchema()
                .addProperty("withPackageName", new StringSchema())
                .addProperty("child", new ObjectSchema()
                    .addProperty("withPackageName", new StringSchema())
                    .addProperty("common", new ObjectSchema()
                        .addProperty("name", new StringSchema()))))));
    openAPI.getComponents().addSchemas("RootWithTitle", new ObjectSchema()
        .addProperty("child", new ObjectSchema()
            .title("GrandParent")
            .addProperty("withTitle", new StringSchema())
            .addProperty("child", new ObjectSchema()
                .addProperty("name", new StringSchema()))));
    openAPI.getComponents().addSchemas("com.example.kubernetes.Typical", new ObjectSchema()
        .addProperty("kind", new StringSchema())
        .addProperty("apiVersion", new StringSchema())
        .addProperty("metadata", new ObjectSchema())
        .addProperty("spec", new ObjectSchema()
            .addProperty("replicas", new IntegerSchema())
            .addProperty("openAPI", new ObjectSchema()
                .addProperty("in-openAPI", new StringSchema())
                .addProperty("schema", new ObjectSchema()
                    .addProperty("$ref", new StringSchema())))
            .addProperty("selector", new ObjectSchema()
                .addProperty("in-spec", new BooleanSchema())
                .addProperty("matchLabels", new MapSchema().additionalProperties(new StringSchema())))
            .addProperty("aws", new ObjectSchema()
                .addProperty("spec", new ObjectSchema()
                    .addProperty("in-aws", new StringSchema())))
            .addProperty("libvirt", new ObjectSchema()
                .addProperty("spec", new ObjectSchema()
                    .addProperty("in-libvirt", new StringSchema()))))

        .addProperty("status", new ObjectSchema()
            .addProperty("phase", new StringSchema())
            .addProperty("selector", new ObjectSchema()
                .addProperty("in-status", new BooleanSchema())
                .addProperty("matchLabels", new MapSchema().additionalProperties(new StringSchema())))));

    SchemaFlattener.flatten(openAPI);
  }

  @ParameterizedTest
  @ValueSource(strings = { "Common", "RootChild", "RootCChild" })
  void preservesStringFields(String componentName) {
    assertEquals("string",
        ((Schema<?>) openAPI.getComponents().getSchemas().get(componentName).getProperties().get("name")).getType());
  }

  @Nested
  @DisplayName("resolveModelName")
  class ResolveModelName {

    @Test
    void prefersTitle() {
      assertTrue(openAPI.getComponents().getSchemas().containsKey("GrandParent"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "RootChild", "GRootChild", "ArrayChild", "MapChild", "com.example.with.package.RootChild" })
    void preservesNameOfFirstInlined(String expectedComponentName) {
      assertTrue(openAPI.getComponents().getSchemas().containsKey(expectedComponentName));
    }

    @ParameterizedTest
    @ValueSource(strings = { "RootCChild", "GRootCChild", "ArrayCChild", "MapCChild", "com.example.with.package.RootCChild" })
    void contractsNameOfSecondInlined(String expectedComponentName) {
      assertTrue(openAPI.getComponents().getSchemas().containsKey(expectedComponentName));
    }

    @ParameterizedTest
    @ValueSource(strings = { "GRootCCChild", "com.example.with.package.RootCCChild", "MapCCChild" })
    void contractsNameOfThirdInlined(String expectedComponentName) {
      assertTrue(openAPI.getComponents().getSchemas().containsKey(expectedComponentName));
    }

    @Test
    void contractsContiguousUpperCaseProperly() {
      assertTrue(openAPI.getComponents().getSchemas().containsKey("com.example.kubernetes.TypicalSpecOpenAPI"));
      assertTrue(openAPI.getComponents().getSchemas().containsKey("com.example.kubernetes.TypicalSpecOASchema"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Aws", "Libvirt" })
    void contractPreservesNames(String preservedName) {
      assertTrue(
          openAPI.getComponents().getSchemas().containsKey("com.example.kubernetes.TypicalSpec" + preservedName + "Spec"));
    }

  }

  @Nested
  class ReusesCommonTopLevelSchemas {

    @Test
    void rootChildReusesCommonSchema() {
      assertEquals("#/components/schemas/Common",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("RootCChild").getProperties().get("child")).get$ref());
    }

    @Test
    void grootChildReusesCommonSchema() {
      assertEquals("#/components/schemas/Common",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("GRootCCChild").getProperties().get("common")).get$ref());
    }

    @Test
    void arrayChildReusesCommonSchema() {
      assertEquals("#/components/schemas/Common",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("ArrayCChild").getProperties().get("common")).get$ref());
    }

    @Test
    void arraySchemaReusesCommonSchema() {
      assertEquals("#/components/schemas/Common",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("CommonArray").getProperties().get("child")).getItems()
              .get$ref());
    }

    @Test
    void mapChildReusesCommonSchema() {
      assertEquals("#/components/schemas/Common",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("MapCCChild").getProperties().get("common")).get$ref());
    }

    @Test
    void packagedChildReusesCommonSchema() {
      assertEquals("#/components/schemas/Common",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("com.example.with.package.RootCCChild").getProperties()
              .get("common")).get$ref());
    }
  }
}
