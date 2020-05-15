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
import io.fabric8.servicecatalog.api.model.DoneableClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.DoneableClusterServiceClass;
import io.fabric8.servicecatalog.api.model.DoneableClusterServicePlan;
import io.fabric8.servicecatalog.api.model.DoneableServiceBinding;
import io.fabric8.servicecatalog.api.model.DoneableServiceBroker;
import io.fabric8.servicecatalog.api.model.DoneableServiceClass;
import io.fabric8.servicecatalog.api.model.DoneableServiceInstance;
import io.fabric8.servicecatalog.api.model.DoneableServicePlan;
import io.fabric8.servicecatalog.client.internal.*;
import io.fabric8.servicecatalog.api.model.*;

public interface ServiceCatalogClient extends Client {

    NonNamespaceOperation<ClusterServiceBroker, ClusterServiceBrokerList, DoneableClusterServiceBroker, ClusterServiceBrokerResource> clusterServiceBrokers();

    NonNamespaceOperation<ClusterServiceClass, ClusterServiceClassList, DoneableClusterServiceClass, ClusterServiceClassResource> clusterServiceClasses();

    NonNamespaceOperation<ClusterServicePlan, ClusterServicePlanList, DoneableClusterServicePlan, ClusterServicePlanResource> clusterServicePlans();

    MixedOperation<ServiceInstance, ServiceInstanceList, DoneableServiceInstance, ServiceInstanceResource> serviceInstances();

    MixedOperation<ServiceBinding, ServiceBindingList, DoneableServiceBinding, ServiceBindingResource> serviceBindings();

    MixedOperation<ServiceBroker, ServiceBrokerList, DoneableServiceBroker, Resource<ServiceBroker, DoneableServiceBroker>> serviceBrokers();

    MixedOperation<ServiceClass, ServiceClassList, DoneableServiceClass, Resource<ServiceClass, DoneableServiceClass>> serviceClasses();

    MixedOperation<ServicePlan, ServicePlanList, DoneableServicePlan, Resource<ServicePlan, DoneableServicePlan>> servicePlans();

}
