/*
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
import io.fabric8.openclustermanagement.api.model.search.v1alpha1.Search;
import io.fabric8.openclustermanagement.api.model.search.v1alpha1.SearchBuilder;
import io.fabric8.openclustermanagement.api.model.search.v1alpha1.SearchList;
import io.fabric8.openclustermanagement.api.model.search.v1alpha1.SearchListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class SearchTest {
  OpenClusterManagementClient client;
  KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searches/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSearch("test-get"))
        .once();

    // When
    Search search = client.search().searches().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(search)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searches")
        .andReturn(HttpURLConnection.HTTP_OK, new SearchListBuilder()
            .addToItems(createNewSearch("test-list"))
            .build())
        .once();

    // When
    SearchList searchList = client.search().searches().inNamespace("ns1").list();

    // Then
    assertThat(searchList).isNotNull();
    assertThat(searchList.getItems()).hasSize(1);
    assertThat(searchList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searches/sample-sc")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSearch("sample-sc"))
        .once();

    // When
    boolean isDeleted = client.search().searches().inNamespace("ns1").withName("sample-sc").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Search createNewSearch(String name) {
    return new SearchBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withImagePullPolicy("Always")
        .endSpec()
        .build();
  }
}
