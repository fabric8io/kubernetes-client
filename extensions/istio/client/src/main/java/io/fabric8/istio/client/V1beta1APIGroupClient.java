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
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import okhttp3.OkHttpClient;

public class V1beta1APIGroupClient extends BaseClient implements V1beta1APIGroupDSL {

  public V1beta1APIGroupClient() {
    super();
  }

  public V1beta1APIGroupClient(Config configuration) {
    super(configuration);
  }

  public V1beta1APIGroupClient(OkHttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  // networking

  @Override
  public MixedOperation<DestinationRule, DestinationRuleList, Resource<DestinationRule>> destinationRules() {
    return Handlers.getOperation(DestinationRule.class, DestinationRuleList.class, this.getHttpClient(),
      this.getConfiguration());
  }

  @Override
  public MixedOperation<Gateway, GatewayList, Resource<Gateway>> gateways() {
    return Handlers.getOperation(Gateway.class, GatewayList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<ServiceEntry, ServiceEntryList, Resource<ServiceEntry>> serviceEntries() {
    return Handlers.getOperation(ServiceEntry.class, ServiceEntryList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Sidecar, SidecarList, Resource<Sidecar>> sidecars() {
    return Handlers.getOperation(Sidecar.class, SidecarList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<VirtualService, VirtualServiceList, Resource<VirtualService>> virtualServices() {
    return Handlers.getOperation(VirtualService.class, VirtualServiceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<WorkloadEntry, WorkloadEntryList, Resource<WorkloadEntry>> workloadEntries() {
    return Handlers.getOperation(WorkloadEntry.class, WorkloadEntryList.class, this.getHttpClient(), this.getConfiguration());
  }

  // security
  @Override
  public MixedOperation<PeerAuthentication, PeerAuthenticationList, Resource<PeerAuthentication>> peerAuthentications() {
    return Handlers.getOperation(PeerAuthentication.class, PeerAuthenticationList.class, this.getHttpClient(),
      this.getConfiguration());
  }

  @Override
  public MixedOperation<RequestAuthentication, RequestAuthenticationList, Resource<RequestAuthentication>> requestAuthentications() {
    return Handlers.getOperation(RequestAuthentication.class, RequestAuthenticationList.class, this.getHttpClient(),
      this.getConfiguration());
  }

  @Override
  public MixedOperation<AuthorizationPolicy, AuthorizationPolicyList, Resource<AuthorizationPolicy>> authorizationPolicies() {
    return Handlers.getOperation(AuthorizationPolicy.class, AuthorizationPolicyList.class, this.getHttpClient(),
      this.getConfiguration());
  }
}
