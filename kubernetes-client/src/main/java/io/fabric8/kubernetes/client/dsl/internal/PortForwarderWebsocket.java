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

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.URLUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A port-forwarder using the websocket protocol.
 * It requires Kubernetes 1.6+ (previous versions support the SPDY protocol only).
 */
public class PortForwarderWebsocket implements PortForwarder {

  private static final Logger LOG = LoggerFactory.getLogger(PortForwarderWebsocket.class);

  private final HttpClient client;

  public PortForwarderWebsocket(HttpClient client) {
    this.client = client;
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
      final ServerSocketChannel server;
      if (localHost == null) {
        server = ServerSocketChannel.open().bind(new InetSocketAddress(localPort));
      } else {
        server = ServerSocketChannel.open().bind(new InetSocketAddress(localHost, localPort));
      }

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
            closeQuietly(handles.toArray(new Closeable[]{}));
            closeExecutor(executorService);
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
            closeQuietly(localPortForwardHandle);
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
    final AtomicBoolean alive = new AtomicBoolean(true);
    final AtomicBoolean errorOccurred = new AtomicBoolean(false);
    final Collection<Throwable> clientThrowables = Collections.synchronizedCollection(new ArrayList<>());
    final Collection<Throwable> serverThrowables = Collections.synchronizedCollection(new ArrayList<>());
    final String logPrefix = "FWD";

    WebSocket.Listener listener = new WebSocket.Listener() {
      private int messagesRead = 0;

      private final ExecutorService pumperService = Executors.newSingleThreadExecutor();

      @Override
      public void onOpen(final WebSocket webSocket) {
        LOG.debug("{}: onOpen", logPrefix);

        if (in != null) {
          pumperService.execute(() -> {
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            int read;
            try {
              do {
                buffer.clear();
                buffer.put((byte) 0); // channel byte
                read = in.read(buffer);
                if (read > 0) {
                  buffer.flip();
                  webSocket.send(buffer);
                }
              } while (alive.get() && read >= 0);

            } catch (IOException e) {
              if (alive.get()) {
                clientThrowables.add(e);
                LOG.error("Error while writing client data");
                closeBothWays(webSocket, 1001, "Client error");
              }
            }
          });
        }
      }

      @Override
      public void onMessage(WebSocket webSocket, String text) {
        LOG.debug("{}: onMessage(String)", logPrefix);
        onMessage(webSocket, ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8)));
      }

      @Override
      public void onMessage(WebSocket webSocket, ByteBuffer buffer) {
        messagesRead++;
        if (messagesRead <= 2) {
          // skip the first two messages, containing the ports used internally
          return;
        }

        if (!buffer.hasRemaining()) {
          errorOccurred.set(true);
          LOG.error("Received an empty message");
          closeBothWays(webSocket, 1002, "Protocol error");
        }

        byte channel = buffer.get();
        if (channel < 0 || channel > 1) {
          errorOccurred.set(true);
          LOG.error("Received a wrong channel from the remote socket: {}", channel);
          closeBothWays(webSocket, 1002, "Protocol error");
        } else if (channel == 1) {
          // Error channel
          errorOccurred.set(true);
          LOG.error("Received an error from the remote socket");
          closeForwarder();
        } else {
          // Data
          if (out != null) {
            try {
              out.write(buffer); // channel byte already skipped
            } catch (IOException e) {
              if (alive.get()) {
                clientThrowables.add(e);
                LOG.error("Error while forwarding data to the client", e);
                closeBothWays(webSocket, 1002, "Protocol error");
              }
            }
          }
        }
      }

      @Override
      public void onClose(WebSocket webSocket, int code, String reason) {
        LOG.debug("{}: onClose. Code={}, Reason={}", logPrefix, code, reason);
        if (alive.get()) {
          closeForwarder();
        }
      }

      @Override
      public void onError(WebSocket webSocket, Throwable t) {
        LOG.debug("{}: onFailure", logPrefix);
        if (alive.get()) {
          serverThrowables.add(t);
          LOG.error("{}: Throwable received from websocket", logPrefix, t);
          closeForwarder();
        }
      }

      private void closeBothWays(WebSocket webSocket, int code, String message) {
        LOG.debug("{}: Closing with code {} and reason: {}", logPrefix, code, message);
        alive.set(false);
        try {
          webSocket.sendClose(code, message);
        } catch (Exception e) {
          serverThrowables.add(e);
          LOG.error("Error while closing the websocket", e);
        }
        closeForwarder();
      }

      private void closeForwarder() {
        alive.set(false);
        if (in != null) {
          try {
            in.close();
          } catch (IOException e) {
            LOG.error("{}: Error while closing the client input channel", logPrefix, e);
          }
        }
        if (out != null && out != in) {
          try {
            out.close();
          } catch (IOException e) {
            LOG.error("{}: Error while closing the client output channel", logPrefix, e);
          }
        }
        closeExecutor(pumperService);
      }
    };
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
      public void close() throws IOException {
        socket.cancel(true);
        socket.whenComplete((w, t) -> { if (w != null) {
          w.sendClose(1001, "User closing");
        }});
      }

      @Override
      public boolean isAlive() {
        return alive.get();
      }

      @Override
      public boolean errorOccurred() {
        return errorOccurred.get() || !clientThrowables.isEmpty() || !serverThrowables.isEmpty();
      }

      @Override
      public Collection<Throwable> getClientThrowables() {
        return clientThrowables;
      }

      @Override
      public Collection<Throwable> getServerThrowables() {
        return serverThrowables;
      }
    };
  }

  private void closeExecutor(ExecutorService executor) {
    try {
      executor.shutdown();
      if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
        executor.shutdownNow();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
          LOG.error("The executor service did not terminate");
        }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } catch (Exception e) {
      LOG.error("Error while closing the executor", e);
    }
  }

  public static void closeQuietly(Closeable... cloaseables) {
    if(cloaseables != null) {
      for(Closeable c : cloaseables) {
        try {
          if(c != null) {
            c.close();
          }
        } catch (IOException ioe) {
          // Ignored
        }
      }
    }
  }

}
