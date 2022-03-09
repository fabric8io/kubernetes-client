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
package io.fabric8.camelk.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;

public class V1alpha1APIGroupExtensionAdapter implements ExtensionAdapter<V1alpha1APIGroupClient> {

  @Override
  public Class<V1alpha1APIGroupClient> getExtensionType() {
    return V1alpha1APIGroupClient.class;
  }

  @Override
  public V1alpha1APIGroupClient adapt(Client client) {
    return new V1alpha1APIGroupClient(client);
  }
}
