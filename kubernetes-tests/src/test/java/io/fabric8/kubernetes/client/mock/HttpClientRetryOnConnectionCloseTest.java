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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HttpClientRetryOnConnectionCloseTest {

  @Test
  void kubernetesClientRetriesOnConnectionClose() throws Exception {
    AtomicInteger connectionCount = new AtomicInteger(0);

    try (ServerSocket serverSocket = new ServerSocket(0)) {
      Thread serverThread = new Thread(() -> {
        while (!serverSocket.isClosed()) {
          try {
            Socket socket = serverSocket.accept();
            connectionCount.incrementAndGet();
            socket.close();
          } catch (IOException e) {
            // expected when serverSocket is closed at end of test
          }
        }
      });
      serverThread.setDaemon(true);
      serverThread.start();

      String masterUrl = "http://localhost:" + serverSocket.getLocalPort();

      try (KubernetesClient client = new KubernetesClientBuilder()
          .withConfig(new ConfigBuilder()
              .withMasterUrl(masterUrl)
              .withRequestRetryBackoffLimit(2)
              .withRequestRetryBackoffInterval(50)
              .withNamespace("default")
              .build())
          .build()) {

        assertThatThrownBy(() -> client.pods().inNamespace("default").list())
            .isInstanceOf(KubernetesClientException.class)
            .hasCauseInstanceOf(IOException.class);

        // 1 initial attempt + 2 retries
        assertThat(connectionCount.get()).isEqualTo(3);
      }
    }
  }

}
