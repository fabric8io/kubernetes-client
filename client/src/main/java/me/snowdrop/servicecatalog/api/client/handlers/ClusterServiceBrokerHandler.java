/**
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
  * 
**/
package me.snowdrop.servicecatalog.api.client.handlers;

import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watch;

import me.snowdrop.servicecatalog.api.model.ClusterServiceBroker;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBrokerBuilder;
import me.snowdrop.servicecatalog.api.client.internal.ClusterServiceBrokerOperationImpl;
import okhttp3.OkHttpClient;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class ClusterServiceBrokerHandler implements ResourceHandler<ClusterServiceBroker, ClusterServiceBrokerBuilder> {

  @Override
  public String getKind() {
    return ClusterServiceBroker.class.getSimpleName();
  }

  @Override
  public ClusterServiceBroker create(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item) {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public ClusterServiceBroker replace(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item) {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public ClusterServiceBroker reload(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item) {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public ClusterServiceBrokerBuilder edit(ClusterServiceBroker item) {
    return new ClusterServiceBrokerBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item) {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item, Watcher<ClusterServiceBroker> watcher) {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item, String resourceVersion, Watcher<ClusterServiceBroker> watcher) {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public ClusterServiceBroker waitUntilReady(OkHttpClient client, Config config, String namespace, ClusterServiceBroker item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ClusterServiceBrokerOperationImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }
}
