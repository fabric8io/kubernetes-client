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

import io.fabric8.openshift.api.model.Identity;
import io.fabric8.openshift.api.model.IdentityBuilder;
import io.fabric8.openshift.api.model.IdentityList;
import io.fabric8.openshift.api.model.IdentityListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class IdentityTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/user.openshift.io/v1/identities/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIdentity("test-get"))
        .once();

    // When
    Identity identity = client.identities().withName("test-get").get();

    // Then
    assertThat(identity)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/user.openshift.io/v1/identities")
        .andReturn(HttpURLConnection.HTTP_OK, new IdentityListBuilder()
            .addToItems(createNewIdentity("test-list"))
            .build())
        .once();

    // When
    IdentityList identityList = client.identities().list();

    // Then
    assertThat(identityList).isNotNull();
    assertThat(identityList.getItems()).hasSize(1);
    assertThat(identityList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/user.openshift.io/v1/identities/developer:developer")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIdentity("developer:developer"))
        .once();

    // When
    boolean isDeleted = client.identities().withName("developer:developer").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Identity createNewIdentity(String name) {
    return new IdentityBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withProviderName("developer")
        .withProviderUserName("developer")
        .withNewUser()
        .withName("developer")
        .withUid("da8a03a4-be11-498e-8673-b2c072935e7b")
        .endUser()
        .build();
  }
}
