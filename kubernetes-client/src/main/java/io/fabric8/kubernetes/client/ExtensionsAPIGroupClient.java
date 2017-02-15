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
import io.fabric8.kubernetes.api.model.extensions.DoneableDaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DoneableDeployment;
import io.fabric8.kubernetes.api.model.extensions.DoneableHorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.extensions.DoneableIngress;
import io.fabric8.kubernetes.api.model.DoneableJob;
import io.fabric8.kubernetes.api.model.extensions.DoneableReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.DoneableThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.api.model.Job;
import io.fabric8.kubernetes.api.model.JobList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.DaemonSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.DeploymentOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.HorizontalPodAutoscalerOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.IngressOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.JobOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ReplicaSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ThirdPartyResourceOperationsImpl;

import okhttp3.OkHttpClient;

public class ExtensionsAPIGroupClient extends BaseClient implements ExtensionsAPIGroupDSL {

  public ExtensionsAPIGroupClient() throws KubernetesClientException {
    super();
  }

  public ExtensionsAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Job, JobList, DoneableJob, ScalableResource<Job, DoneableJob>> jobs() {
    return new JobOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<Deployment, DeploymentList, DoneableDeployment, ScalableResource<Deployment, DoneableDeployment>> deployments() {
    return new DeploymentOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  @Deprecated
  public MixedOperation<Ingress, IngressList, DoneableIngress, Resource<Ingress, DoneableIngress>> ingress() {
    return ingresses();
  }

  @Override
  public MixedOperation<Ingress, IngressList, DoneableIngress, Resource<Ingress, DoneableIngress>> ingresses() {
    return new IngressOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<DaemonSet, DaemonSetList, DoneableDaemonSet, Resource<DaemonSet, DoneableDaemonSet>> daemonSets() {
    return new DaemonSetOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  public MixedOperation<ThirdPartyResource, ThirdPartyResourceList, DoneableThirdPartyResource, Resource<ThirdPartyResource, DoneableThirdPartyResource>> thirdPartyResources() {
    return new ThirdPartyResourceOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  public MixedOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet, RollableScallableResource<ReplicaSet, DoneableReplicaSet>> replicaSets() {
    return new ReplicaSetOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  public MixedOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, DoneableHorizontalPodAutoscaler, Resource<HorizontalPodAutoscaler, DoneableHorizontalPodAutoscaler>> horizontalPodAutoscalers() {
    return new HorizontalPodAutoscalerOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }
}
