/*
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
import io.fabric8.kubernetes.client.Client;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * To be used as a base for overriding or adding Resource methods
 *
 * @param <T> the resource type
 */
public abstract class ExtensibleResourceAdapter<T> extends ResourceAdapter<T> implements ExtensibleResource<T> {

  protected Client client;

  public ExtensibleResourceAdapter() {

  }

  public abstract ExtensibleResourceAdapter<T> newInstance();

  public ExtensibleResourceAdapter<T> init(ExtensibleResource<T> resource, Client client) {
    this.resource = resource;
    this.client = client;
    return this;
  }

  @SuppressWarnings("unchecked")
  private ExtensibleResource<T> extensibleResource() {
    return (ExtensibleResource<T>) resource;
  }

  @Override
  public ExtensibleResource<T> lockResourceVersion(String resourceVersion) {
    return newInstance().init(extensibleResource().lockResourceVersion(resourceVersion), client);
  }

  @Override
  public ExtensibleResource<T> withResourceVersion(String resourceVersion) {
    return newInstance().init(extensibleResource().withResourceVersion(resourceVersion), client);
  }

  @Override
  public ExtensibleResource<T> fromServer() {
    return newInstance().init(extensibleResource().fromServer(), client);
  }

  @Override
  public ExtensibleResource<T> withGracePeriod(long gracePeriodSeconds) {
    return newInstance().init(extensibleResource().withGracePeriod(gracePeriodSeconds), client);
  }

  @Override
  public ExtensibleResource<T> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return newInstance().init(extensibleResource().withPropagationPolicy(propagationPolicy), client);
  }

  @Override
  public ExtensibleResource<T> withIndexers(Map<String, Function<T, List<String>>> indexers) {
    return newInstance().init(extensibleResource().withIndexers(indexers), client);
  }

  @Override
  public ExtensibleResource<T> dryRun(boolean isDryRun) {
    return newInstance().init(extensibleResource().dryRun(isDryRun), client);
  }

  @Override
  public ExtensibleResource<T> withLimit(Long limit) {
    return newInstance().init(extensibleResource().withLimit(limit), client);
  }

  @Override
  public <C extends Client> C inWriteContext(Class<C> clazz) {
    return extensibleResource().inWriteContext(clazz);
  }

  @Override
  public ExtensibleResource<T> lockResourceVersion() {
    return newInstance().init(extensibleResource().lockResourceVersion(), client);
  }

  @Override
  public T getItem() {
    return extensibleResource().getItem();
  }

  @Override
  public ExtensibleResource<T> fieldValidation(Validation fieldValidation) {
    return newInstance().init(extensibleResource().fieldValidation(fieldValidation), client);
  }

  @Override
  public ExtensibleResource<T> fieldManager(String manager) {
    return newInstance().init(extensibleResource().fieldManager(manager), client);
  }

  @Override
  public ExtensibleResource<T> forceConflicts() {
    return newInstance().init(extensibleResource().forceConflicts(), client);
  }

  @Override
  public ExtensibleResource<T> withTimeout(long timeout, TimeUnit unit) {
    return newInstance().init(extensibleResource().withTimeout(timeout, unit), client);
  }

  @Override
  public ExtensibleResource<T> withTimeoutInMillis(long timeoutInMillis) {
    return withTimeout(timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  public ExtensibleResource<T> unlock() {
    return newInstance().init(extensibleResource().unlock(), client);
  }

  @Override
  public ExtensibleResource<T> subresource(String subresource) {
    return newInstance().init(extensibleResource().subresource(subresource), client);
  }

}
