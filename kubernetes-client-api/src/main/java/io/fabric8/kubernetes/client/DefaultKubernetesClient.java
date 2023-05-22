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
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;

/**
 * Class for Default Kubernetes Client implementing KubernetesClient interface.
 * It is thread safe.
 *
 * @deprecated direct usage should no longer be needed. Please use the {@link KubernetesClientBuilder} instead.
 */
@Deprecated
public class DefaultKubernetesClient extends NamespacedKubernetesClientAdapter<NamespacedKubernetesClient> {

  public static final String KUBERNETES_VERSION_ENDPOINT = "version";

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
      // this reads a little oddly, but it supplies the given HttpClient via the factory.
      // no further configuration is performed
      // an alternative would be to add back a factory method that returns the client, or to allow the HttpClient to be set directly on the KubernetesClientBuilder
      builder.withHttpClientFactory(new Factory() {

        @Override
        public Builder newBuilder() {
          throw new UnsupportedOperationException();
        }

        @Override
        public Builder newBuilder(Config config) {
          return new StandardHttpClientBuilder<HttpClient, HttpClient.Factory, StandardHttpClientBuilder<HttpClient, HttpClient.Factory, ?>>(
              null) {

            @Override
            public HttpClient build() {
              return httpClient;
            }

            @Override
            protected StandardHttpClientBuilder<HttpClient, HttpClient.Factory, StandardHttpClientBuilder<HttpClient, HttpClient.Factory, ?>> newInstance(
                Factory clientFactory) {
              return null;
            }
          };
        }

      });
    }
    this.init(builder.build());
  }

}
