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

import io.fabric8.kubernetes.api.model.extensions.*;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ClientScaleableResource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.DaemonSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.DeploymentOperationsImpl;
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
  public ClientMixedOperation<Job, JobList, DoneableJob, ClientScaleableResource<Job, DoneableJob>> jobs() {
    return new JobOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public ClientMixedOperation<Deployment, DeploymentList, DoneableDeployment, ClientScaleableResource<Deployment, DoneableDeployment>> deployments() {
    return new DeploymentOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  @Deprecated
  public ClientMixedOperation<Ingress, IngressList, DoneableIngress, ClientResource<Ingress, DoneableIngress>> ingress() {
    return ingresses();
  }

  @Override
  public ClientMixedOperation<Ingress, IngressList, DoneableIngress, ClientResource<Ingress, DoneableIngress>> ingresses() {
    return new IngressOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public ClientMixedOperation<DaemonSet, DaemonSetList, DoneableDaemonSet, ClientResource<DaemonSet, DoneableDaemonSet>> daemonSets() {
    return new DaemonSetOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  public ClientMixedOperation<ThirdPartyResource, ThirdPartyResourceList, DoneableThirdPartyResource, ClientResource<ThirdPartyResource, DoneableThirdPartyResource>> thirdPartyResources() {
    return new ThirdPartyResourceOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  public ClientMixedOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet, ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet>> replicaSets() {
    return new ReplicaSetOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

}
