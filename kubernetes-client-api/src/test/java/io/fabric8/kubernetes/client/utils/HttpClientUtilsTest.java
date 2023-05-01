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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.Interceptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

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
          arguments("192.168.1.110", new String[] { "http://192.168.1.0/24" }),
          arguments("192.168.1.110", new String[] { "192.0.0.0/8" }),
          arguments("192.168.1.110", new String[] { "http://192.0.0.0/8" }));
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
          arguments("192.168.1.110", new String[] { "http://192.168.1.0/32" }),
          arguments("192.168.1.110", new String[] { "http://192.168.1.0/33" }));
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

  @Nested
  @DisplayName("getHttpClientFactory")
  class GetHttpClientFactory {

    private List<HttpClient.Factory> factories;
    @SuppressWarnings("rawtypes")
    private MockedStatic<ServiceLoader> mockedStaticServiceLoader;

    @BeforeEach
    void setUp() {
      // n.b. Since ServiceLoader is mocked for this test, it's not possible to use AssertJ assertions.
      factories = new ArrayList<>();
      mockedStaticServiceLoader = mockStatic(ServiceLoader.class);
      @SuppressWarnings("unchecked")
      final ServiceLoader<HttpClient.Factory> mockServiceLoader = mock(ServiceLoader.class);
      when(mockServiceLoader.iterator()).thenAnswer(i -> new ArrayList<>(factories).iterator());
      when(ServiceLoader.load(eq(HttpClient.Factory.class), any())).thenReturn(mockServiceLoader);
      mockedStaticServiceLoader.when(() -> ServiceLoader.load(eq(HttpClient.Factory.class)))
          .thenReturn(mockServiceLoader);
    }

    @AfterEach
    void tearDown() {
      factories.clear();
      mockedStaticServiceLoader.close();
    }

    @Test
    @DisplayName("With no implementations, should throw exception")
    void withNoImplementations() {
      final KubernetesClientException result = assertThrows(KubernetesClientException.class,
          HttpClientUtils::getHttpClientFactory);
      assertEquals(
          "No httpclient implementations found on the context classloader, please ensure your classpath includes an implementation jar",
          result.getMessage());
    }

    @Test
    @DisplayName("With default implementation, should return default")
    void withDefault() {
      factories.add(new DefaultHttpClientFactory());
      assertEquals(DefaultHttpClientFactory.class, HttpClientUtils.getHttpClientFactory().getClass());
    }

    @Test
    @DisplayName("With default and other implementation, should return other")
    void withDefaultAndOther() {
      factories.add(new ScoredHttpClientFactory("other", 0));
      factories.add(new DefaultHttpClientFactory());
      assertEquals(ScoredHttpClientFactory.class, HttpClientUtils.getHttpClientFactory().getClass());
    }

    @Test
    @DisplayName("With default, other, and priority implementations; should return Priority")
    void withDefaultAndPriorityAndOther() {
      factories.add(new ScoredHttpClientFactory("other", 0));
      factories.add(new ScoredHttpClientFactory("priority", Integer.MAX_VALUE));
      factories.add(new DefaultHttpClientFactory());
      final HttpClient.Factory result = HttpClientUtils.getHttpClientFactory();
      assertEquals(ScoredHttpClientFactory.class, result.getClass());
      assertEquals(Integer.MAX_VALUE, result.priority());
      assertEquals("priority", ((ScoredHttpClientFactory) result).id);
    }

    @Test
    @DisplayName("With multiple implementations and several with max priority, should return first of max priority")
    void withMultipleAndCollision() {
      factories.add(new DefaultHttpClientFactory());
      factories.add(new ScoredHttpClientFactory("other", 0));
      factories.add(new ScoredHttpClientFactory("priority-1", Integer.MAX_VALUE));
      factories.add(new ScoredHttpClientFactory("priority-2", Integer.MAX_VALUE));
      factories.add(new DefaultHttpClientFactory());
      final HttpClient.Factory result = HttpClientUtils.getHttpClientFactory();
      assertEquals(ScoredHttpClientFactory.class, result.getClass());
      assertEquals(Integer.MAX_VALUE, result.priority());
      assertEquals("priority-1", ((ScoredHttpClientFactory) result).id);
    }

    private final class ScoredHttpClientFactory implements HttpClient.Factory {
      private final String id;
      private final int priority;

      public ScoredHttpClientFactory(String id, int priority) {
        this.id = id;
        this.priority = priority;
      }

      @Override
      public HttpClient.Builder newBuilder() {
        return null;
      }

      @Override
      public int priority() {
        return priority;
      }
    }

    private final class DefaultHttpClientFactory implements HttpClient.Factory {

      @Override
      public HttpClient.Builder newBuilder() {
        return null;
      }

      @Override
      public int priority() {
        return -1;
      }

    }

  }
}
