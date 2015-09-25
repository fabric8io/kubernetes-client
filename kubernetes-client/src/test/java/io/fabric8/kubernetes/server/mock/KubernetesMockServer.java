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
import java.util.HashMap;
import java.util.Map;

public class KubernetesMockServer {

  private final ObjectMapper mapper = new ObjectMapper();

  private MockWebServer server = new MockWebServer();
  private Map<String, ServerResponse> responses = new HashMap<>();


  public void init() throws IOException {
    server.setDispatcher(new Dispatcher() {
      @Override
      public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
        String path = request.getPath();
        if (responses.containsKey(path)) {
          ServerResponse response = responses.get(path);
          MockResponse mockResponse = new MockResponse();
          mockResponse.setBody(response.getBody());
          mockResponse.setResponseCode(response.getCode());
          return mockResponse;
        }
        return new MockResponse().setResponseCode(404);
      }
    });
    expectAndReturnAsJson("/", 200, new RootPathsBuilder().addToPaths("/api").build());
    server.play();
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
    responses.put(path, new ServerResponse(code, toJson(body)));
  }

  public void expectAndReturnAsString(String path, int code, String body) {
    responses.put(path, new ServerResponse(code, body));
  }

  private String toJson(Object obj) {
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
