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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.fabric8.crd.generator.annotation.AdditionalPrinterColumn;
import io.fabric8.crd.generator.annotation.AdditionalSelectableField;
import io.fabric8.crd.generator.annotation.PreserveUnknownFields;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.annotation.SchemaFrom;
import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.crd.generator.annotation.SelectableField;
import io.fabric8.crdv2.generator.InternalSchemaSwaps.SwapResult;
import io.fabric8.crdv2.generator.ResolvingContext.GeneratorObjectSchema;
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
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;
import tools.jackson.databind.ser.BeanPropertyWriter;
import tools.jackson.module.jsonSchema.JsonSchema;
import tools.jackson.module.jsonSchema.types.ArraySchema;
import tools.jackson.module.jsonSchema.types.ArraySchema.Items;
import tools.jackson.module.jsonSchema.types.IntegerSchema;
import tools.jackson.module.jsonSchema.types.NumberSchema;
import tools.jackson.module.jsonSchema.types.ObjectSchema;
import tools.jackson.module.jsonSchema.types.ObjectSchema.SchemaAdditionalProperties;
import tools.jackson.module.jsonSchema.types.ReferenceSchema;
import tools.jackson.module.jsonSchema.types.StringSchema;
import tools.jackson.module.jsonSchema.types.ValueTypeSchema;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedParameterizedType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.namespace.QName;

import static java.util.Optional.ofNullable;

/**
 * Encapsulates the common logic supporting OpenAPI schema generation for CRD generation.
 *
 * @param <T> the concrete type of the generated JSON Schema
 * @param <V> the concrete type of the validation rule
 */
public abstract class AbstractJsonSchema<T extends KubernetesJSONSchemaProps, V extends KubernetesValidationRule> {

  private static final Logger logger = LoggerFactory.getLogger(AbstractJsonSchema.class);

  /**
   * Jackson gives every JDK date and time type one of these formats, but the API server validates {@code date-time}
   * as RFC 3339 (the offset is mandatory) and {@code date} as a full-date, rejecting any value that doesn't match.
   * JDK types only keep the format when they always write a matching value, see {@link #writesFormat}.
   */
  private static final Set<String> TEMPORAL_FORMATS = Set.of("date-time", "date", "time");

  private final ResolvingContext resolvingContext;
  private final T root;
  private final Set<String> dependentClasses = new HashSet<>();
  private final Set<AdditionalPrinterColumn> additionalPrinterColumns = new HashSet<>();
  private final Set<AdditionalSelectableField> additionalSelectableFields = new HashSet<>();

  public static class AnnotationMetadata {
    public final Annotation annotation;
    public final KubernetesJSONSchemaProps schema;

    public AnnotationMetadata(Annotation annotation, KubernetesJSONSchemaProps schema) {
      this.annotation = annotation;
      this.schema = schema;
    }
  }

  private final Map<Class<? extends Annotation>, LinkedHashMap<String, AnnotationMetadata>> pathMetadata = new HashMap<>();

  public AbstractJsonSchema(ResolvingContext resolvingContext, Class<?> def) {
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
    JsonSchema schema = resolvingContext.toJsonSchema(definition);
    consumeRepeatingAnnotation(definition, AdditionalPrinterColumn.class,
        additionalPrinterColumns::add);
    consumeRepeatingAnnotation(definition, AdditionalSelectableField.class,
        additionalSelectableFields::add);
    if (schema instanceof GeneratorObjectSchema) {
      return resolveObject(new LinkedHashMap<>(), schemaSwaps, schema, null, "kind", "apiVersion", "metadata");
    }
    return resolveProperty(new LinkedHashMap<>(), schemaSwaps, null,
        resolvingContext.objectMapper.serializationConfig().constructType(definition), schema, null, null);
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

    public PropertyMetadata(JsonSchema value, BeanProperty beanProperty) {
      required = Boolean.TRUE.equals(value.getRequired());

      description = beanProperty.getMetadata().getDescription();

      schemaFrom = ofNullable(beanProperty.getAnnotation(SchemaFrom.class)).<Class<?>> map(SchemaFrom::type)
          .orElseGet(() -> serializedAs(beanProperty));
      preserveUnknownFields = beanProperty.getAnnotation(PreserveUnknownFields.class) != null;

      if (value.isValueTypeSchema()) {
        ValueTypeSchema valueTypeSchema = value.asValueTypeSchema();
        this.format = ofNullable(valueTypeSchema.getFormat()).map(Object::toString).orElse(null);
      }

      if (format != null && TEMPORAL_FORMATS.contains(format) && !keepsTemporalFormat(beanProperty, format)) {
        this.format = null;
      }

      if (value.isStringSchema()) {
        StringSchema stringSchema = value.asStringSchema();
        // only set if ValidationSchemaFactoryWrapper is used
        pattern = ofNullable(beanProperty.getAnnotation(Pattern.class)).map(Pattern::value)
            .or(() -> ofNullable(stringSchema.getPattern()))
            .orElse(null);
        // @Size counts the bytes of a binary type, the API server validates the length of their base64 string
        final UnaryOperator<Long> length = value instanceof Base64Schema
            ? AbstractJsonSchema::base64Length
            : UnaryOperator.identity();
        minLength = findMinInSizeAnnotation(beanProperty).map(length)
            .or(() -> ofNullable(stringSchema.getMinLength()).map(Integer::longValue))
            .orElse(null);
        maxLength = findMaxInSizeAnnotation(beanProperty).map(length)
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
      defaultValue = toDefault(beanProperty);
    }

    JsonNode toDefault(BeanProperty beanProperty) {
      Optional<String> defaultAnnotationValue = ofNullable(beanProperty.getAnnotation(Default.class)).map(Default::value);
      String value = defaultAnnotationValue.orElse(beanProperty.getMetadata().getDefaultValue());

      if (value == null) {
        return null;
      }
      Optional<Class<?>> rawType = Optional.ofNullable(beanProperty.getType()).map(JavaType::getRawClass);
      try {
        Object typedValue = resolvingContext.kubernetesSerialization.unmarshal(value, rawType.orElse(Object.class));
        return resolvingContext.kubernetesSerialization.convertValue(typedValue, JsonNode.class);
      } catch (Exception e) {
        if (defaultAnnotationValue.isEmpty()) {
          logger.warn("Cannot parse default value: '" + value
              + "' from JsonProperty annotation as valid YAML or JSON, no default value will be used.");
          return null;
        }
        final String strippedValue = value.strip();
        final String jsonHint = strippedValue.startsWith("{") || strippedValue.startsWith("[")
            ? " Values starting with '{' or '[' are parsed as JSON, so a flow-style YAML mapping such as"
                + " '{key: value}' has to be written as JSON ('{\"key\": \"value\"}')."
            : "";
        throw new IllegalArgumentException(
            "Cannot parse default value: '" + value + "' as valid YAML or JSON." + jsonHint, e);
      }
    }

    /**
     * The type Jackson writes instead of the declared one ({@code @JsonSerialize(as)}), resolved on its own like
     * {@code @SchemaFrom}: jackson-module-jsonSchema reuses the first schema it builds for a declared type, so
     * properties declared with the same type would otherwise share one schema.
     */
    private Class<?> serializedAs(BeanProperty beanProperty) {
      if (beanProperty instanceof BeanPropertyWriter) {
        final JavaType serializationType = ((BeanPropertyWriter) beanProperty).getSerializationType();
        if (serializationType != null && !serializationType.hasRawClass(beanProperty.getType().getRawClass())) {
          return serializationType.getRawClass();
        }
      }
      return null;
    }

    /**
     * JDK types keep only the formats they always match, other types keep whatever their serializer declares.
     */
    private boolean keepsTemporalFormat(BeanProperty beanProperty, String format) {
      final JavaType type = unwrapReferenceType(beanProperty.getType());
      return type == null || !type.getRawClass().getName().startsWith("java.")
          || writesFormat(type.getRawClass(), format);
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
      if (format != null) {
        // otherwise keep the one resolveProperty derived from the type
        schema.setFormat(format);
      }
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

  /**
   * @param valueTypeInfo the {@link JsonTypeInfo} of the property holding this value, which overrides the one of its type
   */
  private T resolveObject(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, JsonSchema jacksonSchema,
      JsonTypeInfo valueTypeInfo, String... ignore) {
    Set<String> ignores = ignore.length > 0 ? new LinkedHashSet<>(Arrays.asList(ignore)) : Collections.emptySet();

    T objectSchema = singleProperty("object");

    schemaSwaps = schemaSwaps.branchAnnotations();
    final InternalSchemaSwaps swaps = schemaSwaps;

    GeneratorObjectSchema gos = (GeneratorObjectSchema) jacksonSchema.asObjectSchema();
    BeanDescription bd = CRDUtils.introspectForSerialization(
        resolvingContext.objectMapper.serializationConfig(), gos.javaType);
    boolean preserveUnknownFields = false;
    if (resolvingContext.implicitPreserveUnknownFields) {
      preserveUnknownFields = bd.findAnyGetter() != null || bd.findAnySetterAccessor() != null;
    }

    Class<?> rawClass = gos.javaType.getRawClass();
    collectDependentClasses(rawClass);

    JsonClassDescription classDescription = findClassAnnotation(rawClass, JsonClassDescription.class);
    if (classDescription != null && Utils.isNotNullOrEmpty(classDescription.value())) {
      objectSchema.setDescription(classDescription.value());
    }

    // while it should not be repeating, we reuse this method to look for preserve unknown on the class hierarchy
    consumeRepeatingAnnotation(rawClass, PreserveUnknownFields.class,
        ignored -> objectSchema.setXKubernetesPreserveUnknownFields(true));

    // only the declared type is introspected, so the subtypes' properties are not part of the schema;
    // CRDs cannot express a discriminated union, so keep the subtype content instead of pruning it
    if (isPolymorphic(valueTypeInfo, bd)) {
      objectSchema.setXKubernetesPreserveUnknownFields(true);
    }

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

      final BeanProperty beanProperty = gos.beanProperties.get(property.getKey());
      Utils.checkNotNull(beanProperty, "CRD generation works only with bean properties");
      if (beanProperty.getAnnotation(JsonIgnore.class) != null) {
        continue;
      }

      JsonSchema propertySchema = wireSchema(beanProperty.getType(), property.getValue(), beanProperty);
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
        type = resolvingContext.objectMapper.serializationConfig().constructType(propertyMetadata.schemaFrom);
      }

      T schema = resolveProperty(visited, schemaSwaps, name, type, propertySchema, beanProperty,
          beanProperty.getAnnotation(JsonTypeInfo.class));

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
   * @param valueTypeInfo the property's {@link JsonTypeInfo}, which applies to its value, or to the elements of a container
   */
  private T resolveProperty(LinkedHashMap<String, String> visited, InternalSchemaSwaps schemaSwaps, String name,
      JavaType type, JsonSchema jacksonSchema, BeanProperty beanProperty, JsonTypeInfo valueTypeInfo) {

    // the schema Jackson generated is the referenced type's, so resolve it with that type
    type = unwrapReferenceType(type);
    jacksonSchema = wireSchema(type, jacksonSchema, beanProperty);
    final String integerFormat = integerFormat(type);

    if (jacksonSchema.isArraySchema()) {
      Items items = jacksonSchema.asArraySchema().getItems();
      if (items == null) { // raw collection, or one with an Object element type
        return arrayLikeProperty(anyTypeProperty());
      }
      if (items.isArrayItems()) {
        throw new IllegalStateException("not yet supported");
      }
      JsonSchema arraySchema = jacksonSchema.asArraySchema().getItems().asSingleItems().getSchema();
      final T schema = resolveProperty(visited, schemaSwaps, name, type.getContentType(), arraySchema, null,
          valueTypeInfo);
      handleTypeAnnotations(schema, beanProperty, List.class, 0);
      return arrayLikeProperty(schema);
    } else if (jacksonSchema.isIntegerSchema() || (jacksonSchema.isNumberSchema() && integerFormat != null)) {
      // Jackson describes the items of a long[] as numbers
      final T schema = singleProperty("integer");
      schema.setFormat(integerFormat);
      return schema;
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
            .map(JsonNodeFactory.instance::stringNode)
            .toArray(JsonNode[]::new);
        return enumProperty(enumValues);
      }
      final T schema = singleProperty("string");
      if (jacksonSchema instanceof Base64Schema) {
        schema.setFormat("byte");
      }
      return schema;
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
      String typeName = null;
      if (type.getRawClass() == ObjectNode.class) {
        typeName = "object";
      }
      T schema = singleProperty(typeName);

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
      final JavaType valueType = type.getContentType();

      if (keyType.getRawClass() != String.class) {
        logger.warn("Property '{}' with '{}' key type is mapped to 'string' because of CRD schemas limitations", name, keyType);
      }

      JsonSchema mapValueSchema = ((SchemaAdditionalProperties) ((ObjectSchema) jacksonSchema).getAdditionalProperties())
          .getJsonSchema();
      T component = resolveProperty(visited, schemaSwaps, name, valueType, mapValueSchema, null, valueTypeInfo);
      handleTypeAnnotations(component, beanProperty, Map.class, 1);
      return mapLikeProperty(component);
    }

    Class<?> def = type.getRawClass();

    // KubernetesResource is too broad, but we can check for several common subclasses
    if (def == GenericKubernetesResource.class
        || (def.isInterface() && HasMetadata.class.isAssignableFrom(def))) {
      return raw();
    }

    // an Object property (or an Object map value) holds arbitrary JSON, so it cannot be described further.
    // Its Jackson schema can't be trusted either: it's shared with every Object property, including one with
    // @JsonSerialize(as), which is resolved from that type instead (see PropertyMetadata#serializedAs)
    if (def == Object.class) {
      return anyTypeProperty();
    }

    if (visited.put(def.getName(), name) != null) {
      throw new IllegalArgumentException(
          "Found a cyclic reference involving the field of type " + def.getName() + " starting a field "
              + visited.entrySet().stream().map(e -> e.getValue() + " >>\n" + e.getKey()).collect(Collectors.joining(".")) + "."
              + name);
    }

    T res = resolveObject(visited, schemaSwaps, jacksonSchema, valueTypeInfo);
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

            // see PropertyMetadata
            final UnaryOperator<Long> length = "byte".equals(schema.getFormat())
                ? AbstractJsonSchema::base64Length
                : UnaryOperator.identity();
            ofNullable(at.getAnnotation(Size.class))
                .map(Size::min)
                .filter(v -> v > 0)
                .map(length)
                .ifPresent(schema::setMinLength);

            ofNullable(at.getAnnotation(Size.class))
                .map(Size::max)
                .filter(v -> v < Long.MAX_VALUE)
                .map(length)
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

  /**
   * Whether the JDK type always writes a value the format accepts. Durations ({@code PT1H30M}), {@code LocalDateTime}
   * and {@code java.sql.Time} (no offset) and the partial types ({@code 10:15:30+01:00}, {@code 2026-01},
   * {@code --12-25}) never do.
   */
  private static boolean writesFormat(Class<?> type, String format) {
    return switch (format) {
      case "date-time" -> type == Instant.class || type == OffsetDateTime.class || type == ZonedDateTime.class
          || Calendar.class.isAssignableFrom(type)
          || (Date.class.isAssignableFrom(type) && type != java.sql.Time.class);
      // java.sql.Date only reports date with Jackson2JdkTypesModule, which writes it as yyyy-MM-dd
      case "date" -> type == LocalDate.class || type == java.sql.Date.class;
      default -> false;
    };
  }

  /**
   * Jackson's serializers describe {@code byte[]} and {@code ByteBuffer} as arrays of integers and {@code char[]} and
   * {@code QName} as an array and an object (or a reference to the first QName), but write them as strings (base64 for
   * the binary types). Only these default descriptions are replaced, a property with its own serializer keeps its schema.
   */
  private static JsonSchema wireSchema(JavaType type, JsonSchema schema, BeanProperty beanProperty) {
    final JavaType valueType = unwrapReferenceType(type);
    if (valueType == null || hasOwnSerializer(beanProperty)) {
      return schema;
    }
    if (schema.isArraySchema() && isBinary(valueType)) {
      return new Base64Schema();
    }
    if ((schema.isArraySchema() && valueType.hasRawClass(char[].class))
        || ((schema.isObjectSchema() || schema instanceof ReferenceSchema) && valueType.hasRawClass(QName.class))) {
      return new StringSchema();
    }
    return schema;
  }

  private static boolean hasOwnSerializer(BeanProperty beanProperty) {
    final JsonSerialize serialize = beanProperty == null ? null : beanProperty.getAnnotation(JsonSerialize.class);
    return serialize != null && serialize.using() != ValueSerializer.None.class;
  }

  /**
   * A binary type Jackson writes as a base64 string, see {@link #wireSchema}.
   */
  private static final class Base64Schema extends StringSchema {
  }

  /**
   * The format controller-gen gives the Go counterpart ({@code int32}, {@code int64}), which the API server
   * range-checks. {@code short}, {@code byte} and {@code BigInteger} get none, like Go's {@code int16} and {@code int8}.
   */
  private static String integerFormat(JavaType type) {
    if (type == null) {
      return null;
    }
    final Class<?> raw = type.getRawClass();
    if (raw == int.class || raw == Integer.class || raw == OptionalInt.class || raw == AtomicInteger.class) {
      return "int32";
    }
    if (raw == long.class || raw == Long.class || raw == OptionalLong.class || raw == AtomicLong.class) {
      return "int64";
    }
    return null;
  }

  /**
   * Written as base64, like Go's {@code []byte}. {@code Byte[]} and {@code List<Byte>} are written as arrays of numbers.
   */
  private static boolean isBinary(JavaType type) {
    return type != null && (type.hasRawClass(byte[].class) || ByteBuffer.class.isAssignableFrom(type.getRawClass()));
  }

  private static long base64Length(long bytes) {
    return 4 * ((bytes + 2) / 3);
  }

  /**
   * Jackson describes {@code Optional<X>} and the other reference types with the schema of {@code X}.
   */
  private static JavaType unwrapReferenceType(JavaType type) {
    while (type != null && type.isReferenceType()) {
      type = type.getReferencedType();
    }
    return type;
  }

  /**
   * A property's {@link JsonTypeInfo} overrides its type's, which Jackson also inherits from interfaces and mix-ins.
   * {@link JsonTypeInfo.Id#NONE} opts out of polymorphic handling.
   */
  private static boolean isPolymorphic(JsonTypeInfo valueTypeInfo, BeanDescription bd) {
    final JsonTypeInfo typeInfo = valueTypeInfo != null ? valueTypeInfo : bd.getClassAnnotations().get(JsonTypeInfo.class);
    if (typeInfo != null) {
      return typeInfo.use() != JsonTypeInfo.Id.NONE;
    }
    return bd.getClassAnnotations().has(JsonSubTypes.class);
  }

  /**
   * Schema for content that cannot be described, such as an {@code Object} property or a raw collection.
   * Without {@code x-kubernetes-preserve-unknown-fields} the API server prunes whatever is stored there.
   */
  private T anyTypeProperty() {
    T schema = singleProperty(null);
    schema.setXKubernetesPreserveUnknownFields(true);
    return schema;
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
