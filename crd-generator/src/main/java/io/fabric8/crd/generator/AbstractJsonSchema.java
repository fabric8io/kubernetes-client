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
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.PrimitiveRefBuilder;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;
import io.sundr.codegen.utils.TypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Encapsulates the common logic supporting OpenAPI schema generation for CRD generation.
 *
 * @param <T> the concrete type of the generated JSON Schema
 * @param <B> the concrete type of the JSON Schema builder
 */
public abstract class AbstractJsonSchema<T, B> {

  protected static final TypeDef QUANTITY = ClassTo.TYPEDEF.apply(Quantity.class);
  protected static final TypeDef DURATION = ClassTo.TYPEDEF.apply(Duration.class);
  protected static final TypeDef INT_OR_STRING = ClassTo.TYPEDEF.apply(IntOrString.class);


  protected static final TypeDef BOOLEAN = ClassTo.TYPEDEF.apply(Boolean.class);
  protected static final TypeDef STRING = ClassTo.TYPEDEF.apply(String.class);
  protected static final TypeDef INT = ClassTo.TYPEDEF.apply(Integer.class);
  protected static final TypeDef LONG = ClassTo.TYPEDEF.apply(Long.class);
  protected static final TypeDef DOUBLE = ClassTo.TYPEDEF.apply(Double.class);
  protected static final TypeDef DATE = ClassTo.TYPEDEF.apply(Date.class);
  protected static final TypeRef QUANTITY_REF = QUANTITY.toReference();
  protected static final TypeRef DURATION_REF = DURATION.toReference();
  protected static final TypeRef INT_OR_STRING_REF = INT_OR_STRING.toReference();


  protected static final TypeRef BOOLEAN_REF = BOOLEAN.toReference();
  protected static final TypeRef STRING_REF = STRING.toReference();
  protected static final TypeRef INT_REF = INT.toReference();
  protected static final TypeRef LONG_REF = LONG.toReference();
  protected static final TypeRef DOUBLE_REF = DOUBLE.toReference();
  protected static final TypeRef DATE_REF = DATE.toReference();

  protected static final TypeRef P_INT_REF = new PrimitiveRefBuilder().withName("int").build();
  protected static final TypeRef P_LONG_REF = new PrimitiveRefBuilder().withName("long").build();
  protected static final TypeRef P_DOUBLE_REF = new PrimitiveRefBuilder().withName("double").build();
  protected static final TypeRef P_BOOLEAN_REF = new PrimitiveRefBuilder().withName("boolean")
    .build();

  public static final Map<TypeRef, String> COMMON_MAPPINGS = new HashMap<>();
  private static final String INT_OR_STRING_MARKER = "int_or_string";

  static {
    COMMON_MAPPINGS.put(STRING_REF, "string");
    COMMON_MAPPINGS.put(DATE_REF, "string");
    COMMON_MAPPINGS.put(INT_REF, "integer");
    COMMON_MAPPINGS.put(P_INT_REF, "integer");
    COMMON_MAPPINGS.put(LONG_REF, "number");
    COMMON_MAPPINGS.put(P_LONG_REF, "number");
    COMMON_MAPPINGS.put(DOUBLE_REF, "number");
    COMMON_MAPPINGS.put(P_DOUBLE_REF, "number");
    COMMON_MAPPINGS.put(BOOLEAN_REF, "boolean");
    COMMON_MAPPINGS.put(P_BOOLEAN_REF, "boolean");
    COMMON_MAPPINGS.put(QUANTITY_REF, INT_OR_STRING_MARKER);
    COMMON_MAPPINGS.put(INT_OR_STRING_REF, INT_OR_STRING_MARKER);
    COMMON_MAPPINGS.put(DURATION_REF, "string");
  }

  /**
   * Creates the JSON schema for the particular {@link TypeDef}. This is template method where
   * sub-classes are supposed to provide specific implementations of abstract methods.
   *
   * @param definition The definition.
   * @param ignore a potentially empty list of property names to ignore while generating the schema
   * @return The schema.
   */
  protected T internalFrom(TypeDef definition, String... ignore) {
    final B builder = newBuilder();
    Set<String> ignores =
      ignore.length > 0 ? new LinkedHashSet<>(Arrays.asList(ignore)) : Collections
        .emptySet();
    List<String> required = new ArrayList<>();

    for (Property property : Types.allProperties(definition)) {
      if (property.isStatic()) {
        continue;
      }

      final String name = property.getName();
      if (ignores.contains(name)) {
        continue;
      }

      if (property.getAnnotations()
        .stream()
        .anyMatch(a -> a.getClassRef().getFullyQualifiedName()
          .equals("javax.validation.constraints.NotNull"))) {
        required.add(name);
      }

      addProperty(property, builder, internalFrom(property.getTypeRef()));
    }
    return build(builder, required);
  }

  /**
   * Creates a new specific builder object.
   *
   * @return a new builder object specific to the CRD generation version
   */
  public abstract B newBuilder();

  /**
   * Adds the specified property to the specified builder, calling {@link #internalFrom(TypeRef)}
   * to create the property schema.
   *
   * @param property the property to add to the currently being built schema
   * @param builder the builder representing the schema being built
   * @param schema the built schema for the property being added
   */
  public abstract void addProperty(Property property, B builder, T schema);

  /**
   * Finishes up the process by actually building the final JSON schema based on the provided
   * builder and a potentially empty list of names of fields which should be marked as required
   *
   * @param builder the builder used to build the final schema
   * @param required the list of names of required fields
   * @return the built JSON schema
   */
  public abstract T build(B builder, List<String> required);

  /**
   * Builds the specific JSON schema representing the structural schema for the specified property
   *
   * @param typeRef the type of the property which schema we want to build
   * @return the structural schema associated with the specified property
   */
  public T internalFrom(TypeRef typeRef) {
    // Note that ordering of the checks here is meaningful: we need to check for complex types last
    // in case some "complex" types are handled specifically
    if (typeRef.getDimensions() > 0 || TypeUtils.isCollection(typeRef)) { // Handle Collections & Arrays
      return collectionProperty(
        internalFrom(TypeAs.combine(TypeAs.UNWRAP_ARRAY_OF, TypeAs.UNWRAP_COLLECTION_OF).apply(typeRef)));
    } else if (TypeUtils.isOptional(typeRef)) { // Handle Optionals
      return internalFrom(TypeAs.UNWRAP_OPTIONAL_OF.apply(typeRef));
    } else {
      final String typeName = COMMON_MAPPINGS.get(typeRef);
      if(typeName != null) { // we have a type that we handle specifically
        if (INT_OR_STRING_MARKER.equals(typeName)) { // Handle int or string mapped types
          return mappedProperty(typeRef);
        } else {
          return singleProperty(typeName); // Handle Standard Types
        }
      } else {
        if (typeRef instanceof ClassRef) { // Handle complex types
          ClassRef classRef = (ClassRef) typeRef;
          TypeDef def = classRef.getDefinition();

          // check if we're dealing with an enum
          if(def.isEnum()) {
            final JsonNode[] enumValues = def.getProperties().stream()
              .map(Property::getName)
              .filter(n -> !n.startsWith("$"))
              .map(JsonNodeFactory.instance::textNode)
              .toArray(JsonNode[]::new);
            return enumProperty(enumValues);
          } else {
            return internalFrom(def);
          }

        }
        return null;
      }
    }
  }

  /**
   * Builds the schema for specifically handled property types (e.g. intOrString properties)
   *
   * @param ref the type of the specifically handled property
   * @return the property schema
   */
  protected abstract T mappedProperty(TypeRef ref);

  /**
   * Builds the schema for collection properties
   *
   * @param schema the schema for the extracted element type for this collection-like property
   * @return the schema for the collection-like property
   */
  protected abstract T collectionProperty(T schema);

  /**
   * Builds the schema for standard, simple (e.g. string) property types
   *
   * @param typeName the mapped name of the property type
   * @return the schema for the property
   */
  protected abstract T singleProperty(String typeName);

  protected abstract T enumProperty(JsonNode... enumValues);
}
