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
package io.fabric8.knative.client.serving.v1;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;

public class ServingV1ExtensionAdapter implements ExtensionAdapter<ServingV1Client> {

  @Override
  public Class<ServingV1Client> getExtensionType() {
    return ServingV1Client.class;
  }

  @Override
  public ServingV1Client adapt(Client client) {
    return new DefaultServingV1Client(client);
  }

}
