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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateOnlyResourceOperation<I, O> extends OperationSupport implements InOutCreateable<I, O> {
  protected Class<O> type;

  protected CreateOnlyResourceOperation(OperationContext ctx) {
    super(ctx);
  }

  public Class<O> getType() {
    return type;
  }

  protected O handleCreate(I resource) throws ExecutionException, InterruptedException, IOException {
    return handleCreate(resource, getType());
  }

  @Override
  public O create(I item) {
    try {
      return handleCreate(item);
    } catch (ExecutionException | IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ie);
    }
  }

}
