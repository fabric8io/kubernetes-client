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
package io.fabric8.kubernetes.client.informers.impl;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.BaseKubernetesClient;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * SharedInformerFactory class constructs and caches informers for api types.
 *
 * This has been taken from https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/SharedInformerFactory.java
 * which is ported from official go client https://github.com/kubernetes/client-go/blob/master/informers/factory.go
 */
public class SharedInformerFactoryImpl implements SharedInformerFactory {
  private static final Logger log = LoggerFactory.getLogger(SharedInformerFactoryImpl.class);

  private final List<Map.Entry<OperationContext, SharedIndexInformer>> informers = new ArrayList<>();

  private final ExecutorService informerExecutor;

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners = new ConcurrentLinkedQueue<>();

  private boolean allowShutdown = true;

  private String name;
  private String namespace;

  private BaseKubernetesClient<?> client;

  public SharedInformerFactoryImpl(BaseKubernetesClient<?> client) {
    // ideally this should be bounded.  The current implication is that there
    // can be 1 thread used (not dedicated to) per informer - which
    // could be problematic for a large number of informers.  however
    // if okhttp is in use, it will use two threads per watch
    this(client, Utils.getCommonExecutorSerive());
    this.allowShutdown = false;
  }
  /**
   * Constructor with thread pool specified.
   * @param threadPool specified thread pool.
   */
  public SharedInformerFactoryImpl(BaseKubernetesClient<?> client, ExecutorService threadPool) {
    this.informerExecutor = threadPool;
    this.client = client;
  }

  /**
   * Configure Namespace for {@link SharedInformerFactory}
   *
   * @param namespace namespace to configure
   * @return {@link SharedInformerFactory} with namespace configured
   * @deprecated use {@link Informable} instead
   */
  @Override
  @Deprecated
  public SharedInformerFactory inNamespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  /**
   * Configure Name for {@link SharedInformerFactory}
   *
   * @param name name to be configured
   * @return {@link SharedInformerFactory} with name configured
   * @deprecated use {@link Informable} instead
   */
  @Override
  @Deprecated
  public SharedInformerFactory withName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Constructs and returns a shared index informer with resync period specified. And the
   * informer cache will be overwritten.
   *
   * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
   *
   * @param apiTypeClass apiType class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced}) if Namespace scoped resource
   * @return the shared index informer
   */
  @Override
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, null, resyncPeriodInMillis, ResourceDefinitionContext.fromResourceType(apiTypeClass));
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources.
   *
   * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
   *
   * @param customResourceContext basic information about the Custom Resource Definition corresponding to that custom resource
   * @param apiTypeClass apiType class
   * @param apiListTypeClass api list type class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @param <L> the type's list parameter (should extend {@link io.fabric8.kubernetes.api.model.KubernetesResourceList}
   * @return the shared index informer
   * @deprecated Since 5.x versions of client {@link CustomResourceDefinitionContext} are configured via annotations in CustomResource implementations, please use any of the alternative sharedIndexInformerForCustomResource methods
   */
  @Override
  @Deprecated
  public synchronized <T extends CustomResource<?, ?>, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
    CustomResourceDefinitionContext customResourceContext, Class<T> apiTypeClass, Class<L> apiListTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, apiListTypeClass, resyncPeriodInMillis, customResourceContext);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for a Custom Resource. You
   * can use it for scenarios where you don't have a POJO for your custom type by specifying group, version and plural in
   * {@link CustomResourceDefinitionContext}
   *
   * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
   *
   * @param genericResourceContext object containing details about resource like apiGroup, version and plural, etc.
   * @param resyncPeriodInMillis resync period in milliseconds.
   * @return {@link SharedIndexInformer} for GenericKubernetesResource
   * @deprecated use {@link #sharedIndexInformerFor(Class, long)}
   */
  @Override
  @Deprecated
  public synchronized SharedIndexInformer<GenericKubernetesResource> sharedIndexInformerForCustomResource(ResourceDefinitionContext genericResourceContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(GenericKubernetesResource.class, GenericKubernetesResourceList.class, resyncPeriodInMillis, genericResourceContext);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources.
   * POJO
   *
   * @param apiTypeClass apiType class
   * @param resyncPeriodInMillis  resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @return the shared index informer
   * @deprecated use {@link #sharedIndexInformerFor(Class, long)} instead
   */
  @Override
  @Deprecated
  public synchronized <T extends CustomResource<?, ?>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
    Class<T> apiTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerForCustomResource(apiTypeClass, (Class)null, resyncPeriodInMillis);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources.
   *
   * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
   *
   * @param apiTypeClass apiType class
   * @param apiListTypeClass api list type class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @param <L> the type's list parameter (should extend {@link io.fabric8.kubernetes.api.model.KubernetesResourceList}
   * @return the shared index informer
   * @deprecated use {@link #sharedIndexInformerFor(Class, long)}
   */
  @Override
  @Deprecated
  public synchronized <T extends CustomResource<?,?>, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(Class<T> apiTypeClass, Class<L> apiListTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, apiListTypeClass, resyncPeriodInMillis, ResourceDefinitionContext.fromResourceType(apiTypeClass));
  }

  /**
   * Constructs and returns a shared index informer with resync period specified. And the
   * informer cache will be overwritten. You can use this method to specify namespace in {@link OperationContext}
   * if you want to monitor for events in a dedicated namespace only or provide other filtering options.
   *
   * @param apiTypeClass apiType class
   * @param apiListTypeClass api list type class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @param <L> the type's list parameter (should extend {@link io.fabric8.kubernetes.api.model.KubernetesResourceList}
   * @return the shared index informer
   */
  private synchronized <T extends HasMetadata, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, Class<L> apiListTypeClass, long resyncPeriodInMillis, ResourceDefinitionContext rdc) {

    HasMetadataOperationsImpl<T, L> resources = getResourceOperation(apiTypeClass, apiListTypeClass, rdc);

    // we want the resources to no longer reference a resourceVersion
    SharedIndexInformer<T> informer = new DefaultSharedIndexInformer<>(apiTypeClass, resources.withResourceVersion(null), resyncPeriodInMillis, informerExecutor);
    this.informers.add(new AbstractMap.SimpleEntry<>(resources.getOperationContext(), informer));
    return informer;
  }

  private <T extends HasMetadata, L extends KubernetesResourceList<T>> HasMetadataOperationsImpl<T, L> getResourceOperation(
      Class<T> apiTypeClass, Class<L> apiListTypeClass, ResourceDefinitionContext rdc) {

    HasMetadataOperationsImpl<T, L> resources = client.customResources(rdc, apiTypeClass, apiListTypeClass);

    if (namespace != null) {
      resources = (HasMetadataOperationsImpl<T, L>) resources.inNamespace(namespace);
    } else {
      resources = (HasMetadataOperationsImpl<T, L>) resources.inAnyNamespace();
    }
    if (name != null) {
      resources = (HasMetadataOperationsImpl<T, L>) resources.withName(name);
    }

    return resources;
  }

  /**
   * Gets existing shared index informer, return null if the requesting informer
   * is never constructed. If there are multiple SharedIndexInformer objects corresponding
   * to a Kubernetes resource, then it returns the first one
   *
   * @param apiTypeClass API type class
   * @param <T> type of API type
   * @return SharedIndexInformer object
   */
  @Override
  public synchronized <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass) {
    for (Map.Entry<OperationContext, SharedIndexInformer> entry : this.informers) {
      if (entry.getValue().getApiTypeClass().equals(apiTypeClass)) {
        return entry.getValue();
      }
    }
    return null;
  }

  /**
   * Gets a list of entries of ({@link OperationContext}, {@link SharedIndexInformer}) registered
   * by the user.
   *
   * @return a list of entries of {@link OperationContext} and {@link SharedIndexInformer}
   * @deprecated use {@link #getExistingSharedIndexInformer(Class)} instead
   */
  @Deprecated
  public List<Map.Entry<OperationContext, SharedIndexInformer>> getExistingSharedIndexInformers() {
    return Collections.unmodifiableList(this.informers);
  }

  /**
   * Starts all registered informers in an asynchronous fashion.
   *
   * @return {@link Future} for status of all started informer tasks.
   */
  @Override
  public synchronized Future<Void> startAllRegisteredInformers() {
    List<CompletableFuture<Boolean>> startInformerTasks = new ArrayList<>();

    if (!informers.isEmpty() && !informerExecutor.isShutdown()) {
      for (Map.Entry<OperationContext, SharedIndexInformer> entry : informers) {
        startInformerTasks.add(startInformerAsync(entry.getValue()));
      }
    }
    return CompletableFuture.allOf(startInformerTasks.toArray(new CompletableFuture[] {}));
  }

  /**
   * Stop all registered informers and shut down thread pool.
   */
  @Override
  public synchronized void stopAllRegisteredInformers() {
    stopAllRegisteredInformers(true);
  }

  /**
   * Stop all registered informers
   *
   * @param shutDownThreadPool Whether to shut down thread pool or not.
   */
  @Override
  public synchronized void stopAllRegisteredInformers(boolean shutDownThreadPool) {
    informers.forEach(e -> e.getValue().stop());
    if (shutDownThreadPool && allowShutdown) {
      informerExecutor.shutdown();
    }
  }

  @Override
  public void addSharedInformerEventListener(SharedInformerEventListener event) {
    this.eventListeners.add(event);
  }

  private synchronized CompletableFuture<Boolean> startInformerAsync(SharedIndexInformer informer) {
    CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
    informerExecutor.submit(() -> {
      try {
        informer.run();
        completableFuture.complete(true);
      } catch (RuntimeException e) {
        if (this.eventListeners.isEmpty()) {
          log.warn("Failed to start informer", e);
        } else {
          this.eventListeners.forEach(listener -> listener.onException(informer, e));
        }
        completableFuture.completeExceptionally(e);
      }
    });
    return completableFuture;
  }

}
