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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractHttpBodylessMethodTest {

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

  @DisplayName("Bodyless request preserves the requested method instead of defaulting to GET")
  @ParameterizedTest(name = "Bodyless {0} is sent as {0}, not GET")
  @ValueSource(strings = { "DELETE", "POST", "PUT", "PATCH" })
  void bodylessRequestKeepsMethod(String method) throws Exception {
    // Given
    final String path = "/bodyless-" + method.toLowerCase(Locale.ROOT);
    expectMethod(method, path);
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      client.sendAsync(client.newHttpRequestBuilder()
          .uri(server.url(path))
          .method(method, "application/json", null)
          .build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest())
        .returns(method, RecordedRequest::getMethod)
        .returns(path, RecordedRequest::getPath);
  }

  private static void expectMethod(String method, String path) {
    switch (method) {
      case "DELETE":
        server.expect().delete().withPath(path).andReturn(200, "").once();
        break;
      case "POST":
        server.expect().post().withPath(path).andReturn(200, "").once();
        break;
      case "PUT":
        server.expect().put().withPath(path).andReturn(200, "").once();
        break;
      case "PATCH":
        server.expect().patch().withPath(path).andReturn(200, "").once();
        break;
      default:
        throw new IllegalArgumentException("Unsupported method: " + method);
    }
  }
}
