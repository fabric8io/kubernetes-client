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
package io.fabric8.openshift.client.server.mock.hive;

import io.fabric8.openshift.api.model.hive.v1.ClusterDeployment;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentBuilder;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentList;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterDeploymentTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterdeployments/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterDeployment("test-get"))
        .once();

    // When
    ClusterDeployment clusterDeployment = client.hive().clusterDeployments().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(clusterDeployment)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterdeployments")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterDeploymentListBuilder()
            .addToItems(createNewClusterDeployment("test-list"))
            .build())
        .once();

    // When
    ClusterDeploymentList clusterDeploymentList = client.hive().clusterDeployments().inNamespace("ns1").list();

    // Then
    assertThat(clusterDeploymentList).isNotNull();
    assertThat(clusterDeploymentList.getItems()).hasSize(1);
    assertThat(clusterDeploymentList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterdeployments/clusterdeployment1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterDeployment("clusterdeployment1"))
        .once();

    // When
    boolean isDeleted = client.hive().clusterDeployments().inNamespace("ns1").withName("clusterdeployment1").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterDeployment createNewClusterDeployment(String name) {
    return new ClusterDeploymentBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withPreserveOnDelete(false)
        .withClusterName("foo")
        .withBaseDomain("bar.baz")
        .withNewPlatform()
        .withNewAws()
        .withRegion("us-east-1")
        .withNewCredentialsSecretRef().withName("foo-aws-creds").endCredentialsSecretRef()
        .endAws()
        .endPlatform()
        .withNewProvisioning()
        .withNewInstallConfigSecretRef()
        .withName("foo-install-config")
        .endInstallConfigSecretRef()
        .withNewImageSetRef()
        .withName("clusterimageset-sample")
        .endImageSetRef()
        .endProvisioning()
        .withNewPullSecretRef()
        .withName("foo-pull-secret")
        .endPullSecretRef()
        .endSpec()
        .build();
  }
}
