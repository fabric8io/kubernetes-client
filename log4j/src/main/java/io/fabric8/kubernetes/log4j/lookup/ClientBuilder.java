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
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

import static io.fabric8.kubernetes.client.utils.Utils.getSystemPropertyOrEnvVar;

/**
 * Builds a Kubernetes Client.
 */
final class ClientBuilder {

  /**
   * If this system property is set to {@code true}, the client configuration is retrieved from Log4j Properties.
   */
  public static final String KUBERNETES_LOG4J_USE_PROPERTIES = "kubernetes.log4j.useProperties";

  private ClientBuilder() {
  }

  public static KubernetesClient createClient() {
    final Config config = kubernetesClientConfig(PropertiesUtil.getProperties());
    return config != null ? new KubernetesClientBuilder()
        .withConfig(config).build() : null;
  }

  static Config kubernetesClientConfig(final PropertiesUtil props) {
    try {
      final Config base = Config.autoConfigure(null);
      if (getSystemPropertyOrEnvVar(KUBERNETES_LOG4J_USE_PROPERTIES, false)) {
        final Log4jConfig log4jConfig = new Log4jConfig(props, base);
        return new ConfigBuilder()
            .withApiVersion(log4jConfig.getApiVersion())
            .withCaCertData(log4jConfig.getCaCertData())
            .withCaCertFile(log4jConfig.getCaCertFile())
            .withClientCertData(log4jConfig.getClientCertData())
            .withClientCertFile(log4jConfig.getClientCertFile())
            .withClientKeyAlgo(log4jConfig.getClientKeyAlgo())
            .withClientKeyData(log4jConfig.getClientKeyData())
            .withClientKeyFile(log4jConfig.getClientKeyFile())
            .withClientKeyPassphrase(log4jConfig.getClientKeyPassphrase())
            .withConnectionTimeout(log4jConfig.getConnectionTimeout())
            .withHttpProxy(log4jConfig.getHttpProxy())
            .withHttpsProxy(log4jConfig.getHttpsProxy())
            .withLoggingInterval(log4jConfig.getLoggingInterval())
            .withMasterUrl(log4jConfig.getMasterUrl())
            .withNamespace(log4jConfig.getNamespace())
            .withNoProxy(log4jConfig.getNoProxy())
            .withPassword(log4jConfig.getPassword())
            .withProxyPassword(log4jConfig.getProxyPassword())
            .withProxyUsername(log4jConfig.getProxyUsername())
            .withRequestTimeout(log4jConfig.getRequestTimeout())
            .withTrustCerts(log4jConfig.isTrustCerts())
            .withUsername(log4jConfig.getUsername())
            .withWatchReconnectInterval(log4jConfig.getWatchReconnectInterval())
            .withWatchReconnectLimit(log4jConfig.getWatchReconnectLimit())
            .build();
      }
      return base;
    } catch (final Exception e) {
      StatusLogger.getLogger().warn("An error occurred while retrieving Kubernetes Client configuration: {}.",
          e.getMessage(), e);
    }
    return null;
  }
}
