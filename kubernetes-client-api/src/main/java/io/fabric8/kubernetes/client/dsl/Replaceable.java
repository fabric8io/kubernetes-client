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

public interface Replaceable<T> {

  /**
   * Replace the server's state with the given item.
   *
   * <p>
   * If {@link Lockable#lockResourceVersion(String)} has been used to lock the resourceVersion,
   * this operation is effectively a single update attempt against that version.
   * <p>
   * If {@link Lockable#lockResourceVersion(String)} has not been called, this operation
   * will be retried a number of times in the event of a conflict. If a resourceVersion has been set
   * on the item, the first update attempt will be made against that version. Subsequent attempts will fetch
   * the latest resourceVersion from the server.
   *
   * @return returns deserialized version of api server response
   */
  T replace();

}
