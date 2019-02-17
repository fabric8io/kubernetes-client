/*
 * Copyright (C) 2018 Red Hat inc.
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
package me.snowdrop.servicecatalog.api.client.internal;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import me.snowdrop.servicecatalog.api.client.util.ApiVersionUtil;
import me.snowdrop.servicecatalog.api.model.DoneableServiceInstance;
import me.snowdrop.servicecatalog.api.model.ServiceBinding;
import me.snowdrop.servicecatalog.api.model.ServiceInstance;
import me.snowdrop.servicecatalog.api.model.ServiceInstanceList;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.TreeMap;


public class ServiceInstanceOperationImpl extends HasMetadataOperation<ServiceInstance, ServiceInstanceList, DoneableServiceInstance, ServiceInstanceResource> implements ServiceInstanceResource {

    public ServiceInstanceOperationImpl(OkHttpClient client, Config config) {
        this(client, config, "servicecatalog.k8s.io", "v1beta1", null, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
    }

    public ServiceInstanceOperationImpl(OkHttpClient client, Config config, String apiGroup, String apiVersion, String namespace, String name, Boolean cascading, ServiceInstance item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
        super(client, config, apiGroup, apiVersion, "serviceinstances", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    }

    @Override
    public NonNamespaceOperation<ServiceInstance, ServiceInstanceList, DoneableServiceInstance, ServiceInstanceResource> inNamespace(String namespace) {
        return new ServiceInstanceOperationImpl(client, config, apiGroup, apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    }
    //Added for compatibility
    public ServiceInstanceOperationImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ServiceInstance item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
        super(client, config, ApiVersionUtil.apiGroup(item, apiVersion), ApiVersionUtil.apiVersion(item, apiVersion), "applications", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    }
    @Override
    public ServiceInstanceResource withName(String name) {
        return new ServiceInstanceOperationImpl(client, config, apiGroup, apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    }

    @Override
    public boolean isResourceNamespaced() {
        return true;
    }

    @Override
    public ServiceBinding bind(String secretName) {
        ServiceInstance item = get();
        return new ServiceBindingOperationImpl(client, config, apiGroup, apiVersion, namespace, item.getMetadata().getName(), isCascading(), null, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields())
                .createNew()
                .withNewMetadata()
                    .withName(item.getMetadata().getName())
                .endMetadata()
                .withNewSpec()
                    .withSecretName(secretName)
                    .withNewInstanceRef(item.getMetadata().getName())
                .endSpec()
                .done();
    }
}
