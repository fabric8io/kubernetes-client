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
import io.fabric8.generator.annotation.JSONSchema;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ExternalDocumentation;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ExternalDocumentationBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRule;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  @Override
  protected V1JSONSchemaProps fromAnnotation(Class<?> targetType, JSONSchema schema) {
      V1JSONSchemaProps result = super.fromAnnotation(targetType, schema);
      setIfDefined(mapDefined(schema.type()), result::setType);
      setIfDefined(mapDefined(schema.$ref()), result::set$ref);
      setIfDefined(mapDefined(schema.$schema()), result::set$schema);
      setIfDefined(mapSchemaOrBool(schema.additionalItems()), result::setAdditionalItems);
      setIfDefined(mapSchemaOrBool(schema.additionalProperties()), result::setAdditionalProperties);
      setIfDefined(mapSchemaList(schema.allOf()), result::setAllOf);
      setIfDefined(mapSchemaList(schema.anyOf()), result::setAnyOf);
      setIfDefined(mapSchemaMap(schema.definitions()), result::setDefinitions);
      setIfDefined(mapDependencies(schema.dependencies()), result::setDependencies);
      setIfDefined(mapEnumeration(schema.enumeration(), targetType), result::setEnum);
      setIfDefined(mapDefined(schema.example(), targetType), result::setExample);
      setIfDefined(mapExternalDocs(schema.externalDocs()), result::setExternalDocs);
      setIfDefined(mapDefined(schema.id()), result::setId);
      setIfDefined(mapSchemaOrArray(schema.items()), result::setItems);
      setIfDefined(mapDefined(schema.multipleOf()), result::setMultipleOf);
      setIfDefined(mapSchema(schema.not()), result::setNot);
      setIfDefined(mapSchemaList(schema.oneOf()), result::setOneOf);
      setIfDefined(mapSchemaMap(schema.patternProperties()), result::setPatternProperties);
      setIfDefined(mapSchemaMap(schema.properties()), result::setProperties);
      setIfDefined(mapDefined(schema.title()), result::setTitle);
      setIfDefined(mapBoolean(schema.uniqueItems()), result::setUniqueItems);
      setIfDefined(mapBoolean(schema.xKubernetesEmbeddedResource()), result::setXKubernetesEmbeddedResource);
      setIfDefined(mapBoolean(schema.xKubernetesIntOrString()), result::setXKubernetesIntOrString);
      setIfDefined(mapDefined(schema.xKubernetesListMapKeys()), result::setXKubernetesListMapKeys);
      setIfDefined(mapDefined(schema.xKubernetesListType()), result::setXKubernetesListType);
      setIfDefined(mapDefined(schema.xKubernetesMapType()), result::setXKubernetesMapType);
      setIfDefined(mapValidationRules(schema.xKubernetesValidations()), result::setXKubernetesValidations);
      return result;
  }

  @Override
  protected V1JSONSchemaProps mapImplementation(Class<?> value) {
    if (value == JSONSchema.Undefined.class) {
      return null; // NOSONAR
    }
    return new JsonSchema(resolvingContext.forkContext(true), value).getSchema();
  }

  private JSONSchemaProps mapSchema(Class<?> value) {
    if (value == JSONSchema.Undefined.class) {
      return null; // NOSONAR
    }
    return new JsonSchema(resolvingContext.forkContext(false), value).getSchema();
  }

  private JSONSchemaPropsOrBool mapSchemaOrBool(Class<?> value) {
    if (value == JSONSchema.Undefined.class) {
      return null; // NOSONAR
    }
    JSONSchemaPropsOrBool result = new JSONSchemaPropsOrBool();

    if (JSONSchema.Boolean.class.isAssignableFrom(value)) {
      @SuppressWarnings("unchecked")
      Class<JSONSchema.Boolean> booleanType = (Class<JSONSchema.Boolean>) value;
      result.setAllows(mapBoolean(booleanType));
    } else {
      result.setSchema(new JsonSchema(resolvingContext.forkContext(false), value).getSchema());
    }

    return result;
  }

  private List<JsonNode> mapEnumeration(String[] examples, Class<?> targetType) {
    if (examples.length != 0) {
      return Arrays.stream(examples).map(ex -> mapDefined(ex, targetType)).collect(Collectors.toList());
    }
    return null; // NOSONAR
  }

  private JSONSchemaPropsOrArray mapSchemaOrArray(Class<?>[] values) {
    return Optional.ofNullable(mapSchemaList(values))
        .map(schemas -> {
          JSONSchemaPropsOrArray result = new JSONSchemaPropsOrArray();
          if (schemas.size() == 1) {
            result.setSchema(schemas.get(0));
          } else {
            result.setJSONSchemas(schemas);
          }
          return result;
        })
        .orElse(null);
  }

  private List<JSONSchemaProps> mapSchemaList(Class<?>[] values) {
    if (values.length == 0) {
      return null; // NOSONAR
    }

    return Arrays.stream(values)
        .map(this::mapSchema)
        .collect(Collectors.toList());
  }

  private Map<String, JSONSchemaProps> mapSchemaMap(JSONSchema.Map[] entries) {
    if (entries.length == 0) {
      return null; // NOSONAR
    }

    return Arrays.stream(entries)
        .map(e -> Map.entry(e.name(), mapSchema(e.value())))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  private Map<String, JSONSchemaPropsOrStringArray> mapDependencies(JSONSchema.DependencyMap[] entries) {
    if (entries.length == 0) {
      return null; // NOSONAR
    }

    return Arrays.stream(entries)
        .map(e -> Map.entry(e.name(), new JSONSchemaPropsOrStringArray(mapDefined(e.value().properties()), mapSchema(e.value().schema()))))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  private ExternalDocumentation mapExternalDocs(JSONSchema.ExternalDocumentation externalDocs) {
    if (Stream.of(externalDocs.description(), externalDocs.url()).allMatch(JSONSchema.Undefined.STRING::equals)) {
      return null;
    }

    return new ExternalDocumentationBuilder()
        .withDescription(mapDefined(externalDocs.description()))
        .withUrl(mapDefined(externalDocs.url()))
        .build();
  }

  private List<ValidationRule> mapValidationRules(io.fabric8.generator.annotation.ValidationRule[] values) {
    return Arrays.stream(values).map(super::from).collect(Collectors.toList());
  }
}
