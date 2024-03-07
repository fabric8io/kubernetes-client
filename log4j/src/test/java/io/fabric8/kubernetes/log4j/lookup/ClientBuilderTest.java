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
package io.fabric8.kubernetes.log4j.lookup;

import io.fabric8.kubernetes.client.Config;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientBuilderTest {

  @AfterEach
  void cleanUp() {
    System.getProperties().remove(ClientBuilder.KUBERNETES_LOG4J_USE_PROPERTIES);
  }

  @Test
  void uses_log4j_properties_if_requested() {
    System.setProperty(ClientBuilder.KUBERNETES_LOG4J_USE_PROPERTIES, "true");
    final PropertiesUtil props = new PropertiesUtil("log4j2.kubernetes.client.properties");
    final Config config = ClientBuilder.kubernetesClientConfig(props);
    assertThat(config).isNotNull();
    assertThat(config.getApiVersion()).isEqualTo("apiVersion");
    assertThat(config.getCaCertFile()).isEqualTo("caCertFile");
    assertThat(config.getCaCertData()).isEqualTo("caCertData");
    assertThat(config.getClientCertFile()).isEqualTo("clientCertFile");
    assertThat(config.getClientCertData()).isEqualTo("clientCertData");
    assertThat(config.getClientKeyFile()).isEqualTo("clientKeyFile");
    assertThat(config.getClientKeyData()).isEqualTo("clientKeyData");
    assertThat(config.getClientKeyAlgo()).isEqualTo("clientKeyAlgo");
    assertThat(config.getClientKeyPassphrase()).isEqualTo("clientKeyPassphrase");
    assertThat(config.getConnectionTimeout()).isEqualTo(123);
    assertThat(config.getHttpProxy()).isEqualTo("httpProxy");
    assertThat(config.getHttpsProxy()).isEqualTo("httpsProxy");
    assertThat(config.getLoggingInterval()).isEqualTo(345);
    assertThat(config.getMasterUrl()).isEqualTo("https://masterUrl/");
    assertThat(config.getNamespace()).isEqualTo("namespace");
    assertThat(config.getNoProxy()).isEqualTo(new String[] { "noProxy" });
    assertThat(config.getPassword()).isEqualTo("password");
    assertThat(config.getProxyUsername()).isEqualTo("proxyUsername");
    assertThat(config.getProxyPassword()).isEqualTo("proxyPassword");
    assertThat(config.getRequestTimeout()).isEqualTo(678);
    assertThat(config.isTrustCerts()).isTrue();
    assertThat(config.getUsername()).isEqualTo("username");
    assertThat(config.getWatchReconnectInterval()).isEqualTo(1234);
    assertThat(config.getWatchReconnectLimit()).isEqualTo(5678);
  }

  @Test
  void uses_native_properties() {
    System.setProperty(ClientBuilder.KUBERNETES_LOG4J_USE_PROPERTIES, "false");
    final PropertiesUtil props = new PropertiesUtil("log4j2.kubernetes.client.properties");
    final Config autoConfig = Config.autoConfigure(null);
    final Config config = ClientBuilder.kubernetesClientConfig(props);
    assertThat(config).isNotNull();
    assertThat(config.getApiVersion()).isEqualTo(autoConfig.getApiVersion());
  }
}
