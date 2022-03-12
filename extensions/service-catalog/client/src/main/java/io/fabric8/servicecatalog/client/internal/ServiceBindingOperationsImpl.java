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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.extension.ExtensibleResourceAdapter;
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.client.dsl.ServiceBindingResource;

public class ServiceBindingOperationsImpl extends ExtensibleResourceAdapter<ServiceBinding> implements ServiceBindingResource {

  @Override
  public ExtensibleResourceAdapter<ServiceBinding> newInstance() {
    return new ServiceBindingOperationsImpl();
  }

  @Override
  public Secret getSecret() {
    ServiceBinding instance = get();
    return client.adapt(KubernetesClient.class).secrets().withName(instance.getSpec().getSecretName()).get();
  }
}
