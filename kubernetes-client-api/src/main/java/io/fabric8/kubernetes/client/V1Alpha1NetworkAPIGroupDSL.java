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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDR;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDRList;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddress;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddressList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1Alpha1NetworkAPIGroupDSL extends Client {
  /**
   * API entrypoint for networking.k8s.io/v1alpha1 IPAddress
   * <br>
   * IPAddress represents a single IP of a single IP Family. The object is designed to be used by APIs
   * that operate on IP addresses. The object is used by the Service core API for allocation of IP addresses.
   *
   * @return {@link NonNamespaceOperation} for IPAddress
   */
  NonNamespaceOperation<IPAddress, IPAddressList, Resource<IPAddress>> ipAddresses();

  /**
   * API entrypoint for networking.k8s.io/v1alpha1 ClusterCIDR
   * <br>
   * ClusterCIDR represents a single configuration for per-Node Pod CIDR
   * allocations when the MultiCIDRRangeAllocator is enabled (see the config for
   * kube-controller-manager). A cluster may have any number of ClusterCIDR
   * resources, all of which will be considered when allocating a CIDR for a
   * Node. A ClusterCIDR is eligible to be used for a given Node when the node
   * selector matches the node in question and has free CIDRs to allocate. In
   * case of multiple matching ClusterCIDR resources, the allocator will attempt
   * to break ties using internal heuristics, but any ClusterCIDR whose node
   * selector matches the Node may be used.
   *
   * @return {@link NonNamespaceOperation} for ClusterCIDR
   */
  NonNamespaceOperation<ClusterCIDR, ClusterCIDRList, Resource<ClusterCIDR>> clusterCIDRs();
}
