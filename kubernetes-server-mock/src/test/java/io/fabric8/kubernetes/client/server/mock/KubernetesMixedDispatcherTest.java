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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.internal.SimpleRequest;
import io.fabric8.mockwebserver.internal.SimpleResponse;
import okhttp3.Headers;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesMixedDispatcherTest {

  private static final Headers EMPTY_HEADERS = new Headers.Builder().build();

  private Map<ServerRequest, Queue<ServerResponse>> responses;
  private KubernetesMixedDispatcher dispatcher;

  private Socket socket;

  @BeforeEach
  void setUp() {
    responses = new HashMap<>();
    dispatcher = new KubernetesMixedDispatcher(responses);
    socket = Mockito.mock(Socket.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  @DisplayName("dispatch, with matching expectation, returns expectation")
  void dispatchWithMatchingExpectation() throws Exception {
    // Given
    responses.compute(new SimpleRequest(HttpMethod.GET, "/api/v1/resources/my-resource"), (k, v) -> new ArrayDeque<>())
      .add(new SimpleResponse(true, 200, "resourceBody", null));
    // When
    final MockResponse result = dispatcher.dispatch(new RecordedRequest(
      "GET /api/v1/resources/my-resource HTTP/1.1", EMPTY_HEADERS, Collections.emptyList(),
      0, new Buffer(), 0, socket));
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("status", "HTTP/1.1 200 OK")
      .extracting(MockResponse::getBody).extracting(Buffer::readUtf8)
      .isEqualTo("resourceBody");
  }

  @Test
  @DisplayName("dispatch, with existing CRUD resource, returns CRUD resource")
  void dispatchWithCrudExistentResource() throws Exception {
    // Given
    final Buffer requestBody = new Buffer();
    requestBody.writeString("{\"kind\": \"Resource\", \"apiVersion\": \"v1\",\"metadata\": {\"name\": \"my-resource\"}}", StandardCharsets.UTF_8);
    requestBody.flush();
    dispatcher.dispatch(new RecordedRequest(
        "POST /api/v1/resources HTTP/1.1", EMPTY_HEADERS, Collections.emptyList(),
        requestBody.size(), requestBody, 0, socket));
    // When
    final MockResponse result = dispatcher.dispatch(new RecordedRequest(
      "GET /api/v1/resources/my-resource HTTP/1.1", EMPTY_HEADERS, Collections.emptyList(),
      0, new Buffer(), 0, socket));
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("status", "HTTP/1.1 200 OK")
      .extracting(MockResponse::getBody).extracting(Buffer::readUtf8)
      .extracting(Serialization::unmarshal)
      .isInstanceOf(GenericKubernetesResource.class)
      .hasFieldOrPropertyWithValue("metadata.name", "my-resource");
  }
}
