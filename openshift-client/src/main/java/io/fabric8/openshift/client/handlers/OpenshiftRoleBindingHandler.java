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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.openshift.api.model.OpenshiftRoleBinding;
import io.fabric8.openshift.api.model.OpenshiftRoleBindingBuilder;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OpenshiftRoleBindingOperationsImpl;
import okhttp3.OkHttpClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

@Component
@Service
public class OpenshiftRoleBindingHandler implements ResourceHandler<OpenshiftRoleBinding, OpenshiftRoleBindingBuilder> {

  @Override
  public String getKind() {
    return OpenshiftRoleBinding.class.getSimpleName();
  }

  @Override
  public OpenshiftRoleBinding create(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item) {
      return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
    }

  @Override
  public OpenshiftRoleBinding replace(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item) {
    return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public OpenshiftRoleBinding reload(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item) {
    return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public OpenshiftRoleBindingBuilder edit(OpenshiftRoleBinding item) {
    return new OpenshiftRoleBindingBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item) {
      return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
    }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item, Watcher<OpenshiftRoleBinding> watcher) {
    return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item, String resourceVersion, Watcher<OpenshiftRoleBinding> watcher) {
    return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public OpenshiftRoleBinding waitUntilReady(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }

  @Override
  public OpenshiftRoleBinding waitUntilCondition(OkHttpClient client, Config config, String namespace, OpenshiftRoleBinding item, Predicate<OpenshiftRoleBinding> condition, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new OpenshiftRoleBindingOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilCondition(condition, amount, timeUnit);
  }
}
