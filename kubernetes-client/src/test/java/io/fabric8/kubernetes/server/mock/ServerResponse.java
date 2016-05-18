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

public class ServerResponse {

  private final int statusCode;
  private final String body;
  private final WebSocketSession webSocketSession;
  private final boolean repeatable;

  public ServerResponse(int statusCode, String body, WebSocketSession webSocketSession, boolean repeatable) {
    this.statusCode = statusCode;
    this.body = body;
    this.webSocketSession = webSocketSession;
    this.repeatable = repeatable;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getBody() {
    return body;
  }

  public WebSocketSession getWebSocketSession() {
    return webSocketSession;
  }

  public boolean isRepeatable() {
    return repeatable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ServerResponse that = (ServerResponse) o;

    if (statusCode != that.statusCode) return false;
    if (repeatable != that.repeatable) return false;
    if (body != null ? !body.equals(that.body) : that.body != null) return false;
    return webSocketSession != null ? webSocketSession.equals(that.webSocketSession) : that.webSocketSession == null;

  }

  @Override
  public int hashCode() {
    int result = statusCode;
    result = 31 * result + (body != null ? body.hashCode() : 0);
    result = 31 * result + (webSocketSession != null ? webSocketSession.hashCode() : 0);
    result = 31 * result + (repeatable ? 1 : 0);
    return result;
  }
}
