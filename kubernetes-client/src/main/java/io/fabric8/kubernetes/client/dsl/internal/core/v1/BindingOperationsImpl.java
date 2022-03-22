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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;

public class BindingOperationsImpl extends HasMetadataOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> {
  public BindingOperationsImpl(Client client) {
    this(client, null);
  }

  public BindingOperationsImpl(Client client, String namespace) {
    this(HasMetadataOperationsImpl.defaultContext(client).withNamespace(namespace));
  }

  public BindingOperationsImpl(OperationContext context) {
    super(context
        .withApiGroupVersion("v1")
        .withPlural("bindings"), Binding.class,
        (Class<KubernetesResourceList<Binding>>) TypeFactory.rawClass(new TypeReference<KubernetesResourceList<Binding>>() {
        }.getType()));
  }

  @Override
  public BindingOperationsImpl newInstance(OperationContext context) {
    return new BindingOperationsImpl(context);
  }
}
