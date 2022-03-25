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
import io.fabric8.servicecatalog.api.model.ClusterServiceBroker;
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServiceClassList;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import io.fabric8.servicecatalog.client.dsl.ClusterServiceBrokerResource;
import io.fabric8.servicecatalog.client.dsl.ClusterServiceClassResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClusterServiceBrokerOperationsImpl extends ExtensibleResourceAdapter<ClusterServiceBroker>
    implements ClusterServiceBrokerResource {

  @Override
  public ExtensibleResourceAdapter<ClusterServiceBroker> newInstance() {
    return new ClusterServiceBrokerOperationsImpl();
  }

  @Override
  public ClusterServicePlanList listPlans() {
    ClusterServiceBroker item = get();
    return client.adapt(ServiceCatalogClient.class).clusterServicePlans()
        .withField("spec.clusterServiceBrokerName", item.getMetadata().getName())
        .list();
  }

  @Override
  public ClusterServiceClassList listClasses() {
    ClusterServiceBroker item = get();
    return client.adapt(ServiceCatalogClient.class).clusterServiceClasses()
        .withField("spec.clusterServiceBrokerName", item.getMetadata().getName())
        .list();
  }

  @Override
  public ClusterServiceClassResource useServiceClass(String externalName) {
    ClusterServiceBroker item = get();
    Map<String, String> fields = new HashMap<>();
    fields.put("spec.clusterServiceBrokerName", item.getMetadata().getName());
    if (externalName != null) {
      fields.put("spec.externalName", externalName);
    }

    List<ClusterServiceClass> list = client.adapt(ServiceCatalogClient.class).clusterServiceClasses().withFields(fields).list()
        .getItems();

    if (list.size() != 1) {
      throw new IllegalArgumentException("No unique ClusterServiceClass with external name:" + externalName
          + "found for ClusterServiceBroker: " + item.getMetadata().getName());
    }
    ClusterServiceClass c = list.get(0);
    return client.adapt(ServiceCatalogClient.class).clusterServiceClasses().resource(c);
  }

}
