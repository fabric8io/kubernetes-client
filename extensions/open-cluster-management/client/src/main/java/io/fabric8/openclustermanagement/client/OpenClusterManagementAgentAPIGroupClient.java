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
package io.fabric8.openclustermanagement.client;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfig;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAgentAPIGroupDSL;

public class OpenClusterManagementAgentAPIGroupClient extends ClientAdapter<OpenClusterManagementAgentAPIGroupClient>
    implements OpenClusterManagementAgentAPIGroupDSL {

  @Override
  public OpenClusterManagementAgentAPIGroupClient newInstance() {
    return new OpenClusterManagementAgentAPIGroupClient();
  }

  @Override
  public MixedOperation<KlusterletAddonConfig, KlusterletAddonConfigList, Resource<KlusterletAddonConfig>> klusterletAddonConfigs() {
    return resources(KlusterletAddonConfig.class, KlusterletAddonConfigList.class);
  }
}
