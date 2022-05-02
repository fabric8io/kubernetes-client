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

import io.fabric8.openshift.api.model.hive.v1.ClusterPool;
import io.fabric8.openshift.api.model.hive.v1.ClusterPoolBuilder;
import io.fabric8.openshift.api.model.hive.v1.ClusterPoolList;
import io.fabric8.openshift.api.model.hive.v1.ClusterPoolListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterPoolTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterpools/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterPool("test-get"))
        .once();

    // When
    ClusterPool clusterPool = client.hive().clusterPools().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(clusterPool)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterpools")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterPoolListBuilder()
            .addToItems(createNewClusterPool("test-list"))
            .build())
        .once();

    // When
    ClusterPoolList clusterPoolList = client.hive().clusterPools().inNamespace("ns1").list();

    // Then
    assertThat(clusterPoolList).isNotNull();
    assertThat(clusterPoolList.getItems()).hasSize(1);
    assertThat(clusterPoolList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterpools/clusterpool1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterPool("clusterpool1"))
        .once();

    // When
    boolean isDeleted = client.hive().clusterPools().inNamespace("ns1").withName("clusterpool1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterPool createNewClusterPool(String name) {
    return new ClusterPoolBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withBaseDomain("new-installer.openshift.com")
        .withNewImageSetRef()
        .withName("openshift-4-6")
        .endImageSetRef()
        .withNewPlatform()
        .withNewAws()
        .withNewCredentialsSecretRef()
        .withName("hive-team-aws-creds")
        .endCredentialsSecretRef()
        .withRegion("us-east-1")
        .endAws()
        .endPlatform()
        .withNewPullSecretRef()
        .withName("hive-team-pull-secret")
        .endPullSecretRef()
        .withRunningCount(1)
        .withSize(3)
        .endSpec()
        .build();
  }
}
