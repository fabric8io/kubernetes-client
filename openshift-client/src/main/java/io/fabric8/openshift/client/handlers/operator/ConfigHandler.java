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
package io.fabric8.openshift.client.handlers.operator;

import java.util.function.Predicate;

import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.openshift.client.dsl.internal.operator.ConfigOperationsImpl;

import okhttp3.OkHttpClient;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptions;
import java.util.concurrent.TimeUnit;

public class ConfigHandler implements ResourceHandler<io.fabric8.openshift.api.model.operator.v1.Config, io.fabric8.openshift.api.model.operator.v1.ConfigBuilder> {

  @Override
  public String getKind() {
    return io.fabric8.openshift.api.model.operator.v1.Config.class.getSimpleName();
  }

  @Override
  public String getApiVersion() {
      return "operator.openshift.io/v1";
    }

  @Override
  public io.fabric8.openshift.api.model.operator.v1.Config create(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, boolean dryRun) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).dryRun(dryRun).create();
  }

  @Override
  public io.fabric8.openshift.api.model.operator.v1.Config replace(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, boolean dryRun) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).dryRun(dryRun).replace(item);
  }

  @Override
  public io.fabric8.openshift.api.model.operator.v1.Config reload(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).fromServer().get();
  }

  @Override
  public io.fabric8.openshift.api.model.operator.v1.ConfigBuilder edit(io.fabric8.openshift.api.model.operator.v1.Config item) {
    return new io.fabric8.openshift.api.model.operator.v1.ConfigBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, DeletionPropagation propagationPolicy, long gracePeriodSeconds, io.fabric8.openshift.api.model.operator.v1.Config item, boolean dryRun) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).dryRun(dryRun).withPropagationPolicy(propagationPolicy).withGracePeriod(gracePeriodSeconds).delete();
  }

  @Override
  public Watch watch(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, Watcher<io.fabric8.openshift.api.model.operator.v1.Config> watcher) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, String resourceVersion, Watcher<io.fabric8.openshift.api.model.operator.v1.Config> watcher) {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).watch(resourceVersion, watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, ListOptions options, Watcher<io.fabric8.openshift.api.model.operator.v1.Config> watcher) {
  return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).watch(options, watcher);
  }


  @Override
  public io.fabric8.openshift.api.model.operator.v1.Config waitUntilReady(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).waitUntilReady(amount, timeUnit);
  }

  @Override
  public io.fabric8.openshift.api.model.operator.v1.Config waitUntilCondition(OkHttpClient client, io.fabric8.kubernetes.client.Config config, String namespace, io.fabric8.openshift.api.model.operator.v1.Config item, Predicate<io.fabric8.openshift.api.model.operator.v1.Config> condition, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ConfigOperationsImpl(client, OpenShiftConfig.wrap(config)).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).waitUntilCondition(condition, amount, timeUnit);
  }
}
