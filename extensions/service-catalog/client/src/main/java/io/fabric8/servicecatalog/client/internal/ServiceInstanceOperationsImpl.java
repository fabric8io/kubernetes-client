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

import io.fabric8.kubernetes.client.extension.ExtensibleResourceAdapter;
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.api.model.ServiceBindingBuilder;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import io.fabric8.servicecatalog.client.dsl.ServiceInstanceResource;

public class ServiceInstanceOperationsImpl extends ExtensibleResourceAdapter<ServiceInstance>
    implements ServiceInstanceResource {

  @Override
  public ExtensibleResourceAdapter<ServiceInstance> newInstance() {
    return new ServiceInstanceOperationsImpl();
  }

  @Override
  public ServiceBinding bind(String secretName) {
    ServiceInstance item = get();
    return client.adapt(ServiceCatalogClient.class)
        .serviceBindings().create(new ServiceBindingBuilder()
            .withNewMetadata()
            .withName(item.getMetadata().getName())
            .withNamespace(item.getMetadata().getNamespace())
            .endMetadata()
            .withNewSpec()
            .withSecretName(secretName)
            .withNewInstanceRef(item.getMetadata().getName())
            .endSpec()
            .build());
  }

}
