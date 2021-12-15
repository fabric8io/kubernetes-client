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

import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServiceClassList;
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClusterServiceClassOperationsImpl extends HasMetadataOperation<ClusterServiceClass, ClusterServiceClassList, ClusterServiceClassResource> implements ClusterServiceClassResource {


  public ClusterServiceClassOperationsImpl(ClientContext clientContext) {
      this(HasMetadataOperationsImpl.defaultContext(clientContext));
  }

    public ClusterServiceClassOperationsImpl(OperationContext ctx) {
        super(ctx.withApiGroupName("servicecatalog.k8s.io").withApiGroupVersion("v1beta1").withPlural("clusterserviceclasses"),
                ClusterServiceClass.class, ClusterServiceClassList.class);
    }

    @Override
    public BaseOperation<ClusterServiceClass, ClusterServiceClassList, ClusterServiceClassResource> newInstance(OperationContext context) {
        return new ClusterServiceClassOperationsImpl(context);
    }

    @Override
  public boolean isResourceNamespaced() {
    return false;
  }

    @Override
    public ClusterServicePlanList listPlans() {
        ClusterServiceClass item = get();
        return new ClusterServicePlanOperationsImpl(context).withField("spec.clusterServiceClassRef.name", item != null ? item.getMetadata().getName() : null)
                .list();
    }

    @Override
    public ClusterServicePlanResource usePlan(String externalName) {
        ClusterServiceClass item = get();
        Map<String, String> fields = new HashMap<>();
        fields.put("spec.clusterServiceClassRef.name", item.getMetadata().getName());
        fields.put("spec.externalName", externalName);

        List<ClusterServicePlan> list = new ClusterServicePlanOperationsImpl(context.withFields(fields)).list().getItems();

        if (list.size() != 1) {
            throw new IllegalArgumentException("No unique ClusterServicePlan with external name: " + externalName + " found for ClusterServiceBroker: " + item.getSpec().getClusterServiceBrokerName()+" and ClusterServiceClass: " + item.getSpec().getExternalName()+".");
        }
        return new ClusterServicePlanOperationsImpl(context);
    }

    @Override
    public ServiceInstance instantiate(String instanceName, String plan) {
      ClusterServiceClass item = get();
      return new ServiceInstanceOperationsImpl(context)
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
