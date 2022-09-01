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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    System.setProperty("kubernetes.backwardsCompatibilityInterceptor.disable", "true");

    try {
      // When
      Collection<Interceptor> interceptorList = HttpClientUtils.createApplicableInterceptors(config, null).values();

      // Then
      assertThat(interceptorList)
          .isNotNull()
          .hasSize(3)
          .noneMatch(i -> i instanceof BackwardsCompatibilityInterceptor)
          .hasAtLeastOneElementOfType(ImpersonatorInterceptor.class)
          .hasAtLeastOneElementOfType(TokenRefreshInterceptor.class);
    } finally {
      System.clearProperty("kubernetes.backwardsCompatibilityInterceptor.disable");
    }
  }

  @Nested
  @DisplayName("getProxyUrl")
  @TestInstance(PER_CLASS)
  class GetProxyUrl {

    private ConfigBuilder configBuilder;

    @BeforeEach
    void setUp() {
      configBuilder = new ConfigBuilder();
    }

    @DisplayName("With httpProxy and noProxy matching master url, should return null")
    @ParameterizedTest(name = "{index}: Master URL ''{0}'' matched by No Proxy ''{1}'' ")
    @MethodSource("masterUrlMatchesNoProxyInput")
    void masterUrlMatchesNoProxy(String masterUrl, String[] noProxy) throws MalformedURLException {
      // Given
      Config config = configBuilder.withHttpProxy("http://proxy.url:8080")
          .withMasterUrl(masterUrl).withNoProxy(noProxy).build();
      // When
      URL url = HttpClientUtils.getProxyUrl(config);
      // Then
      assertThat(url).isNull();
    }

    Stream<Arguments> masterUrlMatchesNoProxyInput() {
      return Stream.of(
          arguments("http://192.168.1.100:6443", new String[] { "192.168.1.0/24" }),
          arguments("master.example.com", new String[] { "master.example.com" }),
          arguments("master.example.com", new String[] { ".example.com" }),
          arguments("master.example.com",
              new String[] { "circleci-internal-outer-build-agent", "one.com", "other.com", ".com" }),
          arguments("192.168.1.110", new String[] { "192.168.1.110" }),
          arguments("192.168.1.110", new String[] { "http://192.168.1.110" }),
          arguments("192.168.1.110", new String[] { "https://192.168.1.110" }),
          arguments("192.168.1.110", new String[] { "192.168.1.0/24" }),
          arguments("192.168.1.110", new String[] { "http://192.168.1.0/24" }));
    }

    @DisplayName("With httpProxy and noProxy not matching master url, should return proxy url")
    @ParameterizedTest(name = "{index}: Master URL ''{0}'' not matched by No Proxy ''{1}'' ")
    @MethodSource("masterUrlDoesNotMatchNoProxyInput")
    void masterUrlDoesNotMatchNoProxy(String masterUrl, String[] noProxy) throws MalformedURLException {
      // Given
      Config config = configBuilder.withHttpProxy("http://proxy.url:8080")
          .withMasterUrl(masterUrl).withNoProxy(noProxy).build();
      // When
      URL url = HttpClientUtils.getProxyUrl(config);
      // Then
      assertThat(url).isEqualToWithSortedQueryParameters(new URL("http://proxy.url:8080"));
    }

    Stream<Arguments> masterUrlDoesNotMatchNoProxyInput() {
      return Stream.of(
          arguments("http://192.168.2.100:6443", new String[] { "192.168.1.0/24" }),
          arguments("master.example.com", null),
          arguments("master.example.com", new String[0]),
          arguments("master.example.com", new String[] { "master1.example.com" }),
          arguments("master.example.com", new String[] { ".example1.com" }),
          arguments("master.example.com", new String[] { "circleci-internal-outer-build-agent", }),
          arguments("master.example.com", new String[] { "one.com", "other.com", "master.example.", ".co" }),
          arguments("192.168.1.110", new String[] { "192.168.1.111" }),
          arguments("192.168.1.110", new String[] { "http://192.168.1.111" }),
          arguments("192.168.1.110", new String[] { "https://192.168.1.111" }),
          arguments("192.168.1.110", new String[] { "192.168.10.0/24" }),
          arguments("192.168.1.110", new String[] { "http://192.168.1.0/32" }));
    }

    @DisplayName("With httpProxy and invalid noProxy should throw Exception")
    @ParameterizedTest(name = "{index}: ''{0}'' is invalid")
    @ValueSource(strings = {
        "*.my.domain.com", "!!!.com", "()-?¿?", "http://proxy url"
    })
    void invalidNoProxyUrlThrowsException(String noProxy) {
      // Given
      Config config = configBuilder.withHttpProxy("http://proxy.url:8080")
          .withMasterUrl("master.url").withNoProxy(noProxy).build();
      // When + Then
      assertThatThrownBy(() -> HttpClientUtils.getProxyUrl(config))
          .isInstanceOf(MalformedURLException.class)
          .hasMessage("NO_PROXY URL contains invalid entry: '" + noProxy + "'");
    }

    @Test
    void whenHttpsProxyUrlWithNoPort_shouldThrowException() {
      // Given
      Config config = configBuilder.withMasterUrl("http://localhost").withHttpProxy("http://192.168.0.1").build();
      // When + Then
      assertThatIllegalArgumentException()
          .isThrownBy(() -> HttpClientUtils.getProxyUrl(config))
          .withMessage("Failure in creating proxy URL. Proxy port is required!");
    }

    @Test
    void withNoHttpProxyProvidedReturnsNull() throws MalformedURLException {
      // Given
      Config config = configBuilder.withMasterUrl("master.url").withNoProxy("other.url").build();
      // When
      URL url = HttpClientUtils.getProxyUrl(config);
      // Then
      assertThat(url).isNull();
    }
  }
}
