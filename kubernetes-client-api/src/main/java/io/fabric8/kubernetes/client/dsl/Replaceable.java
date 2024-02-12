/*
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

public interface Replaceable<T> extends Updatable<T> {

  /**
   * Similar to {@link Replaceable#replace()}, but only affects the status subresource
   *
   * @return returns deserialized version of api server response
   *
   * @deprecated use {@link #updateStatus()} instead
   *
   * @see <a href=
   *      "https://github.com/fabric8io/kubernetes-client/blob/main/doc/FAQ.md#alternatives-to-createOrReplace-and-replace"
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

}
