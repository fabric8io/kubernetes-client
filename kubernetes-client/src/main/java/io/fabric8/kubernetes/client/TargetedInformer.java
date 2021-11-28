package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.client.informers.ListerWatcher;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Due to several design issues I haven't heavily refactored the informer to support this logic yet
 * It also does not protect against exceptions when calling the actual handler
 */
public class TargetedInformer<T extends HasMetadata> implements Watcher<T>, Watch {
  
  private ListerWatcher<T, ? extends KubernetesResourceList<T>> listerWatcher;
  private Long batchSize;
  private ResourceEventHandler<T> handler;
  private Function<T, String> keyFunction;
  
  private AtomicBoolean closed = new AtomicBoolean();
  private volatile Watch watch;
  private volatile ConcurrentHashMap<String, T> resources = new ConcurrentHashMap<>();
  private UnaryOperator<T> stateFunction;
  
  public TargetedInformer(ListerWatcher<T, ? extends KubernetesResourceList<T>> listerWatcher, Long batchSize, Function<T, String> keyFunction, ResourceEventHandler<T> handler, UnaryOperator<T> stateFunction) {
    this.listerWatcher = listerWatcher;
    this.batchSize = batchSize;
    this.handler = handler;
    this.stateFunction = stateFunction;
    this.keyFunction = keyFunction;
    listAndWatch();
  }

  @Override
  public void eventReceived(Action action, T resource) {
    String resourceVersion = resource.getMetadata().getResourceVersion();
    String key = keyFunction.apply(resource); 
    switch (action) {
    case ADDED:
    case MODIFIED:
      updated(resource, resourceVersion, key);
      break;
    case DELETED:
      if (resources.remove(key) != null) {
        handler.onDelete(resource, false);
      }
      break;
    default:
      break;
    }
  }

  private void updated(T resource, String resourceVersion, String key) {
    T previous = resources.put(key, storeResource(resource));
    if (previous == null) {
      handler.onAdd(resource);
    } else if (!Objects.equals(resourceVersion, previous.getMetadata().getResourceVersion())) {
      handler.onUpdate(resource, previous);
    }
  }
  
  public T getLastKnownState(String key) {
    return this.resources.get(key);
  }

  // could also store as a string to save memory?
  private T storeResource(T resource) {
    T result = stateFunction.apply(resource);
    if (result == null) {
      try {
        result = (T) resource.getClass().getDeclaredConstructor().newInstance();
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
    // at least retain the uid and resourceVersion
    KubernetesResourceUtil.setResourceVersion(result, resource.getMetadata().getResourceVersion());
    result.getMetadata().setUid(resource.getMetadata().getUid());
    return result;
  }

  @Override
  public void close() {
    if (closed.compareAndSet(false, true)) {
      watch.close();
    }
  }
  
  @Override
  public void onClose(WatcherException cause) {
    if (closed.get()) {
      return;
    }
    if (!cause.isHttpGone()) {
      close();
      return;
    }
    listAndWatch();
    if (closed.get()) {
      watch.close();
    }
  }
  
  public boolean isClosed() {
    return closed.get();
  }
  
  /**
   * Since we don't expose the resources, they are modified as needed
   */
  private void listAndWatch() {
    ConcurrentHashMap<String, T> next = new ConcurrentHashMap<>();
    String continueVal = null;
    String resourceVersion = null;

    // if there's an exception while we do this, we'll simply retry
    // could consider increasing the batch size for the next run
    do {
      KubernetesResourceList<T> result = listerWatcher.list(new ListOptionsBuilder().withLimit(batchSize).withContinue(continueVal).build());
      result.getItems().forEach(i -> {
        String key = keyFunction.apply(i);
        String itemResourceVersion = i.getMetadata().getResourceVersion();
        // process the updates immediately so we don't need to hold the item
        updated(i, itemResourceVersion, key);
        next.put(key, storeResource(i));
      });
      resourceVersion = result.getMetadata().getResourceVersion();
      continueVal = result.getMetadata().getContinue();
    } while (Utils.isNotNullOrEmpty(continueVal));
    
    // process the special case deletes
    resources.keySet().removeAll(next.keySet());
    resources.forEach((k, v) -> this.handler.onDelete(v, true));
    
    resources = next; 
    
    watch = listerWatcher.watch(
        new ListOptionsBuilder().withResourceVersion(resourceVersion).withAllowWatchBookmarks(true).build(), this);
  }
  
  @Override
  public boolean reconnecting() {
    return true;
  }

}
