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
import io.fabric8.openshift.api.model.DoneableRole;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class RoleOperationsImpl extends OpenShiftOperation<Role, RoleList, DoneableRole, Resource<Role, DoneableRole>> {

  public RoleOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this((new OperationContext()).withOkhttpClient(client).withConfig(config));
  }

  public RoleOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION).withApiGroupVersion("v1").withPlural("roles"));
    this.type = Role.class;
    this.listType = RoleList.class;
    this.doneableType = DoneableRole.class;
  }

  @Override
  public RoleOperationsImpl newInstance(OperationContext context) {
    return new RoleOperationsImpl(context);
  }

}
