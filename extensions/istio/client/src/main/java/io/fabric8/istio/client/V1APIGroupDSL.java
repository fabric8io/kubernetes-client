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

import io.fabric8.istio.api.networking.v1.DestinationRule;
import io.fabric8.istio.api.networking.v1.DestinationRuleList;
import io.fabric8.istio.api.networking.v1.Gateway;
import io.fabric8.istio.api.networking.v1.GatewayList;
import io.fabric8.istio.api.networking.v1.ServiceEntry;
import io.fabric8.istio.api.networking.v1.ServiceEntryList;
import io.fabric8.istio.api.networking.v1.Sidecar;
import io.fabric8.istio.api.networking.v1.SidecarList;
import io.fabric8.istio.api.networking.v1.VirtualService;
import io.fabric8.istio.api.networking.v1.VirtualServiceList;
import io.fabric8.istio.api.networking.v1.WorkloadEntry;
import io.fabric8.istio.api.networking.v1.WorkloadEntryList;
import io.fabric8.istio.api.networking.v1.WorkloadGroup;
import io.fabric8.istio.api.networking.v1.WorkloadGroupList;
import io.fabric8.istio.api.security.v1.AuthorizationPolicy;
import io.fabric8.istio.api.security.v1.AuthorizationPolicyList;
import io.fabric8.istio.api.security.v1.PeerAuthentication;
import io.fabric8.istio.api.security.v1.PeerAuthenticationList;
import io.fabric8.istio.api.security.v1.RequestAuthentication;
import io.fabric8.istio.api.security.v1.RequestAuthenticationList;
import io.fabric8.istio.api.telemetry.v1.Telemetry;
import io.fabric8.istio.api.telemetry.v1.TelemetryList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1APIGroupDSL extends Client {
  // networking
  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/destination-rule/">DestinationRule</a>
   *
   * @return MixedOperation for DestinationRule class
   */
  MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules();

  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/gateway/">Gateway</a>
   *
   * @return MixedOperation for Gateway class
   */
  MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways();

  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/service-entry/">ServiceEntry</a>
   *
   * @return MixedOperation for ServiceEntry class
   */
  MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries();

  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/sidecar/">Sidecar</a>
   *
   * @return MixedOperation for Sidecar class
   */
  MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars();

  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/virtual-service/">VirtualService</a>
   *
   * @return MixedOperation for VirtualService class
   */
  MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices();

  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/networking/workload-entry/">WorkloadEntry</a>
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

  // security
  /**
   * API entrypoint for
   * <a href="https://istio.io/latest/docs/reference/config/security/authorization-policy/">AuthorizationPolicy</a>
   *
   * @return MixedOperation for AuthorizationPolicy class
   */
  MixedOperation<AuthorizationPolicy, AuthorizationPolicyList, Resource<AuthorizationPolicy>> authorizationPolicies();

  /**
   * API entrypoint for
   * <a href="https://istio.io/latest/docs/reference/config/security/peer_authentication/">PeerAuthentication</a>
   *
   * @return MixedOperation for PeerAuthentication class
   */
  MixedOperation<PeerAuthentication, PeerAuthenticationList, Resource<PeerAuthentication>> peerAuthentications();

  /**
   * API entrypoint for
   * <a href="https://istio.io/latest/docs/reference/config/security/request_authentication/">RequestAuthentication</a>
   *
   * @return MixedOperation for RequestAuthentication class
   */
  MixedOperation<RequestAuthentication, RequestAuthenticationList, Resource<RequestAuthentication>> requestAuthentications();

  // telemetry
  /**
   * API entrypoint for <a href="https://istio.io/latest/docs/reference/config/telemetry/">Telemetry</a>
   *
   * @return MixedOperation for Telemetry class
   */
  MixedOperation<Telemetry, TelemetryList, Resource<Telemetry>> telemetry();
}
