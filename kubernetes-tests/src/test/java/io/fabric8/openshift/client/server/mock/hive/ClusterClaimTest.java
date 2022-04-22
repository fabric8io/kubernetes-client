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

import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaim;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaimBuilder;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaimList;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaimListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterClaimTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() throws ParseException {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterclaims/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterClaim("test-get"))
        .once();

    // When
    ClusterClaim clusterClaim = client.hive().clusterClaims().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(clusterClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() throws ParseException {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterclaims")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterClaimListBuilder()
            .addToItems(createNewClusterClaim("test-list"))
            .build())
        .once();

    // When
    ClusterClaimList clusterClaimList = client.hive().clusterClaims().inNamespace("ns1").list();

    // Then
    assertThat(clusterClaimList).isNotNull();
    assertThat(clusterClaimList.getItems()).hasSize(1);
    assertThat(clusterClaimList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() throws ParseException {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterclaims/clusterclaim1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterClaim("clusterclaim1"))
        .once();

    // When
    boolean isDeleted = client.hive().clusterClaims().inNamespace("ns1").withName("clusterclaim1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterClaim createNewClusterClaim(String name) throws ParseException {
    return new ClusterClaimBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withClusterPoolName("openshift-46-aws-us-east-1")
        .withLifetime(Duration.parse("8h"))
        .withNamespace("openshift-46-aws-us-east-1-j495p")
        .endSpec()
        .build();
  }
}
