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
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class BuildConfigHandler implements ResourceHandler<BuildConfig, BuildConfigBuilder> {

  @Override
  public String getKind() {
    return BuildConfig.class.getSimpleName();
  }

  @Override
  public BuildConfig create(OkHttpClient client, Config config, String namespace, BuildConfig item) {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).create();
  }

  @Override
  public BuildConfig replace(OkHttpClient client, Config config, String namespace, BuildConfig item) {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).replace(item);
  }

  @Override
  public BuildConfig reload(OkHttpClient client, Config config, String namespace, BuildConfig item) {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, osConfig, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).fromServer().get();
  }

  @Override
  public BuildConfigBuilder edit(BuildConfig item) {
    return new BuildConfigBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, BuildConfig item) {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, BuildConfig item, Watcher<BuildConfig> watcher) {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, osConfig, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, BuildConfig item, String resourceVersion, Watcher<BuildConfig> watcher) {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, osConfig, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).watch(resourceVersion, watcher);
  }

  @Override
  public BuildConfig waitUntilReady(OkHttpClient client, Config config, String namespace, BuildConfig item, long amount, TimeUnit timeUnit) throws InterruptedException {
    OpenShiftConfig osConfig = OpenShiftConfig.wrap(config);
    return new BuildConfigOperationsImpl(client, osConfig, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, osConfig.getBuildTimeout(), TimeUnit.MILLISECONDS).waitUntilReady(amount, timeUnit);
  }
}
