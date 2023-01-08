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
package io.fabric8.istio.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.extension.ExtensionRootClientAdapter;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;

public class DefaultIstioClient extends ExtensionRootClientAdapter<DefaultIstioClient>
    implements NamespacedIstioClient, SupportTestingClient {

  public DefaultIstioClient() {
    super();
  }

  public DefaultIstioClient(Config config) {
    super(config);
  }

  public DefaultIstioClient(Client client) {
    super(client);
  }

  @Override
  protected DefaultIstioClient newInstance(Client client) {
    return new DefaultIstioClient(client);
  }

  @Override
  public FunctionCallable<NamespacedIstioClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public V1alpha3APIGroupDSL v1alpha3() {
    return adapt(V1alpha3APIGroupClient.class);
  }

  @Override
  public V1beta1APIGroupDSL v1beta1() {
    return adapt(V1beta1APIGroupClient.class);
  }

  @Override
  public boolean isSupported() {
    return hasApiGroup("istio.io", false);
  }
}
