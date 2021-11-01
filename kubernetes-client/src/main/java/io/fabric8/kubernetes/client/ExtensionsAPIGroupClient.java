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

import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetList;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicy;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.DeploymentOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.batch.v1.JobOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.ReplicaSetOperationsImpl;
import io.fabric8.kubernetes.client.http.HttpClient;

public class ExtensionsAPIGroupClient extends BaseClient implements ExtensionsAPIGroupDSL {

  public ExtensionsAPIGroupClient() {
    super();
  }

  public ExtensionsAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  @Deprecated
  public MixedOperation<DaemonSet, DaemonSetList, Resource<DaemonSet>> daemonSets() {
    return Handlers.getOperation(DaemonSet.class, DaemonSetList.class, httpClient, getConfiguration());
  }

  @Override
  @Deprecated
  public MixedOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>> deployments() {
    return new DeploymentOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  @Deprecated
  public MixedOperation<Ingress, IngressList, Resource<Ingress>> ingress() {
    return ingresses();
  }

  @Override
  public MixedOperation<Ingress, IngressList, Resource<Ingress>> ingresses() {
    return Handlers.getOperation(Ingress.class, IngressList.class, httpClient, getConfiguration());
  }

  @Override
  @Deprecated
  public MixedOperation<Job, JobList, ScalableResource<Job>> jobs() {
    return new JobOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  @Deprecated
  public MixedOperation<NetworkPolicy, NetworkPolicyList, Resource<NetworkPolicy>> networkPolicies() {
    return Handlers.getOperation(NetworkPolicy.class, NetworkPolicyList.class, httpClient, getConfiguration());
  }

  @Override
  @Deprecated
  /**
   * @deprecated Replaced by {@link PolicyAPIGroupClient#podSecurityPolicies()}
   */
  public MixedOperation<PodSecurityPolicy, PodSecurityPolicyList, Resource<PodSecurityPolicy>> podSecurityPolicies() {
    return Handlers.getOperation(PodSecurityPolicy.class, PodSecurityPolicyList.class, httpClient, getConfiguration());
  }

  @Override
  @Deprecated
  public MixedOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>> replicaSets() {
    return new ReplicaSetOperationsImpl(httpClient, getConfiguration());
  }

}
