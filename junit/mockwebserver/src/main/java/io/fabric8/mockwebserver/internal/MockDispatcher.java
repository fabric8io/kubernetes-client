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

package io.fabric8.mockwebserver.internal;

import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MockDispatcher extends Dispatcher {

  private final Map<ServerRequest, Queue<ServerResponse>> responses;
  private final Collection<WebSocketSession> webSocketSessions = new ConcurrentLinkedQueue<>();

  public MockDispatcher(Map<ServerRequest, Queue<ServerResponse>> responses) {
    this.responses = responses;
  }

  @Override
  public MockResponse dispatch(RecordedRequest request) {
    for (WebSocketSession webSocketSession : webSocketSessions) {
      webSocketSession.dispatch(request);
    }

    HttpMethod method = HttpMethod.valueOf(request.getMethod());
    String path = request.getPath();
    SimpleRequest key = new SimpleRequest(method, path);
    SimpleRequest keyForAnyMethod = new SimpleRequest(path);
    if (responses.containsKey(key)) {
      Queue<ServerResponse> queue = responses.get(key);
      return handleResponse(queue.peek(), queue, request);
    } else if (responses.containsKey(keyForAnyMethod)) {
      Queue<ServerResponse> queue = responses.get(keyForAnyMethod);
      return handleResponse(queue.peek(), queue, request);
    }
    return new MockResponse().setResponseCode(404);
  }

  private MockResponse handleResponse(ServerResponse response, Queue<ServerResponse> queue, RecordedRequest request) {
    if (response == null) {
      return new MockResponse().setResponseCode(404);
    } else if (!response.isRepeatable()) {
      queue.remove();
    }
    if (response instanceof SimpleResponse) {
      SimpleResponse simpleResponse = (SimpleResponse) response;
      if (simpleResponse.getWebSocketSession() != null) {
        webSocketSessions.add(simpleResponse.getWebSocketSession());
      }
    }
    return response.toMockResponse(request);
  }

  @Override
  public void shutdown() {
    webSocketSessions.forEach(WebSocketSession::shutdown);
    super.shutdown();
  }
}
