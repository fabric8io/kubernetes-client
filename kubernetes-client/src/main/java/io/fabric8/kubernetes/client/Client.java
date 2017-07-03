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

import io.fabric8.kubernetes.api.model.RootPaths;

import java.io.Closeable;
import java.net.URL;

public interface Client extends ConfigAware, Closeable {

  /**
   * Checks if the client can be adapted to an other client type.
   * @param type  The target client class.
   * @param <C>   The target client type.
   * @return      Returns true if a working {@link io.fabric8.kubernetes.client.ExtensionAdapter} is found.
   */
  <C> Boolean  isAdaptable(Class<C> type);

  <C> C adapt(Class<C> type);

  URL getMasterUrl();

  String getApiVersion();

  String getNamespace();

  RootPaths rootPaths();

  /**
   * Returns true if this cluster supports the given API path or API Group ID
   * @param path
   * @return
   */
  boolean supportsApiPath(String path);

  void close();
}
