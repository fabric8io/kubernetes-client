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
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    Config config = createNewConfig("http://localhost", "http://192.168.0.1", null);

    // When + Then
    assertThatIllegalArgumentException()
        .isThrownBy(() -> HttpClientUtils.getProxyUrl(config))
        .withMessage("Failure in creating proxy URL. Proxy port is required!");
  }

  @Test
  void getProxyUrl_whenHttpsProxyUrlWithPort_shouldReturnValidProxyUrl() throws MalformedURLException {
    // Given
    Config config = createNewConfig("http://localhost", "http://192.168.0.1:3128", null);

    // When
    URL url = HttpClientUtils.getProxyUrl(config);

    // Then
    assertThat(url).isNotNull()
        .hasPort(3128)
        .hasHost("192.168.0.1");
  }

  @Test
  void getProxyUrl_whenNoProxyProvided_shouldReturnNull() throws MalformedURLException {
    // Given
    Config config = createNewConfig("http://api.example.x812.my.domain.com:6443", "http://93.2.12.169:3128", ".my.domain.com");

    // When
    URL url = HttpClientUtils.getProxyUrl(config);

    // Then
    assertThat(url).isNull();
  }

  @Test
  void getProxyUrl_whenHostInNoProxyIPAddressRange_shouldReturnNull() throws MalformedURLException {
    // Given
    Config config = createNewConfig("http://192.168.1.100:6443", "http://93.2.12.169:3128", "192.168.1.0/24");

    // When
    URL url = HttpClientUtils.getProxyUrl(config);

    // Then
    assertThat(url).isNull();
  }

  @Test
  void getProxyUrl_whenHostNotInNoProxyIPAddressRange_shouldReturnProxyUrl() throws MalformedURLException {
    // Given
    Config config = createNewConfig("http://192.168.2.100:6443", "http://93.2.12.169:3128", "192.168.1.0/24");

    // When
    URL url = HttpClientUtils.getProxyUrl(config);

    // Then
    assertThat(url).isNotNull().hasHost("93.2.12.169");
  }

  @Test
  void getProxyUrl_whenNoProxyContainsWildcard_thenThrowException() {
    // Given
    Config config = createNewConfig("http://api.example.x812.my.domain.com:6443", "http://93.2.12.169:3128", "*.my.domain.com");

    // When + Then
    assertThatThrownBy(() -> HttpClientUtils.getProxyUrl(config))
        .isInstanceOf(MalformedURLException.class)
        .hasMessage("Wildcard not supported in NO_PROXY URL");
  }

  private Config createNewConfig(String masterUrl, String httpProxy, String noProxy) {
    ConfigBuilder configBuilder = new ConfigBuilder()
        .withMasterUrl(masterUrl)
        .withHttpProxy(httpProxy);
    if (noProxy != null) {
      configBuilder.withNoProxy(noProxy);
    }
    return configBuilder.build();
  }
}
