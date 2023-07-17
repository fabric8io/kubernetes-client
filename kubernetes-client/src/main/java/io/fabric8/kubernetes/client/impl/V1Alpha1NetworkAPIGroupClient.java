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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDR;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDRList;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddress;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddressList;
import io.fabric8.kubernetes.client.V1Alpha1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1Alpha1NetworkAPIGroupClient extends ClientAdapter<V1Alpha1NetworkAPIGroupClient>
    implements V1Alpha1NetworkAPIGroupDSL {
  @Override
  public NonNamespaceOperation<IPAddress, IPAddressList, Resource<IPAddress>> ipAddresses() {
    return resources(IPAddress.class, IPAddressList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterCIDR, ClusterCIDRList, Resource<ClusterCIDR>> clusterCIDRs() {
    return resources(ClusterCIDR.class, ClusterCIDRList.class);
  }

  @Override
  public V1Alpha1NetworkAPIGroupClient newInstance() {
    return new V1Alpha1NetworkAPIGroupClient();
  }
}
