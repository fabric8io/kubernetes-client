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

import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ConfigProxySourceTest {
  @Nested
  @DisplayName("http.proxy System property")
  class HttpProxySystemProperty {
    @BeforeEach
    void setup() {
      System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("http.proxy");
    }

    @Test
    @DisplayName("no other proxy configuration, then http.proxy property takes precedence")
    void noOtherConfiguration() {
      assertThat(new ConfigBuilder().build())
          .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128")
          .hasFieldOrPropertyWithValue("httpsProxy", null);
    }

    @Test
    @DisplayName("all.proxy property configuration, then http.proxy property takes precedence")
    void allProxySystemProperty() {
      try {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128");
      } finally {
        System.clearProperty("all.proxy");
      }
    }

    @Test
    @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
    void httpProxyViaBuilder() {
      assertThat(new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128").build())
          .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128")
          .hasFieldOrPropertyWithValue("httpsProxy", null);
    }

    @Test
    @DisplayName("kubeconfig cluster has proxy-url, then http.proxy property takes precedence")
    void kubeConfigProxyUrl() {
      try {
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpsProxy", null);
      } finally {
        System.clearProperty("kubeconfig");
      }
    }
  }

  @Nested
  @DisplayName("all.proxy System property")
  class AllProxySystemProperty {
    @BeforeEach
    void setup() {
      System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("all.proxy");
    }

    @Test
    @DisplayName("no other proxy configuration, then all.proxy property takes precedence")
    void noOtherConfiguration() {
      assertThat(new ConfigBuilder().build())
          .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128")
          .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-all-proxy-property:3128");
    }

    @Test
    @DisplayName("http.proxy property configuration, then http.proxy property takes precedence")
    void allProxySystemProperty() {
      try {
        System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
      } finally {
        System.clearProperty("http.proxy");
      }
    }

    @Test
    @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
    void httpProxyViaBuilder() {
      assertThat(new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128").build())
          .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128")
          .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
    }

    @Test
    @DisplayName("kubeconfig cluster has proxy-url, then all.proxy property takes precedence")
    void kubeConfigProxyUrl() {
      try {
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-all-proxy-property:3128");
      } finally {
        System.clearProperty("kubeconfig");
      }
    }
  }

  @Nested
  @DisplayName("withHttpProxy via builder")
  class ProxyViaBuilder {
    private ConfigBuilder configBuilder;

    @BeforeEach
    void setUp() {
      configBuilder = new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128");
    }

    @Test
    @DisplayName("no other proxy configuration, then user configuration via builder takes precedence")
    void noOtherConfiguration() {
      assertThat(configBuilder.build())
          .hasFieldOrPropertyWithValue("httpsProxy", null)
          .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
    }

    @Test
    @DisplayName("http.proxy property configuration, then user configuration via builder takes precedence")
    void httpProxySystemProperty() {
      try {
        System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", null)
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      } finally {
        System.clearProperty("http.proxy");
      }
    }

    @Test
    @DisplayName("all.proxy property configuration, then user configuration via builder takes precedence")
    void allProxySystemProperty() {
      try {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      } finally {
        System.clearProperty("all.proxy");
      }
    }

    @Test
    @DisplayName("kubeconfig cluster has proxy-url, then user configuration via builder takes precedence")
    void kubeConfigProxyUrl() {
      try {
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", null)
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      } finally {
        System.clearProperty("kubeconfig");
      }
    }
  }

  @Nested
  @DisplayName("kubeconfig contains proxy-url in cluster configuration")
  class KubeConfigWithProxyUrl {
    @BeforeEach
    void setup() {
      System.setProperty("kubeconfig", Utils
          .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubeconfig");
    }

    @Test
    @Disabled("https://github.com/fabric8io/kubernetes-client/issues/6150")
    void noOtherConfiguration() {
      // When + Then
      assertThat(new ConfigBuilder().build())
          .hasFieldOrPropertyWithValue("httpProxy", null)
          .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
    }

    @Test
    @DisplayName("http.proxy property configuration, then http.proxy takes precedence")
    void httpProxySystemProperty() {
      try {
        System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpsProxy", null);
      } finally {
        System.clearProperty("http.proxy");
      }
    }

    @Test
    @DisplayName("all.proxy property configuration, then all.proxy takes precedence")
    void allProxySystemProperty() {
      try {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-all-proxy-property:3128")
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128");
      } finally {
        System.clearProperty("all.proxy");
      }
    }

    @Test
    @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
    void httpProxyViaBuilder() {
      assertThat(new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128").build())
          .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128")
          .hasFieldOrPropertyWithValue("httpsProxy", null);
    }
  }
}
