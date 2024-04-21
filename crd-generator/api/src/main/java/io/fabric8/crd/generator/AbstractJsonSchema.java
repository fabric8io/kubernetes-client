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
package io.fabric8.crd.generator;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ArraySchema.Items;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema.SchemaAdditionalProperties;
import com.fasterxml.jackson.module.jsonSchema.types.ReferenceSchema;
import com.fasterxml.jackson.module.jsonSchema.types.StringSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ValueTypeSchema;
import io.fabric8.crd.generator.InternalSchemaSwaps.SwapResult;
import io.fabric8.crd.generator.ResolvingContext.GeneratorObjectSchema;
import io.fabric8.crd.generator.annotation.PreserveUnknownFields;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.annotation.SchemaFrom;
import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.generator.annotation.Default;
import io.fabric8.generator.annotation.Max;
import io.fabric8.generator.annotation.Min;
import io.fabric8.generator.annotation.Nullable;
import io.fabric8.generator.annotation.Pattern;
import io.fabric8.generator.annotation.Required;
import io.fabric8.generator.annotation.ValidationRule;
import io.fabric8.generator.annotation.ValidationRules;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.annotation.LabelSelector;
import io.fabric8.kubernetes.model.annotation.SpecReplicas;
import io.fabric8.kubernetes.model.annotation.StatusReplicas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
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
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.fabric8.crd.generator.CRDGenerator.YAML_MAPPER;
import static java.util.Optional.ofNullable;

/**
 * Encapsulates the common logic supporting OpenAPI schema generation for CRD generation.
 *
 * @param <T> the concrete type of the generated JSON Schema
 * @param <B> the concrete type of the JSON Schema builder
 * @param <V> the concrete type of the validation rule
 */
public abstract class AbstractJsonSchema<T, B, V> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJsonSchema.class);

  private ResolvingContext resolvingContext;
  private T root;

  public static class AnnotationMetadata {
    public final Annotation annotation;
    public final String description;
    public final String type;

    public AnnotationMetadata(Annotation annotation, String description, String type) {
      this.annotation = annotation;
      this.description = description;
      this.type = type;
    }
  }

  private Map<Class<? extends Annotation>, LinkedHashMap<String, AnnotationMetadata>> pathMetadata = new HashMap<>();

  public AbstractJsonSchema(ResolvingContext resolvingContext, Class<?> def) {
    this.resolvingContext = resolvingContext;
    // TODO: could make this configurable, and could stop looking for single valued ones - or warn
    Stream.of(SpecReplicas.class, StatusReplicas.class, LabelSelector.class, PrinterColumn.class)
        .forEach(clazz -> pathMetadata.put(clazz, new LinkedHashMap<>()));

    this.root = resolveRoot(def);
  }

  public T getSchema() {
    return root;
  }

  public Optional<String> getSinglePath(Class<? extends Annotation> clazz) {
    return ofNullable(pathMetadata.get(clazz)).flatMap(m -> m.keySet().stream().findFirst());
  }

  public Map<String, AnnotationMetadata> getAllPaths(Class<PrinterColumn> clazz) {
    return ofNullable(pathMetadata.get(clazz)).orElse(new LinkedHashMap<>());
  }

  protected List<V> mapValidationRules(List<KubernetesValidationRule> validationRules) {
    if (validationRules == null) {
      return Collections.emptyList();
    }
    return validationRules.stream()
        .map(this::mapValidationRule)
        .collect(Collectors.toList());
  }

  /**
   * Creates the JSON schema for the class. This is template method where
   * sub-classes are supposed to provide specific implementations of abstract methods.
   *
   * @param definition The definition.
   * @param ignore a potentially empty list of property names to ignore while generating the schema
   * @return The schema.
   */
  private T resolveRoot(Class<?> definition) {
    InternalSchemaSwaps schemaSwaps = new InternalSchemaSwaps();
    JsonSchema schema = toJsonSchema(definition);
    if (schema instanceof GeneratorObjectSchema) {
      return resolveObject(new LinkedHashMap<>(), schemaSwaps, schema, "kind", "apiVersion", "metadata");
    }
    return resolvePropertySchema(new LinkedHashMap<>(), schemaSwaps, null, resolvingContext.serializationConfig.constructType(definition), schema);
  }

  private static <A extends Annotation> void extractAnnotations(Class<?> beanClass, Class<A> annotation, Consumer<A> consumer) {
    while (beanClass != Object.class) {
      Stream.of(beanClass.getAnnotationsByType(annotation)).forEach(consumer);
      beanClass = beanClass.getSuperclass();
    }
  }

  static void collectValidationRules(BeanProperty beanProperty, List<KubernetesValidationRule> validationRules) {
    // TODO: the old logic allowed for picking up the annotation from both the getter and the field
    // this requires a messy hack by convention because there doesn't seem to be a way to all annotations
    // nor does jackson provide the field
    if (beanProperty.getMember() instanceof AnnotatedMethod) {
      // field first
      Method m = ((AnnotatedMethod)beanProperty.getMember()).getMember();
      String name = m.getName();
      if (name.startsWith("get") || name.startsWith("set")) {
        name = name.substring(3);
      } else if (name.startsWith("is")) {
        name = name.substring(2);
      }
      if (name.length() > 0) {
        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
      }
      try {
        Field f = beanProperty.getMember().getDeclaringClass().getDeclaredField(name);
        ofNullable(f.getAnnotation(ValidationRule.class)).map(KubernetesValidationRule::from)
            .ifPresent(validationRules::add);
        ofNullable(f.getAnnotation(ValidationRules.class))
            .ifPresent(ann -> Stream.of(ann.value()).map(KubernetesValidationRule::from).forEach(validationRules::add));
      } catch (NoSuchFieldException | SecurityException e) {
      }
      // then method
      Stream.of(m.getAnnotationsByType(ValidationRule.class)).map(KubernetesValidationRule::from).forEach(validationRules::add);
      return;
    }

    // fall back to standard logic
    ofNullable(beanProperty.getAnnotation(ValidationRule.class)).map(KubernetesValidationRule::from)
        .ifPresent(validationRules::add);
    ofNullable(beanProperty.getAnnotation(ValidationRules.class))
        .ifPresent(ann -> Stream.of(ann.value()).map(KubernetesValidationRule::from).forEach(validationRules::add));
  }

  class PropertyMetadata {

    private boolean required;
    private String description;
    private String defaultValue;
    private Double min;
    private Double max;
    private String pattern;
    private boolean nullable;
    private String format;
    private List<KubernetesValidationRule> validationRules = new ArrayList<>();
    private boolean preserveUnknownFields;
    private Class<?> schemaFrom;

    public PropertyMetadata(JsonSchema value, BeanProperty beanProperty) {
      required = Boolean.TRUE.equals(value.getRequired());

      description = beanProperty.getMetadata().getDescription();
      defaultValue = beanProperty.getMetadata().getDefaultValue();

      schemaFrom = ofNullable(beanProperty.getAnnotation(SchemaFrom.class)).map(SchemaFrom::type).orElse(null);

      if (value.isValueTypeSchema()) {
        ValueTypeSchema valueTypeSchema = value.asValueTypeSchema();
        this.format = ofNullable(valueTypeSchema.getFormat()).map(Object::toString).orElse(null);
      }

      if (value.isStringSchema()) {
        StringSchema stringSchema = value.asStringSchema();
        // only set if ValidationSchemaFactoryWrapper is used
        this.pattern = stringSchema.getPattern(); // looks for the Pattern annotation
        this.max = ofNullable(stringSchema.getMaxLength()).map(Integer::doubleValue).orElse(null);
        this.min = ofNullable(stringSchema.getMinLength()).map(Integer::doubleValue).orElse(null);
      } else {
        // TODO: process the other schema types for validation values
      }

      collectValidationRules(beanProperty, validationRules);

      // TODO: should probably move to a standard annotations
      // see ValidationSchemaFactoryWrapper
      nullable = beanProperty.getAnnotation(Nullable.class) != null;
      max = ofNullable(beanProperty.getAnnotation(Max.class)).map(Max::value).orElse(max);
      min = ofNullable(beanProperty.getAnnotation(Min.class)).map(Min::value).orElse(min);

      // TODO: should the following be deprecated?
      required = beanProperty.getAnnotation(Required.class) != null;
      defaultValue = ofNullable(beanProperty.getAnnotation(Default.class)).map(Default::value).orElse(defaultValue);
      pattern = ofNullable(beanProperty.getAnnotation(Pattern.class)).map(Pattern::value).orElse(pattern);
      preserveUnknownFields = beanProperty.getAnnotation(PreserveUnknownFields.class) != null;
    }

    public T updateSchema(T schema) {
      if (description != null) {
        schema = addDescription(schema, description);
      }

      if (defaultValue != null) {
        try {
          setDefault(schema, YAML_MAPPER.readTree(defaultValue));
        } catch (JsonProcessingException e) {
          throw new IllegalArgumentException("Cannot parse default value: '" + defaultValue + "' as valid YAML.");
        }
      }
      if (nullable) {
        setNullable(schema, nullable);
      }
      setMax(schema, max);
      setMin(schema, min);
      setPattern(schema, pattern);
      setFormat(schema, format);
      if (preserveUnknownFields) {
        setPreserveUnknown(schema, true);
      }

      if (!validationRules.isEmpty()) {
        List<V> validationRulesFromProperty = validationRules.stream()
            .map(AbstractJsonSchema.this::mapValidationRule)
            .collect(Collectors.toList());

        schema = addToValidationRules(schema, validationRulesFromProperty);
      }
      return schema;
    }
  }

  private T resolveObject(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, JsonSchema jacksonSchema,
      String... ignore) {
    Set<String> ignores = ignore.length > 0 ? new LinkedHashSet<>(Arrays.asList(ignore)) : Collections.emptySet();

    final B builder = newBuilder();

    schemaSwaps = schemaSwaps.branchAnnotations();
    final InternalSchemaSwaps swaps = schemaSwaps;

    GeneratorObjectSchema gos = (GeneratorObjectSchema)jacksonSchema.asObjectSchema();
    AnnotationIntrospector ai = resolvingContext.serializationConfig.getAnnotationIntrospector();
    BeanDescription bd = resolvingContext.serializationConfig.introspect(gos.javaType);
    boolean preserveUnknownFields = bd.findAnyGetter() != null || bd.findAnySetterAccessor() != null;

    extractAnnotations(gos.javaType.getRawClass(), SchemaSwap.class, ss -> {
      swaps.registerSwap(gos.javaType.getRawClass(),
          ss.originalType(),
          ss.fieldName(),
          ss.targetType(), ss.depth());
    });

    List<String> required = new ArrayList<>();

    for (Map.Entry<String, JsonSchema> property : new TreeMap<>(gos.getProperties()).entrySet()) {
      String name = property.getKey();
      if (ignores.contains(name)) {
        continue;
      }
      schemaSwaps = schemaSwaps.branchDepths();
      SwapResult swapResult = schemaSwaps.lookupAndMark(gos.javaType.getRawClass(), name);
      LinkedHashMap<String, String> savedVisited = visited;
      if (swapResult.onGoing) {
        visited = new LinkedHashMap<>();
      }

      BeanProperty beanProperty = gos.beanProperties.get(property.getKey());
      Utils.checkNotNull(beanProperty, "CRD generation works only with bean properties");

      JsonSchema propertySchema = property.getValue();
      PropertyMetadata propertyMetadata = new PropertyMetadata(propertySchema, beanProperty);

      // fallback to the JsonFormat pattern
      if (propertyMetadata.pattern == null) {
        propertyMetadata.pattern = ofNullable(ai.findFormat(beanProperty.getMember())).map(Value::getPattern).orElse(null);
      }

      if (propertyMetadata.required) {
        required.add(name);
      }

      JavaType type = beanProperty.getType();
      if (swapResult.classRef != null) {
        propertyMetadata.schemaFrom = swapResult.classRef;
      }
      if (propertyMetadata.schemaFrom != null) {
        if (propertyMetadata.schemaFrom == void.class) {
          // fully omit - this is a little inconsistent with the NullSchema handling
          continue;
        }
        propertySchema = toJsonSchema(propertyMetadata.schemaFrom);
        type = resolvingContext.serializationConfig.constructType(propertyMetadata.schemaFrom);
      }

      T schema = resolvePropertySchema(visited, schemaSwaps, name, type, propertySchema);

      if (!swapResult.onGoing) {
        for (Entry<Class<? extends Annotation>, LinkedHashMap<String, AnnotationMetadata>> entry : pathMetadata.entrySet()) {
          String jsonType = getType(schema);
          ofNullable(beanProperty.getAnnotation(entry.getKey())).ifPresent(
              ann -> entry.getValue().put(toFQN(savedVisited, name),
                  new AnnotationMetadata(ann, propertyMetadata.description, jsonType)));
        }
      }

      schema = propertyMetadata.updateSchema(schema);

      visited = savedVisited;

      addProperty(name, builder, schema);
    }

    List<KubernetesValidationRule> validationRules = new ArrayList<>();
    extractAnnotations(gos.javaType.getRawClass(), ValidationRule.class,
        v -> validationRules.add(KubernetesValidationRule.from(v)));

    swaps.throwIfUnmatchedSwaps();
    return build(builder, required, validationRules, preserveUnknownFields);
  }

  protected abstract String getType(T schema);

  static String toFQN(LinkedHashMap<String, String> visited, String name) {
    if (visited.isEmpty()) {
      return "." + name;
    }
    return visited.values().stream().collect(Collectors.joining(".", ".", ".")) + name;
  }

  private T resolvePropertySchema(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, String name,
      JavaType type, JsonSchema jacksonSchema) {

    if (type.getRawClass() == IntOrString.class || type.getRawClass() == Quantity.class) {
      return intOrString(); // TODO: create a serializer for this and remove this override
    }

    if (jacksonSchema.isArraySchema()) {
      Items items = jacksonSchema.asArraySchema().getItems();
      if (items.isArrayItems()) {
        throw new IllegalStateException("not yet supported");
      }
      JsonSchema arraySchema = jacksonSchema.asArraySchema().getItems().asSingleItems().getSchema();
      final T schema = resolvePropertySchema(visited, schemaSwaps, name, type.getContentType(), arraySchema);
      return arrayLikeProperty(schema);
    } else if (jacksonSchema.isIntegerSchema()) {
      return singleProperty("integer");
    } else if (jacksonSchema.isNumberSchema()) {
      return singleProperty("number");
    } else if (jacksonSchema.isBooleanSchema()) {
      return singleProperty("boolean");
    } else if (jacksonSchema.isStringSchema()) {
      // currently on string enums are supported
      StringSchema stringSchema = jacksonSchema.asStringSchema();
      if (!stringSchema.getEnums().isEmpty()) {
        Set<String> ignores = type.isEnumType() ? findIngoredEnumConstants(type) : Collections.emptySet();
        final JsonNode[] enumValues = stringSchema.getEnums().stream()
            .sorted()
            .filter(s -> !ignores.contains(s))
            .map(JsonNodeFactory.instance::textNode)
            .toArray(JsonNode[]::new);
        return enumProperty(enumValues);
      }
      return singleProperty("string");
    } else if (jacksonSchema.isNullSchema()) {
      return singleProperty("object"); // TODO: this may not be the right choice, but rarely will someone be using Void
    } else if (jacksonSchema.isAnySchema()) {
      // TODO: this could optionally take a type restriction
      T schema = singleProperty(null);
      setPreserveUnknown(schema, true);
      return schema;
    } else if (jacksonSchema.isUnionTypeSchema()) {
      throw new IllegalStateException("not yet supported");
    } else if (jacksonSchema instanceof ReferenceSchema) {
      // de-reference the reference schema - these can be naturally non-cyclic, for example siblings
      ReferenceSchema ref = (ReferenceSchema)jacksonSchema;
      GeneratorObjectSchema referenced = resolvingContext.seen.get(ref.get$ref());
      Utils.checkNotNull(referenced, "Could not find previously generated schema");
      jacksonSchema = referenced;
    }

    if (type.isMapLikeType()) {
      final JavaType keyType = type.getKeyType();

      if (keyType.getRawClass() != String.class) {
        LOGGER.warn("Property '{}' with '{}' key type is mapped to 'string' because of CRD schemas limitations", name, keyType);
      }

      final JavaType valueType = type.getContentType();
      JsonSchema mapValueSchema = ((SchemaAdditionalProperties)((ObjectSchema)jacksonSchema).getAdditionalProperties()).getJsonSchema();
      T component = resolvePropertySchema(visited, schemaSwaps, name, valueType, mapValueSchema);
      return mapLikeProperty(component);
    }

    Class<?> def = type.getRawClass();
    if (visited.put(def.getName(), name) != null) {
      throw new IllegalArgumentException(
          "Found a cyclic reference involving the field of type " + def.getName() + " starting a field "
              + visited.entrySet().stream().map(e -> e.getValue() + " >>\n" + e.getKey()).collect(Collectors.joining(".")) + "."
              + name);
    }

    T res = resolveObject(visited, schemaSwaps, jacksonSchema);
    visited.remove(def.getName());
    return res;
  }

  /**
   * we've added support for ignoring an enum values, which complicates this processing
   * as that is something not supported directly by jackson
   */
  private Set<String> findIngoredEnumConstants(JavaType type) {
    Field[] fields = type.getRawClass().getFields();
    Set<String> toIgnore = new HashSet<>();
    for (Field field : fields) {
      if (field.isEnumConstant() && field.getAnnotation(JsonIgnore.class) != null) {
        // hack to figure out the enum constant
        try {
          Object value = field.get(null);
          toIgnore.add(resolvingContext.kubernetesSerialization.unmarshal(resolvingContext.kubernetesSerialization.asJson(value), String.class));
        } catch (IllegalArgumentException | IllegalAccessException e) {
        }
      }
    }
    return toIgnore;
  }

  /**
   * Version independent DTO for a ValidationRule
   */
  protected static class KubernetesValidationRule {
    private String fieldPath;
    private String message;
    private String messageExpression;
    private Boolean optionalOldSelf;
    private String reason;
    private String rule;

    public String getFieldPath() {
      return fieldPath;
    }

    public String getMessage() {
      return message;
    }

    public String getMessageExpression() {
      return messageExpression;
    }

    public Boolean getOptionalOldSelf() {
      return optionalOldSelf;
    }

    public String getReason() {
      return reason;
    }

    public String getRule() {
      return rule;
    }

    static KubernetesValidationRule from(ValidationRule validationRule) {
      KubernetesValidationRule result = new KubernetesValidationRule();
      result.rule = validationRule.value();
      result.reason = mapNotEmpty(validationRule.reason());
      result.message = mapNotEmpty(validationRule.message());
      result.messageExpression = mapNotEmpty(validationRule.messageExpression());
      result.fieldPath = mapNotEmpty(validationRule.fieldPath());
      result.optionalOldSelf = validationRule.optionalOldSelf() ? true : null;
      return result;
    }

    private static String mapNotEmpty(String s) {
      if (s == null)
        return null;
      if (s.isEmpty())
        return null;
      return s;
    }
  }

  /**
   * Creates a new specific builder object.
   *
   * @return a new builder object specific to the CRD generation version
   */
  protected abstract B newBuilder();

  /**
   * Adds the specified property to the specified builder
   *
   * @param name the property to add to the currently being built schema
   * @param builder the builder representing the schema being built
   * @param schema the built schema for the property being added
   */
  protected abstract void addProperty(String name, B builder, T schema);

  /**
   * Finishes up the process by actually building the final JSON schema based on the provided
   * builder and a potentially empty list of names of fields which should be marked as required
   *
   * @param builder the builder used to build the final schema
   * @param required the list of names of required fields
   * @param validationRules the list of validation rules
   * @param preserveUnknownFields whether preserveUnknownFields is enabled
   * @return the built JSON schema
   */
  public abstract T build(B builder,
      List<String> required,
      List<KubernetesValidationRule> validationRules,
      boolean preserveUnknownFields);

  private JsonSchema toJsonSchema(Class<?> clazz) {
    try {
      return resolvingContext.generator.generateSchema(clazz);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    }
  }

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

  protected abstract T addDescription(T schema, String description);

  protected abstract V mapValidationRule(KubernetesValidationRule validationRule);

  protected abstract void setDefault(T schema, JsonNode node);

  protected abstract void setMin(T schema, Double min);

  protected abstract void setMax(T schema, Double max);

  protected abstract void setFormat(T schema, String format);

  protected abstract void setPattern(T schema, String pattern);

  protected abstract void setNullable(T schema, Boolean nullable);

  protected abstract void setPreserveUnknown(T schema, Boolean preserveUnknown);

  protected abstract T addToValidationRules(T schema, List<V> validationRules);

}
