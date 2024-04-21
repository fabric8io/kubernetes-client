/*
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

import io.fabric8.crd.example.inherited.Child;
import io.fabric8.crd.generator.utils.Types.SpecAndStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypesTest {

  @Test
  void shouldFindInheritedStatusProperty() {
    final SpecAndStatus specAndStatus = Types.resolveSpecAndStatusTypes(Child.class);
    assertEquals("io.fabric8.crd.example.inherited.ChildStatus", specAndStatus.getStatusClassName());
    assertEquals("io.fabric8.crd.example.inherited.ChildSpec", specAndStatus.getSpecClassName());
  }

}
