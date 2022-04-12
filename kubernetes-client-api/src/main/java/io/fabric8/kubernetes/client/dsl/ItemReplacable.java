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

public interface ItemReplacable<T> {

  /**
   * Similar to calling resource(item).replaceStatus()
   * <br>
   * See {@link Replaceable#replace()}
   *
   * @param item replacement
   * @return the replaced item from the api server
   */
  T replaceStatus(T item);

  /**
   * Similar to calling resource(item).replace()
   * <br>
   * See {@link Replaceable#replace()}
   *
   * @param item replacement
   * @return the replaced item from the api server
   */
  T replace(T item);

}
