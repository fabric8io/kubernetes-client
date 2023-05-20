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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.flowcontrol.v1beta3.FlowSchema;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta3.FlowSchemaList;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta3.PriorityLevelConfiguration;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta3.PriorityLevelConfigurationList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1beta3FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1beta3FlowControlAPIGroupClient extends ClientAdapter<V1beta3FlowControlAPIGroupClient>
    implements V1beta3FlowControlAPIGroupDSL {

  @Override
  public NonNamespaceOperation<FlowSchema, FlowSchemaList, Resource<FlowSchema>> flowSchema() {
    return resources(FlowSchema.class, FlowSchemaList.class);
  }

  @Override
  public NonNamespaceOperation<PriorityLevelConfiguration, PriorityLevelConfigurationList, Resource<PriorityLevelConfiguration>> priorityLevelConfigurations() {
    return resources(PriorityLevelConfiguration.class, PriorityLevelConfigurationList.class);
  }

  @Override
  public V1beta3FlowControlAPIGroupClient newInstance() {
    return new V1beta3FlowControlAPIGroupClient();
  }
}
