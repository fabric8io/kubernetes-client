/*
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
package io.fabric8.mockwebserver.http;

public interface WebSocket {
  /**
   * Returns the original request that initiated this web socket.
   */
  RecordedRequest request();

  /**
   * Attempts to enqueue {@code text} to be UTF-8 encoded and sent as the data of a text (type
   * {@code 0x1}) message.
   */
  boolean send(String text);

  /**
   * Attempts to enqueue {@code bytes} to be sent as a the data of a binary (type {@code 0x2})
   * message.
   */
  boolean send(byte[] bytes);

  /**
   * Compatibility layer for OkHttp.
   *
   * @deprecated use {@link #send(byte[])} or {@link #send(String)} instead.
   */
  @Deprecated
  default boolean send(ByteString bytes) {
    return send(bytes.toByteArray());
  }

  /**
   * Attempts to initiate a graceful shutdown of this web socket.
   * <p>
   * No more messages can be sent.
   *
   * @param code the status code.
   * @param reason reason of closure.
   */
  boolean close(int code, String reason);
}
