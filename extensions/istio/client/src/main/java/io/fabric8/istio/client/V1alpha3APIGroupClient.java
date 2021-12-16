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
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class V1alpha3APIGroupClient extends BaseClient implements V1alpha3APIGroupDSL {

  public V1alpha3APIGroupClient() {
    super();
  }

  public V1alpha3APIGroupClient(Config configuration) {
    super(configuration);
  }

  public V1alpha3APIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  // networking

  @Override
  public MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules() {
    return Handlers.getOperation(DestinationRule.class, DestinationRuleList.class, this);
  }

  @Override
  public MixedOperation<EnvoyFilter, EnvoyFilterList, Resource<EnvoyFilter>> envoyFilters() {
    return Handlers.getOperation(EnvoyFilter.class, EnvoyFilterList.class, this);
  }

  @Override
  public MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways() {
    return Handlers.getOperation(Gateway.class, GatewayList.class, this);
  }

  @Override
  public MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries() {
    return Handlers.getOperation(ServiceEntry.class, ServiceEntryList.class, this);
  }

  @Override
  public MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars() {
    return Handlers.getOperation(Sidecar.class, SidecarList.class, this);
  }

  @Override
  public MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices() {
    return Handlers.getOperation(VirtualService.class, VirtualServiceList.class, this);
  }

  @Override
  public MixedOperation<WorkloadEntry, WorkloadEntryList, Resource<WorkloadEntry>> workloadEntries() {
    return Handlers.getOperation(WorkloadEntry.class, WorkloadEntryList.class, this);
  }
}
