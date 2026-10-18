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
package io.fabric8.ovn.client.dsl;

import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRoute;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteList;
import io.fabric8.kubernetes.api.model.ovn.v1.ClusterNetworkConnect;
import io.fabric8.kubernetes.api.model.ovn.v1.ClusterNetworkConnectList;
import io.fabric8.kubernetes.api.model.ovn.v1.ClusterUserDefinedNetwork;
import io.fabric8.kubernetes.api.model.ovn.v1.ClusterUserDefinedNetworkList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewall;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIP;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoS;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressService;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceList;
import io.fabric8.kubernetes.api.model.ovn.v1.RouteAdvertisements;
import io.fabric8.kubernetes.api.model.ovn.v1.RouteAdvertisementsList;
import io.fabric8.kubernetes.api.model.ovn.v1.VTEP;
import io.fabric8.kubernetes.api.model.ovn.v1.VTEPList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1OpenVirtualNetworkingAPIGroupDSL extends Client {
  /**
   * API entrypoint for k8s.ovn.org/v1 EgressIP.
   * EgressIP is a CRD allowing the user to define a fixed
   * source IP for all egress traffic originating from any pods which
   * match the EgressIP resource according to its spec definition.
   *
   * @return {@link NonNamespaceOperation} for EgressIP
   */
  NonNamespaceOperation<EgressIP, EgressIPList, Resource<EgressIP>> egressIps();

  /**
   * API entrypoint for k8s.ovn.org/v1 AdminPolicyBasedExternalRoute.
   * AdminPolicyBasedExternalRoute is a CRD allowing the cluster administrators to configure policies for external gateway IPs
   * to be applied to all the pods contained in selected namespaces.
   * Egress traffic from the pods that belong to the selected namespaces to outside the cluster is routed through these external
   * gateway IPs.
   *
   * @return {@link NonNamespaceOperation} for AdminPolicBasedExternalRoute
   */
  NonNamespaceOperation<AdminPolicyBasedExternalRoute, AdminPolicyBasedExternalRouteList, Resource<AdminPolicyBasedExternalRoute>> adminPolicyBasedExternalRoutes();

  /**
   * API entrypoint for k8s.ovn.org/v1 EgressFirewall.
   * EgressFirewall describes the current egress firewall for a Namespace.
   * Traffic from a pod to an IP address outside the cluster will be checked against
   * each EgressFirewallRule in the pod's namespace's EgressFirewall, in
   * order. If no rule matches (or no EgressFirewall is present) then the traffic
   * will be allowed by default.
   *
   * @return {@link MixedOperation} for EgressFirewall
   */
  MixedOperation<EgressFirewall, EgressFirewallList, Resource<EgressFirewall>> egressFirewalls();

  /**
   * API entrypoint for k8s.ovn.org/v1 EgressQoS.
   * EgressQoS is a CRD that allows the user to define a DSCP value
   * for pods egress traffic on its namespace to specified CIDRs.
   * Traffic from these pods will be checked against each EgressQoSRule in
   * the namespace's EgressQoS, and if there is a match the traffic is marked
   * with the relevant DSCP value.
   *
   * @return {@link MixedOperation} for EgressQoS
   */
  MixedOperation<EgressQoS, EgressQoSList, Resource<EgressQoS>> egressQoses();

  /**
   * API entrypoint for k8s.ovn.org/v1 EgressService.
   * EgressService is a CRD that allows the user to request that the source
   * IP of egress packets originating from all the pods that are endpoints
   * of the corresponding LoadBalancer Service would be its ingress IP.
   * In addition, it allows the user to request that egress packets originating from
   * all the pods that are endpoints of the LoadBalancer service would use a different
   * network than the main one.
   *
   * @return {@link MixedOperation} for EgressService
   */
  MixedOperation<EgressService, EgressServiceList, Resource<EgressService>> egressServices();

  /**
   * API entrypoint for k8s.ovn.org/v1 ClusterNetworkConnect.
   * ClusterNetworkConnect enables connecting multiple User Defined Networks and/or
   * Cluster User Defined Networks together.
   *
   * @return {@link NonNamespaceOperation} for ClusterNetworkConnect
   */
  NonNamespaceOperation<ClusterNetworkConnect, ClusterNetworkConnectList, Resource<ClusterNetworkConnect>> clusterNetworkConnects();

  /**
   * API entrypoint for k8s.ovn.org/v1 ClusterUserDefinedNetwork.
   * ClusterUserDefinedNetwork describes a network request for a shared network across namespaces.
   *
   * @return {@link NonNamespaceOperation} for ClusterUserDefinedNetwork
   */
  NonNamespaceOperation<ClusterUserDefinedNetwork, ClusterUserDefinedNetworkList, Resource<ClusterUserDefinedNetwork>> clusterUserDefinedNetworks();

  /**
   * API entrypoint for k8s.ovn.org/v1 RouteAdvertisements.
   * RouteAdvertisements determines which network routes are advertised through FRR (BGP),
   * from which nodes and in which VRF.
   *
   * @return {@link NonNamespaceOperation} for RouteAdvertisements
   */
  NonNamespaceOperation<RouteAdvertisements, RouteAdvertisementsList, Resource<RouteAdvertisements>> routeAdvertisements();

  /**
   * API entrypoint for k8s.ovn.org/v1 VTEP.
   * VTEP defines VTEP (VXLAN Tunnel Endpoint) IP configuration for EVPN.
   *
   * @return {@link NonNamespaceOperation} for VTEP
   */
  NonNamespaceOperation<VTEP, VTEPList, Resource<VTEP>> vteps();
}
