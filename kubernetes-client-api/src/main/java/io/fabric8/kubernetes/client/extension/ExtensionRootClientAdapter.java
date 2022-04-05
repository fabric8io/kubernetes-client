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
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

/**
 * A specialized {@link ClientAdapter} that has constructors for fully creating the client.
 * <br>
 * It must be handled with an {@link ExtensionAdapter}
 */
public abstract class ExtensionRootClientAdapter<C extends ClientAdapter<C>> extends ClientAdapter<C> {

  protected ExtensionRootClientAdapter() {
    this(new KubernetesClientBuilder().build());
  }

  protected ExtensionRootClientAdapter(Config configuration) {
    this(new KubernetesClientBuilder().withConfig(configuration).build());
  }

  protected ExtensionRootClientAdapter(Client client) {
    init(client);
  }

  @Override
  public final C newInstance() {
    return newInstance(getClient());
  }

  /**
   * Extension root adapters new instances should be created
   * without creating a new client
   */
  protected abstract C newInstance(Client client);

}
