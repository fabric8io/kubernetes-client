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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigFromKubeconfigTest {

  @Nested
  class SingleContextConfig {
    private Config config;

    @BeforeEach
    void setUp() {
      config = Config.fromKubeconfig(new File(Objects.requireNonNull(
          ConfigFromKubeconfigTest.class.getResource("/config-from-kubeconfig/single-context-config.yaml")).getFile()));
    }

    @Test
    void setsFile() {
      assertThat(config.getFile()).isEqualTo(new File(Objects.requireNonNull(
          ConfigFromKubeconfigTest.class.getResource("/config-from-kubeconfig/single-context-config.yaml")).getFile()));
    }

    @Test
    void loadsContexts() {
      assertThat(config.getContexts())
          .singleElement()
          .hasFieldOrPropertyWithValue("name", "the-context")
          .extracting(NamedContext::getContext)
          .hasFieldOrPropertyWithValue("cluster", "the-cluster")
          .hasFieldOrPropertyWithValue("namespace", "the-context-default-namespace");
    }

    @Test
    void setsNamespace() {
      assertThat(config.getNamespace()).isEqualTo("the-context-default-namespace");
    }

    @Test
    void setsCurrentContext() {
      assertThat(config.getCurrentContext())
          .hasFieldOrPropertyWithValue("name", "the-context")
          .extracting(NamedContext::getContext)
          .hasFieldOrPropertyWithValue("cluster", "the-cluster")
          .hasFieldOrPropertyWithValue("user", "the-user")
          .hasFieldOrPropertyWithValue("namespace", "the-context-default-namespace");
    }

    @Test
    void setsClusterInformation() {
      assertThat(config)
          .hasFieldOrPropertyWithValue("masterUrl", "https://cluster.example.com/")
          .hasFieldOrPropertyWithValue("trustCerts", false)
          .hasFieldOrPropertyWithValue("disableHostnameVerification", false)
          // config.getFile verified in setsFile
          .hasFieldOrPropertyWithValue("caCertFile", new File(config.getFile().getParent(), "ca.crt").getAbsolutePath())
          .hasFieldOrPropertyWithValue("caCertData", "SOME_BASE64_ENCODED_CERT_DATA_FOR_CA_CERT")
          .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy.example.com");
    }

    @Test
    void setsAuthInformation() {
      assertThat(config)
          // config.getFile verified in setsFile
          .hasFieldOrPropertyWithValue("clientCertFile", new File(config.getFile().getParent(), "client.crt").getAbsolutePath())
          .hasFieldOrPropertyWithValue("clientCertData", "SOME_BASE64_ENCODED_CERT_DATA_FOR_CLIENT_CERT")
          // Base64-encoded to allow RSA key detection: BEGIN RSA PRIVATE KEY
          .hasFieldOrPropertyWithValue("clientKeyData", "QkVHSU4gUlNBIFBSSVZBVEUgS0VZCg==")
          .hasFieldOrPropertyWithValue("clientKeyAlgo", "RSA")
          // Set as autoOAuthToken to enable automatic refresh-persist in file when using interceptors
          .hasFieldOrPropertyWithValue("autoOAuthToken", "the-user-token")
          .hasFieldOrPropertyWithValue("username", "the-username")
          .hasFieldOrPropertyWithValue("password", "the-pa33word");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void setsAuthInformationClientKeyFileAbsolute() {
      assertThat(config)
          .hasFieldOrPropertyWithValue("clientKeyFile", "/absolute/path/client.key");
    }
  }
}
