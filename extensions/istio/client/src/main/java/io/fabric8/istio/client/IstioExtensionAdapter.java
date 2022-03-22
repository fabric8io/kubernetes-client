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
package io.fabric8.istio.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;

public class IstioExtensionAdapter implements ExtensionAdapter<IstioClient> {

  @Override
  public Class<IstioClient> getExtensionType() {
    return IstioClient.class;
  }

  @Override
  public IstioClient adapt(Client client) {
    return new DefaultIstioClient(client);
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(V1beta1APIGroupDSL.class, new V1beta1APIGroupClient());
    factory.register(V1alpha3APIGroupDSL.class, new V1alpha3APIGroupClient());
  }

}
