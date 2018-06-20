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
package me.snowdrop.servicecatalog.api.client.handlers;

import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watch;

import me.snowdrop.servicecatalog.api.model.ClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClassBuilder;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServiceClassOperationImpl;
import okhttp3.OkHttpClient;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class ClusterServiceClassHandler implements ResourceHandler<ClusterServiceClass, ClusterServiceClassBuilder> {

  @Override
  public String getKind() {
    return ClusterServiceClass.class.getSimpleName();
  }

  @Override
  public ClusterServiceClass create(OkHttpClient client, Config config, String namespace, ClusterServiceClass item) {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public ClusterServiceClass replace(OkHttpClient client, Config config, String namespace, ClusterServiceClass item) {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public ClusterServiceClass reload(OkHttpClient client, Config config, String namespace, ClusterServiceClass item) {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public ClusterServiceClassBuilder edit(ClusterServiceClass item) {
    return new ClusterServiceClassBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, ClusterServiceClass item) {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ClusterServiceClass item, Watcher<ClusterServiceClass> watcher) {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ClusterServiceClass item, String resourceVersion, Watcher<ClusterServiceClass> watcher) {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public ClusterServiceClass waitUntilReady(OkHttpClient client, Config config, String namespace, ClusterServiceClass item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ClusterServiceClassOperationImpl(client, config, "servicecatalog.k8s.io", "v1beta1", namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }
}
