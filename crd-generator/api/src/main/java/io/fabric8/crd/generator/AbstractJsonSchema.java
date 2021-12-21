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
package io.fabric8.crd.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import io.fabric8.crd.generator.utils.Types;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Quantity;
import io.sundr.builder.internal.functions.TypeAs;
import io.sundr.model.*;
import io.sundr.utils.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static io.sundr.model.utils.Types.BOOLEAN_REF;

import static io.sundr.model.utils.Types.STRING_REF;

import static io.sundr.model.utils.Types.INT_REF;

import static io.sundr.model.utils.Types.LONG_REF;

import static io.sundr.model.utils.Types.DOUBLE_REF;

/**
 * Encapsulates the common logic supporting OpenAPI schema generation for CRD generation.
 *
 * @param <T> the concrete type of the generated JSON Schema
 * @param <B> the concrete type of the JSON Schema builder
 */
public abstract class AbstractJsonSchema<T, B> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJsonSchema.class);

  protected static final TypeDef QUANTITY = TypeDef.forName(Quantity.class.getName());
  protected static final TypeDef DURATION = TypeDef.forName(Duration.class.getName());
  protected static final TypeDef INT_OR_STRING =TypeDef.forName(IntOrString.class.getName());  

  protected static final TypeRef QUANTITY_REF = QUANTITY.toReference();
  protected static final TypeRef DURATION_REF = DURATION.toReference();
  protected static final TypeRef INT_OR_STRING_REF = INT_OR_STRING.toReference();


  protected static final TypeDef DATE = TypeDef.forName(Date.class.getName());
  protected static final TypeRef DATE_REF = DATE.toReference();

  private static final String INT_OR_STRING_MARKER = "int_or_string";
  private static final String STRING_MARKER = "string";
  private static final String NUMBER_MARKER = "number";
  private static final String BOOLEAN_MARKER = "boolean";

  protected static final TypeRef P_INT_REF = new PrimitiveRefBuilder().withName("int").build();
  protected static final TypeRef P_LONG_REF = new PrimitiveRefBuilder().withName("long").build();
  protected static final TypeRef P_DOUBLE_REF = new PrimitiveRefBuilder().withName("double").build();
  protected static final TypeRef P_BOOLEAN_REF = new PrimitiveRefBuilder().withName(BOOLEAN_MARKER)
    .build();

  private static final Map<TypeRef, String> COMMON_MAPPINGS = new HashMap<>();
  public static final String ANNOTATION_JSON_PROPERTY = "com.fasterxml.jackson.annotation.JsonProperty";
  public static final String ANNOTATION_JSON_PROPERTY_DESCRIPTION = "com.fasterxml.jackson.annotation.JsonPropertyDescription";
  public static final String ANNOTATION_NOT_NULL = "javax.validation.constraints.NotNull";

  static {
    COMMON_MAPPINGS.put(STRING_REF, STRING_MARKER);
    COMMON_MAPPINGS.put(DATE_REF, STRING_MARKER);
    COMMON_MAPPINGS.put(INT_REF, "integer");
    COMMON_MAPPINGS.put(P_INT_REF, "integer");
    COMMON_MAPPINGS.put(LONG_REF, NUMBER_MARKER);
    COMMON_MAPPINGS.put(P_LONG_REF, NUMBER_MARKER);
    COMMON_MAPPINGS.put(DOUBLE_REF, NUMBER_MARKER);
    COMMON_MAPPINGS.put(P_DOUBLE_REF, NUMBER_MARKER);
    COMMON_MAPPINGS.put(BOOLEAN_REF, BOOLEAN_MARKER);
    COMMON_MAPPINGS.put(P_BOOLEAN_REF, BOOLEAN_MARKER);
    COMMON_MAPPINGS.put(QUANTITY_REF, INT_OR_STRING_MARKER);
    COMMON_MAPPINGS.put(INT_OR_STRING_REF, INT_OR_STRING_MARKER);
    COMMON_MAPPINGS.put(DURATION_REF, STRING_MARKER);
  }

  public static String getSchemaTypeFor(TypeRef typeRef) {
    String type = COMMON_MAPPINGS.get(typeRef);
    if (type == null && typeRef instanceof ClassRef) { // Handle complex types
      ClassRef classRef = (ClassRef) typeRef;
      TypeDef def = Types.typeDefFrom(classRef);
      type = def.isEnum() ? STRING_MARKER : "object";
    }
    return type;
  }

  /**
   * Creates the JSON schema for the particular {@link TypeDef}. This is template method where
   * sub-classes are supposed to provide specific implementations of abstract methods.
   *
   * @param definition The definition.
   * @param ignore     a potentially empty list of property names to ignore while generating the schema
   * @return The schema.
   */
  protected T internalFrom(TypeDef definition, String... ignore) {
    return internalFromImpl(definition, new HashSet<>(), ignore);
  }

  private T internalFromImpl(TypeDef definition, Set<String> visited, String... ignore) {
    final B builder = newBuilder();
    Set<String> ignores =
      ignore.length > 0 ? new LinkedHashSet<>(Arrays.asList(ignore)) : Collections
        .emptySet();
    List<String> required = new ArrayList<>();

    // index potential accessors by name for faster lookup
    final Map<String, Method> accessors = indexPotentialAccessors(definition);

    for (Property property : definition.getProperties()) {
      String name = property.getName();
      if (property.isStatic() || ignores.contains(name)) {
        LOGGER.debug("Ignoring property {}", name);
        continue;
      }

      final PropertyFacade facade = new PropertyFacade(property, accessors);
      final Property possiblyRenamedProperty = facade.process();
      name = possiblyRenamedProperty.getName();

      if (facade.required) {
        required.add(name);
      }
      final T schema = internalFromImpl(name, possiblyRenamedProperty.getTypeRef(), visited);
      // if we got a description from the field or an accessor, use it
      final String description = facade.description;
      final T possiblyUpdatedSchema;
      if (description == null) {
        possiblyUpdatedSchema = schema;
      } else {
        possiblyUpdatedSchema = addDescription(schema, description);
      }
      addProperty(possiblyRenamedProperty, builder, possiblyUpdatedSchema);
    }
    return build(builder, required);
  }

  private Map<String, Method> indexPotentialAccessors(TypeDef definition) {
    final List<Method> methods = definition.getMethods();
    final Map<String, Method> accessors = new HashMap<>(methods.size());
    methods.stream()
      .filter(this::isPotentialAccessor)
      .forEach(m -> accessors.put(m.getName(), m));
    return accessors;
  }


  private static class PropertyOrAccessor {
    private final Collection<AnnotationRef> annotations;
    private final String name;
    private final String propertyName;
    private final String type;
    private String renamedTo;
    private boolean required;
    private String description;

    private PropertyOrAccessor(Collection<AnnotationRef> annotations, String name, String propertyName, boolean isMethod) {
      this.annotations = annotations;
      this.name = name;
      this.propertyName = propertyName;
      type = isMethod ? "accessor" : "field";
    }

    static PropertyOrAccessor fromProperty(Property property) {
      return new PropertyOrAccessor(property.getAnnotations(), property.getName(), property.getName(), false);
    }

    static PropertyOrAccessor fromMethod(Method method, String propertyName) {
      return new PropertyOrAccessor(method.getAnnotations(), method.getName(), propertyName, true);
    }

    public void process() {
      annotations.forEach(a -> {
        switch (a.getClassRef().getFullyQualifiedName()) {
          case ANNOTATION_NOT_NULL:
            required = true;
            break;
          case ANNOTATION_JSON_PROPERTY:
            final String nameFromAnnotation = (String) a.getParameters().get("value");
            if (!Strings.isNullOrEmpty(nameFromAnnotation) && !propertyName.equals(nameFromAnnotation)) {
              renamedTo = nameFromAnnotation;
            }
            break;
          case ANNOTATION_JSON_PROPERTY_DESCRIPTION:
            final String descriptionFromAnnotation = (String) a.getParameters().get("value");
            if (!Strings.isNullOrEmpty(descriptionFromAnnotation)) {
              description = descriptionFromAnnotation;
            }
            break;
        }
      });
    }

    public String getRenamedTo() {
      return renamedTo;
    }

    public boolean isRequired() {
      return required;
    }

    public String getDescription() {
      return description;
    }

    public boolean contributeName() {
      return renamedTo != null;
    }

    public boolean contributeDescription() {
      return description != null;
    }

    @Override
    public String toString() {
      return "'" + name + "' " + type;
    }
  }

  private static class PropertyFacade {
    private final List<PropertyOrAccessor> propertyOrAccessors = new ArrayList<>(4);
    private String renamedTo;
    private String description;
    private boolean required;
    private final Property original;
    private String nameContributedBy;
    private String descriptionContributedBy;

    public PropertyFacade(Property property, Map<String, Method> potentialAccessors) {
      original = property;
      final String capitalized = property.getNameCapitalized();
      final String name = property.getName();
      propertyOrAccessors.add(PropertyOrAccessor.fromProperty(property));
      Method method = potentialAccessors.get("is" + capitalized);
      if (method != null) {
        propertyOrAccessors.add(PropertyOrAccessor.fromMethod(method, name));
      }
      method = potentialAccessors.get("get" + capitalized);
      if (method != null) {
        propertyOrAccessors.add(PropertyOrAccessor.fromMethod(method, name));
      }
      method = potentialAccessors.get("set" + capitalized);
      if (method != null) {
        propertyOrAccessors.add(PropertyOrAccessor.fromMethod(method, name));
      }
    }

    public Property process() {
      final String name = original.getName();

      propertyOrAccessors.forEach(p -> {
        p.process();
        final String contributorName = p.toString();
        if (p.contributeName()) {
          if (renamedTo == null) {
            renamedTo = p.getRenamedTo();
            this.nameContributedBy = contributorName;
          } else {
            LOGGER.debug("Property {} has already been renamed to {} by {}", name, renamedTo, nameContributedBy);
          }
        }

        if (p.contributeDescription()) {
          if (description == null) {
            description = p.getDescription();
            descriptionContributedBy = contributorName;
          } else {
            LOGGER.debug("Description for property {} has already been contributed by: {}", name, descriptionContributedBy);
          }
        }

        if (p.isRequired()) {
          required = true;
        }
      });
      
      return renamedTo != null ? new Property(original.getAnnotations(), original.getTypeRef(), renamedTo,
        original.getComments(), original.getModifiers(), original.getAttributes()) : original;
    }
  }

  private boolean isPotentialAccessor(Method method) {
    final String name = method.getName();
    return name.startsWith("is") || name.startsWith("get") || name.startsWith("set");
  }

  /**
   * Retrieves the updated property name for the specified property if its annotations warrant it
   *
   * @param property the Property which name might need to be updated
   * @return the updated property name or its original one if it didn't need to be changed
   */
  private String extractUpdatedNameFromJacksonPropertyIfPresent(Property property) {
    final String name = property.getName();
    return property.getAnnotations().stream()
      // only consider JsonProperty annotation
      .filter(a -> a.getClassRef().getFullyQualifiedName().equals(ANNOTATION_JSON_PROPERTY))
      .findAny()
      // if we found an annotated accessor, override the property's name if needed
      .map(a -> {
        final String fromAnnotation = (String) a.getParameters().get("value");
        if (!Strings.isNullOrEmpty(fromAnnotation) && !name.equals(fromAnnotation)) {
          return fromAnnotation;
        } else {
          return name;
        }
      }).orElse(property.getName());
  }

  /**
   * Creates a new specific builder object.
   *
   * @return a new builder object specific to the CRD generation version
   */
  public abstract B newBuilder();

  /**
   * Adds the specified property to the specified builder, calling {@link #internalFrom(String, TypeRef)}
   * to create the property schema.
   *
   * @param property the property to add to the currently being built schema
   * @param builder  the builder representing the schema being built
   * @param schema   the built schema for the property being added
   */
  public abstract void addProperty(Property property, B builder, T schema);

  /**
   * Finishes up the process by actually building the final JSON schema based on the provided
   * builder and a potentially empty list of names of fields which should be marked as required
   *
   * @param builder  the builder used to build the final schema
   * @param required the list of names of required fields
   * @return the built JSON schema
   */
  public abstract T build(B builder, List<String> required);

  /**
   * Builds the specific JSON schema representing the structural schema for the specified property
   *
   * @param name    the name of the property which schema we want to build
   * @param typeRef the type of the property which schema we want to build
   * @return the structural schema associated with the specified property
   */
  public T internalFrom(String name, TypeRef typeRef) {
    return internalFromImpl(name, typeRef, new HashSet<>());
  }

  private T internalFromImpl(String name, TypeRef typeRef, Set<String> visited) {
    // Note that ordering of the checks here is meaningful: we need to check for complex types last
    // in case some "complex" types are handled specifically
    if (typeRef.getDimensions() > 0 || io.sundr.model.utils.Collections.isCollection(typeRef)) { // Handle Collections & Arrays
      final TypeRef collectionType = TypeAs.combine(TypeAs.UNWRAP_ARRAY_OF, TypeAs.UNWRAP_COLLECTION_OF)
        .apply(typeRef);
      final T schema = internalFromImpl(name, collectionType, visited);
      return arrayLikeProperty(schema);
    } else if (io.sundr.model.utils.Collections.IS_MAP.apply(typeRef)) { // Handle Maps
      final TypeRef keyType = TypeAs.UNWRAP_MAP_KEY_OF.apply(typeRef);
      boolean degraded = false;
      if (keyType instanceof ClassRef) {
        ClassRef classRef = (ClassRef) keyType;
        if (!classRef.getFullyQualifiedName().equals("java.lang.String")) {
          degraded = true;
        } else {
          final TypeRef valueType = TypeAs.UNWRAP_MAP_VALUE_OF.apply(typeRef);
          classRef = (ClassRef) valueType;
          if (!classRef.getFullyQualifiedName().equals("java.lang.String")) {
            degraded = true;
          }
        }
      } else {
        degraded = true;
      }
      if (degraded) {
        LOGGER.warn("Property '{}' with '{}' type is mapped to a string to string mapping because of CRD schemas limitations", name, typeRef);
      }
      return mapLikeProperty();
    } else if (io.sundr.model.utils.Optionals.isOptional(typeRef)) { // Handle Optionals
      return internalFromImpl(name, TypeAs.UNWRAP_OPTIONAL_OF.apply(typeRef), visited);
    } else {
      final String typeName = COMMON_MAPPINGS.get(typeRef);
      if (typeName != null) { // we have a type that we handle specifically
        if (INT_OR_STRING_MARKER.equals(typeName)) { // Handle int or string mapped types
          return mappedProperty(typeRef);
        } else {
          return singleProperty(typeName); // Handle Standard Types
        }
      } else {
        if (typeRef instanceof ClassRef) { // Handle complex types
          ClassRef classRef = (ClassRef) typeRef;
          TypeDef def = Types.typeDefFrom(classRef);

          // check if we're dealing with an enum
          if (def.isEnum()) {
            final JsonNode[] enumValues = def.getProperties().stream()
              .map(this::extractUpdatedNameFromJacksonPropertyIfPresent)
              .filter(n -> !n.startsWith("$"))
              .map(JsonNodeFactory.instance::textNode)
              .toArray(JsonNode[]::new);
            return enumProperty(enumValues);
          } else {
            return resolveNestedClass(name, def, visited);
          }

        }
        return null;
      }
    }
  }

  // Flag to detect cycles
  private boolean resolving = false;

  private T resolveNestedClass(String name, TypeDef def, Set<String> visited) {
    if (!resolving) {
      visited.clear();
      resolving = true;
    } else {
      String visitedName = name + ":" + def.getFullyQualifiedName();
      if (!def.getFullyQualifiedName().startsWith("java") && visited.contains(visitedName)) {
        throw new IllegalArgumentException("Found a cyclic reference involving the field " + name + " of type " + def.getFullyQualifiedName());
      }
      visited.add(visitedName);
    }

    T res = internalFromImpl(def, visited);
    resolving = false;
    return res;
  }

  /**
   * Builds the schema for specifically handled property types (e.g. intOrString properties)
   *
   * @param ref the type of the specifically handled property
   * @return the property schema
   */
  protected abstract T mappedProperty(TypeRef ref);

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
   * @return the schema for the map-like property
   */
  protected abstract T mapLikeProperty();

  /**
   * Builds the schema for standard, simple (e.g. string) property types
   *
   * @param typeName the mapped name of the property type
   * @return the schema for the property
   */
  protected abstract T singleProperty(String typeName);

  protected abstract T enumProperty(JsonNode... enumValues);

  protected abstract T addDescription(T schema, String description);
}
