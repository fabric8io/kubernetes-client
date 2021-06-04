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
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.machine.v1beta1.Machine;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheck;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheckList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSet;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSetList;

public interface OpenShiftMachineAPIGroupDSL extends Client {
  /**
   * DSL entrypoint for Machine (machine.openshift.io/v1beta1)
   *
   * @return {@link MixedOperation} for Machine
   */
  MixedOperation<Machine, MachineList, Resource<Machine>> machines();

  /**
   * DSL entrypoint for MachineSet (machine.openshift.io/v1beta1)
   *
   * @return {@link MixedOperation} for MachineSet
   */
  MixedOperation<MachineSet, MachineSetList, Resource<MachineSet>> machineSets();

  /**
   * DSL entrypoint for MachineHealthCheck
   *
   * @return {@link MixedOperation} for MachineHealthCheck
   */
  MixedOperation<MachineHealthCheck, MachineHealthCheckList, Resource<MachineHealthCheck>> machineHealthChecks();
}
