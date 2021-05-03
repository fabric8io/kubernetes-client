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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusBuilder;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

public class ComponentStatusOperationsImpl extends HasMetadataOperation<ComponentStatus, ComponentStatusList,
  Resource<ComponentStatus>> {

  public ComponentStatusOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null);
  }

  public ComponentStatusOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public ComponentStatusOperationsImpl(OperationContext context) {
    super(context.withPlural("componentstatuses"));
    this.type = ComponentStatus.class;
    this.listType = ComponentStatusList.class;
  }

  @Override
  public ComponentStatusOperationsImpl newInstance(OperationContext context) {
    return new ComponentStatusOperationsImpl(context);
  }

  @Override
  protected VisitableBuilder<ComponentStatus, ?> createVisitableBuilder(ComponentStatus item) {
    return new ComponentStatusBuilder(item);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
