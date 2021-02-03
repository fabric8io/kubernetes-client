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

import io.fabric8.crd.generator.utils.Types;
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

public abstract class JsonSchema<T, B> {

  private static final TypeDef BOOLEAN = ClassTo.TYPEDEF.apply(Boolean.class);
  private static final TypeDef STRING = ClassTo.TYPEDEF.apply(String.class);
  private static final TypeDef INT = ClassTo.TYPEDEF.apply(Integer.class);
  private static final TypeDef LONG = ClassTo.TYPEDEF.apply(Long.class);
  private static final TypeDef DOUBLE = ClassTo.TYPEDEF.apply(Double.class);
  private static final TypeDef DATE = ClassTo.TYPEDEF.apply(Date.class);

  private static final TypeRef BOOLEAN_REF = BOOLEAN.toReference();
  private static final TypeRef STRING_REF = STRING.toReference();
  private static final TypeRef INT_REF = INT.toReference();
  private static final TypeRef LONG_REF = LONG.toReference();
  private static final TypeRef DOUBLE_REF = DOUBLE.toReference();
  private static final TypeRef DATE_REF = DATE.toReference();

  private static final TypeRef P_INT_REF = new PrimitiveRefBuilder().withName("int").build();
  private static final TypeRef P_LONG_REF = new PrimitiveRefBuilder().withName("long").build();
  private static final TypeRef P_DOUBLE_REF = new PrimitiveRefBuilder().withName("double").build();
  private static final TypeRef P_BOOLEAN_REF = new PrimitiveRefBuilder().withName("boolean")
    .build();

  public static final Map<TypeRef, String> TYPE_MAP = new HashMap<>();

  static {
    TYPE_MAP.put(STRING_REF, "string");
    TYPE_MAP.put(DATE_REF, "string");
    TYPE_MAP.put(INT_REF, "integer");
    TYPE_MAP.put(P_INT_REF, "integer");
    TYPE_MAP.put(LONG_REF, "number");
    TYPE_MAP.put(P_LONG_REF, "number");
    TYPE_MAP.put(DOUBLE_REF, "number");
    TYPE_MAP.put(P_DOUBLE_REF, "number");
    TYPE_MAP.put(BOOLEAN_REF, "boolean");
    TYPE_MAP.put(P_BOOLEAN_REF, "boolean");
  }

  /**
   * Creates the JSON schema for the particular {@link TypeDef}.
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

  public abstract B newBuilder();

  public abstract void addProperty(Property property, B builder, T schema);

  public abstract T build(B builder, List<String> required);

  public T internalFrom(TypeRef typeRef) {
    //1. Handle Collections and Arrays
    if (typeRef.getDimensions() > 0 || TypeUtils.isCollection(typeRef)) {
      return collectionProperty(
        internalFrom(TypeAs.combine(TypeAs.UNWRAP_ARRAY_OF, TypeAs.UNWRAP_COLLECTION_OF).apply(typeRef)));
      //2. Handle Standard Types
    } else if (TYPE_MAP.containsKey(typeRef)) {
      return singleProperty(TYPE_MAP.get(typeRef));
      //3. Handle Optionals
    } else if (TypeUtils.isOptional(typeRef)) {
      return internalFrom(TypeAs.UNWRAP_OPTIONAL_OF.apply(typeRef));
      //4. Handle complex types
    } else if (typeRef instanceof ClassRef) {
      ClassRef classRef = (ClassRef) typeRef;
      TypeDef def = classRef.getDefinition();
      return internalFrom(def);
    }
    return null;
  }

  protected abstract T collectionProperty(T schema);

  protected abstract T singleProperty(String typeName);
}
