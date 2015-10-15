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

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class MockServerExpectationImpl implements MockServerExpectation {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private final String method;
  private final String path;
  private final int statusCode;
  private final String body;
  private final int times;

  private final Map<ServerRequest, Queue<ServerResponse>> responses;

  public MockServerExpectationImpl(Map<ServerRequest, Queue<ServerResponse>> responses) {
    this("", null, 200, null, 1, responses);
  }
  public MockServerExpectationImpl(String method, String path, int statusCode, String body, int times, Map<ServerRequest, Queue<ServerResponse>> responses) {
    this.method = method;
    this.path = path;
    this.statusCode = statusCode;
    this.body = body;
    this.times = times;
    this.responses = responses;
  }

  @Override
  public Pathable<Returnable<Timeable>> any() {
    return new MockServerExpectationImpl("", path, statusCode, body, times, responses);
  }

  @Override
  public Pathable<Returnable<Timeable>> post() {
    return new MockServerExpectationImpl("post", path, statusCode, body, times, responses);
  }

  @Override
  public Pathable<Returnable<Timeable>> get() {
    return new MockServerExpectationImpl("get", path, statusCode, body, times, responses);
  }

  @Override
  public Pathable<Returnable<Timeable>> put() {
    return new MockServerExpectationImpl("put", path, statusCode, body, times, responses);
  }

  @Override
  public Pathable<Returnable<Timeable>> delete() {
    return new MockServerExpectationImpl("delete", path, statusCode, body, times, responses);
  }

  @Override
  public Returnable<Timeable> withPath(String path) {
    return new MockServerExpectationImpl(method, path, statusCode, body, times, responses);
  }

  @Override
  public Timeable andReturn(int statusCode, Object content) {
    if (content instanceof String) {
      return new MockServerExpectationImpl(method, path, statusCode, (String) content, times, responses);
    } else {
      try {
        return new MockServerExpectationImpl(method, path, statusCode, MAPPER.writeValueAsString(content), times, responses);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public void always() {
    enqueue(new ServerRequest(method, path), new ServerResponse(statusCode, body, false));
  }

  @Override
  public void once() {
    enqueue(new ServerRequest(method, path), new ServerResponse(statusCode, body, true));
  }

  @Override
  public void times(int times) {
    for (int i = 0; i < times; i++) {
      once();
    }
  }

  private void enqueue(ServerRequest req, ServerResponse resp) {
    Queue<ServerResponse> queuedResponses = responses.get(req);
    if (queuedResponses == null) {
      queuedResponses = new ArrayDeque<>();
      responses.put(req, queuedResponses);
    }
    queuedResponses.add(resp);
  }
}
