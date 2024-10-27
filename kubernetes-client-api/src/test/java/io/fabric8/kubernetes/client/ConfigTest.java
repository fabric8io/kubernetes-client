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

import io.fabric8.kubernetes.api.model.ExecConfig;
import io.fabric8.kubernetes.api.model.ExecConfigBuilder;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.lib.FileSystem;
import io.fabric8.kubernetes.client.utils.Utils;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

class ConfigTest {

  private static final String TEST_KUBECONFIG_FILE = Utils.filePath(ConfigTest.class.getResource("/test-kubeconfig"));
  private static final String TEST_EC_KUBECONFIG_FILE = Utils.filePath(ConfigTest.class.getResource("/test-ec-kubeconfig"));
  private static final String TEST_NAMESPACE_FILE = Utils.filePath(ConfigTest.class.getResource("/test-namespace"));

  private static final String TEST_KUBECONFIG_EXEC_FILE = Utils.filePath(ConfigTest.class.getResource("/test-kubeconfig-exec"));
  private static final String TEST_TOKEN_GENERATOR_FILE = Utils.filePath(ConfigTest.class.getResource("/token-generator"));
  private static final String TEST_TOKEN_GENERATOR_FILE_WITH_SPACES = Utils
      .filePath(ConfigTest.class.getResource("/token-generator with spaces"));

  private static final String TEST_KUBECONFIG_EXEC_WIN_FILE = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-win"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_NULL_ARGS = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-null-args"));
  private static final String TEST_KUBECONFIG_EXEC_FILE_WIN_NULL_ARGS = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-win-null-args"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_WITH_SPACES_WIN = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-with-spaces-windows"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_WITH_SPACES = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-with-spaces"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_ARGS_WITH_SPACES_WIN = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-args-with-spaces-windows"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_ARGS_WITH_SPACES = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-args-with-spaces"));

  private static final String TEST_KUBECONFIG_NO_CURRENT_CONTEXT_FILE = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-nocurrentctxt.yml"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_CERT_AUTH = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-cert-auth"));
  private static final String TEST_KUBECONFIG_EXEC_WIN_FILE_CERT_AUTH = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-win-cert-auth"));
  private static final String TEST_KUBECONFIG_EXEC_FILE_CERT_AUTH_EC_INVALID = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-cert-auth-ec-invalid"));
  private static final String TEST_KUBECONFIG_EXEC_WIN_FILE_CERT_AUTH_EC_INVALID = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-win-cert-auth-ec-invalid"));
  private static final String TEST_CERT_GENERATOR_FILE = Utils.filePath(ConfigTest.class.getResource("/cert-generator"));

  @Nested
  @DisplayName("System Properties Configured")
  class SystemPropertiesConfigured {
    @BeforeEach
    void setUp() {
      System.setProperty("kubernetes.master", "http://somehost:80");
      System.setProperty("kubernetes.namespace", "testns");
      System.setProperty("kubernetes.auth.token", "token");
      System.setProperty("kubernetes.auth.basic.username", "user");
      System.setProperty("kubernetes.auth.basic.password", "pass");
      System.setProperty("kubernetes.trust.certificates", "true");
      System.setProperty("kubernetes.disable.hostname.verification", "true");
      System.setProperty("kubernetes.certs.ca.file", "/path/to/cert");
      System.setProperty("kubernetes.certs.ca.data", "cacertdata");
      System.setProperty("kubernetes.certs.client.file", "/path/to/clientcert");
      System.setProperty("kubernetes.certs.client.data", "clientcertdata");
      System.setProperty("kubernetes.certs.client.key.file", "/path/to/clientkey");
      System.setProperty("kubernetes.certs.client.key.data", "clientkeydata");
      System.setProperty("kubernetes.certs.client.key.algo", "algo");
      System.setProperty("kubernetes.certs.client.key.passphrase", "passphrase");
      System.setProperty("kubernetes.certs.client.key.file", "/path/to/clientkey");
      System.setProperty("kubernetes.max.concurrent.requests", "120");
      System.setProperty("kubernetes.max.concurrent.requests.per.host", "20");
      System.setProperty("kubernetes.watch.reconnectInterval", "5000");
      System.setProperty("kubernetes.watch.reconnectLimit", "5");
      System.setProperty("kubernetes.request.timeout", "5000");
      System.setProperty("http.proxy", "httpProxy");
      System.setProperty("kubernetes.tls.versions", "TLSv1.2,TLSv1.1");
      System.setProperty("kubernetes.truststore.file", "/path/to/truststore");
      System.setProperty("kubernetes.truststore.passphrase", "truststorePassphrase");
      System.setProperty("kubernetes.keystore.file", "/path/to/keystore");
      System.setProperty("kubernetes.keystore.passphrase", "keystorePassphrase");
      System.setProperty("kubernetes.upload.request.timeout", "600000");
      System.setProperty("kubernetes.websocket.ping.interval", "1000");
      System.setProperty("kubernetes.connection.timeout", "1000");
      System.setProperty("kubernetes.scale.timeout", "1000");
      System.setProperty("https.proxy", "httpsProxy");
      System.setProperty("no.proxy", "no-proxy-url1.io,no-proxy-url2.io");
      System.setProperty("proxy.username", "proxyUsername");
      System.setProperty("proxy.password", "proxyPassword");
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubernetes.master");
      System.clearProperty("kubernetes.namespace");
      System.clearProperty("kubernetes.auth.token");
      System.clearProperty("kubernetes.auth.basic.username");
      System.clearProperty("kubernetes.auth.basic.password");
      System.clearProperty("kubernetes.trust.certificates");
      System.clearProperty("kubernetes.disable.hostname.verification");
      System.clearProperty("kubernetes.certs.ca.file");
      System.clearProperty("kubernetes.certs.ca.data");
      System.clearProperty("kubernetes.certs.client.file");
      System.clearProperty("kubernetes.certs.client.data");
      System.clearProperty("kubernetes.certs.client.key.file");
      System.clearProperty("kubernetes.certs.client.key.data");
      System.clearProperty("kubernetes.certs.client.key.algo");
      System.clearProperty("kubernetes.certs.client.key.passphrase");
      System.clearProperty("kubernetes.certs.client.key.file");
      System.clearProperty("kubernetes.max.concurrent.requests");
      System.clearProperty("kubernetes.max.concurrent.requests.per.host");
      System.clearProperty("kubernetes.watch.reconnectInterval");
      System.clearProperty("kubernetes.watch.reconnectLimit");
      System.clearProperty("kubernetes.request.timeout");
      System.clearProperty("http.proxy");
      System.clearProperty("kubernetes.tls.versions");
      System.clearProperty("kubernetes.truststore.file");
      System.clearProperty("kubernetes.truststore.passphrase");
      System.clearProperty("kubernetes.keystore.file");
      System.clearProperty("kubernetes.keystore.passphrase");
      System.clearProperty("kubernetes.upload.request.timeout");
      System.clearProperty("kubernetes.websocket.ping.interval");
      System.clearProperty("kubernetes.connection.timeout");
      System.clearProperty("kubernetes.scale.timeout");
      System.clearProperty("https.proxy");
      System.clearProperty("no.proxy");
      System.clearProperty("proxy.username");
      System.clearProperty("proxy.password");
    }

    @Test
    @DisplayName("no args Config constructor, should load from properties")
    void zeroArgumentConstructor_whenInvoked_shouldLoadFromProperties() {
      assertThat(new Config())
          .isNotNull()
          .hasFieldOrPropertyWithValue("trustCerts", true)
          .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
          .hasFieldOrPropertyWithValue("namespace", "testns")
          .hasFieldOrPropertyWithValue("username", "user")
          .hasFieldOrPropertyWithValue("password", "pass")
          .hasFieldOrPropertyWithValue("caCertFile", "/path/to/cert")
          .hasFieldOrPropertyWithValue("caCertData", "cacertdata")
          .hasFieldOrPropertyWithValue("clientCertFile", "/path/to/clientcert")
          .hasFieldOrPropertyWithValue("clientCertData", "clientcertdata")
          .hasFieldOrPropertyWithValue("clientKeyFile", "/path/to/clientkey")
          .hasFieldOrPropertyWithValue("clientKeyData", "clientkeydata")
          .hasFieldOrPropertyWithValue("clientKeyAlgo", "algo")
          .hasFieldOrPropertyWithValue("clientKeyPassphrase", "passphrase")
          .hasFieldOrPropertyWithValue("httpProxy", "httpProxy")
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("watchReconnectLimit", 5)
          .hasFieldOrPropertyWithValue("requestTimeout", 5000)
          .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 600000)
          .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 })
          .hasFieldOrPropertyWithValue("trustStoreFile", "/path/to/truststore")
          .hasFieldOrPropertyWithValue("trustStorePassphrase", "truststorePassphrase")
          .hasFieldOrPropertyWithValue("keyStoreFile", "/path/to/keystore")
          .hasFieldOrPropertyWithValue("keyStorePassphrase", "keystorePassphrase")
          .hasFieldOrPropertyWithValue("maxConcurrentRequests", 120)
          .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 20)
          .hasFieldOrPropertyWithValue("websocketPingInterval", 1000L)
          .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
          .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("httpsProxy", "httpsProxy")
          .hasFieldOrPropertyWithValue("proxyUsername", "proxyUsername")
          .hasFieldOrPropertyWithValue("proxyPassword", "proxyPassword")
          .hasFieldOrPropertyWithValue("noProxy", new String[] { "no-proxy-url1.io", "no-proxy-url2.io" })
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token");
    }

    @Test
    @DisplayName("ConfigBuilder, should load from properties")
    void configBuilder_whenInvoked_shouldLoadFromProperties() {
      assertThat(new ConfigBuilder().build())
          .isNotNull()
          .hasFieldOrPropertyWithValue("trustCerts", true)
          .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
          .hasFieldOrPropertyWithValue("namespace", "testns")
          .hasFieldOrPropertyWithValue("username", "user")
          .hasFieldOrPropertyWithValue("password", "pass")
          .hasFieldOrPropertyWithValue("caCertFile", "/path/to/cert")
          .hasFieldOrPropertyWithValue("caCertData", "cacertdata")
          .hasFieldOrPropertyWithValue("clientCertFile", "/path/to/clientcert")
          .hasFieldOrPropertyWithValue("clientCertData", "clientcertdata")
          .hasFieldOrPropertyWithValue("clientKeyFile", "/path/to/clientkey")
          .hasFieldOrPropertyWithValue("clientKeyData", "clientkeydata")
          .hasFieldOrPropertyWithValue("clientKeyAlgo", "algo")
          .hasFieldOrPropertyWithValue("clientKeyPassphrase", "passphrase")
          .hasFieldOrPropertyWithValue("httpProxy", "httpProxy")
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("watchReconnectLimit", 5)
          .hasFieldOrPropertyWithValue("requestTimeout", 5000)
          .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 600000)
          .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 })
          .hasFieldOrPropertyWithValue("trustStoreFile", "/path/to/truststore")
          .hasFieldOrPropertyWithValue("trustStorePassphrase", "truststorePassphrase")
          .hasFieldOrPropertyWithValue("keyStoreFile", "/path/to/keystore")
          .hasFieldOrPropertyWithValue("keyStorePassphrase", "keystorePassphrase")
          .hasFieldOrPropertyWithValue("maxConcurrentRequests", 120)
          .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 20)
          .hasFieldOrPropertyWithValue("websocketPingInterval", 1000L)
          .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
          .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("httpsProxy", "httpsProxy")
          .hasFieldOrPropertyWithValue("proxyUsername", "proxyUsername")
          .hasFieldOrPropertyWithValue("proxyPassword", "proxyPassword")
          .hasFieldOrPropertyWithValue("noProxy", new String[] { "no-proxy-url1.io", "no-proxy-url2.io" })
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token");
    }

    @Test
    @DisplayName("ConfigBuilder, with builder methods, should override properties")
    void configBuilder_withBuilderMethods_shouldOverrideFieldsConfiguredViaProperties() {
      Config config = new ConfigBuilder()
          .withMasterUrl("http://somehost-via-builder:80")
          .withNamespace("testns-via-builder")
          .build();

      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("trustCerts", true)
          .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost-via-builder:80/")
          .hasFieldOrPropertyWithValue("namespace", "testns-via-builder")
          .hasFieldOrPropertyWithValue("username", "user")
          .hasFieldOrPropertyWithValue("password", "pass")
          .hasFieldOrPropertyWithValue("caCertFile", "/path/to/cert")
          .hasFieldOrPropertyWithValue("caCertData", "cacertdata")
          .hasFieldOrPropertyWithValue("clientCertFile", "/path/to/clientcert")
          .hasFieldOrPropertyWithValue("clientCertData", "clientcertdata")
          .hasFieldOrPropertyWithValue("clientKeyFile", "/path/to/clientkey")
          .hasFieldOrPropertyWithValue("clientKeyData", "clientkeydata")
          .hasFieldOrPropertyWithValue("clientKeyAlgo", "algo")
          .hasFieldOrPropertyWithValue("clientKeyPassphrase", "passphrase")
          .hasFieldOrPropertyWithValue("httpProxy", "httpProxy")
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("watchReconnectLimit", 5)
          .hasFieldOrPropertyWithValue("requestTimeout", 5000)
          .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 600000)
          .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 })
          .hasFieldOrPropertyWithValue("trustStoreFile", "/path/to/truststore")
          .hasFieldOrPropertyWithValue("trustStorePassphrase", "truststorePassphrase")
          .hasFieldOrPropertyWithValue("keyStoreFile", "/path/to/keystore")
          .hasFieldOrPropertyWithValue("keyStorePassphrase", "keystorePassphrase")
          .hasFieldOrPropertyWithValue("maxConcurrentRequests", 120)
          .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 20)
          .hasFieldOrPropertyWithValue("websocketPingInterval", 1000L)
          .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
          .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("httpsProxy", "httpsProxy")
          .hasFieldOrPropertyWithValue("proxyUsername", "proxyUsername")
          .hasFieldOrPropertyWithValue("proxyPassword", "proxyPassword")
          .hasFieldOrPropertyWithValue("noProxy", new String[] { "no-proxy-url1.io", "no-proxy-url2.io" })
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token");
    }
  }

  @Test
  @DisplayName("when fields configured via builder, then fields get most precedence")
  void builder_whenInvoked_shouldCreateConfigWithConfiguredFields() {
    // Given + When
    Config config = new ConfigBuilder()
        .withMasterUrl("http://somehost:80")
        .withApiVersion("v1")
        .withNamespace("testns")
        .withOauthToken("token")
        .withUsername("user")
        .withPassword("pass")
        .withTrustCerts(true)
        .withDisableHostnameVerification(true)
        .withCaCertFile("/path/to/cert")
        .withCaCertData("cacertdata")
        .withClientCertFile("/path/to/clientcert")
        .withClientCertData("clientcertdata")
        .withClientKeyFile("/path/to/clientkey")
        .withClientKeyData("clientkeydata")
        .withClientKeyAlgo("algo")
        .withClientKeyPassphrase("passphrase")
        .withMaxConcurrentRequests(120)
        .withMaxConcurrentRequestsPerHost(20)
        .withWatchReconnectInterval(5000)
        .withWatchReconnectLimit(5)
        .withRequestTimeout(5000)
        .withUploadRequestTimeout(600000)
        .withHttpProxy("httpProxy")
        .withHttpsProxy("httpsProxy")
        .withProxyUsername("proxyUsername")
        .withProxyPassword("proxyPassword")
        .withNoProxy("no-proxy-url1.io", "no-proxy-url2.io")
        .withTlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1)
        .withTrustStoreFile("/path/to/truststore")
        .withTrustStorePassphrase("truststorePassphrase")
        .withKeyStoreFile("/path/to/keystore")
        .withKeyStorePassphrase("keystorePassphrase")
        .withHttp2Disable(false)
        .withWebsocketPingInterval(1000L)
        .withConnectionTimeout(1000)
        .withScaleTimeout(1000L)
        .build();
    // Then
    assertThat(config)
        .isNotNull()
        .hasFieldOrPropertyWithValue("trustCerts", true)
        .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
        .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
        .hasFieldOrPropertyWithValue("namespace", "testns")
        .hasFieldOrPropertyWithValue("username", "user")
        .hasFieldOrPropertyWithValue("password", "pass")
        .hasFieldOrPropertyWithValue("caCertFile", "/path/to/cert")
        .hasFieldOrPropertyWithValue("caCertData", "cacertdata")
        .hasFieldOrPropertyWithValue("clientCertFile", "/path/to/clientcert")
        .hasFieldOrPropertyWithValue("clientCertData", "clientcertdata")
        .hasFieldOrPropertyWithValue("clientKeyFile", "/path/to/clientkey")
        .hasFieldOrPropertyWithValue("clientKeyData", "clientkeydata")
        .hasFieldOrPropertyWithValue("clientKeyAlgo", "algo")
        .hasFieldOrPropertyWithValue("clientKeyPassphrase", "passphrase")
        .hasFieldOrPropertyWithValue("httpProxy", "httpProxy")
        .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
        .hasFieldOrPropertyWithValue("watchReconnectLimit", 5)
        .hasFieldOrPropertyWithValue("requestTimeout", 5000)
        .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 600000)
        .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 })
        .hasFieldOrPropertyWithValue("trustStoreFile", "/path/to/truststore")
        .hasFieldOrPropertyWithValue("trustStorePassphrase", "truststorePassphrase")
        .hasFieldOrPropertyWithValue("keyStoreFile", "/path/to/keystore")
        .hasFieldOrPropertyWithValue("keyStorePassphrase", "keystorePassphrase")
        .hasFieldOrPropertyWithValue("maxConcurrentRequests", 120)
        .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 20)
        .hasFieldOrPropertyWithValue("websocketPingInterval", 1000L)
        .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
        .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
        .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
        .hasFieldOrPropertyWithValue("http2Disable", false)
        .hasFieldOrPropertyWithValue("httpsProxy", "httpsProxy")
        .hasFieldOrPropertyWithValue("proxyUsername", "proxyUsername")
        .hasFieldOrPropertyWithValue("proxyPassword", "proxyPassword")
        .hasFieldOrPropertyWithValue("noProxy", new String[] { "no-proxy-url1.io", "no-proxy-url2.io" })
        .hasFieldOrPropertyWithValue("oauthToken", "token");
  }

  @Test
  @DisplayName("no additional config, should use default value for webSocketPingInterval")
  void builder_whenInvoked_shouldHonorDefaultWebsocketPingInterval() {
    // Given + When
    Config config = new ConfigBuilder().build();
    // Then
    assertThat(config.getWebsocketPingInterval())
        .isEqualTo(30000L);
  }

  @Nested
  @DisplayName("Inside Kubernetes cluster")
  class InCluster {
    @BeforeEach
    void setUp() {
      System.setProperty("kubeconfig", "/dev/null");
      System.clearProperty("kubernetes.master");
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubeconfig");
    }

    @Test
    @DisplayName("when KUBERNETES_SERVICE_HOST,KUBERNETES_SERVICE_PORT env variables present, then compute masterUrl from environment variables")
    void autoConfigure_whenKubernetesServiceEnvironmentVariablesPresent_thenComputeMasterUrlFromEnvironmentVariables() {
      try {
        // Given
        System.setProperty("KUBERNETES_SERVICE_HOST", "10.0.0.1");
        System.setProperty("KUBERNETES_SERVICE_PORT", "443");
        // When
        Config config = Config.autoConfigure(null);
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("masterUrl", "https://10.0.0.1:443/")
            .hasFieldOrPropertyWithValue("file", null);
      } finally {
        System.clearProperty("KUBERNETES_SERVICE_HOST");
        System.clearProperty("KUBERNETES_SERVICE_PORT");
      }
    }

    @Test
    @DisplayName("refresh() creates new instance when invoked")
    void refresh_whenInvoked_shouldCreateNewInstance() {
      Config config = Config.autoConfigure(null);
      assertThat(config)
          .hasFieldOrPropertyWithValue("file", null)
          .hasFieldOrPropertyWithValue("autoConfigure", true);

      // ensure that refresh creates a new instance
      Config refresh = config.refresh();
      assertThat(refresh)
          .isNotSameAs(config)
          .hasFieldOrPropertyWithValue("file", null)
          .hasFieldOrPropertyWithValue("autoConfigure", true);
    }

    @Test
    @DisplayName("when KUBERNETES_SERVICE_HOST,KUBERNETES_SERVICE_PORT env variables present with IPv6 address, then compute masterUrl from environment variables")
    void autoConfigure_whenKubernetesServiceEnvironmentVariablesPresentWithIPv6_thenComputeMasterUrlFromEnvironmentVariables() {
      try {
        // Given
        System.setProperty("KUBERNETES_SERVICE_HOST", "2001:db8:1f70::999:de8:7648:6e8");
        System.setProperty("KUBERNETES_SERVICE_PORT", "443");
        // When
        Config config = Config.autoConfigure(null);
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("masterUrl", "https://[2001:db8:1f70::999:de8:7648:6e8]:443/")
            .hasFieldOrPropertyWithValue("file", null);
      } finally {
        System.clearProperty("KUBERNETES_SERVICE_HOST");
        System.clearProperty("KUBERNETES_SERVICE_PORT");
      }
    }

    @Test
    @DisplayName("when ServiceAccount token file provided, then use it as autoOAuthToken")
    void whenServiceAccountTokenPathProvided_thenUseThatToken() {
      try {
        // Given
        System.setProperty("kubernetes.auth.serviceAccount.token",
            Utils.filePath(ConfigTest.class.getResource("/test-serviceaccount/token")));
        // When
        Config config = new ConfigBuilder().build();
        // Then
        assertThat(config.getAutoOAuthToken()).contains("token-from-mounted-serviceaccount");
      } finally {
        System.clearProperty("kubernetes.auth.serviceAccount.token");
      }
    }

    @Test
    @DisplayName("when ServiceAccount certificate file provided, then use it as caCertFile")
    void whenServiceAccountCertFilePathProvided_thenUseThatToken() {
      try {
        // Given
        String certFilePath = Utils.filePath(ConfigTest.class.getResource("/test-serviceaccount/ca.crt"));
        System.setProperty("kubernetes.certs.ca.file", certFilePath);
        // When
        Config config = new ConfigBuilder().build();
        // Then
        assertThat(config.getCaCertFile()).isEqualTo(certFilePath);
      } finally {
        System.clearProperty("kubernetes.certs.ca.file");
      }
    }

    @Test
    @DisplayName("when kubernetes.tryNamespacePath=false, then do NOT read ServiceAccount files")
    void whenTryNamespacePathDisabled_thenDoNotUseServiceAccountAttributes() {
      try {
        // Given
        System.setProperty("kubernetes.auth.tryServiceAccount", "false");
        System.setProperty("kubernetes.auth.serviceAccount.token",
            Utils.filePath(ConfigTest.class.getResource("/test-serviceaccount/token")));
        // When
        Config config = new ConfigBuilder().build();
        // Then
        assertThat(config.getAutoOAuthToken()).isNull();
      } finally {
        System.clearProperty("kubernetes.auth.tryServiceAccount");
        System.clearProperty("kubernetes.auth.serviceAccount.token");
      }
    }
  }

  @Nested
  @DisplayName("kubeconfig present")
  class KubeConfigPresent {
    @BeforeEach
    void setUp() {
      System.setProperty("kubeconfig", TEST_KUBECONFIG_FILE);
      System.clearProperty("kubernetes.namespace");
    }

    @Test
    @DisplayName("new Config() should auto configure from kubeconfig")
    void noArgConstructor_shouldAutoConfigureFromKubeConfig() {
      assertThat(new Config())
          .isNotNull()
          .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
          .hasFieldOrPropertyWithValue("namespace", "testns")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "token")
          .satisfies(c -> assertThat(c.getCaCertFile()).endsWith("testns/ca.pem".replace("/", File.separator)))
          .satisfies(c -> assertThat(new File(c.getCaCertFile())).isAbsolute())
          .hasFieldOrPropertyWithValue("file", new File(TEST_KUBECONFIG_FILE));
    }

    @Test
    @DisplayName("Config.autoConfigure with overridden context")
    void overrideContext() {
      assertThat(Config.autoConfigure("production/172-28-128-4:8443/root"))
          .isNotNull()
          .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
          .hasFieldOrPropertyWithValue("namespace", "production")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "supertoken")
          .satisfies(c -> assertThat(c.getCaCertFile()).endsWith("testns/ca.pem".replace("/", File.separator)))
          .satisfies(c -> assertThat(new File(c.getCaCertFile())).isAbsolute());
    }
  }

  @Nested
  @DisplayName("load fromKubeConfig")
  class FromKubeConfig {
    @BeforeEach
    void setUp() {
      System.clearProperty("kubeconfig");
      System.clearProperty("kubernetes.master");
    }

    @Test
    @DisplayName("standard kubeconfig file")
    void fromKubeConfigContent() throws IOException {
      // Given + When
      final Config config = Config.fromKubeconfig(prepareKubeConfigYamlFrom(TEST_KUBECONFIG_FILE));
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
          .hasFieldOrPropertyWithValue("autoConfigure", false)
          .hasFieldOrPropertyWithValue("file", null)
          .isSameAs(config.refresh());
    }

    @Test
    @DisplayName("kubeconfig with EC Private Data in client key")
    void shouldAutoDetectClientKeyAlgo() throws IOException {
      // Given + When
      final Config config = Config.fromKubeconfig(prepareKubeConfigYamlFrom(TEST_EC_KUBECONFIG_FILE));
      // Then
      assertThat(config.getClientKeyAlgo()).isEqualTo("EC");
    }

    private String prepareKubeConfigYamlFrom(String filePath) throws IOException {
      File configFile = new File(filePath);
      return String.join(System.lineSeparator(), Files.readAllLines(configFile.toPath()));
    }
  }

  @Test
  @DisplayName("when multiple kube config files in property, then pick first one")
  void autoConfigure_withMultipleKubeConfigAndOverrideContext_shouldPickFirstFile() {
    try {
      // Given
      System.setProperty("kubeconfig", TEST_KUBECONFIG_FILE + File.pathSeparator + "some-other-file");
      // When
      Config config = Config.autoConfigure("production/172-28-128-4:8443/root");
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
          .hasFieldOrPropertyWithValue("namespace", "production")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "supertoken")
          .satisfies(c -> assertThat(c.getCaCertFile()).endsWith("testns/ca.pem".replace("/", File.separator)))
          .satisfies(c -> assertThat(new File(c.getCaCertFile())).isAbsolute());
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  @DisplayName("when kubenamespace file property provided, then read namespace from this file")
  void whenNamespacePathFilePropertyConfigured_shouldUpdateNamespace() {
    try {
      // Given
      System.setProperty("kubeconfig", "nokubeconfigfile");
      System.setProperty("kubenamespace", TEST_NAMESPACE_FILE);
      System.setProperty("kubernetes.master", "http://somehost:80");
      // When
      Config config = new Config();
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
          .hasFieldOrPropertyWithValue("namespace", "testnsfrompath");
    } finally {
      System.clearProperty("kubeconfig");
      System.clearProperty("kubenamespace");
      System.clearProperty("kubernetes.master");
    }
  }

  @Test
  @DisplayName("kubenamespace property configured with non existent file, then do NOT update Config's namespace")
  void whenNamespacePathFilePropertyConfiguredWithNonExistentFile_shouldNotUpdateNamespace() {
    try {
      // Given
      System.setProperty("kubeconfig", "nokubeconfigfile");
      System.setProperty("kubenamespace", "nonamespace");
      System.setProperty("kubernetes.master", "http://somehost:80");
      // When
      Config config = new Config();
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
          .hasFieldOrPropertyWithValue("namespace", null);
    } finally {
      System.clearProperty("kubeconfig");
      System.clearProperty("kubenamespace");
      System.clearProperty("kubernetes.master");
    }
  }

  @Test
  @DisplayName("kubenamespace property and kubernetes.namespace property provided, then kubernetes.namespace takes precedence")
  void whenNamespacePathFilePropertyAndNamespacePropertyProvided_thenNamespacePropertyTakesPrecedence() {
    try {
      // Given
      System.setProperty("kubenamespace", TEST_NAMESPACE_FILE);
      System.setProperty("kubernetes.master", "http://somehost:80");
      System.setProperty("kubernetes.namespace", "testns");
      // When
      Config config = new Config();
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
          .hasFieldOrPropertyWithValue("namespace", "testns");
    } finally {
      System.clearProperty("kubenamespace");
      System.clearProperty("kubernetes.master");
      System.clearProperty("kubernetes.namespace");
    }
  }

  @Test
  @DisplayName("no currentContext set in kubeconfig, then do NOT set currentContext in kubeconfig")
  void whenNoCurrentContextInKubeConfig_thenDoNotSetCurrentContext() {
    try {
      // Given
      System.setProperty("kubeconfig", TEST_KUBECONFIG_NO_CURRENT_CONTEXT_FILE);
      // When
      Config config = new Config();
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("currentContext", null)
          .hasFieldOrPropertyWithValue("namespace", null)
          .hasFieldOrPropertyWithValue("masterUrl", "https://kubernetes.default.svc/")
          .extracting(Config::getContexts)
          .asInstanceOf(InstanceOfAssertFactories.list(NamedContext.class))
          .hasSize(3);
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  @DisplayName("kubenamespace, kubernetes.namespace and ConfigBuilder.withNamespace provided, ConfigBuilder.withNamespace takes precedence")
  void whenNamespacePathAndSystemPropertiesAndBuilderProvided_thenBuilderTakesPrecedence() {
    try {
      // Given
      System.setProperty("kubenamespace", TEST_NAMESPACE_FILE);
      System.setProperty("kubernetes.master", "http://somehost:80");
      System.setProperty("kubernetes.namespace", "tobeoverriden");
      // When
      Config config = new ConfigBuilder()
          .withNamespace("testns2")
          .build();
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "http://somehost:80/")
          .hasFieldOrPropertyWithValue("namespace", "testns2");
    } finally {
      System.clearProperty("kubenamespace");
      System.clearProperty("kubernetes.master");
      System.clearProperty("kubernetes.namespace");
    }
  }

  @Test
  @DisplayName("customHeaders configured via builder, then set customHeaders in Config")
  void whenCustomHeaderProvidedViaBuilder_thenSetCustomHeaderInConfig() {
    // Given
    Map<String, String> customHeaders = new HashMap<>();
    customHeaders.put("user-id", "test-user");
    customHeaders.put("cluster-id", "test-cluster");
    // When
    Config config = new ConfigBuilder()
        .withCustomHeaders(customHeaders)
        .build();
    // Then
    assertThat(config)
        .isNotNull()
        .extracting(Config::getCustomHeaders)
        .asInstanceOf(InstanceOfAssertFactories.MAP)
        .hasSize(2);
  }

  @Test
  @DisplayName("when impersonate-username, impersonate-extras configured via System Properties and ConfigBuilder, then ConfigBuilder takes precedence")
  void shouldSetImpersonateUsernameAndGroupFromSystemProperty() {
    try {
      // Given
      System.setProperty("kubernetes.impersonate.username", "username");
      System.setProperty("kubernetes.impersonate.group", "group");
      final Map<String, List<String>> extras = new HashMap<>();
      extras.put("c", Collections.singletonList("d"));
      // When
      final Config config = new ConfigBuilder()
          .withImpersonateUsername("a")
          .withImpersonateExtras(extras)
          .build();
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("requestConfig.impersonateUsername", "a")
          .hasFieldOrPropertyWithValue("requestConfig.impersonateGroups", new String[] { "group" })
          .hasFieldOrPropertyWithValue("requestConfig.impersonateExtras",
              Collections.singletonMap("c", Collections.singletonList("d")));
    } finally {
      System.clearProperty("kubernetes.impersonate.username");
      System.clearProperty("kubernetes.impersonate.group");
    }
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void honorClientAuthenticatorCommandsOnWindows() {
    try {
      // Given
      System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_WIN_FILE);
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("autoOAuthToken", "HELLO WORLD");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  @DisabledOnOs(OS.WINDOWS)
  void honorClientAuthenticatorCommands() throws Exception {
    try {
      // Given
      Files.setPosixFilePermissions(Paths.get(TEST_TOKEN_GENERATOR_FILE), PosixFilePermissions.fromString("rwxrwxr-x"));
      System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE);
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("autoOAuthToken", "HELLO WORLD");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  void should_accept_client_authentication_commands_with_null_args() throws Exception {
    try {
      // Given
      if (FileSystem.getCurrent() == FileSystem.WINDOWS) {
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_WIN_NULL_ARGS);
      } else {
        Files.setPosixFilePermissions(Paths.get(TEST_TOKEN_GENERATOR_FILE), PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_NULL_ARGS);
      }
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("autoOAuthToken", "HELLO");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  @DisplayName("when arguments in kubeconfig, then add client cert data to Config")
  void autoConfigure_whenCommandLineArgsProvided_thenLoadClientCertData() throws Exception {
    try {
      // Given
      if (FileSystem.getCurrent() == FileSystem.WINDOWS) {
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_WIN_FILE_CERT_AUTH);
      } else {
        Files.setPosixFilePermissions(Paths.get(TEST_CERT_GENERATOR_FILE), PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_CERT_AUTH);
      }
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("clientCertData", "CERT DATA")
          .hasFieldOrPropertyWithValue("clientKeyData", "KEY DATA");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  @DisplayName("when invalid arguments in kubeconfig, then do not add client cert data to Config")
  void autoConfigure_whenInvalidArgsProvided_thenDoNotLoadClientCertData() throws Exception {
    try {
      // Given
      if (FileSystem.getCurrent() == FileSystem.WINDOWS) {
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_WIN_FILE_CERT_AUTH_EC_INVALID);
      } else {
        Files.setPosixFilePermissions(Paths.get(TEST_CERT_GENERATOR_FILE), PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_CERT_AUTH_EC_INVALID);
      }
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("clientCertData", null)
          .hasFieldOrPropertyWithValue("clientKeyData", null);
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  void should_accept_client_authentication_commands_args_with_spaces() throws Exception {
    try {
      // Given
      if (FileSystem.getCurrent() == FileSystem.WINDOWS) {
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_ARGS_WITH_SPACES_WIN);
      } else {
        Files.setPosixFilePermissions(Paths.get(TEST_TOKEN_GENERATOR_FILE_WITH_SPACES),
            PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_ARGS_WITH_SPACES);
      }
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("autoOAuthToken", "HELLO W O R L D");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  void should_accept_client_authentication_commands_with_spaces() throws Exception {
    try {
      // Given
      if (FileSystem.getCurrent() == FileSystem.WINDOWS) {
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_WITH_SPACES_WIN);
      } else {
        Files.setPosixFilePermissions(Paths.get(TEST_TOKEN_GENERATOR_FILE_WITH_SPACES),
            PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty("kubeconfig", TEST_KUBECONFIG_EXEC_FILE_WITH_SPACES);
      }
      // When
      Config config = Config.autoConfigure(null);
      // Then
      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("autoOAuthToken", "HELLO WORLD");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  void shouldBeUsedTokenSuppliedByProvider() {
    // Given
    Config config = new ConfigBuilder().withOauthToken("oauthToken")
        .withOauthTokenProvider(() -> "PROVIDER_TOKEN")
        .build();

    // When + Then
    // this is mostly a configuration error, and
    // the provider does not modify the oauthtoken field
    assertThat(config.getOauthToken()).isEqualTo("oauthToken");
  }

  @Test
  @DisplayName("kubeconfig contains auth-provider, then read token from auth-provider section")
  void whenKubeConfigWithAuthConfigProvider_thenLoadTokenFromAuthProvider() throws URISyntaxException {
    try {
      // Given
      System.setProperty("kubeconfig", new File(getClass().getResource("/test-kubeconfig").toURI()).getAbsolutePath());
      // When
      Config config = Config.autoConfigure("production/172-28-128-4:8443/mmosley");
      // Then
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
          .hasFieldOrPropertyWithValue("autoOAuthToken",
              "eyJraWQiOiJDTj1vaWRjaWRwLnRyZW1vbG8ubGFuLCBPVT1EZW1vLCBPPVRybWVvbG8gU2VjdXJpdHksIEw9QXJsaW5ndG9uLCBTVD1WaXJnaW5pYSwgQz1VUy1DTj1rdWJlLWNhLTEyMDIxNDc5MjEwMzYwNzMyMTUyIiwiYWxnIjoiUlMyNTYifQ.eyJpc3MiOiJodHRwczovL29pZGNpZHAudHJlbW9sby5sYW46ODQ0My9hdXRoL2lkcC9PaWRjSWRQIiwiYXVkIjoia3ViZXJuZXRlcyIsImV4cCI6MTQ4MzU0OTUxMSwianRpIjoiMm96US15TXdFcHV4WDlHZUhQdy1hZyIsImlhdCI6MTQ4MzU0OTQ1MSwibmJmIjoxNDgzNTQ5MzMxLCJzdWIiOiI0YWViMzdiYS1iNjQ1LTQ4ZmQtYWIzMC0xYTAxZWU0MWUyMTgifQ.w6p4J_6qQ1HzTG9nrEOrubxIMb9K5hzcMPxc9IxPx2K4xO9l-oFiUw93daH3m5pluP6K7eOE6txBuRVfEcpJSwlelsOsW8gb8VJcnzMS9EnZpeA0tW_p-mnkFc3VcfyXuhe5R3G7aa5d8uHv70yJ9Y3-UhjiN9EhpMdfPAoEB9fYKKkJRzF7utTTIPGrSaSU6d2pcpfYKaxIwePzEkT4DfcQthoZdy9ucNvvLoi1DIC-UocFD8HLs8LYKEqSxQvOcvnThbObJ9af71EwmuE21fO5KzMW20KtAeget1gnldOosPtz1G5EwvaQ401-RPQzPGMVBld0_zMCAwZttJ4knw");
    } finally {
      System.clearProperty("kubeconfig");
    }
  }

  @Test
  @DisplayName("Config.empty() should create an empty non auto-configured instance")
  void emptyConfig() {
    // Given
    Config emptyConfig = null;

    // When
    emptyConfig = Config.empty();

    // Then
    assertThat(emptyConfig)
        .hasFieldOrPropertyWithValue("masterUrl", "https://kubernetes.default.svc/")
        .hasFieldOrPropertyWithValue("contexts", Collections.emptyList())
        .hasFieldOrPropertyWithValue("maxConcurrentRequests", 64)
        .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 5)
        .hasFieldOrPropertyWithValue("trustCerts", false)
        .hasFieldOrPropertyWithValue("disableHostnameVerification", false)
        .hasFieldOrPropertyWithValue("clientKeyAlgo", "RSA")
        .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
        .hasFieldOrPropertyWithValue("watchReconnectInterval", 1000)
        .hasFieldOrPropertyWithValue("watchReconnectLimit", -1)
        .hasFieldOrPropertyWithValue("connectionTimeout", 10000)
        .hasFieldOrPropertyWithValue("requestTimeout", 10000)
        .hasFieldOrPropertyWithValue("scaleTimeout", 600000L)
        .hasFieldOrPropertyWithValue("loggingInterval", 20000)
        .hasFieldOrPropertyWithValue("websocketPingInterval", 30000L)
        .hasFieldOrPropertyWithValue("uploadRequestTimeout", 120000)
        .hasFieldOrPropertyWithValue("impersonateExtras", Collections.emptyMap())
        .hasFieldOrPropertyWithValue("http2Disable", false)
        .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2 })
        .satisfies(e -> assertThat(e.getCurrentContext()).isNull())
        .satisfies(e -> assertThat(e.getImpersonateGroups()).isEmpty())
        .satisfies(e -> assertThat(e.getUserAgent()).isNotNull());
  }

  @Test
  @DisplayName("should create expected authenticator command for aws")
  void getAuthenticatorCommandFromExecConfig_whenAwsCommandUsed_thenUseCommandLineArgsInExecCommand() throws IOException {
    // Given
    File commandFolder = Files.createTempDirectory("test").toFile();
    File commandFile = new File(commandFolder, "aws");
    Files.createFile(commandFile.toPath());
    String systemPathValue = getTestPathValue(commandFolder);
    ExecConfig execConfig = new ExecConfigBuilder()
        .withApiVersion("client.authentication.k8s.io/v1alpha1")
        .addToArgs("--region", "us-west2", "eks", "get-token", "--cluster-name", "api-eks.example.com")
        .withCommand("aws")
        .build();

    // When
    List<String> processBuilderArgs = Config.getAuthenticatorCommandFromExecConfig(execConfig, new File("~/.kube/config"),
        systemPathValue);

    // Then
    assertThat(processBuilderArgs)
        .isNotNull()
        .hasSize(3);
    assertPlatformPrefixes(processBuilderArgs);
    List<String> commandParts = Arrays.asList(processBuilderArgs.get(2).split(" "));
    assertThat(commandParts)
        .containsExactly(commandFile.getAbsolutePath(), "--region", "us-west2", "eks",
            "get-token", "--cluster-name", "api-eks.example.com");
  }

  @Test
  @DisplayName("should generate expected authenticator command for gke-gcloud-auth-plugin")
  void getAuthenticatorCommandFromExecConfig_whenGkeAuthPluginCommandProvided_thenUseCommandLineArgs() throws IOException {
    // Given
    File commandFolder = Files.createTempDirectory("test").toFile();
    File commandFile = new File(commandFolder, "gke-gcloud-auth-plugin");
    String systemPathValue = getTestPathValue(commandFolder);
    ExecConfig execConfigNoArgs = new ExecConfigBuilder()
        .withApiVersion("client.authentication.k8s.io/v1alpha1")
        .withCommand(commandFile.getPath())
        .build();
    // Simulate "user.exec.args: null" like e.g. in the configuration for the gke-gcloud-auth-plugin.
    execConfigNoArgs.setArgs(null);

    // When
    List<String> processBuilderArgs = Config.getAuthenticatorCommandFromExecConfig(
        execConfigNoArgs, null, systemPathValue);

    // Then
    assertThat(processBuilderArgs)
        .isNotNull()
        .hasSize(3)
        .satisfies(pb -> assertThat(pb.get(2)).isEqualTo(commandFile.getPath()));
    assertPlatformPrefixes(processBuilderArgs);
  }

  private void assertPlatformPrefixes(List<String> processBuilderArgs) {
    List<String> platformArgsExpected = Utils.getCommandPlatformPrefix();
    assertThat(processBuilderArgs)
        .satisfies(p -> assertThat(p.get(0)).isEqualTo(platformArgsExpected.get(0)))
        .satisfies(p -> assertThat(p.get(1)).isEqualTo(platformArgsExpected.get(1)));
  }

  private String getTestPathValue(File commandFolder) {
    if (Utils.isWindowsOperatingSystem()) {
      return "C:\\Program Files\\Java\\jdk14.0_23\\bin" + File.pathSeparator +
          commandFolder.getAbsolutePath() + File.pathSeparator +
          "C:\\Program Files\\Apache Software Foundation\\apache-maven-3.3.1";
    } else {
      return "/usr/java/jdk-14.0.1/bin" + File.pathSeparator +
          commandFolder.getAbsolutePath() + File.pathSeparator +
          "/opt/apache-maven/bin";
    }
  }

  @Nested
  @DisplayName("Config.getHomeDir")
  class GetHomeDir {
    @Nested
    @DisplayName("os.name=Windows")
    class OsNameWindows {
      private String osNamePropToRestore;

      @BeforeEach
      void setUp() {
        osNamePropToRestore = System.getProperty("os.name");
        System.setProperty("os.name", "Windows");
      }

      @Test
      void shouldUseHomeDriveHomePathOnWindows_WhenHomeEnvVariableIsNotSet() {
        // Given
        Map<String, String> envVars = new HashMap<>();
        envVars.put("HOMEDRIVE", "C:\\Users\\");
        envVars.put("HOMEPATH", "user");
        envVars.put("USERPROFILE", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

        // When + Then
        assertThat(Config.getHomeDir(f -> true, envVars::get)).isEqualTo("C:\\Users\\user");
      }

      @Test
      void shouldUseUserprofileOnWindows_WhenHomeHomeDriveHomePathEnvVariablesAreNotSet() {
        // Given
        Map<String, String> envVars = new HashMap<>();
        envVars.put("USERPROFILE", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

        // When + Then
        assertThat(Config.getHomeDir(f -> true, envVars::get))
            .isEqualTo("C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");
      }

      @Test
      void shouldUseHomeEnvVariableOnWindows_WhenHomeEnvVariableIsSet() {
        // Given
        Map<String, String> envVars = new HashMap<>();
        envVars.put("HOMEDRIVE", "C:\\Users\\");
        envVars.put("HOMEPATH", "user");
        envVars.put("HOME", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

        // When + Then
        assertThat(Config.getHomeDir(f -> true, envVars::get))
            .isEqualTo("C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");
      }

      @AfterEach
      void tearDown() {
        System.setProperty("os.name", osNamePropToRestore);
      }
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void shouldUseHomeEnvVariable_WhenEnabledOnWindows_WhenHomeEnvVariableIsSet() {
      // Given
      Map<String, String> envVars = new HashMap<>();
      envVars.put("HOMEDRIVE", "C:\\Users\\");
      envVars.put("HOMEPATH", "user");
      envVars.put("HOME", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

      // When + Then
      assertThat(Config.getHomeDir(f -> true, envVars::get))
          .isEqualTo("C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");
    }

    @Test
    void shouldReturnUserHomeProp_WhenHomeEnvVariablesAreNotSet() {
      String userHomePropToRestore = System.getProperty("user.home");
      try {
        // Given
        System.setProperty("user.home", "/home/user");
        Map<String, String> emptyEnvVars = Collections.emptyMap();

        // When + Then
        assertThat(Config.getHomeDir(f -> true, emptyEnvVars::get)).isEqualTo("/home/user");
      } finally {
        System.setProperty("user.home", userHomePropToRestore);
      }
    }
  }

  @Test
  void refresh_whenOAuthTokenSourceSetToUser_thenConfigUnchanged() {
    // Given
    Config config = new ConfigBuilder()
        .withOauthToken("token-from-user")
        .build();

    // When
    Config updatedConfig = config.refresh();

    // Then
    assertThat(updatedConfig)
        .isSameAs(config)
        .hasFieldOrPropertyWithValue("oauthToken", "token-from-user");
  }

  @Test
  void givenEmptyKubeConfig_whenConfigCreated_thenShouldNotProduceNPE() throws URISyntaxException {
    try {
      // Given
      System.setProperty("kubeconfig",
          new File(Objects.requireNonNull(getClass().getResource("/test-empty-kubeconfig")).toURI()).getAbsolutePath());

      // When
      Config config = new ConfigBuilder().build();

      // Then
      assertThat(config).isNotNull();
    } finally {
      System.clearProperty("kubeconfig");
    }
  }
}
