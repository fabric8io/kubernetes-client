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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.CustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.informers.impl.DefaultSharedIndexInformer;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import okhttp3.OkHttpClient;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static io.fabric8.kubernetes.client.utils.Utils.getPluralFromKind;

/**
 * SharedInformerFactory class constructs and caches informers for api types.
 *
 * This has been taken from https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/SharedInformerFactory.java
 * which is ported from offical go client https://github.com/kubernetes/client-go/blob/master/informers/factory.go
 */
public class SharedInformerFactory extends BaseOperation {
  private final Map<Type, SharedIndexInformer> informers = new HashMap<>();

  private final Map<Type, Future> startedInformers = new HashMap<>();

  private final ExecutorService informerExecutor;

  private final BaseOperation baseOperation;

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners = new ConcurrentLinkedQueue<>();

  /**
   * Constructor with thread pool specified.
   *
   * @param threadPool specified thread pool.
   * @param okHttpClient OkHttp client
   * @param configuration configuration for client
   */
  public SharedInformerFactory(ExecutorService threadPool, OkHttpClient okHttpClient, Config configuration) {
    super(new OperationContext().withOkhttpClient(okHttpClient).withConfig(configuration));
    initOperationContext(configuration);
    this.informerExecutor = threadPool;
    this.baseOperation = this.newInstance(context);
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
    return sharedIndexInformerFor(apiTypeClass, KubernetesResourceUtil.inferListType(apiTypeClass), null, resyncPeriodInMillis);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified. And the
   * informer cache will be overwritten.
   *
   * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
   *
   * @param apiTypeClass apiType class
   * @param operationContext {@link OperationContext} Operation Context
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced}) if Namespace scoped resource
   * @return the shared index informer
   */
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, KubernetesResourceUtil.inferListType(apiTypeClass), operationContext, resyncPeriodInMillis);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources. Note that
   * {@link CustomResourceDefinitionContext} would be build using opinionated defaults by inspecting the ApiType
   * POJO
   *
   * @param apiTypeClass apiType class
   * @param operationContext operation context
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link CustomResource} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @return the shared index informer
   */
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerForCustomResource(Class<T> apiTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, CustomResourceOperationsImpl.inferListType(apiTypeClass), operationContext.withPlural(CustomResourceDefinitionContext.fromCustomResourceType(apiTypeClass).getPlural()), resyncPeriodInMillis);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources. Note that
   * {@link CustomResourceDefinitionContext} would be build using opinionated defaults by inspecting the ApiType
   * POJO
   *
   * @param apiTypeClass apiType class
   * @param resyncPeriodInMillis  resync period in milliseconds
   * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @return the shared index informer
   */
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerForCustomResource(Class<T> apiTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, CustomResourceOperationsImpl.inferListType(apiTypeClass), null, resyncPeriodInMillis);
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
  private synchronized <T extends HasMetadata, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, Class<L> apiListTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    ListerWatcher<T, L> listerWatcher = listerWatcherFor(apiTypeClass, apiListTypeClass);
    OperationContext context = this.context.withApiGroupName(HasMetadata.getGroup(apiTypeClass))
      .withApiGroupVersion(HasMetadata.getVersion(apiTypeClass))
      .withPlural(resolvePlural(apiTypeClass)) // todo: we should unify how plurals are calculated
      .withIsNamespaceConfiguredFromGlobalConfig(this.context.isNamespaceFromGlobalConfig());
    if (operationContext != null) {
      context = context.withOperationContext(operationContext);
      // If OperationContext contains namespace, ignore global watch
      if (operationContext.getNamespace() != null) {
        context = context.withIsNamespaceConfiguredFromGlobalConfig(false);
      }
    }
    SharedIndexInformer<T> informer = new DefaultSharedIndexInformer<>(apiTypeClass, listerWatcher, resyncPeriodInMillis, context, eventListeners);
    this.informers.put(apiTypeClass, informer);
    return informer;
  }

  private <T extends HasMetadata, L extends KubernetesResourceList<T>> ListerWatcher<T, L> listerWatcherFor(Class<T> apiTypeClass, Class<L> apiListTypeClass) {

    return new ListerWatcher<T, L>() {
      @Override
      public L list(ListOptions params, String namespace, OperationContext context) {
        BaseOperation<T, L, ?> listBaseOperation = getConfiguredBaseOperation(namespace, context, apiTypeClass, apiListTypeClass);
        registerKindToKubernetesDeserializer(apiTypeClass);
        return listBaseOperation.list();
      }

      @Override
      public Watch watch(ListOptions params, String namespace, OperationContext context, Watcher<T> resourceWatcher) {
        BaseOperation<T, L, ?> watchBaseOperation = getConfiguredBaseOperation(namespace, context, apiTypeClass, apiListTypeClass);
        registerKindToKubernetesDeserializer(apiTypeClass);
        return watchBaseOperation.watch(params.getResourceVersion(), resourceWatcher);
      }
    };
  }

  /**
   * Gets existing shared index informer, return null if the requesting informer
   * is never constructed.
   *
   * @param apiTypeClass API type class
   * @param <T> type of API type
   * @return SharedIndexInformer object
   */
  public synchronized <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass) {
    return this.informers.get(apiTypeClass);
  }

  /**
   * Starts all registered informers.
   */
  public synchronized void startAllRegisteredInformers() {
    if (informers.isEmpty()) {
      return;
    }

    if (!informerExecutor.isShutdown()) {
      informers.forEach(
        (informerType, informer) ->
          startedInformers.computeIfAbsent(informerType, key -> informerExecutor.submit(informer::run)));
    }
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
    if (informers.isEmpty()) {
      return;
    }
    informers.forEach(
      (informerType, informer) -> {
        if (startedInformers.remove(informerType) != null) {
          informer.stop();
        }
      });
    if (shutDownThreadPool) {
      informerExecutor.shutdown();
    }
  }

  public void addSharedInformerEventListener(SharedInformerEventListener event) {
    this.eventListeners.add(event);
  }

  private <T extends HasMetadata, L extends KubernetesResourceList<T>> BaseOperation<T, L, ?> getConfiguredBaseOperation(String namespace, OperationContext context, Class<T> apiTypeClass, Class<L> apiListTypeClass) {
    BaseOperation<T, L, ?> baseOperationWithContext;
    // Avoid adding Namespace if it's picked from Global Configuration
    if (context.isNamespaceFromGlobalConfig()) {
      // SharedInformer default behavior is to watch in all namespaces
      // unless we specify namespace explicitly in OperationContext
      baseOperationWithContext = baseOperation.newInstance(context
        .withConfig(new ConfigBuilder(config)
          .withNamespace(null)
          .build())
        .withNamespace(null));
    } else {
      baseOperationWithContext = baseOperation.newInstance(context.withNamespace(namespace));
    }
    baseOperationWithContext.setType(apiTypeClass);
    baseOperationWithContext.setListType(apiListTypeClass);
    return baseOperationWithContext;
  }

  private void initOperationContext(Config configuration) {
    if (configuration.getNamespace() != null) {
      context = context.withIsNamespaceConfiguredFromGlobalConfig(true);
    }
  }

  private <T extends HasMetadata> void registerKindToKubernetesDeserializer(Class<T> apiTypeClass) {
    if (CustomResource.class.isAssignableFrom(apiTypeClass)) {
      KubernetesDeserializer.registerCustomKind(HasMetadata.getApiVersion(apiTypeClass), apiTypeClass.getSimpleName(), apiTypeClass);
    }
  }

  private <T extends HasMetadata> String resolvePlural(Class<T> apiTypeClass) {
    if (CustomResource.class.isAssignableFrom(apiTypeClass)) {
      return CustomResourceDefinitionContext.fromCustomResourceType(apiTypeClass).getPlural();
    }
    return getPluralFromKind(HasMetadata.getKind(apiTypeClass));
  }
}
