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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

public class NamespacedCreateOnlyResourceOperationsImpl<I, O> extends CreateOnlyResourceOperationsImpl<I, O> implements NamespacedInOutCreateable<I, O> {
  private final Class<O> outputClass;
  private final String resourceApiGroupName;
  private final String resourceApiGroupVersion;
  private final String plural;

  public NamespacedCreateOnlyResourceOperationsImpl(OkHttpClient client, Config config, String resourceApiGroupName, String resourceApiGroupVersion, String plural, Class<O> outputClass) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config), resourceApiGroupName, resourceApiGroupVersion, plural, outputClass);
  }

  public NamespacedCreateOnlyResourceOperationsImpl(OperationContext context, String resourceApiGroupName, String resourceApiGroupVersion, String plural, Class<O> outputClass) {
    super(context, resourceApiGroupName, resourceApiGroupVersion, plural, outputClass);
    this.outputClass = outputClass;
    this.resourceApiGroupName = resourceApiGroupName;
    this.resourceApiGroupVersion = resourceApiGroupVersion;
    this.plural = plural;
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<I, O> inNamespace(String namespace) {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(context.withNamespace(namespace), resourceApiGroupName, resourceApiGroupVersion, plural, outputClass);
  }

  @Override
  public boolean isResourceNamespaced() {
    return true;
  }
}
