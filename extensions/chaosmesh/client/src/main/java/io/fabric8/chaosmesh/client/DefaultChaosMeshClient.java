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

import io.fabric8.chaosmesh.v1alpha1.AwsChaos;
import io.fabric8.chaosmesh.v1alpha1.AwsChaosList;
import io.fabric8.chaosmesh.v1alpha1.DNSChaos;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosList;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaos;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosList;
import io.fabric8.chaosmesh.v1alpha1.IoChaos;
import io.fabric8.chaosmesh.v1alpha1.IoChaosList;
import io.fabric8.chaosmesh.v1alpha1.JVMChaos;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosList;
import io.fabric8.chaosmesh.v1alpha1.KernelChaos;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosList;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodChaos;
import io.fabric8.chaosmesh.v1alpha1.PodChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodIoChaos;
import io.fabric8.chaosmesh.v1alpha1.PodIoChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.StressChaos;
import io.fabric8.chaosmesh.v1alpha1.StressChaosList;
import io.fabric8.chaosmesh.v1alpha1.TimeChaos;
import io.fabric8.chaosmesh.v1alpha1.TimeChaosList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientState;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class DefaultChaosMeshClient extends BaseClient implements NamespacedChaosMeshClient {

    public DefaultChaosMeshClient() {
        super();
    }

    public DefaultChaosMeshClient(Config configuration) {
        super(configuration);
    }

    public DefaultChaosMeshClient(ClientState clientState) {
        super(clientState);
    }

    @Override
    public NamespacedChaosMeshClient inAnyNamespace() {
        return inNamespace(null);
    }

    @Override
    public NamespacedChaosMeshClient inNamespace(String namespace) {
        Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();

        return new DefaultChaosMeshClient(newState(updated));
    }

    @Override
    public FunctionCallable<NamespacedChaosMeshClient> withRequestConfig(RequestConfig requestConfig) {
        return new WithRequestCallable<>(this, requestConfig);
    }


  @Override
  public MixedOperation<IoChaos, IoChaosList, Resource<IoChaos>> ioChaos() {
    return Handlers.getOperation(IoChaos.class, IoChaosList.class, this);
  }

  @Override
  public MixedOperation<KernelChaos, KernelChaosList,
    Resource<KernelChaos>> kernelChaos() {
    return Handlers.getOperation(KernelChaos.class, KernelChaosList.class, this);
  }

  @Override
  public MixedOperation<NetworkChaos, NetworkChaosList, Resource<NetworkChaos>> networkChaos() {
    return Handlers.getOperation(NetworkChaos.class, NetworkChaosList.class, this);
  }

  @Override
  public MixedOperation<PodChaos, PodChaosList, Resource<PodChaos>> podChaos() {
    return Handlers.getOperation(PodChaos.class, PodChaosList.class, this);
  }

  @Override
  public MixedOperation<PodIoChaos, PodIoChaosList, Resource<PodIoChaos>> podIoChaos() {
    return Handlers.getOperation(PodIoChaos.class, PodIoChaosList.class, this);
  }

  @Override
  public MixedOperation<PodNetworkChaos, PodNetworkChaosList, Resource<PodNetworkChaos>> podNetworkChaos() {
    return Handlers.getOperation(PodNetworkChaos.class, PodNetworkChaosList.class, this);
  }

  @Override
  public MixedOperation<StressChaos, StressChaosList,
    Resource<StressChaos>> stressChaos() {
    return Handlers.getOperation(StressChaos.class, StressChaosList.class, this);
  }

  @Override
  public MixedOperation<TimeChaos, TimeChaosList, Resource<TimeChaos>> timeChaos() {
    return Handlers.getOperation(TimeChaos.class, TimeChaosList.class, this);
  }

  @Override
  public MixedOperation<JVMChaos, JVMChaosList, Resource<JVMChaos>> jvmChaos() {
    return Handlers.getOperation(JVMChaos.class, JVMChaosList.class, this);
  }

  @Override
  public MixedOperation<HTTPChaos, HTTPChaosList, Resource<HTTPChaos>> httpChaos() {
    return Handlers.getOperation(HTTPChaos.class, HTTPChaosList.class, this);
  }

  @Override
  public MixedOperation<DNSChaos, DNSChaosList, Resource<DNSChaos>> dnsChaos() {
    return Handlers.getOperation(DNSChaos.class, DNSChaosList.class, this);
  }

  @Override
  public MixedOperation<AwsChaos, AwsChaosList, Resource<AwsChaos>> awsChaos() {
    return Handlers.getOperation(AwsChaos.class, AwsChaosList.class, this);
  }
}
