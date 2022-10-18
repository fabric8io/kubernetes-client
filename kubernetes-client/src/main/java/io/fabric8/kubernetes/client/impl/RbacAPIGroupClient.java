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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.RoleList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class RbacAPIGroupClient extends ClientAdapter<RbacAPIGroupClient> implements RbacAPIGroupDSL {

  @Override
  public MixedOperation<Role, RoleList, Resource<Role>> roles() {
    return resources(Role.class, RoleList.class);
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> roleBindings() {
    return resources(RoleBinding.class, RoleBindingList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterRole, ClusterRoleList, Resource<ClusterRole>> clusterRoles() {
    return resources(ClusterRole.class, ClusterRoleList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> clusterRoleBindings() {
    return resources(ClusterRoleBinding.class, ClusterRoleBindingList.class);
  }

  @Override
  public RbacAPIGroupClient newInstance() {
    return new RbacAPIGroupClient();
  }
}
