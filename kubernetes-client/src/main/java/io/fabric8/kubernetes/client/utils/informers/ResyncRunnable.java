package io.fabric8.kubernetes.client.utils.informers;

import io.fabric8.kubernetes.client.utils.informers.cache.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Calls the resync function of store interface which is always implemented
 * by DeltaFIFO.
 */
public class ResyncRunnable<T> implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(ResyncRunnable.class);

  private Store<T> store;
  private Supplier<Boolean> shouldResyncFunc;

  public ResyncRunnable(Store<T> store, Supplier<Boolean> shouldResyncFunc) {
    this.store = store;
    this.shouldResyncFunc = shouldResyncFunc;
  }

  public void run() {
    if (log.isDebugEnabled()) {
      log.debug("ResyncRunnable#resync .. ..");
    }

    if (shouldResyncFunc == null || shouldResyncFunc.get()) {
      if (log.isDebugEnabled()) {
        log.debug("ResyncRunnable#force resync");
      }

      this.store.resync();
    }
  }
}
