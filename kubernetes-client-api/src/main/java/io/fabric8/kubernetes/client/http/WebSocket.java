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

  /**
   * Callback methods for websocket events. The methods are
   * guaranteed to be called serially - except for {@link #onError(WebSocket, Throwable)}
   */
  interface Listener {

    default void onOpen(WebSocket webSocket) {
    }

    /**
     * Called once the full text message has been built. {@link WebSocket#request()} must
     * be called to receive more messages or onClose.
     */
    default void onMessage(WebSocket webSocket, String text) {
      webSocket.request();
    }

    /**
     * Called once the full binary message has been built. {@link WebSocket#request()} must
     * be called to receive more messages or onClose.
     */
    default void onMessage(WebSocket webSocket, ByteBuffer bytes) {
      webSocket.request();
    }

    /**
     * Called when the remote input closes. It's a terminal event, calls to {@link WebSocket#request()}
     * do nothing after this.
     */
    default void onClose(WebSocket webSocket, int code, String reason) {
    }

    /**
     * Called when an error has occurred. It's a terminal event, calls to {@link WebSocket#request()}
     * do nothing after this.
     */
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

    /**
     * Protocol used for WebSocket message exchange.
     *
     * <blockquote>
     * The client can request that the server use a specific subprotocol by
     * including the |Sec-WebSocket-Protocol| field in its handshake. If it
     * is specified, the server needs to include the same field and one of
     * the selected subprotocol values in its response for the connection to
     * be established.
     * </blockquote>
     * <i>RFC 6455: Section 1.9, Subprotocols Using the WebSocket Protocol</i>
     *
     * @param protocol the protocol to be used.
     * @return this builder.
     */
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

  /**
   * Used to receive more onMessage or {@link Listener#onClose(WebSocket, int, String)} events after the initial message is
   * received
   * <p>
   * request is implicitly called by {@link Listener#onOpen(WebSocket)}
   * <p>
   * depending on the websocket implementation request may trigger immediate / concurrent delivery
   * of the close event - this means you'll generally want to call this method once you've completed the consumption
   * of the current event.
   */
  void request();

  /**
   * Converts http or https URIs to ws or wss URIs.
   * <p>
   * Clients such as JDK or Jetty require URIs to be performed to the ws protocol, other clients perform
   * this same transformation automatically.
   *
   * @param httpUri the original URI to transform.
   * @return a new URI with the converted protocol (if applicable).
   */
  static URI toWebSocketUri(URI httpUri) {
    if (httpUri != null && httpUri.getScheme().startsWith("http")) {
      // the jdk logic expects a ws uri
      // after the https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8245245 it just does the reverse of this
      // to convert back to http(s) ...
      return URI.create("ws" + httpUri.toString().substring(4));
    }
    return httpUri;
  }

}
