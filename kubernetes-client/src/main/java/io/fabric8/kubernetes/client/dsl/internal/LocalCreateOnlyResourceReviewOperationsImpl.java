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
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

public class LocalCreateOnlyResourceReviewOperationsImpl<T> extends CreateOnlyResourceOperationsImpl<T> implements Namespaceable<LocalCreateOnlyResourceReviewOperationsImpl<T>> {
  private Class<T> subjectAccessRequestClass;
  private String subjectAccessApiGroupName;
  private String subjectAccessApiGroupVersion;
  private String plural;

  public LocalCreateOnlyResourceReviewOperationsImpl(OkHttpClient client, Config config, String subjectAccessApiGroupName, String subjectAccessApiGroupVersion, String plural, Class<T> subjectAccessRequestClass) {
    super(client, config, subjectAccessApiGroupName, subjectAccessApiGroupVersion, plural, subjectAccessRequestClass);
    this.subjectAccessRequestClass = subjectAccessRequestClass;
    this.subjectAccessApiGroupName = subjectAccessApiGroupName;
    this.subjectAccessApiGroupVersion = subjectAccessApiGroupVersion;
    this.plural = plural;
  }

  public LocalCreateOnlyResourceReviewOperationsImpl(OperationContext context, String subjectAccessApiGroupName, String subjectAccessApiGroupVersion, String plural, Class<T> subjectAccessRequestClass) {
    super(context, subjectAccessApiGroupName, subjectAccessApiGroupVersion, plural, subjectAccessRequestClass);
    this.subjectAccessRequestClass = subjectAccessRequestClass;
    this.subjectAccessApiGroupName = subjectAccessApiGroupName;
    this.subjectAccessApiGroupVersion = subjectAccessApiGroupVersion;
    this.plural = plural;
  }

  @Override
  public LocalCreateOnlyResourceReviewOperationsImpl<T> inNamespace(String namespace) {
    this.namespace = namespace;
    return new LocalCreateOnlyResourceReviewOperationsImpl<>(context.withNamespace(namespace), subjectAccessApiGroupName, subjectAccessApiGroupVersion, plural, subjectAccessRequestClass);
  }

  @Override
  public boolean isResourceNamespaced() {
    return true;
  }
}
