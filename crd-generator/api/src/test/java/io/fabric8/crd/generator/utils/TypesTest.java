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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.example.basic.BasicSpec;
import io.fabric8.crd.example.basic.BasicStatus;
import io.fabric8.crd.example.person.Person;
import io.fabric8.crd.example.webserver.WebServerWithStatusProperty;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeParamDef;
import io.sundr.codegen.model.TypeParamRef;
import io.sundr.codegen.model.TypeRef;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class TypesTest {

  @Test
  public void shouldFindStatusProperty() {
    TypeDef def = ClassTo.TYPEDEF.apply(WebServerWithStatusProperty.class);
    Optional<Property> p = Types.findStatusProperty(def);
    assertTrue(p.isPresent());

    def = ClassTo.TYPEDEF.apply(Basic.class);
    p = Types.findStatusProperty(def);
    assertTrue(p.isPresent());
  }
  
  @Test
  public void findingSuperClassesShouldWork() {
    TypeDef def = ClassTo.TYPEDEF.apply(Basic.class);
    Set<ClassRef> superClasses = Types.projectSuperClasses(def);
    assertTrue(superClasses.stream().anyMatch(c -> c.getName().contains("CustomResource")));
  }

  @Test
  public void unrollHierarchyShouldProduceProperlyTypedClasses() {
    TypeDef def = ClassTo.TYPEDEF.apply(Basic.class);
    Set<ClassRef> superClasses = Types.projectSuperClasses(def);
    System.out.println("Defs:" + superClasses);
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
  public void isNamespacedShouldWork() {
    TypeDef def = ClassTo.TYPEDEF.apply(Basic.class);
    assertTrue(Types.isNamespaced(def));
    def = ClassTo.TYPEDEF.apply(Person.class);
    assertFalse(Types.isNamespaced(def));
  }
}
