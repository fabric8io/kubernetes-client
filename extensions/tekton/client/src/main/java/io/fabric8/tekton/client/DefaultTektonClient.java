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
package io.fabric8.tekton.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.tekton.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.tekton.client.dsl.V1beta1APIGroupDSL;

public class DefaultTektonClient extends BaseClient implements NamespacedTektonClient {

  public DefaultTektonClient() {
    super();
  }

  public DefaultTektonClient(Config configuration) {
    super(configuration);
  }

  public DefaultTektonClient(HttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
  public NamespacedTektonClient inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedTektonClient inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration())
      .withNamespace(namespace)
      .build();

    return new DefaultTektonClient(getHttpClient(), updated);
  }

  @Override
  public FunctionCallable<NamespacedTektonClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public V1beta1APIGroupDSL v1beta1() {
    return adapt(V1beta1APIGroupClient.class);
  }

  @Override
  public V1alpha1APIGroupDSL v1alpha1() {
    return adapt(V1alpha1APIGroupClient.class);
  }

}
