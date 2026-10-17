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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RestoreSystemProperties({ "http.proxy", "https.proxy", "all.proxy", "kubeconfig" })
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

      @Test
      @DisplayName("no other proxy configuration, then http.proxy property takes precedence")
      void noOtherConfiguration() {
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
      }

      @Test
      @DisplayName("all.proxy property configuration, then http.proxy property takes precedence")
      void allProxySystemProperty() {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
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
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-server.example:80");
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
        System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("all.proxy property configuration, then user configuration via builder takes precedence")
      void allProxySystemProperty() {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("kubeconfig cluster has proxy-url, then user configuration via builder takes precedence")
      void kubeConfigProxyUrl() throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-builder:3128");
      }
    }

    @Nested
    @DisplayName("all.proxy System property")
    class AllProxySystemProperty {
      @BeforeEach
      void setup() {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");
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
        System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-via-http-proxy-property:3128");
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
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-server.example:80");
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

      @Test
      @DisplayName("socks5 proxy-url with HTTP master is stored")
      void whenProxyUrlSocks5MasterUrlHttp_thenConfigStoresProxyUrl() {
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "socks5://proxy-server.example:80")
            .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-server.example:80");
      }

      @Test
      @DisplayName("http proxy-url with HTTP master is stored")
      void whenProxyUrlHttp_thenConfigStoresProxyUrl() throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("http://kubernetes-remote-server.example:6443", "http://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "http://proxy-server.example:80")
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-server.example:80");
      }

      @Test
      @DisplayName("http.proxy property configuration, kubeconfig proxy-url takes precedence")
      void httpProxySystemProperty() {
        System.setProperty("http.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "socks5://proxy-server.example:80");
      }

      @Test
      @DisplayName("all.proxy property configuration, then kubeconfig proxy-url takes precedence")
      void allProxySystemProperty() {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "socks5://proxy-server.example:80");
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

      @Test
      @DisplayName("no other proxy configuration, then https.proxy property takes precedence")
      void noOtherConfiguration() {
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-http-proxy-property:3128");
      }

      @Test
      @DisplayName("all.proxy property configuration, then https.proxy property takes precedence")
      void allProxySystemProperty() {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-http-proxy-property:3128");
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
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
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
        System.setProperty("https.proxy", "https://proxy-via-https-proxy-property:3128");

        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("all.proxy property configuration, then user configuration via builder takes precedence")
      void allProxySystemProperty() {
        System.setProperty("all.proxy", "https://proxy-via-all-proxy-property:3128");

        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }

      @Test
      @DisplayName("kubeconfig cluster has proxy-url, then user configuration via builder takes precedence")
      void kubeConfigProxyUrl() {
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-via-builder:3128");
      }
    }

    @Nested
    @DisplayName("all.proxy System property")
    class AllProxySystemProperty {
      @BeforeEach
      void setup() {
        System.setProperty("all.proxy", "http://proxy-via-all-proxy-property:3128");
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
        System.setProperty("https.proxy", "http://proxy-via-http-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "http://proxy-via-http-proxy-property:3128");
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
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster("https://kubernetes-remote-server.example:6443", "https://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-server.example:80");
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

      @Test
      @DisplayName("socks5 proxy-url with HTTPS master is stored")
      void whenProxyUrlSocks5_thenConfigStoresProxyUrl() {
        // Given
        System.setProperty("kubeconfig", Utils
            .filePath(ConfigTest.class.getResource("/config-proxy-source/kubeconfig-with-proxy-url")));
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue(
                "httpProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080")
            .hasFieldOrPropertyWithValue(
                "httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
      }

      @Test
      @DisplayName("https proxy-url with HTTPS master is stored")
      void whenProxyUrlHttps_thenConfigStoresProxyUrl() throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster(
                "https://kubernetes-remote-server.example:6443",
                "https://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "https://proxy-server.example:80")
            .hasFieldOrPropertyWithValue("httpsProxy", "https://proxy-server.example:80");
      }

      @ParameterizedTest(name = "server={0}, proxy-url={1}")
      @CsvSource({
          "https://kubernetes-remote-server.example:6443, http://proxy-server.example:80",
          "https://kubernetes-remote-server.example:6443, https://proxy-server.example:80",
          "http://kubernetes-remote-server.example:6443, http://proxy-server.example:80",
          "http://kubernetes-remote-server.example:6443, https://proxy-server.example:80"
      })
      @DisplayName("kubeconfig proxy-url applies to both HTTP and HTTPS destination proxy fields")
      void whenKubeConfigProxyUrlSet_thenProxyUrlAppliesToBothConfigFields(
          String masterUrl, String proxyUrl) throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster(masterUrl, proxyUrl).getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", proxyUrl)
            .hasFieldOrPropertyWithValue("httpsProxy", proxyUrl);
      }

      @Test
      @DisplayName("proxy-url scheme comparison is case-insensitive")
      void whenProxyUrlSchemeIsUppercase_thenConfigStoresProxyUrl() throws IOException {
        // Given
        System.setProperty("kubeconfig",
            createKubeConfigWithCluster(
                "HTTPS://kubernetes-remote-server.example:6443", "HTTP://proxy-server.example:80")
                .getAbsolutePath());
        // When + Then
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpProxy", "HTTP://proxy-server.example:80")
            .hasFieldOrPropertyWithValue("httpsProxy", "HTTP://proxy-server.example:80");
      }

      @Test
      @DisplayName("https.proxy property configuration, kubeconfig proxy-url takes precedence")
      void httpsProxySystemProperty() {
        System.setProperty("https.proxy", "https://proxy-via-http-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
      }

      @Test
      @DisplayName("all.proxy property configuration, then kubeconfig proxy-url takes precedence")
      void allProxySystemProperty() {
        System.setProperty("all.proxy", "https://proxy-via-all-proxy-property:3128");

        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy-via-kubeconfig-proxy-url:1080");
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
