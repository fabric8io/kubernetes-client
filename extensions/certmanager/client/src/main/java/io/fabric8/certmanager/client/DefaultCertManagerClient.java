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
package io.fabric8.certmanager.client;

import io.fabric8.certmanager.client.dsl.V1APIGroupDSL;
import io.fabric8.certmanager.client.dsl.V1alpha2APIGroupDSL;
import io.fabric8.certmanager.client.dsl.V1alpha3APIGroupDSL;
import io.fabric8.certmanager.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import okhttp3.OkHttpClient;

public class DefaultCertManagerClient extends BaseClient implements NamespacedCertManagerClient {

  public DefaultCertManagerClient() {
    super();
  }

  public DefaultCertManagerClient(Config configuration) {
    super(configuration);
  }

  public DefaultCertManagerClient(OkHttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
  public NamespacedCertManagerClient inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedCertManagerClient inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration())
      .withNamespace(namespace)
      .build();

    return new DefaultCertManagerClient(getHttpClient(), updated);
  }

  @Override
  public FunctionCallable<NamespacedCertManagerClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public V1APIGroupDSL v1() { return adapt(V1APIGroupClient.class); }

  @Override
  public V1alpha2APIGroupDSL v1alpha2() {
    return adapt(V1alpha2APIGroupClient.class);
  }

  @Override
  public V1alpha3APIGroupDSL v1alpha3() {
    return adapt(V1alpha3APIGroupClient.class);
  }

  @Override
  public V1beta1APIGroupDSL v1beta1() {
    return adapt(V1beta1APIGroupClient.class);
  }

}
