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
import io.sundr.model.AnnotationRef;
import io.sundr.model.ClassRef;
import io.sundr.model.Property;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeDefBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static io.fabric8.crd.generator.AbstractJsonSchema.ANNOTATION_JSON_IGNORE;

public class AnnotatedPropertyPathDetector extends TypedVisitor<TypeDefBuilder> {

  protected static final String DOT = ".";
  protected static final String STATUS = ".status.";

  private final String prefix;
  private final String annotationName;
  private final List<Property> parents;
  private final AtomicReference<Optional<String>> reference;

  public AnnotatedPropertyPathDetector(String prefix, String annotationName) {
    this(prefix, annotationName, new ArrayList<>());
  }

  public AnnotatedPropertyPathDetector(String prefix, String annotationName, List<Property> parents) {
    this(prefix, annotationName, parents, new AtomicReference<>(Optional.empty()));
  }

  public AnnotatedPropertyPathDetector(String prefix, String annotationName, List<Property> parents,
      AtomicReference<Optional<String>> reference) {
    this.prefix = prefix;
    this.annotationName = annotationName;
    this.parents = parents;
    this.reference = reference;
  }

  private static boolean excludePropertyProcessing(Property p) {
    for (AnnotationRef annotation : p.getAnnotations()) {
      if (annotation.getClassRef().getFullyQualifiedName().equals(ANNOTATION_JSON_IGNORE)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void visit(TypeDefBuilder builder) {
    TypeDef type = builder.build();
    final List<Property> properties = type.getProperties();
    if (visitProperties(properties)) {
      return;
    }
    visitPropertiesClasses(properties);
  }

  private void visitPropertiesClasses(List<Property> properties) {
    for (Property p : properties) {
      if (!(p.getTypeRef() instanceof ClassRef)) {
        continue;
      }
      if (!parents.contains(p) && !excludePropertyProcessing(p)) {
        ClassRef classRef = (ClassRef) p.getTypeRef();
        TypeDef propertyType = Types.typeDefFrom(classRef);
        if (!propertyType.isEnum()) {
          List<Property> newParents = new ArrayList<>(parents);
          newParents.add(p);
          new TypeDefBuilder(propertyType)
              .accept(new AnnotatedPropertyPathDetector(prefix, annotationName, newParents, reference))
              .build();
        }
      }
    }
  }

  private boolean visitProperties(List<Property> properties) {
    for (Property p : properties) {
      if (parents.contains(p)) {
        continue;
      }

      List<Property> newParents = new ArrayList<>(parents);
      boolean match = false;
      for (AnnotationRef annotation : p.getAnnotations()) {
        match = annotation.getClassRef().getName().equals(annotationName);
        if (match) {
          newParents.add(p);
          reference.set(Optional.of(newParents.stream().map(Property::getName).collect(Collectors.joining(DOT, prefix, ""))));
          return true;
        }
      }
    }
    return false;
  }

  public Optional<String> getPath() {
    return reference.get();
  }
}
