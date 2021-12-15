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
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceBuilder;


public class ClusterServicePlanOperationsImpl extends HasMetadataOperation<ClusterServicePlan, ClusterServicePlanList, ClusterServicePlanResource>
    implements ClusterServicePlanResource {

    public ClusterServicePlanOperationsImpl(ClientContext clientContext) {
      this(HasMetadataOperationsImpl.defaultContext(clientContext));
    }

    public ClusterServicePlanOperationsImpl(OperationContext ctx) {
        super(ctx.withApiGroupName("servicecatalog.k8s.io").withApiGroupVersion("v1beta1").withPlural("clusterserviceplans"),
                ClusterServicePlan.class, ClusterServicePlanList.class);
    }

    @Override
    public BaseOperation<ClusterServicePlan, ClusterServicePlanList, ClusterServicePlanResource> newInstance(OperationContext context) {
        return new ClusterServicePlanOperationsImpl(context);
    }

    @Override
    public boolean isResourceNamespaced() {
        return false;
    }


    @Override
    public ServiceInstance instantiate(String... args) {
        String instanceName;
        String instanceNamespace;

        if (args.length == 1) {
            instanceName = args[0];
            instanceNamespace = config.getNamespace();
        } else if (args.length == 2) {
            instanceNamespace = args[0];
            instanceName = args[1];
        } else {
            throw new IllegalArgumentException("Instantiate needs to be called with either <namespace> <instance name> or <instance name> arguments, but instead found: " + args.length +" arguments.");
        }

        ClusterServicePlan item = get();
        return new ServiceInstanceOperationsImpl(context.withItem(null))
            .create(new ServiceInstanceBuilder()
                .withNewMetadata()
                .withName(instanceName)
                .withNamespace(instanceNamespace)
                .endMetadata()
                .withNewSpec()
                .withClusterServiceClassName(item.getSpec().getClusterServiceClassRef().getName())
                .withClusterServicePlanName(item.getMetadata().getName())
                .endSpec()
                .build());
    }

    @Override
    public ServiceInstanceResource instantiateAnd(String... args) {
        ServiceInstance item = instantiate(args);
        return new ServiceInstanceOperationsImpl(context.withItem(item));
    }

}
