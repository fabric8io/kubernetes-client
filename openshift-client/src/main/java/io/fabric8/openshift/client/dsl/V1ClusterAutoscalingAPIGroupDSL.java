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
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerList;

public interface V1ClusterAutoscalingAPIGroupDSL extends Client {
  /**
   * DSL entrypoint for ClusterAutoscaler (autoscaling.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for ClusterAutoscaler
   */
  NonNamespaceOperation<ClusterAutoscaler, ClusterAutoscalerList, Resource<ClusterAutoscaler>> clusterAutoscalers();
}
