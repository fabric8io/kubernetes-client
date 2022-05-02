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
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomization;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationBuilder;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationList;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class SearchCustomizationTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searchcustomizations/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSearchCustomization("test-get"))
        .once();

    // When
    SearchCustomization searchCustomization = client.search().searchCustomizations().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(searchCustomization)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searchcustomizations")
        .andReturn(HttpURLConnection.HTTP_OK, new SearchCustomizationListBuilder()
            .addToItems(createNewSearchCustomization("test-list"))
            .build())
        .once();

    // When
    SearchCustomizationList searchCustomizationList = client.search().searchCustomizations().inNamespace("ns1").list();

    // Then
    assertThat(searchCustomizationList).isNotNull();
    assertThat(searchCustomizationList.getItems()).hasSize(1);
    assertThat(searchCustomizationList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/search.open-cluster-management.io/v1alpha1/namespaces/ns1/searchcustomizations/sample-sc")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSearchCustomization("sample-sc"))
        .once();

    // When
    boolean isDeleted = client.search().searchCustomizations().inNamespace("ns1").withName("sample-sc").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private SearchCustomization createNewSearchCustomization(String name) {
    return new SearchCustomizationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withPersistence(true)
        .endSpec()
        .build();
  }
}
