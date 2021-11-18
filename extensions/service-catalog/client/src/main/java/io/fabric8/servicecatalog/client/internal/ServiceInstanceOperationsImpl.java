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

import io.fabric8.kubernetes.client.ClientState;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.api.model.ServiceBindingBuilder;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceList;

public class ServiceInstanceOperationsImpl extends HasMetadataOperation<ServiceInstance, ServiceInstanceList, ServiceInstanceResource> implements ServiceInstanceResource {

    public ServiceInstanceOperationsImpl(ClientState clientState) {
        this(HasMetadataOperationsImpl.defaultContext(clientState));
    }

    public ServiceInstanceOperationsImpl(OperationContext ctx) {
        super(ctx.withApiGroupName("servicecatalog.k8s.io").withApiGroupVersion("v1beta1").withPlural("serviceinstances"),
                ServiceInstance.class, ServiceInstanceList.class);
    }

    @Override
    public BaseOperation<ServiceInstance, ServiceInstanceList, ServiceInstanceResource> newInstance(OperationContext context) {
        return new ServiceInstanceOperationsImpl(context);
    }

    @Override
    public boolean isResourceNamespaced() {
        return true;
    }

    @Override
    public ServiceBinding bind(String secretName) {
        ServiceInstance item = get();
        return new ServiceBindingOperationsImpl(context.withItem(null))
            .create(new ServiceBindingBuilder()
                .withNewMetadata()
                    .withName(item.getMetadata().getName())
                .endMetadata()
                .withNewSpec()
                    .withSecretName(secretName)
                    .withNewInstanceRef(item.getMetadata().getName())
                .endSpec()
                    .build());
    }

}
