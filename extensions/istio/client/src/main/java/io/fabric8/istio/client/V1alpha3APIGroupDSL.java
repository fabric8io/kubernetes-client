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
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

/**
 * Main interface for Istio Client.
 */
public interface V1alpha3APIGroupDSL extends Client {

  // networking
  /**
   * API entrypoint for DestinationRule(https://istio.io/latest/docs/reference/config/networking/destination-rule/)
   *
   * @return MixedOperation for DestinationRule class
   */
  MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules();

  /**
   * API entrypoint for EnvoyFilter(https://istio.io/latest/docs/reference/config/networking/envoy-filter/)
   *
   * @return MixedOperation for EnvoyFilter class
   */
  MixedOperation<EnvoyFilter, EnvoyFilterList, Resource<EnvoyFilter>> envoyFilters();

  /**
   * API entrypoint for Gateway(https://istio.io/latest/docs/reference/config/networking/gateway/)
   *
   * @return MixedOperation for Gateway class
   */
  MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways();

  /**
   * API entrypoint for ServiceEntry(https://istio.io/latest/docs/reference/config/networking/service-entry/)
   *
   * @return MixedOperation for ServiceEntry class
   */
  MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries();

  /**
   * API entrypoint for Sidecar(https://istio.io/latest/docs/reference/config/networking/sidecar/)
   *
   * @return MixedOperation for Sidecar class
   */
  MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars();

  /**
   * API entrypoint for VirtualService(https://istio.io/latest/docs/reference/config/networking/virtual-service/)
   *
   * @return MixedOperation for VirtualService class
   */
  MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices();

  /**
   * API entrypoint for WorkloadEntry(https://istio.io/latest/docs/reference/config/networking/workload-entry/)
   *
   * @return MixedOperation for WorkloadEntry class
   */
  MixedOperation<WorkloadEntry, WorkloadEntryList, Resource<WorkloadEntry>> workloadEntries();

  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/workload-group/">WorkloadGroup</a>
   *
   * @return MixedOperation for WorkloadGroup class
   */
  MixedOperation<WorkloadGroup, WorkloadGroupList, Resource<WorkloadGroup>> workloadGroups();
}
