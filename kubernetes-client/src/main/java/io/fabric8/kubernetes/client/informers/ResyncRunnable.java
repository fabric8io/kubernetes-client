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
import io.fabric8.kubernetes.client.informers.cache.DeltaFIFO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Calls the resync function of store interface which is always implemented
 * by DeltaFIFO.
 */
public class ResyncRunnable<T extends HasMetadata> implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(ResyncRunnable.class);

  private DeltaFIFO<T> store;
  private Supplier<Boolean> shouldResyncFunc;

  public ResyncRunnable(DeltaFIFO<T> store, Supplier<Boolean> shouldResyncFunc) {
    this.store = store;
    this.shouldResyncFunc = shouldResyncFunc;
  }

  @Override
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
