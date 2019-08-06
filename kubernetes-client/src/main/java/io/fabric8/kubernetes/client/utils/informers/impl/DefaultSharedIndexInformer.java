package io.fabric8.kubernetes.client.utils.informers.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.informers.ListerWatcher;
import io.fabric8.kubernetes.client.utils.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.utils.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.utils.informers.cache.Cache;
import io.fabric8.kubernetes.client.utils.informers.cache.Controller;
import io.fabric8.kubernetes.client.utils.informers.cache.DeltaFIFO;
import io.fabric8.kubernetes.client.utils.informers.cache.Indexer;
import io.fabric8.kubernetes.client.utils.informers.cache.ProcessorListener;
import io.fabric8.kubernetes.client.utils.informers.cache.SharedProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class DefaultSharedIndexInformer<T extends HasMetadata, TList extends KubernetesResourceList<T>> implements SharedIndexInformer<T> {
  private static final Logger log = LoggerFactory.getLogger(DefaultSharedIndexInformer.class);

  private static final long MINIMUM_RESYNC_PERIOD_MILLIS = 1000L;

  // resyncCheckPeriod is how often we want the reflector's resync timer to fire so it can
  // call shouldResync to check if any of our listeners need a resync.
  private long resyncCheckPeriodMillis;

  // defaultEventHandlerResyncPeriod is the default resync period for any handlers added via
  // AddEventHandler(i.e they don't specify one and just want to use the shared informer's default
  // value).
  private long defaultEventHandlerResyncPeriod;

  private Indexer<T> indexer;

  private SharedProcessor<T> processor;

  private Controller<T, TList> controller;

  private Thread controllerThread;

  private volatile boolean started = false;
  private volatile boolean stopped = false;

  public DefaultSharedIndexInformer(Class<T> apiTypeClass, ListerWatcher listerWatcher, long resyncPeriod, BaseOperation<T, TList, ?, ?> baseOperation, OperationContext context) {
    this.resyncCheckPeriodMillis = resyncPeriod;
    this.defaultEventHandlerResyncPeriod = resyncPeriod;

    this.processor = new SharedProcessor<>();
    this.indexer = new Cache();

    DeltaFIFO<T> fifo = new DeltaFIFO<T>(Cache::metaNamespaceKeyFunc, this.indexer);

    this.controller = new Controller<T, TList>(apiTypeClass, fifo, listerWatcher, this::handleDeltas, processor::shouldResync, resyncCheckPeriodMillis, baseOperation, context);
    controllerThread = new Thread(controller::run);
  }

  /**
   * add event callback
   *
   * @param handler event handler
   */
  @Override
  public void addEventHandler(ResourceEventHandler<T> handler) {
    addEventHandlerWithResyncPeriod(handler, defaultEventHandlerResyncPeriod);
  }

  @Override
  public void addEventHandlerWithResyncPeriod(ResourceEventHandler<T> handler, long resyncPeriodMillis) {
    if (stopped) {
      log.info("DefaultSharedIndexInformer#Handler was not added to shared informer because it has stopped already");
      return;
    }

    if (resyncPeriodMillis > 0) {
      if (resyncPeriodMillis < MINIMUM_RESYNC_PERIOD_MILLIS) {
        log.warn("DefaultSharedIndexInformer#resyncPeriod {} is too small. Chanding it to minimul allowed rule of {}", resyncPeriodMillis, MINIMUM_RESYNC_PERIOD_MILLIS);
        resyncPeriodMillis = MINIMUM_RESYNC_PERIOD_MILLIS;
      }

      if (resyncPeriodMillis < this.resyncCheckPeriodMillis) {
        if (started) {
          log.warn("DefaultSharedIndexInformer#resyncPeriod {} is smaller than resyncCheckPeriod {} and the informer has already started. Changing it to {}", resyncPeriodMillis, resyncCheckPeriodMillis);
          resyncPeriodMillis = resyncCheckPeriodMillis;
        } else {
          // if the event handler's resyncPeriod is smaller than the current resyncCheckPeriod
          // update resyncCheckPeriod to match resyncPeriod and adjust the resync periods of all
          // the listeners accordingly.
          this.resyncCheckPeriodMillis = resyncPeriodMillis;
        }
      }
    }

    ProcessorListener<T> listener = new ProcessorListener(handler, determineResyncPeriod(resyncCheckPeriodMillis, this.resyncCheckPeriodMillis));
    System.out.println("adding listeners");
//    if (!started) {
//      System.out.println("this.processor.addListener(" + listener + " )");
//      this.processor.addListener(listener);
//      return;
//    }

    this.processor.addAndStartListener(listener);
    List<T> objectList = this.indexer.list();
    for (Object item : objectList) {
      listener.add(new ProcessorListener.AddNotification(item));
    }
  }

  @Override
  public String lastSyncResourceVersion() {
    if (!started) {
      return "";
    }
    return this.controller.lastSyncResourceVersion();
  }

  @Override
  public void run() {
    if (started) {
      return;
    }

    started = true;

    System.out.println("Processor::run()");
    this.processor.run();
    controllerThread.start();
  }

  @Override
  public void stop() {
    if (!started) {
      return;
    }

    stopped = true;
    controller.stop();
    controllerThread.interrupt();

    processor.stop();
  }

  @Override
  public boolean hasSynced() {
    return controller != null && this.controller.hasSynced();
  }

  /**
   * Handles deltas and call processor distribute
   *
   * @param deltas deltas
   */
  private void handleDeltas(Deque<AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object>> deltas) {
    if (deltas == null || deltas.isEmpty()) {
      return;
    }

    // from oldest to newest
    for (AbstractMap.SimpleEntry<DeltaFIFO.DeltaType, Object> delta : deltas) {
      DeltaFIFO.DeltaType deltaType = delta.getKey();

      switch (deltaType) {
        case SYNCHRONIZATION:
        case ADDITION:
        case UPDATION:
          boolean isSync = (deltaType == DeltaFIFO.DeltaType.SYNCHRONIZATION);
          Object oldObj = this.indexer.get((T) delta.getValue());
          if (oldObj != null) {
            this.indexer.update((T) delta.getValue());
            this.processor.distribute(new ProcessorListener.UpdateNotification(oldObj, delta.getValue()), isSync);
          } else {
            this.indexer.add((T) delta.getValue());
            this.processor.distribute(new ProcessorListener.AddNotification(delta.getValue()), isSync);
          }
          break;
        case DELETION:
          if (!(delta.getValue() instanceof DeltaFIFO.DeletedFinalStateUnknown)) {
            this.indexer.delete((T) delta.getValue());
          }
          this.processor.distribute(new ProcessorListener.DeleteNotification(delta.getValue()), false);
          break;
      }
    }
  }

  @Override
  public void addIndexers(Map indexers) {
    throw new RuntimeException("unimplemented!");
  }


  @Override
  public Indexer getIndexer() {
    return this.indexer;
  }

  private long determineResyncPeriod(long desired, long check) {
    if (desired == 0) {
      return desired;
    }

    if (check == 0) {
      return 0;
    }
    return desired < check ? check : desired;
  }
}
