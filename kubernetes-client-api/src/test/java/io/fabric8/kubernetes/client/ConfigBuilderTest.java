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
package io.fabric8.kubernetes.client;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigBuilderTest {

  @Test
  void withPrimitiveValues() {
    final ConfigBuilder configBuilder = new ConfigBuilder()
        .withAutoConfigure(false)
        .withTrustCerts(true)
        .withDisableHostnameVerification(true)
        .withWebsocketPingInterval(133701)
        .withConnectionTimeout(133702)
        .withMaxConcurrentRequests(133703)
        .withWatchReconnectInterval(133704)
        .withWatchReconnectLimit(133705)
        .withUploadRequestTimeout(133706)
        .withRequestRetryBackoffLimit(133707)
        .withRequestRetryBackoffInterval(133708)
        .withRequestTimeout(133709)
        .withScaleTimeout(133710)
        .withLoggingInterval(133711)
        .withHttp2Disable(true)
        .withOnlyHttpWatches(true);
    assertThat(configBuilder.build())
        .hasFieldOrPropertyWithValue("autoConfigure", Boolean.FALSE)
        .hasFieldOrPropertyWithValue("trustCerts", Boolean.TRUE)
        .hasFieldOrPropertyWithValue("disableHostnameVerification", Boolean.TRUE)
        .hasFieldOrPropertyWithValue("websocketPingInterval", 133701L)
        .hasFieldOrPropertyWithValue("connectionTimeout", 133702)
        .hasFieldOrPropertyWithValue("maxConcurrentRequests", 133703)
        .hasFieldOrPropertyWithValue("watchReconnectInterval", 133704)
        .hasFieldOrPropertyWithValue("watchReconnectLimit", 133705)
        .hasFieldOrPropertyWithValue("uploadRequestTimeout", 133706)
        .hasFieldOrPropertyWithValue("requestRetryBackoffLimit", 133707)
        .hasFieldOrPropertyWithValue("requestRetryBackoffInterval", 133708)
        .hasFieldOrPropertyWithValue("requestTimeout", 133709)
        .hasFieldOrPropertyWithValue("scaleTimeout", 133710L)
        .hasFieldOrPropertyWithValue("loggingInterval", 133711)
        .hasFieldOrPropertyWithValue("http2Disable", Boolean.TRUE)
        .hasFieldOrPropertyWithValue("onlyHttpWatches", Boolean.TRUE);
  }

  @Test
  void withBoxedValues() {
    final ConfigBuilder configBuilder = new ConfigBuilder()
        .withAutoConfigure(Boolean.FALSE)
        .withTrustCerts(Boolean.TRUE)
        .withDisableHostnameVerification(Boolean.TRUE)
        .withWebsocketPingInterval(Long.valueOf(133701))
        .withConnectionTimeout(Integer.valueOf(133702))
        .withMaxConcurrentRequests(Integer.valueOf(133703))
        .withWatchReconnectInterval(Integer.valueOf(133704))
        .withWatchReconnectLimit(Integer.valueOf(133705))
        .withUploadRequestTimeout(Integer.valueOf(133706))
        .withRequestRetryBackoffLimit(Integer.valueOf(133707))
        .withRequestRetryBackoffInterval(Integer.valueOf(133708))
        .withRequestTimeout(Integer.valueOf(133709))
        .withScaleTimeout(Long.valueOf(133710))
        .withLoggingInterval(Integer.valueOf(133711))
        .withHttp2Disable(Boolean.TRUE)
        .withOnlyHttpWatches(Boolean.TRUE);
    assertThat(configBuilder.build())
        .hasFieldOrPropertyWithValue("autoConfigure", false)
        .hasFieldOrPropertyWithValue("trustCerts", true)
        .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
        .hasFieldOrPropertyWithValue("websocketPingInterval", 133701L)
        .hasFieldOrPropertyWithValue("connectionTimeout", 133702)
        .hasFieldOrPropertyWithValue("maxConcurrentRequests", 133703)
        .hasFieldOrPropertyWithValue("watchReconnectInterval", 133704)
        .hasFieldOrPropertyWithValue("watchReconnectLimit", 133705)
        .hasFieldOrPropertyWithValue("uploadRequestTimeout", 133706)
        .hasFieldOrPropertyWithValue("requestRetryBackoffLimit", 133707)
        .hasFieldOrPropertyWithValue("requestRetryBackoffInterval", 133708)
        .hasFieldOrPropertyWithValue("requestTimeout", 133709)
        .hasFieldOrPropertyWithValue("scaleTimeout", 133710L)
        .hasFieldOrPropertyWithValue("loggingInterval", 133711)
        .hasFieldOrPropertyWithValue("http2Disable", true)
        .hasFieldOrPropertyWithValue("onlyHttpWatches", true);
  }

}
