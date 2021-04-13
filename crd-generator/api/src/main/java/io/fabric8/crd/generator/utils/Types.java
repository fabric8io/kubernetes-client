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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Types {

  private static final TypeDef NAMESPACED = ClassTo.TYPEDEF.apply(Namespaced.class);
  private static final Map<TypeDef, List<Property>> propertiesCache = new ConcurrentHashMap<>(7);


  public static TypeDef projectDefinition(ClassRef ref) {
    List<TypeRef> arguments = ref.getArguments();
    TypeDef definition = ref.getDefinition();
    if (arguments.isEmpty()) {
      return definition;
    }

    Map<String, TypeRef> mappings = new HashMap<>();
    for (int i = 0; i < arguments.size(); i++) {
      String name = definition.getParameters().get(i).getName();
      TypeRef typeRef = ref.getArguments().get(i);
      mappings.put(name, typeRef);
    }

    return new TypeDefBuilder(definition)
      .accept(mapClassRefArguments(mappings), mapGenericProperties(mappings))
      .build();
  }

  /**
   * Map generic properties to known {@link TypeRef} based on the specified mappings.
   * Example: Given a property `T size` and a map containing `T -> Integer` the final property will be: `Integer type`.
   * @param mappings A map that maps class arguments names to types.
   * @return a visitors that performs the actual mapping.
   */
  public static TypedVisitor<PropertyBuilder> mapGenericProperties(Map<String, TypeRef> mappings) {
      return new TypedVisitor<PropertyBuilder>() {
        @Override
        public void visit(PropertyBuilder property) {
          TypeRef typeRef = property.buildTypeRef();
          if (typeRef instanceof TypeParamRef) {
            TypeParamRef typeParamRef = (TypeParamRef) typeRef;
            String key = typeParamRef.getName();
            if (mappings.containsKey(key)) {
              TypeRef paramRef = mappings.get(key);
              if (paramRef != null) {
                property.withTypeRef(paramRef);
              }
            }
          }
        }
      };
  }

  /**
   * Map arguments, of {@link ClassRef} instances to known {@link TypeRef} based on the specified mappings.
   * Example: Given a class reference to `Shape<T>` and a map containing `T -> Integer` the final reference will be: `Shape<Integer> type`.
   * @param mappings A map that maps class arguments names to types.
   * @return a visitors that performs the actual mapping.
   */
  public static TypedVisitor<ClassRefBuilder> mapClassRefArguments(Map<String, TypeRef> mappings) {
      return new TypedVisitor<ClassRefBuilder>() {
        @Override
        public void visit(ClassRefBuilder c) {
          List<TypeRef> arguments = new ArrayList<>();
          for (TypeRef arg : c.buildArguments()) {
            TypeRef mappedRef = arg;
            if (arg instanceof TypeParamRef) {
              TypeParamRef typeParamRef = (TypeParamRef) arg;
              TypeRef mapping = mappings.get(typeParamRef.getName());
              if (mapping != null) {
                mappedRef = mapping;
              }
            }
            arguments.add(mappedRef);
          }
          c.withArguments(arguments);
        }
      };
  }
 
  public static Set<ClassRef> projectSuperClasses(TypeDef definition) {
    List<ClassRef> extendsList = definition.getExtendsList();
    return extendsList.stream()
      .flatMap(s -> Stream.concat(Stream.of(s), projectDefinition(s).getExtendsList().stream()))
      .collect(Collectors.toSet());
  }

  /**
   * All properties (including inherited).
   * @param typeDef        The type.
   * @return A list with all properties.
   */
  public static List<Property> projectProperties(TypeDef typeDef) {
    List<Property> properties = propertiesCache.get(typeDef);
    if(properties != null) {
      return properties;
    }

    properties = Stream.concat(typeDef.getProperties().stream(),
                               typeDef.getExtendsList()
                               .stream()
                               .peek(e -> System.out.println("Projected class:" + e))
                               .flatMap(e -> projectDefinition(e)
                                        .getProperties()
                                        .stream()
                                        .peek(p -> System.out.println("\t" + p + " filtered:" + filterCustomResourceProperties(e).test(p)))
                                        .filter(p -> filterCustomResourceProperties(e).test(p))))
                               .collect(Collectors.toList());
    propertiesCache.put(typeDef, properties);
    return properties;
  }


  public static Predicate<Property> filterCustomResourceProperties(ClassRef ref) {
    return p -> !ref.getFullyQualifiedName().equals(CUSTOM_RESOURCE_NAME) || (p.getName().equals("spec") || p.getName().equals("status"));
  }

  public static class SpecAndStatus {
    private static SpecAndStatus UNRESOLVED = new SpecAndStatus(null, null);
    private final String specClassName;
    private final String statusClassName;
    private final boolean unreliable;

    public SpecAndStatus(String specClassName, String statusClassName) {
      this.specClassName = specClassName;
      this.statusClassName = statusClassName;
      this.unreliable = specClassName == null || statusClassName == null;
    }

    public String getSpecClassName() {
      return specClassName;
    }

    public String getStatusClassName() {
      return statusClassName;
    }

    public boolean isUnreliable() {
      return unreliable;
    }
  }
  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();
  public static SpecAndStatus resolveSpecAndStatusTypes(TypeDef definition) {
    Set<ClassRef> superClasses = Types.projectSuperClasses(definition);

    Optional<ClassRef> optionalCustomResourceRef = superClasses.stream()
      .filter(s -> s.getFullyQualifiedName().equals(CUSTOM_RESOURCE_NAME)).findFirst();
    if (optionalCustomResourceRef.isPresent()) {
      ClassRef customResourceRef = optionalCustomResourceRef.get();
      if (customResourceRef.getArguments().size() == 2) {
        TypeRef specType = customResourceRef.getArguments().get(0);
        String specClassName =
          specType instanceof ClassRef ? ((ClassRef) specType).getFullyQualifiedName() : null;
        TypeRef statusType = customResourceRef.getArguments().get(1);
        String statusClassName =
          statusType instanceof ClassRef ? ((ClassRef) statusType).getFullyQualifiedName() : null;
        return new SpecAndStatus(specClassName, statusClassName);
      }
    }
    return SpecAndStatus.UNRESOLVED;
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
    return projectProperties(typeDef).stream()
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
