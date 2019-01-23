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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Replaceable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 */
public class CustomResourceOperationsImpl<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>> extends HasMetadataOperation<T, L, D,
    Resource<T, D>> implements MixedOperation<T, L, D, Resource<T, D>> {

  private final boolean resourceNamespaced;

  public CustomResourceOperationsImpl(OkHttpClient httpClient, Config configuration, CustomResourceDefinition crd, Class<T> resourceType, Class<L> resourceListType, Class<D> doneType) {
    this(httpClient, configuration, apiGroup(crd), apiVersion(crd), resourceT(crd), resourceNamespaced(crd), null, null, false, null, null, false, resourceType, resourceListType, doneType);
  }

  public CustomResourceOperationsImpl(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, boolean resouceNamespaced, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, Class<T> type, Class<L> listType, Class<D> doneableType) {
    super(client, config, apiGroup, apiVersion, resourceT, namespace, name, cascading, item, resourceVersion, reloadingFromServer, type, listType, doneableType);
    this.resourceNamespaced = resouceNamespaced;
    this.apiGroupVersion = getAPIGroup() + "/" + getAPIVersion();

    KubernetesDeserializer.registerCustomKind(type.getSimpleName(), type);
    if (KubernetesResource.class.isAssignableFrom(listType)) {
      KubernetesDeserializer.registerCustomKind(listType.getSimpleName(), (Class<? extends KubernetesResource>) listType);
    }
  }

  protected static String apiGroup(CustomResourceDefinition crd) {
    return crd.getSpec().getGroup();
  }

  protected static String apiVersion(CustomResourceDefinition crd) {
    return crd.getSpec().getVersion();
  }

  protected static String resourceT(CustomResourceDefinition crd) {
    return crd.getSpec().getNames().getPlural();
  }

  protected static String name(CustomResourceDefinition crd) {
    return crd.getMetadata().getName();
  }

  protected static boolean resourceNamespaced(CustomResourceDefinition crd) {
    return "Namespaced".equals(crd.getSpec().getScope());
  }

  @Override
  public NonNamespaceOperation<T, L, D, Resource<T, D>> inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NonNamespaceOperation<T, L, D, Resource<T, D>> inNamespace(String namespace) {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }

  @Override
  public boolean isResourceNamespaced() {
    return resourceNamespaced;
  }

  @Override
  public Resource<T, D> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }

  @Override
  public Replaceable<T, T> lockResourceVersion(String resourceVersion) {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }

  @Override
  protected Resource<T, D> createItemOperation(T item) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), getName(), isCascading(), item, getResourceVersion(), isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }

  @Override
  public Resource<T, D> load(InputStream is) {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), getName(), isCascading(), unmarshal(is, getType()), getResourceVersion(), isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }

  @Override
  public Gettable<T> fromServer() {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), true, getType(), getListType(), getDoneableType());
  }

  @Override
  public Watchable<Watch, Watcher<T>> withResourceVersion(String resourceVersion) {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }

  @Override
  public EditReplacePatchDeletable<T, T, D, Boolean> cascading(boolean cascading) {
    return new CustomResourceOperationsImpl<>(client, getConfig(), getAPIGroup(), getAPIVersion(), getResourceT(), resourceNamespaced, getNamespace(), getName(), cascading, getItem(), getResourceVersion(), isReloadingFromServer(), getType(), getListType(), getDoneableType());
  }
}
