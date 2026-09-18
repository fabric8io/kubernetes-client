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
package io.fabric8.crdv2.generator;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.victools.jsonschema.generator.FieldScope;
import io.fabric8.crd.generator.annotation.AdditionalPrinterColumn;
import io.fabric8.crd.generator.annotation.AdditionalSelectableField;
import io.fabric8.crd.generator.annotation.PreserveUnknownFields;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.annotation.SchemaFrom;
import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.crd.generator.annotation.SelectableField;
import io.fabric8.crdv2.generator.InternalSchemaSwaps.SwapResult;
import io.fabric8.crdv2.generator.v1.JsonSchema.V1JSONSchemaProps;
import io.fabric8.crdv2.generator.v1.SchemaCustomizer;
import io.fabric8.generator.annotation.Default;
import io.fabric8.generator.annotation.Max;
import io.fabric8.generator.annotation.Min;
import io.fabric8.generator.annotation.Nullable;
import io.fabric8.generator.annotation.Pattern;
import io.fabric8.generator.annotation.Required;
import io.fabric8.generator.annotation.Size;
import io.fabric8.generator.annotation.ValidationRule;
import io.fabric8.generator.annotation.ValidationRules;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.annotation.LabelSelector;
import io.fabric8.kubernetes.model.annotation.SpecReplicas;
import io.fabric8.kubernetes.model.annotation.StatusReplicas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.SerializationConfig;
import tools.jackson.databind.introspect.AnnotatedClass;
import tools.jackson.databind.introspect.BeanPropertyDefinition;
import tools.jackson.databind.introspect.ClassIntrospector;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;
import tools.jackson.databind.node.StringNode;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedParameterizedType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Optional.ofNullable;

/**
 * Encapsulates the common logic supporting OpenAPI schema generation for CRD generation.
 *
 * @param <T> the concrete type of the generated JSON Schema
 * @param <V> the concrete type of the validation rule
 */
public abstract class AbstractJsonSchema<T extends KubernetesJSONSchemaProps, V extends KubernetesValidationRule> {

  private static final Logger logger = LoggerFactory.getLogger(AbstractJsonSchema.class);
  public static final String OBJECT_LITERAL = "object";
  public static final String STRING_LITERAL = "string";
  public static final String INTEGER_LITERAL = "integer";
  public static final String NUMBER_LITERAL = "number";

  private final ResolvingContext resolvingContext;
  private final T root;
  private final Set<String> dependentClasses = new HashSet<>();
  private final Set<AdditionalPrinterColumn> additionalPrinterColumns = new HashSet<>();
  private final Set<AdditionalSelectableField> additionalSelectableFields = new HashSet<>();

  public record AnnotationMetadata(Annotation annotation, KubernetesJSONSchemaProps schema) {
  }

  private final Map<Class<? extends Annotation>, LinkedHashMap<String, AnnotationMetadata>> pathMetadata = new HashMap<>();

  protected AbstractJsonSchema(ResolvingContext resolvingContext, Class<?> def) {
    this.resolvingContext = resolvingContext;
    // TODO: could make this configurable, and could stop looking for single valued ones - or warn
    Stream.of(
        SpecReplicas.class,
        StatusReplicas.class,
        LabelSelector.class,
        PrinterColumn.class,
        SelectableField.class).forEach(clazz -> pathMetadata.put(clazz, new LinkedHashMap<>()));

    this.root = resolveRoot(def);
  }

  public T getSchema() {
    return root;
  }

  public Set<String> getDependentClasses() {
    return dependentClasses;
  }

  public Optional<String> getSinglePath(Class<? extends Annotation> clazz) {
    return ofNullable(pathMetadata.get(clazz)).flatMap(m -> m.keySet().stream().findFirst());
  }

  public Map<String, AnnotationMetadata> getAllPaths(Class<? extends Annotation> clazz) {
    return ofNullable(pathMetadata.get(clazz)).orElse(new LinkedHashMap<>());
  }

  /**
   * Creates the JSON schema for the class. This is template method where
   * subclasses are supposed to provide specific implementations of abstract methods.
   *
   * @param definition The definition.
   * @return The schema.
   */
  private T resolveRoot(Class<?> definition) {
    InternalSchemaSwaps schemaSwaps = new InternalSchemaSwaps();
    ObjectNode schema = resolvingContext.toJsonSchema(definition);
    consumeRepeatingAnnotation(definition, AdditionalPrinterColumn.class,
        additionalPrinterColumns::add);
    consumeRepeatingAnnotation(definition, AdditionalSelectableField.class,
        additionalSelectableFields::add);

    // Resolve top-level $ref (victools may emit $ref at the root for some types)
    JsonNode resolved = resolveRef(schema);
    if (resolved != schema && resolved instanceof ObjectNode objectNode) {
      schema = objectNode;
    }

    String type = resolveSchemaType(schema);
    if (OBJECT_LITERAL.equals(type)) {
      return resolveObject(new LinkedHashMap<>(), schemaSwaps, schema, definition,
          "kind", "apiVersion", "metadata");
    }
    JavaType javaType = resolvingContext.objectMapper.serializationConfig()
        .constructType(definition);
    return resolveProperty(new LinkedHashMap<>(), schemaSwaps, null, javaType, schema, null);
  }

  /**
   * Resolves the schema type from a schema node, handling both scalar type values
   * and array type values (e.g. ["string", "null"] for Optional types).
   */
  private static String resolveSchemaType(ObjectNode schemaNode) {
    JsonNode typeNode = schemaNode.get("type");
    if (typeNode == null) {
      return "";
    }
    if (typeNode.isString()) {
      return typeNode.asString();
    }
    if (typeNode.isArray()) {
      // Multi-type (e.g., ["string", "null"]) - return the first non-null type
      for (JsonNode t : typeNode) {
        String tv = t.asString();
        if (!"null".equals(tv)) {
          return tv;
        }
      }
      return "null";
    }
    return "";
  }

  /**
   * Walks up the class hierarchy to consume the repeating annotation
   */
  private static <A extends Annotation> void consumeRepeatingAnnotation(Class<?> beanClass, Class<A> annotation,
      Consumer<A> consumer) {
    while (beanClass != null && beanClass != Object.class) {
      Stream.of(beanClass.getAnnotationsByType(annotation)).forEach(consumer);
      beanClass = beanClass.getSuperclass();
    }
  }

  /**
   * Walks up the class hierarchy to find the first (most specific) occurrence of the annotation.
   */
  private static <A extends Annotation> A findClassAnnotation(Class<?> beanClass, Class<A> annotation) {
    while (beanClass != null && beanClass != Object.class) {
      A found = beanClass.getAnnotation(annotation);
      if (found != null) {
        return found;
      }
      beanClass = beanClass.getSuperclass();
    }
    return null;
  }

  void collectValidationRules(FieldScope fieldScope, Class<?> ownerClass, List<V> validationRules) {
    if (fieldScope == null) {
      return;
    }
    // Collect from the field itself
    Field rawField = fieldScope.getRawMember();
    collectValidationAnnotations(rawField, validationRules);

    // Also collect from the getter method (if present and different from field annotations).
    // getAnnotationConsideringFieldAndGetter returns one or the other, but when both field
    // and getter carry @ValidationRule, both sets must be included.
    // Use ownerClass (the most specific class being processed) to find getters that may
    // override the field's declaring class getter (e.g., K8sValidation.getSpec() overrides
    // CustomResource.getSpec() with additional validation rules).
    String fieldName = rawField.getName();
    String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    Class<?> lookupClass = ownerClass != null ? ownerClass : rawField.getDeclaringClass();
    try {
      Method getter = lookupClass.getMethod(getterName);
      collectValidationAnnotations(getter, validationRules);
    } catch (NoSuchMethodException e) {
      // Try boolean getter pattern
      if (rawField.getType() == boolean.class || rawField.getType() == Boolean.class) {
        String isGetterName = "is" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
          Method getter = lookupClass.getMethod(isGetterName);
          collectValidationAnnotations(getter, validationRules);
        } catch (NoSuchMethodException e2) {
          // No getter found, nothing to do
        }
      }
    }
  }

  private void collectValidationAnnotations(AnnotatedElement element, List<V> validationRules) {
    ValidationRules container = element.getAnnotation(ValidationRules.class);
    if (container != null) {
      Stream.of(container.value()).map(this::from).forEach(validationRules::add);
    } else {
      ofNullable(element.getAnnotation(ValidationRule.class)).map(this::from)
          .ifPresent(validationRules::add);
    }
  }

  class PropertyMetadata {

    private boolean required;
    private final String description;
    private final JsonNode defaultValue;
    private Double min;
    private Boolean exclusiveMinimum;
    private Double max;
    private Boolean exclusiveMaximum;
    private String pattern;
    private Long minLength;
    private Long maxLength;
    private Long minItems;
    private Long maxItems;
    private Long minProperties;
    private Long maxProperties;
    private boolean nullable;
    private String format;
    private List<V> validationRules = new ArrayList<>();
    private boolean preserveUnknownFields;
    private Class<?> schemaFrom;

    public PropertyMetadata(ObjectNode schemaNode, FieldScope fieldScope, Class<?> ownerClass) {
      description = ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(JsonPropertyDescription.class))
          .map(JsonPropertyDescription::value)
          .orElse(null);
      schemaFrom = ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(SchemaFrom.class))
          .map(SchemaFrom::type).orElse(null);
      preserveUnknownFields = fieldScope.getAnnotationConsideringFieldAndGetter(
          PreserveUnknownFields.class) != null;

      this.format = schemaNode.path("format").asString(null);
      extractTypeConstraints(schemaNode, fieldScope);
      collectValidationRules(fieldScope, ownerClass, validationRules);

      // TODO: should probably move to a standard annotation
      nullable = fieldScope.getAnnotationConsideringFieldAndGetter(Nullable.class) != null;
      // TODO: should the following be deprecated?
      required = fieldScope.getAnnotationConsideringFieldAndGetter(Required.class) != null;
      defaultValue = toDefault(fieldScope);
    }

    private void extractTypeConstraints(ObjectNode schemaNode, FieldScope fieldScope) {
      String schemaType = resolveSchemaType(schemaNode);
      switch (schemaType) {
        case STRING_LITERAL -> extractStringConstraints(schemaNode, fieldScope);
        case INTEGER_LITERAL, NUMBER_LITERAL -> extractNumericConstraints(schemaNode, fieldScope);
        case "array" -> extractArrayConstraints(schemaNode, fieldScope);
        // TODO: Could be also applied only on Maps instead of "all the rest"
        case OBJECT_LITERAL -> extractObjectConstraints(fieldScope);
        default -> {
        }
      }
    }

    private void extractStringConstraints(ObjectNode schemaNode, FieldScope fieldScope) {
      pattern = ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(Pattern.class))
          .map(Pattern::value)
          .or(() -> ofNullable(schemaNode.path("pattern").asString(null)))
          .orElse(null);
      minLength = findMinInSizeAnnotation(fieldScope)
          .or(() -> ofNullable(schemaNode.has("minLength") ? (long) schemaNode.get("minLength").intValue() : null))
          .orElse(null);
      maxLength = findMaxInSizeAnnotation(fieldScope)
          .or(() -> ofNullable(schemaNode.has("maxLength") ? (long) schemaNode.get("maxLength").intValue() : null))
          .orElse(null);
    }

    private void extractNumericConstraints(ObjectNode schemaNode, FieldScope fieldScope) {
      Double minimum = schemaNode.has("minimum") ? schemaNode.get("minimum").doubleValue() : null;
      Boolean exclMin = schemaNode.has("exclusiveMinimum") ? schemaNode.get("exclusiveMinimum").booleanValue() : null;
      Double maximum = schemaNode.has("maximum") ? schemaNode.get("maximum").doubleValue() : null;
      Boolean exclMax = schemaNode.has("exclusiveMaximum") ? schemaNode.get("exclusiveMaximum").booleanValue() : null;
      setMinMax(fieldScope, minimum, exclMin, maximum, exclMax);
    }

    private void extractArrayConstraints(ObjectNode schemaNode, FieldScope fieldScope) {
      minItems = findMinInSizeAnnotation(fieldScope)
          .or(() -> ofNullable(schemaNode.has("minItems") ? (long) schemaNode.get("minItems").intValue() : null))
          .orElse(null);
      maxItems = findMaxInSizeAnnotation(fieldScope)
          .or(() -> ofNullable(schemaNode.has("maxItems") ? (long) schemaNode.get("maxItems").intValue() : null))
          .orElse(null);
    }

    private void extractObjectConstraints(FieldScope fieldScope) {
      minProperties = findMinInSizeAnnotation(fieldScope).orElse(null);
      maxProperties = findMaxInSizeAnnotation(fieldScope).orElse(null);
    }

    JsonNode toDefault(FieldScope fieldScope) {
      // @Default annotation takes precedence
      Optional<String> defaultAnnotationValue = ofNullable(
          fieldScope.getAnnotationConsideringFieldAndGetter(Default.class)).map(Default::value);

      // Fall back to @JsonProperty(defaultValue = "...")
      Optional<String> jsonPropertyDefault = ofNullable(
          fieldScope.getAnnotationConsideringFieldAndGetter(JsonProperty.class))
          .map(JsonProperty::defaultValue)
          .filter(v -> !v.isEmpty());

      boolean fromDefaultAnnotation = defaultAnnotationValue.isPresent();
      String value = defaultAnnotationValue.or(() -> jsonPropertyDefault).orElse(null);

      if (value == null) {
        return null;
      }
      // Use Java reflection for the declared field type (victools may unwrap arrays/collections)
      Class<?> rawType = fieldScope.getRawMember().getType();
      try {
        if (rawType == String.class) {
          // Strings don't need JSON parsing - use the value directly
          return StringNode.valueOf(value);
        }
        // Add Enum handling
        if (rawType.isEnum()) {
          Object enumValue = resolvingContext.objectMapper.convertValue(value, rawType);
          return resolvingContext.objectMapper.convertValue(enumValue, JsonNode.class);
        }

        // For non-string types, parse as JSON
        Object typedValue = resolvingContext.objectMapper.readValue(value, rawType);
        return resolvingContext.objectMapper.convertValue(typedValue, JsonNode.class);
      } catch (Exception e) {
        if (fromDefaultAnnotation) {
          throw new IllegalArgumentException("Cannot parse default value: '" + value + "' as valid YAML or JSON.", e);
        }
        // For @JsonProperty(defaultValue), silently ignore invalid values
        return null;
      }
    }

    private void setMinMax(FieldScope fieldScope,
        Double minimum, Boolean exclusiveMinimum, Double maximum, Boolean exclusiveMaximum) {
      ofNullable(minimum).ifPresent(v -> {
        this.min = v;
        if (Boolean.TRUE.equals(exclusiveMinimum)) {
          this.exclusiveMinimum = true;
        }
      });
      ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(Min.class)).ifPresent(a -> {
        min = a.value();
        if (!a.inclusive()) {
          this.exclusiveMinimum = true;
        }
      });
      ofNullable(maximum).ifPresent(v -> {
        this.max = v;
        if (Boolean.TRUE.equals(exclusiveMaximum)) {
          this.exclusiveMaximum = true;
        }
      });
      ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(Max.class)).ifPresent(a -> {
        this.max = a.value();
        if (!a.inclusive()) {
          this.exclusiveMaximum = true;
        }
      });
    }

    public void updateSchema(T schema) {
      if (Utils.isNotNullOrEmpty(description)) {
        schema.setDescription(description);
      }
      schema.setDefault(defaultValue);
      if (nullable) {
        schema.setNullable(true);
      }
      schema.setMaximum(max);
      schema.setExclusiveMaximum(exclusiveMaximum);
      schema.setMinimum(min);
      schema.setExclusiveMinimum(exclusiveMinimum);

      schema.setMinLength(minLength);
      schema.setMaxLength(maxLength);

      schema.setMinItems(minItems);
      schema.setMaxItems(maxItems);

      schema.setMinProperties(minProperties);
      schema.setMaxProperties(maxProperties);

      schema.setPattern(pattern);
      schema.setFormat(format);
      if (preserveUnknownFields) {
        schema.setXKubernetesPreserveUnknownFields(true);
      }

      addToValidationRules(schema, validationRules);
    }

    private Optional<Long> findMinInSizeAnnotation(FieldScope fieldScope) {
      return ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(Size.class))
          .map(Size::min)
          .filter(v -> v > 0);
    }

    private Optional<Long> findMaxInSizeAnnotation(FieldScope fieldScope) {
      return ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(Size.class))
          .map(Size::max)
          .filter(v -> v < Long.MAX_VALUE);
    }
  }

  private record ObjectContext<T>(T objectSchema, List<String> required, Map<String, JavaType> propertyTypes,
      Map<String, FieldScope> cachedFieldScopes) {
  }

  private T resolveObject(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      ObjectNode schemaNode, Class<?> rawClass, String... ignore) {

    Set<String> ignores = ignore.length > 0 ? new LinkedHashSet<>(Arrays.asList(ignore)) : Collections.emptySet();
    T objectSchema = singleProperty(OBJECT_LITERAL);
    schemaSwaps = schemaSwaps.branchAnnotations();

    BeanDescription bd = introspectBean(rawClass);
    boolean preserveUnknownFields = resolvingContext.implicitPreserveUnknownFields
        && (bd.findAnyGetter() != null || bd.findAnySetterAccessor() != null);

    ObjectContext<T> ctx = new ObjectContext<>(objectSchema, new ArrayList<>(),
        buildPropertyTypeMap(bd), new LinkedHashMap<>());

    collectDependentClasses(rawClass);
    applyClassLevelAnnotations(objectSchema, schemaSwaps, rawClass);
    resolveProperties(visited, schemaSwaps, schemaNode, rawClass, ignores, ctx);
    schemaSwaps.throwIfUnmatchedSwaps();

    return finalizeObjectSchema(objectSchema, rawClass, ctx.required, preserveUnknownFields);
  }

  private BeanDescription introspectBean(Class<?> rawClass) {
    SerializationConfig config = resolvingContext.objectMapper.serializationConfig();
    JavaType javaType = config.constructType(rawClass);
    ClassIntrospector ci = config.classIntrospectorInstance().forOperation(config);
    AnnotatedClass ac = ci.introspectClassAnnotations(javaType);
    return ci.introspectForSerialization(javaType, ac);
  }

  private Map<String, JavaType> buildPropertyTypeMap(BeanDescription bd) {
    Map<String, JavaType> propertyTypes = new HashMap<>();
    for (BeanPropertyDefinition bpd : bd.findProperties()) {
      propertyTypes.put(bpd.getName(), bpd.getPrimaryType());
    }
    return propertyTypes;
  }

  private void applyClassLevelAnnotations(T objectSchema, InternalSchemaSwaps swaps, Class<?> rawClass) {
    JsonClassDescription classDescription = findClassAnnotation(rawClass, JsonClassDescription.class);
    if (classDescription != null && Utils.isNotNullOrEmpty(classDescription.value())) {
      objectSchema.setDescription(classDescription.value());
    }
    // While @PreserveUnknownFields should not be repeating, we reuse consumeRepeatingAnnotation
    // to walk the class hierarchy and find it on any level
    consumeRepeatingAnnotation(rawClass, PreserveUnknownFields.class,
        ignored -> objectSchema.setXKubernetesPreserveUnknownFields(true));
    consumeRepeatingAnnotation(rawClass, SchemaSwap.class,
        ss -> swaps.registerSwap(rawClass, ss.originalType(), ss.fieldName(), ss.targetType(), ss.depth()));
  }

  private void resolveProperties(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      ObjectNode schemaNode, Class<?> rawClass, Set<String> ignores, ObjectContext<T> ctx) {

    JsonNode propertiesNode = schemaNode.get("properties");
    if (!(propertiesNode instanceof ObjectNode properties)) {
      return;
    }

    cacheFieldScopes(rawClass, properties, ctx.cachedFieldScopes);

    for (var property : new TreeMap<>(nodeToMap(properties)).entrySet()) {
      String name = property.getKey();
      if (ignores.contains(name)) {
        continue;
      }
      resolveAndAddProperty(visited, schemaSwaps, rawClass, ctx, name, property.getValue());
    }
  }

  // Pre-cache field scopes before iterating, because toJsonSchema calls during
  // schema swaps clear the fieldScopes map in ResolvingContext
  private void cacheFieldScopes(Class<?> rawClass, ObjectNode properties, Map<String, FieldScope> target) {
    for (var entry : nodeToMap(properties).entrySet()) {
      FieldScope fs = resolvingContext.getFieldScope(rawClass, entry.getKey());
      if (fs != null) {
        target.put(entry.getKey(), fs);
      }
    }
  }

  private void resolveAndAddProperty(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      Class<?> rawClass, ObjectContext<T> ctx, String name, JsonNode propertyNode) {

    FieldScope fieldScope = ctx.cachedFieldScopes.get(name);
    if (fieldScope == null || fieldScope.getAnnotationConsideringFieldAndGetter(JsonIgnore.class) != null) {
      return;
    }

    schemaSwaps = schemaSwaps.branchDepths();
    SwapResult swapResult = schemaSwaps.lookupAndMark(rawClass, name);
    LinkedHashMap<String, String> effectiveVisited = swapResult.onGoing ? new LinkedHashMap<>() : visited;

    ObjectNode propertySchemaNode = resolvePropertySchemaNode(propertyNode);
    PropertyMetadata propertyMetadata = new PropertyMetadata(propertySchemaNode, fieldScope, rawClass);

    if (propertyMetadata.required) {
      ctx.required.add(name);
    }

    // Use BeanDescription property types (with proper generics) over victools erased types
    SerializationConfig config = resolvingContext.objectMapper.serializationConfig();
    JavaType propertyType = ctx.propertyTypes.getOrDefault(name,
        config.constructType(fieldScope.getType().getErasedType()));

    if (swapResult.classRef != null) {
      propertyMetadata.schemaFrom = swapResult.classRef;
    }
    if (propertyMetadata.schemaFrom != null) {
      if (propertyMetadata.schemaFrom == void.class) {
        // Fully omit - this is a little inconsistent with the NullSchema handling
        return;
      }
      // Use toJsonSchemaForSwap to preserve the primary schema's $defs and rootSchema
      propertySchemaNode = resolvingContext.toJsonSchemaForSwap(propertyMetadata.schemaFrom);
      propertyType = config.constructType(propertyMetadata.schemaFrom);
    }

    T schema = resolveProperty(effectiveVisited, schemaSwaps, name, propertyType, propertySchemaNode, fieldScope);
    propertyMetadata.updateSchema(schema);

    if (!swapResult.onGoing) {
      collectPathMetadata(fieldScope, visited, name, schema);
    }

    addProperty(name, ctx.objectSchema, schema);
  }

  // Resolve $ref to get the actual property schema node
  private ObjectNode resolvePropertySchemaNode(JsonNode propertyNode) {
    JsonNode resolved = resolveRef(propertyNode);
    if (resolved instanceof ObjectNode objectNode) {
      return objectNode;
    }
    if (propertyNode instanceof ObjectNode objectNode) {
      return objectNode;
    }
    return resolvingContext.objectMapper.createObjectNode();
  }

  private void collectPathMetadata(FieldScope fieldScope, LinkedHashMap<String, String> visited,
      String name, T schema) {
    for (var entry : pathMetadata.entrySet()) {
      ofNullable(fieldScope.getAnnotationConsideringFieldAndGetter(entry.getKey())).ifPresent(
          ann -> entry.getValue().put(toFQN(visited, name), new AnnotationMetadata(ann, schema)));
    }
  }

  private T finalizeObjectSchema(T objectSchema, Class<?> rawClass,
      List<String> required, boolean preserveUnknownFields) {
    objectSchema.setRequired(required);
    if (preserveUnknownFields) {
      objectSchema.setXKubernetesPreserveUnknownFields(true);
    }
    List<V> validationRules = new ArrayList<>();
    consumeRepeatingAnnotation(rawClass, ValidationRule.class,
        v -> validationRules.add(from(v)));
    addToValidationRules(objectSchema, validationRules);
    return handleSchemaCustomizer(objectSchema, rawClass);
  }

  private T handleSchemaCustomizer(T objectSchema, Class<?> rawClass) {
    if (objectSchema instanceof JSONSchemaProps) {
      JSONSchemaProps[] props = new JSONSchemaProps[] { (JSONSchemaProps) objectSchema };
      consumeRepeatingAnnotation(rawClass, SchemaCustomizer.class, sc -> {
        try {
          props[0] = sc.value().getConstructor().newInstance().apply(props[0], sc.input(),
              this.resolvingContext.kubernetesSerialization);
        } catch (ReflectiveOperationException e) {
          throw new RuntimeException("Failed to instantiate or apply SchemaCustomizer: " + sc.value().getName(), e);
        } catch (RuntimeException e) {
          throw new RuntimeException("Failed to apply SchemaCustomizer: " + sc.value().getName(), e);
        }
      });
      if (props[0] != objectSchema) {
        // hack to convert back to V1JSONSchemaProps
        objectSchema = (T) resolvingContext.kubernetesSerialization.convertValue(props[0], V1JSONSchemaProps.class);
      }
    }
    return objectSchema;
  }

  private void collectDependentClasses(Class<?> rawClass) {
    if (rawClass != null && !rawClass.getName().startsWith("java.") && dependentClasses.add(rawClass.getName())) {
      Stream.of(rawClass.getInterfaces()).forEach(this::collectDependentClasses);
      collectDependentClasses(rawClass.getSuperclass());
    }
  }

  static String toFQN(LinkedHashMap<String, String> visited, String name) {
    if (visited.isEmpty()) {
      return "." + name;
    }
    return visited.values().stream().collect(Collectors.joining(".", ".", ".")) + name;
  }

  /**
   * Resolves a JSON $ref node by looking up the referenced definition.
   * Handles both $defs references and "#" self-references.
   */
  private JsonNode resolveRef(JsonNode node) {
    if (node.has("$ref")) {
      String ref = node.get("$ref").asString();
      if ("#".equals(ref)) {
        // Self-reference to the root schema
        ObjectNode rootSchema = resolvingContext.getRootSchema();
        if (rootSchema != null) {
          return rootSchema;
        }
      }
      ObjectNode resolved = resolvingContext.getDefs().get(ref);
      if (resolved != null) {
        return resolved;
      }
    }
    return node;
  }

  /**
   * Converts an ObjectNode to a Map of property name to JsonNode.
   */
  private static Map<String, JsonNode> nodeToMap(ObjectNode node) {
    Map<String, JsonNode> map = new LinkedHashMap<>();
    node.properties().forEach(e -> map.put(e.getKey(), e.getValue()));
    return map;
  }

  private T resolveProperty(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, String name,
      JavaType type, ObjectNode schemaNode, FieldScope fieldScope) {

    // Resolve $ref first — victools uses $ref/$defs but CRDs require inline schemas
    JsonNode resolved = resolveRef(schemaNode);
    if (resolved instanceof ObjectNode objectNode) {
      schemaNode = objectNode;
    }

    String schemaType = resolveSchemaType(schemaNode);

    // Dispatch by schema type — each branch handles one JSON Schema type
    T result = resolveBySchemaType(visited, schemaSwaps, name, type, schemaNode, fieldScope, schemaType);
    if (result != null) {
      return result;
    }

    // Check for Kubernetes-specific schema extensions (no "type" field, identified by x-kubernetes-* markers)
    result = resolveKubernetesExtensions(schemaNode);
    if (result != null) {
      return result;
    }

    // Map-like type: detect by Java type. victools may emit additionalProperties, or just
    // {"type":"object"} for maps with Object/raw values, or even an empty schema for some cases.
    if (type != null && type.isMapLikeType()
        && (schemaNode.has(ADDITIONAL_PROPERTIES) || OBJECT_LITERAL.equals(schemaType) || schemaType.isEmpty())) {
      return resolveMapProperty(visited, schemaSwaps, name, type, schemaNode, fieldScope);
    }

    // "any" schema — no type, no properties, no additionalProperties
    if (schemaType.isEmpty() && !schemaNode.has("properties") && !schemaNode.has(ADDITIONAL_PROPERTIES)) {
      return resolveAnySchema(visited, schemaSwaps, name, type, fieldScope);
    }

    // Object type — recurse into nested object
    return resolveNestedObject(visited, schemaSwaps, name, type, schemaNode);
  }

  private static final String ADDITIONAL_PROPERTIES = "additionalProperties";

  /**
   * Dispatches to the appropriate handler based on the JSON Schema "type" field.
   * Returns null if the type doesn't match any primitive/array/string handler.
   */
  private T resolveBySchemaType(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      String name, JavaType type, ObjectNode schemaNode, FieldScope fieldScope, String schemaType) {
    return switch (schemaType) {
      case "array" -> resolveArrayProperty(visited, schemaSwaps, name, type, schemaNode, fieldScope);
      case INTEGER_LITERAL -> singleProperty(INTEGER_LITERAL);
      case NUMBER_LITERAL -> singleProperty(NUMBER_LITERAL);
      case "boolean" -> singleProperty("boolean");
      case STRING_LITERAL -> resolveStringOrEnum(type, schemaNode);
      // TODO: this may not be the right choice, but rarely will someone be using Void
      case "null" -> singleProperty(OBJECT_LITERAL);
      default -> null;
    };
  }

  /**
   * Handles array-typed properties by resolving the items schema and wrapping it.
   */
  private T resolveArrayProperty(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      String name, JavaType type, ObjectNode schemaNode, FieldScope fieldScope) {
    JsonNode items = schemaNode.path("items");
    if (items.isMissingNode()) {
      throw new IllegalStateException(String.format("Untyped collection %s", name));
    }
    JsonNode resolvedItems = resolveRef(items);
    ObjectNode arrayItemSchema = resolvedItems instanceof ObjectNode resolvedObjectItems
        ? resolvedObjectItems
        : resolvingContext.objectMapper.createObjectNode();
    // Get the content type; if null (victools may resolve to element type), use type directly
    JavaType contentType = type != null ? type.getContentType() : null;
    if (contentType == null) {
      contentType = type != null ? type : resolvingContext.objectMapper.serializationConfig().constructType(Object.class);
    }
    T schema = resolveProperty(visited, schemaSwaps, name, contentType, arrayItemSchema, null);
    handleTypeAnnotations(schema, fieldScope, List.class, 0);
    return arrayLikeProperty(schema);
  }

  /**
   * Handles string-typed properties, including enum detection.
   * Builds enum values from the Java type (using Jackson serialization to respect @JsonProperty renaming
   * and @JsonIgnore filtering) or from the schema's enum node.
   */
  private T resolveStringOrEnum(JavaType type, ObjectNode schemaNode) {
    if (type != null && type.isEnumType()) {
      JsonNode[] enumValues = buildEnumValuesFromJavaType(type);
      if (enumValues.length > 0) {
        return enumProperty(enumValues);
      }
    }
    JsonNode enumNode = schemaNode.path("enum");
    if (!enumNode.isMissingNode() && enumNode.isArray()) {
      JsonNode[] enumValues = StreamSupport
          .stream(enumNode.spliterator(), false)
          .map(JsonNode::asString)
          .sorted()
          .map(JsonNodeFactory.instance::stringNode)
          .toArray(JsonNode[]::new);
      return enumProperty(enumValues);
    }
    return singleProperty(STRING_LITERAL);
  }

  /**
   * Checks for Kubernetes-specific schema extensions (x-kubernetes-int-or-string,
   * x-kubernetes-embedded-resource, x-kubernetes-preserve-unknown-fields).
   * Returns null if no extension marker is found.
   */
  private T resolveKubernetesExtensions(ObjectNode schemaNode) {
    if (schemaNode.has("x-kubernetes-int-or-string")) {
      return intOrString();
    }
    if (schemaNode.has("x-kubernetes-embedded-resource")) {
      return raw();
    }
    if (schemaNode.has("x-kubernetes-preserve-unknown-fields")) {
      T schema = singleProperty(null);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    }
    return null;
  }

  /**
   * Resolves a map-like property by extracting the value type schema from additionalProperties.
   * CRD schemas only support string keys, so non-string key types trigger a warning.
   */
  private T resolveMapProperty(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      String name, JavaType type, ObjectNode schemaNode, FieldScope fieldScope) {
    JavaType keyType = type.getKeyType();
    if (keyType != null && keyType.getRawClass() != String.class) {
      logger.warn("Property '{}' with '{}' key type is mapped to 'string' because of CRD schemas limitations",
          name, keyType);
    }

    JsonNode additionalPropsNode = resolveRef(schemaNode.path(ADDITIONAL_PROPERTIES));
    ObjectNode additionalProps = additionalPropsNode instanceof ObjectNode ap
        ? ap
        : resolvingContext.objectMapper.createObjectNode();
    JavaType valueType = type.getContentType();
    JavaType resolvedValueType = valueType != null ? valueType
        : resolvingContext.objectMapper.serializationConfig().constructType(Object.class);
    T component = resolveProperty(visited, schemaSwaps, name, resolvedValueType, additionalProps, null);
    handleTypeAnnotations(component, fieldScope, Map.class, 1);
    return mapLikeProperty(component);
  }

  /**
   * Handles schemas with no type, no properties, and no additionalProperties ("any" schemas).
   * Checks for well-known Kubernetes types (IntOrString, Quantity, RawExtension), map-like types
   * where victools omitted additionalProperties, and free-form JSON types (JsonNode, ObjectNode).
   */
  private T resolveAnySchema(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      String name, JavaType type, FieldScope fieldScope) {
    if (type == null) {
      return singleProperty(null);
    }

    Class<?> rawClass = type.getRawClass();

    // Well-known Kubernetes types that use "any" schema representation
    if (rawClass == IntOrString.class || rawClass == Quantity.class) {
      return intOrString();
    }
    if (rawClass == RawExtension.class) {
      return raw();
    }

    // Map-like type with empty schema (e.g., Map<String, Object>):
    // victools may not generate additionalProperties for maps with Object values
    if (type.isMapLikeType()) {
      ObjectNode emptySchema = resolvingContext.objectMapper.createObjectNode();
      return resolveMapProperty(visited, schemaSwaps, name, type, emptySchema, fieldScope);
    }

    // Free-form JSON types get x-kubernetes-preserve-unknown-fields
    if (JsonNode.class.isAssignableFrom(rawClass)) {
      T schema = singleProperty(null);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    }
    if (rawClass == ObjectNode.class) {
      T schema = singleProperty(OBJECT_LITERAL);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    }
    if (rawClass == Object.class) {
      T schema = singleProperty(OBJECT_LITERAL);
      if (fieldScope != null) {
        schema.setXKubernetesPreserveUnknownFields(true);
      }
      return schema;
    }
    return singleProperty(null);
  }

  /**
   * Handles object-typed properties by recursing into the nested class.
   * Detects well-known Kubernetes interfaces and cyclic references.
   */
  private T resolveNestedObject(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps,
      String name, JavaType type, ObjectNode schemaNode) {
    if (type == null) {
      T schema = singleProperty(OBJECT_LITERAL);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    }

    Class<?> def = type.getRawClass();

    // KubernetesResource is too broad, but common subclasses can be recognized
    if (def == GenericKubernetesResource.class
        || (def.isInterface() && HasMetadata.class.isAssignableFrom(def))) {
      return raw();
    }

    // Unknown interfaces (not Kubernetes-related) produce "any type" schemas
    if (def.isInterface()) {
      T schema = singleProperty(null);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    }

    // Free-form JSON object produced by victools custom definition
    if (def == ObjectNode.class) {
      T schema = singleProperty(OBJECT_LITERAL);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    }

    // Cyclic reference detection — CRDs don't support $ref, so cycles must be reported
    if (visited.put(def.getName(), name) != null) {
      throw new IllegalArgumentException(
          "Found a cyclic reference involving the field of type " + def.getName() + " starting a field "
              + visited.entrySet().stream().map(e -> e.getValue() + " >>\n" + e.getKey()).collect(Collectors.joining("."))
              + "." + name);
    }

    T res = resolveObject(visited, schemaSwaps, schemaNode, def);
    visited.remove(def.getName());
    return res;
  }

  private void handleTypeAnnotations(final T schema, FieldScope fieldScope, Class<?> containerType, int typeIndex) {
    if (fieldScope == null) {
      return;
    }
    Class<?> erasedType = fieldScope.getType().getErasedType();
    // Check both the exact container type and whether it's assignable (for subclass collections)
    if (!containerType.equals(erasedType) && !containerType.isAssignableFrom(erasedType)) {
      return;
    }

    Field rawField = fieldScope.getRawMember();
    AnnotatedType fieldType = rawField.getAnnotatedType();

    Stream.of(fieldType)
        .filter(AnnotatedParameterizedType.class::isInstance)
        .map(AnnotatedParameterizedType.class::cast)
        .map(AnnotatedParameterizedType::getAnnotatedActualTypeArguments)
        .filter(a -> typeIndex < a.length) // Guard against subtype wrappers with fewer type params
        .map(a -> a[typeIndex])
        .forEach(at -> {
          if (STRING_LITERAL.equals(schema.getType())) {
            ofNullable(at.getAnnotation(Pattern.class))
                .ifPresent(a -> schema.setPattern(a.value()));

            ofNullable(at.getAnnotation(Size.class))
                .map(Size::min)
                .filter(v -> v > 0)
                .ifPresent(schema::setMinLength);

            ofNullable(at.getAnnotation(Size.class))
                .map(Size::max)
                .filter(v -> v < Long.MAX_VALUE)
                .ifPresent(schema::setMaxLength);

          } else if (NUMBER_LITERAL.equals(schema.getType()) || INTEGER_LITERAL.equals(schema.getType())) {
            ofNullable(at.getAnnotation(Min.class)).ifPresent(a -> {
              schema.setMinimum(a.value());
              if (!a.inclusive()) {
                schema.setExclusiveMinimum(true);
              }
            });
            ofNullable(at.getAnnotation(Max.class)).ifPresent(a -> {
              schema.setMaximum(a.value());
              if (!a.inclusive()) {
                schema.setExclusiveMaximum(true);
              }
            });
          }
        });
  }

  /**
   * Builds sorted enum values from a Java enum type.
   * Uses getEnumConstants() instead of field.get() to avoid access issues with
   * package-private enum classes. Handles @JsonProperty renaming and @JsonIgnore filtering.
   */
  private JsonNode[] buildEnumValuesFromJavaType(JavaType type) {
    Class<?> enumClass = type.getRawClass();
    Object[] constants = enumClass.getEnumConstants();
    if (constants == null) {
      return new JsonNode[0];
    }

    Set<String> values = new TreeSet<>();
    for (Object constant : constants) {
      Enum<?> enumConstant = (Enum<?>) constant;
      String constantName = enumConstant.name();
      try {
        Field field = enumClass.getField(constantName);
        if (field.getAnnotation(JsonIgnore.class) != null) {
          continue;
        }
        // Check for @JsonProperty to get the serialized name
        JsonProperty jsonProp = field.getAnnotation(JsonProperty.class);
        if (jsonProp != null && !jsonProp.value().isEmpty()) {
          values.add(jsonProp.value());
        } else {
          values.add(constantName);
        }
      } catch (NoSuchFieldException e) {
        values.add(constantName);
      }
    }

    return values.stream()
        .map(JsonNodeFactory.instance::stringNode)
        .toArray(JsonNode[]::new);
  }

  V from(ValidationRule validationRule) {
    V result = newKubernetesValidationRule();
    result.setRule(validationRule.value());
    result.setReason(mapNotEmpty(validationRule.reason()));
    result.setMessage(mapNotEmpty(validationRule.message()));
    result.setMessageExpression(mapNotEmpty(validationRule.messageExpression()));
    result.setFieldPath(mapNotEmpty(validationRule.fieldPath()));
    result.setOptionalOldSelf(validationRule.optionalOldSelf() ? true : null);
    return result;
  }

  private static String mapNotEmpty(String s) {
    return Utils.isNullOrEmpty(s) ? null : s;
  }

  protected abstract V newKubernetesValidationRule();

  /**
   * Adds the specified property to the specified builder
   *
   * @param name the property to add to the currently being built schema
   * @param objectSchema the schema being built
   * @param schema the built schema for the property being added
   */
  protected abstract void addProperty(String name, T objectSchema, T schema);

  /**
   * Builds the schema for specifically for intOrString properties
   *
   * @return the property schema
   */
  protected abstract T intOrString();

  /**
   * Builds the schema for array-like properties
   *
   * @param schema the schema for the extracted element type for this array-like property
   * @return the schema for the array-like property
   */
  protected abstract T arrayLikeProperty(T schema);

  /**
   * Builds the schema for map-like properties
   *
   * @param schema the schema for the extracted element type for the values of this map-like property
   * @return the schema for the map-like property
   */
  protected abstract T mapLikeProperty(T schema);

  /**
   * Builds the schema for standard, simple (e.g. string) property types
   *
   * @param typeName the mapped name of the property type
   * @return the schema for the property
   */
  protected abstract T singleProperty(String typeName);

  protected abstract T enumProperty(JsonNode... enumValues);

  protected abstract void addToValidationRules(T schema, List<V> validationRules);

  protected abstract T raw();

  public Set<AdditionalPrinterColumn> getAdditionalPrinterColumns() {
    return additionalPrinterColumns;
  }

  public Set<AdditionalSelectableField> getAdditionalSelectableFields() {
    return additionalSelectableFields;
  }

}
