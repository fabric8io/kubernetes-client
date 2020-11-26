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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateOnlyResourceOperationsImpl<T> extends OperationSupport implements io.fabric8.kubernetes.client.dsl.Createable<T> {
  private final Class<T> subjectAccessRequestClass;

  public CreateOnlyResourceOperationsImpl(OkHttpClient client, Config config, String apiGroupName, String apiGroupVersion, String plural, Class<T> subjectAccessRequestClass) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config), apiGroupName, apiGroupVersion, plural, subjectAccessRequestClass);
  }

  public CreateOnlyResourceOperationsImpl(OperationContext context, String apiGroupName, String apiGroupVersion, String plural, Class<T> subjectAccessRequestClass) {
    super(context.withApiGroupName(apiGroupName)
      .withApiGroupVersion(apiGroupVersion)
      .withPlural(plural));
    this.subjectAccessRequestClass = subjectAccessRequestClass;
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

  @Override
  public T create(T... resources) {
    try {
      if (resources.length > 1) {
        throw new IllegalArgumentException("Too many items to create.");
      } else if (resources.length == 1) {
        return handleCreate(resources[0], subjectAccessRequestClass);
      } else {
        return handleCreate(getItem(), subjectAccessRequestClass);
      }
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    }
  }

  @Override
  public T create(T item) {
    try {
      return handleCreate(item, subjectAccessRequestClass);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    }
  }

  public T getItem() {
    return (T) context.getItem();
  }
}
