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

public interface InformerExceptionHandler {

  public enum EventType {
    /**
     * an exception that occurs trying to perform the list or watch operation. The default handling is to log the exception.
     */
    LIST_OR_WATCH,
    /**
     * an exception that occurs invoking a {@link ResourceEventHandler} method. The default handling is to log the exception.
     */
    HANDLER
  }

  /**
   * Determine if the informer should stop given from a non-http gone WatchException cause.
   * <p>
   * The default behavior is to terminate as we cannot guarantee if the state is still correct
   *
   * @param t the non-http gone WatchException cause
   * @return true if the informer should stop, false if it should attempt to keep running
   */
  default boolean shouldStop(Throwable t) {
    return true;
  }

  /**
   * Override the default handling of exceptions seen while the informer is running.
   * <p>
   * If you want to stop the informer as a side-effect of this call, then construct your implementation
   * of this class with a reference to the informer then call the stop method.
   */
  void onException(EventType eventType, Throwable t);

  /**
   * Called after each time the list, sync and watch operations have been successful.
   */
  default void onWatching() {

  }

}
