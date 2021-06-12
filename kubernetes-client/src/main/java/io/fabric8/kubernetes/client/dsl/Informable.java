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

package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Informable<T> {
  
  /**
   * The indexers to add to {@link SharedInformer}s created by subsequent inform calls;
   * @param indexers to customize the indexing
   * @return the current {@link Informable}
   */
  public Informable<T> withIndexers(Map<String, Function<T, List<String>>> indexers);
  
  /**
   * Similar to a {@link Watch}, but will attempt to handle failures after successfully started.
   * and provides a store of all the current resources.
   * <p>This returned informer will not support resync.
   * <p>This call will be blocking for the initial list and watch.
   * <p>You are expected to call stop to terminate the underlying Watch.
   * <p>Additional handlers can be added, but processing of the events will be in the websocket thread, 
   * so consider non-blocking handler operations for more than one handler.
   * 
   * @param handler to notify
   * @return a running {@link SharedIndexInformer}
   */
  default SharedIndexInformer<T> inform(ResourceEventHandler<T> handler) {
    return inform(handler, 0);
  }
  
  /**
   * Similar to a {@link Watch}, but will attempt to handle failures after successfully started.
   * and provides a store of all the current resources.
   * <p>This call will be blocking for the initial list and watch.
   * <p>You are expected to call stop to terminate the underlying Watch.
   * <p>Additional handlers can be added, but processing of the events will be in the websocket thread, 
   * so consider non-blocking handleroperations for more than one handler.
   * 
   * @param handler to notify
   * @param resync the resync period or 0 for no resync
   * @return a running {@link SharedIndexInformer}
   */
  public SharedIndexInformer<T> inform(ResourceEventHandler<T> handler, long resync);

}
