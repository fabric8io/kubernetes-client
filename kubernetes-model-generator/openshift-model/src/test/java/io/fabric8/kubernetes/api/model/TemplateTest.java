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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateTest {

  private static ObjectMapper objectMapper;

  @BeforeAll
  static void beforeAll() {
    objectMapper = new ObjectMapper();
  }

  @Test
  @DisplayName("getObjects, with objects member field null, should return empty List")
  void getObjectsWithNullFieldShouldReturnEmptyList() {
    // Given
    final Template template = new Template();
    template.setObjects(null);
    // When
    final List<HasMetadata> result = template.getObjects();
    // Then
    assertThat(result).isNotNull().isEmpty();
  }

  @Test
  @DisplayName("getObjects, with objects, should return sorted List")
  void getObjectsWithObjectsShouldReturnSortedList() {
    // Given
    final Template template = new TemplateBuilder()
      .addToObjects(new SecretBuilder().build())
      .addToObjects(new ServiceBuilder().build())
      .addToObjects(new ProjectBuilder().build())
      .build();
    // When
    final List<HasMetadata> result = template.getObjects();
    // Then
    assertThat(result)
      .extracting("class")
      .containsExactly(Project.class, Secret.class, Service.class);
  }

  @Test
  @DisplayName("serialize from deserialized, with null objects, should serialize")
  void serializeFromDeserializedWithNullObjectsShouldSerialize() throws IOException {
    // Given
    final Template template = objectMapper.readValue(
      TemplateTest.class.getResource("/template-with-null-objects.json").openStream(), Template.class);
    // When
    final String result = objectMapper.writeValueAsString(template);
    // Then
    assertThat(result).contains("\"objects\":[]");
  }
}
