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
package io.fabric8.kubernetes.log4j.lookup;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

/**
 * Builds a Kubernetes Client.
 */
class ClientBuilder {

  public KubernetesClient createClient() {
    final Config config = kubernetesClientConfig();
    return config != null ? new KubernetesClientBuilder()
        .withConfig(config).build() : null;
  }

  private Config kubernetesClientConfig() {
    Config base = null;
    try {
      base = Config.autoConfigure(null);
    } catch (Exception ex) {
      if (ex instanceof NullPointerException) {
        return null;
      }
    }
    final ClientProperties props = new ClientProperties(base);
    final Config properties = new ConfigBuilder(base)
        .withApiVersion(props.getApiVersion())
        .withCaCertData(props.getCaCertData())
        .withCaCertFile(props.getCaCertFile())
        .withClientCertData(props.getClientCertData())
        .withClientCertFile(props.getClientCertFile())
        .withClientKeyAlgo(props.getClientKeyAlgo())
        .withClientKeyData(props.getClientKeyData())
        .withClientKeyFile(props.getClientKeyFile())
        .withClientKeyPassphrase(props.getClientKeyPassphrase())
        .withConnectionTimeout(props.getConnectionTimeout())
        .withHttpProxy(props.getHttpProxy())
        .withHttpsProxy(props.getHttpsProxy())
        .withMasterUrl(props.getMasterUrl())
        .withNamespace(props.getNamespace())
        .withNoProxy(props.getNoProxy())
        .withPassword(props.getPassword())
        .withProxyPassword(props.getProxyPassword())
        .withProxyUsername(props.getProxyUsername())
        .withRequestTimeout(props.getRequestTimeout())
        .withTrustCerts(props.isTrustCerts())
        .withUsername(props.getUsername())
        .build();
    return properties;
  }
}
