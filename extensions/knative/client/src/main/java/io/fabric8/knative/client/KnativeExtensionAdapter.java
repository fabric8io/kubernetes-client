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
package io.fabric8.knative.client;

import io.fabric8.knative.client.serving.v1.DefaultServingV1Client;
import io.fabric8.knative.client.serving.v1.ServingV1Client;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;

public class KnativeExtensionAdapter implements ExtensionAdapter<KnativeClient> {

  @Override
  public Class<KnativeClient> getExtensionType() {
    return KnativeClient.class;
  }

  @Override
  public KnativeClient adapt(Client client) {
    return new DefaultKnativeClient(client);
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(ServingV1Client.class, new DefaultServingV1Client());
  }

}
