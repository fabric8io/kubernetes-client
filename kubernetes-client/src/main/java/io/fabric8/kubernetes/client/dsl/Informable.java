package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedInformer;

public interface Informable<T> {
  
  /**
   * Similar to a {@link Watch}, but will attempt to handle failures after successfully started.
   * <br>This call will be blocking for the initial list and watch.
   * <br>You are expected to call stop to terminate the underlying Watch.
   * 
   * @param handler to notify
   * @param resync the resync period or 0 for no resync
   * @return a running {@link SharedInformer}
   */
  public SharedInformer<T> inform(ResourceEventHandler<T> handler, long resync);

}
