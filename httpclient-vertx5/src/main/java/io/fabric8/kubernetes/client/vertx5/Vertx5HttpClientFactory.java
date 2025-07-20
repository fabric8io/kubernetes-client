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
package io.fabric8.kubernetes.client.vertx5;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.vertx5.adapters.Vertx5HttpClientBuilder;
import io.vertx.core.Vertx;

public final class Vertx5HttpClientFactory implements HttpClient.Factory {

  public static final String NAME = "vertx5";

  @Override
  public Vertx5HttpClientBuilder<Vertx5HttpClientFactory> newBuilder() {
    return new Vertx5HttpClientBuilder<>(this, null);
  }

  public Vertx5HttpClientBuilder<Vertx5HttpClientFactory> newBuilder(final Vertx vertx) {
    return new Vertx5HttpClientBuilder<>(this, vertx);
  }
}