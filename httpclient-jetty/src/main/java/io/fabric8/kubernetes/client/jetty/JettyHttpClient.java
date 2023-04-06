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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.ByteArrayBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.InputStreamBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.StringBodyContent;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.utils.Utils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.BytesRequestContent;
import org.eclipse.jetty.client.util.InputStreamRequestContent;
import org.eclipse.jetty.client.util.StringRequestContent;
import org.eclipse.jetty.websocket.api.exceptions.UpgradeException;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.http.BufferUtil.copy;
import static io.fabric8.kubernetes.client.http.StandardMediaTypes.APPLICATION_OCTET_STREAM;
import static io.fabric8.kubernetes.client.http.StandardMediaTypes.TEXT_PLAIN;

public class JettyHttpClient extends StandardHttpClient<JettyHttpClient, JettyHttpClientFactory, JettyHttpClientBuilder> {

  private final HttpClient jetty;
  private final WebSocketClient jettyWs;

  public JettyHttpClient(StandardHttpClientBuilder<JettyHttpClient, JettyHttpClientFactory, JettyHttpClientBuilder> builder,
      HttpClient jetty, WebSocketClient jettyWs) {
    super(builder);
    this.jetty = jetty;
    this.jettyWs = jettyWs;
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
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      Consumer<List<ByteBuffer>> consumer) {
    return new JettyAsyncResponseListener(request) {

      @Override
      protected void onContent(ByteBuffer content) throws Exception {
        // we must clone as the buffer can be reused by the byte consumer
        consumer.consume(Collections.singletonList(copy(content)), this);
      }
    }.listen(newRequest(request));
  }

  private Request newRequest(StandardHttpRequest originalRequest) {
    try {
      jetty.start();
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    final var requestBuilder = originalRequest.newBuilder();
    final var request = requestBuilder.build();

    var jettyRequest = jetty.newRequest(request.uri()).method(request.method());
    jettyRequest.timeout(builder.getReadTimeout().toMillis() + builder.getWriteTimeout().toMillis(), TimeUnit.MILLISECONDS);
    jettyRequest.headers(m -> request.headers().forEach((k, l) -> l.forEach(v -> m.add(k, v))));

    final var contentType = Optional.ofNullable(request.getContentType());

    BodyContent body = request.body();
    if (body != null) {
      if (body instanceof StringBodyContent) {
        jettyRequest.body(new StringRequestContent(contentType.orElse(TEXT_PLAIN), ((StringBodyContent) body).getContent()));
      } else if (body instanceof ByteArrayBodyContent) {
        jettyRequest.body(
            new BytesRequestContent(contentType.orElse(APPLICATION_OCTET_STREAM), ((ByteArrayBodyContent) body).getContent()));
      } else if (body instanceof InputStreamBodyContent) {
        InputStreamBodyContent bodyContent = (InputStreamBodyContent) body;
        if (bodyContent.getLength() >= 0) {
          jettyRequest.headers(m -> m.put(StandardHttpHeaders.CONTENT_LENGTH, Long.toString(bodyContent.getLength())));
        }
        jettyRequest
            .body(new InputStreamRequestContent(contentType.orElse(APPLICATION_OCTET_STREAM), bodyContent.getContent()));
      } else {
        throw new AssertionError("Unsupported body content");
      }
    }

    if (request.isExpectContinue()) {
      jettyRequest.headers(m -> m.put(StandardHttpHeaders.EXPECT, StandardHttpHeaders.EXPECT_CONTINUE));
    }

    return jettyRequest;
  }

  @Override
  public CompletableFuture<WebSocketResponse> buildWebSocketDirect(StandardWebSocketBuilder standardWebSocketBuilder,
      Listener listener) {
    try {
      jettyWs.start();
      final HttpRequest request = standardWebSocketBuilder.asHttpRequest();
      final ClientUpgradeRequest cur = new ClientUpgradeRequest();
      if (Utils.isNotNullOrEmpty(standardWebSocketBuilder.getSubprotocol())) {
        cur.setSubProtocols(standardWebSocketBuilder.getSubprotocol());
      }
      cur.setHeaders(request.headers());
      if (builder.getReadTimeout() != null) {
        cur.setTimeout(builder.getReadTimeout().toMillis(), TimeUnit.MILLISECONDS);
      }
      // Extra-future required because we can't Map the UpgradeException to a WebSocketHandshakeException easily
      final CompletableFuture<WebSocketResponse> future = new CompletableFuture<>();
      final JettyWebSocket webSocket = new JettyWebSocket(listener);
      jettyWs.connect(webSocket, Objects.requireNonNull(WebSocket.toWebSocketUri(request.uri())), cur)
          .whenComplete((s, ex) -> {
            if (ex != null) {
              if (ex instanceof CompletionException && ex.getCause() instanceof UpgradeException) {
                future.complete(JettyWebSocket.toWebSocketResponse(request, webSocket, (UpgradeException) ex.getCause()));
              } else if (ex instanceof UpgradeException) {
                future.complete(JettyWebSocket.toWebSocketResponse(request, webSocket, (UpgradeException) ex));
              } else {
                future.completeExceptionally(ex);
              }
            } else {
              future.complete(JettyWebSocket.toWebSocketResponse(request, webSocket, s));
            }
          });
      return future;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  HttpClient getJetty() {
    return jetty;
  }

  WebSocketClient getJettyWs() {
    return jettyWs;
  }

}
