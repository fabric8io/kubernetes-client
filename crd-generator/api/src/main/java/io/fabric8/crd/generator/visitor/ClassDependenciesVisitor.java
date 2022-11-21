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
package io.fabric8.crd.generator.visitor;

import io.fabric8.crd.generator.utils.Types;
import io.sundr.builder.TypedVisitor;
import io.sundr.model.ClassRef;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeDefBuilder;
import io.sundr.model.TypeRef;
import io.sundr.model.utils.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassDependenciesVisitor extends TypedVisitor<TypeDefBuilder> {
  private static final Map<String, Set<String>> traversedClasses = new HashMap<>();
  private static final Map<String, Set<String>> crdNameToCrClass = new HashMap<>();
  private final Set<String> classesForCR;
  private final Set<ClassRef> processed = new HashSet<>();

  public ClassDependenciesVisitor(String crClassName, String crdName) {
    // need to record all classes associated with the different versions of the CR (not the CRD spec)
    crdNameToCrClass.computeIfAbsent(crdName, k -> new HashSet<>()).add(crClassName);
    classesForCR = traversedClasses.computeIfAbsent(crClassName, k -> new HashSet<>());
  }

  @Override
  public void visit(TypeDefBuilder builder) {
    TypeDef type = builder.build();

    // finish quickly if we're ignoring the class or we already have processed it
    // note that we cannot simply check the traversed class set to know if a class has been processed because classes
    // are usually added to the traversed set before they're looked at in depth
    final String className = type.getFullyQualifiedName();
    if (ignore(className)) {
      return;
    }

    // process all references to see if they need to be added or not
    type.getReferences().forEach(c -> {
      final String fqn = c.getFullyQualifiedName();
      if (ignore(fqn)) {
        return;
      }

      // check if we're dealing with a collection type to extract parameter types if existing
      if (fqn.startsWith("java.util") && (Collections.isCollection(c) || Collections.IS_MAP.apply(c))) {
        c.getArguments().forEach(this::processTypeRef);
      } else {
        // otherwise, process all non-JDK classes that we haven't already processed
        if (!ignore(fqn) && classesForCR.add(fqn)) {
          // deal with generic arguments if present
          c.getArguments().forEach(this::processTypeRef);
        }
      }
    });

    // add classes from extends list
    type.getExtendsList().forEach(this::processTypeRef);
  }

  private boolean ignore(String className) {
    return (className.startsWith("java.") && !className.startsWith("java.util."))
        || className.startsWith("com.fasterxml.jackson") || className.startsWith("jdk.");
  }

  private void processTypeRef(TypeRef t) {
    if (t instanceof ClassRef) {
      ClassRef classRef = (ClassRef) t;
      // only process the class reference if we haven't already
      // note that the references are stored in the set including type arguments, so List<A> and List<B> are not the same
      if (processed.add(classRef)) {
        visit(new TypeDefBuilder(Types.typeDefFrom(classRef)));
      }
    }
  }

  public static Map<String, Set<String>> getTraversedClasses() {
    return traversedClasses;
  }

  public static Set<String> getDependentClasses(String crClassName) {
    return traversedClasses.get(crClassName);
  }

  public static Set<String> getDependentClassesFromCRDName(String crdName) {
    // retrieve all dependent classes that might affect any of the CR versions
    return crdNameToCrClass.get(crdName).stream()
        .flatMap(crClassName -> traversedClasses.get(crClassName).stream())
        .collect(Collectors.toSet());
  }
}
