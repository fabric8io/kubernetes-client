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

import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import io.fabric8.mockwebserver.utils.ResponseProviders;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SimpleResponse implements ServerResponse {

  private static final String HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";

  private final ResponseProvider<String> bodyProvider;

  private final WebSocketSession webSocketSession;
  private final boolean repeatable;
  private final long responseDelay;
  private final TimeUnit responseDelayUnit;

  public SimpleResponse(boolean repeatable, int statusCode, String body, WebSocketSession webSocketSession) {
    this(repeatable, ResponseProviders.of(statusCode, body), webSocketSession);
  }

  public SimpleResponse(boolean repeatable, ResponseProvider<String> bodyProvider, WebSocketSession webSocketSession) {
    this(repeatable, bodyProvider, webSocketSession, 0, TimeUnit.MILLISECONDS);
  }

  public SimpleResponse(boolean repeatable, int statusCode, String body, WebSocketSession webSocketSession, long responseDelay,
      TimeUnit responseDelayUnit) {
    this(repeatable, ResponseProviders.of(statusCode, body), webSocketSession, responseDelay, responseDelayUnit);
  }

  public SimpleResponse(boolean repeatable, ResponseProvider<String> bodyProvider, WebSocketSession webSocketSession,
      long responseDelay, TimeUnit responseDelayUnit) {
    this.bodyProvider = bodyProvider;
    this.webSocketSession = webSocketSession;
    this.repeatable = repeatable;
    this.responseDelay = responseDelay;
    this.responseDelayUnit = responseDelayUnit;
  }

  public ResponseProvider<String> getBodyProvider() {
    return bodyProvider;
  }

  @Override
  public MockResponse toMockResponse(RecordedRequest request) {
    MockResponse mockResponse = new MockResponse();
    mockResponse.setHeaders(bodyProvider.getHeaders());
    mockResponse.setResponseCode(bodyProvider.getStatusCode(request));

    if (webSocketSession != null) {
      mockResponse.withWebSocketUpgrade(webSocketSession);
      // see https://developer.mozilla.org/en-US/docs/Web/HTTP/Protocol_upgrade_mechanism
      // see https://github.com/netty/netty/blob/4.1/codec-http/src/main/java/io/netty/handler/codec/http/websocketx/WebSocketClientHandshaker.java#L366
      String requestWebsocketProtocol = request.getHeaders().get(HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL);
      if (requestWebsocketProtocol != null
          // only add the response header if it's not set, to prevent changing custom response headers
          && mockResponse.getHeaders().get(HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL) == null) {
        mockResponse.addHeader(HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL, requestWebsocketProtocol);
      }
    } else {
      mockResponse.setBody(bodyProvider.getBody(request));
    }

    if (responseDelay > 0) {
      mockResponse.setBodyDelay(responseDelay, responseDelayUnit);
    }

    return mockResponse;
  }

  public WebSocketSession getWebSocketSession() {
    return webSocketSession;
  }

  @Override
  public boolean isRepeatable() {
    return repeatable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    SimpleResponse that = (SimpleResponse) o;
    return repeatable == that.repeatable && responseDelay == that.responseDelay
        && Objects.equals(bodyProvider, that.bodyProvider) && Objects.equals(webSocketSession, that.webSocketSession)
        && responseDelayUnit == that.responseDelayUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bodyProvider, webSocketSession, repeatable, responseDelay, responseDelayUnit);
  }
}
