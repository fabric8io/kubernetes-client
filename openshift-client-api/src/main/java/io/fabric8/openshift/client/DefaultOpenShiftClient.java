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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpClient.Builder;
import io.fabric8.kubernetes.client.http.HttpClient.Factory;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;

/**
 * Class for Default Openshift Client implementing KubernetesClient interface.
 * It is thread safe.
 *
 * @deprecated direct usage should no longer be needed. Please use the {@link KubernetesClientBuilder} instead.
 */
@Deprecated
public class DefaultOpenShiftClient extends NamespacedOpenShiftClientAdapter {

  public static final String OPENSHIFT_VERSION_ENDPOINT = "version/openshift";

  public DefaultOpenShiftClient() {
    this(new OpenShiftConfigBuilder().build());
  }

  public DefaultOpenShiftClient(String masterUrl) {
    this(new OpenShiftConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public DefaultOpenShiftClient(final Config config) {
    this(new OpenShiftConfig(config));
  }

  public DefaultOpenShiftClient(final OpenShiftConfig config) {
    this(HttpClientUtils.createHttpClient(config), config);
  }

  public DefaultOpenShiftClient(HttpClient httpClient, OpenShiftConfig config) {
    // basically copied from DefaultKubernetesClient to avoid creating another public method
    KubernetesClientBuilder builder = new KubernetesClientBuilder().withConfig(config);
    if (httpClient != null) {
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
