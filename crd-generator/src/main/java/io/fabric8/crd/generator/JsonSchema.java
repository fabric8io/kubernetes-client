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

public abstract class JsonSchema<T, B> {

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

  public static final Map<TypeRef, String> JAVA_TYPE_TO_SCHEMA_TYPE = new HashMap<>();

  static {
    JAVA_TYPE_TO_SCHEMA_TYPE.put(STRING_REF, "string");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(DATE_REF, "string");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(INT_REF, "integer");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(P_INT_REF, "integer");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(LONG_REF, "number");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(P_LONG_REF, "number");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(DOUBLE_REF, "number");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(P_DOUBLE_REF, "number");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(BOOLEAN_REF, "boolean");
    JAVA_TYPE_TO_SCHEMA_TYPE.put(P_BOOLEAN_REF, "boolean");
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
    } else if (JAVA_TYPE_TO_SCHEMA_TYPE.containsKey(typeRef)) {
      return mappedProperty(typeRef);
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

  protected abstract T mappedProperty(TypeRef ref);

  protected abstract T collectionProperty(T schema);

  protected abstract T singleProperty(String typeName);

}
