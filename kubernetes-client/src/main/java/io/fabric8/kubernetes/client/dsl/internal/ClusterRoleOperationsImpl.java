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
package io.fabric8.kubernetes.client.dsl.internal;


import io.fabric8.kubernetes.api.model.rbac.DoneableClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

public class ClusterRoleOperationsImpl extends HasMetadataOperation<ClusterRole, ClusterRoleList, DoneableClusterRole, Resource<ClusterRole, DoneableClusterRole>> {

  public ClusterRoleOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ClusterRoleOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("rbac.authorization.k8s.io")
      .withApiGroupVersion("v1")
      .withPlural("clusterroles"));
    this.type = ClusterRole.class;
    this.listType = ClusterRoleList.class;
    this.doneableType = DoneableClusterRole.class;
  }
  @Override
  public ClusterRoleOperationsImpl newInstance(OperationContext context) {
    return new ClusterRoleOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
