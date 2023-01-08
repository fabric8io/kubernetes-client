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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpClientTransport;
import org.eclipse.jetty.client.HttpProxy;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.dynamic.HttpClientTransportDynamic;
import org.eclipse.jetty.client.http.HttpClientConnectionFactory;
import org.eclipse.jetty.client.http.HttpClientTransportOverHTTP;
import org.eclipse.jetty.http2.client.HTTP2Client;
import org.eclipse.jetty.http2.client.http.ClientConnectionFactoryOverHTTP2;
import org.eclipse.jetty.io.ClientConnector;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.time.Duration;
import java.util.Optional;
import java.util.stream.Stream;

public class JettyHttpClientBuilder
    extends StandardHttpClientBuilder<JettyHttpClient, JettyHttpClientFactory, JettyHttpClientBuilder> {

  private static final int MAX_CONNECTIONS = Integer.MAX_VALUE;

  public JettyHttpClientBuilder(JettyHttpClientFactory clientFactory) {
    super(clientFactory);
    // TODO: HTTP2 disabled, MockWebServer support is limited and requires changes
    //  Enable (preferHttp11->false) the feature after fixing MockWebServer
    //  https://github.com/fabric8io/kubernetes-client/issues/4193
    this.preferHttp11 = true;
  }

  @Override
  public JettyHttpClient build() {
    if (client != null) {
      return new JettyHttpClient(this, client.getJetty(), client.getJettyWs());
    }
    final var sslContextFactory = new SslContextFactory.Client();
    if (sslContext != null) {
      sslContextFactory.setSslContext(sslContext);
    }
    if (tlsVersions != null && tlsVersions.length > 0) {
      sslContextFactory.setIncludeProtocols(Stream.of(tlsVersions).map(TlsVersion::javaName).toArray(String[]::new));
    }
    HttpClient sharedHttpClient = new HttpClient(newTransport(sslContextFactory, preferHttp11));
    WebSocketClient sharedWebSocketClient = new WebSocketClient(new HttpClient(newTransport(sslContextFactory, preferHttp11)));
    sharedWebSocketClient.setIdleTimeout(Duration.ZERO);
    if (connectTimeout != null) {
      sharedHttpClient.setConnectTimeout(connectTimeout.toMillis());
      sharedWebSocketClient.setConnectTimeout(connectTimeout.toMillis());
    }
    sharedHttpClient.setFollowRedirects(followRedirects);
    // long running http requests count against this and eventually exhaust
    // the work that can be done
    sharedHttpClient.setMaxConnectionsPerDestination(MAX_CONNECTIONS);
    sharedWebSocketClient.getHttpClient().setMaxConnectionsPerDestination(MAX_CONNECTIONS);
    if (proxyAddress != null) {
      sharedHttpClient.getProxyConfiguration().getProxies()
          .add(new HttpProxy(new Origin.Address(proxyAddress.getHostString(), proxyAddress.getPort()), false));
    }
    if (proxyAddress != null && proxyAuthorization != null) {
      sharedHttpClient.getRequestListeners().add(new Request.Listener.Adapter() {
        @Override
        public void onBegin(Request request) {
          request.headers(h -> h.put("Proxy-Authorization", proxyAuthorization));
        }
      });
    }
    return new JettyHttpClient(this, sharedHttpClient, sharedWebSocketClient);
  }

  private static HttpClientTransport newTransport(SslContextFactory.Client sslContextFactory, boolean preferHttp11) {
    final var clientConnector = new ClientConnector();
    clientConnector.setSslContextFactory(sslContextFactory);
    final HttpClientTransport transport;
    if (preferHttp11) {
      transport = new HttpClientTransportOverHTTP(clientConnector);
    } else {
      var http2 = new ClientConnectionFactoryOverHTTP2.HTTP2(new HTTP2Client(clientConnector));
      transport = new HttpClientTransportDynamic(clientConnector, http2, HttpClientConnectionFactory.HTTP11);
    }
    return transport;
  }

  @Override
  protected JettyHttpClientBuilder newInstance(JettyHttpClientFactory clientFactory) {
    return new JettyHttpClientBuilder(clientFactory);
  }

  @Override
  public Duration getReadTimeout() {
    return Optional.ofNullable(readTimeout).orElse(Duration.ZERO);
  }

  @Override
  public Duration getWriteTimeout() {
    return Optional.ofNullable(writeTimeout).orElse(Duration.ZERO);
  }

  @Override
  public Duration getConnectTimeout() {
    return Optional.ofNullable(connectTimeout).orElse(Duration.ZERO);
  }
}
