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
package io.fabric8.kubernetes.client;

import org.slf4j.LoggerFactory;

public interface Watcher<T> {

  /**
   * If the Watcher can reconnect itself after an error
   * 
   * @return
   */
  default boolean reconnecting() {
    return false;
  }

  /**
   * Handle the given event.
   * <p>
   * Should not be implemented with long-running logic as this method is called directly from
   * an IO thread.
   */
  void eventReceived(Action action, T resource);

  /**
   * Invoked when the watcher is gracefully closed.
   */
  default void onClose() {
    LoggerFactory.getLogger(Watcher.class).debug("Watcher closed");
  }

  /**
   * Invoked when the watcher closes due to an Exception.
   * <p>
   * Should not be implemented with long-running logic as this method is called directly from
   * an IO thread.
   * 
   * @param cause What caused the watcher to be closed.
   */
  void onClose(WatcherException cause);

  enum Action {
    ADDED,
    MODIFIED,
    DELETED,
    ERROR,
    BOOKMARK
  }

}
