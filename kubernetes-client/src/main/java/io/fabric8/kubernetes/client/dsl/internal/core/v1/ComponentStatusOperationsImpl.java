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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;

public class ComponentStatusOperationsImpl extends HasMetadataOperation<ComponentStatus, ComponentStatusList,
  Resource<ComponentStatus>> {

  public ComponentStatusOperationsImpl(ClientContext clientContext) {
    this(clientContext, null);
  }

  public ComponentStatusOperationsImpl(ClientContext clientContext, String namespace) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext).withNamespace(namespace));
  }

  public ComponentStatusOperationsImpl(OperationContext context) {
    super(context.withPlural("componentstatuses"), ComponentStatus.class, ComponentStatusList.class);
  }

  @Override
  public ComponentStatusOperationsImpl newInstance(OperationContext context) {
    return new ComponentStatusOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
