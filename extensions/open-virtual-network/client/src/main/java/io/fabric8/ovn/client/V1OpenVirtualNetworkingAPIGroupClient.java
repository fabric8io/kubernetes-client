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
package io.fabric8.ovn.client;

import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRoute;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewall;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIP;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoS;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressService;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.ovn.client.dsl.V1OpenVirtualNetworkingAPIGroupDSL;

public class V1OpenVirtualNetworkingAPIGroupClient extends ClientAdapter<V1OpenVirtualNetworkingAPIGroupClient>
    implements V1OpenVirtualNetworkingAPIGroupDSL {
  @Override
  public NonNamespaceOperation<EgressIP, EgressIPList, Resource<EgressIP>> egressIps() {
    return resources(EgressIP.class, EgressIPList.class);
  }

  @Override
  public NonNamespaceOperation<AdminPolicyBasedExternalRoute, AdminPolicyBasedExternalRouteList, Resource<AdminPolicyBasedExternalRoute>> adminPolicyBasedExternalRoutes() {
    return resources(AdminPolicyBasedExternalRoute.class, AdminPolicyBasedExternalRouteList.class);
  }

  @Override
  public MixedOperation<EgressFirewall, EgressFirewallList, Resource<EgressFirewall>> egressFirewalls() {
    return resources(EgressFirewall.class, EgressFirewallList.class);
  }

  @Override
  public MixedOperation<EgressQoS, EgressQoSList, Resource<EgressQoS>> egressQoses() {
    return resources(EgressQoS.class, EgressQoSList.class);
  }

  @Override
  public MixedOperation<EgressService, EgressServiceList, Resource<EgressService>> egressServices() {
    return resources(EgressService.class, EgressServiceList.class);
  }

  @Override
  public V1OpenVirtualNetworkingAPIGroupClient newInstance() {
    return new V1OpenVirtualNetworkingAPIGroupClient();
  }
}
