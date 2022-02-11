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
package io.fabric8.openshift.client.dsl.internal.core;

import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinition;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionList;
import io.fabric8.openshift.client.OpenshiftClientContext;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;

public class NetworkAttachmentDefinitionOperationsImpl extends OpenShiftOperation<NetworkAttachmentDefinition, NetworkAttachmentDefinitionList, Resource<NetworkAttachmentDefinition>> {

  public NetworkAttachmentDefinitionOperationsImpl(OpenshiftClientContext clientContext) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext));
  }

  public NetworkAttachmentDefinitionOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("k8s.cni.cncf.io")
      .withApiGroupVersion("v1")
      .withPlural("network-attachment-definitions"), NetworkAttachmentDefinition.class, NetworkAttachmentDefinitionList.class);
  }

  @Override
  public NetworkAttachmentDefinitionOperationsImpl newInstance(OperationContext context) {
    return new NetworkAttachmentDefinitionOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return true;
  }
}

