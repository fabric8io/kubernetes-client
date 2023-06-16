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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.authentication.TokenRequest;
import io.fabric8.kubernetes.api.model.authentication.TokenRequestBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ServiceAccountResource;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.TestAsyncBody;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ServiceAccountOperationsImplTest {

  private TestStandardHttpClientFactory factory;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory();
    client = new KubernetesClientBuilder().withConfig(Config.empty()).withHttpClientFactory(factory).build();
  }

  @Test
  void tokenRequest_whenApiServerCallSuccessful_thenReturnTokenInTokenRequestStatus() throws URISyntaxException {
    // Given
    final String responseFromServer = "{\"kind\":\"TokenRequest\",\"apiVersion\":\"authentication.k8s.io/v1\"," +
        "\"status\":{\"token\":\"my.secret.token\",\"expirationTimestamp\":\"2023-06-14T18:42:15Z\"}}";
    factory.getInstances().iterator().next()
        .expect("/api/v1/namespaces/test/serviceaccounts/my-serviceaccount/token", (r, c) -> {
          final AsyncBody body = new TestAsyncBody();
          c.consume(Collections.singletonList(ByteBuffer.wrap((responseFromServer).getBytes(StandardCharsets.UTF_8))), body);
          return CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(200).withBody(body));
        });
    TokenRequest tokenRequest = new TokenRequestBuilder()
        .withNewSpec()
        .withAudiences("http://example.svc")
        .endSpec()
        .build();
    // When
    TokenRequest updatedTokenRequest = client.serviceAccounts().inNamespace("test").withName("my-serviceaccount")
        .tokenRequest(tokenRequest);
    // Then
    Assertions.assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("uri").asString()
        .endsWith("/api/v1/namespaces/test/serviceaccounts/my-serviceaccount/token");
    assertThat(updatedTokenRequest)
        .hasFieldOrPropertyWithValue("status.token", "my.secret.token")
        .hasFieldOrPropertyWithValue("status.expirationTimestamp", "2023-06-14T18:42:15Z");
  }

  @Test
  void tokenRequest_whenApiServerRequestFailure_thenThrowException() {
    // Given
    final String responseFromServer = "{\"kind\":\"Status\",\"apiVersion\":\"v1\",\"status\":\"Failure\",\"message\":\"serviceaccount my-serviceaccount not found\",\"reason\":\"NotFound\",\"details\":{\"name\":\"my-service-account\",\"kind\":\"serviceaccounts\"},\"code\":404}";
    factory.getInstances().iterator().next()
        .expect("/api/v1/namespaces/test/serviceaccounts/my-serviceaccount/token", (r, c) -> {
          final AsyncBody body = new TestAsyncBody();
          c.consume(Collections.singletonList(ByteBuffer.wrap((responseFromServer).getBytes(StandardCharsets.UTF_8))), body);
          return CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(404).withBody(body));
        });
    ServiceAccountResource serviceAccountResource = client.serviceAccounts()
        .inNamespace("test").withName("my-serviceaccount");
    // When - Then
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(serviceAccountResource::tokenRequest)
        .withMessageContaining("serviceaccount my-serviceaccount not found")
        .hasFieldOrPropertyWithValue("code", 404)
        .hasFieldOrPropertyWithValue("status.code", 404)
        .hasFieldOrPropertyWithValue("status.message", "serviceaccount my-serviceaccount not found")
        .hasFieldOrPropertyWithValue("status.reason", "NotFound");
  }
}
