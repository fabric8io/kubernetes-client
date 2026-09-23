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
package io.fabric8.kubernetes.client.http;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A proxy that relays every connection to a single origin, whatever host the request names.
 * <p>
 * It answers a CONNECT itself and tunnels what follows, recording it, and passes any other (absolute-form) request on
 * as is.
 */
final class TunnelingProxy implements Closeable {

  private final ServerSocket serverSocket;
  private final ExecutorService executor = Executors.newCachedThreadPool();
  private final Queue<Socket> sockets = new ConcurrentLinkedQueue<>();
  private final Queue<String> requestHeads = new ConcurrentLinkedQueue<>();
  private final ByteArrayOutputStream tunneled = new ByteArrayOutputStream();

  TunnelingProxy(int originPort) throws IOException {
    serverSocket = new ServerSocket(0, 50, InetAddress.getLoopbackAddress());
    executor.execute(() -> {
      while (!serverSocket.isClosed()) {
        try {
          final Socket client = serverSocket.accept();
          executor.execute(() -> relay(client, originPort));
        } catch (IOException e) {
          return;
        }
      }
    });
  }

  int getPort() {
    return serverSocket.getLocalPort();
  }

  /** The head of the first request of every connection, a CONNECT for the tunneled ones. */
  List<String> getRequestHeads() {
    return List.copyOf(requestHeads);
  }

  /** What the clients sent inside the CONNECT tunnels, which the proxy can't read unless it's plain text. */
  String getTunneledText() {
    synchronized (tunneled) {
      return tunneled.toString(StandardCharsets.ISO_8859_1);
    }
  }

  private void relay(Socket client, int originPort) {
    try (client; Socket origin = new Socket(InetAddress.getLoopbackAddress(), originPort)) {
      sockets.add(client);
      sockets.add(origin);
      final InputStream in = client.getInputStream();
      final String head = readHead(in);
      requestHeads.add(head);
      final OutputStream originOut = origin.getOutputStream();
      final OutputStream upstream;
      if (head.startsWith("CONNECT ")) {
        client.getOutputStream().write("HTTP/1.1 200 Connection established\r\n\r\n".getBytes(StandardCharsets.ISO_8859_1));
        upstream = new OutputStream() {
          @Override
          public void write(int b) throws IOException {
            write(new byte[] { (byte) b }, 0, 1);
          }

          @Override
          public void write(byte[] b, int off, int len) throws IOException {
            synchronized (tunneled) {
              tunneled.write(b, off, len);
            }
            originOut.write(b, off, len);
          }
        };
      } else {
        originOut.write(head.getBytes(StandardCharsets.ISO_8859_1));
        upstream = originOut;
      }
      executor.execute(() -> {
        try {
          in.transferTo(upstream);
          origin.shutdownOutput();
        } catch (IOException e) {
          // the connection is closed
        }
      });
      origin.getInputStream().transferTo(client.getOutputStream());
    } catch (IOException e) {
      // the connection is closed
    }
  }

  private static String readHead(InputStream in) throws IOException {
    final StringBuilder head = new StringBuilder();
    int b;
    while (!head.toString().endsWith("\r\n\r\n") && (b = in.read()) != -1) {
      head.append((char) b);
    }
    return head.toString();
  }

  @Override
  public void close() throws IOException {
    serverSocket.close();
    for (Socket socket : sockets) {
      socket.close();
    }
    executor.shutdownNow();
  }
}
