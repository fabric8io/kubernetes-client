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

import io.fabric8.kubernetes.client.http.HttpClient;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxImpl;
import io.vertx.ext.web.client.WebClientOptions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VertxHttpClientBuilderTest {

  @Test
  void testZeroTimeouts() {
    VertxHttpClientFactory factory = new VertxHttpClientFactory();
    HttpClient.Builder builder = factory.newBuilder();

    // should build and be usable without an issue
    try (HttpClient client = builder.connectTimeout(0, TimeUnit.MILLISECONDS).build();) {
      assertNotNull(client.newHttpRequestBuilder().uri("http://localhost").build());
    }
  }

  @Test
  void reusesVertxInstanceWhenSharedVertx() {
    Vertx vertx = Vertx.vertx();
    try (HttpClient client = new VertxHttpClientFactory(vertx).newBuilder().build()) {
      assertThat(client)
          .isInstanceOf(VertxHttpClient.class)
          .extracting("vertx")
          .isSameAs(vertx);
    } finally {
      vertx.close();
    }
  }

  @Test
  void createsVertxInstanceWhenNoSharedVertx() {
    try (HttpClient client = new VertxHttpClientFactory().newBuilder().build()) {
      assertThat(client)
          .isInstanceOf(VertxHttpClient.class)
          .extracting("vertx")
          .isNotNull();
    }
  }

  @Test
  void doesntCloseSharedVertxInstanceWhenClientIsClosed() {
    final Vertx vertx = Vertx.vertx();
    final var builder = new VertxHttpClientFactory(vertx).newBuilder();
    builder.build().close();
    assertThat(builder.vertx)
        .asInstanceOf(InstanceOfAssertFactories.type(VertxImpl.class))
        .returns(false, vi -> vi.closeFuture().isClosed());
    vertx.close();
  }

  @Test
  void closesVertxInstanceWhenClientIsClosed() {
    final var builder = new VertxHttpClientFactory().newBuilder();
    builder.build().close();
    assertThat(builder.vertx)
        .asInstanceOf(InstanceOfAssertFactories.type(VertxImpl.class))
        .returns(true, vi -> vi.closeFuture().isClosed());
  }

  @Test
  void buildsSuccessfullyWithCustomWebClientOptions() {
    WebClientOptions customOptions = new WebClientOptions()
        .setKeepAlive(false)
        .setTcpNoDelay(false)
        .setUserAgent("custom-agent");

    VertxHttpClientFactory factory = new VertxHttpClientFactory();
    VertxHttpClientBuilder<?> builder = factory.newBuilder();

    try (HttpClient client = builder.withCustomWebClientOptions(customOptions).build()) {
      assertThat(client)
          .isInstanceOf(VertxHttpClient.class)
          .isNotNull();

      assertThat(client.newHttpRequestBuilder().uri("http://localhost").build())
          .isNotNull();
    }
  }
}
