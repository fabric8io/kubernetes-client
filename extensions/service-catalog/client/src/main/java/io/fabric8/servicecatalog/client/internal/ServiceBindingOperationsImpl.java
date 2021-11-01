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
package io.fabric8.servicecatalog.client.internal;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.api.model.ServiceBindingList;


public class ServiceBindingOperationsImpl extends HasMetadataOperation<ServiceBinding, ServiceBindingList, ServiceBindingResource> implements ServiceBindingResource {

  public ServiceBindingOperationsImpl(HttpClient client, Config config) {
      this(new OperationContext().withHttpClient(client).withConfig(config));
  }

    public ServiceBindingOperationsImpl(OperationContext ctx) {
        super(ctx.withApiGroupName("servicecatalog.k8s.io").withApiGroupVersion("v1beta1").withPlural("servicebindings"),
                ServiceBinding.class, ServiceBindingList.class);
    }

    @Override
    public BaseOperation<ServiceBinding, ServiceBindingList, ServiceBindingResource> newInstance(OperationContext context) {
        return new ServiceBindingOperationsImpl(context);
    }

  @Override
  public boolean isResourceNamespaced() {
    return true;
  }

  @Override
  public Secret getSecret() {
      ServiceBinding instance = get();
      return Handlers.getOperation(Secret.class, SecretList.class, client, getConfig())
              .newInstance(context.withItem(null).withName(instance.getSpec().getSecretName())).get();
  }
}
