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

import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetList;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicy;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.V1NetworkAPIGroupDSL;

public interface ExtensionsAPIGroupDSL extends Client {

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use apps/v1 instead ({@link AppsAPIGroupDSL#daemonSets()
   *             kubernetesClient.apps().daemonSets()}).
   */
  @Deprecated
  MixedOperation<DaemonSet, DaemonSetList, Resource<DaemonSet>> daemonSets();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use apps/v1 instead ({@link AppsAPIGroupDSL#deployments()
   *             kubernetesClient.apps().deployments()}).
   */
  @Deprecated
  MixedOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>> deployments();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use networking.k8s.io/v1 instead
   *             ({@link V1NetworkAPIGroupDSL#ingresses() kubernetesClient.network().v1().ingresses()}).
   */
  @Deprecated
  MixedOperation<Ingress, IngressList, Resource<Ingress>> ingress();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use networking.k8s.io/v1 instead
   *             ({@link V1NetworkAPIGroupDSL#ingresses() kubernetesClient.network().v1().ingresses()}).
   */
  MixedOperation<Ingress, IngressList, Resource<Ingress>> ingresses();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use batch/v1 instead ({@link V1BatchAPIGroupDSL#jobs()
   *             kubernetesClient.batch().v1().jobs()}).
   */
  @Deprecated
  MixedOperation<Job, JobList, ScalableResource<Job>> jobs();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use networking.k8s.io/v1 instead
   *             ({@link V1NetworkAPIGroupDSL#networkPolicies() kubernetesClient.network().v1().networkPolicies()}).
   */
  @Deprecated
  MixedOperation<NetworkPolicy, NetworkPolicyList, Resource<NetworkPolicy>> networkPolicies();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use apps/v1 instead ({@link AppsAPIGroupDSL#replicaSets()
   *             kubernetesClient.apps().replicaSets()}).
   */
  @Deprecated
  MixedOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>> replicaSets();

  /**
   * @deprecated The extensions/v1beta1 API is deprecated. Use policy/v1beta1 instead
   *             ({@link V1beta1PolicyAPIGroupDSL#podSecurityPolicies()
   *             kubernetesClient.policy().v1beta1().podSecurityPolicies()}).
   */
  @Deprecated
  MixedOperation<PodSecurityPolicy, PodSecurityPolicyList, Resource<PodSecurityPolicy>> podSecurityPolicies();

}
