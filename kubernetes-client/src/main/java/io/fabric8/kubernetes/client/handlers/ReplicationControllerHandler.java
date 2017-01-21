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
package io.fabric8.kubernetes.client.handlers;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class ReplicationControllerHandler implements ResourceHandler<ReplicationController, ReplicationControllerBuilder> {

  @Override
  public String getKind() {
    return ReplicationController.class.getSimpleName();
  }

  @Override
  public ReplicationController create(OkHttpClient client, Config config, String namespace, ReplicationController item) {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).create();
  }

  @Override
  public ReplicationController replace(OkHttpClient client, Config config, String namespace, ReplicationController item) {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).replace(item);
  }

  @Override
  public ReplicationController reload(OkHttpClient client, Config config, String namespace, ReplicationController item) {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).fromServer().get();
  }

  @Override
  public ReplicationControllerBuilder edit(ReplicationController item) {
    return new ReplicationControllerBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, ReplicationController item) {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ReplicationController item, Watcher<ReplicationController> watcher) {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, ReplicationController item, String resourceVersion, Watcher<ReplicationController> watcher) {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).watch(resourceVersion, watcher);
  }

  @Override
  public ReplicationController waitUntilReady(OkHttpClient client, Config config, String namespace, ReplicationController item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ReplicationControllerOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS).waitUntilReady(amount, timeUnit);
  }
}
