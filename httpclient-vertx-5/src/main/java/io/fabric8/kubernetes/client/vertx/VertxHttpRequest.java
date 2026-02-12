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
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
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
   * <p>
   * This method sets up response handlers BEFORE sending the request body to avoid a race condition
   * where the response body could be consumed and the response ended before handlers are attached.
   * This is critical in Vert.x 5 where responses with small/empty bodies can complete very quickly.
   *
   * @param client HTTP client to use for the request
   * @param consumer consumer for processing response body chunks
   * @return CompletableFuture containing the HTTP response with async body
   */
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpClient client,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    return client.request(options)
        .compose(req -> {
          final Promise<HttpResponse<AsyncBody>> promise = Promise.promise();

          // Set up response handler BEFORE sending the request body.
          // This ensures we can pause the response and set up handlers before any body data arrives.
          // Using req.response() instead of req.send().map() avoids the race condition where
          // the response body could be consumed before the map transformation runs.
          req.response()
              .onSuccess(resp -> {
                resp.pause(); // Immediately pause to prevent body consumption before handlers are set
                promise.complete(toFabricResponse(resp, consumer));
              })
              .onFailure(promise::fail);

          // If the caller asked for 100-continue semantics we first flush the headers,
          // wait for the server to acknowledge, then stream the body.
          if (request.isExpectContinue()) {
            req.continueHandler(v -> writeBody(req, request.body()));
            req.sendHead().onFailure(promise::fail);
          } else {
            // Normal request - send headers and body
            writeBody(req, request.body());
          }

          return promise.future();
        })
        .toCompletionStage()
        .toCompletableFuture();
  }

  /**
   * Writes the request body to the HTTP request.
   * For simple body types (null, String, byte[]), uses req.end() directly.
   * For InputStream bodies, uses req.send(ReadStream) which handles the streaming internally.
   * Note: For InputStream, this method returns after initiating the send - the response
   * will be handled by the response() future set up in consumeBytes().
   *
   * @param req the Vert.x HTTP client request
   * @param body the body content to send, or null for no body
   */
  private void writeBody(HttpClientRequest req, BodyContent body) {
    if (body == null) {
      req.end();
      return;
    }

    if (body instanceof StandardHttpRequest.StringBodyContent) {
      StandardHttpRequest.StringBodyContent s = (StandardHttpRequest.StringBodyContent) body;
      req.end(Buffer.buffer(s.getContent()));
      return;
    }
    if (body instanceof StandardHttpRequest.ByteArrayBodyContent) {
      StandardHttpRequest.ByteArrayBodyContent b = (StandardHttpRequest.ByteArrayBodyContent) body;
      req.end(Buffer.buffer(b.getContent()));
      return;
    }
    if (body instanceof StandardHttpRequest.InputStreamBodyContent) {
      StandardHttpRequest.InputStreamBodyContent i = (StandardHttpRequest.InputStreamBodyContent) body;
      InputStream is = i.getContent();
      ReadStream<Buffer> stream = new InputStreamReadStream(this, is, req);
      // Use send(ReadStream) which handles the streaming properly.
      // The response will be handled by the response() future already set up.
      req.send(stream);
      return;
    }
    req.reset(0L, new IllegalArgumentException("Unsupported body content: " + body.getClass()));
  }

  /**
   * Converts a Vert.x HTTP response to Fabric8's HttpResponse with async body support.
   * Note: The response must already be paused before calling this method.
   *
   * @param resp the Vert.x HTTP response (must be paused)
   * @param consumer consumer for processing response body chunks
   * @return HttpResponse with async body bridge
   */
  private HttpResponse<AsyncBody> toFabricResponse(HttpClientResponse resp,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
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
