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

package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OkHttpClientFactoryTest {

  @Test
  void shouldNotRespectMaxRequests() {
    OkHttpClientImpl client = new OkHttpClientFactory().newBuilder(new ConfigBuilder().build()).build();

    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequests());

    Config config = new ConfigBuilder()
        .withMaxConcurrentRequests(120)
        .build();

    client = new OkHttpClientFactory().newBuilder(config).build();
    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequests());
  }

  @Test
  void shouldNotRespectMaxRequestsPerHost() {
    OkHttpClientImpl client = new OkHttpClientFactory().newBuilder(new ConfigBuilder().build()).build();

    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequestsPerHost());

    Config config = new ConfigBuilder()
        .withMaxConcurrentRequestsPerHost(20)
        .build();

    client = new OkHttpClientFactory().newBuilder(config).build();

    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequestsPerHost());
  }

}
