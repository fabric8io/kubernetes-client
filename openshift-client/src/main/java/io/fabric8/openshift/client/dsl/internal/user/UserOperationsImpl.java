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
package io.fabric8.openshift.client.dsl.internal.user;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserBuilder;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;
import okhttp3.OkHttpClient;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.USER;

public class UserOperationsImpl extends OpenShiftOperation<User, UserList, Resource<User>> {

  public UserOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public UserOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(USER)
      .withPlural("users"));
    this.type = User.class;
    this.listType = UserList.class;
  }

  @Override
  public UserOperationsImpl newInstance(OperationContext context) {
    return new UserOperationsImpl(context);
  }

  @Override
  protected VisitableBuilder<User, ?> createVisitableBuilder(User item) {
    return new UserBuilder(item);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
