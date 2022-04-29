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

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

public interface WebSocket {

  interface Listener {

    default void onOpen(WebSocket webSocket) {
    }

    default void onMessage(WebSocket webSocket, String text) {
    }

    default void onMessage(WebSocket webSocket, ByteBuffer bytes) {
    }

    default void onClose(WebSocket webSocket, int code, String reason) {
    }

    default void onError(WebSocket webSocket, Throwable error) {
    }

  }

  interface Builder extends BasicBuilder {

    /**
     * Builds a new WebSocket connection and waits asynchronously until the connection is opened.
     * The listener onOpen callback is called before the returned future is completed.
     *
     * @param listener
     * @return CompletableFuture which is completed after connection is opened
     */
    CompletableFuture<WebSocket> buildAsync(Listener listener);

    Builder subprotocol(String protocol);

    @Override
    Builder header(String name, String value);

    @Override
    Builder setHeader(String k, String v);

    @Override
    Builder uri(URI uri);

  }

  /**
   * Send some data
   *
   * @return true if the message was successfully enqueued.
   */
  boolean send(ByteBuffer buffer);

  /**
   * Send a close message. If successful, the output side
   * will then be closed. After a timeout the input side will
   * automatically be shutdown if it isn't already shutdown by
   * the remote side.
   *
   * @return true if the message was successfully enqueued.
   */
  boolean sendClose(int code, String reason);

  /**
   * Returns the size in bytes of all messages enqueued to be transmitted to the server. This
   * doesn't include framing overhead.
   */
  long queueSize();

}
