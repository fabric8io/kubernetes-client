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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.client.dsl.internal.OpenShiftCreateOnlyResourceNonNamespaceOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftCreateOnlyResourceOperationsImpl<I, O> extends OpenShiftCreateOnlyResourceNonNamespaceOperationsImpl<I, O> implements InOutCreateable<I, O>, Namespaceable<OpenShiftCreateOnlyResourceOperationsImpl<I, O>> {
  private final String subjectAccessApiGroupName;
  private final String subjectAccessApiGroupVersion;
  private final String plural;
  private final Class<O> responseClass;

  public OpenShiftCreateOnlyResourceOperationsImpl(OkHttpClient client, Config config, String apiGroupName, String apiGroupVersion, String plural, Class<O> responseClass) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config), apiGroupName, apiGroupVersion, plural, responseClass);
  }

  public OpenShiftCreateOnlyResourceOperationsImpl(OperationContext context, String apiGroupName, String apiGroupVersion, String plural, Class<O> responseClass) {
    super(context.withApiGroupName(apiGroupName)
      .withApiGroupVersion(apiGroupVersion)
      .withPlural(plural), apiGroupName, apiGroupVersion, plural, responseClass);
    this.subjectAccessApiGroupName = apiGroupName;
    this.subjectAccessApiGroupVersion = apiGroupVersion;
    this.plural = plural;
    this.responseClass = responseClass;
  }

  @Override
  public OpenShiftCreateOnlyResourceOperationsImpl<I, O> inNamespace(String namespace) {
    return new OpenShiftCreateOnlyResourceOperationsImpl<>(context.withNamespace(namespace), subjectAccessApiGroupName, subjectAccessApiGroupVersion, this.plural, responseClass);
  }

  @Override
  public boolean isResourceNamespaced() {
    return true;
  }
}

