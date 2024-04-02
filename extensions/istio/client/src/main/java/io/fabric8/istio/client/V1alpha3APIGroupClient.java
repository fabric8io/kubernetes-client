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
package io.fabric8.istio.client;

import io.fabric8.istio.api.networking.v1alpha3.DestinationRule;
import io.fabric8.istio.api.networking.v1alpha3.DestinationRuleList;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilter;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterList;
import io.fabric8.istio.api.networking.v1alpha3.Gateway;
import io.fabric8.istio.api.networking.v1alpha3.GatewayList;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntry;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntryList;
import io.fabric8.istio.api.networking.v1alpha3.Sidecar;
import io.fabric8.istio.api.networking.v1alpha3.SidecarList;
import io.fabric8.istio.api.networking.v1alpha3.VirtualService;
import io.fabric8.istio.api.networking.v1alpha3.VirtualServiceList;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadEntry;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadEntryList;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadGroup;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadGroupList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1alpha3APIGroupClient extends ClientAdapter<V1alpha3APIGroupClient> implements V1alpha3APIGroupDSL {

  @Override
  public V1alpha3APIGroupClient newInstance() {
    return new V1alpha3APIGroupClient();
  }

  // networking

  @Override
  public MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules() {
    return resources(DestinationRule.class, DestinationRuleList.class);
  }

  @Override
  public MixedOperation<EnvoyFilter, EnvoyFilterList, Resource<EnvoyFilter>> envoyFilters() {
    return resources(EnvoyFilter.class, EnvoyFilterList.class);
  }

  @Override
  public MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways() {
    return resources(Gateway.class, GatewayList.class);
  }

  @Override
  public MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries() {
    return resources(ServiceEntry.class, ServiceEntryList.class);
  }

  @Override
  public MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars() {
    return resources(Sidecar.class, SidecarList.class);
  }

  @Override
  public MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices() {
    return resources(VirtualService.class, VirtualServiceList.class);
  }

  @Override
  public MixedOperation<WorkloadEntry, WorkloadEntryList, Resource<WorkloadEntry>> workloadEntries() {
    return resources(WorkloadEntry.class, WorkloadEntryList.class);
  }

  @Override
  public MixedOperation<WorkloadGroup, WorkloadGroupList, Resource<WorkloadGroup>> workloadGroups() {
    return resources(WorkloadGroup.class, WorkloadGroupList.class);
  }
}
