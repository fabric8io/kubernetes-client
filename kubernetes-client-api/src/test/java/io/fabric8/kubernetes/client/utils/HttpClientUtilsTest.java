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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.Interceptor;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HttpClientUtilsTest {
  @Test
  void testCreateApplicableInterceptors() {
    // Given
    Config config = new ConfigBuilder().build();

    // When
    Collection<Interceptor> interceptorList = HttpClientUtils.createApplicableInterceptors(config, null).values();

    // Then
    assertThat(interceptorList)
        .isNotNull()
        .hasSize(3)
        .hasAtLeastOneElementOfType(ImpersonatorInterceptor.class)
        .hasAtLeastOneElementOfType(TokenRefreshInterceptor.class);
  }

  @Test
  void testCreateApplicableInterceptorsWithBackwardsCompatibilityDisabled() {
    // Given
    Config config = new ConfigBuilder().build();
    System.setProperty(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE, "true");

    // When
    Collection<Interceptor> interceptorList = HttpClientUtils.createApplicableInterceptors(config, null).values();

    // Then
    assertThat(interceptorList)
        .isNotNull()
        .hasSize(3)
        .noneMatch(i -> i instanceof BackwardsCompatibilityInterceptor)
        .hasAtLeastOneElementOfType(ImpersonatorInterceptor.class)
        .hasAtLeastOneElementOfType(TokenRefreshInterceptor.class);
    System.clearProperty(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE);
  }

  @Test
  void getProxyUrl_whenHttpsProxyUrlWithNoPort_shouldReturnValidProxyUrl() {
    // Given
    Config config = new ConfigBuilder()
        .withMasterUrl("http://localhost")
        .withHttpProxy("http://192.168.0.1")
        .build();

    // When
    final IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
        () -> HttpClientUtils.getProxyUrl(config));

    // Then
    assertThat(illegalArgumentException)
        .hasMessage("Failure in creating proxy URL. Proxy port is required!");
  }

  @Test
  void getProxyUrl_whenHttpsProxyUrlWithPort_shouldReturnValidProxyUrl() throws MalformedURLException {
    // Given
    Config config = new ConfigBuilder()
        .withMasterUrl("http://localhost")
        .withHttpProxy("http://192.168.0.1:3128")
        .build();

    // When
    URL url = HttpClientUtils.getProxyUrl(config);

    // Then
    assertThat(url).isNotNull()
        .hasPort(3128)
        .hasHost("192.168.0.1");
  }
}
