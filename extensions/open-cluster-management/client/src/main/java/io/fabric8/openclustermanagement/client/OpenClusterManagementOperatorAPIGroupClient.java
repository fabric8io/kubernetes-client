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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHub;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubList;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManager;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerList;
import io.fabric8.openclustermanagement.api.model.operator.v1.Klusterlet;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementOperatorAPIGroupDSL;

public class OpenClusterManagementOperatorAPIGroupClient extends BaseClient implements OpenClusterManagementOperatorAPIGroupDSL {

  public OpenClusterManagementOperatorAPIGroupClient() {
    super();
  }

  public OpenClusterManagementOperatorAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public MixedOperation<MultiClusterHub, MultiClusterHubList, Resource<MultiClusterHub>> multiClusterHubs() {
    return Handlers.getOperation(MultiClusterHub.class, MultiClusterHubList.class, this);
  }

  @Override
  public NonNamespaceOperation<Klusterlet, KlusterletList, Resource<Klusterlet>> klusterlets() {
    return Handlers.getOperation(Klusterlet.class, KlusterletList.class, this);
  }

  @Override
  public NonNamespaceOperation<ClusterManager, ClusterManagerList, Resource<ClusterManager>> clusterManagers() {
    return Handlers.getOperation(ClusterManager.class, ClusterManagerList.class, this);
  }
}

