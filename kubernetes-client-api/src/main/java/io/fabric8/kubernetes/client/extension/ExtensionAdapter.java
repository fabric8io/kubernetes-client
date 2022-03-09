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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.Client;

import java.util.function.Supplier;

/**
 * An Adapter that can be used to adapt an instance of the {@link Client} .
 *
 * @param <C> The Client.
 */
public interface ExtensionAdapter<C extends Client> {

  public interface HandlerFactory {
    <T extends HasMetadata, R extends ExtensibleResourceAdapter<T>> void register(Class<T> type, Supplier<R> target);
  }

  /**
   * @return The concrete class of the {@link io.fabric8.kubernetes.client.Client}.
   */
  Class<C> getExtensionType();

  /**
   * Checks that the requirements of the target client are meet. (e.g. checks that openshift is available).
   * @param client The instance of {@link Client}.
   * @return boolean value indicating whether this extension is supported
   */
  default boolean isSupported(Client client) {
    return true;
  }

  /**
   * Adapt the client to another type.  This will not perform any check of whether the new client
   * type is supported.  It may even return the same object if it already supports the given
   * client type.
   *
   * @param client The instance of {@link Client} to adapt.
   * @return The refined instance of the {@link Client}.
   */
  C adapt(Client client);

  /**
   * Extensions should override to inject {@link ExtensibleResourceAdapter} usage into the {@link HandlerFactory}
   * @param factory
   */
  default void registerHandlers(HandlerFactory factory) {}

}
