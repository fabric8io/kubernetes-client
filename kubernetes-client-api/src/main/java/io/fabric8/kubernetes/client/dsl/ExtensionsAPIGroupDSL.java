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

public interface ExtensionsAPIGroupDSL extends Client {

  @Deprecated
  MixedOperation<DaemonSet, DaemonSetList, Resource<DaemonSet>> daemonSets();

  @Deprecated
  MixedOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>> deployments();

  @Deprecated
  MixedOperation<Ingress, IngressList, Resource<Ingress>> ingress();

  MixedOperation<Ingress, IngressList, Resource<Ingress>> ingresses();

  @Deprecated
  MixedOperation<Job, JobList, ScalableResource<Job>> jobs();

  @Deprecated
  MixedOperation<NetworkPolicy, NetworkPolicyList, Resource<NetworkPolicy>> networkPolicies();

  @Deprecated
  MixedOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>> replicaSets();

  @Deprecated
  /**
   * @deprecated Replaced by {@link PolicyAPIGroupDSL#podSecurityPolicies()}
   */
  MixedOperation<PodSecurityPolicy, PodSecurityPolicyList, Resource<PodSecurityPolicy>> podSecurityPolicies();

}
