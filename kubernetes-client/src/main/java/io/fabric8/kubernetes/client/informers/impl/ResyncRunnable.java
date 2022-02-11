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

import io.fabric8.kubernetes.client.informers.impl.cache.SyncableStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Calls the resync function of store interface which is always implemented
 * by DeltaFIFO.
 */
public class ResyncRunnable<T> implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(ResyncRunnable.class);

  private SyncableStore<T> store;
  private Supplier<Boolean> shouldResyncFunc;

  public ResyncRunnable(SyncableStore<T> store, Supplier<Boolean> shouldResyncFunc) {
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
