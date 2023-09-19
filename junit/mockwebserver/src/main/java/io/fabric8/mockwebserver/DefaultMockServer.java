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
import io.fabric8.mockwebserver.internal.MockDispatcher;
import io.fabric8.mockwebserver.internal.MockSSLContextFactory;
import io.fabric8.mockwebserver.internal.MockServerExpectationImpl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultMockServer implements MockServer {

  private final Context context;
  private final boolean useHttps;
  private final MockWebServer server;
  private final Map<ServerRequest, Queue<ServerResponse>> responses;
  private final AtomicInteger lastRequestCount;
  private final AtomicReference<RecordedRequest> lastRequest;

  private final AtomicBoolean initialized = new AtomicBoolean();
  private final AtomicBoolean shutdown = new AtomicBoolean();

  public DefaultMockServer() {
    this(new Context(), new MockWebServer(), new HashMap<>(), false);
  }

  public DefaultMockServer(boolean useHttps) {
    this(new Context(), new MockWebServer(), new HashMap<>(), useHttps);
  }

  public DefaultMockServer(MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, boolean useHttps) {
    this(new Context(), server, responses, useHttps);
  }

  public DefaultMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses,
      boolean useHttps) {
    this(context, server, responses, new MockDispatcher(responses), useHttps);
  }

  public DefaultMockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses,
      Dispatcher dispatcher, boolean useHttps) {
    this.context = context;
    this.useHttps = useHttps;
    this.server = server;
    this.responses = responses;
    this.lastRequest = new AtomicReference<>();
    this.lastRequestCount = new AtomicInteger(0);
    this.server.setDispatcher(dispatcher);
  }

  private void startInternal() {
    if (initialized.compareAndSet(false, true)) {
      if (useHttps) {
        server.useHttps(MockSSLContextFactory.create().getSocketFactory(), false);
      }
      onStart();
    }
  }

  private void shutdownInternal() {
    if (shutdown.compareAndSet(false, true)) {
      onShutdown();
    }
  }

  public final void start() {
    try {
      startInternal();
      server.start();
    } catch (IOException e) {
      throw new MockServerException("Exception when starting DefaultMockServer", e);
    }
  }

  public final void start(int port) {
    try {
      startInternal();
      server.start(port);
    } catch (IOException e) {
      throw new MockServerException("Exception when starting DefaultMockServer with port", e);
    }
  }

  public final void start(InetAddress inetAddress, int port) {
    try {
      startInternal();
      server.start(inetAddress, port);
    } catch (IOException e) {
      throw new MockServerException("Exception when starting DefaultMockServer with InetAddress and port", e);
    }
  }

  public final void shutdown() {
    try {
      server.shutdown();
    } catch (IOException e) {
      throw new MockServerException("Exception when stopping DefaultMockServer", e);
    } finally {
      shutdownInternal();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String url(String path) {
    return server.url(path).toString();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPort() {
    return server.getPort();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getHostName() {
    return server.getHostName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Proxy toProxyAddress() {
    return server.toProxyAddress();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MockServerExpectation expect() {
    return new MockServerExpectationImpl(responses, context);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getRequestCount() {
    return server.getRequestCount();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RecordedRequest takeRequest() throws InterruptedException {
    return server.takeRequest();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RecordedRequest takeRequest(long timeout, TimeUnit unit) throws InterruptedException {
    return server.takeRequest(timeout, unit);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public synchronized RecordedRequest getLastRequest() throws InterruptedException {
    if (lastRequest.get() != null && getRequestCount() == lastRequestCount.get()) {
      return lastRequest.get();
    }
    int requestCount = getRequestCount() - lastRequestCount.getAndSet(getRequestCount());
    RecordedRequest latestRequest = null;
    while (requestCount-- > 0) {
      latestRequest = takeRequest();
    }
    lastRequest.set(latestRequest);
    return latestRequest;
  }
}
