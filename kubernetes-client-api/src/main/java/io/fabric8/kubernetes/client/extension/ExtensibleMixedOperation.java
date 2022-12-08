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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.GracePeriodConfigurable;
import io.fabric8.kubernetes.client.PropagationPolicyConfigurable;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.AnyNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.DeletableWithOptions;
import io.fabric8.kubernetes.client.dsl.FilterNested;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.ItemWritableOperation;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ExtensibleMixedOperation<T, L, R extends Resource<T>> implements MixedOperation<T, L, R> {

  protected final MixedOperation<T, L, R> operation;
  protected final Client client;

  public ExtensibleMixedOperation(Client client, MixedOperation<T, L, R> operation) {
    this.client = client;
    this.operation = operation;
  }

  @Override
  public R withName(String name) {
    return operation.withName(name);
  }

  @Override
  public NonNamespaceOperation<T, L, R> inNamespace(String name) {
    return operation.inNamespace(name);
  }

  @Override
  public T replaceStatus(T item) {
    return operation.replaceStatus(item);
  }

  @Override
  public AnyNamespaceOperation<T, L, R> inAnyNamespace() {
    return operation.inAnyNamespace();
  }

  @Override
  public Watchable<T> withResourceVersion(String resourceVersion) {
    return operation.withResourceVersion(resourceVersion);
  }

  @Override
  public L list() {
    return operation.list();
  }

  @Override
  public L list(Integer limitVal, String continueVal) {
    return operation.list(limitVal, continueVal);
  }

  @Override
  public List<StatusDetails> delete() {
    return operation.delete();
  }

  @Override
  public T waitUntilReady(long amount, TimeUnit timeUnit) {
    return operation.waitUntilReady(amount, timeUnit);
  }

  @Override
  public PropagationPolicyConfigurable<? extends Deletable> withGracePeriod(long gracePeriodSeconds) {
    return operation.withGracePeriod(gracePeriodSeconds);
  }

  @Override
  public T waitUntilCondition(Predicate<T> condition, long amount, TimeUnit timeUnit) {
    return operation.waitUntilCondition(condition, amount, timeUnit);
  }

  @Override
  public T createOrReplace(T item) {
    return operation.createOrReplace(item);
  }

  @Override
  public Watch watch(Watcher<T> watcher) {
    return operation.watch(watcher);
  }

  @Override
  public GracePeriodConfigurable<? extends Deletable> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return operation.withPropagationPolicy(propagationPolicy);
  }

  @Override
  public FilterNested<FilterWatchListDeletable<T, L, R>> withNewFilter() {
    return operation.withNewFilter();
  }

  @Override
  public T replace(T item) {
    return operation.replace(item);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabels(Map<String, String> labels) {
    return operation.withLabels(labels);
  }

  @Override
  public ItemWritableOperation<T> dryRun() {
    return operation.dryRun();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutLabels(Map<String, String> labels) {
    return operation.withoutLabels(labels);
  }

  @Override
  public DeletableWithOptions withTimeout(long timeout, TimeUnit unit) {
    return operation.withTimeout(timeout, unit);
  }

  @Override
  public Watch watch(ListOptions options, Watcher<T> watcher) {
    return operation.watch(options, watcher);
  }

  @Override
  public L list(ListOptions listOptions) {
    return operation.list(listOptions);
  }

  @Override
  public Informable<T> withIndexers(Map<String, Function<T, List<String>>> indexers) {
    return operation.withIndexers(indexers);
  }

  @Override
  public Stream<R> resources() {
    return operation.resources();
  }

  @Override
  public DeletableWithOptions withTimeoutInMillis(long timeoutInMillis) {
    return operation.withTimeoutInMillis(timeoutInMillis);
  }

  @Override
  public T create(T item) {
    return operation.create(item);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelIn(String key, String... values) {
    return operation.withLabelIn(key, values);
  }

  @Override
  public List<StatusDetails> delete(T item) {
    return operation.delete(item);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelNotIn(String key, String... values) {
    return operation.withLabelNotIn(key, values);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabel(String key, String value) {
    return operation.withLabel(key, value);
  }

  @Override
  public Informable<T> withLimit(Long limit) {
    return operation.withLimit(limit);
  }

  @Override
  public ItemWritableOperation<T> dryRun(boolean isDryRun) {
    return operation.dryRun(isDryRun);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabel(String key) {
    return operation.withLabel(key);
  }

  @Override
  public T updateStatus(T item) {
    return operation.updateStatus(item);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutLabel(String key, String value) {
    return operation.withoutLabel(key, value);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<T> watcher) {
    return operation.watch(resourceVersion, watcher);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutLabel(String key) {
    return operation.withoutLabel(key);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withFields(Map<String, String> fields) {
    return operation.withFields(fields);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withField(String key, String value) {
    return operation.withField(key, value);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutFields(Map<String, String> fields) {
    return operation.withoutFields(fields);
  }

  @Override
  public T patchStatus(T item) {
    return operation.patchStatus(item);
  }

  @Override
  public boolean delete(T... items) {
    return operation.delete(items);
  }

  @Override
  public SharedIndexInformer<T> inform() {
    return operation.inform();
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withoutField(String key, String value) {
    return operation.withoutField(key, value);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelSelector(LabelSelector selector) {
    return operation.withLabelSelector(selector);
  }

  @Override
  public boolean delete(List<T> items) {
    return operation.delete(items);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withLabelSelector(String selectorAsString) {
    return operation.withLabelSelector(selectorAsString);
  }

  @Override
  public FilterWatchListDeletable<T, L, R> withInvolvedObject(ObjectReference objectReference) {
    return operation.withInvolvedObject(objectReference);
  }

  @Override
  public R load(InputStream is) {
    return operation.load(is);
  }

  @Override
  public R load(URL url) {
    return operation.load(url);
  }

  @Override
  public SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler) {
    return operation.inform(handler);
  }

  @Override
  public R load(File file) {
    return operation.load(file);
  }

  @Override
  public R load(String path) {
    return operation.load(path);
  }

  @Override
  public R resource(T item) {
    return operation.resource(item);
  }

  @Override
  public SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler, long resync) {
    return operation.inform(handler, resync);
  }

  @Override
  public SharedIndexInformer<T> runnableInformer(long resync) {
    return operation.runnableInformer(resync);
  }

  @Override
  public CompletableFuture<List<T>> informOnCondition(Predicate<List<T>> condition) {
    return operation.informOnCondition(condition);
  }

}
