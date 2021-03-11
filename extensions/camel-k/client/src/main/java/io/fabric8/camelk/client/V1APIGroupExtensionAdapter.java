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

import io.fabric8.kubernetes.client.APIGroupExtensionAdapter;
import io.fabric8.kubernetes.client.Client;
import okhttp3.OkHttpClient;

public class V1APIGroupExtensionAdapter extends APIGroupExtensionAdapter<V1APIGroupClient> {
  @Override
  protected String getAPIGroupName() {
    return "v1";
  }

  @Override
  public Class<V1APIGroupClient> getExtensionType() {
    return V1APIGroupClient.class;
  }

  @Override
  protected V1APIGroupClient newInstance(Client client) {
    return new V1APIGroupClient(client.adapt(OkHttpClient.class), client.getConfiguration());
  }
}
