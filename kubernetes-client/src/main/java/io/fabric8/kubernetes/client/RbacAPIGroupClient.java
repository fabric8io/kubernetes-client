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

import io.fabric8.kubernetes.api.model.rbac.*;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.ClusterRoleBindingOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ClusterRoleOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.RoleBindingOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.RoleOperationsImpl;
import io.fabric8.kubernetes.api.model.rbac.DoneableRole;
import io.fabric8.kubernetes.api.model.rbac.DoneableRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.DoneableClusterRole;
import io.fabric8.kubernetes.api.model.rbac.DoneableClusterRoleBinding;
import okhttp3.OkHttpClient;

public class RbacAPIGroupClient extends BaseClient implements RbacAPIGroupDSL {

  public RbacAPIGroupClient() throws KubernetesClientException {
    super();
  }

  public RbacAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Role, RoleList, DoneableRole, Resource<Role, DoneableRole>> roles() {
    return new RoleOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, Resource<RoleBinding, DoneableRoleBinding>> roleBindings() {
    return new RoleBindingOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<ClusterRole, ClusterRoleList, DoneableClusterRole, Resource<ClusterRole, DoneableClusterRole>> clusterRoles() {
    return new ClusterRoleOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, DoneableClusterRoleBinding, Resource<ClusterRoleBinding, DoneableClusterRoleBinding>> clusterRoleBindings() {
    return new ClusterRoleBindingOperationsImpl(httpClient, getConfiguration());
  }
}
