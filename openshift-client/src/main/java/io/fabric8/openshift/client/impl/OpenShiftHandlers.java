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

package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;

public final class OpenShiftHandlers {

  private OpenShiftHandlers() {
    // Utility
  }

  public static <I extends KubernetesResource, O extends KubernetesResource> CreateOnlyResourceOperationsImpl<I, O> getCreateOnlyResourceOperation(
      Class<I> inputType, Class<O> outputType, Client client) {
    return new CreateOnlyResourceOperationsImpl<>(client, ResourceDefinitionContext.fromResourceType(inputType), inputType,
        outputType);
  }

}
