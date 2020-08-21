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
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.servicecatalog.api.model.ClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.ClusterServiceBrokerList;
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServiceClassList;
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.api.model.DoneableClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.DoneableClusterServiceClass;
import io.fabric8.servicecatalog.api.model.DoneableClusterServicePlan;
import io.fabric8.servicecatalog.api.model.DoneableServiceBinding;
import io.fabric8.servicecatalog.api.model.DoneableServiceBroker;
import io.fabric8.servicecatalog.api.model.DoneableServiceClass;
import io.fabric8.servicecatalog.api.model.DoneableServiceInstance;
import io.fabric8.servicecatalog.api.model.DoneableServicePlan;
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

/**
 * Main interface for Service Catalog Client.
 */
public interface ServiceCatalogClient extends Client {

  /**
   * API entrypoint for ClusterServiceBroker(servicecatalog.k8s.io/v1beta1)
   *
   * @return NonNamespaceOperation for ClusterServiceBroker class
   */
  NonNamespaceOperation<ClusterServiceBroker, ClusterServiceBrokerList, DoneableClusterServiceBroker, ClusterServiceBrokerResource> clusterServiceBrokers();

  /**
   * API entrypoint for ClusterServiceClass(servicecatalog.k8s.io/v1beta1)
   *
   * @return NonNamespaceOperation for ClusterServiceClass class
   */
  NonNamespaceOperation<ClusterServiceClass, ClusterServiceClassList, DoneableClusterServiceClass, ClusterServiceClassResource> clusterServiceClasses();

  /**
   * API entrypoint for ClusterServicePlan(servicecatalog.k8s.io/v1beta1)
   *
   * @return NonNamespaceOperation for ClusterServicePlan class
   */
  NonNamespaceOperation<ClusterServicePlan, ClusterServicePlanList, DoneableClusterServicePlan, ClusterServicePlanResource> clusterServicePlans();

  /**
   * API entrypoint for ServiceInstance(servicecatalog.k8s.io/v1beta1)
   *
   * @return MixedOperation for ServiceInstance class
   */
  MixedOperation<ServiceInstance, ServiceInstanceList, DoneableServiceInstance, ServiceInstanceResource> serviceInstances();

  /**
   * API entrypoint for ServiceBinding(servicecatalog.k8s.io/v1beta1)
   *
   * @return MixedOperation for ServiceBinding class
   */
  MixedOperation<ServiceBinding, ServiceBindingList, DoneableServiceBinding, ServiceBindingResource> serviceBindings();

  /**
   * API entrypoint for ServiceBroker(servicecatalog.k8s.io/v1beta1)
   *
   * @return MixedOperation for ServiceBroker class
   */
  MixedOperation<ServiceBroker, ServiceBrokerList, DoneableServiceBroker, Resource<ServiceBroker, DoneableServiceBroker>> serviceBrokers();

  /**
   * API entrypoint for ServiceClass(servicecatalog.k8s.io/v1beta1)
   *
   * @return MixedOperation for ServiceClass class
   */
  MixedOperation<ServiceClass, ServiceClassList, DoneableServiceClass, Resource<ServiceClass, DoneableServiceClass>> serviceClasses();

  /**
   * API entrypoint for ServicePlan(servicecatalog.k8s.io/v1beta1)
   *
   * @return MixedOperation for ServicePlan class
   */
  MixedOperation<ServicePlan, ServicePlanList, DoneableServicePlan, Resource<ServicePlan, DoneableServicePlan>> servicePlans();

}
