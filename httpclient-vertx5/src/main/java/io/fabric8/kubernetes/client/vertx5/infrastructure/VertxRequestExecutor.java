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
package io.fabric8.kubernetes.client.vertx5.infrastructure;

import io.fabric8.kubernetes.client.vertx5.core.RequestSpec;
import io.fabric8.kubernetes.client.vertx5.functional.Result;
import io.vertx.core.Future;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
final class VertxRequestExecutor {

  @NonNull
  private final HttpClient httpClient;

  CompletableFuture<Result<HttpClientResponse>> executeRequest(@NonNull final RequestSpec requestSpec) {
    final CompletableFuture<Result<HttpClientResponse>> future = new CompletableFuture<>();

    try {
      final RequestOptions options = createRequestOptions(requestSpec);

      httpClient.request(options)
          .compose(this::sendRequest)
          .onSuccess(response -> future.complete(Result.success(response)))
          .onFailure(throwable -> future.complete(Result.failure(throwable)));

    } catch (final Exception e) {
      future.complete(Result.failure(e));
    }

    return future;
  }

  private RequestOptions createRequestOptions(@NonNull final RequestSpec requestSpec) {
    final RequestOptions options = new RequestOptions();

    options.setAbsoluteURI(requestSpec.getUri().toString());
    options.setMethod(HttpMethod.valueOf(requestSpec.getMethod()));

    if (requestSpec.getTimeout() != null) {
      options.setTimeout(requestSpec.getTimeout().toMillis());
    }

    requestSpec.getHeaders().forEach((name, values) -> values.forEach(value -> options.addHeader(name, value)));

    if (requestSpec.getContentType() != null) {
      options.putHeader("Content-Type", requestSpec.getContentType());
    }

    if (requestSpec.isExpectContinue()) {
      options.putHeader("Expect", "100-continue");
    }

    return options;
  }

  private Future<HttpClientResponse> sendRequest(@NonNull final HttpClientRequest request) {
    return request.send();
  }
}