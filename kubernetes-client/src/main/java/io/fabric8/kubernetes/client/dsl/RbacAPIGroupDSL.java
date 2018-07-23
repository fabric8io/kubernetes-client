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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.rbac.DoneableKubernetesClusterRole;
import io.fabric8.kubernetes.api.model.rbac.DoneableKubernetesClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRole;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleList;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRole;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleList;
import io.fabric8.kubernetes.api.model.rbac.DoneableKubernetesRole;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.DoneableKubernetesRoleBinding;
import io.fabric8.kubernetes.client.Client;

public interface RbacAPIGroupDSL extends Client{

  MixedOperation<KubernetesRole, KubernetesRoleList, DoneableKubernetesRole, Resource<KubernetesRole, DoneableKubernetesRole>> kubernetesRoles();

  MixedOperation<KubernetesRoleBinding, KubernetesRoleBindingList, DoneableKubernetesRoleBinding, Resource<KubernetesRoleBinding, DoneableKubernetesRoleBinding>> kubernetesRoleBindings();

  MixedOperation<KubernetesClusterRole, KubernetesClusterRoleList, DoneableKubernetesClusterRole, Resource<KubernetesClusterRole, DoneableKubernetesClusterRole>> kubernetesClusterRoles();

  MixedOperation<KubernetesClusterRoleBinding, KubernetesClusterRoleBindingList, DoneableKubernetesClusterRoleBinding, Resource<KubernetesClusterRoleBinding, DoneableKubernetesClusterRoleBinding>> kubernetesClusterRoleBindings();

}
