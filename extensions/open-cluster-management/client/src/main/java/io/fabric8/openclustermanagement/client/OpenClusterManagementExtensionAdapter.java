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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAgentAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAppsAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementClustersAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementDiscoveryAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementObservabilityAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementOperatorAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementPolicyAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementSearchAPIGroupDSL;

public class OpenClusterManagementExtensionAdapter implements ExtensionAdapter<OpenClusterManagementClient> {

  @Override
  public Class<OpenClusterManagementClient> getExtensionType() {
    return OpenClusterManagementClient.class;
  }

  @Override
  public OpenClusterManagementClient adapt(Client client) {
    return new DefaultOpenClusterManagementClient(client);
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(OpenClusterManagementAppsAPIGroupDSL.class, new OpenClusterManagementAppsAPIGroupClient());
    factory.register(OpenClusterManagementAgentAPIGroupDSL.class, new OpenClusterManagementAgentAPIGroupClient());
    factory.register(OpenClusterManagementClustersAPIGroupDSL.class, new OpenClusterManagementClustersAPIGroupClient());
    factory.register(OpenClusterManagementDiscoveryAPIGroupDSL.class, new OpenClusterManagementDiscoveryAPIGroupClient());
    factory.register(OpenClusterManagementObservabilityAPIGroupDSL.class,
        new OpenClusterManagementObservabilityAPIGroupClient());
    factory.register(OpenClusterManagementOperatorAPIGroupDSL.class, new OpenClusterManagementOperatorAPIGroupClient());
    factory.register(OpenClusterManagementPolicyAPIGroupDSL.class, new OpenClusterManagementPolicyAPIGroupClient());
    factory.register(OpenClusterManagementSearchAPIGroupDSL.class, new OpenClusterManagementSearchAPIGroupClient());
  }
}
