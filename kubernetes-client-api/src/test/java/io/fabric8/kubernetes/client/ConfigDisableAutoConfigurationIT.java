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

import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.api.model.NamedContextBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigDisableAutoConfigurationTest {
  private final NamedContext userConfiguredNamedContext = new NamedContextBuilder()
      .withName("context1")
      .withNewContext()
      .withCluster("api-test-openshiftapps-com:6443")
      .withUser("testuser/api-test-openshiftapps-com:6443")
      .endContext()
      .build();

  @Nested
  @DisplayName("via kubernetes.disable.autoConfig=true")
  class AutoConfigDisabledViaProperty {
    @BeforeEach
    void setUp() {
      System.setProperty("kubernetes.disable.autoConfig", "true");
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubernetes.disable.autoConfig");
    }

    @Nested
    @DisplayName("And inside Kubernetes Cluster with ServiceAccount mounted")
    class InsideKubernetesClusterWithMountedServiceAccount {
      @BeforeEach
      void setUp() {
        System.setProperty("kubernetes.auth.serviceAccount.token",
            Utils.filePath(ConfigDisableAutoConfigurationTest.class
                .getResource("/config-disable-autoconfiguration/serviceaccount/token")));
        System.setProperty("kubenamespace",
            Utils.filePath(ConfigDisableAutoConfigurationTest.class
                .getResource("/config-disable-autoconfiguration/serviceaccount/namespace")));
      }

      @Test
      @DisplayName("then use default values")
      void whenConfigDisabledViaPropertyAndUserProvidesNoConfiguration_thenUseConfigDefaultValues() {
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("autoConfigure", false)
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
      @DisplayName("And user configuration via builder, then user configuration takes precedence")
      void whenConfigDisabledViaPropertyAndUserProvidesConfigurationViaConfigBuilder_thenUseConfigDefaultValues() {
        // Given + When
        Config config = new ConfigBuilder()
            .withMasterUrl("https://api-test.openshiftapps.com:6443")
            .withContexts(userConfiguredNamedContext)
            .withCurrentContext(userConfiguredNamedContext)
            .withMaxConcurrentRequests(30)
            .withMaxConcurrentRequestsPerHost(10)
            .withTrustCerts()
            .withDisableHostnameVerification()
            .withClientKeyAlgo("EC")
            .withWatchReconnectInterval(500)
            .withWatchReconnectLimit(10)
            .withConnectionTimeout(1000)
            .withRequestTimeout(1000)
            .withScaleTimeout(1000)
            .withLoggingInterval(1000)
            .withWebsocketPingInterval(10000L)
            .withUploadRequestTimeout(1000)
            .withImpersonateExtras(Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .withHttp2Disable(true)
            .withTlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3 })
            .withCurrentContext(userConfiguredNamedContext)
            .withImpersonateGroups("developer", "admin")
            .withUserAgent("custom-user-agent")
            .build();
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("autoConfigure", false)
            .hasFieldOrPropertyWithValue("masterUrl", "https://api-test.openshiftapps.com:6443/")
            .hasFieldOrPropertyWithValue("contexts", Collections.singletonList(userConfiguredNamedContext))
            .hasFieldOrPropertyWithValue("maxConcurrentRequests", 30)
            .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 10)
            .hasFieldOrPropertyWithValue("trustCerts", true)
            .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
            .hasFieldOrPropertyWithValue("clientKeyAlgo", "EC")
            .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
            .hasFieldOrPropertyWithValue("watchReconnectInterval", 500)
            .hasFieldOrPropertyWithValue("watchReconnectLimit", 10)
            .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
            .hasFieldOrPropertyWithValue("requestTimeout", 1000)
            .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
            .hasFieldOrPropertyWithValue("loggingInterval", 1000)
            .hasFieldOrPropertyWithValue("websocketPingInterval", 10000L)
            .hasFieldOrPropertyWithValue("uploadRequestTimeout", 1000)
            .hasFieldOrPropertyWithValue("impersonateExtras",
                Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .hasFieldOrPropertyWithValue("http2Disable", true)
            .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3 })
            .satisfies(e -> assertThat(e.getCurrentContext()).isEqualTo(userConfiguredNamedContext))
            .satisfies(e -> assertThat(e.getImpersonateGroups()).containsExactly("developer", "admin"))
            .satisfies(e -> assertThat(e.getUserAgent()).isEqualTo("custom-user-agent"));
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("kubernetes.master");
        System.clearProperty("kubernetes.auth.serviceAccount.token");
        System.clearProperty("kubenamespace");
      }
    }

    @Nested
    @DisplayName("And system properties configured")
    class SystemPropertiesConfigured {
      @BeforeEach
      void setUp() {
        System.setProperty("kubernetes.master", "http://somehost:80");
        System.setProperty("kubernetes.namespace", "testns");
      }

      @Test
      @DisplayName("then use default values")
      void whenConfigDisabledViaPropertyAndUserProvidesNoConfiguration_thenUseConfigDefaultValues() {
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("autoConfigure", false)
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
      @DisplayName("And user configuration via builder, then user configuration takes precedence")
      void whenConfigDisabledViaPropertyAndUserProvidesConfigurationViaConfigBuilder_thenUseConfigDefaultValues() {
        // Given + When
        Config config = new ConfigBuilder()
            .withMasterUrl("https://api-test.openshiftapps.com:6443")
            .withContexts(userConfiguredNamedContext)
            .withCurrentContext(userConfiguredNamedContext)
            .withMaxConcurrentRequests(30)
            .withMaxConcurrentRequestsPerHost(10)
            .withTrustCerts()
            .withDisableHostnameVerification()
            .withClientKeyAlgo("EC")
            .withWatchReconnectInterval(500)
            .withWatchReconnectLimit(10)
            .withConnectionTimeout(1000)
            .withRequestTimeout(1000)
            .withScaleTimeout(1000)
            .withLoggingInterval(1000)
            .withWebsocketPingInterval(10000L)
            .withUploadRequestTimeout(1000)
            .withImpersonateExtras(Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .withHttp2Disable(true)
            .withTlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3 })
            .withCurrentContext(userConfiguredNamedContext)
            .withImpersonateGroups("developer", "admin")
            .withUserAgent("custom-user-agent")
            .build();
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("autoConfigure", false)
            .hasFieldOrPropertyWithValue("masterUrl", "https://api-test.openshiftapps.com:6443/")
            .hasFieldOrPropertyWithValue("contexts", Collections.singletonList(userConfiguredNamedContext))
            .hasFieldOrPropertyWithValue("maxConcurrentRequests", 30)
            .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 10)
            .hasFieldOrPropertyWithValue("trustCerts", true)
            .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
            .hasFieldOrPropertyWithValue("clientKeyAlgo", "EC")
            .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
            .hasFieldOrPropertyWithValue("watchReconnectInterval", 500)
            .hasFieldOrPropertyWithValue("watchReconnectLimit", 10)
            .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
            .hasFieldOrPropertyWithValue("requestTimeout", 1000)
            .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
            .hasFieldOrPropertyWithValue("loggingInterval", 1000)
            .hasFieldOrPropertyWithValue("websocketPingInterval", 10000L)
            .hasFieldOrPropertyWithValue("uploadRequestTimeout", 1000)
            .hasFieldOrPropertyWithValue("impersonateExtras",
                Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .hasFieldOrPropertyWithValue("http2Disable", true)
            .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3 })
            .satisfies(e -> assertThat(e.getCurrentContext()).isEqualTo(userConfiguredNamedContext))
            .satisfies(e -> assertThat(e.getImpersonateGroups()).containsExactly("developer", "admin"))
            .satisfies(e -> assertThat(e.getUserAgent()).isEqualTo("custom-user-agent"));
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("kubernetes.master");
      }
    }

    @Nested
    @DisplayName("And kubeconfig present")
    class KubeConfigPresent {
      @BeforeEach
      void setUp() {
        System.setProperty("kubeconfig",
            Utils.filePath(getClass().getResource("/config-disable-autoconfiguration/kube-config")));
      }

      @Test
      @DisplayName("then use default values")
      void whenConfigDisabledViaPropertyAndUserProvidesNoConfiguration_thenUseConfigDefaultValues() {
        assertThat(new ConfigBuilder().build())
            .hasFieldOrPropertyWithValue("autoConfigure", false)
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
      @DisplayName("And user configuration via builder, then user configuration via builder takes precedence")
      void whenConfigDisabledViaPropertyAndUserProvidesConfigurationViaConfigBuilder_thenUseConfigDefaultValues() {
        // Given + When
        Config config = new ConfigBuilder()
            .withMasterUrl("https://api-test.openshiftapps.com:6443")
            .withContexts(userConfiguredNamedContext)
            .withCurrentContext(userConfiguredNamedContext)
            .withMaxConcurrentRequests(30)
            .withMaxConcurrentRequestsPerHost(10)
            .withTrustCerts()
            .withDisableHostnameVerification()
            .withClientKeyAlgo("EC")
            .withWatchReconnectInterval(500)
            .withWatchReconnectLimit(10)
            .withConnectionTimeout(1000)
            .withRequestTimeout(1000)
            .withScaleTimeout(1000)
            .withLoggingInterval(1000)
            .withWebsocketPingInterval(10000L)
            .withUploadRequestTimeout(1000)
            .withImpersonateExtras(Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .withHttp2Disable(true)
            .withTlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3 })
            .withCurrentContext(userConfiguredNamedContext)
            .withImpersonateGroups("developer", "admin")
            .withUserAgent("custom-user-agent")
            .build();
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("autoConfigure", false)
            .hasFieldOrPropertyWithValue("masterUrl", "https://api-test.openshiftapps.com:6443/")
            .hasFieldOrPropertyWithValue("contexts", Collections.singletonList(userConfiguredNamedContext))
            .hasFieldOrPropertyWithValue("maxConcurrentRequests", 30)
            .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 10)
            .hasFieldOrPropertyWithValue("trustCerts", true)
            .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
            .hasFieldOrPropertyWithValue("clientKeyAlgo", "EC")
            .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
            .hasFieldOrPropertyWithValue("watchReconnectInterval", 500)
            .hasFieldOrPropertyWithValue("watchReconnectLimit", 10)
            .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
            .hasFieldOrPropertyWithValue("requestTimeout", 1000)
            .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
            .hasFieldOrPropertyWithValue("loggingInterval", 1000)
            .hasFieldOrPropertyWithValue("websocketPingInterval", 10000L)
            .hasFieldOrPropertyWithValue("uploadRequestTimeout", 1000)
            .hasFieldOrPropertyWithValue("impersonateExtras",
                Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .hasFieldOrPropertyWithValue("http2Disable", true)
            .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3 })
            .satisfies(e -> assertThat(e.getCurrentContext()).isEqualTo(userConfiguredNamedContext))
            .satisfies(e -> assertThat(e.getImpersonateGroups()).containsExactly("developer", "admin"))
            .satisfies(e -> assertThat(e.getUserAgent()).isEqualTo("custom-user-agent"));
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("kubeconfig");
      }
    }
  }

  @Nested
  @Disabled("https://github.com/fabric8io/kubernetes-client/issues/6137")
  @DisplayName("With autoConfigure(false) in ConfigBuilder")
  class AutoConfigDisabledViaBuilder {
    private ConfigBuilder configBuilder;

    @BeforeEach
    void setUp() {
      System.setProperty("kubeconfig", "/dev/null");
      configBuilder = new ConfigBuilder().withAutoConfigure(false);
    }

    @AfterEach
    void tearDown() {
      System.clearProperty("kubeconfig");
    }

    @Nested
    @DisplayName("And system properties configured")
    class SystemPropertiesConfigured {
      @BeforeEach
      void setUp() {
        System.setProperty("kubernetes.master", "http://somehost:80");
        System.setProperty("kubernetes.namespace", "testns");
      }

      @Test
      @DisplayName("then use default values")
      void whenConfigDisabledViaPropertyAndUserProvidesNoConfiguration_thenUseConfigDefaultValues() {
        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("autoConfigure", false)
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
      @DisplayName("And user configuration via builder, then user configuration takes precedence")
      void whenConfigDisabledViaPropertyAndUserProvidesConfigurationViaConfigBuilder_thenUseConfigDefaultValues() {
        // Given + When
        Config config = configBuilder.withMasterUrl("https://api-test.openshiftapps.com:6443")
            .withContexts(userConfiguredNamedContext)
            .withCurrentContext(userConfiguredNamedContext)
            .withMaxConcurrentRequests(30)
            .withMaxConcurrentRequestsPerHost(10)
            .withTrustCerts()
            .withDisableHostnameVerification()
            .withClientKeyAlgo("EC")
            .withWatchReconnectInterval(500)
            .withWatchReconnectLimit(10)
            .withConnectionTimeout(1000)
            .withRequestTimeout(1000)
            .withScaleTimeout(1000)
            .withLoggingInterval(1000)
            .withWebsocketPingInterval(10000L)
            .withUploadRequestTimeout(1000)
            .withImpersonateExtras(Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .withHttp2Disable(true)
            .withTlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3 })
            .withCurrentContext(userConfiguredNamedContext)
            .withImpersonateGroups("developer", "admin")
            .withUserAgent("custom-user-agent")
            .build();
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("autoConfigure", false)
            .hasFieldOrPropertyWithValue("masterUrl", "https://api-test.openshiftapps.com:6443/")
            .hasFieldOrPropertyWithValue("contexts", Collections.singletonList(userConfiguredNamedContext))
            .hasFieldOrPropertyWithValue("maxConcurrentRequests", 30)
            .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 10)
            .hasFieldOrPropertyWithValue("trustCerts", true)
            .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
            .hasFieldOrPropertyWithValue("clientKeyAlgo", "EC")
            .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
            .hasFieldOrPropertyWithValue("watchReconnectInterval", 500)
            .hasFieldOrPropertyWithValue("watchReconnectLimit", 10)
            .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
            .hasFieldOrPropertyWithValue("requestTimeout", 1000)
            .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
            .hasFieldOrPropertyWithValue("loggingInterval", 1000)
            .hasFieldOrPropertyWithValue("websocketPingInterval", 10000L)
            .hasFieldOrPropertyWithValue("uploadRequestTimeout", 1000)
            .hasFieldOrPropertyWithValue("impersonateExtras",
                Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .hasFieldOrPropertyWithValue("http2Disable", true)
            .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3 })
            .satisfies(e -> assertThat(e.getCurrentContext()).isEqualTo(userConfiguredNamedContext))
            .satisfies(e -> assertThat(e.getImpersonateGroups()).containsExactly("developer", "admin"))
            .satisfies(e -> assertThat(e.getUserAgent()).isEqualTo("custom-user-agent"));
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("kubernetes.master");
        System.clearProperty("kubeconfig");
        System.clearProperty("kubernetes.namespace");
      }
    }

    @Nested
    @DisplayName("And kubeconfig present")
    class KubeConfigPresent {
      @BeforeEach
      void setUp() throws IOException {
        System.setProperty("kubeconfig",
            Utils.filePath(getClass().getResource("/config-disable-autoconfiguration/kube-config")));
      }

      @Test
      @DisplayName("then use default values")
      void whenConfigDisabledViaPropertyAndUserProvidesNoConfiguration_thenUseConfigDefaultValues() {
        assertThat(configBuilder.build())
            .hasFieldOrPropertyWithValue("autoConfigure", false)
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
      @DisplayName("And user configuration via builder, then user configuration via builder takes precedence")
      void whenConfigDisabledViaPropertyAndUserProvidesConfigurationViaConfigBuilder_thenUseConfigDefaultValues() {
        // Given + When
        Config config = configBuilder
            .withMasterUrl("https://api-test.openshiftapps.com:6443")
            .withContexts(userConfiguredNamedContext)
            .withCurrentContext(userConfiguredNamedContext)
            .withMaxConcurrentRequests(30)
            .withMaxConcurrentRequestsPerHost(10)
            .withTrustCerts()
            .withDisableHostnameVerification()
            .withClientKeyAlgo("EC")
            .withWatchReconnectInterval(500)
            .withWatchReconnectLimit(10)
            .withConnectionTimeout(1000)
            .withRequestTimeout(1000)
            .withScaleTimeout(1000)
            .withLoggingInterval(1000)
            .withWebsocketPingInterval(10000L)
            .withUploadRequestTimeout(1000)
            .withImpersonateExtras(Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .withHttp2Disable(true)
            .withTlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3 })
            .withCurrentContext(userConfiguredNamedContext)
            .withImpersonateGroups("developer", "admin")
            .withUserAgent("custom-user-agent")
            .build();
        // Then
        assertThat(config)
            .hasFieldOrPropertyWithValue("autoConfigure", false)
            .hasFieldOrPropertyWithValue("masterUrl", "https://api-test.openshiftapps.com:6443/")
            .hasFieldOrPropertyWithValue("contexts", Collections.singletonList(userConfiguredNamedContext))
            .hasFieldOrPropertyWithValue("maxConcurrentRequests", 30)
            .hasFieldOrPropertyWithValue("maxConcurrentRequestsPerHost", 10)
            .hasFieldOrPropertyWithValue("trustCerts", true)
            .hasFieldOrPropertyWithValue("disableHostnameVerification", true)
            .hasFieldOrPropertyWithValue("clientKeyAlgo", "EC")
            .hasFieldOrPropertyWithValue("clientKeyPassphrase", "changeit")
            .hasFieldOrPropertyWithValue("watchReconnectInterval", 500)
            .hasFieldOrPropertyWithValue("watchReconnectLimit", 10)
            .hasFieldOrPropertyWithValue("connectionTimeout", 1000)
            .hasFieldOrPropertyWithValue("requestTimeout", 1000)
            .hasFieldOrPropertyWithValue("scaleTimeout", 1000L)
            .hasFieldOrPropertyWithValue("loggingInterval", 1000)
            .hasFieldOrPropertyWithValue("websocketPingInterval", 10000L)
            .hasFieldOrPropertyWithValue("uploadRequestTimeout", 1000)
            .hasFieldOrPropertyWithValue("impersonateExtras",
                Collections.singletonMap("acme%2Fproject", Collections.singletonList("some-project")))
            .hasFieldOrPropertyWithValue("http2Disable", true)
            .hasFieldOrPropertyWithValue("tlsVersions", new TlsVersion[] { TlsVersion.TLS_1_3 })
            .satisfies(e -> assertThat(e.getCurrentContext()).isEqualTo(userConfiguredNamedContext))
            .satisfies(e -> assertThat(e.getImpersonateGroups()).containsExactly("developer", "admin"))
            .satisfies(e -> assertThat(e.getUserAgent()).isEqualTo("custom-user-agent"));
      }

      @AfterEach
      void tearDown() {
        System.clearProperty("kubeconfig");
      }
    }
  }
}
