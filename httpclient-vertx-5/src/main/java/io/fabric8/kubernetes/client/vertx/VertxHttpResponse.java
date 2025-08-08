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
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
import io.vertx.core.http.HttpClientResponse;

import java.util.Optional;

/**
 * Vert.x 5 implementation of {@link HttpResponse} for the Fabric8 Kubernetes Client.
 * 
 * <p>
 * Bridges Vert.x 5's {@link HttpClientResponse} with Fabric8's HTTP abstraction,
 * providing case-insensitive headers and async body streaming for Kubernetes operations
 * like pod logs, exec sessions, and watch operations.
 * 
 * <p>
 * Thread-safe and immutable once constructed. The {@link AsyncBody} must be
 * consumed or cancelled to prevent resource leaks.
 * 
 * @since 6.0.0
 */
public class VertxHttpResponse extends StandardHttpHeaders implements HttpResponse<AsyncBody> {
  /** The async body for streaming consumption. Must be consumed or cancelled. */
  private final AsyncBody result;

  /** The underlying Vert.x response providing status code and headers. */
  private final HttpClientResponse resp;

  /** The original request for correlation and debugging. */
  private final HttpRequest request;

  /**
   * Constructs a VertxHttpResponse bridging Vert.x 5 and Fabric8 client APIs.
   * Headers are converted to case-insensitive format.
   * 
   * @param result the async body, must be consumed or cancelled
   * @param resp the underlying Vert.x response
   * @param request the original request for correlation
   */
  VertxHttpResponse(AsyncBody result, HttpClientResponse resp, HttpRequest request) {
    super(VertxHttpRequest.toHeadersMap(resp.headers()));
    this.result = result;
    this.resp = resp;
    this.request = request;
  }

  /**
   * Returns the HTTP status code from the underlying Vert.x response.
   * 
   * @return the HTTP status code (e.g., 200, 404, 500)
   */
  @Override
  public int code() {
    return resp.statusCode();
  }

  /**
   * Returns the async response body for streaming consumption.
   * 
   * <p>
   * Provides non-blocking access with backpressure support, ideal for
   * streaming Kubernetes operations like pod logs, exec sessions, and watch operations.
   * The body must be consumed or cancelled to prevent resource leaks.
   * 
   * @return the async body for streaming data consumption
   */
  @Override
  public AsyncBody body() {
    return result;
  }

  /**
   * Returns the original HTTP request that initiated this response.
   * Useful for debugging, correlation, and retry logic.
   * 
   * @return the original HTTP request
   */
  @Override
  public HttpRequest request() {
    return request;
  }

  /**
   * Returns the previous response in an HTTP redirect chain.
   * 
   * <p>
   * Currently always returns empty as redirect chain tracking is not implemented.
   * Redirects are rare in Kubernetes API contexts.
   * 
   * @return empty Optional
   */
  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return Optional.empty();
  }
}
