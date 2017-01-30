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

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.internal.readiness.ReadinessWatcher;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ServiceOperationsImpl extends HasMetadataOperation<Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> {

  public ServiceOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public ServiceOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Service item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, null, apiVersion, "services", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  @Override
  public Service replace(Service item) {
      try {
        Service old = getMandatory();
        return super.replace(new ServiceBuilder(item)
          .editSpec()
          .withClusterIP(old.getSpec().getClusterIP())
          .endSpec()
          .build());
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
  }

  @Override
  public Service patch(Service item) {
      try {
        Service old = getMandatory();
        return super.patch(new ServiceBuilder(item)
          .editSpec()
          .withClusterIP(old.getSpec().getClusterIP())
          .endSpec()
          .build());
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
  }

  @Override
  public Service waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    Service service = get();
    if (service == null) {
      throw new IllegalArgumentException("Service with name:[" + name + "] in namespace:[" + namespace + "] not found!");
    }
    EndpointsOperationsImpl endpointsOperation = new EndpointsOperationsImpl(client, config, apiVersion, getNamespace(), getName(), isCascading(), null, null, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    Endpoints endpoints = endpointsOperation.waitUntilReady(amount, timeUnit);
    return get();
  }
}
