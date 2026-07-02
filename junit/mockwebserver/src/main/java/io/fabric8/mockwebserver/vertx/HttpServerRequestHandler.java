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
  private static final String TRANSFER_ENCODING = "Transfer-Encoding";

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
    // A WebSocket upgrade must be performed synchronously from within the request handler, before
    // the request is read. Reading the (empty) body first and upgrading from the asynchronous body
    // callback makes Vert.x's HttpServerRequest#toWebSocket() intermittently throw
    // "Request has already been read" once the request end event has been processed on the event
    // loop. WebSocket upgrade requests never carry a body, so there is nothing to read here.
    if (isWebSocketUpgrade(event)) {
      final RecordedRequest request = toRecordedRequest(event, null);
      final MockResponse mockResponse = onHttpRequest(request);
      if (mockResponse.getWebSocketListener() != null) {
        event.toWebSocket()
            .onFailure(exceptionHandler)
            .onSuccess(new ServerWebSocketHandler(request, mockResponse));
        return;
      }
      // Not a WebSocket response after all; drain the request and reply as a standard HTTP
      // response. The failure handler is wired the same way as the regular path so that a body
      // read error surfaces as a 500 instead of being silently dropped.
      event.resume();
      final Future<io.vertx.core.buffer.Buffer> body = readBody(event);
      body.onFailure(exceptionHandler);
      body.onSuccess(ignored -> sendResponse(event, mockResponse));
      return;
    }
    event.resume();
    final Future<io.vertx.core.buffer.Buffer> body = readBody(event);
    body.onFailure(exceptionHandler);
    body.onSuccess(bodyBuffer -> {
      final RecordedRequest request = toRecordedRequest(event, bodyBuffer);
      final MockResponse mockResponse = onHttpRequest(request);
      // WebSocket
      if (mockResponse.getWebSocketListener() != null) {
        event.toWebSocket()
            .onFailure(exceptionHandler)
            .onSuccess(new ServerWebSocketHandler(request, mockResponse));
        return;
      }
      // Standard Http Response
      sendResponse(event, mockResponse);
    });

  }

  private RecordedRequest toRecordedRequest(HttpServerRequest event, io.vertx.core.buffer.Buffer bodyBuffer) {
    return new RecordedRequest(
        event.version().alpnName().toUpperCase(Locale.ROOT),
        HttpMethod.fromVertx(event.method()),
        event.uri(),
        Headers.builder().addAll(event.headers()).build(),
        new io.fabric8.mockwebserver.http.Buffer(bodyBuffer == null ? null : bodyBuffer.getBytes()));
  }

  private void sendResponse(HttpServerRequest event, MockResponse mockResponse) {
    final HttpServerResponse vertxResponse = event.response();
    vertxResponse.setStatusCode(mockResponse.code());
    mockResponse.getHeaders().toMultimap().forEach((key, values) -> vertxResponse.headers().add(key, values));
    if (mockResponse.getBody() != null && mockResponse.getBody().size() > 0) {
      if (!vertxResponse.headers().contains(TRANSFER_ENCODING)) {
        vertxResponse.headers().add(CONTENT_LENGTH, String.valueOf(mockResponse.getBody().size()));
      }
      final io.vertx.core.buffer.Buffer toSend = io.vertx.core.buffer.Buffer.buffer(mockResponse.getBody().getBytes());
      if (mockResponse.getBodyDelay() != null) {
        vertx.setTimer(mockResponse.getBodyDelay().toMillis(), timerId -> vertxResponse.send(toSend));
      } else {
        vertxResponse.send(toSend);
      }
    } else {
      vertxResponse.end();
    }
  }

  private static Future<io.vertx.core.buffer.Buffer> readBody(HttpServerRequest event) {
    return hasBody(event) ? event.body() : Future.succeededFuture(null);
  }

  private static boolean isWebSocketUpgrade(HttpServerRequest event) {
    final String upgrade = event.getHeader("Upgrade");
    return upgrade != null && upgrade.toLowerCase(Locale.ROOT).contains("websocket");
  }

  private static boolean hasBody(HttpServerRequest event) {
    final String contentLength = event.headers().get(CONTENT_LENGTH);
    if (contentLength != null && !contentLength.trim().isEmpty() && Integer.parseInt(contentLength) > 0) {
      return true;
    }
    return event.headers().contains(CONTENT_TYPE);
  }
}
