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

import io.fabric8.openshift.api.model.UserOAuthAccessToken;
import io.fabric8.openshift.api.model.UserOAuthAccessTokenBuilder;
import io.fabric8.openshift.api.model.UserOAuthAccessTokenList;
import io.fabric8.openshift.api.model.UserOAuthAccessTokenListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class UserOAuthAccessTokenTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/oauth.openshift.io/v1/useroauthaccesstokens/sha256~mTZgKITxcHpoKJ5FSwLSeu0UNOQ0CO8bEMv0eLsANmU")
        .andReturn(HttpURLConnection.HTTP_OK,
            createNewUserOAuthAccessToken("sha256~mTZgKITxcHpoKJ5FSwLSeu0UNOQ0CO8bEMv0eLsANmU"))
        .once();

    // When
    UserOAuthAccessToken userOAuthAccessToken = client.userOAuthAccessTokens()
        .withName("sha256~mTZgKITxcHpoKJ5FSwLSeu0UNOQ0CO8bEMv0eLsANmU").get();

    // Then
    assertThat(userOAuthAccessToken)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "sha256~mTZgKITxcHpoKJ5FSwLSeu0UNOQ0CO8bEMv0eLsANmU");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/oauth.openshift.io/v1/useroauthaccesstokens")
        .andReturn(HttpURLConnection.HTTP_OK, new UserOAuthAccessTokenListBuilder()
            .addToItems(createNewUserOAuthAccessToken("sha256~mTZgKITxcHpoKJ5FSwLSeu0UNOQ0CO8bEMv0eLsANmU"))
            .build())
        .once();

    // When
    UserOAuthAccessTokenList userOAuthAccessTokenList = client.userOAuthAccessTokens().list();

    // Then
    assertThat(userOAuthAccessTokenList).isNotNull();
    assertThat(userOAuthAccessTokenList.getItems()).hasSize(1);
    assertThat(userOAuthAccessTokenList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "sha256~mTZgKITxcHpoKJ5FSwLSeu0UNOQ0CO8bEMv0eLsANmU");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/oauth.openshift.io/v1/useroauthaccesstokens/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewUserOAuthAccessToken("cluster"))
        .once();

    // When
    boolean isDeleted = client.userOAuthAccessTokens().withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private UserOAuthAccessToken createNewUserOAuthAccessToken(String name) {
    return new UserOAuthAccessTokenBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withUserName("user1")
        .withUserUID("uid")
        .addToScopes("user:check-access")
        .withRedirectURI("https://oauth-openshift.apps-crc.testing/oauth/token/implicit")
        .withClientName("openshift-challenging-client")
        .withExpiresIn(86400L)
        .withAuthorizeToken("sha256~oKyk5Wcnar7JeO4-pLdnyGt-IIpmhNJA7-2testing-test")
        .build();
  }
}
