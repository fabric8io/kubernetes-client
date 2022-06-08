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

import io.fabric8.kubernetes.client.http.HttpClient.Builder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.internal.SSLUtils;
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

import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class JettyHttpClientBuilder extends DerivedJettyHttpClientBuilder<JettyHttpClientBuilder>
    implements Builder {

  private Duration connectTimeout;
  private SSLContext sslContext;
  private boolean followAllRedirects;
  private Origin.Address proxyAddress;
  private String proxyAuthorization;
  private TlsVersion[] tlsVersions;
  // TODO: HTTP2 disabled, MockWebServer support is limited and requires changes
  // Enable (preferHttp11->false) the feature after fixing MockWebServer
  private boolean preferHttp11 = true;
  private HttpClient sharedHttpClient;
  private WebSocketClient sharedWebSocketClient;

  public JettyHttpClientBuilder(JettyHttpClientFactory factory) {
    super(factory);
  }

  @Override
  public JettyHttpClient build() {
    if (sharedHttpClient != null) {
      return new JettyHttpClient(this, sharedHttpClient, sharedWebSocketClient, interceptors.values(), factory);
    }
    final var sslContextFactory = new SslContextFactory.Client();
    if (sslContext != null) {
      sslContextFactory.setSslContext(sslContext);
    }
    if (tlsVersions != null && tlsVersions.length > 0) {
      sslContextFactory.setIncludeProtocols(Stream.of(tlsVersions).map(TlsVersion::javaName).toArray(String[]::new));
    }
    sharedHttpClient = new HttpClient(newTransport(sslContextFactory, preferHttp11));
    sharedWebSocketClient = new WebSocketClient(new HttpClient(newTransport(sslContextFactory, preferHttp11)));
    sharedWebSocketClient.setIdleTimeout(Duration.ZERO);
    if (connectTimeout != null) {
      sharedHttpClient.setConnectTimeout(connectTimeout.toMillis());
      sharedWebSocketClient.setConnectTimeout(connectTimeout.toMillis());
    }
    sharedHttpClient.setFollowRedirects(followAllRedirects);
    if (proxyAddress != null) {
      sharedHttpClient.getProxyConfiguration().getProxies().add(new HttpProxy(proxyAddress, false));
    }
    if (proxyAddress != null && proxyAuthorization != null) {
      sharedHttpClient.getRequestListeners().add(new Request.Listener.Adapter() {
        @Override
        public void onBegin(Request request) {
          request.headers(h -> h.put("Proxy-Authorization", proxyAuthorization));
        }
      });
    }
    return new JettyHttpClient(this, sharedHttpClient, sharedWebSocketClient, interceptors.values(), factory);
  }

  @Override
  public JettyHttpClientBuilder connectTimeout(long connectTimeout, TimeUnit unit) {
    this.connectTimeout = Duration.ofNanos(unit.toNanos(connectTimeout));
    return this;
  }

  @Override
  public JettyHttpClientBuilder sslContext(KeyManager[] keyManagers, TrustManager[] trustManagers) {
    this.sslContext = SSLUtils.sslContext(keyManagers, trustManagers);
    return this;
  }

  @Override
  public JettyHttpClientBuilder followAllRedirects() {
    followAllRedirects = true;
    return this;
  }

  @Override
  public JettyHttpClientBuilder proxyAddress(InetSocketAddress proxyAddress) {
    if (proxyAddress == null) {
      this.proxyAddress = null;
    } else {
      this.proxyAddress = new Origin.Address(proxyAddress.getHostString(), proxyAddress.getPort());
    }
    return this;
  }

  @Override
  public JettyHttpClientBuilder proxyAuthorization(String credentials) {
    proxyAuthorization = credentials;
    return this;
  }

  @Override
  public JettyHttpClientBuilder tlsVersions(TlsVersion... tlsVersions) {
    this.tlsVersions = tlsVersions;
    return this;
  }

  @Override
  public JettyHttpClientBuilder preferHttp11() {
    preferHttp11 = true;
    return this;
  }

  public Builder copy() {
    final var ret = new JettyHttpClientBuilder(factory);
    ret.sharedHttpClient = sharedHttpClient;
    ret.sharedWebSocketClient = sharedWebSocketClient;
    ret.readTimeout = readTimeout;
    ret.writeTimeout = writeTimeout;
    ret.interceptors.putAll(interceptors);
    ret.connectTimeout = connectTimeout;
    ret.sslContext = sslContext;
    ret.followAllRedirects = followAllRedirects;
    ret.proxyAddress = proxyAddress;
    ret.proxyAuthorization = proxyAuthorization;
    ret.tlsVersions = tlsVersions;
    ret.preferHttp11 = preferHttp11;
    return ret;
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
}
