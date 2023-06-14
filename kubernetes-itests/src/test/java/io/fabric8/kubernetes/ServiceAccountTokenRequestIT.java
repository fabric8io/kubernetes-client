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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.authentication.TokenRequest;
import io.fabric8.kubernetes.api.model.authentication.TokenRequestBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@LoadKubernetesManifests("/serviceaccounttokenrequest-it.yml")
@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 20)
class ServiceAccountTokenRequestIT {
  KubernetesClient client;

  @Test
  void tokenRequest_whenNoArgsProvided_thenCreateToken() {
    // Given
    // When
    TokenRequest tokenRequest = client.serviceAccounts().withName("sa-token-request-no-args").tokenRequest();

    // Then
    assertThat(tokenRequest).isNotNull();
    assertThat(tokenRequest.getStatus()).isNotNull();
    assertThat(tokenRequest.getStatus().getToken()).isNotEmpty();
  }

  @Test
  void tokenRequest_whenArgsProvided_thenCreateToken() {
    // Given
    TokenRequest tokenRequest = new TokenRequestBuilder()
        .withNewSpec()
        .addToAudiences("https://kubernetes.default.svc")
        .withExpirationSeconds(3600L)
        .endSpec()
        .build();

    // When
    tokenRequest = client.serviceAccounts().withName("sa-token-request-args").tokenRequest(tokenRequest);

    // Then
    assertThat(tokenRequest).isNotNull();
    assertThat(tokenRequest.getStatus()).isNotNull();
    assertThat(tokenRequest.getStatus().getToken()).isNotEmpty();
  }
}
