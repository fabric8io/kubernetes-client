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
import io.sundr.adapter.api.AdapterContext;
import io.sundr.adapter.api.Adapters;
import io.sundr.builder.TypedVisitor;
import io.sundr.model.*;
import io.sundr.model.functions.GetDefinition;
import io.sundr.model.repo.DefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Types {
  private Types() {
    throw new IllegalStateException("Utility class");
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(Types.class);
  private static final String NAMESPACED = Namespaced.class.getName();
  public static final String JAVA_LANG_VOID = "java.lang.Void";
  public static final AdapterContext REFLECTION_CONTEXT = AdapterContext.create(DefinitionRepository.getRepository());

  /**
   * Make sure the generation context is reset so that types can be properly introspected if classes have changed since the last generation round.
   */
  public static void resetGenerationContext() {
    DefinitionRepository.getRepository().clear();
  }

  public static TypeDef typeDefFrom(Class<?> clazz) {
    return unshallow(Adapters.adaptType(clazz, REFLECTION_CONTEXT));
  }

  public static TypeDef unshallow(TypeDef definition) {
    // resolve hierarchy
    final List<ClassRef> classRefs = new ArrayList<>(Types.projectSuperClasses(definition));
    // resolve properties
    final List<Property> properties = Types.projectProperties(definition);
    // re-create TypeDef with all the needed information
    return new TypeDef(definition.getKind(), definition.getPackageName(),
      definition.getName(), definition.getComments(), definition.getAnnotations(), classRefs,
      definition.getImplementsList(), definition.getParameters(), properties,
      definition.getConstructors(), definition.getMethods(), definition.getOuterTypeName(),
      definition.getInnerTypes(), definition.getModifiers(), definition.getAttributes());
  }

  public static TypeDef typeDefFrom(ClassRef classRef) {
    return unshallow(GetDefinition.of(classRef));
  }

  private static TypeDef projectDefinition(ClassRef ref) {
    List<TypeRef> arguments = ref.getArguments();
    TypeDef definition = GetDefinition.of(ref);
    if (arguments.isEmpty()) {
      return definition;
    }

    List<TypeParamDef> parameters = definition.getParameters();
    Map<String, TypeRef> mappings = new HashMap<>();
    for (int i = 0; i < arguments.size(); i++) {
      String name = parameters.get(i).getName();
      TypeRef typeRef = arguments.get(i);
      mappings.put(name, typeRef);
    }

    return new TypeDefBuilder(definition)
      .accept(mapClassRefArguments(mappings), mapGenericProperties(mappings))
      .build();
  }

  /**
   * Map generic properties to known {@link TypeRef} based on the specified mappings.
   * Example: Given a property {@code T size} and a map containing {@code T -> Integer} the final
   * property will be: {@code Integer type}.
   * @param mappings A map that maps class arguments names to types.
   * @return a visitors that performs the actual mapping.
   */
  private static TypedVisitor<PropertyBuilder> mapGenericProperties(Map<String, TypeRef> mappings) {
    return new TypedVisitor<PropertyBuilder>() {
      @Override
      public void visit(PropertyBuilder property) {
        TypeRef typeRef = property.buildTypeRef();
        if (typeRef instanceof TypeParamRef) {
          TypeParamRef typeParamRef = (TypeParamRef) typeRef;
          String key = typeParamRef.getName();
          TypeRef paramRef = mappings.get(key);
          if (paramRef != null) {
            property.withTypeRef(paramRef);
          }
        }
      }
    };
  }

  /**
   * Map arguments, of {@link ClassRef} instances to known {@link TypeRef} based on the specified mappings.
   * Example: Given a class reference to {@code Shape<T>} and a map containing {@code T -> Integer}
   * the final reference will be: {@code Shape<Integer> type}.
   * @param mappings A map that maps class arguments names to types.
   * @return a visitors that performs the actual mapping.
   */
  private static TypedVisitor<ClassRefBuilder> mapClassRefArguments(Map<String, TypeRef> mappings) {
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

  private static Set<ClassRef> projectSuperClasses(TypeDef definition) {
    List<ClassRef> extendsList = definition.getExtendsList();
    return extendsList.stream()
      .flatMap(s -> Stream.concat(Stream.of(s), projectDefinition(s).getExtendsList().stream()))
      .collect(Collectors.toSet());
  }

  /**
   * All non-static properties (including inherited).
   * @param typeDef        The type.
   * @return A list with all properties.
   */
  private static List<Property> projectProperties(TypeDef typeDef) {
    final String fqn = typeDef.getFullyQualifiedName();
    return Stream.concat(
        typeDef.getProperties().stream().filter(p -> {
          // enums have self-referential static properties for each enum case so we cannot ignore them
          if (typeDef.isEnum()) {
            final TypeRef typeRef = p.getTypeRef();
            if (typeRef instanceof ClassRef && fqn.equals(((ClassRef) typeRef).getFullyQualifiedName())) {
              // we're dealing with an enum case so keep it
              return true;
            }
          }
          // otherwise exclude all static properties
          return !p.isStatic();
        }),
        typeDef.getExtendsList().stream()
          .filter(e -> !e.getFullyQualifiedName().startsWith("java."))
          .flatMap(e -> projectProperties(projectDefinition(e))
            .stream()
            .filter(p -> filterCustomResourceProperties(e).test(p)))
      )

      .collect(Collectors.toList());
  }


  private static Predicate<Property> filterCustomResourceProperties(ClassRef ref) {
    return p -> !p.isStatic() &&
      (!ref.getFullyQualifiedName().equals(CUSTOM_RESOURCE_NAME) ||
        (p.getName().equals("spec") || p.getName().equals("status")));
  }


  public static void output(TypeDef def) {
    final StringBuilder builder = new StringBuilder(300);
    Types.describeType(def, "", new HashSet<>(), builder);
    LOGGER.debug("\n{}", builder);
  }

  public static void describeType(TypeDef def, String indent, Set<String> visited, StringBuilder builder) {
    if (visited.isEmpty()) {
      builder.append(indent).append(def.getFullyQualifiedName()).append("\n");
    }

    visited.add(def.getFullyQualifiedName());
    for (Property property : def.getProperties()) {
      TypeRef typeRef = property.getTypeRef();
      if (typeRef instanceof ClassRef) {
        final TypeDef typeDef = typeDefFrom((ClassRef) typeRef);
        builder.append(indent).append("\t").append(property).append(" - ClassRef [").append(typeDef.getKind()).append("]\n");
        if (!visited.contains(typeDef.getFullyQualifiedName())) {
          describeType(typeDef, indent + "\t", visited, builder);
        }
      } else {
        final String type;
        if (typeRef instanceof PrimitiveRef) {
          type = "PrimitiveRef";
        } else if (typeRef instanceof TypeParamRef) {
          type = "TypeParamRef";
        } else if (typeRef instanceof VoidRef) {
          type = "VoidRef";
        } else if (typeRef instanceof WildcardRef) {
          type = "WildcardRef";
        } else {
          type = "Unknown";
        }
        builder.append(indent).append("\t").append(property).append(" - ").append(type).append("\n");
      }
    }
    visited.remove(def.getFullyQualifiedName());
  }

  public static class SpecAndStatus {

    private static final SpecAndStatus UNRESOLVED = new SpecAndStatus(null, null);
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
    Optional<ClassRef> optionalCustomResourceRef = definition.getExtendsList().stream()
      .filter(s -> s.getFullyQualifiedName().equals(CUSTOM_RESOURCE_NAME)).findFirst();
    if (optionalCustomResourceRef.isPresent()) {
      ClassRef customResourceRef = optionalCustomResourceRef.get();
      List<TypeRef> arguments = customResourceRef.getArguments();
      if (arguments.size() == 2) {
        String specClassName = getClassFQNIfNotVoid(arguments.get(0));
        String statusClassName = getClassFQNIfNotVoid(arguments.get(1));
        return new SpecAndStatus(specClassName, statusClassName);
      }
    }
    return SpecAndStatus.UNRESOLVED;
  }

  public static boolean isNamespaced(TypeDef definition) {
    return isNamespaced(definition, new HashSet<>());
  }

  public static boolean isNamespaced(TypeDef definition, Set<TypeDef> visited) {
    if (definition.getFullyQualifiedName().equals(NAMESPACED)) {
      return true;
    }

    if (visited.contains(definition) || definition.getPackageName().startsWith("java.")) {
      return false;
    }

    Set<TypeDef> newVisited = new HashSet<>(visited);
    newVisited.add(definition);

    for (ClassRef i : definition.getImplementsList()) {
      if (isNamespaced(GetDefinition.of(i), newVisited)) {
        return true;
      }
    }

    for (ClassRef e : definition.getExtendsList()) {
      if (isNamespaced(GetDefinition.of(e), newVisited)) {
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
    return typeDef.getProperties().stream()
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
    return "status".equals(property.getName()) && getClassFQNIfNotVoid(property.getTypeRef()) != null;
  }

  private static String getClassFQNIfNotVoid(TypeRef typeRef) {
    if (!(typeRef instanceof ClassRef)) {
      return null;
    }
    String fullyQualifiedName = ((ClassRef) typeRef).getFullyQualifiedName();
    return JAVA_LANG_VOID.equals(fullyQualifiedName) ? null : fullyQualifiedName;
  }
}
