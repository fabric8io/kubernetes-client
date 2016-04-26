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


/**
 * An Adapter that can be used to adapt an instance of the {@link NamespacedKubernetesClient} to an {@link io.fabric8.kubernetes.client.Extension}.
 *
 * @param <C> The Client.
 */
public interface ExtensionAdapter<C> {

  /**
   * @return The concrete class of the {@link io.fabric8.kubernetes.client.Client}.
   */
  Class<C> getExtensionType();

  /**
   * Checks if it is possible to adapt.
   * It checks that the requirements of the target client are meet. (e.g. checks that openshift is available).
   * @param client The instance of {@link NamespacedKubernetesClient} to adapt.
   * @return
   */
  Boolean isAdaptable(Client client);

  /**
   * The adapt function.
   *
   * @param client The instance of {@link NamespacedKubernetesClient} to adapt.
   * @return The instance of the {@link io.fabric8.kubernetes.client.Client}.
   */
  C adapt(Client client);
}
