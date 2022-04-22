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

import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequest;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestBuilder;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestList;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class CredentialsRequestTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/cloudcredential.openshift.io/v1/namespaces/ns1/credentialsrequests/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewCredentialsRequest("test-get"))
        .once();

    // When
    CredentialsRequest credentialsRequest = client.credentialsRequests().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(credentialsRequest)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/cloudcredential.openshift.io/v1/namespaces/ns1/credentialsrequests")
        .andReturn(HttpURLConnection.HTTP_OK, new CredentialsRequestListBuilder()
            .addToItems(createNewCredentialsRequest("test-list"))
            .build())
        .once();

    // When
    CredentialsRequestList credentialsRequestList = client.credentialsRequests().inNamespace("ns1").list();

    // Then
    assertThat(credentialsRequestList).isNotNull();
    assertThat(credentialsRequestList.getItems()).hasSize(1);
    assertThat(credentialsRequestList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/cloudcredential.openshift.io/v1/namespaces/ns1/credentialsrequests/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewCredentialsRequest("test-delete"))
        .once();

    // When
    boolean isDeleted = client.credentialsRequests().inNamespace("ns1").withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private CredentialsRequest createNewCredentialsRequest(String name) {
    return new CredentialsRequestBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addToProviderSpec("apiVersion", "cloudcredential.openshift.io/v1")
        .addToProviderSpec("kind", "GCPProviderSpec")
        .addToProviderSpec("skipServiceCheck", "true")
        .withNewSecretRef()
        .withName("cloud-credential-operator-gcp-ro-creds")
        .withNamespace("openshift-cloud-credential-operator")
        .endSecretRef()
        .endSpec()
        .build();
  }
}
