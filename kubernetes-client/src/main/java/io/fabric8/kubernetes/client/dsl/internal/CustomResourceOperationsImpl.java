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

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.inferListType;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import okhttp3.OkHttpClient;

/**
 */
public class CustomResourceOperationsImpl<T extends HasMetadata, L extends KubernetesResourceList<T>> extends HasMetadataOperation<T, L, Resource<T>> implements MixedOperation<T, L, Resource<T>> {

  private final boolean resourceNamespaced;

  public CustomResourceOperationsImpl(OkHttpClient client, Config config) {
    this(new CustomResourceOperationContext().withOkhttpClient(client).withConfig(config));
  }

  public CustomResourceOperationsImpl(CustomResourceOperationContext context) {
    super(context.withApiGroupName(context.getCrdContext().getGroup())
      .withApiGroupVersion(context.getCrdContext().getVersion())
      .withPlural(context.getCrdContext().getPlural()));

    this.type = context.getType();
    this.listType = context.getListType() != null ? context.getListType() : (Class) inferListType(this.type);

    this.resourceNamespaced = resourceNamespaced(context.getCrdContext());
    this.apiVersion = ApiVersionUtil.joinApiGroupAndVersion(getAPIGroupName(), getAPIGroupVersion());

    KubernetesDeserializer.registerCustomKind(apiVersion, kind(context.getCrdContext()), type);
    if (KubernetesResource.class.isAssignableFrom(listType)) {
      KubernetesDeserializer.registerCustomKind(listType.getSimpleName(), (Class<? extends KubernetesResource>) listType);
    }
  }

  @Override
  public CustomResourceOperationsImpl newInstance(OperationContext context) {
    return new CustomResourceOperationsImpl((CustomResourceOperationContext) context);
  }

  protected static boolean resourceNamespaced(CustomResourceDefinitionContext crdContext) {
    return "Namespaced".equals(crdContext.getScope());
  }

  private String kind(CustomResourceDefinitionContext crdContext) {
    return crdContext.getKind() != null ? crdContext.getKind() : getKind();
  }

  @Override
  public boolean isResourceNamespaced() {
    return resourceNamespaced;
  }
}
