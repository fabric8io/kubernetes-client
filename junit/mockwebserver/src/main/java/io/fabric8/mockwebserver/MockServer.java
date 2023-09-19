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
package io.fabric8.mockwebserver;

import io.fabric8.mockwebserver.dsl.MockServerExpectation;
import okhttp3.mockwebserver.RecordedRequest;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public interface MockServer {

  /**
   * This method is called right before start. Override it to add extra initialization.
   */
  default void onStart() {
  }

  /**
   * This method is called right after shutdown. Override it to add extra cleanup.
   */
  default void onShutdown() {
  }

  /**
   * The port for the {@link okhttp3.mockwebserver.MockWebServer}.
   *
   * @return the MockWebServer port.
   */
  int getPort();

  /**
   * The host name for the {@link okhttp3.mockwebserver.MockWebServer}.
   * 
   * @return the MockWebServer host name;
   */
  String getHostName();

  /**
   * Returns a {@link Proxy} for the {@link okhttp3.mockwebserver.MockWebServer} with the current HostName and Port.
   *
   * @return a Proxy for the MockWebServer.
   */
  Proxy toProxyAddress();

  /**
   * Returns a String URL for connecting to this server.
   *
   * @param path the request path, such as "/".
   */
  String url(String path);

  /**
   * Returns a {@link MockServerExpectation} to set the expectations.
   *
   * @return the MockServerExpectation builder.
   */
  MockServerExpectation expect();

  /**
   * Returns the number of HTTP requests received thus far by this server. This may exceed the
   * number of HTTP connections when connection reuse is in practice.
   */
  int getRequestCount();

  /**
   * Awaits the next HTTP request, removes it, and returns it. Callers should use this to verify the
   * request was sent as intended. This method will block until the request is available, possibly
   * forever.
   *
   * @return the head of the request queue
   */
  RecordedRequest takeRequest() throws InterruptedException;

  /**
   * Awaits the next HTTP request (waiting up to the specified wait time if necessary), removes it,
   * and returns it. Callers should use this to verify the request was sent as intended within the
   * given time.
   *
   * @param timeout how long to wait before giving up, in units of {@code unit}
   * @param unit a {@code TimeUnit} determining how to interpret the {@code timeout} parameter
   * @return the head of the request queue
   */
  RecordedRequest takeRequest(long timeout, TimeUnit unit) throws InterruptedException;

  /**
   * Returns the last (most recent) HTTP request processed by the {@link okhttp3.mockwebserver.MockWebServer}.
   *
   * n.b. This method clears the request queue.
   *
   * @return the most recent RecordedRequest or null if none was processed.
   */
  RecordedRequest getLastRequest() throws InterruptedException;
}
