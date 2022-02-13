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
import io.fabric8.kubernetes.client.ExtensionAdapter;
import io.fabric8.kubernetes.client.ExtensionAdapterSupport;
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

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceCatalogExtensionAdapter extends ExtensionAdapterSupport
        implements ExtensionAdapter<ServiceCatalogClient> {

    static final ConcurrentMap<URL, Boolean> IS_SERVICE_CATALOG = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_SERVICE_CATALOG_APIGROUPS = new ConcurrentHashMap<>();

    @Override
    public Class<ServiceCatalogClient> getExtensionType() {
        return ServiceCatalogClient.class;
    }

    @Override
    public Boolean isAdaptable(Client client) {
        return isAdaptable(client, IS_SERVICE_CATALOG, USES_SERVICE_CATALOG_APIGROUPS, "servicecatalog.k8s.io");
    }

    @Override
    public ServiceCatalogClient adapt(Client client) {
        return new DefaultServiceCatalogClient(client);
    }

    @Override
    public void registerHandlers(HandlerFactory factory) {
        factory.register(ClusterServiceBroker.class, ClusterServiceBrokerOperationsImpl::new);
        factory.register(ClusterServiceClass.class, ClusterServiceClassOperationsImpl::new);
        factory.register(ClusterServicePlan.class, ClusterServicePlanOperationsImpl::new);
        factory.register(ServiceBinding.class, ServiceBindingOperationsImpl::new);
        factory.register(ServiceInstance.class, ServiceInstanceOperationsImpl::new);
    }
}
