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
package io.fabric8.kubernetes.client;

import okhttp3.OkHttpClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class AppsAPIGroupExtensionAdapter extends APIGroupExtensionAdapter<AppsAPIGroupClient> {

  @Override
  protected String getAPIGroupName() {
    return "apps";
  }

  @Override
  public Class<AppsAPIGroupClient> getExtensionType() {
    return AppsAPIGroupClient.class;
  }

  @Override
  protected AppsAPIGroupClient newInstance(Client client) {
    return new AppsAPIGroupClient(client.adapt(OkHttpClient.class), client.getConfiguration());
  }

}
