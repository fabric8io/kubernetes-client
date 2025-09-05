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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.streams.ReadStream;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Vert.x HTTP request implementation that bridges Fabric8's StandardHttpRequest to Vert.x HttpClient.
 * Handles various body content types and provides async response processing with back-pressure control.
 */
class VertxHttpRequest {

  /** Vert.x instance for async operations */
  final Vertx vertx;
  /** HTTP request options including URL, method, headers */
  private final RequestOptions options;
  /** Source request containing body and metadata */
  private final StandardHttpRequest request;

  /**
   * Creates a new Vert.x HTTP request wrapper.
   * 
   * @param vertx Vert.x instance for async operations
   * @param options HTTP request options (URL, method, headers)
   * @param request source request with body and metadata
   */
  public VertxHttpRequest(Vertx vertx, RequestOptions options, StandardHttpRequest request) {
    this.vertx = vertx;
    this.options = options;
    this.request = request;
  }

  /**
   * Executes the HTTP request asynchronously and returns a response with streaming body support.
   * 
   * @param client HTTP client to use for the request
   * @param consumer consumer for processing response body chunks
   * @return CompletableFuture containing the HTTP response with async body
   */
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpClient client,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    return client.request(options)
        .compose(req -> {
          // If the caller asked for 100‑continue semantics we first flush the headers,
          // wait for the server to acknowledge, then stream the body.
          if (request.isExpectContinue()) {
            io.vertx.core.Promise<HttpClientResponse> promise = io.vertx.core.Promise.promise();

            // Vert.x will invoke this handler when the server replies with 100-Continue
            req.continueHandler(v -> sendBody(req, request.body()).onComplete(promise));

            // Send just the headers – body will follow from the handler above
            req.sendHead().onFailure(promise::fail);

            return promise.future();
          }

          // Normal request – send headers and body in one go
          return sendBody(req, request.body());
        })
        .map(resp -> toFabricResponse(resp, consumer))
        .toCompletionStage()
        .toCompletableFuture();
  }

  /**
   * Sends the HTTP request with the appropriate body content type.
   * Supports string, byte array, and input stream body content.
   * 
   * @param req the Vert.x HTTP client request
   * @param body the body content to send, or null for no body
   * @return Future containing the HTTP response
   */
  private Future<HttpClientResponse> sendBody(HttpClientRequest req, BodyContent body) {
    if (body == null) {
      return req.send();
    }

    if (body instanceof StandardHttpRequest.StringBodyContent) {
      StandardHttpRequest.StringBodyContent s = (StandardHttpRequest.StringBodyContent) body;
      return req.send(Buffer.buffer(s.getContent()));
    }
    if (body instanceof StandardHttpRequest.ByteArrayBodyContent) {
      StandardHttpRequest.ByteArrayBodyContent b = (StandardHttpRequest.ByteArrayBodyContent) body;
      return req.send(Buffer.buffer(b.getContent()));
    }
    if (body instanceof StandardHttpRequest.InputStreamBodyContent) {
      StandardHttpRequest.InputStreamBodyContent i = (StandardHttpRequest.InputStreamBodyContent) body;
      InputStream is = i.getContent();
      ReadStream<Buffer> stream = new InputStreamReadStream(this, is, req);
      return req.send(stream);
    }
    return Future.failedFuture(new IllegalArgumentException("Unsupported body content: " + body.getClass()));
  }

  /**
   * Converts a Vert.x HTTP response to Fabric8's HttpResponse with async body support.
   * Pauses the response stream initially to allow back-pressure control from the AsyncBody.
   * 
   * @param resp the Vert.x HTTP response
   * @param consumer consumer for processing response body chunks
   * @return HttpResponse with async body bridge
   */
  private HttpResponse<AsyncBody> toFabricResponse(HttpClientResponse resp,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {

    resp.pause(); // we drive back‑pressure from the AsyncBody
    VertxAsyncBody asyncBody = new VertxAsyncBody(resp, consumer);
    return new VertxHttpResponse(asyncBody, resp, request);
  }

  /**
   * Converts Vert.x MultiMap headers to standard Map<String, List<String>> format.
   * Preserves multiple values for the same header key.
   * 
   * @param multiMap Vert.x MultiMap containing headers
   * @return Map with header names as keys and value lists
   */
  static Map<String, List<String>> toHeadersMap(MultiMap multiMap) {
    Map<String, List<String>> headers = new LinkedHashMap<>();
    multiMap.names().forEach(k -> headers.put(k, multiMap.getAll(k)));
    return headers;
  }
}
