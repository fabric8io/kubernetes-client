package io.fabric8.kubernetes.client.utils.informers;

/**
 * SharedInformer defines basic methods of an informer.
 */
public interface SharedInformer<T> {

  /**
   * Add event handler
   *
   * @param handler event handler
   */
  void addEventHandler(ResourceEventHandler<T> handler);

  /**
   * Adds an event handler to the shared informer using the specified resync period.
   * Events to a single handler are delivered sequentially, but there is no
   * coordination between different handlers.
   *
   * @param handle the event handler
   * @param resyncPeriod the specific resync period
   */
  void addEventHandlerWithResyncPeriod(ResourceEventHandler<T> handle, long resyncPeriod);

  /**
   * Starts the shared informer, which will be stopped until stop() is called.
   */
  void run();

  /**
   * Stops the shared informer.
   */
  void stop();

  boolean hasSynced();

  /**
   * The resource version observed when last synced with the underlying store.
   * The value returned is not synchronized with access to the underlying store
   * and is not thread-safe.
   *
   * @return string value
   */
  String lastSyncResourceVersion();
}
