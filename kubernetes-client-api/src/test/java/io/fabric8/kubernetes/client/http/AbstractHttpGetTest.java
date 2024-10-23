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

import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.InputStream;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public abstract class AbstractHttpGetTest {

  private static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  protected abstract Class<? extends Exception> getConnectionFailedExceptionType();

  @Test
  @DisplayName("Should send a GET request with body")
  public void get() throws Exception {
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      client
          .sendAsync(client.newHttpRequestBuilder().uri(server.url("/get")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest())
        .returns("GET", RecordedRequest::getMethod)
        .returns("/get", RecordedRequest::getPath)
        .returns("HTTP/1.1", RecordedRequest::getHttpVersion);
  }

  @Test
  @DisplayName("Unsupported response type throws exception")
  public void unsupportedResponseType() {
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final var httpRequest = client.newHttpRequestBuilder().uri(server.url("/get")).build();
      assertThatIllegalArgumentException()
          .isThrownBy(() -> client.sendAsync(httpRequest, Boolean.class))
          .withMessageStartingWith("Unsupported response type: ")
          .withMessageContaining("Boolean");
    }
  }

  @DisplayName("Supported response body types")
  @ParameterizedTest(name = "{index}: {0}")
  @ValueSource(classes = { String.class, byte[].class, Reader.class, InputStream.class })
  void supportedResponseBodyTypes(Class<?> type) throws Exception {
    // Given
    final var length = 16384;
    final var value = new String(new byte[length]);
    server.expect().withPath("/type").andReturn(200, value).always();
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final var request = client.newHttpRequestBuilder().uri(server.url("/type")).build();
      final var result = client.sendAsync(request, type).get(10, TimeUnit.SECONDS);
      assertThat(result)
          .returns(String.valueOf(length), r -> r.header("Content-Length"))
          .satisfies(r -> assertThat(r.body()).isInstanceOf(type))
          .satisfies(r -> assertThat(r.bodyString()).isEqualTo(value));
    }
  }
}
