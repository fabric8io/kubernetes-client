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
import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.DaemonSetOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class DaemonSetHandler implements ResourceHandler<DaemonSet, DaemonSetBuilder> {

  @Override
  public String getKind() {
    return DaemonSet.class.getSimpleName();
  }

  @Override
  public DaemonSet create(OkHttpClient client, Config config, String namespace, DaemonSet item) {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public DaemonSet replace(OkHttpClient client, Config config, String namespace, DaemonSet item) {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public DaemonSet reload(OkHttpClient client, Config config, String namespace, DaemonSet item) {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public DaemonSetBuilder edit(DaemonSet item) {
    return new DaemonSetBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, DaemonSet item) {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, DaemonSet item, Watcher<DaemonSet> watcher) {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, DaemonSet item, String resourceVersion, Watcher<DaemonSet> watcher) {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public DaemonSet waitUntilReady(OkHttpClient client, Config config, String namespace, DaemonSet item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new DaemonSetOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }
}
