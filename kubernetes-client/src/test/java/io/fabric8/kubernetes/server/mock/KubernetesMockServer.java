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
          Queue<ServerResponse> queue = responses.get(key);
          return handleResponse(queue.peek(), queue);
        } else if (responses.containsKey(keyForAnyMethod)) {
          Queue<ServerResponse> queue = responses.get(keyForAnyMethod);
          return handleResponse(queue.peek(), queue);
        }
        return new MockResponse().setResponseCode(404);
      }
    });
    expect().get().withPath("/").andReturn(200, new RootPathsBuilder().addToPaths("/api").build()).always();
    server.play();
  }

  private MockResponse handleResponse(ServerResponse response, Queue<ServerResponse> queue) {
    if (response == null) {
      return new MockResponse().setResponseCode(404);
    } else if (response.isToBeRemoved()) {
      queue.remove();
    }
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

  public MockServerExpectation expect() {
    return new MockServerExpectationImpl(responses);
  }
}
