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

import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.api.model.DoneableSecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.TreeMap;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.SECURITY;

public class SecurityContextConstraintsOperationsImpl  extends OpenShiftOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, Resource<SecurityContextConstraints, DoneableSecurityContextConstraints>> {

  public SecurityContextConstraintsOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public SecurityContextConstraintsOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(SECURITY)
      .withPlural("securitycontextconstraints"));
    this.type = SecurityContextConstraints.class;
    this.listType = SecurityContextConstraintsList.class;
    this.doneableType = DoneableSecurityContextConstraints.class;
  }

  @Override
  public SecurityContextConstraintsOperationsImpl newInstance(OperationContext context) {
    return new SecurityContextConstraintsOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
