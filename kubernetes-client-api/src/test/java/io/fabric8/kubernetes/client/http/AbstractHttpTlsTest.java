/*
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
package io.fabric8.kubernetes.client.http;

import io.fabric8.kubernetes.client.internal.SSLUtils;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.TrustManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public abstract class AbstractHttpTlsTest {

  private static DefaultMockServer server;
  private static TrustManager[] trustManagers;

  @BeforeAll
  static void beforeAll() throws Exception {
    server = new DefaultMockServer(true);
    server.start();
    trustManagers = SSLUtils.trustManagers(null, server.getSelfSignedCertificate().certificatePath(), false, null, null);
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("HTTP-over-TLS completes the request trusting the supplied certificate")
  void secureHttpGetWithTrustedCert() throws Exception {
    try (HttpClient client = getHttpClientFactory().newBuilder().sslContext(null, trustManagers).build()) {
      server.expect().withPath("/secure-get")
          .andReturn(200, "ok")
          .once();
      HttpResponse<String> response = client
          .sendAsync(client.newHttpRequestBuilder().uri(server.url("secure-get")).build(), String.class)
          .get(10, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("ok");
    }
  }

  @Test
  @DisplayName("Untrusted cert on HTTP path fails fast with default retry policy instead of draining ~19s backoff")
  void untrustedCertFailsFastWithDefaultRetryPolicy() throws Exception {
    TrustManager[] untrustedManagers = SSLUtils.trustManagers(null, null, false, null, null);
    try (HttpClient client = getHttpClientFactory().newBuilder().sslContext(null, untrustedManagers).build()) {
      long start = System.nanoTime();
      assertThatThrownBy(() -> client
          .sendAsync(client.newHttpRequestBuilder().uri(server.url("secure-get")).build(), String.class)
          .get(10, TimeUnit.SECONDS))
          .isInstanceOf(ExecutionException.class)
          .cause()
          .satisfies(cause -> {
            assertThat(StandardHttpClient.isTerminalTlsTrustFailure(cause))
                .as("cause tree should contain a TLS trust failure: %s", cause)
                .isTrue();
          });
      long elapsedMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
      assertThat(elapsedMs)
          .as("should fail fast, not drain the ~19s default backoff schedule")
          .isLessThan(10_000);
    }
  }
}
