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
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProvider;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProviderBuilder;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProviderList;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProviderListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class SyncIdentityProviderTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/syncidentityproviders/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSyncIdentityProvider("test-get"))
        .once();

    // When
    SyncIdentityProvider syncIdentityProvider = client.hive().syncIdentityProviders().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(syncIdentityProvider)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/syncidentityproviders")
        .andReturn(HttpURLConnection.HTTP_OK, new SyncIdentityProviderListBuilder()
            .addToItems(createNewSyncIdentityProvider("test-list"))
            .build())
        .once();

    // When
    SyncIdentityProviderList syncIdentityProviderList = client.hive().syncIdentityProviders().inNamespace("ns1").list();

    // Then
    assertThat(syncIdentityProviderList).isNotNull();
    assertThat(syncIdentityProviderList.getItems()).hasSize(1);
    assertThat(syncIdentityProviderList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/syncidentityproviders/syncidentityprovider1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSyncIdentityProvider("syncidentityprovider1"))
        .once();

    // When
    boolean isDeleted = client.hive().syncIdentityProviders().inNamespace("ns1").withName("syncidentityprovider1").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private SyncIdentityProvider createNewSyncIdentityProvider(String name) {
    return new SyncIdentityProviderBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addNewClusterDeploymentRef("MyCluster")
        .addToIdentityProviders(new IdentityProviderBuilder()
            .withName("myprovider")
            .withType("GitHubIdentityProvider")
            .withGithub(new GitHubIdentityProviderBuilder()
                .withClientID("sample-client-id")
                .withNewClientSecret()
                .withName("foo")
                .endClientSecret()
                .withHostname("github.com")
                .build())
            .build())
        .endSpec()
        .build();
  }
}
