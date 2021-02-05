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
package io.fabric8.crd.generator.utils;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.sundr.builder.TypedVisitor;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.PropertyBuilder;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeParamRef;
import io.sundr.codegen.model.TypeRef;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Types {

  private static final TypeDef NAMESPACED = ClassTo.TYPEDEF.apply(Namespaced.class);
  private static final TypeDef CUSTOM_RESOURCE = ClassTo.TYPEDEF.apply(CustomResource.class);


  /**
   * All properties (including inherited).
   * @param typeDef   The type.
   * @return A list with all properties.
   */
  public static List<Property> allProperties(TypeDef typeDef) {
    return unrollHierarchy(typeDef)
      .stream()
      .flatMap(h -> h.getProperties().stream())
      .collect(Collectors.toList());
  }

  /**
   * Unrolls the hierararchy of a specified type.
   * @param typeDef       The specified type.
   * @return A set that contains all the hierarching (including the specified type).
   */
  public static Set<TypeDef> unrollHierarchy(TypeDef typeDef) {
    if (typeDef.getPackageName() != null && (typeDef.getPackageName().startsWith("java.") ||
      typeDef.getPackageName().startsWith("javax.") ||
      typeDef.getPackageName().startsWith("com.sun.") ||
      typeDef.getPackageName().startsWith("com.ibm."))) {
      return new HashSet<>();
    }
    if (typeDef.getFullyQualifiedName().equals(CUSTOM_RESOURCE.getFullyQualifiedName())) {
      //We need a version of custom resource stripped from unneeded properties.
      return Stream.of(new TypeDefBuilder(CUSTOM_RESOURCE)
        .withProperties(typeDef.getProperties()
          .stream()
          .filter(p -> p.getName().equals("spec") || p.getName().equals("status"))
          .collect(Collectors.toList())).build()).collect(Collectors.toSet());
    }
    Set<TypeDef> hierarchy = new HashSet<>();
    hierarchy.add(typeDef);
    hierarchy.addAll(typeDef.getExtendsList().stream()
      .flatMap(s -> unrollHierarchy(applyTypeArguments(s)).stream()).collect(Collectors.toSet()));
    return hierarchy;
  }

  /**
   * Apply type arguments on all generic properties of a {@link ClassRef}.
   *
   * @param ref the {@link ClassRef} on which we want to apply the type arguments
   * @return the result of the application
   */
  public static TypeDef applyTypeArguments(ClassRef ref) {
    Map<String, TypeRef> bounds = new HashMap<>();
    for (int i = 0; i < ref.getArguments().size(); i++) {
      bounds.put(ref.getDefinition().getParameters().get(i).getName(), ref.getArguments().get(i));
    }

    return new TypeDefBuilder(ref.getDefinition()).accept(new TypedVisitor<PropertyBuilder>() {
      @Override
      public void visit(PropertyBuilder property) {
        TypeRef typeRef = property.buildTypeRef();
        if (typeRef instanceof TypeParamRef) {
          TypeParamRef typeParamRef = (TypeParamRef) typeRef;
          String key = typeParamRef.getName();
          if (bounds.containsKey(key)) {
            TypeRef paramRef = bounds.get(key);
            if (paramRef != null) {
              property.withTypeRef(paramRef);
            }
          }
        }
      }
    }).build();
  }


  public static boolean isNamespaced(TypeDef definition) {
    return isNamespaced(definition, new HashSet<TypeDef>());
  }

  public static boolean isNamespaced(TypeDef definition, Set<TypeDef> visited) {
    if (definition.getFullyQualifiedName().equals(NAMESPACED.getFullyQualifiedName())) {
      return true;
    }

    if (visited.contains(definition) || definition.getPackageName().startsWith("java.")) {
      return false;
    }

    Set<TypeDef> newVisited = new HashSet<>(visited);
    newVisited.add(definition);

    for (ClassRef i : definition.getImplementsList()) {
      if (isNamespaced(i.getDefinition(), newVisited)) {
        return true;
      }
    }

    for (ClassRef e : definition.getExtendsList()) {
      if (isNamespaced(e.getDefinition(), newVisited)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Finds the status property. The method look up for a status property.
   *
   * @param typeDef the type whose status property we want to find
   * @return the an optional property.
   */
  public static Optional<Property> findStatusProperty(TypeDef typeDef) {
    return allProperties(typeDef).stream()
      .filter(Types::isStatusProperty)
      .findFirst();
  }


  /**
   * Returns true if the specified property corresponds to status.
   * A property qualifies as `status` if it is called `status`.
   * @param property the property we want to check
   * @return {@code true} if named {@code status}, {@code false} otherwise
   */
  public static boolean isStatusProperty(Property property) {
    return "status".equals(property.getName());
  }
}
