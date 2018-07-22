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

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRole;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesClusterRoleOperationsImpl;
import okhttp3.OkHttpClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class KubernetesClusterRoleHandler implements ResourceHandler<KubernetesClusterRole, KubernetesClusterRoleBuilder> {

  @Override
  public String getKind() {
    return KubernetesClusterRole.class.getSimpleName();
  }

  @Override
  public KubernetesClusterRole create(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item) {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public KubernetesClusterRole replace(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item) {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public KubernetesClusterRole reload(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item) {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public KubernetesClusterRoleBuilder edit(KubernetesClusterRole item) {
    return new KubernetesClusterRoleBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item) {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item, Watcher<KubernetesClusterRole> watcher) {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item, String resourceVersion, Watcher<KubernetesClusterRole> watcher) {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public KubernetesClusterRole waitUntilReady(OkHttpClient client, Config config, String namespace, KubernetesClusterRole item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new KubernetesClusterRoleOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }
}
