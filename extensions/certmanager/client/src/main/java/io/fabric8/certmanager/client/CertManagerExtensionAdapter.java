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
package io.fabric8.certmanager.client;

import io.fabric8.certmanager.client.dsl.V1APIGroupDSL;
import io.fabric8.certmanager.client.dsl.V1alpha2APIGroupDSL;
import io.fabric8.certmanager.client.dsl.V1alpha3APIGroupDSL;
import io.fabric8.certmanager.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;

public class CertManagerExtensionAdapter implements ExtensionAdapter<CertManagerClient> {

  @Override
  public Class<CertManagerClient> getExtensionType() {
    return CertManagerClient.class;
  }

  @Override
  public CertManagerClient adapt(Client client) {
    return new DefaultCertManagerClient(client);
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(V1alpha2APIGroupDSL.class, new V1alpha2APIGroupClient());
    factory.register(V1alpha3APIGroupDSL.class, new V1alpha3APIGroupClient());
    factory.register(V1beta1APIGroupDSL.class, new V1beta1APIGroupClient());
    factory.register(V1APIGroupDSL.class, new V1APIGroupClient());
  }

}
