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
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.ServiceResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.OkHttpClient;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class ServiceOperationsImpl extends HasMetadataOperation<Service, ServiceList, DoneableService, ServiceResource<Service, DoneableService>> implements ServiceResource<Service, DoneableService> {

  public ServiceOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, null, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public ServiceOperationsImpl(OkHttpClient client, Config config, String apiGroup, String apiVersion, String namespace, String name, Boolean cascading, Service item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, apiGroup, apiVersion, "services", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
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
        throw KubernetesClientException.launderThrowable(forOperationType("replace"), e);
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
        throw KubernetesClientException.launderThrowable(forOperationType("patch"), e);
      }
  }

  @Override
  public Service waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    long started = System.currentTimeMillis();
    super.waitUntilReady(amount, timeUnit);
    long alreadySpent = System.currentTimeMillis() - started;

    // if awaiting existence took very long, let's give at least 10 seconds to awaiting readiness
    long remaining = Math.max(10_000, timeUnit.toMillis(amount) - alreadySpent);

    EndpointsOperationsImpl endpointsOperation = new EndpointsOperationsImpl(client, config, apiGroupVersion, getNamespace(), getName(), isCascading(), null, null, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    endpointsOperation.waitUntilReady(remaining, TimeUnit.MILLISECONDS);

    return get();
  }

  public String getURL(String portName) {
    String clusterIP =  getMandatory().getSpec().getClusterIP();
    if("None".equals(clusterIP)) {
      throw new IllegalStateException("Service: " + getMandatory().getMetadata().getName() + " in namespace " +
        namespace + " is head-less. Search for endpoints instead");
    }
    return getUrlHelper(portName);
  }

  private String getUrlHelper(String portName) {
    ServiceLoader<ServiceToURLProvider> urlProvider = ServiceLoader.load(ServiceToURLProvider.class, Thread.currentThread().getContextClassLoader());
    Iterator<ServiceToURLProvider> iterator = urlProvider.iterator();
    List<ServiceToURLProvider> servicesList = new ArrayList<>();

    while(iterator.hasNext()) {
      servicesList.add(iterator.next());
    }

    // Sort all loaded implementations according to priority
    Collections.sort(servicesList, new ServiceToUrlSortComparator());
    for(ServiceToURLProvider serviceToURLProvider : servicesList) {
      String url = serviceToURLProvider.getURL(getMandatory(), portName, namespace, new DefaultKubernetesClient(client, getConfig()));
      if(url != null && URLUtils.isValidURL(url)) {
        return url;
      }
    }

    return null;
  }

  public class ServiceToUrlSortComparator implements Comparator<ServiceToURLProvider> {
    public int compare(ServiceToURLProvider first, ServiceToURLProvider second) {
      return first.getPriority() - second.getPriority();
    }
  }
}
