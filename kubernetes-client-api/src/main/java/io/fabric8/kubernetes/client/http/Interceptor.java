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

package io.fabric8.kubernetes.client.http;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Interceptor {

  interface RequestTags {

    <T> T getTag(Class<T> type);

  }

  /**
   * Called before a request to allow for the manipulation of the request
   *
   * @param builder used to modify the request
   * @param request the current request
   */
  default void before(BasicBuilder builder, HttpRequest request, RequestTags tags) {
  }

  /**
   * Called after a non-WebSocket HTTP response is received. The body might or might not be already consumed.
   * <p>
   * Should be used to analyze response codes and headers, original response shouldn't be altered.
   *
   * @param request the original request sent to the server.
   * @param response the response received from the server.
   */
  default void after(HttpRequest request, HttpResponse<?> response) {

  }

  // In case we want to encapsulate to spy the responses from the server

  /**
   * Called before a request to allow the encapsulation of the provided consumer.
   * <p>
   *
   * @param consumer the original consumer.
   * @param request the HTTP request.
   * @return the consumer to use.
   */
  default AsyncBody.Consumer<List<ByteBuffer>> consumer(AsyncBody.Consumer<List<ByteBuffer>> consumer, HttpRequest request) {
    return consumer;
  }

  /**
   * Called after a websocket failure or by default from a normal request
   *
   * @param builder used to modify the request
   * @param response the failed response
   * @return true if the builder should be used to execute a new request
   */
  default CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response, RequestTags tags) {
    return CompletableFuture.completedFuture(false);
  }

  /**
   * Called after a non-websocket failure
   *
   * @param builder used to modify the request
   * @param response the failed response
   * @return true if the builder should be used to execute a new request
   */
  default CompletableFuture<Boolean> afterFailure(HttpRequest.Builder builder, HttpResponse<?> response, RequestTags tags) {
    return afterFailure((BasicBuilder) builder, response, tags);
  }

}
