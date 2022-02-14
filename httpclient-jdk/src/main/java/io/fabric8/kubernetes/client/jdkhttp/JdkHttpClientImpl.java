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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.BodySubscribers;
import java.net.http.WebSocketHandshakeException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO:
 * - executorservice
 * - Mapping to a Reader is always UTF-8
 * - determine if write timeout should be implemented
 */
public class JdkHttpClientImpl implements HttpClient {

  private static class JdkHttpResponseImpl<T> implements HttpResponse<T> {

    private java.net.http.HttpResponse<T> response;

    public JdkHttpResponseImpl(java.net.http.HttpResponse<T> response) {
      this.response = response;
    }

    @Override
    public List<String> headers(String key) {
      return response.headers().allValues(key);
    }

    @Override
    public int code() {
      return response.statusCode();
    }

    @Override
    public T body() {
      return response.body();
    }

    @Override
    public HttpRequest request() {
      return new JdkHttpRequestImpl(null, response.request());
    }

    @Override
    public Optional<HttpResponse<T>> previousResponse() {
      return response.previousResponse().map(JdkHttpResponseImpl::new);
    }

  }

  private JdkHttpClientBuilderImpl builder;
  private java.net.http.HttpClient httpClient;

  public JdkHttpClientImpl(JdkHttpClientBuilderImpl builderImpl, java.net.http.HttpClient httpClient) {
    this.builder = builderImpl;
    this.httpClient = httpClient;
  }

  @Override
  public void close() {
    // nothing to do by default, but a custom factory may want to
    // take action
    builder.clientFactory.closeHttpClient(this);
  }

  @Override
  public DerivedClientBuilder newBuilder() {
    return this.builder.copy(httpClient);
  }

  @Override
  public <T> HttpResponse<T> send(HttpRequest request, Class<T> type) throws IOException {
    try {
      return sendAsync(request, type).get();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      InterruptedIOException ie = new InterruptedIOException();
      ie.initCause(e);
      throw ie;
    } catch (ExecutionException e) {
      InterruptedIOException ie = new InterruptedIOException();
      ie.initCause(e);
      throw ie;
    }
  }

  @Override
  public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, Class<T> type) {
    JdkHttpRequestImpl jdkRequest = (JdkHttpRequestImpl)request;
    JdkHttpRequestImpl.BuilderImpl builderImpl = jdkRequest.newBuilder();
    for (Interceptor interceptor : builder.interceptors.values()) {
      interceptor.before(builderImpl, jdkRequest);
      jdkRequest = builderImpl.build();
    }
    BodyHandler<T> bodyHandler;
    if (type == null) {
      bodyHandler = (BodyHandler<T>) BodyHandlers.discarding();
    } else if (type == InputStream.class) {
      bodyHandler = (BodyHandler<T>) BodyHandlers.ofInputStream();
    } else if (type == String.class) {
      bodyHandler = (BodyHandler<T>) BodyHandlers.ofString();
    } else {
      bodyHandler = (responseInfo) -> {
        BodySubscriber<InputStream> upstream = BodyHandlers.ofInputStream().apply(responseInfo);

        BodySubscriber<Reader> downstream = BodySubscribers.mapping(
            upstream,
            (InputStream is) -> new InputStreamReader(is, StandardCharsets.UTF_8));
        return (BodySubscriber<T>) downstream;
      };
    }

    CompletableFuture<java.net.http.HttpResponse<T>> cf = this.httpClient.sendAsync(builderImpl.build().request, bodyHandler);

    for (Interceptor interceptor : builder.interceptors.values()) {
      cf = cf.thenCompose(response -> {
        if (response != null && !HttpResponse.isSuccessful(response.statusCode())
            && interceptor.afterFailure(builderImpl, new JdkHttpResponseImpl<T>(response))) {
          return this.httpClient.sendAsync(builderImpl.build().request, bodyHandler);
        }
        return CompletableFuture.completedFuture(response);
      });
    }

    return cf.thenApply(JdkHttpResponseImpl::new);
  }

  @Override
  public io.fabric8.kubernetes.client.http.WebSocket.Builder newWebSocketBuilder() {
    return new JdkWebSocketImpl.BuilderImpl(this);
  }

  @Override
  public io.fabric8.kubernetes.client.http.HttpRequest.Builder newHttpRequestBuilder() {
    return new JdkHttpRequestImpl.BuilderImpl().timeout(this.builder.readTimeout);
  }

  /*
   * TODO: this may not be the best way to do this - in general
   * instead we create a reponse to hold them both
   */
  private static class WebSocketResponse {
    public WebSocketResponse(WebSocket w, java.net.http.WebSocketHandshakeException wshse) {
      this.webSocket = w;
      this.wshse = wshse;
    }
    WebSocket webSocket;
    java.net.http.WebSocketHandshakeException wshse;
  }

  public CompletableFuture<WebSocket> buildAsync(JdkWebSocketImpl.BuilderImpl webSocketBuilder, Listener listener) {
    JdkWebSocketImpl.BuilderImpl copy = webSocketBuilder.copy();

    for (Interceptor interceptor : builder.interceptors.values()) {
      interceptor.before(copy, new JdkHttpRequestImpl(null, copy.asRequest()));
    }

    CompletableFuture<WebSocket> result = new CompletableFuture<WebSocket>();

    CompletableFuture<WebSocketResponse> cf = internalBuildAsync(webSocketBuilder, listener);

    for (Interceptor interceptor : builder.interceptors.values()) {
      cf = cf.thenCompose((response) -> {
        if (response.wshse != null && response.wshse.getResponse() != null
            && interceptor.afterFailure(copy, new JdkHttpResponseImpl<>(response.wshse.getResponse()))) {
          return this.internalBuildAsync(webSocketBuilder, listener);
        }
        return CompletableFuture.completedFuture(response);
      });
    }

    // map back to the expected convention with the future completed by the response exception
    cf.whenComplete((r, t) -> {
      if (t != null) {
        result.completeExceptionally(t);
      } else if (r != null) {
        if (r.wshse != null) {
          result.completeExceptionally(new io.fabric8.kubernetes.client.http.WebSocketHandshakeException(
              new JdkHttpResponseImpl<>(r.wshse.getResponse())).initCause(r.wshse));
        } else {
          result.complete(r.webSocket);
        }
      } else {
        // shouldn't happen
        result.complete(null);
      }
    });

    return result;
  }

  /**
   * Convert the invocation of a JDK build async into a holder of both the exception and the response
   */
  public CompletableFuture<WebSocketResponse> internalBuildAsync(JdkWebSocketImpl.BuilderImpl webSocketBuilder, Listener listener) {
    java.net.http.HttpRequest request = webSocketBuilder.asRequest();
    java.net.http.WebSocket.Builder builder = this.httpClient.newWebSocketBuilder();
    request.headers().map().forEach((k, v) -> {
      v.forEach(s -> builder.header(k, s));
    });
    if (webSocketBuilder.subprotocol != null) {
      builder.subprotocols(webSocketBuilder.subprotocol);
    }
    // the Watch logic sets a websocketTimeout as the readTimeout
    // TODO: this should probably be made clearer in the docs
    if (this.builder.readTimeout != null) {
      builder.connectTimeout(this.builder.readTimeout);
    }

    AtomicLong queueSize = new AtomicLong();

    // use a responseholder to convey both the exception and the websocket
    CompletableFuture<WebSocketResponse> response = new CompletableFuture<JdkHttpClientImpl.WebSocketResponse>();

    URI uri = request.uri();
    if (uri.getScheme().startsWith("http")) {
      // the jdk logic expects a ws uri
      // after the https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8245245 it just does the reverse of this
      // to convert back to http(s) ...
      uri = URI.create("ws" + uri.toString().substring(4));
    }
    builder.buildAsync(uri, new JdkWebSocketImpl.ListenerAdapter(listener, queueSize)).whenComplete((w, t) -> {
      if (t instanceof CompletionException && t.getCause() != null) {
        t = t.getCause();
      }
      if (t instanceof java.net.http.WebSocketHandshakeException) {
        response.complete(new WebSocketResponse(new JdkWebSocketImpl(queueSize, w), (WebSocketHandshakeException)t));
      } else if (t != null) {
        response.completeExceptionally(t);
      } else {
        response.complete(new WebSocketResponse(new JdkWebSocketImpl(queueSize, w), null));
      }
    });

    return response;
  }

  public JdkHttpClientBuilderImpl getBuilder() {
    return builder;
  }

}
