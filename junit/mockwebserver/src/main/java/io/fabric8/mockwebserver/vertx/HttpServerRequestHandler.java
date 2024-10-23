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
package io.fabric8.mockwebserver.vertx;

import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.http.Headers;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

import java.util.Locale;

public abstract class HttpServerRequestHandler implements Handler<HttpServerRequest> {

  private static final String CONTENT_LENGTH = "Content-Length";
  private static final String CONTENT_TYPE = "Content-Type";

  private final Vertx vertx;

  protected HttpServerRequestHandler(Vertx vertx) {
    this.vertx = vertx;
  }

  protected abstract MockResponse onHttpRequest(RecordedRequest request);

  @Override
  public final void handle(HttpServerRequest event) {
    final Handler<Throwable> exceptionHandler = err -> {
      if (!event.response().headWritten()) {
        event.response().setStatusCode(500).setStatusMessage(err.getMessage()).send();
      }
    };
    event.resume();
    final Future<io.vertx.core.buffer.Buffer> body;
    if (hasBody(event)) {
      body = event.body();
    } else {
      body = Future.succeededFuture(null);
    }
    body.onFailure(exceptionHandler);
    body.onSuccess(bodyBuffer -> {
      final RecordedRequest request = new RecordedRequest(
          event.version().alpnName().toUpperCase(Locale.ROOT),
          HttpMethod.fromVertx(event.method()),
          event.uri(),
          Headers.builder().addAll(event.headers()).build(),
          new io.fabric8.mockwebserver.http.Buffer(bodyBuffer == null ? null : bodyBuffer.getBytes()));
      final MockResponse mockResponse = onHttpRequest(request);
      // WebSocket
      if (mockResponse.getWebSocketListener() != null) {
        event.toWebSocket()
            .onFailure(exceptionHandler)
            .onSuccess(new ServerWebSocketHandler(request, mockResponse));
        return;
      }
      // Standard Http Response
      final HttpServerResponse vertxResponse = event.response();
      vertxResponse.setStatusCode(mockResponse.code());
      mockResponse.getHeaders().toMultimap().forEach((key, values) -> vertxResponse.headers().add(key, values));
      if (mockResponse.getBody() != null && mockResponse.getBody().size() > 0) {
        vertxResponse.headers().add(CONTENT_LENGTH, String.valueOf(mockResponse.getBody().size()));
        final io.vertx.core.buffer.Buffer toSend = io.vertx.core.buffer.Buffer.buffer(mockResponse.getBody().getBytes());
        if (mockResponse.getBodyDelay() != null) {
          vertx.setTimer(mockResponse.getBodyDelay().toMillis(), timerId -> vertxResponse.send(toSend));
        } else {
          vertxResponse.send(toSend);
        }
      } else {
        vertxResponse.end();
      }
    });

  }

  private static boolean hasBody(HttpServerRequest event) {
    final String contentLength = event.headers().get(CONTENT_LENGTH);
    if (contentLength != null && !contentLength.trim().isEmpty() && Integer.parseInt(contentLength) > 0) {
      return true;
    }
    return event.headers().contains(CONTENT_TYPE);
  }
}
