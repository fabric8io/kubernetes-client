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
import io.sundr.codegen.model.ClassRefBuilder;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.PropertyBuilder;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeParamDef;
import io.sundr.codegen.model.TypeParamRef;
import io.sundr.codegen.model.TypeRef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Types {

  private static final TypeDef NAMESPACED = ClassTo.TYPEDEF.apply(Namespaced.class);
  private static final TypeDef CUSTOM_RESOURCE = ClassTo.TYPEDEF.apply(CustomResource.class);
  private static final Map<TypeDef, List<Property>> propertiesCache = new ConcurrentHashMap<>(7);


  /**
   * All properties (including inherited).
   * @param typeDef   The type.
   * @return A list with all properties.
   */
  public static List<Property> allProperties(TypeDef typeDef) {
    List<Property> properties = propertiesCache.get(typeDef);
    if(properties != null) {
      return properties;
    }

    properties = unrollHierarchy(typeDef)
      .stream()
      .flatMap(h -> h.getProperties().stream())
      .collect(Collectors.toList());
    propertiesCache.put(typeDef, properties);
    return properties;
  }

  /**
   * Unrolls the hierarchy of a specified type.
   * @param typeDef       The specified type.
   * @return A set that contains the complete type hierarchy (including the specified type).
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
    final List<TypeRef> arguments = ref.getArguments();
    final TypeDef definition = ref.getDefinition();
    final List<TypeParamDef> parameters = definition.getParameters();
    // only apply type arguments if their number matches the definition
    if (arguments.size() == parameters.size()) {
      for (int i = 0; i < arguments.size(); i++) {
        bounds.put(parameters.get(i).getName(), arguments.get(i));
      }

      return new TypeDefBuilder(definition).accept(new TypedVisitor<PropertyBuilder>() {
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
    return new TypeDefBuilder(definition).build();
  }


  /**
   * Gets the definition of the {@link ClassRef} but projects type arguments to the definition.
   */
  public static TypeDef projectDefinition(ClassRef ref) {
    List<TypeRef> arguments = ref.getArguments();
    TypeDef definition = ref.getDefinition();
    if (arguments.isEmpty()) {
      return definition;
    }

    Map<String, TypeRef> genericMap = new HashMap<>();
    for (int i = 0; i < arguments.size(); i++) {
      String name = definition.getParameters().get(i).getName();
      TypeRef typeRef = ref.getArguments().get(i);
      genericMap.put(name, typeRef);
    }

    definition.getParameters().stream()
      .collect(Collectors.toMap(TypeParamDef::getName, TypeParamDef::getBounds));
    return new TypeDefBuilder(definition)
      .accept(new TypedVisitor<ClassRefBuilder>() {
        @Override
        public void visit(ClassRefBuilder c) {
          List<TypeRef> arguments = new ArrayList<>();
          for (TypeRef arg : c.buildArguments()) {
            TypeRef mappedRef = arg;
            if (arg instanceof TypeParamRef) {
              TypeParamRef typeParamRef = (TypeParamRef) arg;
              TypeRef mapping = genericMap.get(typeParamRef.getName());
              if (mapping != null) {
                mappedRef = mapping;
              }
            }
            arguments.add(mappedRef);
          }
          c.withArguments(arguments);
        }
      }).build();
  }
  
  public static Set<ClassRef> getSuperClasses(TypeDef definition) {
    List<ClassRef> extendsList = definition.getExtendsList();
    return extendsList.stream()
      .flatMap(s -> Stream.concat(Stream.of(s), projectDefinition(s).getExtendsList().stream()))
      .collect(Collectors.toSet());
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
