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
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OkHttpClientFactoryTest {

  @Test
  void shouldNotRespectMaxRequests() {
    OkHttpClientImpl client = new OkHttpClientFactory().newBuilder(Config.empty()).build();

    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequests());

    Config config = new ConfigBuilder(Config.empty())
        .withMaxConcurrentRequests(120)
        .build();

    client = new OkHttpClientFactory().newBuilder(config).build();
    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequests());
  }

  @Test
  void shouldNotRespectMaxRequestsPerHost() {
    OkHttpClientImpl client = new OkHttpClientFactory().newBuilder(Config.empty()).build();

    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequestsPerHost());

    Config config = new ConfigBuilder(Config.empty())
        .withMaxConcurrentRequestsPerHost(20)
        .build();

    client = new OkHttpClientFactory().newBuilder(config).build();

    assertEquals(Integer.MAX_VALUE, client.getOkHttpClient().dispatcher().getMaxRequestsPerHost());
  }

  @Test
  void additionalConfigCanOverrideDispatcher() {
    final Dispatcher dispatcher = new Dispatcher();
    OkHttpClientImpl client = new OkHttpClientFactory() {
      @Override
      protected void additionalConfig(OkHttpClient.Builder builder) {
        dispatcher.setMaxRequests(1337);
        builder.dispatcher(dispatcher);
      }
    }
        .newBuilder(Config.empty())
        .build();
    assertThat(client.getOkHttpClient().dispatcher())
        .isSameAs(dispatcher)
        .hasFieldOrPropertyWithValue("maxRequests", 1337);
  }

  @Test
  void initDispatcherCanOverrideDispatcher() {
    OkHttpClientImpl client = new OkHttpClientFactory() {
      @Override
      protected Dispatcher initDispatcher() {
        final Dispatcher dispatcher = super.initDispatcher();
        dispatcher.setMaxRequests(1337);
        return dispatcher;
      }
    }
        .newBuilder(Config.empty())
        .build();
    assertThat(client.getOkHttpClient().dispatcher())
        .hasFieldOrPropertyWithValue("maxRequests", 1337);
  }

  @Test
  void proxyOverride() {
    OkHttpClientFactory factory = new OkHttpClientFactory() {
      @Override
      protected void additionalConfig(Builder builder) {
        builder.proxy(new Proxy(Type.SOCKS, InetSocketAddress.createUnresolved("foo", 1000)));
      }

    };

    OkHttpClientImpl client = factory.newBuilder(Config.empty()).build();

    assertEquals(Type.SOCKS, client.getOkHttpClient().proxy().type());
  }

  @Test
  void httpClientsHaveZeroReadTimeout() {
    OkHttpClientImpl client = new OkHttpClientFactory().newBuilder(Config.empty()).build();
    assertEquals(0, client.getOkHttpClient().readTimeoutMillis());
  }

  @Test
  void httpClientsHaveZeroWriteTimeout() {
    OkHttpClientImpl client = new OkHttpClientFactory().newBuilder(Config.empty()).build();
    assertEquals(0, client.getOkHttpClient().writeTimeoutMillis());
  }
}
