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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.HttpClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VertxHttpClientBuilderTest {

  @Test
  void testZeroTimeouts() {
    VertxHttpClientFactory factory = new VertxHttpClientFactory();
    HttpClient.Builder builder = factory.newBuilder();

    // should build and be usable without an issue
    try (HttpClient client = builder.readTimeout(0, TimeUnit.MILLISECONDS).connectTimeout(0, TimeUnit.MILLISECONDS)
        .writeTimeout(0,
            TimeUnit.MILLISECONDS)
        .build();) {
      assertNotNull(client.newHttpRequestBuilder().uri("http://localhost").build());
    }
  }

}
