/**
 * Copyright 2018 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.dekorate.crd.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.lang.model.element.TypeElement;

import io.dekorate.crd.annotation.Status;
import io.dekorate.crd.config.CustomResourceConfig;
import io.sundr.builder.Predicate;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.AnnotationRefBuilder;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;
import io.sundr.codegen.utils.TypeUtils;

public class Types {

  /**
   * Finds the status type.
   * The method will use the `statusClassName` if present and then fallback to annotations.
   */
  public static Optional<TypeRef> findStatusType(CustomResourceConfig config, TypeDef typeDef) {
    if (!CustomResourceConfig.AUTODETECT.equals(config.getStatusClassName())) {
      System.out.println("Status explicitly specified: " + config.getStatusClassName());
      try {
        TypeElement statusElement = CodegenContext.getContext().getElements().getTypeElement(config.getStatusClassName());
        return Optional.of(ElementTo.TYPEDEF.apply(statusElement).toReference());
      } catch (Exception e) {
        //ignore
      }

      try {
        return Optional.of(ClassTo.TYPEDEF.apply(Class.forName(config.getStatusClassName())).toReference());
      } catch (ClassNotFoundException e) {
        throw new IllegalStateException("Class " + config.getStatusClassName() + " could not be found neither in the compilation unit, nor in the classpath!", e);
      }
    }

    System.out.println("Searching for status");
    return findStatusProperty(config, typeDef).map(Property::getTypeRef);
  }

  /**
   * Finds the status property.
   * The method look up for a status property.
   * @return the an optional property.
   */
  public static Optional<Property> findStatusProperty(CustomResourceConfig config, TypeDef typeDef) {
    return TypeUtils.allProperties(typeDef).stream()
      .filter(Types::isStatusProperty)
      .findFirst();
  }
 

  /**
   * Returns true if the specified property corresponds to status.
   * A property qualifies as `status` if annotated with the `@Status` annotation or is just called `status`.
   * @return true if named status or annotated with @Status, false otherwise
   */
  public static boolean isStatusProperty(Property property)  {
    return "status".equals(property.getName()) || property.getAnnotations().stream().anyMatch(a -> Status.class.getName().equals(a.getClassRef().getFullyQualifiedName()));
  }

  private static final Predicate<AnnotationRefBuilder> predicate = new Predicate<AnnotationRefBuilder>() {
        @Override
        public boolean apply(AnnotationRefBuilder ref) {
         return ref.getClassRef().getName().equals("SpecReplicas");
        }
    };
 
  public void getSpecReplicasPath(TypeDef def, List<String> path, List<String> visited) {
    for (Property p : def.getProperties()) {
      if (p.getAnnotations().stream().anyMatch(a -> a.getClassRef().getName().equals("SpecReplicas"))) {
        
      }
    }
  }
}
