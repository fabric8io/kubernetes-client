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
package io.fabric8.volcano.client;

import io.fabric8.kubernetes.client.APIGroupExtensionAdapter;
import io.fabric8.kubernetes.client.Client;
import okhttp3.OkHttpClient;

public class V1beta1APIGroupExtensionAdapter extends APIGroupExtensionAdapter<V1beta1APIGroupClient> {
  @Override
  protected String getAPIGroupName() {
    return "v1beta1";
  }

  @Override
  public Class<V1beta1APIGroupClient> getExtensionType() {
    return V1beta1APIGroupClient.class;
  }

  @Override
  protected V1beta1APIGroupClient newInstance(Client client) {
    return new V1beta1APIGroupClient(client.adapt(OkHttpClient.class), client.getConfiguration());
  }
}
