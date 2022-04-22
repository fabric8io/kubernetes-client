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
package io.fabric8.openclustermanagement.test.search;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperator;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorBuilder;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorList;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class SearchOperatorTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searchoperators/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSearchOperator("test-get"))
        .once();

    // When
    SearchOperator searchOperator = client.search().searchOperators().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(searchOperator)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searchoperators")
        .andReturn(HttpURLConnection.HTTP_OK, new SearchOperatorListBuilder()
            .addToItems(createNewSearchOperator("test-list"))
            .build())
        .once();

    // When
    SearchOperatorList searchOperatorList = client.search().searchOperators().inNamespace("ns1").list();

    // Then
    assertThat(searchOperatorList).isNotNull();
    assertThat(searchOperatorList.getItems()).hasSize(1);
    assertThat(searchOperatorList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searchoperators/sample-searchoperator")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSearchOperator("sample-searchoperator"))
        .once();

    // When
    boolean isDeleted = client.search().searchOperators().inNamespace("ns1").withName("sample-searchoperator").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private SearchOperator createNewSearchOperator(String name) {
    return new SearchOperatorBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withPullpolicy("Always")
        .withNewRedisgraphResource()
        .withLimitMemory("1Gi")
        .withRequestCpu("25m")
        .withRequestMemory("64Mi")
        .endRedisgraphResource()
        .withPullpolicy("Always")
        .withPullsecret("multiclusterhub-operator-pull-secret")
        .withNewSearchimageoverrides()
        .withRedisgraphTls("quay.io/open-cluster-management/redisgraph-tls:2.4.0-e2ec66da43abff85a7fcf56f22ed5849e0589069")
        .endSearchimageoverrides()
        .endSpec()
        .build();
  }
}
