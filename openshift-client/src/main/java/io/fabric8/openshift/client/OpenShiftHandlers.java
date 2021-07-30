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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import okhttp3.OkHttpClient;

import java.util.function.BiFunction;

public final class OpenShiftHandlers {

  private OpenShiftHandlers() {
    // Utility
  }

  public static <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> void register(
      Class<T> type, BiFunction<OkHttpClient, OpenShiftConfig, HasMetadataOperation<T, L, R>> operationConstructor) {
    Handlers.register(type, (o, c) -> operationConstructor.apply(o, OpenShiftConfig.wrap(c)));
  }

  public static <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> HasMetadataOperation<T, L, R> getOperation(
      Class<T> type, Class<L> listType, OkHttpClient client, OpenShiftConfig config) {
    return Handlers.getOperation(type, listType, client, config);
  }

  public static <I extends KubernetesResource, O extends KubernetesResource> CreateOnlyResourceOperationsImpl<I, O> getCreateOnlyResourceOperation(
      Class<I> inputType, Class<O> outputType, OkHttpClient client, OpenShiftConfig config) {
    return new CreateOnlyResourceOperationsImpl<>(client, config, ResourceDefinitionContext.fromResourceType(inputType), inputType, outputType);
  }

}
