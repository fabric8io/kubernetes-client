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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public interface Interceptor {

  /**
   * {@link Interceptor}s that rely upon the {@link Config}, in particular the {@link RequestConfig}, must implement
   * this method to receive the modified configuration
   *
   * @param config
   * @return
   */
  default Interceptor withConfig(Config config) {
    return this;
  }

  static UnaryOperator<Interceptor> useConfig(Config config) {
    return interceptor -> {
      if (config == null) {
        return interceptor;
      }
      return interceptor.withConfig(config);
    };
  }

  /**
   * Called before a request to allow for the manipulation of the request
   *
   * @param builder used to modify the request
   * @param headers the current headers
   */
  default void before(BasicBuilder builder, HttpHeaders headers) {
  }

  /**
   * Called after a websocket failure or by default from a normal request
   *
   * @param builder used to modify the request
   * @param response the failed response
   * @return true if the builder should be used to execute a new request
   */
  default CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
    return CompletableFuture.completedFuture(false);
  }

  /**
   * Called after a non-websocket failure
   *
   * @param builder used to modify the request
   * @param response the failed response
   * @return true if the builder should be used to execute a new request
   */
  default CompletableFuture<Boolean> afterFailure(HttpRequest.Builder builder, HttpResponse<?> response) {
    return afterFailure((BasicBuilder) builder, response);
  }

}
