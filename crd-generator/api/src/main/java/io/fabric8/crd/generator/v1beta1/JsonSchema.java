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
package io.fabric8.crd.generator.v1beta1;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.crd.generator.AbstractJsonSchema;
import io.fabric8.crd.generator.ResolvingContext;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.ValidationRule;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.ValidationRuleBuilder;

import java.util.List;

public class JsonSchema extends AbstractJsonSchema<JSONSchemaProps, JSONSchemaPropsBuilder, ValidationRule> {

  private static final JSONSchemaProps JSON_SCHEMA_INT_OR_STRING = new JSONSchemaPropsBuilder()
      .withXKubernetesIntOrString(true)
      .withAnyOf(
          new JSONSchemaPropsBuilder().withType("integer").build(),
          new JSONSchemaPropsBuilder().withType("string").build())
      .build();

  public JsonSchema(ResolvingContext resolvingContext, Class<?> definition) {
    super(resolvingContext, definition);
  }

  @Override
  public JSONSchemaPropsBuilder newBuilder() {
    return new JSONSchemaPropsBuilder().withType("object");
  }

  @Override
  protected void setDefault(JSONSchemaProps schema, JsonNode node) {
    schema.setDefault(node);
  }

  @Override
  protected void setMin(JSONSchemaProps schema, Double min) {
    schema.setMinimum(min);
  }

  @Override
  protected void setMax(JSONSchemaProps schema, Double max) {
    schema.setMaximum(max);
  }

  @Override
  protected void setFormat(JSONSchemaProps schema, String format) {
    schema.setFormat(format);
  }

  @Override
  protected void setPattern(JSONSchemaProps schema, String pattern) {
    schema.setPattern(pattern);
  }

  @Override
  protected void setNullable(JSONSchemaProps schema, Boolean nullable) {
    schema.setNullable(nullable);
  }

  @Override
  protected void setPreserveUnknown(JSONSchemaProps schema, Boolean preserveUnknown) {
    schema.setXKubernetesPreserveUnknownFields(preserveUnknown);
  }

  @Override
  protected JSONSchemaProps addToValidationRules(JSONSchemaProps schema, List<ValidationRule> validationRules) {
    return schema.edit().addAllToXKubernetesValidations(validationRules).build();
  }

  @Override
  protected void addProperty(String name, JSONSchemaPropsBuilder builder,
      JSONSchemaProps schema) {
    builder.addToProperties(name, schema);
  }

  @Override
  public JSONSchemaProps build(JSONSchemaPropsBuilder builder, List<String> required,
      List<KubernetesValidationRule> validationRules, boolean preserveUnknownFields) {
    builder = builder.withRequired(required);
    if (preserveUnknownFields) {
      builder.withXKubernetesPreserveUnknownFields(preserveUnknownFields);
    }
    builder.addAllToXKubernetesValidations(mapValidationRules(validationRules));
    return builder.build();
  }

  @Override
  protected JSONSchemaProps arrayLikeProperty(JSONSchemaProps schema) {
    return new JSONSchemaPropsBuilder()
        .withType("array")
        .withNewItems()
        .withSchema(schema)
        .and()
        .build();
  }

  @Override
  protected JSONSchemaProps mapLikeProperty(JSONSchemaProps schema) {
    return new JSONSchemaPropsBuilder()
        .withType("object")
        .withNewAdditionalProperties()
        .withSchema(schema)
        .endAdditionalProperties()
        .build();
  }

  @Override
  protected JSONSchemaProps singleProperty(String typeName) {
    return new JSONSchemaPropsBuilder().withType(typeName).build();
  }

  @Override
  protected JSONSchemaProps intOrString() {
    return JSON_SCHEMA_INT_OR_STRING;
  }

  @Override
  protected JSONSchemaProps enumProperty(JsonNode... enumValues) {
    return new JSONSchemaPropsBuilder().withType("string").withEnum(enumValues).build();
  }

  @Override
  protected JSONSchemaProps addDescription(JSONSchemaProps schema, String description) {
    return new JSONSchemaPropsBuilder(schema)
        .withDescription(description)
        .build();
  }

  @Override
  protected ValidationRule mapValidationRule(KubernetesValidationRule validationRule) {
    return new ValidationRuleBuilder()
        .withRule(validationRule.getRule())
        .withMessage(validationRule.getMessage())
        .withMessageExpression(validationRule.getMessageExpression())
        .withReason(validationRule.getReason())
        .withFieldPath(validationRule.getFieldPath())
        .withOptionalOldSelf(validationRule.getOptionalOldSelf())
        .build();
  }

  @Override
  protected String getType(JSONSchemaProps schema) {
    return schema.getType();
  }
}
