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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.servicecatalog.api.model.*;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClusterServiceBrokerOperationsImpl extends HasMetadataOperation<ClusterServiceBroker, ClusterServiceBrokerList, ClusterServiceBrokerResource> implements ClusterServiceBrokerResource {

  public ClusterServiceBrokerOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ClusterServiceBrokerOperationsImpl(OperationContext context) {
      super(context.withApiGroupName("servicecatalog.k8s.io").withApiGroupVersion("v1beta1").withPlural("clusterservicebrokers"),
              ClusterServiceBroker.class, ClusterServiceBrokerList.class);
  }

    @Override
    public BaseOperation<ClusterServiceBroker, ClusterServiceBrokerList, ClusterServiceBrokerResource> newInstance(OperationContext context) {
        return new ClusterServiceBrokerOperationsImpl(context);
    }

    @Override
  public boolean isResourceNamespaced() {
    return false;
  }

    @Override
    public ClusterServicePlanList listPlans() {
        ClusterServiceBroker item = get();
        return new ClusterServicePlanOperationsImpl(context)
                .withField("spec.clusterServiceBrokerName", item.getMetadata().getName())
                .list();
    }

    @Override
    public ClusterServiceClassList listClasses() {
        ClusterServiceBroker item = get();
        return new ClusterServiceClassOperationsImpl(context)
                .withField("spec.clusterServiceBrokerName", item.getMetadata().getName())
                .list();
    }


    @Override
    public ClusterServiceClassResource useServiceClass(String externalName) {
        ClusterServiceBroker item = get();
        Map<String, String> fields = new HashMap<>();
        fields.put("spec.clusterServiceBrokerName", item.getMetadata().getName());
        fields.put("spec.externalName", externalName);

        List<ClusterServiceClass> list = new ClusterServiceClassOperationsImpl(context.withFields(fields)).list().getItems();

        if (list.size() != 1) {
            throw new IllegalArgumentException("No unique ClusterServiceClass with external name:" + externalName + "found for ClusterServiceBroker: " + item.getMetadata().getName());
        }
        ClusterServiceClass c = list.get(0);
        return new ClusterServiceClassOperationsImpl(context);
    }

}
