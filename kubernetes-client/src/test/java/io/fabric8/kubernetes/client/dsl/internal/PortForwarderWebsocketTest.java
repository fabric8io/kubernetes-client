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

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PortForwarderWebsocketTest {
  private final HttpClient mockHttpClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);

  private PortForwarderWebsocket portForwarderWebsocket;

  @BeforeEach
  void initPortForwarderWebsocket() {
    this.portForwarderWebsocket = new PortForwarderWebsocket(mockHttpClient, CommonThreadPool.get());
  }

  @Test
  void testCreateNewInetSocketAddressWithNullLocalhost() {
    // Given
    int port = 8080;

    // When
    InetSocketAddress inetSocketAddress = portForwarderWebsocket.createNewInetSocketAddress(null, 8080);

    // Then
    assertThat(inetSocketAddress.getAddress().isAnyLocalAddress()).isTrue();
    assertThat(inetSocketAddress.getPort()).isEqualTo(port);
  }

  @Test
  void testCreateNewInetSocketAddress() throws UnknownHostException {
    // Given
    InetAddress inetAddress = InetAddress.getByAddress(new byte[] { 10, 19, 21, 23 });
    int port = 8080;

    // When
    InetSocketAddress inetSocketAddress = portForwarderWebsocket.createNewInetSocketAddress(inetAddress, 8080);

    // Then
    assertThat(inetSocketAddress.getAddress()).isEqualTo(inetAddress);
    assertThat(inetSocketAddress.getPort()).isEqualTo(port);
  }
}
