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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Replaceable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 */
public class CustomResourceOperationsImpl<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>> extends HasMetadataOperation<T, L, D,
    Resource<T, D>> implements MixedOperation<T, L, D, Resource<T, D>> {

  private final boolean resourceNamespaced;

  public CustomResourceOperationsImpl(OkHttpClient client, Config config) {
    this(new CustomResourceOperationContext().withOkhttpClient(client).withConfig(config));
  }

  public CustomResourceOperationsImpl(CustomResourceOperationContext context) {
    super(context.withApiGroupName(apiGroup((CustomResourceDefinition) context.getCrd()))
      .withApiGroupVersion(apiVersion((CustomResourceDefinition) context.getCrd()))
      .withPlural(resourceT((CustomResourceDefinition) context.getCrd())));

    this.type = context.getType();
    this.listType = context.getListType();
    this.doneableType = context.getDoneableType();

    this.resourceNamespaced = resourceNamespaced((CustomResourceDefinition) context.getCrd());
    this.apiVersion = getAPIGroup() + "/" + getAPIVersion();

    KubernetesDeserializer.registerCustomKind(type.getSimpleName(), type);
    if (KubernetesResource.class.isAssignableFrom(listType)) {
      KubernetesDeserializer.registerCustomKind(listType.getSimpleName(), (Class<? extends KubernetesResource>) listType);
    }
  }

  @Override
  public CustomResourceOperationsImpl newInstance(OperationContext context) {
    return new CustomResourceOperationsImpl((CustomResourceOperationContext) context);
  }

  protected static String apiGroup(CustomResourceDefinition crd) {
    return crd.getSpec().getGroup();
  }

  protected static String apiVersion(CustomResourceDefinition crd) {
    return crd.getSpec().getVersion();
  }

  protected static String resourceT(CustomResourceDefinition crd) {
    return crd.getSpec().getNames().getPlural();
  }

  protected static String name(CustomResourceDefinition crd) {
    return crd.getMetadata().getName();
  }

  protected static boolean resourceNamespaced(CustomResourceDefinition crd) {
    return "Namespaced".equals(crd.getSpec().getScope());
  }

  @Override
  public boolean isResourceNamespaced() {
    return resourceNamespaced;
  }
}
