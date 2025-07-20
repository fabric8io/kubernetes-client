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
package io.fabric8.kubernetes.client.vertx5.adapters;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
import io.vertx.core.http.HttpClientResponse;
import lombok.NonNull;

import java.util.Optional;

final class Vertx5HttpResponse extends StandardHttpHeaders implements HttpResponse<AsyncBody> {

  @NonNull
  private final AsyncBody result;
  @NonNull
  private final HttpClientResponse resp;
  @NonNull
  private final HttpRequest request;

  Vertx5HttpResponse(@NonNull final AsyncBody result, @NonNull final HttpClientResponse resp,
      @NonNull final HttpRequest request) {
    super(Vertx5HttpRequest.toHeadersMap(resp.headers()));
    this.result = result;
    this.resp = resp;
    this.request = request;
  }

  @Override
  public int code() {
    return resp.statusCode();
  }

  @Override
  public AsyncBody body() {
    return result;
  }

  @Override
  public HttpRequest request() {
    return request;
  }

  @Override
  public String message() {
    return resp.statusMessage();
  }

  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return Optional.empty();
  }
}