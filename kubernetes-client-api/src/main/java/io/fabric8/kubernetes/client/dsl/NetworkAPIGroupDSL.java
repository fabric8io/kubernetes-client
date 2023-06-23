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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.V1Alpha1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.V1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.V1beta1NetworkAPIGroupDSL;

public interface NetworkAPIGroupDSL extends Client {
  V1NetworkAPIGroupDSL v1();

  V1beta1NetworkAPIGroupDSL v1beta1();

  V1Alpha1NetworkAPIGroupDSL v1alpha1();

  MixedOperation<NetworkPolicy, NetworkPolicyList, Resource<NetworkPolicy>> networkPolicies();

  MixedOperation<Ingress, IngressList, Resource<Ingress>> ingress();

  MixedOperation<Ingress, IngressList, Resource<Ingress>> ingresses();
}
