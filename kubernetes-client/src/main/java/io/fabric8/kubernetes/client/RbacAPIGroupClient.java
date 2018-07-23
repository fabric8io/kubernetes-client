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
import io.fabric8.kubernetes.client.dsl.internal.KubernetesClusterRoleBindingOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesClusterRoleOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesRoleOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesRoleBindingOperationsImpl;
import okhttp3.OkHttpClient;

public class RbacAPIGroupClient extends BaseClient implements RbacAPIGroupDSL {

  public RbacAPIGroupClient() throws KubernetesClientException {
    super();
  }

  public RbacAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<KubernetesRole, KubernetesRoleList, DoneableKubernetesRole, Resource<KubernetesRole, DoneableKubernetesRole>> kubernetesRoles() {
    return new KubernetesRoleOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<KubernetesRoleBinding, KubernetesRoleBindingList, DoneableKubernetesRoleBinding, Resource<KubernetesRoleBinding, DoneableKubernetesRoleBinding>> kubernetesRoleBindings() {
    return new KubernetesRoleBindingOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<KubernetesClusterRole, KubernetesClusterRoleList, DoneableKubernetesClusterRole, Resource<KubernetesClusterRole, DoneableKubernetesClusterRole>> kubernetesClusterRoles() {
    return new KubernetesClusterRoleOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<KubernetesClusterRoleBinding, KubernetesClusterRoleBindingList, DoneableKubernetesClusterRoleBinding, Resource<KubernetesClusterRoleBinding, DoneableKubernetesClusterRoleBinding>> kubernetesClusterRoleBindings() {
    return new KubernetesClusterRoleBindingOperationsImpl(httpClient, getConfiguration());
  }
}
