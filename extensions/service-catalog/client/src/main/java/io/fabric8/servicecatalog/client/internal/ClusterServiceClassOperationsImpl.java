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
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceBuilder;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import io.fabric8.servicecatalog.client.dsl.ClusterServiceClassResource;
import io.fabric8.servicecatalog.client.dsl.ClusterServicePlanResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClusterServiceClassOperationsImpl extends ExtensibleResourceAdapter<ClusterServiceClass>
    implements ClusterServiceClassResource {

  @Override
  public ExtensibleResourceAdapter<ClusterServiceClass> newInstance() {
    return new ClusterServiceClassOperationsImpl();
  }

  @Override
  public ClusterServicePlanList listPlans() {
    ClusterServiceClass item = get();
    return client.adapt(ServiceCatalogClient.class)
        .clusterServicePlans()
        .withField("spec.clusterServiceClassRef.name", item != null ? item.getMetadata().getName() : null)
        .list();
  }

  @Override
  public ClusterServicePlanResource usePlan(String externalName) {
    ClusterServiceClass item = get();
    Map<String, String> fields = new HashMap<>();
    fields.put("spec.clusterServiceClassRef.name", item.getMetadata().getName());
    fields.put("spec.externalName", externalName);

    List<ClusterServicePlan> list = client.adapt(ServiceCatalogClient.class)
        .clusterServicePlans()
        .withFields(fields)
        .list()
        .getItems();

    if (list.size() != 1) {
      throw new IllegalArgumentException("No unique ClusterServicePlan with external name: " + externalName
          + " found for ClusterServiceBroker: " + item.getSpec().getClusterServiceBrokerName()
          + " and ClusterServiceClass: " + item.getSpec().getExternalName() + ".");
    }
    ClusterServicePlan plan = list.get(0);
    return client.adapt(ServiceCatalogClient.class).clusterServicePlans().resource(plan);
  }

  @Override
  public ServiceInstance instantiate(String instanceName, String plan) {
    ClusterServiceClass item = get();
    return client.adapt(ServiceCatalogClient.class)
        .serviceInstances()
        .create(new ServiceInstanceBuilder()
            .withNewMetadata()
            .withName(instanceName)
            .endMetadata()
            .withNewSpec()
            .withClusterServiceClassExternalName(item.getMetadata().getName())
            .withClusterServicePlanExternalName(plan)
            .endSpec()
            .build());
  }

}
