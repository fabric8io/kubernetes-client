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

import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.servicecatalog.client.internal.*;
import io.fabric8.servicecatalog.api.model.*;
import okhttp3.OkHttpClient;

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

  @Override
public NonNamespaceOperation<ClusterServiceBroker, ClusterServiceBrokerList, ClusterServiceBrokerResource> clusterServiceBrokers() {
    return new ClusterServiceBrokerOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
public NonNamespaceOperation<ClusterServiceClass, ClusterServiceClassList, ClusterServiceClassResource> clusterServiceClasses() {
    return new ClusterServiceClassOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
public NonNamespaceOperation<ClusterServicePlan, ClusterServicePlanList, ClusterServicePlanResource> clusterServicePlans() {
    return new ClusterServicePlanOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
public MixedOperation<ServiceInstance, ServiceInstanceList, ServiceInstanceResource> serviceInstances() {
    return new ServiceInstanceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
public MixedOperation<ServiceBinding, ServiceBindingList, ServiceBindingResource> serviceBindings() {
    return new ServiceBindingOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<ServiceBroker, ServiceBrokerList, Resource<ServiceBroker>> serviceBrokers() {
    return Handlers.getOperation(ServiceBroker.class, ServiceBrokerList.class, httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<ServiceClass, ServiceClassList, Resource<ServiceClass>> serviceClasses() {
    return Handlers.getOperation(ServiceClass.class, ServiceClassList.class, httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<ServicePlan, ServicePlanList, Resource<ServicePlan>> servicePlans() {
    return Handlers.getOperation(ServicePlan.class, ServicePlanList.class, httpClient, getConfiguration());
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
    return new WithRequestCallable<>(this, requestConfig);
  }
}
