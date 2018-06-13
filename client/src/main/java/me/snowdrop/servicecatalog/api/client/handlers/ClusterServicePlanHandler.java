/**
  * Copyright (C) 2018 Red Hat, Inc.
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
  * 
**/
package me.snowdrop.servicecatalog.api.client.handlers;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watch;

import me.snowdrop.servicecatalog.api.model.ClusterServicePlan;
import me.snowdrop.servicecatalog.api.model.ClusterServicePlanBuilder;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServicePlanOperationImpl;
import okhttp3.OkHttpClient;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class ClusterServicePlanHandler implements ResourceHandler<ClusterServicePlan, ClusterServicePlanBuilder> {

  @Override
  public String getKind() {
    return ClusterServicePlan.class.getSimpleName();
  }

  @Override
  public ClusterServicePlan create(OkHttpClient client, Config config, String namespace, ClusterServicePlan item) {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public ClusterServicePlan replace(OkHttpClient client, Config config, String namespace, ClusterServicePlan item) {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public ClusterServicePlan reload(OkHttpClient client, Config config, String namespace, ClusterServicePlan item) {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public ClusterServicePlanBuilder edit(ClusterServicePlan item) {
    return new ClusterServicePlanBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, ClusterServicePlan item) {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ClusterServicePlan item, Watcher<ClusterServicePlan> watcher) {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ClusterServicePlan item, String resourceVersion, Watcher<ClusterServicePlan> watcher) {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public ClusterServicePlan waitUntilReady(OkHttpClient client, Config config, String namespace, ClusterServicePlan item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ClusterServicePlanOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }
}
