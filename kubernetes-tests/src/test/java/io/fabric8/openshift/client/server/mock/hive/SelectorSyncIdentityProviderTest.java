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

import io.fabric8.openshift.api.model.config.v1.GitHubIdentityProviderBuilder;
import io.fabric8.openshift.api.model.config.v1.IdentityProviderBuilder;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProvider;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProviderBuilder;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProviderList;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProviderListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class SelectorSyncIdentityProviderTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/selectorsyncidentityproviders/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSelectorSyncIdentityProvider("test-get"))
        .once();

    // When
    SelectorSyncIdentityProvider selectorSyncIdentityProvider = client.hive().selectorSyncIdentityProviders()
        .withName("test-get").get();

    // Then
    assertThat(selectorSyncIdentityProvider)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/selectorsyncidentityproviders")
        .andReturn(HttpURLConnection.HTTP_OK, new SelectorSyncIdentityProviderListBuilder()
            .addToItems(createNewSelectorSyncIdentityProvider("test-list"))
            .build())
        .once();

    // When
    SelectorSyncIdentityProviderList selectorSyncIdentityProviderList = client.hive().selectorSyncIdentityProviders().list();

    // Then
    assertThat(selectorSyncIdentityProviderList).isNotNull();
    assertThat(selectorSyncIdentityProviderList.getItems()).hasSize(1);
    assertThat(selectorSyncIdentityProviderList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/selectorsyncidentityproviders/selectorsyncidentityprovider1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSelectorSyncIdentityProvider("selectorsyncidentityprovider1"))
        .once();

    // When
    boolean isDeleted = client.hive().selectorSyncIdentityProviders().withName("selectorsyncidentityprovider1").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private SelectorSyncIdentityProvider createNewSelectorSyncIdentityProvider(String name) {
    return new SelectorSyncIdentityProviderBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addToIdentityProviders(new IdentityProviderBuilder()
            .withName("my_allow_provider")
            .withType("GitHubIdentityProvider")
            .withGithub(new GitHubIdentityProviderBuilder()
                .withClientID("sample-client-id")
                .withNewClientSecret()
                .withName("foo")
                .endClientSecret()
                .withHostname("github.com")
                .build())
            .build())
        .withNewClusterDeploymentSelector()
        .addToMatchLabels("cluster-group", "abutcher")
        .endClusterDeploymentSelector()
        .endSpec()
        .build();
  }
}
