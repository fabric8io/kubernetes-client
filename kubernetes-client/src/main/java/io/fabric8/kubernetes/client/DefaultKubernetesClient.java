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

import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.InputStream;

/**
 * Class for Default Kubernetes Client implementing KubernetesClient interface.
 * It is thread safe.
 */
public class DefaultKubernetesClient extends BaseKubernetesClient<NamespacedKubernetesClient> implements NamespacedKubernetesClient {

  public DefaultKubernetesClient() {
    super();
  }

  public DefaultKubernetesClient(String masterUrl) {
    super(masterUrl);
  }

  public DefaultKubernetesClient(Config config) {
    super(config);
  }
  
  public DefaultKubernetesClient(HttpClient httpClient, Config config) {
    super(httpClient, config);
  }

  public static DefaultKubernetesClient fromConfig(String config) {
    return new DefaultKubernetesClient(Serialization.unmarshal(config, Config.class));
  }

  public static DefaultKubernetesClient fromConfig(InputStream is) {
    return new DefaultKubernetesClient(Serialization.unmarshal(is, Config.class));
  }

  @Override
  public NamespacedKubernetesClient inNamespace(String name) {
    Config updated = new ConfigBuilder(getConfiguration()).withNamespace(name).build();
    return new DefaultKubernetesClient(httpClient, updated);
  }

  @Override
  public LeaderElectorBuilder<NamespacedKubernetesClient> leaderElector() {
    return new LeaderElectorBuilder<>(this);
  }

  @Override
  public FunctionCallable<NamespacedKubernetesClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

}
