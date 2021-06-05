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
package io.fabric8.openshift.client.dsl.internal.authorization;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.ClusterRoleBindingBuilder;
import io.fabric8.openshift.api.model.ClusterRoleBindingList;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;
import okhttp3.OkHttpClient;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class ClusterRoleBindingOperationsImpl extends OpenShiftOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> {

  public ClusterRoleBindingOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ClusterRoleBindingOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION)
      .withPlural("clusterrolebindings"));
    this.type = ClusterRoleBinding.class;
    this.listType = ClusterRoleBindingList.class;
  }

  @Override
  public ClusterRoleBindingOperationsImpl newInstance(OperationContext context) {
    return new ClusterRoleBindingOperationsImpl(context);
  }

  @Override
  protected VisitableBuilder<ClusterRoleBinding, ?> createVisitableBuilder(ClusterRoleBinding item) {
    return new ClusterRoleBindingBuilder(item);
  }
}
