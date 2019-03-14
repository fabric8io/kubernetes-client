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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;
import io.fabric8.openshift.api.model.OpenshiftClusterRoleBinding;
import io.fabric8.openshift.api.model.OpenshiftClusterRoleBindingList;
import io.fabric8.openshift.api.model.DoneableOpenshiftClusterRoleBinding;
import io.fabric8.openshift.client.OpenShiftConfig;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class OpenshiftClusterRoleBindingOperationsImpl extends OpenShiftOperation<OpenshiftClusterRoleBinding, OpenshiftClusterRoleBindingList, DoneableOpenshiftClusterRoleBinding, Resource<OpenshiftClusterRoleBinding, DoneableOpenshiftClusterRoleBinding>> {

  public OpenshiftClusterRoleBindingOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OpenshiftClusterRoleBindingOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION)
      .withPlural("clusterrolebindings"));
    this.type = OpenshiftClusterRoleBinding.class;
    this.listType = OpenshiftClusterRoleBindingList.class;
    this.doneableType = DoneableOpenshiftClusterRoleBinding.class;
  }

  @Override
  public OpenshiftClusterRoleBindingOperationsImpl newInstance(OperationContext context) {
    return new OpenshiftClusterRoleBindingOperationsImpl(context);
  }
}
