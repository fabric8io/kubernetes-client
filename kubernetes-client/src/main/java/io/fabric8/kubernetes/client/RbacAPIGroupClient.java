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
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.rbac.v1.ClusterRoleBindingOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.rbac.v1.ClusterRoleOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.rbac.v1.RoleBindingOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.rbac.v1.RoleOperationsImpl;
import okhttp3.OkHttpClient;

public class RbacAPIGroupClient extends BaseClient implements RbacAPIGroupDSL {

  public RbacAPIGroupClient() {
    super();
  }

  public RbacAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Role, RoleList, Resource<Role>> roles() {
    return new RoleOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> roleBindings() {
    return new RoleBindingOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<ClusterRole, ClusterRoleList, Resource<ClusterRole>> clusterRoles() {
    return new ClusterRoleOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> clusterRoleBindings() {
    return new ClusterRoleBindingOperationsImpl(httpClient, getConfiguration());
  }
}
