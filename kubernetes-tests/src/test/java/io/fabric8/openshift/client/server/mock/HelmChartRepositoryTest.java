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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.HelmChartRepository;
import io.fabric8.openshift.api.model.HelmChartRepositoryBuilder;
import io.fabric8.openshift.api.model.HelmChartRepositoryList;
import io.fabric8.openshift.api.model.HelmChartRepositoryListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class HelmChartRepositoryTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/helm.openshift.io/v1beta1/helmchartrepositories/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHelmChartRepository("test-get"))
        .once();

    // When
    HelmChartRepository helmChartRepository = client.helmChartRepositories().withName("test-get").get();

    // Then
    assertThat(helmChartRepository)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/helm.openshift.io/v1beta1/helmchartrepositories")
        .andReturn(HttpURLConnection.HTTP_OK, new HelmChartRepositoryListBuilder()
            .addToItems(createNewHelmChartRepository("test-list"))
            .build())
        .once();

    // When
    HelmChartRepositoryList helmChartRepositoryList = client.helmChartRepositories().list();

    // Then
    assertThat(helmChartRepositoryList).isNotNull();
    assertThat(helmChartRepositoryList.getItems()).hasSize(1);
    assertThat(helmChartRepositoryList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/helm.openshift.io/v1beta1/helmchartrepositories/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHelmChartRepository("test-delete"))
        .once();

    // When
    boolean isDeleted = client.helmChartRepositories().withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private HelmChartRepository createNewHelmChartRepository(String name) {
    return new HelmChartRepositoryBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withName("azure-sample-repo")
        .withNewConnectionConfig()
        .withUrl("https://raw.githubusercontent.com/Azure-Samples/helm-charts/master/docs")
        .endConnectionConfig()
        .endSpec()
        .build();
  }
}
