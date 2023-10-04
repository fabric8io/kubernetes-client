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

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.ProjectHelmChartRepository;
import io.fabric8.openshift.api.model.ProjectHelmChartRepositoryBuilder;
import io.fabric8.openshift.api.model.ProjectHelmChartRepositoryList;
import io.fabric8.openshift.api.model.ProjectHelmChartRepositoryListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class ProjectHelmChartRepositoryTest {
  KubernetesMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ProjectHelmChartRepository projectHelmChartRepository = getProjectHelmChartRepository();
    server.expect().post()
        .withPath("/apis/helm.openshift.io/v1beta1/namespaces/ns1/projecthelmchartrepositories")
        .andReturn(HttpURLConnection.HTTP_OK, projectHelmChartRepository)
        .once();

    // When
    projectHelmChartRepository = client.projectHelmChartRepositories().inNamespace("ns1").resource(projectHelmChartRepository)
        .create();

    // Then
    assertNotNull(projectHelmChartRepository);
    assertEquals("foo", projectHelmChartRepository.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/helm.openshift.io/v1beta1/namespaces/ns1/projecthelmchartrepositories/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getProjectHelmChartRepository())
        .once();

    // When
    ProjectHelmChartRepository projectHelmChartRepository = client.projectHelmChartRepositories().inNamespace("ns1")
        .withName("foo").get();

    // Then
    assertNotNull(projectHelmChartRepository);
    assertEquals("foo", projectHelmChartRepository.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/helm.openshift.io/v1beta1/namespaces/ns1/projecthelmchartrepositories")
        .andReturn(HttpURLConnection.HTTP_OK,
            new ProjectHelmChartRepositoryListBuilder().withItems(getProjectHelmChartRepository()).build())
        .once();

    // When
    ProjectHelmChartRepositoryList projectHelmChartRepositoryList = client.projectHelmChartRepositories().inNamespace("ns1")
        .list();

    // Then
    assertNotNull(projectHelmChartRepositoryList);
    assertNotNull(projectHelmChartRepositoryList.getItems());
    assertEquals(1, projectHelmChartRepositoryList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/helm.openshift.io/v1beta1/namespaces/ns1/projecthelmchartrepositories/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getProjectHelmChartRepository())
        .once();

    // When
    boolean deleted = client.projectHelmChartRepositories().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ProjectHelmChartRepository getProjectHelmChartRepository() {
    return new ProjectHelmChartRepositoryBuilder()
        .withNewMetadata()
        .withName("foo")
        .endMetadata()
        .withNewSpec()
        .withName("azure-sample-repo")
        .withNewConnectionConfig()
        .withUrl("https://example.com/Azure-Samples/helm-charts/master/docs")
        .endConnectionConfig()
        .endSpec()
        .build();
  }
}
