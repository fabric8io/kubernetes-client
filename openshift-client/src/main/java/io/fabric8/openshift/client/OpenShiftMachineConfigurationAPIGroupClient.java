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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPool;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPoolList;
import io.fabric8.openshift.client.dsl.MachineConfigurationAPIGroupDSL;

public class OpenShiftMachineConfigurationAPIGroupClient extends BaseClient implements MachineConfigurationAPIGroupDSL {

  public OpenShiftMachineConfigurationAPIGroupClient() {
    super();
  }

  public OpenShiftMachineConfigurationAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<ContainerRuntimeConfig, ContainerRuntimeConfigList, Resource<ContainerRuntimeConfig>> containerRuntimeConfigs() {
    return OpenShiftHandlers.getOperation(ContainerRuntimeConfig.class, ContainerRuntimeConfigList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ControllerConfig, ControllerConfigList, Resource<ControllerConfig>> controllerConfigs() {
    return OpenShiftHandlers.getOperation(ControllerConfig.class, ControllerConfigList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeletConfig, KubeletConfigList, Resource<KubeletConfig>> kubeletConfigs() {
    return OpenShiftHandlers.getOperation(KubeletConfig.class, KubeletConfigList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<MachineConfigPool, MachineConfigPoolList, Resource<MachineConfigPool>> machineConfigPools() {
    return OpenShiftHandlers.getOperation(MachineConfigPool.class, MachineConfigPoolList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<MachineConfig, MachineConfigList, Resource<MachineConfig>> machineConfigs() {
    return OpenShiftHandlers.getOperation(MachineConfig.class, MachineConfigList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
