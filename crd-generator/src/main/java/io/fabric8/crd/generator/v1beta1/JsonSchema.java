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
package io.fabric8.crd.generator.v1beta1;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsBuilder;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import java.util.List;

public class JsonSchema extends io.fabric8.crd.generator.JsonSchema<JSONSchemaProps, JSONSchemaPropsBuilder> {

  private static final JsonSchema instance = new JsonSchema();

  /**
   * Creates the JSON schema for the particular {@link TypeDef}.
   *
   * @param definition The definition.
   * @param ignore     an optional list of property names to ignore
   * @return The schema.
   */
  public static JSONSchemaProps from(
    TypeDef definition, String... ignore) {
    return instance.internalFrom(definition, ignore);
  }

  @Override
  public JSONSchemaPropsBuilder newBuilder() {
    final JSONSchemaPropsBuilder builder = new JSONSchemaPropsBuilder();
    builder.withType("object");
    return builder;
  }

  @Override
  public void addProperty(Property property, JSONSchemaPropsBuilder builder,
    JSONSchemaProps schema) {
    if (schema != null) {
      builder.addToProperties(property.getName(), schema);
    }
  }

  @Override
  public JSONSchemaProps build(JSONSchemaPropsBuilder builder, List<String> required) {
    return builder.withRequired(required).build();
  }

  @Override
  protected JSONSchemaProps collectionProperty(JSONSchemaProps schema) {
    return new JSONSchemaPropsBuilder()
      .withType("array")
      .withNewItems()
      .withSchema(schema)
      .and()
      .build();
  }

  @Override
  protected JSONSchemaProps singleProperty(String typeName) {
    return new JSONSchemaPropsBuilder()
      .withType(typeName)
      .build();
  }
}
