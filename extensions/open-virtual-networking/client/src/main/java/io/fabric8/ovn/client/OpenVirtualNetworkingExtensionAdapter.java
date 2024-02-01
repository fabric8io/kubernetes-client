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
package io.fabric8.ovn.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.ovn.client.dsl.V1OpenVirtualNetworkingAPIGroupDSL;

public class OpenVirtualNetworkingExtensionAdapter implements ExtensionAdapter<OpenVirtualNetworkingClient> {

  @Override
  public Class<OpenVirtualNetworkingClient> getExtensionType() {
    return OpenVirtualNetworkingClient.class;
  }

  @Override
  public OpenVirtualNetworkingClient adapt(Client client) {
    if (client.hasApiGroup("k8s.ovn.org", false)) {
      return new DefaultOpenVirtualNetworkingClient(client);
    }
    return null;
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(V1OpenVirtualNetworkingAPIGroupDSL.class, new V1OpenVirtualNetworkingAPIGroupClient());
  }
}
