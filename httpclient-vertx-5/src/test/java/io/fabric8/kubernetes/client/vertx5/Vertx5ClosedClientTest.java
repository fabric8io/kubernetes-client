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
package io.fabric8.kubernetes.client.vertx5;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class Vertx5ClosedClientTest {

  @Test
  @DisplayName("requests on a closed client fail fast with IllegalStateException(\"Client is closed\")")
  void request() {
    final HttpClient client = new Vertx5HttpClientFactory().newBuilder().build();
    client.close();
    assertThatIllegalStateException()
        .isThrownBy(() -> client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost:1/").build(), String.class))
        .withMessage("Client is closed");
  }

  @Test
  @DisplayName("WebSockets on a closed client fail fast with IllegalStateException(\"Client is closed\")")
  void webSocket() {
    final HttpClient client = new Vertx5HttpClientFactory().newBuilder().build();
    client.close();
    assertThatIllegalStateException()
        .isThrownBy(() -> client.newWebSocketBuilder().uri(URI.create("ws://localhost:1/"))
            .buildAsync(new WebSocket.Listener() {
            }))
        .withMessage("Client is closed");
  }
}
