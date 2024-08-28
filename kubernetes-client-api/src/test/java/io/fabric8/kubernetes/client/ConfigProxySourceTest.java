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

import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ConfigProxySourceTest {
  @TempDir
  private File temporaryFolder;

  @Nested
  @DisplayName("HTTP Proxy")
  class HttpProxyConfig {
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
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
      }

      @Test
      @DisplayName("all.proxy property configuration, then http.proxy property takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
        } finally {
          System.clearProperty("all.proxy");
        }
      }

      @Test
      @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
      void httpProxyViaBuilder() {
        assertThat(new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128").build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("kubeconfig cluster has http proxy-url, then kubeconfig proxy-url takes precedence")
      void kubeConfigProxyUrl() throws IOException {
        try {
          // Given
          System.setProperty("kubeconfig",
              createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                  .getAbsolutePath());
          // When + Then
          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-server.example:80");
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
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("http.proxy property configuration, then user configuration via builder takes precedence")
      void httpProxySystemProperty() {
        try {
          System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

          assertThat(configBuilder.build())
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
              .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
        } finally {
          System.clearProperty("all.proxy");
        }
      }

      @Test
      @DisplayName("kubeconfig cluster has proxy-url, then user configuration via builder takes precedence")
      void kubeConfigProxyUrl() throws IOException {
        try {
          // Given
          System.setProperty("kubeconfig",
              createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                  .getAbsolutePath());
          // When + Then
          assertThat(configBuilder.build())
              .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
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
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-all-proxy-property:3128");
      }

      @Test
      @DisplayName("http.proxy property configuration, then http.proxy property takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
        } finally {
          System.clearProperty("http.proxy");
        }
      }

      @Test
      @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
      void httpProxyViaBuilder() {
        assertThat(new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128").build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("kubeconfig cluster has proxy-url, then kubeconfig proxy-url takes precedence")
      void kubeConfigProxyUrl() throws IOException {
        try {
          // Given
          System.setProperty("kubeconfig",
              createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                  .getAbsolutePath());
          // When + Then
          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-server.example:80");
        } finally {
          System.clearProperty("kubeconfig");
        }
      }
    }

    @Nested
    @DisplayName("kubeconfig contains proxy-url in cluster configuration")
    class KubeConfigWithProxyUrl {
      @BeforeEach
      void setup() throws IOException {
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "socks5://proxy-server.example:80")
                .getAbsolutePath());
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("kubeconfig");
      }

      @Test
      @DisplayName("proxy-url with sock5 scheme, masterUrl with http scheme, then Config sets httpProxy")
      void whenProxyUrlSocks5MasterUrlHttp_thenHttpProxySetInConfig() {
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "socks5://proxy-server.example:80")
            .hasFieldOrPropertyWithValue("httpsProxy", null);
      }

      @Test
      @DisplayName("proxy-url with http scheme, masterUrl with http scheme, then Config sets httpProxy")
      void whenProxyUrlHttp_thenHttpProxySetInConfig() throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-server.example:80")
            .hasFieldOrPropertyWithValue("httpsProxy", null);
      }

      @Test
      @DisplayName("http.proxy property configuration, kubeconfig proxy-url takes precedence")
      void httpProxySystemProperty() {
        try {
          System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpProxy", "socks5://proxy-server.example:80");
        } finally {
          System.clearProperty("http.proxy");
        }
      }

      @Test
      @DisplayName("all.proxy property configuration, then kubeconfig proxy-url takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpProxy", "socks5://proxy-server.example:80");
        } finally {
          System.clearProperty("all.proxy");
        }
      }

      @Test
      @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
      void httpProxyViaBuilder() {
        assertThat(new ConfigBuilder().withHttpProxy("http://proxy-via-builder:3128").build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }
    }
  }

  @Nested
  @DisplayName("HTTPS Proxy")
  class HttpsProxyConfig {
    @Nested
    @DisplayName("https.proxy System property")
    class HttpsProxySystemProperty {
      @BeforeEach
      void setup() {
        System.setProperty("https.proxy", "http://proxy-via-http-proxy-property:3128");
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("https.proxy");
      }

      @Test
      @DisplayName("no other proxy configuration, then https.proxy property takes precedence")
      void noOtherConfiguration() {
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-http-proxy-property:3128");
      }

      @Test
      @DisplayName("all.proxy property configuration, then https.proxy property takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-http-proxy-property:3128");
        } finally {
          System.clearProperty("all.proxy");
        }
      }

      @Test
      @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
      void httpsProxyViaBuilder() {
        assertThat(new ConfigBuilder().withHttpsProxy("https://proxy-via-builder:3128").build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("kubeconfig cluster has proxy-url, then kubeconfig proxy-url takes precedence")
      void kubeConfigProxyUrl() {
        try {
          // Given
          System.setProperty("kubeconfig", Utils
              .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
          // When + Then
          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
        } finally {
          System.clearProperty("kubeconfig");
        }
      }
    }

    @Nested
    @DisplayName("withHttpsProxy via builder")
    class ProxyViaBuilder {
      private ConfigBuilder configBuilder;

      @BeforeEach
      void setUp() {
        configBuilder = new ConfigBuilder().withHttpsProxy("https://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("no other proxy configuration, then user configuration via builder takes precedence")
      void noOtherConfiguration() {
        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("https.proxy property configuration, then user configuration via builder takes precedence")
      void httpsProxySystemProperty() {
        try {
          System.setProperty("https.proxy", "https://proxy-via-https-proxy-property:3128");

          assertThat(configBuilder.build())
              .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
        } finally {
          System.clearProperty("https.proxy");
        }
      }

      @Test
      @DisplayName("all.proxy property configuration, then user configuration via builder takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("all.proxy", "https://proxy-via-all-proxy-property:3128");

          assertThat(configBuilder.build())
              .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
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
              .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
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
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-all-proxy-property:3128");
      }

      @Test
      @DisplayName("https.proxy property configuration, then https.proxy property takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("https.proxy", "http://proxy-via-http-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-http-proxy-property:3128");
        } finally {
          System.clearProperty("https.proxy");
        }
      }

      @Test
      @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
      void httpsProxyViaBuilder() {
        assertThat(new ConfigBuilder().withHttpsProxy("https://proxy-via-builder:3128").build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("kubeconfig cluster has proxy-url, then kubeconfig proxy-url takes precedence")
      void kubeConfigProxyUrl() throws IOException {
        try {
          // Given
          System.setProperty("kubeconfig",
              createKubeConfigWithCluster("https://kubernetes-remote-server.example:6443", "https://proxy-server.example:80")
                  .getAbsolutePath());
          // When + Then
          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-server.example:80");
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
      @DisplayName("proxy-url with socks5 scheme, masterUrl with https scheme, then Config sets httpsProxy")
      void whenProxyUrlSocks5_thenHttpsProxySetInConfig() {
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
      }

      @Test
      @DisplayName("proxy-url with https scheme, masterUrl with https scheme, then Config sets httpsProxy")
      void whenProxyUrlHttps_thenHttpsProxySetInConfig() throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("https://kubernetes-remote-server.example:6443", "https://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-server.example:80");
      }

      @Test
      @DisplayName("https.proxy property configuration, kubeconfig proxy-url takes precedence")
      void httpsProxySystemProperty() {
        try {
          System.setProperty("https.proxy", "https://proxy-via-http-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
        } finally {
          System.clearProperty("https.proxy");
        }
      }

      @Test
      @DisplayName("all.proxy property configuration, then kubeconfig proxy-url takes precedence")
      void allProxySystemProperty() {
        try {
          System.setProperty("all.proxy", "https://proxy-via-all-proxy-property:3128");

          assertThat(new ConfigBuilder().build())
              .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
        } finally {
          System.clearProperty("all.proxy");
        }
      }

      @Test
      @DisplayName("user configures proxy via builder, then user configuration via builder takes precedence")
      void httpsProxyViaBuilder() {
        assertThat(new ConfigBuilder().withHttpsProxy("https://proxy-via-builder:3128").build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }
    }
  }

  private File createKubeConfigWithCluster(String masterUrl, String proxyUrl) throws IOException {
    io.fabric8.kubernetes.api.model.Config kubeConfig = Serialization.unmarshal(
        ConfigTest.class.getResourceAsStream("/config-proxy-source/kubeconfig-with-proxy-url"),
        io.fabric8.kubernetes.api.model.Config.class);
    kubeConfig.getClusters().get(0).getCluster().setServer(masterUrl);
    kubeConfig.getClusters().get(0).getCluster().setProxyUrl(proxyUrl);
    File updatedKubeConfig = new File(temporaryFolder, "kubeconfig");
    Files.write(updatedKubeConfig.toPath(), Serialization.asYaml(kubeConfig).getBytes(StandardCharsets.UTF_8));
    return updatedKubeConfig;
  }
}
