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
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1APIGroupClient extends ClientAdapter<V1APIGroupClient> implements V1APIGroupDSL {

  public V1APIGroupClient() {
    super();
  }

  V1APIGroupClient(Client client) {
    init(client);
  }

  @Override
  public MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules() {
    return resources(DestinationRule.class, DestinationRuleList.class);
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

  @Override
  public MixedOperation<AuthorizationPolicy, AuthorizationPolicyList, Resource<AuthorizationPolicy>> authorizationPolicies() {
    return resources(AuthorizationPolicy.class, AuthorizationPolicyList.class);
  }

  @Override
  public MixedOperation<PeerAuthentication, PeerAuthenticationList, Resource<PeerAuthentication>> peerAuthentications() {
    return resources(PeerAuthentication.class, PeerAuthenticationList.class);
  }

  @Override
  public MixedOperation<RequestAuthentication, RequestAuthenticationList, Resource<RequestAuthentication>> requestAuthentications() {
    return resources(RequestAuthentication.class, RequestAuthenticationList.class);
  }

  @Override
  public MixedOperation<Telemetry, TelemetryList, Resource<Telemetry>> telemetry() {
    return resources(Telemetry.class, TelemetryList.class);
  }

  @Override
  public V1APIGroupClient newInstance() {
    return new V1APIGroupClient();
  }
}
