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

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A SOCKS5 proxy (RFC 1928, no authentication) that relays every CONNECT to a single origin, whatever address it names.
 */
final class Socks5Relay implements Closeable {

  private final ServerSocket serverSocket;
  private final ExecutorService executor = Executors.newCachedThreadPool();
  private final Queue<Socket> sockets = new ConcurrentLinkedQueue<>();
  private final AtomicInteger connectCount = new AtomicInteger();

  Socks5Relay(int originPort) throws IOException {
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

  int getConnectCount() {
    return connectCount.get();
  }

  private void relay(Socket client, int originPort) {
    try (client; Socket origin = new Socket(InetAddress.getLoopbackAddress(), originPort)) {
      sockets.add(client);
      sockets.add(origin);
      final DataInputStream in = new DataInputStream(client.getInputStream());
      final OutputStream out = client.getOutputStream();
      in.readUnsignedByte(); // version
      in.readFully(new byte[in.readUnsignedByte()]); // methods
      out.write(new byte[] { 0x05, 0x00 }); // no authentication
      in.readFully(new byte[3]); // version, CONNECT, reserved
      final int addressType = in.readUnsignedByte();
      if (addressType == 0x01) {
        in.readFully(new byte[4]);
      } else if (addressType == 0x04) {
        in.readFully(new byte[16]);
      } else {
        in.readFully(new byte[in.readUnsignedByte()]);
      }
      in.readUnsignedShort(); // port
      connectCount.incrementAndGet();
      out.write(new byte[] { 0x05, 0x00, 0x00, 0x01, 0, 0, 0, 0, 0, 0 });
      executor.execute(() -> {
        try {
          in.transferTo(origin.getOutputStream());
          origin.shutdownOutput();
        } catch (IOException e) {
          // the connection is closed
        }
      });
      origin.getInputStream().transferTo(out);
    } catch (IOException e) {
      // the connection is closed
    }
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
