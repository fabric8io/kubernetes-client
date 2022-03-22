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

import io.fabric8.camelk.client.dsl.V1APIGroupDSL;
import io.fabric8.camelk.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;

public class CamelKExtensionAdapter implements ExtensionAdapter<CamelKClient> {

  @Override
  public Class<CamelKClient> getExtensionType() {
    return CamelKClient.class;
  }

  @Override
  public CamelKClient adapt(Client client) {
    return new DefaultCamelKClient(client);
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(V1APIGroupDSL.class, new V1APIGroupClient());
    factory.register(V1alpha1APIGroupDSL.class, new V1alpha1APIGroupClient());
  }

}
