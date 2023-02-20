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

package io.fabric8.kubernetes.client.extension;

import io.fabric8.kubernetes.client.Client;

/**
 * Marks the client as being able to test for its own support.
 * <p>
 * Moving forward only clients with special support needs, such as
 * the openshift client should implement this interface. For those classes,
 * this interface can be part of the public contract.
 *
 * @deprecated will be removed in future versions
 */
@Deprecated
public interface SupportTestingClient extends Client {

  /**
   * Tests if the client is supported.
   * <br>
   * Implementations will use
   * {@link Client#hasApiGroup(String, boolean)} to be compatible with mock support
   *
   * @return true if supported
   *
   * @deprecated use {@link Client#supports(Class)} or {@link Client#supports(String, String)} instead
   */
  @Deprecated
  boolean isSupported();

}
