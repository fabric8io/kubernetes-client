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

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;

import java.net.URL;

public class ServiceOperationsImpl extends BaseOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService, Void, Boolean>> {

  public ServiceOperationsImpl(AsyncHttpClient httpClient, URL rootUrl) {
    super(httpClient, rootUrl, "services", null, null, Service.class, ServiceList.class, DoneableService.class);
  }

  public ServiceOperationsImpl(AsyncHttpClient httpClient, URL rootUrl, String namespace, String name) {
    super(httpClient, rootUrl, "services", namespace, name);
  }

  @Override
  public Service update(Service item) {
      try {
        Service old = get();
        String resourceVersion = old.getMetadata().getResourceVersion();
        return handleUpdate(getResourceUrl(), new ServiceBuilder(item)
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
}
