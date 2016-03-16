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

class ServerResponse {

  private final int code;
  private final String body;
  private final WebSocketSession webSocketSession;
  private final boolean toBeRemoved;

  public ServerResponse(int code, String body, WebSocketSession webSocketSession, boolean toBeRemoved) {
    this.code = code;
    this.body = body;
    this.webSocketSession = webSocketSession;
    this.toBeRemoved = toBeRemoved;
  }

  public int getCode() {
    return code;
  }

  public String getBody() {
    return body;
  }

  public WebSocketSession getWebSocketSession() {
    return webSocketSession;
  }

  public boolean isToBeRemoved() {
    return toBeRemoved;
  }
}
