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
   * See {@link Replaceable#replace()}
   *
   * @param item replacement
   * @return the replaced item from the api server
   * @deprecated use resource(item).replaceStatus()
   */
  @Deprecated
  T replaceStatus(T item);

  /**
   * See {@link Replaceable#replace()}
   *
   * @param item replacement
   * @return the replaced item from the api server
   * @deprecated use resource(item).replace()
   */
  @Deprecated
  T replace(T item);

}
