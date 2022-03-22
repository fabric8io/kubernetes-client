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
package io.fabric8.servicecatalog.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.servicecatalog.api.model.ClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.client.internal.ClusterServiceBrokerOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ClusterServiceClassOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ClusterServicePlanOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ServiceBindingOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ServiceInstanceOperationsImpl;

public class ServiceCatalogExtensionAdapter implements ExtensionAdapter<ServiceCatalogClient> {

  @Override
  public Class<ServiceCatalogClient> getExtensionType() {
    return ServiceCatalogClient.class;
  }

  @Override
  public ServiceCatalogClient adapt(Client client) {
    return new DefaultServiceCatalogClient(client);
  }

  @Override
  public void registerResources(ResourceFactory factory) {
    factory.register(ClusterServiceBroker.class, new ClusterServiceBrokerOperationsImpl());
    factory.register(ClusterServiceClass.class, new ClusterServiceClassOperationsImpl());
    factory.register(ClusterServicePlan.class, new ClusterServicePlanOperationsImpl());
    factory.register(ServiceBinding.class, new ServiceBindingOperationsImpl());
    factory.register(ServiceInstance.class, new ServiceInstanceOperationsImpl());
  }
}
