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
package io.fabric8.openshift.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectHelmChartRepositoryTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isNamespaceScoped() {
    assertThat(Namespaced.class.isAssignableFrom(ProjectHelmChartRepository.class)).isTrue();
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/test-v1beta1-projecthelmchartrepository.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ProjectHelmChartRepository projectHelmChartRepository = mapper.readValue(originalJson,
        ProjectHelmChartRepository.class);
    final String serializedJson = mapper.writeValueAsString(projectHelmChartRepository);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(projectHelmChartRepository)
        .hasFieldOrPropertyWithValue("metadata.name", "azure-sample-repo")
        .extracting(ProjectHelmChartRepository::getSpec)
        .hasFieldOrPropertyWithValue("name", "azure-sample-repo")
        .hasFieldOrPropertyWithValue("connectionConfig.url", "https://example.com/Azure-Samples/helm-charts/master/docs");
  }

  @Test
  void builder() {
    // Given
    ProjectHelmChartRepositoryBuilder ProjectHelmChartRepositoryBuilder = new ProjectHelmChartRepositoryBuilder()
        .withNewMetadata()
        .withName("azure-sample-repo")
        .endMetadata()
        .withNewSpec()
        .withName("azure-sample-repo")
        .withNewConnectionConfig()
        .withUrl("https://example.com/Azure-Samples/helm-charts/master/docs")
        .endConnectionConfig()
        .endSpec();

    // When
    ProjectHelmChartRepository projectHelmChartRepository = ProjectHelmChartRepositoryBuilder.build();

    // Then
    assertThat(projectHelmChartRepository)
        .hasFieldOrPropertyWithValue("metadata.name", "azure-sample-repo")
        .extracting(ProjectHelmChartRepository::getSpec)
        .hasFieldOrPropertyWithValue("name", "azure-sample-repo")
        .hasFieldOrPropertyWithValue("connectionConfig.url", "https://example.com/Azure-Samples/helm-charts/master/docs");
  }
}
