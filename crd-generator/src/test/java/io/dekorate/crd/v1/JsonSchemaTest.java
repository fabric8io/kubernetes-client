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
 */
package io.dekorate.crd.v1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.dekorate.crd.example.person.Person;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.TypeDef;
import org.junit.jupiter.api.Test;

class JsonSchemaTest {

  @Test
  void shouldCreateJsonSchemaFromClass() {
    TypeDef person = ClassTo.TYPEDEF.apply(Person.class);
    JSONSchemaProps schema = JsonSchema.from(person);
    assertNotNull(schema);
  }

}
