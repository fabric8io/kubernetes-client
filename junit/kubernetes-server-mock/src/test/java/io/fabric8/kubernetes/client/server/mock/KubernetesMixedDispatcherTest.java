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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.http.Buffer;
import io.fabric8.mockwebserver.http.Headers;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.internal.SimpleRequest;
import io.fabric8.mockwebserver.internal.SimpleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesMixedDispatcherTest {

  private static final Headers EMPTY_HEADERS = new Headers.Builder().build();

  private Map<ServerRequest, Queue<ServerResponse>> responses;
  private KubernetesMixedDispatcher dispatcher;

  @BeforeEach
  void setUp() {
    responses = new HashMap<>();
    dispatcher = new KubernetesMixedDispatcher(responses);
  }

  @Test
  @DisplayName("dispatch, with matching expectation, returns expectation")
  void dispatchWithMatchingExpectation() {
    // Given
    responses.compute(new SimpleRequest(HttpMethod.GET, "/api/v1/resources/my-resource"), (k, v) -> new ArrayDeque<>())
        .add(new SimpleResponse(true, 200, "resourceBody", null));
    // When
    final MockResponse result = dispatcher.dispatch(new RecordedRequest("HTTP/1.1", HttpMethod.GET,
        "/api/v1/resources/my-resource", EMPTY_HEADERS, null));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("status", "HTTP/1.1 200 OK")
        .extracting(MockResponse::getBody).extracting(Buffer::readUtf8)
        .isEqualTo("resourceBody");
  }

  @Test
  @DisplayName("dispatch, with existing CRUD resource, returns CRUD resource")
  void dispatchWithCrudExistentResource() {
    // Given
    final Buffer requestBody = new Buffer();
    requestBody.writeString("{\"kind\": \"Resource\", \"apiVersion\": \"v1\",\"metadata\": {\"name\": \"my-resource\"}}",
        StandardCharsets.UTF_8);
    requestBody.flush();
    dispatcher.dispatch(new RecordedRequest("HTTP/1.1", HttpMethod.POST,
        "/api/v1/resources", EMPTY_HEADERS, requestBody));
    // When
    final MockResponse result = dispatcher.dispatch(new RecordedRequest("HTTP/1.1", HttpMethod.GET,
        "/api/v1/resources/my-resource", EMPTY_HEADERS, null));
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("status", "HTTP/1.1 200 OK")
        .extracting(MockResponse::getBody).extracting(Buffer::readUtf8)
        .extracting(Serialization::unmarshal)
        .isInstanceOf(GenericKubernetesResource.class)
        .hasFieldOrPropertyWithValue("metadata.name", "my-resource");
  }
}
