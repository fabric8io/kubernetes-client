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

import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;

public class NetworkAPIGroupClient extends BaseClient implements NetworkAPIGroupDSL {

  public NetworkAPIGroupClient() {
    super();
  }

  public NetworkAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public V1NetworkAPIGroupDSL v1() {
    return adapt(V1NetworkAPIGroupClient.class);
  }

  @Override
  public V1beta1NetworkAPIGroupDSL v1beta1() {
    return adapt(V1beta1NetworkAPIGroupClient.class);
  }

  @Override
  public MixedOperation<NetworkPolicy, NetworkPolicyList, Resource<NetworkPolicy>> networkPolicies() {
    return Handlers.getOperation(NetworkPolicy.class, NetworkPolicyList.class, httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<Ingress, IngressList, Resource<Ingress>> ingress() {
    return ingresses();
  }

  @Override
  public MixedOperation<Ingress, IngressList, Resource<Ingress>> ingresses() {
    return Handlers.getOperation(Ingress.class, IngressList.class, httpClient, getConfiguration());
  }
}
