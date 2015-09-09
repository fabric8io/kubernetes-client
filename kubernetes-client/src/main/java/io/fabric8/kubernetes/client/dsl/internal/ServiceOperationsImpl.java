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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;

public class ServiceOperationsImpl extends BaseOperation<KubernetesClient, Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>, CreateFromLoadable<Service, DoneableService>> {

  public ServiceOperationsImpl(KubernetesClient client) {
    this(client, null, null, true, null);
  }

  public ServiceOperationsImpl(KubernetesClient client, String namespace, String name, Boolean cascading, Service item) {
    super(client,"services", namespace, name, cascading, item);
  }

  @Override
  public Service replace(Service item) {
      try {
        Service old = get();
        String resourceVersion = old.getMetadata().getResourceVersion();
        return handleReplace(getResourceUrl(), new ServiceBuilder(item)
          .editMetadata()
          .withResourceVersion(resourceVersion)
          .endMetadata()
          .editSpec()
          .withClusterIP(old.getSpec().getClusterIP())
          .endSpec()
          .build());
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
  }

  @Override
  public Service update(Service item) {
      return replace(item);
  }
}
