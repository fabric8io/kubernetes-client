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

/**
 * ResourceEventHandler can handle notifications for events that
 * happen to a resource. The events are information only, so you can't
 * return an error.
 *
 * @param <T> resource
 */
public interface ResourceEventHandler<T> {

  /**
   * Called after an empty list is retrieved on start or after an HTTP GONE when the {@link Store} is empty
   */
  default void onNothing() {

  }

  /**
   * Called when an object is added.
   *
   * @param obj object
   */
  void onAdd(T obj);

  /**
   * Called when an object is modified. Note that oldObj is the last
   * known state of the object -- it is possible that several changes
   * were combined together, so you can't use this to see every single
   * change. It is also called when a sync happens - oldObj will be
   * the same as newObj.
   *
   * @param oldObj old object
   * @param newObj new object
   */
  void onUpdate(T oldObj, T newObj);

  /**
   * Gets the final state of the item if it is known, otherwise
   * it would get an object of the DeletedFinalStateUnknown. This can
   * happen if the watch is closed and misses the delete event and
   * we don't notice the deletion until the subsequent re-list.
   *
   * @param obj object to delete
   * @param deletedFinalStateUnknown get final state of item if it is known or not.
   */
  void onDelete(T obj, boolean deletedFinalStateUnknown);

}
