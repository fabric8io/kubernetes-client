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

import io.fabric8.kubernetes.client.informers.cache.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BooleanSupplier;

/**
 * Calls the resync function of store interface which is always implemented
 * by DeltaFIFO.
 */
public class ResyncRunnable<T> implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(ResyncRunnable.class);

  private Store<T> store;
  private BooleanSupplier shouldResyncFunc;

  public ResyncRunnable(Store<T> store, BooleanSupplier shouldResyncFunc) {
    this.store = store;
    this.shouldResyncFunc = shouldResyncFunc;
  }

  public void run() {
    if (log.isDebugEnabled()) {
      log.debug("ResyncRunnable#resync .. ..");
    }

    // TODO if there is a concern that this processing could overwhelm the single
    // thread, then hand this off to the common pool
    if (shouldResyncFunc == null || shouldResyncFunc.getAsBoolean()) {
      if (log.isDebugEnabled()) {
        log.debug("ResyncRunnable#force resync");
      }

      this.store.resync();
    }
  }
}
