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
package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
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

public interface MachineConfigurationAPIGroupDSL extends Client {
  /**
   * API entrypoint for ContainerRuntimeConfig (machineconfiguration.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for ContainerRuntimeConfig
   */
  NonNamespaceOperation<ContainerRuntimeConfig, ContainerRuntimeConfigList, Resource<ContainerRuntimeConfig>> containerRuntimeConfigs();

  /**
   * API entrypoint for ControllerConfig (machineconfiguration.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for ControllerConfig
   */
  NonNamespaceOperation<ControllerConfig, ControllerConfigList, Resource<ControllerConfig>> controllerConfigs();

  /**
   * API entrypoint for KubeletConfig (machineconfiguration.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for KubeletConfig
   */
  NonNamespaceOperation<KubeletConfig, KubeletConfigList, Resource<KubeletConfig>> kubeletConfigs();

  /**
   * API entrypoint for MachineConfigPool (machineconfiguration.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for MachineConfigPool
   */
  NonNamespaceOperation<MachineConfigPool, MachineConfigPoolList, Resource<MachineConfigPool>> machineConfigPools();

  /**
   * API entrypoint for MachineConfig (machineconfiguration.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for MachineConfig
   */
  NonNamespaceOperation<MachineConfig, MachineConfigList, Resource<MachineConfig>> machineConfigs();
}
