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

package io.fabric8.kubernetes.client.extension;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.client.GracePeriodConfigurable;
import io.fabric8.kubernetes.client.PropagationPolicyConfigurable;
import io.fabric8.kubernetes.client.ResourceNotFoundException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.ReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.WritableOperation;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Base for overriding a Resource
 *
 * @param <T> the resource type
 */
public class ResourceAdapter<T> implements Resource<T> {

  Resource<T> resource;

  public ResourceAdapter() {

  }

  public ResourceAdapter(Resource<T> resource) {
    this.resource = resource;
  }

  public Resource<T> getResource() {
    return resource;
  }

  @Override
  public List<StatusDetails> delete() {
    return resource.delete();
  }

  @Override
  public boolean isReady() {
    return resource.isReady();
  }

  @Override
  public T get() {
    return resource.get();
  }

  @Override
  public ReplaceDeletable<T> lockResourceVersion(String resourceVersion) {
    return resource.lockResourceVersion(resourceVersion);
  }

  @Override
  public WritableOperation<T> dryRun() {
    return resource.dryRun();
  }

  @Override
  public Watchable<T> withResourceVersion(String resourceVersion) {
    return resource.withResourceVersion(resourceVersion);
  }

  @Override
  public Gettable<T> fromServer() {
    return resource.fromServer();
  }

  @Override
  public T replaceStatus() {
    return resource.replaceStatus();
  }

  @Override
  public T create() {
    return resource.create();
  }

  @Override
  public PropagationPolicyConfigurable<? extends Deletable> withGracePeriod(long gracePeriodSeconds) {
    return resource.withGracePeriod(gracePeriodSeconds);
  }

  @Override
  public T createOrReplace() {
    return resource.createOrReplace();
  }

  @Override
  public T editStatus(UnaryOperator<T> function) {
    return resource.editStatus(function);
  }

  @Override
  public T require() throws ResourceNotFoundException {
    return resource.require();
  }

  @Override
  public GracePeriodConfigurable<? extends Deletable> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return resource.withPropagationPolicy(propagationPolicy);
  }

  @Override
  public Watch watch(Watcher<T> watcher) {
    return resource.watch(watcher);
  }

  @Override
  @Deprecated
  public T patch(T item) {
    return resource.patch(item);
  }

  @Override
  public T patchStatus(T item) {
    return resource.patchStatus(item);
  }

  @Override
  public T edit(UnaryOperator<T> function) {
    return resource.edit(function);
  }

  @Override
  public T waitUntilReady(long amount, TimeUnit timeUnit) {
    return resource.waitUntilReady(amount, timeUnit);
  }

  @Override
  public Watch watch(ListOptions options, Watcher<T> watcher) {
    return resource.watch(options, watcher);
  }

  @Override
  public T waitUntilCondition(Predicate<T> condition, long amount, TimeUnit timeUnit) {
    return resource.waitUntilCondition(condition, amount, timeUnit);
  }

  @Override
  public Informable<T> withIndexers(Map<String, Function<T, List<String>>> indexers) {
    return resource.withIndexers(indexers);
  }

  @Override
  public WritableOperation<T> dryRun(boolean isDryRun) {
    return resource.dryRun(isDryRun);
  }

  @Override
  public T edit(Visitor... visitors) {
    return resource.edit(visitors);
  }

  @Override
  public T patch(PatchContext patchContext, T item) {
    return resource.patch(patchContext, item);
  }

  @Override
  public Informable<T> withLimit(Long limit) {
    return resource.withLimit(limit);
  }

  @Override
  public <V> T edit(Class<V> visitorType, Visitor<V> visitor) {
    return resource.edit(visitorType, visitor);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<T> watcher) {
    return resource.watch(resourceVersion, watcher);
  }

  @Override
  public T accept(Consumer<T> function) {
    return resource.accept(function);
  }

  @Override
  public SharedIndexInformer<T> inform() {
    return resource.inform();
  }

  @Override
  public T patch(String patch) {
    return resource.patch(patch);
  }

  @Override
  public T patch(PatchContext patchContext, String patch) {
    return resource.patch(patchContext, patch);
  }

  @Override
  public SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler) {
    return resource.inform(handler);
  }

  @Override
  public SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler, long resync) {
    return resource.inform(handler, resync);
  }

  @Override
  public SharedIndexInformer<T> runnableInformer(long resync) {
    return resource.runnableInformer(resync);
  }

  @Override
  public CompletableFuture<List<T>> informOnCondition(Predicate<List<T>> condition) {
    return resource.informOnCondition(condition);
  }

  @Override
  public T replace() {
    return resource.replace();
  }

  @Override
  public T create(T item) {
    return resource.create(item);
  }

  @Override
  public T replace(T item) {
    return resource.replace(item);
  }

  @Override
  public T createOrReplace(T item) {
    return resource.createOrReplace(item);
  }

  @Override
  public T replaceStatus(T item) {
    return resource.replaceStatus(item);
  }

  @Override
  public List<StatusDetails> delete(T item) {
    return resource.delete(item);
  }

  @Override
  public T updateStatus(T item) {
    return resource.updateStatus(item);
  }

  @Override
  public ReplaceDeletable<T> lockResourceVersion() {
    return resource.lockResourceVersion();
  }

  @Override
  public T patchStatus() {
    return resource.patchStatus();
  }

  @Override
  public T patch() {
    return resource.patch();
  }

  @Override
  public T patch(PatchContext patchContext) {
    return resource.patch(patchContext);
  }

}
