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
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsCluster;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterBuilder;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterList;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class GitOpsClusterTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1beta1/namespaces/ns1/gitopsclusters/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewGitOpsCluster("test-get"))
        .once();

    // When
    GitOpsCluster gitOpsCluster = client.apps().gitOpsClusters().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(gitOpsCluster)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1beta1/namespaces/ns1/gitopsclusters")
        .andReturn(HttpURLConnection.HTTP_OK, new GitOpsClusterListBuilder()
            .addToItems(createNewGitOpsCluster("test-list"))
            .build())
        .once();

    // When
    GitOpsClusterList gitOpsClusterList = client.apps().gitOpsClusters().inNamespace("ns1").list();

    // Then
    assertThat(gitOpsClusterList).isNotNull();
    assertThat(gitOpsClusterList.getItems()).hasSize(1);
    assertThat(gitOpsClusterList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apps.open-cluster-management.io/v1beta1/namespaces/ns1/gitopsclusters/sample-goc")
        .andReturn(HttpURLConnection.HTTP_OK, createNewGitOpsCluster("sample-goc"))
        .once();

    // When
    boolean isDeleted = client.apps().gitOpsClusters().inNamespace("ns1").withName("sample-goc").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private GitOpsCluster createNewGitOpsCluster(String name) {
    return new GitOpsClusterBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewArgoServer()
        .withCluster("notused")
        .withArgoNamespace("openshift-gitops")
        .endArgoServer()
        .withNewPlacementRef()
        .withApiVersion("cluster.open-cluster-management.io/v1alpha1")
        .withKind("Placement")
        .withName("all-openshift-clusters")
        .withNamespace("openshift-gitops")
        .endPlacementRef()
        .endSpec()
        .build();
  }
}
