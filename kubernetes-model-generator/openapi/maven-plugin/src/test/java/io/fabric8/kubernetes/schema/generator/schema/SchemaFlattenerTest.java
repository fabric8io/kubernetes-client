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
                    .addProperty("common", new ObjectSchema()
                        .addProperty("name", new StringSchema()))))));
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
            .addProperty("selector", new ObjectSchema()
                .addProperty("in-spec", new BooleanSchema())
                .addProperty("matchLabels", new MapSchema().additionalProperties(new StringSchema()))))
        .addProperty("status", new ObjectSchema()
            .addProperty("phase", new StringSchema())
            .addProperty("selector", new ObjectSchema()
                .addProperty("in-status", new BooleanSchema())
                .addProperty("matchLabels", new MapSchema().additionalProperties(new StringSchema())))));

    SchemaFlattener.flatten(openAPI);
  }

  @ParameterizedTest
  @ValueSource(strings = { "RootChild", "RootCChild", "RootCCChild" })
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
    @ValueSource(strings = { "RootCCChild", "GRootCCChild", "com.example.with.package.RootCCChild" })
    void contractsNameOfThirdInlined(String expectedComponentName) {
      assertTrue(openAPI.getComponents().getSchemas().containsKey(expectedComponentName));
    }

  }

  @Nested
  class ReusesCommonSchema {

    @Test
    void grootChildReusesRootSchema() {
      assertEquals("#/components/schemas/RootCCChild",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("GRootCCChild").getProperties().get("common")).get$ref());
    }

    @Test
    void arrayChildReusesRootSchema() {
      assertEquals("#/components/schemas/RootCCChild",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("ArrayCChild").getProperties().get("common")).get$ref());
    }

    @Test
    void arraySchemaReusesRootSchema() {
      assertEquals("#/components/schemas/RootCCChild",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("CommonArray").getProperties().get("child")).getItems()
              .get$ref());
    }

    @Test
    void mapChildReusesRootSchema() {
      assertEquals("#/components/schemas/RootCCChild",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("MapCChild").getProperties().get("common")).get$ref());
    }

    @Test
    void packagedChildReusesRootSchema() {
      assertEquals("#/components/schemas/RootCCChild",
          ((Schema<?>) openAPI.getComponents().getSchemas().get("com.example.with.package.RootCCChild").getProperties()
              .get("common")).get$ref());
    }
  }

  /**
   * To avoid problems with Sundrio (https://github.com/fabric8io/kubernetes-client/issues/6320)
   * we'll do special handling of inlined nested fields (spec, status, parameters)
   * <p>
   * This is required because their names will likely collision with the generated classes when creating the builders
   */
  @Nested
  class SundrioHandling {

    @ParameterizedTest
    @ValueSource(strings = {
        "com.example.kubernetes.TypicalSpc",
        "com.example.kubernetes.TypicalSts"
    })
    void keywordsAreTranslated(String expectedComponentName) {
      assertTrue(openAPI.getComponents().getSchemas().containsKey(expectedComponentName));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "com.example.kubernetes.TypicalSpecSelector",
        "com.example.kubernetes.TypicalStatusSelector"
    })
    void preservesInlinedKeywords(String expectedComponentName) {
      assertTrue(openAPI.getComponents().getSchemas().containsKey(expectedComponentName));
    }
  }
}
