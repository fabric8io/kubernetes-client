/*
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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.networking.v1.IPAddress;
import io.fabric8.kubernetes.api.model.networking.v1.IPAddressList;
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1.IngressClass;
import io.fabric8.kubernetes.api.model.networking.v1.IngressClassList;
import io.fabric8.kubernetes.api.model.networking.v1.IngressList;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.networking.v1.ServiceCIDR;
import io.fabric8.kubernetes.api.model.networking.v1.ServiceCIDRList;
import io.fabric8.kubernetes.client.V1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1NetworkAPIGroupClient extends ClientAdapter<V1NetworkAPIGroupClient> implements V1NetworkAPIGroupDSL {

  @Override
  public MixedOperation<NetworkPolicy, NetworkPolicyList, Resource<NetworkPolicy>> networkPolicies() {
    return resources(NetworkPolicy.class, NetworkPolicyList.class);
  }

  @Override
  public MixedOperation<Ingress, IngressList, Resource<Ingress>> ingresses() {
    return resources(Ingress.class, IngressList.class);
  }

  @Override
  public NonNamespaceOperation<IngressClass, IngressClassList, Resource<IngressClass>> ingressClasses() {
    return resources(IngressClass.class, IngressClassList.class);
  }

  @Override
  public NonNamespaceOperation<IPAddress, IPAddressList, Resource<IPAddress>> ipAddresses() {
    return resources(IPAddress.class, IPAddressList.class);
  }

  @Override
  public NonNamespaceOperation<ServiceCIDR, ServiceCIDRList, Resource<ServiceCIDR>> serviceCIDRs() {
    return resources(ServiceCIDR.class, ServiceCIDRList.class);
  }

  @Override
  public V1NetworkAPIGroupClient newInstance() {
    return new V1NetworkAPIGroupClient();
  }
}
