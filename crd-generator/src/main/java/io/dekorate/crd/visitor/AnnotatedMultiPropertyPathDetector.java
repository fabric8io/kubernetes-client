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

package io.dekorate.crd.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.dekorate.crd.util.Types;
import io.sundr.builder.TypedVisitor;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;

public class AnnotatedMultiPropertyPathDetector extends TypedVisitor<TypeDefBuilder> {

  protected static final String DOT = ".";
  protected static final String STATUS = ".status.";

  private final String prefix;
  private final String annotationName;
  private final List<Property> parents;
  private final Map<String, Property> properties;

  public AnnotatedMultiPropertyPathDetector(String prefix, String annotationName) {
    this(prefix, annotationName, new ArrayList<>());
  }

  public AnnotatedMultiPropertyPathDetector(String prefix, String annotationName, List<Property> parents) {
    this(prefix, annotationName, parents, new HashMap<>());
  }

  public AnnotatedMultiPropertyPathDetector(String prefix, String annotationName, List<Property> parents, Map<String, Property> properties) {
    this.prefix = prefix;
    this.annotationName = annotationName;
    this.parents = parents;
    this.properties = properties;
  }

  @Override
  public void visit(TypeDefBuilder builder) {
    TypeDef type = builder.build();
    for (Property p : Types.allProperties(type)) {
        if (parents.contains(p)) {
          continue;
        }

        List<Property> newParents = new ArrayList<>(parents);
        boolean match = p.getAnnotations().stream().anyMatch(a -> a.getClassRef().getName().equals(annotationName));
        if (match) {
          newParents.add(p);
          properties.put(newParents.stream().map(Property::getName).collect(Collectors.joining(DOT, prefix, "")), p);
        }
    }

    Types.allProperties(type).stream().filter(p -> p.getTypeRef() instanceof ClassRef).forEach(p -> {
        if (!parents.contains(p)) {
          ClassRef classRef = (ClassRef) p.getTypeRef();
          TypeDef propertyType = classRef.getDefinition();
          List<Property> newParents = new ArrayList<>(parents);
          newParents.add(p);
          new TypeDefBuilder(propertyType)
            .accept(new AnnotatedMultiPropertyPathDetector(prefix, annotationName, newParents, properties))
            .build();
        }
      });
  }

  public Set<String> getPaths() {
    return properties.keySet();
  }

  public Map<String, Property> getProperties() {
    return properties;
  }
}
