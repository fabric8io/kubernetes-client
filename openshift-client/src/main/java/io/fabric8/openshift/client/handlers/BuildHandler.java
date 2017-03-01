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
package io.fabric8.openshift.client.handlers;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.BuildOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class BuildHandler implements ResourceHandler<Build, BuildBuilder> {

  @Override
  public String getKind() {
    return Build.class.getSimpleName();
  }

  @Override
  public Build create(OkHttpClient client, Config config, String namespace, Build item) {
      return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).create();
  }

  @Override
  public Build replace(OkHttpClient client, Config config, String namespace, Build item) {
    return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).replace(item);
  }

  @Override
  public Build reload(OkHttpClient client, Config config, String namespace, Build item) {
    return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).fromServer().get();
  }

  @Override
  public BuildBuilder edit(Build item) {
    return new BuildBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, Build item) {
      return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, Build item, Watcher<Build> watcher) {
    return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, Build item, String resourceVersion, Watcher<Build> watcher) {
    return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).watch(resourceVersion, watcher);
  }

  @Override
  public Build waitUntilReady(OkHttpClient client, Config config, String namespace, Build item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new BuildOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, -1, -1, false, null, null).waitUntilReady(amount, timeUnit);
  }
}
