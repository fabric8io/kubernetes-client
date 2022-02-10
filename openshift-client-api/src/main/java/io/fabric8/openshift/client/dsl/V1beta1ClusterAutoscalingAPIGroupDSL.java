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
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscalerList;

public interface V1beta1ClusterAutoscalingAPIGroupDSL extends Client {
  /**
   * DSL entrypoint for MachineAutoscaler (autoscaling.openshift.io/v1beta1)
   *
   * @return {@link MixedOperation} for MachineAutoscaler
   */
  MixedOperation<MachineAutoscaler, MachineAutoscalerList, Resource<MachineAutoscaler>> machineAutoscalers();
}
