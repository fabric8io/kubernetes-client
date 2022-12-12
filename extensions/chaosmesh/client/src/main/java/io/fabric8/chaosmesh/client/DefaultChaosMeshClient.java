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
package io.fabric8.chaosmesh.client;

import io.fabric8.chaosmesh.v1alpha1.AWSChaos;
import io.fabric8.chaosmesh.v1alpha1.AWSChaosList;
import io.fabric8.chaosmesh.v1alpha1.DNSChaos;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosList;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaos;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosList;
import io.fabric8.chaosmesh.v1alpha1.IOChaos;
import io.fabric8.chaosmesh.v1alpha1.IOChaosList;
import io.fabric8.chaosmesh.v1alpha1.JVMChaos;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosList;
import io.fabric8.chaosmesh.v1alpha1.KernelChaos;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosList;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodChaos;
import io.fabric8.chaosmesh.v1alpha1.PodChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaos;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.StressChaos;
import io.fabric8.chaosmesh.v1alpha1.StressChaosList;
import io.fabric8.chaosmesh.v1alpha1.TimeChaos;
import io.fabric8.chaosmesh.v1alpha1.TimeChaosList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ExtensionRootClientAdapter;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;

public class DefaultChaosMeshClient extends ExtensionRootClientAdapter<DefaultChaosMeshClient>
    implements NamespacedChaosMeshClient, SupportTestingClient {

  public DefaultChaosMeshClient() {
    super();
  }

  public DefaultChaosMeshClient(Config config) {
    super(config);
  }

  public DefaultChaosMeshClient(Client client) {
    super(client);
  }

  @Override
  protected DefaultChaosMeshClient newInstance(Client client) {
    return new DefaultChaosMeshClient(client);
  }

  @Override
  public FunctionCallable<NamespacedChaosMeshClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public MixedOperation<IOChaos, IOChaosList, Resource<IOChaos>> ioChaos() {
    return resources(IOChaos.class, IOChaosList.class);
  }

  @Override
  public MixedOperation<KernelChaos, KernelChaosList, Resource<KernelChaos>> kernelChaos() {
    return resources(KernelChaos.class, KernelChaosList.class);
  }

  @Override
  public MixedOperation<NetworkChaos, NetworkChaosList, Resource<NetworkChaos>> networkChaos() {
    return resources(NetworkChaos.class, NetworkChaosList.class);
  }

  @Override
  public MixedOperation<PodChaos, PodChaosList, Resource<PodChaos>> podChaos() {
    return resources(PodChaos.class, PodChaosList.class);
  }

  @Override
  public MixedOperation<PodIOChaos, PodIOChaosList, Resource<PodIOChaos>> podIOChaos() {
    return resources(PodIOChaos.class, PodIOChaosList.class);
  }

  @Override
  public MixedOperation<PodNetworkChaos, PodNetworkChaosList, Resource<PodNetworkChaos>> podNetworkChaos() {
    return resources(PodNetworkChaos.class, PodNetworkChaosList.class);
  }

  @Override
  public MixedOperation<StressChaos, StressChaosList, Resource<StressChaos>> stressChaos() {
    return resources(StressChaos.class, StressChaosList.class);
  }

  @Override
  public MixedOperation<TimeChaos, TimeChaosList, Resource<TimeChaos>> timeChaos() {
    return resources(TimeChaos.class, TimeChaosList.class);
  }

  @Override
  public MixedOperation<JVMChaos, JVMChaosList, Resource<JVMChaos>> jvmChaos() {
    return resources(JVMChaos.class, JVMChaosList.class);
  }

  @Override
  public MixedOperation<HTTPChaos, HTTPChaosList, Resource<HTTPChaos>> httpChaos() {
    return resources(HTTPChaos.class, HTTPChaosList.class);
  }

  @Override
  public MixedOperation<DNSChaos, DNSChaosList, Resource<DNSChaos>> dnsChaos() {
    return resources(DNSChaos.class, DNSChaosList.class);
  }

  @Override
  public MixedOperation<AWSChaos, AWSChaosList, Resource<AWSChaos>> awsChaos() {
    return resources(AWSChaos.class, AWSChaosList.class);
  }

  @Override
  public boolean isSupported() {
    return hasApiGroup("chaos-mesh.org", false);
  }
}
