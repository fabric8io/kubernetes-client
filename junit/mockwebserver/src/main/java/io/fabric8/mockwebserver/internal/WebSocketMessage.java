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

import java.nio.charset.StandardCharsets;

public class WebSocketMessage {

  private final Long delay;
  private final byte[] body;
  private final boolean toBeRemoved;
  private final boolean binary;

  public WebSocketMessage(String body) {
    this(0L, body, true);
  }

  public WebSocketMessage(byte[] body) {
    this(0L, body, true, true);
  }

  public WebSocketMessage(String body, boolean toBeRemoved) {
    this(0L, body.getBytes(StandardCharsets.UTF_8), toBeRemoved, false);
  }

  public WebSocketMessage(byte[] body, boolean toBeRemoved) {
    this(0L, body, toBeRemoved, true);
  }

  public WebSocketMessage(Long delay, String body, boolean toBeRemoved) {
    this(delay, body.getBytes(StandardCharsets.UTF_8), toBeRemoved, false);
  }

  public WebSocketMessage(Long delay, byte[] body, boolean toBeRemoved) {
    this(delay, body, toBeRemoved, true);
  }

  public WebSocketMessage(Long delay, String body, boolean toBeRemoved, boolean binary) {
    this(delay, body.getBytes(StandardCharsets.UTF_8), toBeRemoved, binary);
  }

  public WebSocketMessage(Long delay, byte[] body, boolean toBeRemoved, boolean binary) {
    this.delay = delay;
    this.body = body;
    this.toBeRemoved = toBeRemoved;
    this.binary = binary;
  }

  public Long getDelay() {
    return delay;
  }

  public String getBody() {
    return new String(body);
  }

  public boolean isToBeRemoved() {
    return toBeRemoved;
  }

  public byte[] getBytes() {
    return body;
  }

  public boolean isBinary() {
    return binary;
  }
}
