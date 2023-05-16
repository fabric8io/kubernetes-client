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

import io.fabric8.kubernetes.client.http.WebSocket.Builder;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import lombok.Getter;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Getter
public class StandardWebSocketBuilder implements WebSocket.Builder {

  private final StandardHttpClient<?, ?, ?> httpClient;
  private final StandardHttpRequest.Builder builder;
  private String subprotocol;

  public StandardWebSocketBuilder(StandardHttpClient<?, ?, ?> httpClient) {
    this(httpClient, new StandardHttpRequest.Builder());
  }

  public StandardWebSocketBuilder(StandardHttpClient<?, ?, ?> httpClient, StandardHttpRequest.Builder builder) {
    this.httpClient = httpClient;
    this.builder = builder;
  }

  @Override
  public CompletableFuture<WebSocket> buildAsync(Listener listener) {
    return httpClient.buildWebSocket(this, listener);
  }

  @Override
  public StandardWebSocketBuilder subprotocol(String protocol) {
    this.subprotocol = protocol;
    return this;
  }

  @Override
  public StandardWebSocketBuilder header(String name, String value) {
    this.builder.header(name, value);
    return this;
  }

  @Override
  public StandardWebSocketBuilder setHeader(String k, String v) {
    this.builder.setHeader(k, v);
    return this;
  }

  @Override
  public StandardWebSocketBuilder uri(URI uri) {
    this.builder.uri(uri);
    return this;
  }

  public StandardWebSocketBuilder newBuilder() {
    return new StandardWebSocketBuilder(this.httpClient, builder.build().newBuilder()).subprotocol(subprotocol);
  }

  public StandardHttpRequest asHttpRequest() {
    return this.builder.build();
  }

  @Override
  public Builder connectTimeout(long timeout, TimeUnit timeUnit) {
    this.builder.timeout(timeout, timeUnit);
    return this;
  }

}
