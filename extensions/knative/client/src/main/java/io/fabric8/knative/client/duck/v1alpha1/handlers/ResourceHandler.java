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

package io.fabric8.knative.client.duck.v1alpha1.handlers;

import java.util.function.Predicate;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.knative.client.duck.v1alpha1.internal.ResourceOperationsImpl;
import io.fabric8.kubernetes.api.model.DeletionPropagation;

import okhttp3.OkHttpClient;

import io.fabric8.knative.duck.v1alpha1.Resource;
import io.fabric8.knative.duck.v1alpha1.ResourceBuilder;

import java.util.concurrent.TimeUnit;

public class ResourceHandler implements io.fabric8.kubernetes.client.ResourceHandler<Resource, ResourceBuilder> {

  @Override
  public String getKind() {
    return Resource.class.getSimpleName();
  }

  @Override
  public String getApiVersion() {
        return "duck.knative.dev/v1beta1";
      }

  @Override
  public Resource create(OkHttpClient client, Config config, String namespace, Resource item) {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).create();
  }

  @Override
  public Resource replace(OkHttpClient client, Config config, String namespace, Resource item) {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).replace(item);
  }

  @Override
  public Resource reload(OkHttpClient client, Config config, String namespace, Resource item) {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).fromServer().get();
  }

  @Override
  public ResourceBuilder edit(Resource item) {
    return new ResourceBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, DeletionPropagation propagationPolicy, Resource item) {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withPropagationPolicy(propagationPolicy).delete();
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, Resource item, Watcher<Resource> watcher) {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, Resource item, String resourceVersion, Watcher<Resource> watcher) {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).watch(resourceVersion, watcher);
  }

  @Override
  public Resource waitUntilReady(OkHttpClient client, Config config, String namespace, Resource item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).waitUntilReady(amount, timeUnit);
  }

  @Override
  public Resource waitUntilCondition(OkHttpClient client, Config config, String namespace, Resource item, Predicate<Resource> condition, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new ResourceOperationsImpl(client, config).withItem(item).inNamespace(namespace).withName(item.getMetadata().getName()).waitUntilCondition(condition, amount, timeUnit);
  }
}
