package io.fabric8.kubernetes.client.utils.informers;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.CallGenerator;
import io.fabric8.kubernetes.client.utils.informers.impl.DefaultSharedIndexInformer;
import okhttp3.OkHttpClient;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * SharedInformerFactory class constructs and caches informers for api types.
 *
 */
public class SharedInformerFactory extends BaseOperation {
  private Map<Type, SharedIndexInformer> informers;

  private Map<Type, Future> startedInformers;

  private ExecutorService informerExecutor;

  private BaseOperation baseOperation;

  /**
   * Constructor with thread pool specified.
   *
   * @param threadPool specified thread pool.
   */
  public SharedInformerFactory(ExecutorService threadPool, OkHttpClient okHttpClient, Config configuration) {
    super(new OperationContext().withOkhttpClient(okHttpClient).withConfig(configuration));
    this.informerExecutor = threadPool;
    this.informers = new HashMap<>();
    this.startedInformers = new HashMap<>();
    this.baseOperation = this.newInstance(context.withPlural("pods"));
  }

  /**
   * Constructs and returns a shared index informer with resync period specified. And the
   * informer cache will be overwritten.
   *
   * @param apiTypeClass apiType class
   * @param apiListTypeClass api list type class
   * @param resyncPeriodInMillis resync period in milliseconds
   * @param <T> the type parameter
   * @param <TList> the type's list parameter
   * @return the shared index informer
   */
  public synchronized <T extends HasMetadata, TList extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass, Class<TList> apiListTypeClass, long resyncPeriodInMillis) {
    BaseOperation<T, TList, ?, ?> baseOperation = this.newInstance(context.withPlural("pods"));
    ListerWatcher<T, TList> listerWatcher = listerWatcherFor(apiTypeClass, apiListTypeClass);
    SharedIndexInformer<T> informer = new DefaultSharedIndexInformer<T, TList>(apiTypeClass, listerWatcher, resyncPeriodInMillis, baseOperation, context);
    this.informers.put(apiTypeClass, informer);
    return informer;
  }

  private <T extends HasMetadata, TList extends KubernetesResourceList<T>> ListerWatcher<T, TList> listerWatcherFor(Class<T> apiTypeClass, Class<TList> apiListTypeClass) {

    return new ListerWatcher<T, TList>() {
      @Override
      public TList list(ListOptions params, String namespace) throws KubernetesClientException {
        baseOperation.setType(apiTypeClass);
        baseOperation.setListType(apiListTypeClass);
        baseOperation.setNamespace(namespace);
        return (TList)baseOperation.list();
      }

      @Override
      public Watch watch(ListOptions params, String namespace, Watcher<T> resourceWatcher) throws KubernetesClientException {
        return baseOperation.watch(params.getResourceVersion(), resourceWatcher);
      }
    };
  }

  /**
   * Gets existing shared index informer, return null if the requesting informer
   * is never constructed.
   *
   * @param apiTypeClass
   * @param <T>
   * @return
   */
  public synchronized <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass) {
    return this.informers.get(apiTypeClass);
  }

  /**
   * Starts all registered informers.
   */
  public synchronized void startAllRegisteredInformers() {
    if (informers == null || informers.isEmpty()) {
      return;
    }

    informers.forEach(
      (informerType, informer) -> {
        if (!startedInformers.containsKey(informerType)) {
          startedInformers.put(informerType, informerExecutor.submit(informer::run));
        }
      });
  }

  /**
   * Stop all registered informers.
   */
  public synchronized void stopAllRegisteredInformers() {
    if (informers == null || informers.isEmpty()) {
      return;
    }
    informers.forEach(
      (informerType, informer) -> {
        if (startedInformers.containsKey(informerType)) {
          startedInformers.remove(informerType);
          informer.stop();
        }
      });
    informerExecutor.shutdown();
  }
}
