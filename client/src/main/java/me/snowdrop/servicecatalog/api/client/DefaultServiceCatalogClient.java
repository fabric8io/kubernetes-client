/*
 * Copyright (C) 2018 Red Hat inc.
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
package me.snowdrop.servicecatalog.api.client;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServiceBrokerOperationsImpl;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServiceBrokerResource;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServiceClassResource;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServicePlanResource;
import me.snowdrop.servicecatalog.api.client.internal.ServiceBindingResource;
import me.snowdrop.servicecatalog.api.client.internal.ServiceInstanceResource;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServiceBroker;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServicePlan;
import me.snowdrop.servicecatalog.api.model.DoneableServiceBinding;
import me.snowdrop.servicecatalog.api.model.DoneableServiceInstance;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServiceClassOperationsImpl;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServicePlanOperationsImpl;
import me.snowdrop.servicecatalog.api.client.internal.ServiceBindingOperationsImpl;
import me.snowdrop.servicecatalog.api.client.internal.ServiceInstanceOperationsImpl;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBroker;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBrokerList;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClassList;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlan;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlanList;
import me.snowdrop.servicecatalog.api.model.ServiceBinding;
import me.snowdrop.servicecatalog.api.model.ServiceBindingList;
import me.snowdrop.servicecatalog.api.model.ServiceInstance;
import me.snowdrop.servicecatalog.api.model.ServiceInstanceList;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;

public class DefaultServiceCatalogClient extends BaseClient implements NamespacedServiceCatalogClient {

    public DefaultServiceCatalogClient() {
        super();
    }

    public DefaultServiceCatalogClient(Config configuration) {
        super(configuration);
    }

    public DefaultServiceCatalogClient(OkHttpClient httpClient, Config configuration) {
        super(httpClient, configuration);
    }

   public NonNamespaceOperation<ClusterServiceBroker, ClusterServiceBrokerList, DoneableClusterServiceBroker, ClusterServiceBrokerResource> clusterServiceBrokers(){
        return new ClusterServiceBrokerOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }
    public NonNamespaceOperation<ClusterServiceClass, ClusterServiceClassList, DoneableClusterServiceClass, ClusterServiceClassResource> clusterServiceClasses() {
        return new ClusterServiceClassOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }
    public NonNamespaceOperation<ClusterServicePlan, ClusterServicePlanList, DoneableClusterServicePlan, ClusterServicePlanResource> clusterServicePlans() {
        return new ClusterServicePlanOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }
    public MixedOperation<ServiceInstance, ServiceInstanceList, DoneableServiceInstance, ServiceInstanceResource> serviceInstances() {
        return new ServiceInstanceOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }
    public MixedOperation<ServiceBinding, ServiceBindingList, DoneableServiceBinding, ServiceBindingResource> serviceBindings() {
        return new ServiceBindingOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public NamespacedServiceCatalogClient inAnyNamespace() {
        return inNamespace(null);
    }

    @Override
    public NamespacedServiceCatalogClient inNamespace(String namespace) {
        Config updated = new ConfigBuilder(getConfiguration())
                .withNamespace(namespace)
                .build();

        return new DefaultServiceCatalogClient(getHttpClient(), updated);
    }
  @Override
  public FunctionCallable<NamespacedServiceCatalogClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<NamespacedServiceCatalogClient>(this, requestConfig);
  }
}
