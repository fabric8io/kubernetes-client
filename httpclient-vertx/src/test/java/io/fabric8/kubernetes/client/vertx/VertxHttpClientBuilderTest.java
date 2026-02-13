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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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
  void callsAdditionalConfigOnVertxHttpClientFactory() {
    // Create a custom factory that tracks if additionalConfig was called
    final AtomicBoolean additionalConfigCalled = new AtomicBoolean(false);
    final AtomicReference<WebClientOptions> capturedOptions = new AtomicReference<>();

    VertxHttpClientFactory customFactory = new VertxHttpClientFactory() {
      @Override
      protected void additionalConfig(WebClientOptions options) {
        additionalConfigCalled.set(true);
        capturedOptions.set(options);
        // Add custom config to verify it's applied
        options.setKeepAlive(true);
      }
    };

    // Build a client using the custom factory
    try (HttpClient client = customFactory.newBuilder().build()) {
      // Verify additionalConfig was called
      assertThat(additionalConfigCalled.get())
          .as("additionalConfig should be called during build")
          .isTrue();

      assertThat(capturedOptions.get())
          .as("WebClientOptions should be passed to additionalConfig")
          .isNotNull()
          .extracting(WebClientOptions::isKeepAlive)
          .isEqualTo(true);
    }
  }

  @Test
  void doesNotFailWithNonVertxHttpClientFactory() {
    // Test with a generic factory that doesn't have additionalConfig implemented
    // Since this factory is not an instance of VertxHttpClientFactory, no call to additionalConfig should be made
    HttpClient.Factory genericFactory = new HttpClient.Factory() {
      @Override
      public HttpClient.Builder newBuilder() {
        return new VertxHttpClientBuilder<>(this, null);
      }
    };

    // Should not throw an exception
    try (HttpClient client = genericFactory.newBuilder().build()) {
      assertThat(client).isNotNull();
    }
  }
}
