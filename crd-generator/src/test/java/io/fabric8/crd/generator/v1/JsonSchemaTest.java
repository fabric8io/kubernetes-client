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
package io.fabric8.crd.generator.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.crd.example.person.Person;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.TypeDef;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class JsonSchemaTest {

  @Test
  void shouldCreateJsonSchemaFromClass() {
    TypeDef person = ClassTo.TYPEDEF.apply(Person.class);
    JSONSchemaProps schema = JsonSchema.from(person);
    assertNotNull(schema);
    final Map<String, JSONSchemaProps> properties = schema.getProperties();
    assertEquals(7, properties.size());
    final List<String> personTypes = properties.get("type").getEnum().stream().map(JsonNode::asText)
      .collect(Collectors.toList());
    assertEquals(2, personTypes.size());
    assertTrue(personTypes.contains("crazy"));
    assertTrue(personTypes.contains("crazier"));
    final Map<String, JSONSchemaProps> addressProperties = properties.get("addresses").getItems()
      .getSchema().getProperties();
    assertEquals(5, addressProperties.size());
    final List<String> addressTypes = addressProperties.get("type").getEnum().stream()
      .map(JsonNode::asText)
      .collect(Collectors.toList());
    assertEquals(2, addressTypes.size());
    assertTrue(addressTypes.contains("home"));
    assertTrue(addressTypes.contains("work"));
  }

}
