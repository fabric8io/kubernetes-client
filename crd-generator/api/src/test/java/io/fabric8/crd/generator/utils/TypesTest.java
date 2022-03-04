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

import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.example.basic.BasicSpec;
import io.fabric8.crd.example.basic.BasicStatus;
import io.fabric8.crd.example.inherited.Child;
import io.fabric8.crd.example.joke.Joke;
import io.fabric8.crd.example.person.Person;
import io.fabric8.crd.example.webserver.WebServerWithStatusProperty;
import io.fabric8.crd.generator.utils.Types.SpecAndStatus;
import io.sundr.model.ClassRef;
import io.sundr.model.Property;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeRef;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypesTest {

  @Test
  void shouldFindStatusProperty() {
    TypeDef def = Types.typeDefFrom(WebServerWithStatusProperty.class);
    Optional<Property> p = Types.findStatusProperty(def);
    assertTrue(p.isPresent());

    def = Types.typeDefFrom(Basic.class);
    p = Types.findStatusProperty(def);
    assertTrue(p.isPresent());
  }

  @Test
  void shouldFindInheritedStatusProperty() {
    final TypeDef def = Types.typeDefFrom(Child.class);
    final Optional<Property> p = Types.findStatusProperty(def);
    assertTrue(p.isPresent());
    final Property property = p.get();
    final TypeRef typeRef = property.getTypeRef();
    assertTrue(typeRef instanceof ClassRef);
    final ClassRef classRef = (ClassRef) typeRef;
    final SpecAndStatus specAndStatus = Types.resolveSpecAndStatusTypes(def);
    assertEquals(specAndStatus.getStatusClassName(), classRef.getFullyQualifiedName());
  }

  @Test
  void shouldHaveAllTheExpectedProperties() {
    final TypeDef def = Types.typeDefFrom(Joke.class);
    final List<Property> properties = def.getProperties();
    assertEquals(7, properties.size());
  }

  @Test
  void findingSuperClassesShouldWork() {
    List<ClassRef> superClasses = Types.typeDefFrom(Basic.class).getExtendsList();
    assertTrue(superClasses.stream().anyMatch(c -> c.getName().contains("CustomResource")));
  }

  @Test
  void projectSuperClassesShouldProduceProperlyTypedClasses() {
    List<ClassRef> superClasses = Types.typeDefFrom(Basic.class).getExtendsList();
    assertEquals(2, superClasses.size());
    Optional<ClassRef> crOpt = superClasses.stream()
        .filter(c -> c.getName().contains("CustomResource")).findFirst();
    assertTrue(crOpt.isPresent());
    ClassRef crDef = crOpt.get();
    List<TypeRef> arguments = crDef.getArguments();
    assertEquals(2, arguments.size());
    assertTrue(arguments.get(0).toString().contains(BasicSpec.class.getSimpleName()));
    assertTrue(arguments.get(1).toString().contains(BasicStatus.class.getSimpleName()));
  }

  @Test
  void isNamespacedShouldWork() {
    TypeDef def = Types.typeDefFrom(Basic.class);
    assertTrue(Types.isNamespaced(def));
    def = Types.typeDefFrom(Person.class);
    assertFalse(Types.isNamespaced(def));
  }
}
