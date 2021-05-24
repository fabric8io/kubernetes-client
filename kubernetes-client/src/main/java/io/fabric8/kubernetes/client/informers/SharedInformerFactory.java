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
import io.fabric8.kubernetes.client.informers.impl.DefaultSharedIndexInformer;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SharedInformerFactory class constructs and caches informers for api types.
 *
 * This has been taken from https://github.com/kubernetes-client/java/blob/master/util/src/main/java/io/kubernetes/client/informer/SharedInformerFactory.java
 * which is ported from offical go client https://github.com/kubernetes/client-go/blob/master/informers/factory.go
 */
public class SharedInformerFactory extends BaseOperation {
  private static final Logger log = LoggerFactory.getLogger(SharedInformerFactory.class);
  private final Map<String, SharedIndexInformer> informers = new HashMap<>();

  private final Map<String, Future> startedInformers = new HashMap<>();

  private final ExecutorService informerExecutor;

  private final BaseOperation baseOperation;

  private final ConcurrentLinkedQueue<SharedInformerEventListener> eventListeners = new ConcurrentLinkedQueue<>();

  private boolean allowShutdown = true;
  
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
    super(new OperationContext().withOkhttpClient(okHttpClient).withConfig(configuration));
    initOperationContext(configuration);
    this.informerExecutor = threadPool;
    this.baseOperation = this.newInstance(context);
    this.namespace = null;
  }

  /**
   * Configure Namespace for {@link SharedInformerFactory}
   *
   * @param namespace namespace to configure
   * @return {@link SharedInformerFactory} with namespace configured
   */
  @Override
  public SharedInformerFactory inNamespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  /**
   * Configure Name for {@link SharedInformerFactory}
   *
   * @param name name to be configured
   * @return {@link SharedInformerFactory} with name configured
   */
  @Override
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
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, inferListType(apiTypeClass), null, resyncPeriodInMillis);
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
   */
  public synchronized <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, inferListType(apiTypeClass), operationContext, resyncPeriodInMillis);
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
    return sharedIndexInformerFor(apiTypeClass, apiListTypeClass, context
      .withApiGroupName(customResourceContext.getGroup())
      .withApiGroupVersion(customResourceContext.getVersion())
      .withPlural(customResourceContext.getPlural())
      .withIsNamespaceConfiguredFromGlobalConfig(context.isNamespaceFromGlobalConfig()), resyncPeriodInMillis);
  }

  /**
   * Constructs and returns a shared index informer with resync period specified for custom resources.
   *
   * @param apiTypeClass apiType class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter (should extend {@link CustomResource} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
   * @return the shared index informer
   */
  public synchronized <T extends CustomResource<?,?>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
    Class<T> apiTypeClass, OperationContext operationContext, long resyncPeriodInMillis) {
    return sharedIndexInformerFor(apiTypeClass, inferListType(apiTypeClass), operationContext, resyncPeriodInMillis);
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
    return sharedIndexInformerFor(apiTypeClass, apiListTypeClass, null, resyncPeriodInMillis);
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
      .withPlural(HasMetadata.getPlural(apiTypeClass))
      .withIsNamespaceConfiguredFromGlobalConfig(this.context.isNamespaceFromGlobalConfig());
    if (this.namespace != null) {
      context = context.withNamespace(this.namespace).withIsNamespaceConfiguredFromGlobalConfig(false);
    }
    if (this.name != null) {
      context = context.withFields(Collections.singletonMap("metadata.name", this.name));
    }
    if (operationContext != null) {
      context = context.withOperationContext(operationContext);
      // If OperationContext contains namespace, ignore global watch
      if (operationContext.getNamespace() != null) {
        context = context.withIsNamespaceConfiguredFromGlobalConfig(false);
      }
    }
    SharedIndexInformer<T> informer = new DefaultSharedIndexInformer<>(apiTypeClass, listerWatcher, resyncPeriodInMillis, context, informerExecutor);
    this.informers.put(getInformerKey(context), informer);
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
   * is never constructed. If there are multiple SharedIndexInformer objects corresponding
   * to a Kubernetes resource, then it returns the first one
   *
   * @param apiTypeClass API type class
   * @param <T> type of API type
   * @return SharedIndexInformer object
   */
  public synchronized <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass) {
    SharedIndexInformer<T> foundSharedIndexInformer = null;
    for (Map.Entry<String, SharedIndexInformer> entry : this.informers.entrySet()) {
      if (isKeyOfType(entry.getKey(), apiTypeClass)) {
        foundSharedIndexInformer = (SharedIndexInformer<T>) entry.getValue();
      }
    }
    return foundSharedIndexInformer;
  }

  /**
   * Starts all registered informers in an asynchronous fashion.
   * <br>use {@link #addSharedInformerEventListener(SharedInformerEventListener)} to receive startup errors. 
   */
  public synchronized void startAllRegisteredInformers() {
    if (informers.isEmpty()) {
      return;
    }

    if (!informerExecutor.isShutdown()) {
      informers.forEach(
          (informerType, informer) -> startedInformers.computeIfAbsent(informerType,
              key -> informerExecutor.submit(() -> {
                try {
                  informer.run();
                } catch (RuntimeException e) {
                  this.eventListeners.forEach(listener -> listener.onException(informer, e));
                  log.warn("Informer start did not complete", e);
                }
              })));
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
    if (shutDownThreadPool && allowShutdown) {
      informerExecutor.shutdown();
    }
  }

  public void addSharedInformerEventListener(SharedInformerEventListener event) {
    this.eventListeners.add(event);
  }

  Map<String, SharedIndexInformer> getInformers() {
    return this.informers;
  }

  static String getInformerKey(OperationContext operationContext) {
    StringBuilder keyBuilder = new StringBuilder();
    if (operationContext.getApiGroupName() == null) {
      keyBuilder.append(operationContext.getApiGroupVersion());
    } else {
      keyBuilder.append(operationContext.getApiGroupName()).append("/").append(operationContext.getApiGroupVersion());
    }
    keyBuilder.append(getKeyStrForField(operationContext.getPlural()));
    keyBuilder.append(getKeyStrForField(operationContext.getNamespace()));
    keyBuilder.append(getKeyStrForField(operationContext.getName()));

    return keyBuilder.toString();
  }

  private static String getKeyStrForField(String str) {
    StringBuilder keyBuilder = new StringBuilder();
    if (Utils.isNotNullOrEmpty(str)) {
      keyBuilder.append("/");
      keyBuilder.append(str);
    }
    return keyBuilder.toString();
  }

  private static <T> boolean isKeyOfType(String key, Class<T> apiTypeClass) {
    String plural = HasMetadata.getPlural(apiTypeClass);
    return key.contains(plural);
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
}
