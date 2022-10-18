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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.KubernetesClientBuilder.ExecutorSupplier;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpClient.Builder;
import io.fabric8.kubernetes.client.http.HttpClient.Factory;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.InputStream;

/**
 * Class for Default Kubernetes Client implementing KubernetesClient interface.
 * It is thread safe.
 *
 * @deprecated direct usage should no longer be needed. Please use the {@link KubernetesClientBuilder} instead.
 */
@Deprecated
public class DefaultKubernetesClient extends NamespacedKubernetesClientAdapter<NamespacedKubernetesClient> {

  public static final String KUBERNETES_VERSION_ENDPOINT = "version";

  public static DefaultKubernetesClient fromConfig(String config) {
    return new DefaultKubernetesClient(Serialization.unmarshal(config, Config.class));
  }

  public static DefaultKubernetesClient fromConfig(InputStream is) {
    return new DefaultKubernetesClient(Serialization.unmarshal(is, Config.class));
  }

  public DefaultKubernetesClient() {
    this(new ConfigBuilder().build());
  }

  public DefaultKubernetesClient(String masterUrl) {
    this(new ConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public DefaultKubernetesClient(Config config) {
    this(HttpClientUtils.createHttpClient(config), config);
  }

  public DefaultKubernetesClient(HttpClient httpClient, Config config) {
    this(httpClient, config, null);
  }

  public DefaultKubernetesClient(HttpClient httpClient, Config config, ExecutorSupplier executorSupplier) {
    super(NamespacedKubernetesClient.class);
    KubernetesClientBuilder builder = new KubernetesClientBuilder().withConfig(config)
        .withTaskExecutorSupplier(executorSupplier);
    if (httpClient != null) {
      builder.withHttpClientFactory(new Factory() {

        @Override
        public Builder newBuilder() {
          // should not be called
          throw new UnsupportedOperationException();
        }

        @Override
        public HttpClient createHttpClient(Config config) {
          return httpClient;
        }
      });
    }
    this.init(builder.build());
  }

}
