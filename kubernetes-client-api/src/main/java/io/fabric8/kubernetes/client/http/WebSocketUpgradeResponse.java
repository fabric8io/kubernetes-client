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
package io.fabric8.kubernetes.client.http;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WebSocketUpgradeResponse extends StandardHttpHeaders implements HttpResponse<Void> {

  private final HttpRequest httpRequest;
  private final int code;
  private final WebSocket webSocket;

  public WebSocketUpgradeResponse(HttpRequest httpRequest, WebSocket webSocket) {
    this(httpRequest, 101, new LinkedHashMap<>(), webSocket);
  }

  public WebSocketUpgradeResponse(HttpRequest httpRequest, int code, WebSocket webSocket) {
    this(httpRequest, code, new LinkedHashMap<>(), webSocket);
  }

  public WebSocketUpgradeResponse(HttpRequest httpRequest, int code, Map<String, List<String>> headers, WebSocket webSocket) {
    super(headers);
    this.httpRequest = httpRequest;
    this.code = code;
    this.webSocket = webSocket;
  }

  @Override
  public int code() {
    return code;
  }

  @Override
  public Void body() {
    return null;
  }

  @Override
  public HttpRequest request() {
    return httpRequest;
  }

  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return Optional.empty();
  }

  public WebSocket getWebSocket() {
    return webSocket;
  }
}
