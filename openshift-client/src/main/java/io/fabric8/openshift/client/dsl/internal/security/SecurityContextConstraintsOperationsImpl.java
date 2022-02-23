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
package io.fabric8.openshift.client.dsl.internal.security;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.client.OpenshiftClientContext;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.SECURITY;

public class SecurityContextConstraintsOperationsImpl  extends OpenShiftOperation<SecurityContextConstraints, SecurityContextConstraintsList, Resource<SecurityContextConstraints>> {

  public SecurityContextConstraintsOperationsImpl(OpenshiftClientContext clientContext) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext));
  }

  public SecurityContextConstraintsOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(SECURITY)
      .withPlural("securitycontextconstraints"), SecurityContextConstraints.class, SecurityContextConstraintsList.class);
  }

  @Override
  public SecurityContextConstraintsOperationsImpl newInstance(OperationContext context) {
    return new SecurityContextConstraintsOperationsImpl(context);
  }

  @Override
  protected VisitableBuilder<SecurityContextConstraints, ?> createVisitableBuilder(SecurityContextConstraints item) {
    return new SecurityContextConstraintsBuilder(item);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
