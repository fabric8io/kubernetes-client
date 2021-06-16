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
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateOnlyResourceOperationsImpl<I, O> extends OperationSupport implements InOutCreateable<I, O> {
  private final Class<O> outputClassType;

  public CreateOnlyResourceOperationsImpl(OkHttpClient client, Config config, String apiGroupName, String apiGroupVersion, String plural, Class<O> outputClassType) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config), apiGroupName, apiGroupVersion, plural, outputClassType);
  }

  public CreateOnlyResourceOperationsImpl(OperationContext context, String apiGroupName, String apiGroupVersion, String plural, Class<O> outputClassType) {
    super(context.withApiGroupName(apiGroupName)
      .withApiGroupVersion(apiGroupVersion)
      .withPlural(plural));
    this.outputClassType = outputClassType;
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

  @Override
  public O create(I... resources) {
    try {
      if (resources.length > 1) {
        throw new IllegalArgumentException("Too many items to create.");
      } else if (resources.length == 1) {
        return handleCreate(resources[0], outputClassType);
      } else {
        return handleCreate(getItem(), outputClassType);
      }
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    }
  }

  @Override
  public O create(I item) {
    try {
      return handleCreate(item, outputClassType);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    }
  }

  public I getItem() {
    return (I) context.getItem();
  }
}
