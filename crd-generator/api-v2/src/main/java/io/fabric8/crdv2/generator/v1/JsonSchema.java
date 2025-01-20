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

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.crdv2.generator.AbstractJsonSchema;
import io.fabric8.crdv2.generator.KubernetesJSONSchemaProps;
import io.fabric8.crdv2.generator.KubernetesValidationRule;
import io.fabric8.crdv2.generator.ResolvingContext;
import io.fabric8.crdv2.generator.v1.JsonSchema.V1JSONSchemaProps;
import io.fabric8.crdv2.generator.v1.JsonSchema.V1ValidationRule;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRule;

import java.util.Arrays;
import java.util.List;

public class JsonSchema extends AbstractJsonSchema<V1JSONSchemaProps, V1ValidationRule> {

  public static class V1ValidationRule extends ValidationRule implements KubernetesValidationRule {

  }

  public static class V1JSONSchemaProps extends JSONSchemaProps implements KubernetesJSONSchemaProps {

  }

  public static JSONSchemaProps from(Class<?> definition) {
    return new JsonSchema(ResolvingContext.defaultResolvingContext(false), definition).getSchema();
  }

  public JsonSchema(ResolvingContext resolvingContext, Class<?> definition) {
    super(resolvingContext, definition);
  }

  @Override
  protected V1ValidationRule newKubernetesValidationRule() {
    return new V1ValidationRule();
  }

  @Override
  protected void addToValidationRules(V1JSONSchemaProps schema, List<V1ValidationRule> validationRules) {
    schema.getXKubernetesValidations().addAll(validationRules);
  }

  @Override
  protected void addProperty(String name, V1JSONSchemaProps objectSchema, V1JSONSchemaProps schema) {
    objectSchema.getProperties().put(name, schema);
  }

  @Override
  protected V1JSONSchemaProps arrayLikeProperty(V1JSONSchemaProps schema) {
    V1JSONSchemaProps result = singleProperty("array");
    result.setItems(new JSONSchemaPropsOrArray(null, schema));
    return result;
  }

  @Override
  protected V1JSONSchemaProps mapLikeProperty(V1JSONSchemaProps schema) {
    V1JSONSchemaProps result = singleProperty("object");
    result.setAdditionalProperties(new JSONSchemaPropsOrBool(null, schema));
    return result;
  }

  @Override
  protected V1JSONSchemaProps singleProperty(String typeName) {
    V1JSONSchemaProps result = new V1JSONSchemaProps();
    result.setType(typeName);
    return result;
  }

  @Override
  protected V1JSONSchemaProps intOrString() {
    V1JSONSchemaProps result = new V1JSONSchemaProps();
    result.setXKubernetesIntOrString(true);
    result.setAnyOf(Arrays.asList(singleProperty("integer"), singleProperty("string")));
    return result;
  }

  @Override
  protected V1JSONSchemaProps enumProperty(JsonNode... enumValues) {
    V1JSONSchemaProps result = singleProperty("string");
    result.setEnum(Arrays.asList(enumValues));
    return result;
  }

  @Override
  protected V1JSONSchemaProps raw() {
    V1JSONSchemaProps result = singleProperty(null);
    result.setXKubernetesEmbeddedResource(true);
    result.setType("object");
    return result;
  }

}
