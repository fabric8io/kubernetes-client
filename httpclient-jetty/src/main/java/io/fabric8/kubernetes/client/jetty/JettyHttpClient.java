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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.InputStreamRequestContent;
import org.eclipse.jetty.client.util.StringRequestContent;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static io.fabric8.kubernetes.client.http.BufferUtil.copy;
import static io.fabric8.kubernetes.client.http.StandardMediaTypes.APPLICATION_OCTET_STREAM;
import static io.fabric8.kubernetes.client.http.StandardMediaTypes.TEXT_PLAIN;

public class JettyHttpClient implements io.fabric8.kubernetes.client.http.HttpClient {

  private final HttpClient jetty;
  private final WebSocketClient jettyWs;
  private final Collection<Interceptor> interceptors;
  private final JettyHttpClientBuilder builder;
  private final JettyHttpClientFactory factory;
  private final Config config;

  public JettyHttpClient(JettyHttpClientBuilder builder, HttpClient httpClient, WebSocketClient webSocketClient,
      Collection<Interceptor> interceptors, JettyHttpClientFactory jettyHttpClientFactory, Config config) {
    this.builder = builder;
    this.jetty = httpClient;
    this.jettyWs = webSocketClient;
    this.interceptors = interceptors;
    this.factory = jettyHttpClientFactory;
    this.config = config;
  }

  @Override
  public void close() {
    try {
      jetty.stop();
      jettyWs.stop();
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public DerivedClientBuilder newBuilder() {
    return builder.copy(this);
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(
      HttpRequest originalRequest, AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    final var request = toStandardHttpRequest(originalRequest);
    final var future = new JettyAsyncResponseListener(request) {

      @Override
      protected void onContent(ByteBuffer content) throws Exception {
        // we must clone as the buffer can be reused by the byte consumer
        consumer.consume(Collections.singletonList(copy(content)), this);
      }
    }.listen(newRequest(request));
    return interceptResponse(request.toBuilder(), future, r -> consumeBytes(r, consumer));
  }

  @Override
  public WebSocket.Builder newWebSocketBuilder() {
    return new JettyWebSocketBuilder(jettyWs, builder.getReadTimeout());
  }

  @Override
  public HttpRequest.Builder newHttpRequestBuilder() {
    return new StandardHttpRequest.Builder();
  }

  public Factory getFactory() {
    return factory;
  }

  private Request newRequest(StandardHttpRequest originalRequest) {
    try {
      jetty.start();
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    final var requestBuilder = originalRequest.toBuilder();
    interceptors.forEach(i -> Interceptor.useConfig(i, config).before(requestBuilder, originalRequest));
    final var request = requestBuilder.build();

    var jettyRequest = jetty.newRequest(request.uri()).method(request.method());
    jettyRequest.timeout(builder.getReadTimeout().toMillis() + builder.getWriteTimeout().toMillis(), TimeUnit.MILLISECONDS);
    jettyRequest.headers(m -> request.headers().forEach((k, l) -> l.forEach(v -> m.add(k, v))));

    final var contentType = request.headers("Content-Type").stream().findAny();
    if (request.bodyString() != null) {
      jettyRequest.body(new StringRequestContent(contentType.orElse(TEXT_PLAIN), request.bodyString()));
    } else if (request.bodyStream() != null) {
      jettyRequest.body(new InputStreamRequestContent(contentType.orElse(APPLICATION_OCTET_STREAM), request.bodyStream()));
    }
    return jettyRequest;
  }

  private <T> CompletableFuture<HttpResponse<T>> interceptResponse(
      StandardHttpRequest.Builder builder, CompletableFuture<HttpResponse<T>> originalResponse,
      Function<HttpRequest, CompletableFuture<HttpResponse<T>>> function) {
    for (var interceptor : interceptors) {
      originalResponse = originalResponse.thenCompose(r -> {
        if (!r.isSuccessful()) {
          return Interceptor.useConfig(interceptor, config).afterFailure(builder, r)
              .thenCompose(b -> {
                if (Boolean.TRUE.equals(b)) {
                  return function.apply(builder.build());
                }
                return CompletableFuture.completedFuture(r);
              });
        }
        return CompletableFuture.completedFuture(r);
      });
    }
    return originalResponse;
  }

  private static StandardHttpRequest toStandardHttpRequest(HttpRequest request) {
    if (!(request instanceof StandardHttpRequest)) {
      throw new IllegalArgumentException("Only StandardHttpRequest is supported");
    }
    return (StandardHttpRequest) request;
  }

  HttpClient getJetty() {
    return jetty;
  }

  WebSocketClient getJettyWs() {
    return jettyWs;
  }

}
