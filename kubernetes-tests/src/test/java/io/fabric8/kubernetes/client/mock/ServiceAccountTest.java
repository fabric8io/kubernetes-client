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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.api.model.authentication.TokenRequest;
import io.fabric8.kubernetes.api.model.authentication.TokenRequestBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class ServiceAccountTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void create() {
    // Given
    ServiceAccount serviceAccount = createNewServiceAccount("sa-create");
    server.expect().post()
        .withPath("/api/v1/namespaces/test/serviceaccounts")
        .andReturn(HTTP_CREATED, serviceAccount)
        .once();

    // When
    serviceAccount = client.serviceAccounts().resource(serviceAccount).create();

    // Then
    assertThat(serviceAccount)
        .hasFieldOrPropertyWithValue("metadata.name", "sa-create");
  }

  @Test
  void delete() {
    // Given
    ServiceAccount serviceAccount = createNewServiceAccount("sa-delete");
    server.expect().delete()
        .withPath("/api/v1/namespaces/test/serviceaccounts/sa-delete")
        .andReturn(HTTP_OK, serviceAccount)
        .once();

    // When
    List<StatusDetails> statusDetails = client.serviceAccounts().resource(serviceAccount).delete();

    // Then
    assertThat(statusDetails).hasSize(1);
  }

  @Test
  void tokenRequest() {
    // Given
    TokenRequest tokenRequest = new TokenRequestBuilder()
        .withNewMetadata()
        .withName("sa-token-request")
        .endMetadata()
        .withNewSpec()
        .withAudiences("https://kubernetes.default.svc")
        .withExpirationSeconds(3600L)
        .withNewBoundObjectRef()
        .withKind("Pod")
        .withApiVersion("v1")
        .withName("pod-foo-346acf")
        .endBoundObjectRef()
        .endSpec()
        .build();
    server.expect().post()
        .withPath("/api/v1/namespaces/test/serviceaccounts/sa-token-request/token")
        .andReturn(HTTP_CREATED, new TokenRequestBuilder(tokenRequest)
            .withNewStatus()
            .withToken("my.secret.token")
            .endStatus()
            .build())
        .once();

    // When
    tokenRequest = client.serviceAccounts().withName("sa-token-request").tokenRequest(tokenRequest);

    // Then
    assertThat(tokenRequest)
        .hasFieldOrPropertyWithValue("status.token", "my.secret.token");
  }

  private ServiceAccount createNewServiceAccount(String name) {
    return new ServiceAccountBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .build();
  }
}
