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
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArray;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBool;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
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
  protected V1JSONSchemaProps fromAnnotation(Class<?> rawClass, boolean isTargetType, JSONSchema schema) {
    V1JSONSchemaProps result = super.fromAnnotation(rawClass, isTargetType, schema);
    // maybe override the type if it was determined by reading the optional `implementation`
    setIfDefined(schema.type(), result::setType);
    setIfDefined(schema.$ref(), result::set$ref);
    setIfDefined(schema.$schema(), result::set$schema);
    setIfDefined(schema.additionalItems(), this::mapSchemaOrBool, result::setAdditionalItems);
    setIfDefined(schema.additionalProperties(), this::mapSchemaOrBool, result::setAdditionalProperties);
    setIfDefined(schema.definitions(), LinkedHashMap::new, this::mapSchemaMap, result::setDefinitions);
    setIfDefined(schema.dependencies(), LinkedHashMap::new, this::mapDependencies, result::setDependencies);
    setIfDefined(schema.enumeration(), ArrayList::new, v -> parseJson(v, rawClass), result::setEnum);
    setIfDefined(schema.example(), v -> parseJson(v, rawClass), result::setExample);
    setIfDefined(schema.externalDocs(), this::mapExternalDocs, result::setExternalDocs);
    setIfDefined(schema.id(), result::setId);
    setIfDefined(schema.multipleOf(), result::setMultipleOf);
    setIfDefined(schema.patternProperties(), LinkedHashMap::new, this::mapSchemaMap, result::setPatternProperties);
    setIfDefined(schema.title(), result::setTitle);
    setIfDefined(schema.uniqueItems(), this::mapBoolean, result::setUniqueItems);
    setIfDefined(schema.xKubernetesEmbeddedResource(), this::mapBoolean, result::setXKubernetesEmbeddedResource);
    setIfDefined(schema.xKubernetesIntOrString(), this::mapBoolean, result::setXKubernetesIntOrString);
    setIfDefined(schema.xKubernetesListMapKeys(), ArrayList::new, Arrays::asList, result::setXKubernetesListMapKeys);
    setIfDefined(schema.xKubernetesListType(), result::setXKubernetesListType);
    setIfDefined(schema.xKubernetesMapType(), result::setXKubernetesMapType);
    setIfDefined(schema.xKubernetesValidations(), ArrayList::new, this::mapValidationRules, result::setXKubernetesValidations);

    if (schema.structural()) {
      List<JSONSchemaProps> allOf = new ArrayList<>(schema.allOf().length);
      List<JSONSchemaProps> anyOf = new ArrayList<>(schema.anyOf().length);
      AtomicReference<JSONSchemaPropsOrArray> items = new AtomicReference<>();
      AtomicReference<JSONSchemaProps> not = new AtomicReference<>();
      List<JSONSchemaProps> oneOf = new ArrayList<>(schema.oneOf().length);
      Map<String, JSONSchemaProps> properties = new LinkedHashMap<>();

      Consumer<JSONSchemaProps> addProperties = s -> s.getProperties().forEach(properties::putIfAbsent);
      /**
       * Only sets the items if they have not yet been set.
       */
      Consumer<JSONSchemaProps> maybeSetItems = s -> items.compareAndSet(null, s.getItems());

      setIfDefined(schema.items(), this::mapSchemaOrArray, items::set);

      setIfDefined(schema.allOf(), ArrayList::new, this::mapSchemaList, (List<JSONSchemaProps> schemas) -> {
        schemas.stream().map(this::mapJunctorSchema).forEach(allOf::add);
        schemas.forEach(addProperties);
        schemas.forEach(maybeSetItems);
      });

      setIfDefined(schema.anyOf(), ArrayList::new, this::mapSchemaList, (List<JSONSchemaProps> schemas) -> {
        schemas.stream().map(this::mapJunctorSchema).forEach(anyOf::add);
        schemas.forEach(addProperties);
        schemas.forEach(maybeSetItems);
      });

      setIfDefined(schema.not(), this::mapSchema, notSchema -> {
        not.set(mapJunctorSchema(notSchema));
        addProperties.accept(notSchema);
        maybeSetItems.accept(notSchema);
      });

      setIfDefined(schema.oneOf(), ArrayList::new, this::mapSchemaList, (List<JSONSchemaProps> schemas) -> {
        schemas.stream().map(this::mapJunctorSchema).forEach(oneOf::add);
        schemas.forEach(addProperties);
        schemas.forEach(maybeSetItems);
      });

      setIfDefined(schema.properties(), LinkedHashMap::new, this::mapSchemaMap, properties::putAll);

      result.setAllOf(allOf);
      result.setAnyOf(anyOf);
      result.setItems(items.get());
      result.setNot(not.get());
      result.setOneOf(oneOf);
      result.setProperties(properties);
    } else {
      setIfDefined(schema.allOf(), ArrayList::new, this::mapSchemaList, result::setAllOf);
      setIfDefined(schema.anyOf(), ArrayList::new, this::mapSchemaList, result::setAnyOf);
      setIfDefined(schema.items(), this::mapSchemaOrArray, result::setItems);
      setIfDefined(schema.not(), this::mapSchema, result::setNot);
      setIfDefined(schema.oneOf(), ArrayList::new, this::mapSchemaList, result::setOneOf);
      setIfDefined(schema.properties(), LinkedHashMap::new, this::mapSchemaMap, result::setProperties);
    }

    return result;
  }

  @Override
  protected V1JSONSchemaProps mapImplementation(Class<?> value, boolean isTargetType) {
    if (JSONSchema.Undefined.isUndefined(value)) {
      return null; // NOSONAR
    }
    return new JsonSchema(resolvingContext.forkContext(isTargetType), value).getSchema();
  }

  private JSONSchemaPropsOrBool mapSchemaOrBool(Class<?> value) {
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

  private JSONSchemaPropsOrArray mapSchemaOrArray(Class<?>[] values) {
    return mapSchemaOrArray(mapSchemaList(values));
  }

  private JSONSchemaPropsOrArray mapSchemaOrArray(List<JSONSchemaProps> schemas) {
    JSONSchemaPropsOrArray result = new JSONSchemaPropsOrArray();

    if (schemas.size() == 1) {
      result.setSchema(schemas.get(0));
    } else {
      result.setJSONSchemas(schemas);
    }

    return result;
  }

  private JSONSchemaProps mapSchema(Class<?> value) {
    return new JsonSchema(resolvingContext.forkContext(false), value).getSchema();
  }

  private List<JSONSchemaProps> mapSchemaList(Class<?>[] values) {
    return Arrays.stream(values).map(this::mapSchema).collect(Collectors.toList());
  }

  /**
   * Suppress attributes disallowed within a logical junctor (allOf, anyOf, oneOf, not). This functionality
   * is in support of rule #3 from "Specifying a structural schema".
   *
   * @see https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#specifying-a-structural-schema
   */
  private JSONSchemaProps mapJunctorSchema(JSONSchemaProps schema) {
    JSONSchemaPropsBuilder builder = schema.edit()
        .withDescription(null)
        .withDefault(null)
        .withAdditionalProperties(null)
        .withNullable(null)
        .withItems(Optional.ofNullable(schema.getItems())
            .map(items -> Stream
                .concat(
                    Optional.ofNullable(items.getJSONSchemas())
                        .map(List::stream)
                        .orElseGet(Stream::empty),
                    Stream.of(items.getSchema()))
                .filter(Objects::nonNull)
                .map(this::mapJunctorSchema)
                .collect(Collectors.toList()))
            .map(this::mapSchemaOrArray)
            .orElse(null))
        .withProperties(schema.getProperties().entrySet()
            .stream()
            // Recursively remove property attributes
            .map(e -> Map.entry(e.getKey(), mapJunctorSchema(e.getValue())))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    if (!Boolean.TRUE.equals(schema.getXKubernetesIntOrString())) {
      builder.withType(null);
    }

    return builder.build();
  }

  private Map<String, JSONSchemaProps> mapSchemaMap(JSONSchema.Map[] entries) {
    return Arrays.stream(entries)
        .map(e -> Map.entry(e.name(), mapSchema(e.value())))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  private Map<String, JSONSchemaPropsOrStringArray> mapDependencies(JSONSchema.DependencyMap[] entries) {
    return Arrays.stream(entries)
        .map(e -> {
          JSONSchemaPropsOrStringArray result = new JSONSchemaPropsOrStringArray();
          setIfDefined(e.value().properties(), ArrayList::new, Arrays::asList, result::setProperty);
          setIfDefined(e.value().schema(), this::mapSchema, result::setSchema);
          return Map.entry(e.name(), result);
        })
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  private ExternalDocumentation mapExternalDocs(JSONSchema.ExternalDocumentation externalDocs) {
    ExternalDocumentation result = new ExternalDocumentation();
    setIfDefined(externalDocs.description(), result::setDescription);
    setIfDefined(externalDocs.url(), result::setUrl);
    return result;
  }

  private List<ValidationRule> mapValidationRules(io.fabric8.generator.annotation.ValidationRule[] values) {
    return Arrays.stream(values).map(super::from).collect(Collectors.toList());
  }
}
