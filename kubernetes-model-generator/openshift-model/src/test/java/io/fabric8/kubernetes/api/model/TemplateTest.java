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

import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateTest {

  @Test
  @DisplayName("getObjects, with objects, should return List")
  void getObjectsWithObjectsShouldReturnList() {
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
        .containsExactly(Secret.class, Service.class, Project.class);
  }

}
