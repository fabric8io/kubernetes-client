/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.fabric8.kubernetes.client.dsl.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.sundr.codegen.utils.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * A port-forwarder using the websocket protocol.
 * It requires Kubernetes 1.6+ (previous versions support the SPDY protocol only).
 */
public class PortForwarderWebsocket implements PortForwarder {

  private static final Logger LOG = LoggerFactory.getLogger(PortForwarderWebsocket.class);

  private KubernetesClient kubernetes;

  private OkHttpClient client;

  public PortForwarderWebsocket(KubernetesClient kubernetes, OkHttpClient client) {
    this.kubernetes = kubernetes;
    this.client = client;
  }

  @Override
  public PortForwarderBridgedHandle forward(String namespace, String pod, int port) {
    return forward(namespace, pod, port, 0);
  }

  @Override
  public PortForwarderBridgedHandle forward(String namespace, String pod, int port, int localPort) {
    return forward(namespace, pod, port, null, localPort);
  }

  @Override
  public PortForwarderBridgedHandle forward(final String namespace, final String pod, final int port, final InetAddress localHost, final int localPort) {
    try {
      final ServerSocketChannel server;
      if (localHost == null) {
        server = ServerSocketChannel.open().bind(new InetSocketAddress(localPort));
      } else {
        server = ServerSocketChannel.open().bind(new InetSocketAddress(localHost, localPort));
      }
      final AtomicBoolean alive = new AtomicBoolean(true);
      final CopyOnWriteArrayList<PortForwarderHandle> handles = new CopyOnWriteArrayList<>();

      final ExecutorService executorService = Executors.newSingleThreadExecutor();

      final PortForwarderBridgedHandle shutdownHandle = new PortForwarderBridgedHandle() {
        @Override
        public void close() throws IOException {
          alive.set(false);
          try {
            server.close();
          } finally {
            IOUtils.closeQuietly(handles.toArray(new Closeable[]{}));
            closeExecutor(executorService);
          }
        }

        @Override
        public boolean isAlive() {
          return alive.get();
        }

        @Override
        public InetAddress getLocalAddress() {
          try {
            return ((InetSocketAddress) server.getLocalAddress()).getAddress();
          } catch(IOException e) {
            throw new IllegalStateException("Cannot determine local address", e);
          }
        }

        @Override
        public int getLocalPort() {
          try {
            return ((InetSocketAddress) server.getLocalAddress()).getPort();
          } catch(IOException e) {
            throw new IllegalStateException("Cannot determine local address", e);
          }
        }
      };

      executorService.execute(new Runnable() {
        @Override
        public void run() {
          // accept cycle
          while (alive.get()) {
            try {
              SocketChannel socket = server.accept();
              handles.add(forward(namespace, pod, port, socket));
            } catch (IOException e) {
              if (alive.get()) {
                LOG.error("Error while listening for connections", e);
              }
              IOUtils.closeQuietly(shutdownHandle);
            }
          }
        }
      });

      return shutdownHandle;
    } catch (IOException e) {
      throw new IllegalStateException("Unable to port forward", e);
    }
  }

  @Override
  public PortForwarderHandle forward(String namespace, String pod, int port, final ByteChannel clientChannel) {

    final AtomicBoolean alive = new AtomicBoolean(true);
    final String logPrefix = "FWD[" + namespace + "/" + pod + ":" + port + "]";

    Request request;
    try {
      request = new Request.Builder()
        .get()
        .url(kubernetes.getMasterUrl() + "/api/v1/namespaces/" + URLEncoder.encode(namespace, "UTF-8") + "/pods/" + URLEncoder.encode(pod, "UTF-8")+ "/portforward?ports=" + port)
        .build();
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }

    final WebSocket socket = client.newWebSocket(request, new WebSocketListener() {

      private int messagesRead = 0;

      private ExecutorService pumperService = Executors.newSingleThreadExecutor();

      @Override
      public void onOpen(final WebSocket webSocket, Response response) {
        LOG.debug("{}: onOpen", logPrefix);

        pumperService.execute(new Runnable() {
          @Override
          public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            int read;
            try {
              do {
                buffer.clear();
                buffer.put((byte) 0); // channel
                read = clientChannel.read(buffer);
                if (read > 0) {
                  buffer.flip();
                  ByteString data = ByteString.of(buffer);
                  webSocket.send(data);
                }
              } while(alive.get() && read>=0);

              closeBothWays(webSocket, 1000, "Completed");
            } catch(IOException e) {
              if (alive.get()) {
                LOG.error("Error while writing client data");
                closeBothWays(webSocket, 1001, "Client error");
              }
            }
          }
        });
      }

      @Override
      public void onMessage(WebSocket webSocket, String text) {
        LOG.debug("{}: onMessage(String)", logPrefix);
        try {
          onMessage(webSocket, ByteBuffer.wrap(text.getBytes("UTF-8")));
        } catch (IOException e) {
          LOG.error("Error while converting string to byte buffer", e);
          closeBothWays(webSocket, 1002, "Protocol error");
        }
      }

      @Override
      public void onMessage(WebSocket webSocket, ByteString bytes) {
        LOG.debug("{}: onMessage(ByteString)", logPrefix);
        onMessage(webSocket, bytes.asByteBuffer());
      }

      private void onMessage(WebSocket webSocket, ByteBuffer buffer) {
        messagesRead++;
        if (messagesRead <= 2) {
          // skip the first two messages, containing the ports used internally
          return;
        }

        if (!buffer.hasRemaining()) {
          LOG.error("Received an empty message");
          closeBothWays(webSocket, 1002, "Protocol error");
        }

        byte channel = buffer.get();
        if (channel < 0 || channel > 1) {
          LOG.error("Received a wrong channel from the remote socket: {}", channel);
          closeBothWays(webSocket, 1002, "Protocol error");
        } else if (channel == 1) {
          // Error channel
          LOG.error("Received an error from the remote socket");
          closeForwarder();
        } else {
          // Data
          try {
            clientChannel.write(buffer);
          } catch (IOException e) {
            if (alive.get()) {
              LOG.error("Error while forwarding data to the client", e);
              closeBothWays(webSocket, 1002, "Protocol error");
            }
          }

        }

      }

      @Override
      public void onClosing(WebSocket webSocket, int code, String reason) {
        LOG.debug("{}: onClosing. Code={}, Reason={}", logPrefix, code, reason);
        if (alive.get()) {
          closeForwarder();
        }
      }

      @Override
      public void onClosed(WebSocket webSocket, int code, String reason) {
        LOG.debug("{}: onClosed. Code={}, Reason={}", logPrefix, code, reason);
        if (alive.get()) {
          closeForwarder();
        }
      }

      @Override
      public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        LOG.debug("{}: onFailure", logPrefix);
        if (alive.get()) {
          LOG.error(logPrefix + ": Throwable received from websocket", t);
          closeForwarder();
        }
      }

      private void closeBothWays(WebSocket webSocket, int code, String message) {
        alive.set(false);
        try {
          webSocket.close(code, message);
        } catch (Exception e) {
          LOG.error("Error while closing the websocket", e);
        }
        closeForwarder();
      }

      private void closeForwarder() {
        alive.set(false);
        try {
          clientChannel.close();
        } catch (IOException e) {
          LOG.error("Error while closing the client channel", e);
        }
        closeExecutor(pumperService);
      }

    });

    return new PortForwarderHandle() {
      @Override
      public void close() throws IOException {
        socket.close(1001, "User closing");
      }

      @Override
      public boolean isAlive() {
        return alive.get();
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

}
