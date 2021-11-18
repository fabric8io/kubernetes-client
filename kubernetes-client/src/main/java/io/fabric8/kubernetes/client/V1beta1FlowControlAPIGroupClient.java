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

import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchemaList;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfiguration;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfigurationList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1beta1FlowControlAPIGroupDSL;

public class V1beta1FlowControlAPIGroupClient extends BaseClient implements V1beta1FlowControlAPIGroupDSL {
  public V1beta1FlowControlAPIGroupClient() {
    super();
  }

  public V1beta1FlowControlAPIGroupClient(ClientState clientState) {
    super(clientState);
  }

  @Override
  public NonNamespaceOperation<FlowSchema, FlowSchemaList, Resource<FlowSchema>> flowSchema() {
    return Handlers.getOperation(FlowSchema.class, FlowSchemaList.class, this);
  }

  @Override
  public NonNamespaceOperation<PriorityLevelConfiguration, PriorityLevelConfigurationList, Resource<PriorityLevelConfiguration>> priorityLevelConfigurations() {
    return Handlers.getOperation(PriorityLevelConfiguration.class, PriorityLevelConfigurationList.class, this);
  }
}
