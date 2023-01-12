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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A port-forwarder using the websocket protocol.
 * It requires Kubernetes 1.6+ (previous versions support the SPDY protocol only).
 */
public class PortForwarderWebsocket implements PortForwarder {

  private static final Logger LOG = LoggerFactory.getLogger(PortForwarderWebsocket.class);

  private final HttpClient client;
  private final Executor executor;

  public PortForwarderWebsocket(HttpClient client, Executor executor) {
    this.client = client;
    this.executor = executor;
  }

  @Override
  public LocalPortForward forward(URL resourceBaseUrl, int port) {
    return forward(resourceBaseUrl, port, 0);
  }

  @Override
  public LocalPortForward forward(URL resourceBaseUrl, int port, int localPort) {
    return forward(resourceBaseUrl, port, null, localPort);
  }

  @Override
  public LocalPortForward forward(final URL resourceBaseUrl, final int port, final InetAddress localHost, final int localPort) {
    try {
      InetSocketAddress inetSocketAddress = createNewInetSocketAddress(localHost, localPort);
      final ServerSocketChannel server = ServerSocketChannel.open().bind(inetSocketAddress);

      final AtomicBoolean alive = new AtomicBoolean(true);
      final CopyOnWriteArrayList<PortForward> handles = new CopyOnWriteArrayList<>();

      final ExecutorService executorService = Executors.newSingleThreadExecutor();

      // Create a handle that can be used to retrieve information and stop the port-forward
      final LocalPortForward localPortForwardHandle = new LocalPortForward() {
        @Override
        public void close() throws IOException {
          alive.set(false);
          try {
            server.close();
          } finally {
            Utils.closeQuietly(handles);
            executorService.shutdownNow();
          }
        }

        @Override
        public boolean isAlive() {
          return alive.get();
        }

        @Override
        public boolean errorOccurred() {
          for (PortForward handle : handles) {
            if (handle.errorOccurred()) {
              return true;
            }
          }
          return false;
        }

        @Override
        public InetAddress getLocalAddress() {
          try {
            return ((InetSocketAddress) server.getLocalAddress()).getAddress();
          } catch (IOException e) {
            throw new IllegalStateException("Cannot determine local address", e);
          }
        }

        @Override
        public int getLocalPort() {
          try {
            return ((InetSocketAddress) server.getLocalAddress()).getPort();
          } catch (IOException e) {
            throw new IllegalStateException("Cannot determine local address", e);
          }
        }

        @Override
        public Collection<Throwable> getClientThrowables() {
          Collection<Throwable> clientThrowables = new ArrayList<>();
          for (PortForward handle : handles) {
            clientThrowables.addAll(handle.getClientThrowables());
          }
          return clientThrowables;
        }

        @Override
        public Collection<Throwable> getServerThrowables() {
          Collection<Throwable> serverThrowables = new ArrayList<>();
          for (PortForward handle : handles) {
            serverThrowables.addAll(handle.getServerThrowables());
          }
          return serverThrowables;
        }
      };

      // Start listening on localhost for new connections.
      // Every new connection will open its own stream on the remote resource.
      executorService.execute(() -> {
        // accept cycle
        while (alive.get()) {
          try {
            SocketChannel socket = server.accept();
            handles.add(forward(resourceBaseUrl, port, socket, socket));
          } catch (IOException e) {
            if (alive.get()) {
              LOG.error("Error while listening for connections", e);
            }
            Utils.closeQuietly(localPortForwardHandle);
          }
        }
      });

      return localPortForwardHandle;
    } catch (IOException e) {
      throw new IllegalStateException("Unable to port forward", e);
    }
  }

  @Override
  public PortForward forward(URL resourceBaseUrl, int port, final ReadableByteChannel in, final WritableByteChannel out) {
    final PortForwarderWebsocketListener listener = new PortForwarderWebsocketListener(in, out, executor);
    CompletableFuture<WebSocket> socket = client
        .newWebSocketBuilder()
        .uri(URI.create(URLUtils.join(resourceBaseUrl.toString(), "portforward?ports=" + port)))
        .buildAsync(listener);

    socket.whenComplete((w, t) -> {
      if (t != null) {
        listener.onError(w, t);
      }
    });

    return new PortForward() {
      @Override
      public void close() {
        socket.cancel(true);
        socket.whenComplete((w, t) -> {
          if (w != null) {
            listener.closeBothWays(w, 1001, "User closing");
          }
        });
      }

      @Override
      public boolean isAlive() {
        return listener.isAlive();
      }

      @Override
      public boolean errorOccurred() {
        return listener.errorOccurred();
      }

      @Override
      public Collection<Throwable> getClientThrowables() {
        return listener.getClientThrowables();
      }

      @Override
      public Collection<Throwable> getServerThrowables() {
        return listener.getServerThrowables();
      }
    };
  }

  InetSocketAddress createNewInetSocketAddress(InetAddress localHost, int localPort) {
    if (localHost == null) {
      return new InetSocketAddress(localPort);
    }
    return new InetSocketAddress(localHost, localPort);
  }

}
