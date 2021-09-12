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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Informable<T> {
  
  /**
   * The indexers to add to {@link SharedInformer}s created by subsequent inform calls;
   * @param indexers to customize the indexing
   * @return the current {@link Informable}
   */
  Informable<T> withIndexers(Map<String, Function<T, List<String>>> indexers);
  
  /**
   * Similar to a {@link Watch}, but will attempt to handle failures after successfully started.
   * and provides a store of all the current resources.
   * <p>This returned informer will not support resync.
   * <p>This call will be blocking for the initial list and watch.
   * <p>You are expected to call stop to terminate the underlying Watch.
   * <p>Additional handlers can be added, but processing of the events will be in the websocket thread, 
   * so consider non-blocking handler operations for more than one handler.
   * 
   * @return a running {@link SharedIndexInformer}
   */
  default SharedIndexInformer<T> inform() {
    return inform(null, 0);
  }
  
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
  default SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler) {
    return inform(handler, 0);
  }
  
  /**
   * Similar to a {@link Watch}, but will attempt to handle failures after successfully started.
   * and provides a store of all the current resources.
   * <p>This call will be blocking for the initial list and watch.
   * <p>You are expected to call stop to terminate the underlying Watch.
   * <p>Additional handlers can be added, but processing of the events will be in the websocket thread, 
   * so consider non-blocking handler operations for more than one handler.
   * 
   * @param handler to notify
   * @param resync the resync period or 0 for no resync
   * @return a running {@link SharedIndexInformer}
   */
  SharedIndexInformer<T> inform(ResourceEventHandler<? super T> handler, long resync);
  
  /**
   * Return a {@link Future} when the list at this context satisfies the given {@link Predicate}.
   * The predicate will be tested against the state of the underlying informer store on every event.
   * The returned future should be cancelled by the caller if not waiting for completion to close the underlying informer
   * @param condition the {@link Predicate} to test
   * @return a {@link CompletableFuture} of the list of items after the condition is met
   */
  CompletableFuture<List<T>> informOnCondition(Predicate<List<T>> condition);

}
