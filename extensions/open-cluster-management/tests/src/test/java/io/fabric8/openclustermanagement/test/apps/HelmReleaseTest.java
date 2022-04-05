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
package io.fabric8.openclustermanagement.test.apps;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmRelease;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseBuilder;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class HelmReleaseTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/helmreleases/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHelmRelease("test-get"))
        .once();

    // When
    HelmRelease helmRelease = client.apps().helmReleases().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(helmRelease)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/helmreleases")
        .andReturn(HttpURLConnection.HTTP_OK, new HelmReleaseListBuilder()
            .addToItems(createNewHelmRelease("test-list"))
            .build())
        .once();

    // When
    HelmReleaseList HelmReleaseList = client.apps().helmReleases().inNamespace("ns1").list();

    // Then
    assertThat(HelmReleaseList).isNotNull();
    assertThat(HelmReleaseList.getItems()).hasSize(1);
    assertThat(HelmReleaseList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/helmreleases/sample-hr")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHelmRelease("sample-hr"))
        .once();

    // When
    boolean isDeleted = client.apps().helmReleases().inNamespace("ns1").withName("sample-hr").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private HelmRelease createNewHelmRelease(String name) {
    return new HelmReleaseBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewRepo()
        .withChartName("nginx-ingress")
        .withNewSource()
        .withNewHelmRepo()
        .withUrls("https://kubernetes-charts.storage.googleapis.com/nginx-ingress-1.26.0.tgz")
        .endHelmRepo()
        .withType("HelmRepo")
        .endSource()
        .withVersion("1.26.0")
        .endRepo()
        .build();
  }
}
