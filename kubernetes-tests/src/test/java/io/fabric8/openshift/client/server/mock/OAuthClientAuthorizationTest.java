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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.OAuthClientAuthorization;
import io.fabric8.openshift.api.model.OAuthClientAuthorizationBuilder;
import io.fabric8.openshift.api.model.OAuthClientAuthorizationList;
import io.fabric8.openshift.api.model.OAuthClientAuthorizationListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class OAuthClientAuthorizationTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/oauth.openshift.io/v1/oauthclientauthorizations/user1:test-oauth-client")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOAuthClientAuthorization("user1:test-oauth-client"))
        .once();

    // When
    OAuthClientAuthorization oAuthClientAuthorization = client.oAuthClientAuthorizations().withName("user1:test-oauth-client")
        .get();

    // Then
    assertThat(oAuthClientAuthorization)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "user1:test-oauth-client");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/oauth.openshift.io/v1/oauthclientauthorizations")
        .andReturn(HttpURLConnection.HTTP_OK, new OAuthClientAuthorizationListBuilder()
            .addToItems(createNewOAuthClientAuthorization("user1:test-oauth-client"))
            .build())
        .once();

    // When
    OAuthClientAuthorizationList oAuthClientAuthorizationList = client.oAuthClientAuthorizations().list();

    // Then
    assertThat(oAuthClientAuthorizationList).isNotNull();
    assertThat(oAuthClientAuthorizationList.getItems()).hasSize(1);
    assertThat(oAuthClientAuthorizationList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "user1:test-oauth-client");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/oauth.openshift.io/v1/oauthclientauthorizations/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOAuthClientAuthorization("test-delete"))
        .once();

    // When
    boolean isDeleted = client.oAuthClientAuthorizations().withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private OAuthClientAuthorization createNewOAuthClientAuthorization(String name) {
    return new OAuthClientAuthorizationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withUserName("developer")
        .withUserUID("uidda8a03a4-be11-498e-8673-b2c072935e7b")
        .withClientName("openshift-challenging-client")
        .addToScopes("user:check-access")
        .build();
  }
}
