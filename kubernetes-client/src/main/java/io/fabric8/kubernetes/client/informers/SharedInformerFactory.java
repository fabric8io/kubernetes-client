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
package io.fabric8.kubernetes.client.informers;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.inferListType;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.SharedInformerOperationsImpl;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.impl.DefaultSharedIndexInformer;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import okhttp3.OkHttpClient;

/**
 * SharedInformerFactory class constructs and caches informers for api types.
 *
 * This has been taken from https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/SharedInformerFactory.java
 * which is ported from offical go client https://github.com/kubernetes/client-go/blob/master/informers/factory.go
 */
public class SharedInformerFactory {
  private final List<Map.Entry<OperationContext, SharedIndexInformer>> informers = new ArrayList<>();

  private final ExecutorService informerExecutor;

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners = new ConcurrentLinkedQueue<>();

  private boolean allowShutdown = true;
  
  private class SharedInformerFactoryBaseOperation extends BaseOperation {

    private SharedInformerFactoryBaseOperation(OperationContext ctx) {
      super(ctx);
    }
    
    private OperationContext getContext() {
      return this.context;
    }
    
    private void setContext(OperationContext context) {
      this.context = context;
    }
    
    private void setName(String name) {
      this.name = name;
    }
    
  }
  
  private SharedInformerFactoryBaseOperation baseOperation;
  
  public SharedInformerFactory(OkHttpClient okHttpClient, Config configuration) {
    // ideally this should be bounded.  The current implication is that there
    // can be 1 thread used (not dedicated to) per informer - which 
    // could be problematic for a large number of informers.  however
    // there is already a superceding issue there of thread utilization by okhttp
    this(Utils.getCommonExecutorSerive(), okHttpClient, configuration);
    this.allowShutdown = false;
  }
  /**
   * Constructor with thread pool specified.
   *
   * @param threadPool specified thread pool.
   * @param okHttpClient OkHttp client
   * @param configuration configuration for client
   */
  public SharedInformerFactory(ExecutorService threadPool, OkHttpClient okHttpClient, Config configuration) {
    this.baseOperation = new SharedInformerFactoryBaseOperation(new OperationContext().withOkhttpClient(okHttpClient).withConfig(configuration));
    initOperationContext(configuration);
    this.informerExecutor = threadPool;
    this.baseOperation.setNamespace(null);
  }

  /**
   * Configure Namespace for {@link SharedInformerFactory}
   *
   * @param namespace namespace to configure
   * @return {@link SharedInformerFactory} with namespace configured
   * @deprecated use {@link Informable} instead
   */
  @Deprecated
  public SharedInformerFactory inNamespace(String namespace) {
    this.baseOperation.setNamespace(namespace);
    return this;
  }

  /**
   * Configure Name for {@link SharedInformerFactory}
   *
   * @param name name to be configured
   * @return {@link SharedInformerFactory} with name configured
   * @deprecated use {@link Informable} instead
   */
  @Deprecated
  public SharedInformerFactory withName(String name) {
    this.baseOperation.setName(name);
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
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, inferListType(apiTypeClass), null, resyncPeriodInMillis, Utils.isResourceNamespaced(apiTypeClass));
  }

  /**
   * Constructs and returns a shared index informer with resync period specified.
   *
   * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
   *
   * @param apiTypeClass apiType class
   * @param operationContext {@link OperationContext} Operation Context
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced}) if Namespace scoped resource
   * @return the shared index informer
   * @deprecated use {@link Informable} instead
   */
  @Deprecated
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, inferListType(apiTypeClass), operationContext, resyncPeriodInMillis, Utils.isResourceNamespaced(apiTypeClass));
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
  @Deprecated
  public synchronized <T extends CustomResource<?, ?>, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
    CustomResourceDefinitionContext customResourceContext, Class<T> apiTypeClass, Class<L> apiListTypeClass, long resyncPeriodInMillis) {
    KubernetesDeserializer.registerCustomKind(String.format("%s/%s",
      Objects.requireNonNull(customResourceContext.getGroup()),
      Objects.requireNonNull(customResourceContext.getVersion())
    ), Optional.ofNullable(customResourceContext.getKind()).orElse(apiTypeClass.getSimpleName()), apiTypeClass);
    return sharedIndexInformerFor(apiTypeClass, apiListTypeClass, baseOperation.getContext()
      .withApiGroupName(customResourceContext.getGroup())
      .withApiGroupVersion(customResourceContext.getVersion())
      .withPlural(customResourceContext.getPlural())
      .withIsNamespaceConfiguredFromGlobalConfig(baseOperation.getContext().isNamespaceFromGlobalConfig()), resyncPeriodInMillis, Utils.isResourceNamespaced(apiTypeClass));
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
   */
  public synchronized SharedIndexInformer<GenericKubernetesResource> sharedIndexInformerForCustomResource(CustomResourceDefinitionContext genericResourceContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(GenericKubernetesResource.class, GenericKubernetesResourceList.class, new OperationContext()
      .withApiGroupName(genericResourceContext.getGroup())
      .withApiGroupVersion(genericResourceContext.getVersion())
      .withPlural(genericResourceContext.getPlural())
      .withNamespace(baseOperation.getNamespace())
      .withIsNamespaceConfiguredFromGlobalConfig(baseOperation.getContext().isNamespaceFromGlobalConfig()), resyncPeriodInMillis, genericResourceContext.isNamespaceScoped());
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources.
   *
   * @param apiTypeClass apiType class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link CustomResource} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @return the shared index informer
   * @deprecated use {@link Informable} instead
   */
  @Deprecated
  public synchronized <T extends CustomResource<?,?>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
    Class<T> apiTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, inferListType(apiTypeClass), operationContext, resyncPeriodInMillis, Utils.isResourceNamespaced(apiTypeClass));
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources.
   * POJO
   *
   * @param apiTypeClass apiType class
   * @param resyncPeriodInMillis  resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @return the shared index informer
   */
  public synchronized <T extends CustomResource<?, ?>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
    Class<T> apiTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerForCustomResource(apiTypeClass, inferListType(apiTypeClass), resyncPeriodInMillis);
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
   */
  public synchronized <T extends CustomResource<?,?>, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(Class<T> apiTypeClass, Class<L> apiListTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, apiListTypeClass, null, resyncPeriodInMillis, Utils.isResourceNamespaced(apiTypeClass));
  }

  /**
   * Constructs and returns a shared index informer with resync period specified. And the
   * informer cache will be overwritten. You can use this method to specify namespace in {@link OperationContext}
   * if you want to monitor for events in a dedicated namespace only or provide other filtering options.
   *
   * @param apiTypeClass apiType class
   * @param apiListTypeClass api list type class
   * @param operationContext operation context
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @param <L> the type's list parameter (should extend {@link io.fabric8.kubernetes.api.model.KubernetesResourceList}
   * @return the shared index informer
   */
  private synchronized <T extends HasMetadata, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, Class<L> apiListTypeClass, OperationContext operationContext, long resyncPeriodInMillis, boolean isResourceNamespaced) {
    ListerWatcher<T, L> listerWatcher = listerWatcherFor(apiTypeClass, apiListTypeClass, isResourceNamespaced);
    OperationContext context = this.baseOperation.getContext().withApiGroupName(HasMetadata.getGroup(apiTypeClass))
      .withApiGroupVersion(HasMetadata.getVersion(apiTypeClass))
      .withPlural(HasMetadata.getPlural(apiTypeClass))
      .withIsNamespaceConfiguredFromGlobalConfig(this.baseOperation.getContext().isNamespaceFromGlobalConfig());
    if (this.baseOperation.getNamespace() != null) {
      context = context.withNamespace(this.baseOperation.getNamespace()).withIsNamespaceConfiguredFromGlobalConfig(false);
    }
    if (this.baseOperation.getName() != null) {
      context = context.withFields(Collections.singletonMap("metadata.name", this.baseOperation.getName()));
    }
    if (operationContext != null) {
      context = context.withOperationContext(operationContext);
      // If OperationContext contains namespace, ignore global watch
      if (operationContext.getNamespace() != null) {
        context = context.withIsNamespaceConfiguredFromGlobalConfig(false);
      }
    }
    SharedIndexInformer<T> informer = new DefaultSharedIndexInformer<>(apiTypeClass, listerWatcher, resyncPeriodInMillis, context, informerExecutor);
    this.informers.add(new AbstractMap.SimpleEntry<>(context, informer));
    return informer;
  }

  private <T extends HasMetadata, L extends KubernetesResourceList<T>> ListerWatcher<T, L> listerWatcherFor(Class<T> apiTypeClass, Class<L> apiListTypeClass, boolean isResourceNamespaced) {

    return new ListerWatcher<T, L>() {
      @Override
      public L list(ListOptions params, String namespace, OperationContext context) {
        BaseOperation<T, L, ?> listBaseOperation = getConfiguredBaseOperation(namespace, context, apiTypeClass, apiListTypeClass, isResourceNamespaced);
        registerKindToKubernetesDeserializer(apiTypeClass);
        return listBaseOperation.list();
      }

      @Override
      public Watch watch(ListOptions params, String namespace, OperationContext context, Watcher<T> resourceWatcher) {
        BaseOperation<T, L, ?> watchBaseOperation = getConfiguredBaseOperation(namespace, context, apiTypeClass, apiListTypeClass, isResourceNamespaced);
        registerKindToKubernetesDeserializer(apiTypeClass);
        return watchBaseOperation.watch(params.getResourceVersion(), resourceWatcher);
      }
    };
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
  public synchronized <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass) {
    for (Map.Entry<OperationContext, SharedIndexInformer> entry : this.informers) {
      if (entry.getValue().getApiTypeClass().equals(apiTypeClass)) {
        return (SharedIndexInformer<T>) entry.getValue();
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
  public synchronized void stopAllRegisteredInformers() {
    stopAllRegisteredInformers(true);
  }

  /**
   * Stop all registered informers
   *
   * @param shutDownThreadPool Whether to shut down thread pool or not.
   */
  public synchronized void stopAllRegisteredInformers(boolean shutDownThreadPool) {
    informers.forEach(e -> e.getValue().stop());
    if (shutDownThreadPool && allowShutdown) {
      informerExecutor.shutdown();
    }
  }

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
        this.eventListeners.forEach(listener -> listener.onException(informer, e));
        completableFuture.completeExceptionally(e);
      }
    });
    return completableFuture;
  }

  private <T extends HasMetadata, L extends KubernetesResourceList<T>> BaseOperation<T, L, ?> getConfiguredBaseOperation(String namespace, OperationContext context, Class<T> apiTypeClass, Class<L> apiListTypeClass, boolean isNamespacedScoped) {
    SharedInformerOperationsImpl<T, L, Resource<T>> sharedInformerOperations;
    // Avoid adding Namespace if it's picked from Global Configuration
    if (context.isNamespaceFromGlobalConfig()) {
      // SharedInformer default behavior is to watch in all namespaces
      // unless we specify namespace explicitly in OperationContext
      sharedInformerOperations = new SharedInformerOperationsImpl<>(context
        .withConfig(new ConfigBuilder(this.baseOperation.getConfig())
          .withNamespace(null)
          .build())
        .withNamespace(null), isNamespacedScoped);
    } else {
      sharedInformerOperations = new SharedInformerOperationsImpl<>(context.withNamespace(namespace), isNamespacedScoped);
    }
    sharedInformerOperations.setType(apiTypeClass);
    sharedInformerOperations.setListType(apiListTypeClass);
    return sharedInformerOperations;
  }

  private void initOperationContext(Config configuration) {
    if (configuration.getNamespace() != null) {
      this.baseOperation.setContext(this.baseOperation.getContext().withIsNamespaceConfiguredFromGlobalConfig(true));
    }
  }

  private <T extends HasMetadata> void registerKindToKubernetesDeserializer(Class<T> apiTypeClass) {
    if (CustomResource.class.isAssignableFrom(apiTypeClass)) {
      KubernetesDeserializer.registerCustomKind(HasMetadata.getApiVersion(apiTypeClass), apiTypeClass.getSimpleName(), apiTypeClass);
    }
  }

}
