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

package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import io.netty.handler.ssl.JdkSslContext;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.http.UpgradeRejectedException;
import io.vertx.core.http.WebSocketConnectOptions;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.spi.tls.SslContextFactory;
import io.vertx.ext.web.client.WebClientOptions;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class VertxHttpClientFactory implements io.fabric8.kubernetes.client.http.HttpClient.Factory {

  private static final int MAX_CONNECTIONS = 8192;

  private Vertx vertx;

  public VertxHttpClientFactory() {
    this.vertx = Vertx.vertx();
  }

  private final class VertxHttpClientBuilder
      extends StandardHttpClientBuilder<VertxHttpClient, VertxHttpClientFactory, VertxHttpClientBuilder> {

    protected VertxHttpClientBuilder(VertxHttpClientFactory clientFactory) {
      super(clientFactory);
    }

    @Override
    public VertxHttpClient build() {
      // TODO connection limits

      WebClientOptions options = new WebClientOptions();

      options.setMaxPoolSize(MAX_CONNECTIONS);
      options.setMaxWebSockets(MAX_CONNECTIONS);
      options.setIdleTimeoutUnit(TimeUnit.SECONDS);

      if (this.connectTimeout != null) {
        options.setConnectTimeout((int) this.connectTimeout.toMillis());
      }

      if (this.writeTimeout != null) {
        options.setWriteIdleTimeout((int) this.writeTimeout.getSeconds());
      }

      if (this.followRedirects) {
        options.setFollowRedirects(followRedirects);
      }

      if (this.proxyAddress != null) {
        ProxyOptions proxyOptions = new ProxyOptions()
            .setHost(this.proxyAddress.getHostName())
            .setPort(this.proxyAddress.getPort())
            .setType(ProxyType.HTTP);
        options.setProxyOptions(proxyOptions);
      }

      if (tlsVersions != null && tlsVersions.length > 0) {
        Stream.of(tlsVersions).map(TlsVersion::javaName).forEach(tls -> options.addEnabledSecureTransportProtocol(tls));
      }

      if (this.preferHttp11) {
        options.setProtocolVersion(HttpVersion.HTTP_1_1);
      }

      if (this.sslContext != null) {
        options.setSsl(true);
        options.setSslEngineOptions(new JdkSSLEngineOptions() {
          @Override
          public JdkSSLEngineOptions copy() {
            return this;
          }

          @Override
          public SslContextFactory sslContextFactory() {
            return () -> new JdkSslContext(
                sslContext,
                true,
                null,
                IdentityCipherSuiteFilter.INSTANCE,
                ApplicationProtocolConfig.DISABLED,
                io.netty.handler.ssl.ClientAuth.NONE,
                null,
                false);
          }
        });
      }

      // track derived clients to clean up properly
      VertxHttpClient result = new VertxHttpClient(this, options, proxyAddress != null ? proxyAuthorization : null);
      if (this.client != null) {
        this.client.derivedClients.add(result);
      }
      return result;
    }

    @Override
    protected VertxHttpClientBuilder newInstance(VertxHttpClientFactory clientFactory) {
      return new VertxHttpClientBuilder(clientFactory);
    }

  }

  private class VertxHttpClient extends StandardHttpClient<VertxHttpClient, VertxHttpClientFactory, VertxHttpClientBuilder> {

    private List<VertxHttpClient> derivedClients = Collections.synchronizedList(new ArrayList<>());
    final private HttpClient client;
    private final String proxyAuthorization;

    private VertxHttpClient(VertxHttpClientBuilder vertxHttpClientBuilder, WebClientOptions options,
        String proxyAuthorization) {
      super(vertxHttpClientBuilder);
      this.client = vertx.createHttpClient(options);
      this.proxyAuthorization = proxyAuthorization;
    }

    @Override
    public CompletableFuture<WebSocketResponse> buildWebSocketDirect(StandardWebSocketBuilder standardWebSocketBuilder,
        Listener listener) {
      WebSocketConnectOptions options = new WebSocketConnectOptions();

      if (builder.getReadTimeout() != null) {
        options.setTimeout(builder.getReadTimeout().toMillis());
      }

      if (standardWebSocketBuilder.getSubprotocol() != null) {
        options.setSubProtocols(Collections.singletonList(standardWebSocketBuilder.getSubprotocol()));
      }

      StandardHttpRequest request = standardWebSocketBuilder.asHttpRequest();

      request.headers().entrySet().stream()
          .forEach(e -> e.getValue().stream().forEach(v -> options.addHeader(e.getKey(), v)));
      options.setAbsoluteURI(request.uri().toString());

      CompletableFuture<WebSocketResponse> response = new CompletableFuture<WebSocketResponse>();

      client
          .webSocket(options)
          .onSuccess(ws -> {
            VertxWebSocket ret = new VertxWebSocket(ws, listener);
            ret.init();
            response.complete(new WebSocketResponse(ret, null));
          }).onFailure(t -> {
            if (t instanceof UpgradeRejectedException) {
              UpgradeRejectedException handshake = (UpgradeRejectedException) t;
              response.complete(new WebSocketResponse(null,
                  new io.fabric8.kubernetes.client.http.WebSocketHandshakeException(new HttpResponse<String>() {
                    @Override
                    public int code() {
                      return handshake.getStatus();
                    }

                    @Override
                    public String body() {
                      return handshake.getBody().toString();
                    }

                    @Override
                    public HttpRequest request() {
                      throw new UnsupportedOperationException();
                    }

                    @Override
                    public Optional<HttpResponse<?>> previousResponse() {
                      return Optional.empty();
                    }

                    @Override
                    public List<String> headers(String s) {
                      return handshake.getHeaders().getAll(s);
                    }

                    @Override
                    public Map<String, List<String>> headers() {
                      Map<String, List<String>> headers = new LinkedHashMap<>();
                      handshake.getHeaders().names().forEach(name -> {
                        headers.put(name, handshake.getHeaders().getAll(name));
                      });
                      return headers;
                    }
                  })));
            }
            response.completeExceptionally(t);
          });
      return response;
    }

    @Override
    public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
        Consumer<List<ByteBuffer>> consumer) {

      RequestOptions options = new RequestOptions();

      request.headers().forEach((k, l) -> l.forEach(v -> options.addHeader(k, v)));
      options.setAbsoluteURI(request.uri().toString());
      options.setMethod(HttpMethod.valueOf(request.method()));

      // Proxy authorization is handled manually since the proxyAuthorization value is the actual header
      if (proxyAuthorization != null) {
        options.putHeader(HttpHeaders.PROXY_AUTHORIZATION, proxyAuthorization);
      }

      Optional.ofNullable(request.getContentType())
          .ifPresent(s -> options.putHeader(io.vertx.core.http.HttpHeaders.CONTENT_TYPE, s));

      if (request.isExpectContinue()) {
        // TODO: determine if this is enforced by the client
        // seems like a continue handler is needed
        options.putHeader(io.vertx.core.http.HttpHeaders.EXPECT, io.vertx.core.http.HttpHeaders.CONTINUE);
      }

      return new VertxHttpRequest(vertx, options, request.body()).consumeBytes(this.client, consumer);
    }

    @Override
    public void close() {
      client.close();
      synchronized (derivedClients) {
        derivedClients.forEach(VertxHttpClient::close);
        derivedClients.clear();
      }
    }

  }

  @Override
  public VertxHttpClientBuilder newBuilder() {
    return new VertxHttpClientBuilder(this);
  }

}
