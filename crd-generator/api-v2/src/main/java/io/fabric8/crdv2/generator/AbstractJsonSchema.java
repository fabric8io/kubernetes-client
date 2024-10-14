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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ArraySchema;
import com.fasterxml.jackson.module.jsonSchema.types.ArraySchema.Items;
import com.fasterxml.jackson.module.jsonSchema.types.IntegerSchema;
import com.fasterxml.jackson.module.jsonSchema.types.NumberSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema.SchemaAdditionalProperties;
import com.fasterxml.jackson.module.jsonSchema.types.ReferenceSchema;
import com.fasterxml.jackson.module.jsonSchema.types.StringSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ValueTypeSchema;
import io.fabric8.crd.generator.annotation.PreserveUnknownFields;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.annotation.SchemaFrom;
import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.crdv2.generator.InternalSchemaSwaps.SwapResult;
import io.fabric8.crdv2.generator.ResolvingContext.GeneratorObjectSchema;
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
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.annotation.LabelSelector;
import io.fabric8.kubernetes.model.annotation.SpecReplicas;
import io.fabric8.kubernetes.model.annotation.StatusReplicas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

/**
 * Encapsulates the common logic supporting OpenAPI schema generation for CRD generation.
 *
 * @param <T> the concrete type of the generated JSON Schema
 * @param <V> the concrete type of the validation rule
 */
public abstract class AbstractJsonSchema<T extends KubernetesJSONSchemaProps, V extends KubernetesValidationRule> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJsonSchema.class);

  private ResolvingContext resolvingContext;
  private T root;
  private Set<String> dependentClasses = new HashSet<>();

  public static class AnnotationMetadata {
    public final Annotation annotation;
    public final KubernetesJSONSchemaProps schema;

    public AnnotationMetadata(Annotation annotation, KubernetesJSONSchemaProps schema) {
      this.annotation = annotation;
      this.schema = schema;
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

  public Set<String> getDependentClasses() {
    return dependentClasses;
  }

  public Optional<String> getSinglePath(Class<? extends Annotation> clazz) {
    return ofNullable(pathMetadata.get(clazz)).flatMap(m -> m.keySet().stream().findFirst());
  }

  public Map<String, AnnotationMetadata> getAllPaths(Class<PrinterColumn> clazz) {
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
    JsonSchema schema = resolvingContext.toJsonSchema(definition);
    if (schema instanceof GeneratorObjectSchema) {
      return resolveObject(new LinkedHashMap<>(), schemaSwaps, schema, "kind", "apiVersion", "metadata");
    }
    return resolveProperty(new LinkedHashMap<>(), schemaSwaps, null,
        resolvingContext.objectMapper.getSerializationConfig().constructType(definition), schema, null);
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

  Optional<Field> getFieldForMethod(BeanProperty beanProperty) {
    AnnotatedElement annotated = beanProperty.getMember().getAnnotated();
    if (annotated instanceof Method) {
      // field first
      Method m = (Method) annotated;
      String name = m.getName();
      if (name.startsWith("get") || name.startsWith("set")) {
        name = name.substring(3);
      } else if (name.startsWith("is")) {
        name = name.substring(2);
      }
      if (!name.isEmpty()) {
        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
      }

      try {
        return Optional.of(m.getDeclaringClass().getDeclaredField(name));
      } catch (NoSuchFieldException | SecurityException e) {
        // ignored
      }
    }
    return Optional.empty();
  }

  void collectValidationRules(BeanProperty beanProperty, List<V> validationRules) {
    // TODO: the old logic allowed for picking up the annotation from both the getter and the field
    // this requires a messy hack by convention because there doesn't seem to be a way to all annotations
    // nor does jackson provide the field
    AnnotatedElement member = beanProperty.getMember().getAnnotated();
    if (member instanceof Method) {
      Optional<Field> field = getFieldForMethod(beanProperty);
      try {
        field.map(f -> f.getAnnotation(ValidationRule.class)).map(this::from)
            .ifPresent(validationRules::add);
        field.map(f -> f.getAnnotation(ValidationRules.class))
            .ifPresent(ann -> Stream.of(ann.value()).map(this::from).forEach(validationRules::add));
      } catch (SecurityException e) {
        // ignored
      }
      // then method
      Stream.of(member.getAnnotationsByType(ValidationRule.class)).map(this::from).forEach(validationRules::add);
      return;
    }

    // fall back to standard logic
    ofNullable(beanProperty.getAnnotation(ValidationRule.class)).map(this::from)
        .ifPresent(validationRules::add);
    ofNullable(beanProperty.getAnnotation(ValidationRules.class))
        .ifPresent(ann -> Stream.of(ann.value()).map(this::from).forEach(validationRules::add));
  }

  class PropertyMetadata {

    private boolean required;
    private String description;
    private String defaultValue;
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

    public PropertyMetadata(JsonSchema value, BeanProperty beanProperty) {
      required = Boolean.TRUE.equals(value.getRequired());

      description = beanProperty.getMetadata().getDescription();
      defaultValue = beanProperty.getMetadata().getDefaultValue();

      schemaFrom = ofNullable(beanProperty.getAnnotation(SchemaFrom.class)).map(SchemaFrom::type).orElse(null);
      preserveUnknownFields = beanProperty.getAnnotation(PreserveUnknownFields.class) != null;

      if (value.isValueTypeSchema()) {
        ValueTypeSchema valueTypeSchema = value.asValueTypeSchema();
        this.format = ofNullable(valueTypeSchema.getFormat()).map(Object::toString).orElse(null);
      }

      if (value.isStringSchema()) {
        StringSchema stringSchema = value.asStringSchema();
        // only set if ValidationSchemaFactoryWrapper is used
        pattern = ofNullable(beanProperty.getAnnotation(Pattern.class)).map(Pattern::value)
            .or(() -> ofNullable(stringSchema.getPattern()))
            .orElse(null);
        minLength = findMinInSizeAnnotation(beanProperty)
            .or(() -> ofNullable(stringSchema.getMinLength()).map(Integer::longValue))
            .orElse(null);
        maxLength = findMaxInSizeAnnotation(beanProperty)
            .or(() -> ofNullable(stringSchema.getMaxLength()).map(Integer::longValue))
            .orElse(null);
      } else if (value.isIntegerSchema()) {
        // integerschema extends numberschema and must handled first
        IntegerSchema integerSchema = value.asIntegerSchema();
        setMinMax(beanProperty,
            integerSchema.getMinimum(),
            integerSchema.getExclusiveMinimum(),
            integerSchema.getMaximum(),
            integerSchema.getExclusiveMaximum());
      } else if (value.isNumberSchema()) {
        NumberSchema numberSchema = value.asNumberSchema();
        setMinMax(beanProperty,
            numberSchema.getMinimum(),
            numberSchema.getExclusiveMinimum(),
            numberSchema.getMaximum(),
            numberSchema.getExclusiveMaximum());
      } else if (value.isArraySchema()) {
        ArraySchema arraySchema = value.asArraySchema();
        minItems = findMinInSizeAnnotation(beanProperty)
            .or(() -> ofNullable(arraySchema.getMinItems()).map(Integer::longValue))
            .orElse(null);
        maxItems = findMaxInSizeAnnotation(beanProperty)
            .or(() -> ofNullable(arraySchema.getMaxItems()).map(Integer::longValue))
            .orElse(null);
      } else if (value.isObjectSchema()) {
        // TODO: Could be also applied only on Maps instead of "all the rest"
        minProperties = findMinInSizeAnnotation(beanProperty)
            .orElse(null);
        maxProperties = findMaxInSizeAnnotation(beanProperty)
            .orElse(null);
      }

      collectValidationRules(beanProperty, validationRules);

      // TODO: should probably move to a standard annotations
      // see ValidationSchemaFactoryWrapper
      nullable = beanProperty.getAnnotation(Nullable.class) != null;

      // TODO: should the following be deprecated?
      required = beanProperty.getAnnotation(Required.class) != null;
      defaultValue = ofNullable(beanProperty.getAnnotation(Default.class)).map(Default::value).orElse(defaultValue);
    }

    private void setMinMax(BeanProperty beanProperty,
        Double minimum, Boolean exclusiveMinimum, Double maximum, Boolean exclusiveMaximum) {
      ofNullable(minimum).ifPresent(v -> {
        this.min = v;
        if (Boolean.TRUE.equals(exclusiveMinimum)) {
          this.exclusiveMinimum = true;
        }
      });
      ofNullable(beanProperty.getAnnotation(Min.class)).ifPresent(a -> {
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
      ofNullable(beanProperty.getAnnotation(Max.class)).ifPresent(a -> {
        this.max = a.value();
        if (!a.inclusive()) {
          this.exclusiveMaximum = true;
        }
      });
    }

    public void updateSchema(T schema) {
      schema.setDescription(description);

      if (defaultValue != null) {
        try {
          schema.setDefault(resolvingContext.kubernetesSerialization.convertValue(defaultValue, JsonNode.class));
        } catch (IllegalArgumentException e) {
          throw new IllegalArgumentException("Cannot parse default value: '" + defaultValue + "' as valid YAML.", e);
        }
      }
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

    private Optional<Long> findMinInSizeAnnotation(BeanProperty beanProperty) {
      return ofNullable(beanProperty.getAnnotation(Size.class))
          .map(Size::min)
          .filter(v -> v > 0);
    }

    private Optional<Long> findMaxInSizeAnnotation(BeanProperty beanProperty) {
      return ofNullable(beanProperty.getAnnotation(Size.class))
          .map(Size::max)
          .filter(v -> v < Long.MAX_VALUE);
    }
  }

  private T resolveObject(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, JsonSchema jacksonSchema,
      String... ignore) {
    Set<String> ignores = ignore.length > 0 ? new LinkedHashSet<>(Arrays.asList(ignore)) : Collections.emptySet();

    final T objectSchema = singleProperty("object");

    schemaSwaps = schemaSwaps.branchAnnotations();
    final InternalSchemaSwaps swaps = schemaSwaps;

    GeneratorObjectSchema gos = (GeneratorObjectSchema) jacksonSchema.asObjectSchema();
    BeanDescription bd = resolvingContext.objectMapper.getSerializationConfig().introspect(gos.javaType);
    boolean preserveUnknownFields = false;
    if (resolvingContext.implicitPreserveUnknownFields) {
      preserveUnknownFields = bd.findAnyGetter() != null || bd.findAnySetterAccessor() != null;
    }

    Class<?> rawClass = gos.javaType.getRawClass();
    collectDependentClasses(rawClass);

    consumeRepeatingAnnotation(rawClass, SchemaSwap.class, ss -> {
      swaps.registerSwap(rawClass,
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
      SwapResult swapResult = schemaSwaps.lookupAndMark(rawClass, name);
      LinkedHashMap<String, String> savedVisited = visited;
      if (swapResult.onGoing) {
        visited = new LinkedHashMap<>();
      }

      BeanProperty beanProperty = gos.beanProperties.get(property.getKey());
      Utils.checkNotNull(beanProperty, "CRD generation works only with bean properties");

      JsonSchema propertySchema = property.getValue();
      PropertyMetadata propertyMetadata = new PropertyMetadata(propertySchema, beanProperty);

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
        propertySchema = resolvingContext.toJsonSchema(propertyMetadata.schemaFrom);
        type = resolvingContext.objectMapper.getSerializationConfig().constructType(propertyMetadata.schemaFrom);
      }

      T schema = resolveProperty(visited, schemaSwaps, name, type, propertySchema, beanProperty);

      propertyMetadata.updateSchema(schema);

      if (!swapResult.onGoing) {
        for (Entry<Class<? extends Annotation>, LinkedHashMap<String, AnnotationMetadata>> entry : pathMetadata.entrySet()) {
          ofNullable(beanProperty.getAnnotation(entry.getKey())).ifPresent(
              ann -> entry.getValue().put(toFQN(savedVisited, name),
                  new AnnotationMetadata(ann, schema)));
        }
      }

      visited = savedVisited;

      addProperty(name, objectSchema, schema);
    }

    swaps.throwIfUnmatchedSwaps();

    objectSchema.setRequired(required);
    if (preserveUnknownFields) {
      objectSchema.setXKubernetesPreserveUnknownFields(true);
    }
    List<V> validationRules = new ArrayList<>();
    consumeRepeatingAnnotation(rawClass, ValidationRule.class,
        v -> validationRules.add(from(v)));
    addToValidationRules(objectSchema, validationRules);
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

  private T resolveProperty(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, String name,
      JavaType type, JsonSchema jacksonSchema, BeanProperty beanProperty) {

    if (jacksonSchema.isArraySchema()) {
      Items items = jacksonSchema.asArraySchema().getItems();
      if (items == null) { // raw collection
        throw new IllegalStateException(String.format("Untyped collection %s", name));
      }
      if (items.isArrayItems()) {
        throw new IllegalStateException("not yet supported");
      }
      JsonSchema arraySchema = jacksonSchema.asArraySchema().getItems().asSingleItems().getSchema();
      final T schema = resolveProperty(visited, schemaSwaps, name, type.getContentType(), arraySchema, null);
      handleTypeAnnotations(schema, beanProperty, List.class, 0);
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
        Set<String> ignores = type.isEnumType() ? findIgnoredEnumConstants(type) : Collections.emptySet();
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
      if (type.getRawClass() == IntOrString.class || type.getRawClass() == Quantity.class) {
        // TODO: create a serializer for this and remove this override
        // - that won't work currently as there's no way to create a UnionSchema from the Jackson api
        return intOrString();
      }
      if (type.getRawClass() == RawExtension.class) {
        return raw();
      }
      // TODO: this could optionally take a type restriction
      T schema = singleProperty(null);
      schema.setXKubernetesPreserveUnknownFields(true);
      return schema;
    } else if (jacksonSchema.isUnionTypeSchema()) {
      throw new IllegalStateException("not yet supported");
    } else if (jacksonSchema instanceof ReferenceSchema) {
      // de-reference the reference schema - these can be naturally non-cyclic, for example siblings
      ReferenceSchema ref = (ReferenceSchema) jacksonSchema;
      GeneratorObjectSchema referenced = resolvingContext.uriToJacksonSchema.get(ref.get$ref());
      Utils.checkNotNull(referenced, "Could not find previously generated schema");
      jacksonSchema = referenced;
    } else if (type.isMapLikeType()) {
      final JavaType keyType = type.getKeyType();

      if (keyType.getRawClass() != String.class) {
        LOGGER.warn("Property '{}' with '{}' key type is mapped to 'string' because of CRD schemas limitations", name, keyType);
      }

      final JavaType valueType = type.getContentType();
      JsonSchema mapValueSchema = ((SchemaAdditionalProperties) ((ObjectSchema) jacksonSchema).getAdditionalProperties())
          .getJsonSchema();
      T component = resolveProperty(visited, schemaSwaps, name, valueType, mapValueSchema, null);
      handleTypeAnnotations(component, beanProperty, Map.class, 1);
      return mapLikeProperty(component);
    }

    Class<?> def = type.getRawClass();

    // KubernetesResource is too broad, but we can check for several common subclasses
    if (def == GenericKubernetesResource.class
        || (def.isInterface() && HasMetadata.class.isAssignableFrom(def))) {
      return raw();
    }

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

  private void handleTypeAnnotations(final T schema, BeanProperty beanProperty, Class<?> containerType, int typeIndex) {
    if (beanProperty == null || !containerType.equals(beanProperty.getType().getRawClass())) {
      return;
    }

    AnnotatedElement member = beanProperty.getMember().getAnnotated();
    AnnotatedType fieldType = null;
    AnnotatedType methodType = null;
    if (member instanceof Field) {
      fieldType = ((Field) member).getAnnotatedType();
    } else if (member instanceof Method) {
      fieldType = getFieldForMethod(beanProperty).map(Field::getAnnotatedType).orElse(null);
      methodType = ((Method) member).getAnnotatedReceiverType();
    }

    Stream.of(fieldType, methodType)
        .filter(o -> !Objects.isNull(o))
        .filter(AnnotatedParameterizedType.class::isInstance)
        .map(AnnotatedParameterizedType.class::cast)
        .map(AnnotatedParameterizedType::getAnnotatedActualTypeArguments)
        .map(a -> a[typeIndex])
        .forEach(at -> {
          if ("string".equals(schema.getType())) {
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

          } else if ("number".equals(schema.getType()) || "integer".equals(schema.getType())) {
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
   * we've added support for ignoring enum values, which complicates this processing
   * as that is something not supported directly by jackson
   */
  private Set<String> findIgnoredEnumConstants(JavaType type) {
    Field[] fields = type.getRawClass().getFields();
    Set<String> toIgnore = new HashSet<>();
    for (Field field : fields) {
      if (field.isEnumConstant() && field.getAnnotation(JsonIgnore.class) != null) {
        // hack to figure out the enum constant - this guards against some using both JsonIgnore and JsonProperty
        try {
          Object value = field.get(null);
          toIgnore.add(resolvingContext.objectMapper.convertValue(value, String.class));
        } catch (IllegalArgumentException | IllegalAccessException e) {
          // ignored
        }
      }
    }
    return toIgnore;
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

}
