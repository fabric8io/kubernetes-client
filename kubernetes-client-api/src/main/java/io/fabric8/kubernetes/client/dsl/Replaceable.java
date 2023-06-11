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
   * If {@link Resource#lockResourceVersion(String)} has been used to lock the resourceVersion,
   * this operation is effectively a single update attempt against that version.
   * <p>
   * If {@link Resource#lockResourceVersion(String)} has not been called, this operation
   * will be retried a number of times in the event of a conflict. If a resourceVersion has been set
   * on the item, the first update attempt will be made against that version. Subsequent attempts will fetch
   * the latest resourceVersion from the server.
   *
   * @return returns deserialized version of api server response
   *
   * @deprecated use {@link #update()} instead
   *
   * @see <a href=
   *      "https://github.com/fabric8io/kubernetes-client/blob/master/doc/FAQ.md#alternatives-to-createOrReplace-and-replace"
   *      >Migration FAQ</a>
   */
  @Deprecated
  T replace();

  /**
   * Similar to {@link Replaceable#replace()}, but only affects the status subresource
   *
   * @return returns deserialized version of api server response
   *
   * @deprecated use {@link #updateStatus()} instead
   *
   * @see <a href=
   *      "https://github.com/fabric8io/kubernetes-client/blob/master/doc/FAQ.md#alternatives-to-createOrReplace-and-replace"
   *      >Migration FAQ</a>
   */
  @Deprecated
  T replaceStatus();

  /**
   * Similar to {@link Replaceable#update()}, but only affects the status subresource
   *
   * @return returns deserialized version of api server response
   */
  T updateStatus();

  /**
   * Update the server's state with the given item (PUT).
   * <p>
   * If the resourceVersion is on the resource, the update will be performed with optimistic locking, and may
   * result in a conflict (409 error). If no resourceVersion is on the resource, the latest resourceVersion will
   * be obtained from the server prior to the update call - which may still be a conflict in a rare circumstance.
   *
   * @return returns deserialized version of api server response
   */
  T update();

}
