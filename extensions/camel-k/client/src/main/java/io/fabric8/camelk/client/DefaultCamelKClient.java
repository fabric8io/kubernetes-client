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
package io.fabric8.camelk.client;

import io.fabric8.camelk.client.dsl.V1APIGroupDSL;
import io.fabric8.camelk.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;

public class DefaultCamelKClient extends ClientAdapter<DefaultCamelKClient>
    implements NamespacedCamelKClient, SupportTestingClient {

  public DefaultCamelKClient() {
    super();
  }

  public DefaultCamelKClient(Config configuration) {
    super(configuration);
  }

  public DefaultCamelKClient(Client client) {
    super(client);
  }

  @Override
  protected DefaultCamelKClient newInstance(Client client) {
    return new DefaultCamelKClient(client);
  }

  @Override
  public FunctionCallable<NamespacedCamelKClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public V1APIGroupDSL v1() {
    return adapt(V1APIGroupClient.class);
  }

  @Override
  public V1alpha1APIGroupDSL v1alpha1() {
    return adapt(V1alpha1APIGroupClient.class);
  }

  @Override
  public boolean isSupported() {
    return hasApiGroup("camel.apache.org", true);
  }

}
