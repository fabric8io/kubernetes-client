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

import io.fabric8.istio.api.networking.v1beta1.DestinationRule;
import io.fabric8.istio.api.networking.v1beta1.DestinationRuleList;
import io.fabric8.istio.api.networking.v1beta1.Gateway;
import io.fabric8.istio.api.networking.v1beta1.GatewayList;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntry;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntryList;
import io.fabric8.istio.api.networking.v1beta1.Sidecar;
import io.fabric8.istio.api.networking.v1beta1.SidecarList;
import io.fabric8.istio.api.networking.v1beta1.VirtualService;
import io.fabric8.istio.api.networking.v1beta1.VirtualServiceList;
import io.fabric8.istio.api.networking.v1beta1.WorkloadEntry;
import io.fabric8.istio.api.networking.v1beta1.WorkloadEntryList;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicy;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyList;
import io.fabric8.istio.api.security.v1beta1.PeerAuthentication;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationList;
import io.fabric8.istio.api.security.v1beta1.RequestAuthentication;
import io.fabric8.istio.api.security.v1beta1.RequestAuthenticationList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

/**
 * Main interface for Istio Client.
 */
public interface V1beta1APIGroupDSL extends Client {
  // networking
  MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules();

  MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways();

  MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries();

  MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars();

  MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices();

  MixedOperation<WorkloadEntry, WorkloadEntryList, Resource<WorkloadEntry>> workloadEntries();

  // security
  MixedOperation<PeerAuthentication, PeerAuthenticationList, Resource<PeerAuthentication>> peerAuthentications();

  MixedOperation<RequestAuthentication, RequestAuthenticationList, Resource<RequestAuthentication>> requestAuthentications();

  MixedOperation<AuthorizationPolicy, AuthorizationPolicyList, Resource<AuthorizationPolicy>> authorizationPolicies();
}
