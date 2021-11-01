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

import io.fabric8.kubernetes.client.APIGroupExtensionAdapter;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1alpha3APIGroupExtensionAdapter extends APIGroupExtensionAdapter<V1alpha3APIGroupClient> {
  @Override
  protected String getAPIGroupName() {
    return "v1alpha3";
  }

  @Override
  public Class<V1alpha3APIGroupClient> getExtensionType() {
    return V1alpha3APIGroupClient.class;
  }

  @Override
  protected V1alpha3APIGroupClient newInstance(Client client) {
    return new V1alpha3APIGroupClient(client.adapt(HttpClient.class), client.getConfiguration());
  }
}
