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

import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.utils.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ConfigConstructorTest {
  @Test
  @DisplayName("empty configuration, no default values, no auto configured values")
  void emptyConfiguration() {
    // Given + When
    Config config = new Config(null, null, null, null, null,
        null, null, null, null, null,
        null, null, null, null, null,
        null, null, null, null, null,
        null, null, null, null,
        null,
        null, null, null, null,
        null, null, null,
        null,
        null, null, null, null, null,
        null, null, null,
        null, null, null,
        null, null, null, null,
        null, null, false, null);

    // Then
    assertThat(config)
        .isNotNull()
        .satisfies(c -> assertThat(c.getTrustCerts()).isNull())
        .satisfies(c -> assertThat(c.getDisableHostnameVerification()).isNull())
        .hasFieldOrPropertyWithValue("masterUrl", null)
        .hasFieldOrPropertyWithValue("namespace", null)
        .hasFieldOrPropertyWithValue("username", null)
        .hasFieldOrPropertyWithValue("password", null)
        .hasFieldOrPropertyWithValue("caCertFile", null)
        .hasFieldOrPropertyWithValue("caCertData", null)
        .hasFieldOrPropertyWithValue("clientCertFile", null)
        .hasFieldOrPropertyWithValue("clientCertData", null)
        .hasFieldOrPropertyWithValue("clientKeyFile", null)
        .hasFieldOrPropertyWithValue("clientKeyData", null)
        .hasFieldOrPropertyWithValue("clientKeyAlgo", null)
        .hasFieldOrPropertyWithValue("clientKeyPassphrase", null)
        .hasFieldOrPropertyWithValue("httpProxy", null)
        .hasFieldOrPropertyWithValue("watchReconnectInterval", null)
        .hasFieldOrPropertyWithValue("watchReconnectLimit", null)
        .hasFieldOrPropertyWithValue("loggingInterval", null)
        .hasFieldOrPropertyWithValue("requestTimeout", null)
        .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", null)
        .hasFieldOrPropertyWithValue("tlsVersions", null)
        .hasFieldOrPropertyWithValue("trustStoreFile", null)
        .hasFieldOrPropertyWithValue("trustStorePassphrase", null)
        .hasFieldOrPropertyWithValue("keyStoreFile", null)
        .hasFieldOrPropertyWithValue("keyStorePassphrase", null)
        .hasFieldOrPropertyWithValue("maxConcurrentRequests", null)
        .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", null)
        .hasFieldOrPropertyWithValue("websocketPingInterval", null)
        .hasFieldOrPropertyWithValue("connectionTimeout", null)
        .hasFieldOrPropertyWithValue("scaleTimeout", null)
        .hasFieldOrPropertyWithValue("watchReconnectInterval", null)
        .hasFieldOrPropertyWithValue("http2Disable", null)
        .hasFieldOrPropertyWithValue("httpsProxy", null)
        .hasFieldOrPropertyWithValue("proxyUsername", null)
        .hasFieldOrPropertyWithValue("proxyPassword", null)
        .hasFieldOrPropertyWithValue("noProxy", null)
        .hasFieldOrPropertyWithValue("autoOAuthToken", null);
  }

  @Nested
  @DisplayName("Config default values initialization with system properties for auto configuration")
  class DefaultValues {
    @BeforeEach
    void setUp() {
      System.setProperty("kubernetes.master", "http://autoconfigured-master:80");
      System.setProperty("kubernetes.namespace", "autoconfigured-namespace");
      System.setProperty("kubernetes.auth.token", "autoconfigured-token");
      System.setProperty("kubernetes.auth.basic.username", "autoconfigured-user");
      System.setProperty("kubernetes.auth.basic.password", "autoconfigured-pass");
      System.setProperty("kubernetes.trust.certificates", "true");
      System.setProperty("kubernetes.disable.hostname.verification", "true");
      System.setProperty("kubernetes.certs.ca.file", "/autoconfigured-path/to/cert");
      System.setProperty("kubernetes.certs.ca.data", "autoconfigured-cacertdata");
      System.setProperty("kubernetes.certs.client.file", "/autoconfigured-path/to/clientcert");
      System.setProperty("kubernetes.certs.client.data", "autoconfigured-clientcertdata");
      System.setProperty("kubernetes.certs.client.key.file", "/autoconfigured-path/to/clientkey");
      System.setProperty("kubernetes.certs.client.key.data", "autoconfigured-clientkeydata");
      System.setProperty("kubernetes.certs.client.key.algo", "autoconfigured-algo");
      System.setProperty("kubernetes.certs.client.key.passphrase", "autoconfigured-passphrase");
      System.setProperty("kubernetes.certs.client.key.file", "/autoconfigured-path/to/clientkey");
      System.setProperty("kubernetes.max.concurrent.requests", "120");
      System.setProperty("kubernetes.max.concurrent.requests.per.host", "20");
      System.setProperty("kubernetes.watch.reconnectInterval", "5000");
      System.setProperty("kubernetes.watch.reconnectLimit", "5");
      System.setProperty("kubernetes.request.timeout", "5000");
      System.setProperty("http.proxy", "autoconfigured-httpProxy");
      System.setProperty("kubernetes.tls.versions", "TLSv1.2,TLSv1.1");
      System.setProperty("kubernetes.truststore.file", "/autoconfigured-path/to/truststore");
      System.setProperty("kubernetes.truststore.passphrase", "autoconfigured-truststorePassphrase");
      System.setProperty("kubernetes.keystore.file", "/autoconfigured-path/to/keystore");
      System.setProperty("kubernetes.keystore.passphrase", "autoconfigured-keystorePassphrase");
      System.setProperty("kubernetes.upload.request.timeout", "600000");
      System.setProperty("kubernetes.websocket.ping.interval", "1000");
      System.setProperty("kubernetes.connection.timeout", "1000");
      System.setProperty("kubernetes.scale.timeout", "1000");
      System.setProperty("https.proxy", "autoconfigured-httpsProxy");
      System.setProperty("no.proxy", "autoconfigured-no-proxy-url1.io,autoconfigured-no-proxy-url2.io");
      System.setProperty("proxy.username", "autoconfigured-proxyUsername");
      System.setProperty("proxy.password", "autoconfigured-proxyPassword");
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
    @DisplayName("when autoConfigure enabled, then auto configured values override default values")
    void whenAutoConfigureEnabled_thenUseBothDefaultAndAutoConfiguredValues() {
      // Given
      // When
      Config config = new Config(null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null,
          null,
          null, null, null, null,
          null, null, null,
          null,
          null, null, null, null, null,
          null, null, null,
          null, null, null,
          null, null, null, null,
          null, true, true, null);

      // Then
      assertThat(config)
          .isNotNull()
          // Default values
          .hasFieldOrPropertyWithValue("apiVersion", "v1")
          .hasFieldOrPropertyWithValue("onlyHttpWatches", false)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("userAgent", "fabric8-kubernetes-client/" + Version.clientVersion())
          // Auto Configured values
          .hasFieldOrPropertyWithValue("trustCerts", true)
          .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
          .hasFieldOrPropertyWithValue("masterUrl", "http://autoconfigured-master:80/")
          .hasFieldOrPropertyWithValue("namespace", "autoconfigured-namespace")
          .hasFieldOrPropertyWithValue("username", "autoconfigured-user")
          .hasFieldOrPropertyWithValue("password", "autoconfigured-pass")
          .hasFieldOrPropertyWithValue("caCertFile", "/autoconfigured-path/to/cert")
          .hasFieldOrPropertyWithValue("caCertData", "autoconfigured-cacertdata")
          .hasFieldOrPropertyWithValue("clientCertFile", "/autoconfigured-path/to/clientcert")
          .hasFieldOrPropertyWithValue("clientCertData", "autoconfigured-clientcertdata")
          .hasFieldOrPropertyWithValue("clientKeyFile", "/autoconfigured-path/to/clientkey")
          .hasFieldOrPropertyWithValue("clientKeyData", "autoconfigured-clientkeydata")
          .hasFieldOrPropertyWithValue("clientKeyAlgo", "autoconfigured-algo")
          .hasFieldOrPropertyWithValue("clientKeyPassphrase", "autoconfigured-passphrase")
          .hasFieldOrPropertyWithValue("httpProxy", "autoconfigured-httpProxy")
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("watchReconnectLimit", 5)
          .hasFieldOrPropertyWithValue("requestTimeout", 5000)
          .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 600000)
          .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 })
          .hasFieldOrPropertyWithValue("trustStoreFile", "/autoconfigured-path/to/truststore")
          .hasFieldOrPropertyWithValue("trustStorePassphrase", "autoconfigured-truststorePassphrase")
          .hasFieldOrPropertyWithValue("keyStoreFile", "/autoconfigured-path/to/keystore")
          .hasFieldOrPropertyWithValue("keyStorePassphrase", "autoconfigured-keystorePassphrase")
          .hasFieldOrPropertyWithValue("maxConcurrentRequests", 120)
          .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 20)
          .hasFieldOrPropertyWithValue("websocketPingInterval", 1000L)
          .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
          .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("httpsProxy", "autoconfigured-httpsProxy")
          .hasFieldOrPropertyWithValue("proxyUsername", "autoconfigured-proxyUsername")
          .hasFieldOrPropertyWithValue("proxyPassword", "autoconfigured-proxyPassword")
          .hasFieldOrPropertyWithValue("noProxy",
              new String[] { "autoconfigured-no-proxy-url1.io", "autoconfigured-no-proxy-url2.io" })
          .hasFieldOrPropertyWithValue("autoOAuthToken", "autoconfigured-token")
          .hasFieldOrPropertyWithValue("files", Collections.singletonList(Config.DEFAULT_KUBECONFIG_FILE));
    }

    @Test
    @DisplayName("when autoConfigure disabled, then auto configured values are ignored")
    void whenAutoConfigureDisabled_thenOnlyUseDefaultValues() {
      Config config = new Config(null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null,
          null,
          null, null, null, null,
          null, null, null,
          null,
          null, null, null, null, null,
          null, null, null,
          null, null, null,
          null, null, null, null,
          null, false, true, null);

      assertThat(config)
          .isNotNull()
          .hasFieldOrPropertyWithValue("apiVersion", "v1")
          .hasFieldOrPropertyWithValue("onlyHttpWatches", false)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("userAgent", "fabric8-kubernetes-client/" + Version.clientVersion())
          .hasFieldOrPropertyWithValue("trustCerts", false)
          .hasFieldOrPropertyWithValue("disableHostnameVerification", false)
          .hasFieldOrPropertyWithValue("masterUrl", "https://kubernetes.default.svc/")
          .hasFieldOrPropertyWithValue("namespace", null)
          .hasFieldOrPropertyWithValue("username", null)
          .hasFieldOrPropertyWithValue("password", null)
          .hasFieldOrPropertyWithValue("caCertFile", null)
          .hasFieldOrPropertyWithValue("caCertData", null)
          .hasFieldOrPropertyWithValue("clientCertFile", null)
          .hasFieldOrPropertyWithValue("clientCertData", null)
          .hasFieldOrPropertyWithValue("clientKeyFile", null)
          .hasFieldOrPropertyWithValue("clientKeyData", null)
          .hasFieldOrPropertyWithValue("clientKeyAlgo", "RSA")
          .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
          .hasFieldOrPropertyWithValue("httpProxy", null)
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 1000)
          .hasFieldOrPropertyWithValue("watchReconnectLimit", -1)
          .hasFieldOrPropertyWithValue("requestTimeout", 10000)
          .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 120000)
          .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2 })
          .hasFieldOrPropertyWithValue("trustStoreFile", null)
          .hasFieldOrPropertyWithValue("trustStorePassphrase", null)
          .hasFieldOrPropertyWithValue("keyStoreFile", null)
          .hasFieldOrPropertyWithValue("keyStorePassphrase", null)
          .hasFieldOrPropertyWithValue("maxConcurrentRequests", 64)
          .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 5)
          .hasFieldOrPropertyWithValue("websocketPingInterval", 30000L)
          .hasFieldOrPropertyWithValue("connectionTimeout", 10000)
          .hasFieldOrPropertyWithValue("scaleTimeout", 600000L)
          .hasFieldOrPropertyWithValue("watchReconnectInterval", 1000)
          .hasFieldOrPropertyWithValue("http2Disable", false)
          .hasFieldOrPropertyWithValue("httpsProxy", null)
          .hasFieldOrPropertyWithValue("proxyUsername", null)
          .hasFieldOrPropertyWithValue("proxyPassword", null)
          .hasFieldOrPropertyWithValue("noProxy", null)
          .hasFieldOrPropertyWithValue("autoOAuthToken", null)
          .hasFieldOrPropertyWithValue("files", Collections.<File> emptyList());
    }
  }

  @Nested
  @DisplayName("Config auto configured values initialization (autoConfigure=true)")
  class AutoConfiguredValues {
    @Nested
    @DisplayName("(defaultValues=true)")
    class DefaultValuesTrue {
      @Test
      @DisplayName("from system properties")
      void configLoadedViaSystemProperties() {
        try {
          // Given
          System.setProperty("kubernetes.master", "http://autoconfigured-master:80");
          System.setProperty("kubernetes.namespace", "autoconfigured-namespace");
          System.setProperty("kubernetes.auth.token", "autoconfigured-token");
          System.setProperty("kubernetes.auth.basic.username", "autoconfigured-user");
          System.setProperty("kubernetes.auth.basic.password", "autoconfigured-pass");
          System.setProperty("kubernetes.trust.certificates", "true");
          System.setProperty("kubernetes.disable.hostname.verification", "true");
          System.setProperty("kubernetes.certs.ca.file", "/autoconfigured-path/to/cert");
          System.setProperty("kubernetes.certs.ca.data", "autoconfigured-cacertdata");
          System.setProperty("kubernetes.certs.client.file", "/autoconfigured-path/to/clientcert");
          System.setProperty("kubernetes.certs.client.data", "autoconfigured-clientcertdata");
          System.setProperty("kubernetes.certs.client.key.file", "/autoconfigured-path/to/clientkey");
          System.setProperty("kubernetes.certs.client.key.data", "autoconfigured-clientkeydata");
          System.setProperty("kubernetes.certs.client.key.algo", "autoconfigured-algo");
          System.setProperty("kubernetes.certs.client.key.passphrase", "autoconfigured-passphrase");
          System.setProperty("kubernetes.certs.client.key.file", "/autoconfigured-path/to/clientkey");
          System.setProperty("kubernetes.max.concurrent.requests", "120");
          System.setProperty("kubernetes.max.concurrent.requests.per.host", "20");
          System.setProperty("kubernetes.watch.reconnectInterval", "5000");
          System.setProperty("kubernetes.watch.reconnectLimit", "5");
          System.setProperty("kubernetes.request.timeout", "5000");
          System.setProperty("http.proxy", "autoconfigured-httpProxy");
          System.setProperty("kubernetes.tls.versions", "TLSv1.2,TLSv1.1");
          System.setProperty("kubernetes.truststore.file", "/autoconfigured-path/to/truststore");
          System.setProperty("kubernetes.truststore.passphrase", "autoconfigured-truststorePassphrase");
          System.setProperty("kubernetes.keystore.file", "/autoconfigured-path/to/keystore");
          System.setProperty("kubernetes.keystore.passphrase", "autoconfigured-keystorePassphrase");
          System.setProperty("kubernetes.upload.request.timeout", "600000");
          System.setProperty("kubernetes.websocket.ping.interval", "1000");
          System.setProperty("kubernetes.connection.timeout", "1000");
          System.setProperty("kubernetes.scale.timeout", "1000");
          System.setProperty("https.proxy", "autoconfigured-httpsProxy");
          System.setProperty("no.proxy", "autoconfigured-no-proxy-url1.io,autoconfigured-no-proxy-url2.io");
          System.setProperty("proxy.username", "autoconfigured-proxyUsername");
          System.setProperty("proxy.password", "autoconfigured-proxyPassword");

          // When
          Config config = new Config(null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null,
              null,
              null, null, null, null,
              null, null, null,
              null,
              null, null, null, null, null,
              null, null, null,
              null, null, null,
              null, null, null, null,
              null, true, true, null);

          // Then
          assertThat(config)
              .isNotNull()
              // Default values
              .hasFieldOrPropertyWithValue("apiVersion", "v1")
              .hasFieldOrPropertyWithValue("onlyHttpWatches", false)
              .hasFieldOrPropertyWithValue("http2Disable", false)
              .hasFieldOrPropertyWithValue("userAgent", "fabric8-kubernetes-client/" + Version.clientVersion())
              // Auto Configured values
              .hasFieldOrPropertyWithValue("trustCerts", true)
              .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
              .hasFieldOrPropertyWithValue("masterUrl", "http://autoconfigured-master:80/")
              .hasFieldOrPropertyWithValue("namespace", "autoconfigured-namespace")
              .hasFieldOrPropertyWithValue("username", "autoconfigured-user")
              .hasFieldOrPropertyWithValue("password", "autoconfigured-pass")
              .hasFieldOrPropertyWithValue("caCertFile", "/autoconfigured-path/to/cert")
              .hasFieldOrPropertyWithValue("caCertData", "autoconfigured-cacertdata")
              .hasFieldOrPropertyWithValue("clientCertFile", "/autoconfigured-path/to/clientcert")
              .hasFieldOrPropertyWithValue("clientCertData", "autoconfigured-clientcertdata")
              .hasFieldOrPropertyWithValue("clientKeyFile", "/autoconfigured-path/to/clientkey")
              .hasFieldOrPropertyWithValue("clientKeyData", "autoconfigured-clientkeydata")
              .hasFieldOrPropertyWithValue("clientKeyAlgo", "autoconfigured-algo")
              .hasFieldOrPropertyWithValue("clientKeyPassphrase", "autoconfigured-passphrase")
              .hasFieldOrPropertyWithValue("httpProxy", "autoconfigured-httpProxy")
              .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
              .hasFieldOrPropertyWithValue("watchReconnectLimit", 5)
              .hasFieldOrPropertyWithValue("requestTimeout", 5000)
              .hasFieldOrPropertyWithValue("requestConfig.uploadRequestTimeout", 600000)
              .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 })
              .hasFieldOrPropertyWithValue("trustStoreFile", "/autoconfigured-path/to/truststore")
              .hasFieldOrPropertyWithValue("trustStorePassphrase", "autoconfigured-truststorePassphrase")
              .hasFieldOrPropertyWithValue("keyStoreFile", "/autoconfigured-path/to/keystore")
              .hasFieldOrPropertyWithValue("keyStorePassphrase", "autoconfigured-keystorePassphrase")
              .hasFieldOrPropertyWithValue("maxConcurrentRequests", 120)
              .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 20)
              .hasFieldOrPropertyWithValue("websocketPingInterval", 1000L)
              .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
              .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
              .hasFieldOrPropertyWithValue("watchReconnectInterval", 5000)
              .hasFieldOrPropertyWithValue("http2Disable", false)
              .hasFieldOrPropertyWithValue("httpsProxy", "autoconfigured-httpsProxy")
              .hasFieldOrPropertyWithValue("proxyUsername", "autoconfigured-proxyUsername")
              .hasFieldOrPropertyWithValue("proxyPassword", "autoconfigured-proxyPassword")
              .hasFieldOrPropertyWithValue("noProxy",
                  new String[] { "autoconfigured-no-proxy-url1.io", "autoconfigured-no-proxy-url2.io" })
              .hasFieldOrPropertyWithValue("autoOAuthToken", "autoconfigured-token")
              .hasFieldOrPropertyWithValue("files", Collections.singletonList(Config.DEFAULT_KUBECONFIG_FILE));
        } finally {
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
      }

      @Test
      @DisplayName("from kube config")
      void configLoadedViaKubeConfig() {
        try {
          // Given
          String kubeConfigFilePath = Utils.filePath(ConfigConstructorTest.class.getResource("/test-kubeconfig"));
          System.setProperty("kubeconfig", kubeConfigFilePath);
          // When
          Config config = new Config(null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null,
              null,
              null, null, null, null,
              null, null, null,
              null,
              null, null, null, null, null,
              null, null, null,
              null, null, null,
              null, null, null, null,
              null, true, true, null);

          // Then
          assertThat(config)
              .isNotNull()
              .hasFieldOrPropertyWithValue("masterUrl", "https://172.28.128.4:8443/")
              .hasFieldOrPropertyWithValue("trustCerts", true)
              .hasFieldOrPropertyWithValue("namespace", "testns")
              .hasFieldOrPropertyWithValue("autoOAuthToken", "token")
              .satisfies(c -> Assertions.assertThat(c.getCaCertFile()).endsWith("testns/ca.pem".replace("/", File.separator)))
              .satisfies(c -> Assertions.assertThat(new File(c.getCaCertFile())).isAbsolute())
              .hasFieldOrPropertyWithValue("file", new File(kubeConfigFilePath));
        } finally {
          System.clearProperty("kubeconfig");
        }
      }

      @Test
      @DisplayName("from Service Account")
      void configLoadedViaServiceAccount() {
        try {
          // Given
          System.setProperty("kubeconfig", "/dev/null");
          System.setProperty("kubernetes.auth.serviceAccount.token",
              Utils.filePath(ConfigConstructorTest.class.getResource("/config-source-precedence/serviceaccount/token")));
          System.setProperty("kubenamespace",
              Utils.filePath(ConfigConstructorTest.class.getResource("/config-source-precedence/serviceaccount/namespace")));
          // When
          Config config = new Config(null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null, null,
              null, null, null, null,
              null,
              null, null, null, null,
              null, null, null,
              null,
              null, null, null, null, null,
              null, null, null,
              null, null, null,
              null, null, null, null,
              null, true, true, null);

          // Then
          assertThat(config)
              .isNotNull()
              .hasFieldOrPropertyWithValue("namespace", "namespace-from-mounted-serviceaccount")
              .extracting(Config::getAutoOAuthToken)
              .asString()
              .contains("token-from-mounted-serviceaccount");
        } finally {
          System.clearProperty("kubeconfig");
          System.clearProperty("kubernetes.auth.serviceAccount.token");
          System.clearProperty("kubenamespace");
        }
      }
    }

    /*
     * AutoConfiguration requires default values as System Property/Environment variable resolution needs specific defaults for
     * property resolution,
     * such as connection timeout and so on.
     *
     * This is not a problem as the Constructor is package private and is not exposed to the users.
     */
    @Nested
    @DisplayName("(defaultValues=false)")
    class DefaultValuesFalse {
      @Test
      @DisplayName("should throw exception")
      void throwsException() {
        try {
          // Given
          String kubeConfigFilePath = Utils.filePath(ConfigConstructorTest.class.getResource("/test-kubeconfig"));
          System.setProperty("kubeconfig", kubeConfigFilePath);
          // When
          // Then
          assertThatExceptionOfType(NullPointerException.class)
              .isThrownBy(() -> new Config(null, null, null, null, null,
                  null, null, null, null, null,
                  null, null, null, null, null,
                  null, null, null, null, null,
                  null, null, null, null,
                  null,
                  null, null, null, null,
                  null, null, null,
                  null,
                  null, null, null, null, null,
                  null, null, null,
                  null, null, null,
                  null, null, null, null,
                  null, true, false, null));
        } finally {
          System.clearProperty("kubeconfig");
        }
      }
    }
  }
}
