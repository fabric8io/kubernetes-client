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
import io.sundr.model.Property;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeDefBuilder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static io.fabric8.crd.generator.AbstractJsonSchema.ANNOTATION_JSON_IGNORE;

public class AnnotatedMultiPropertyPathDetector extends TypedVisitor<TypeDefBuilder> {

  protected static final String DOT = ".";
  protected static final String STATUS = ".status.";

  private final String prefix;
  private final String annotationName;
  private final List<Property> parents;
  private final Map<String, Property> properties;
  private final Deque<Runnable> toRun;

  public AnnotatedMultiPropertyPathDetector(String prefix, String annotationName) {
    this(prefix, annotationName, new ArrayList<>(), new HashMap<>(), new ArrayDeque<>());
  }

  public AnnotatedMultiPropertyPathDetector(String prefix, String annotationName, List<Property> parents,
      Map<String, Property> properties, Deque<Runnable> toRun) {
    this.prefix = prefix;
    this.annotationName = annotationName;
    this.parents = parents;
    this.properties = properties;
    this.toRun = toRun;
  }

  private boolean excludePropertyProcessing(Property p) {
    return p.getAnnotations().stream()
        .anyMatch(ann -> ann.getClassRef().getFullyQualifiedName().equals(ANNOTATION_JSON_IGNORE));
  }

  @Override
  public void visit(TypeDefBuilder builder) {
    TypeDef type = builder.build();
    final List<Property> props = type.getProperties();
    for (Property p : props) {
      if (parents.contains(p)) {
        continue;
      }

      List<Property> newParents = new ArrayList<>(parents);
      boolean match = p.getAnnotations().stream().anyMatch(a -> a.getClassRef().getName().equals(annotationName));
      if (match) {
        newParents.add(p);
        this.properties
            .put(newParents.stream().map(Property::getName).collect(Collectors.joining(DOT, prefix, "")), p);
      }
    }

    props.stream().filter(p -> p.getTypeRef() instanceof ClassRef).forEach(p -> {
      if (!parents.contains(p) && !excludePropertyProcessing(p)) {
        ClassRef classRef = (ClassRef) p.getTypeRef();
        TypeDef propertyType = Types.typeDefFrom(classRef);
        if (!propertyType.isEnum() && !classRef.getPackageName().startsWith("java.")) {
          List<Property> newParents = new ArrayList<>(parents);
          newParents.add(p);
          toRun.add(() -> new TypeDefBuilder(propertyType)
              .accept(new AnnotatedMultiPropertyPathDetector(prefix, annotationName, newParents, properties, toRun)));
        }
      }
    });

    if (parents.isEmpty()) {
      while (!toRun.isEmpty()) {
        toRun.pop().run();
      }
    }
  }

  public Set<String> getPaths() {
    return properties.keySet();
  }

  public Map<String, Property> getProperties() {
    return properties;
  }
}
