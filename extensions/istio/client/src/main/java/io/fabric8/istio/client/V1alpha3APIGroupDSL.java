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
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

/**
 * Main interface for Istio Client.
 */
public interface V1alpha3APIGroupDSL extends Client {

  // networking
  MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules();

  MixedOperation<EnvoyFilter, EnvoyFilterList, Resource<EnvoyFilter>> envoyFilters();

  MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways();

  MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries();

  MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars();

  MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices();

  MixedOperation<WorkloadEntry, WorkloadEntryList, Resource<WorkloadEntry>> workloadEntries();
}
