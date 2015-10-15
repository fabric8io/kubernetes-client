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

package io.fabric8.kubernetes.server.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.mockwebserver.Dispatcher;
import com.google.mockwebserver.MockResponse;
import com.google.mockwebserver.MockWebServer;
import com.google.mockwebserver.RecordedRequest;
import io.fabric8.kubernetes.api.model.RootPathsBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class KubernetesMockServer {

  private final ObjectMapper mapper = new ObjectMapper();

  private MockWebServer server = new MockWebServer();
  private Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();

  public void init() throws IOException {
    server.setDispatcher(new Dispatcher() {
      @Override
      public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
        String method = request.getMethod();
        String path = request.getPath();
        ServerRequest key = new ServerRequest(method, path);
        ServerRequest keyForAnyMethod = new ServerRequest(path);
        if (responses.containsKey(key)) {
          ServerResponse response = responses.get(key).peek();
          if (responses.get(key).size() > 1) {
            responses.get(key).remove();
          }
          return toMockResponse(response);
        } else if(responses.containsKey(keyForAnyMethod)) {
          ServerResponse response = responses.get(keyForAnyMethod).peek();
          if (responses.get(keyForAnyMethod).size() > 1) {
            responses.get(keyForAnyMethod).remove();
          }
          return toMockResponse(response);
        }
        return new MockResponse().setResponseCode(404);
      }
    });
    expectAndReturnAsJson("/", 200, new RootPathsBuilder().addToPaths("/api").build());
    server.play();
  }

  private MockResponse toMockResponse(ServerResponse response) {
    MockResponse mockResponse = new MockResponse();
    mockResponse.setBody(response.getBody());
    mockResponse.setResponseCode(response.getCode());
    return mockResponse;
  }

  public void destroy() throws IOException {
    server.shutdown();
  }

  public KubernetesClient createClient() {
    Config config = new ConfigBuilder()
      .withMasterUrl("http://localhost:" + server.getPort())
      .withNamespace("test")
      .build();
    return new DefaultKubernetesClient(config);
  }

  public MockWebServer getServer() {
    return server;
  }

  public <T> void expectAndReturnAsJson(String path, int code, T body) {
    enqueue(new ServerRequest(path), new ServerResponse(code, toJson(body)));
  }

  public void expectAndReturnAsString(String path, int code, String body) {
    enqueue(new ServerRequest(path), new ServerResponse(code, body));
  }

  public <T> void expectAndReturnAsJson(String method, String path, int code, T body) {
    enqueue(new ServerRequest(method, path), new ServerResponse(code, toJson(body)));
  }

  public void expectAndReturnAsString(String method, String path, int code, String body) {
    enqueue(new ServerRequest(method, path), new ServerResponse(code, body));
  }


  private void enqueue(ServerRequest req, ServerResponse resp) {
    Queue<ServerResponse> queuedResponses = responses.get(req);
    if (queuedResponses == null) {
      queuedResponses = new ArrayDeque<>();
      responses.put(req, queuedResponses);
    }
    queuedResponses.add(resp);
  }

  private String toJson(Object obj) {
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
