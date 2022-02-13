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
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
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
import io.fabric8.servicecatalog.client.internal.ClusterServiceBrokerResource;
import io.fabric8.servicecatalog.client.internal.ClusterServiceClassResource;
import io.fabric8.servicecatalog.client.internal.ClusterServicePlanResource;
import io.fabric8.servicecatalog.client.internal.ServiceBindingResource;
import io.fabric8.servicecatalog.client.internal.ServiceInstanceResource;

public class DefaultServiceCatalogClient extends ClientAdapter<DefaultServiceCatalogClient> implements NamespacedServiceCatalogClient {

  public DefaultServiceCatalogClient() {
    this(new KubernetesClientBuilder().build());
  }

  public DefaultServiceCatalogClient(Config configuration) {
    this(new KubernetesClientBuilder().withConfig(configuration).build());
  }

  public DefaultServiceCatalogClient(Client client) {
    super(client, DefaultServiceCatalogClient::new);
  }

  @Override
  public NonNamespaceOperation<ClusterServiceBroker, ClusterServiceBrokerList, ClusterServiceBrokerResource> clusterServiceBrokers() {
    return resources(ClusterServiceBroker.class, ClusterServiceBrokerList.class, ClusterServiceBrokerResource.class);
  }

  @Override
  public NonNamespaceOperation<ClusterServiceClass, ClusterServiceClassList, ClusterServiceClassResource> clusterServiceClasses() {
    return resources(ClusterServiceClass.class, ClusterServiceClassList.class, ClusterServiceClassResource.class);
  }

  @Override
  public NonNamespaceOperation<ClusterServicePlan, ClusterServicePlanList, ClusterServicePlanResource> clusterServicePlans() {
    return resources(ClusterServicePlan.class, ClusterServicePlanList.class, ClusterServicePlanResource.class);
  }

  @Override
  public MixedOperation<ServiceInstance, ServiceInstanceList, ServiceInstanceResource> serviceInstances() {
    return resources(ServiceInstance.class, ServiceInstanceList.class, ServiceInstanceResource.class);
  }

  @Override
  public MixedOperation<ServiceBinding, ServiceBindingList, ServiceBindingResource> serviceBindings() {
    return resources(ServiceBinding.class, ServiceBindingList.class, ServiceBindingResource.class);
  }

  @Override
  public MixedOperation<ServiceBroker, ServiceBrokerList, Resource<ServiceBroker>> serviceBrokers() {
    return resources(ServiceBroker.class, ServiceBrokerList.class);
  }

  @Override
  public MixedOperation<ServiceClass, ServiceClassList, Resource<ServiceClass>> serviceClasses() {
    return resources(ServiceClass.class, ServiceClassList.class);
  }

  @Override
  public MixedOperation<ServicePlan, ServicePlanList, Resource<ServicePlan>> servicePlans() {
    return resources(ServicePlan.class, ServicePlanList.class);
  }

  @Override
  public FunctionCallable<NamespacedServiceCatalogClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }
}
