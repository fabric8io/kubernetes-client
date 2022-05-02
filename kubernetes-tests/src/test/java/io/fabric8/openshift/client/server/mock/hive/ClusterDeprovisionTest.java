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

import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovision;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionBuilder;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionList;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterDeprovisionTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterdeprovisions/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterDeprovision("test-get"))
        .once();

    // When
    ClusterDeprovision clusterDeprovision = client.hive().clusterDeprovisions().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(clusterDeprovision)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterdeprovisions")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterDeprovisionListBuilder()
            .addToItems(createNewClusterDeprovision("test-list"))
            .build())
        .once();

    // When
    ClusterDeprovisionList clusterDeprovisionList = client.hive().clusterDeprovisions().inNamespace("ns1").list();

    // Then
    assertThat(clusterDeprovisionList).isNotNull();
    assertThat(clusterDeprovisionList.getItems()).hasSize(1);
    assertThat(clusterDeprovisionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterdeprovisions/clusterdeprovision1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterDeprovision("clusterdeprovision1"))
        .once();

    // When
    boolean isDeleted = client.hive().clusterDeprovisions().inNamespace("ns1").withName("clusterdeprovision1").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterDeprovision createNewClusterDeprovision(String name) {
    return new ClusterDeprovisionBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withInfraID("cluster-infra-id")
        .withNewPlatform()
        .withNewAws()
        .withNewCredentialsSecretRef().withName("cluster-aws-creds").endCredentialsSecretRef()
        .withRegion("us-east-1")
        .endAws()
        .endPlatform()
        .endSpec()
        .build();
  }
}
