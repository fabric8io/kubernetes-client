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

import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.Config;
import me.snowdrop.servicecatalog.api.client.util.ApiVersionUtil;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClassList;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlan;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlanList;
import me.snowdrop.servicecatalog.api.model.DoneableClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ServiceInstance;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;


public class ClusterServiceClassOperationImpl extends HasMetadataOperation<ClusterServiceClass, ClusterServiceClassList, DoneableClusterServiceClass, ClusterServiceClassResource> implements ClusterServiceClassResource {


  public ClusterServiceClassOperationImpl(OkHttpClient client, Config config) {
      this(client, config, "servicecatalog.k8s.io", "v1beta1", null, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

    public ClusterServiceClassOperationImpl(OkHttpClient client, Config config, String apiGroup, String apiVersion, String namespace, String name, Boolean cascading, ClusterServiceClass item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, apiGroup, apiVersion, "clusterserviceclasses", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

      //Added for compatibility
    public ClusterServiceClassOperationImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ClusterServiceClass item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
        super(client, config, ApiVersionUtil.apiGroup(item, apiVersion), ApiVersionUtil.apiVersion(item, apiVersion), "applications", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

    @Override
    public ClusterServiceClassResource withName(String name) {
        return new ClusterServiceClassOperationImpl(client, config, apiGroup, apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    }

    @Override
    public ClusterServicePlanList listPlans() {
        ClusterServiceClass item = get();
        return new ClusterServicePlanOperationImpl(client, config, apiGroup, apiVersion, namespace, null, isCascading(), null, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), new HashMap<>())
            .withField("spec.clusterServiceClassRef.name", item != null ? item.getMetadata().getName() : null)
                .list();
    }

    @Override
    public ClusterServicePlanResource usePlan(String externalName) {
        ClusterServiceClass item = get();
        Map<String, String> fields = new HashMap<>();
        fields.put("spec.clusterServiceClassRef.name", item.getMetadata().getName());
        fields.put("spec.externalName", externalName);

        List<ClusterServicePlan> list = new ClusterServicePlanOperationImpl(client, config, apiGroup, apiVersion, namespace, null, isCascading(), null, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), fields)
            .withFields(fields)
            .list().getItems();

        if (list.size() != 1) {
            throw new IllegalArgumentException("No unique ClusterServicePlan with external name: " + externalName + " found for ClusterServiceBroker: " + item.getSpec().getClusterServiceBrokerName()+" and ClusterServiceClass: " + item.getSpec().getExternalName()+".");
        }
        ClusterServicePlan p = list.get(0);
        return new ClusterServicePlanOperationImpl(client, config, apiGroup, apiVersion, namespace, p.getMetadata().getName(), isCascading(), null, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    }

    @Override
    public ServiceInstance instantiate(String instanceName, String plan) {
      ClusterServiceClass item = get();
      return new ServiceInstanceOperationImpl(client, config, apiGroup, apiVersion, namespace, null, isCascading(), null, null, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields())
                .createNew()
                .withNewMetadata()
                    .withName(instanceName)
                .endMetadata()
                .withNewSpec()
                    .withClusterServiceClassExternalName(item.getMetadata().getName())
                    .withClusterServicePlanExternalName(plan)
                .endSpec()
                .done();
    }
}
