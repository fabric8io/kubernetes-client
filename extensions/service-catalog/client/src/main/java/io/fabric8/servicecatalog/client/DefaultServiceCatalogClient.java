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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.servicecatalog.api.model.ClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.ClusterServiceBrokerList;
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServiceClassList;
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.api.model.ServiceBindingList;
import io.fabric8.servicecatalog.api.model.ServiceBroker;
import io.fabric8.servicecatalog.api.model.ServiceBrokerList;
import io.fabric8.servicecatalog.api.model.ServiceClass;
import io.fabric8.servicecatalog.api.model.ServiceClassList;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceList;
import io.fabric8.servicecatalog.api.model.ServicePlan;
import io.fabric8.servicecatalog.api.model.ServicePlanList;
import io.fabric8.servicecatalog.client.internal.ClusterServiceBrokerOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ClusterServiceBrokerResource;
import io.fabric8.servicecatalog.client.internal.ClusterServiceClassOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ClusterServiceClassResource;
import io.fabric8.servicecatalog.client.internal.ClusterServicePlanOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ClusterServicePlanResource;
import io.fabric8.servicecatalog.client.internal.ServiceBindingOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ServiceBindingResource;
import io.fabric8.servicecatalog.client.internal.ServiceInstanceOperationsImpl;
import io.fabric8.servicecatalog.client.internal.ServiceInstanceResource;

public class DefaultServiceCatalogClient extends BaseClient implements NamespacedServiceCatalogClient {

  public DefaultServiceCatalogClient() {
    super();
  }

  public DefaultServiceCatalogClient(Config configuration) {
    super(configuration);
  }

  public DefaultServiceCatalogClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
public NonNamespaceOperation<ClusterServiceBroker, ClusterServiceBrokerList, ClusterServiceBrokerResource> clusterServiceBrokers() {
    return new ClusterServiceBrokerOperationsImpl(this);
  }

  @Override
public NonNamespaceOperation<ClusterServiceClass, ClusterServiceClassList, ClusterServiceClassResource> clusterServiceClasses() {
    return new ClusterServiceClassOperationsImpl(this);
  }

  @Override
public NonNamespaceOperation<ClusterServicePlan, ClusterServicePlanList, ClusterServicePlanResource> clusterServicePlans() {
    return new ClusterServicePlanOperationsImpl(this);
  }

  @Override
public MixedOperation<ServiceInstance, ServiceInstanceList, ServiceInstanceResource> serviceInstances() {
    return new ServiceInstanceOperationsImpl(this);
  }

  @Override
public MixedOperation<ServiceBinding, ServiceBindingList, ServiceBindingResource> serviceBindings() {
    return new ServiceBindingOperationsImpl(this);
  }

  @Override
  public MixedOperation<ServiceBroker, ServiceBrokerList, Resource<ServiceBroker>> serviceBrokers() {
    return Handlers.getOperation(ServiceBroker.class, ServiceBrokerList.class, this);
  }

  @Override
  public MixedOperation<ServiceClass, ServiceClassList, Resource<ServiceClass>> serviceClasses() {
    return Handlers.getOperation(ServiceClass.class, ServiceClassList.class, this);
  }

  @Override
  public MixedOperation<ServicePlan, ServicePlanList, Resource<ServicePlan>> servicePlans() {
    return Handlers.getOperation(ServicePlan.class, ServicePlanList.class, this);
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

    return new DefaultServiceCatalogClient(newState(updated));
  }

  @Override
  public FunctionCallable<NamespacedServiceCatalogClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }
}
