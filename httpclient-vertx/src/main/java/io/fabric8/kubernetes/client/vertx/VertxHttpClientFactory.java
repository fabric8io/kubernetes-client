package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.ByteArrayBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.InputStreamBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.StringBodyContent;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.http.WebSocketConnectOptions;
import io.vertx.core.net.KeyCertOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.net.TrustOptions;
import io.vertx.ext.web.client.WebClientOptions;

import javax.net.ssl.X509KeyManager;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class VertxHttpClientFactory implements io.fabric8.kubernetes.client.http.HttpClient.Factory {

  private Vertx vertx;

  public VertxHttpClientFactory() {
    this.vertx = Vertx.vertx();
  }

  private final class VertxHttpClientBuilder extends StandardHttpClientBuilder<VertxHttpClient, VertxHttpClientFactory, VertxHttpClientBuilder> {

    protected VertxHttpClientBuilder(VertxHttpClientFactory clientFactory) {
      super(clientFactory);
    }

    @Override
    public VertxHttpClient build() {
      // TODO connection limits

      WebClientOptions options = new WebClientOptions();

      options.setIdleTimeoutUnit(TimeUnit.SECONDS);

      if (this.connectTimeout != null) {
        options.setConnectTimeout((int)this.connectTimeout.toMillis());
      }

      if (this.writeTimeout != null) {
        options.setWriteIdleTimeout((int)this.writeTimeout.getSeconds());
      }

      if (this.followRedirects) {
        options.setFollowRedirects(followRedirects);
      }

      if (this.proxyAddress != null) {
        // TODO separate username and password
        options.setProxyOptions(new ProxyOptions().setHost(this.proxyAddress.getHostName()).setPort(this.proxyAddress.getPort()).setType(ProxyType.HTTP).setUsername(proxyAuthorization));
      }

      if (tlsVersions != null && tlsVersions.length > 0) {
        Stream.of(tlsVersions).map(TlsVersion::javaName).forEach(tls -> options.addEnabledSecureTransportProtocol(tls));
      }

      if (this.preferHttp11) {
        options.setProtocolVersion(HttpVersion.HTTP_1_1);
      }

      if (this.sslContext != null) {
        options.setSsl(true);
        /*options.setSslEngineOptions(new JdkSSLEngineOptions() {
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
        });*/
        // TODO validate how ssl is configured
        if (this.trustManagers != null) {
          options.setTrustOptions(TrustOptions.wrap(trustManagers[0]));
        }
        if (this.keyManagers != null) {
          options.setKeyCertOptions(KeyCertOptions.wrap((X509KeyManager) keyManagers[0]));
        }
      }

      // track derived clients to clean up properly
      VertxHttpClient result = new VertxHttpClient(this, options);
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

    private VertxHttpClient(VertxHttpClientBuilder vertxHttpClientBuilder, WebClientOptions options) {
      super(vertxHttpClientBuilder);
      this.client = vertx.createHttpClient(options);
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

      Future<WebSocketResponse> map = client
          .webSocket(options)
          .map(ws -> {
            VertxWebSocket ret = new VertxWebSocket(ws, listener);
            ret.init();
            return new WebSocketResponse(ret, null);
          }).otherwise(t -> {
            if (t instanceof WebSocketHandshakeException) {
              WebSocketHandshakeException handshake = (WebSocketHandshakeException)t;
              // TODO: create WebSocketHandshakeException when appropriate
            }
            return new WebSocketResponse(null, null);
          });
      return map.toCompletionStage().toCompletableFuture();
    }

    @Override
    public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
        Consumer<List<ByteBuffer>> consumer) {

      RequestOptions options = new RequestOptions();

      request.headers().forEach((k, l) -> l.forEach(v -> options.addHeader(k, v)));
      options.setAbsoluteURI(request.uri().toString());
      options.setMethod(HttpMethod.valueOf(request.method()));
      Buffer bodyBuffer = null;

      Optional.ofNullable(request.getContentType()).ifPresent(s -> options.putHeader(io.vertx.core.http.HttpHeaders.CONTENT_TYPE, s));

      BodyContent body = request.body();
      if (body != null) {
        if (body instanceof StringBodyContent) {
          bodyBuffer = Buffer.buffer(((StringBodyContent) body).getContent());
        } else if (body instanceof ByteArrayBodyContent) {
          bodyBuffer = Buffer.buffer(((ByteArrayBodyContent) body).getContent());
        } else if (body instanceof InputStreamBodyContent) {
          InputStreamBodyContent bodyContent = (InputStreamBodyContent) body;

          // The client calling logic supports two calls here, the user passing in an arbitrary inputstream
          // or a file - we could split off the file handling

          // TODO the inputstream seems problematic - seems like it needs converted into a ReadStream

          throw new UnsupportedOperationException();
        } else {
          throw new AssertionError("Unsupported body content");
        }
      }

      if (request.isExpectContinue()) {
        // TODO: determine if this is enforced by the client
        // seems like a continue handler is needed
        options.putHeader(io.vertx.core.http.HttpHeaders.EXPECT, io.vertx.core.http.HttpHeaders.CONTINUE);
      }

      return new VertxHttpRequest(options, bodyBuffer).consumeBytes(this.client, consumer);
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