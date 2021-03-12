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

package io.fabric8.kubernetes.client.dsl.base;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class HasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> extends BaseOperation< T, L, R> {
  public static final DeletionPropagation DEFAULT_PROPAGATION_POLICY = DeletionPropagation.BACKGROUND;
  public static final long DEFAULT_GRACE_PERIOD_IN_SECONDS = -1L;

  public HasMetadataOperation(OperationContext ctx) {
    super(ctx);
  }

  @Override
  public T edit(UnaryOperator<T> function) {
    T item = getMandatory();
    return patch(function.apply(item));
  }

  @Override
  public T accept(Consumer<T> consumer) {
    T item = getMandatory();
    consumer.accept(item);
    return patch(item);
  }

  @Override
  public T replace(T item) {
    String fixedResourceVersion = getResourceVersion();
    Exception caught = null;
    int maxTries = 10;
    for (int i = 0; i < maxTries; i++) {
      try {
        final String resourceVersion;
        if (fixedResourceVersion != null) {
          resourceVersion = fixedResourceVersion;
        } else {
          T got = fromServer().get();
          if (got == null) {
            return null;
          }
          if (got.getMetadata() != null) {
            resourceVersion = got.getMetadata().getResourceVersion();
          } else {
            resourceVersion = null;
          }
        }

        final UnaryOperator<T> visitor = resource -> {
          try {
            resource.getMetadata().setResourceVersion(resourceVersion);
            return handleReplace(resource);
          } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(forOperationType("replace"), e);
          }
        };
        return visitor.apply(item);
      } catch (KubernetesClientException e) {
        caught = e;
        // Only retry if there's a conflict and using dynamic resource version - this is normally to do with resource version & server updates.
        if (e.getCode() != 409 || fixedResourceVersion != null) {
          break;
        }
        if (i < maxTries - 1) {
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e1) {
            // Ignore this... would only hide the proper exception
            // ...but make sure to preserve the interrupted status
            Thread.currentThread().interrupt();
          }
        }
      } catch (Exception e) {
        caught = e;
      }
    }
    throw KubernetesClientException.launderThrowable(forOperationType("replace"), caught);
  }

  public T patch(T item) {
    Exception caught = null;
    int maxTries = 10;
    for (int i = 0; i < maxTries; i++) {
      try {
        String resourceVersion;
        final T got = fromServer().get();
        if (got == null) {
          return null;
        }
        if (got.getMetadata() != null) {
          resourceVersion = got.getMetadata().getResourceVersion();
        } else {
          resourceVersion = null;
        }
        final UnaryOperator<T> visitor = resource -> {
          try {
            resource.getMetadata().setResourceVersion(resourceVersion);
            return handlePatch(got, resource);
          } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(forOperationType("patch"), e);
          }
        };
        return visitor.apply(item);
      } catch (KubernetesClientException e) {
        caught = e;
        // Only retry if there's a conflict - this is normally to do with resource version & server updates.
        if (e.getCode() != 409) {
          break;
        }
        if (i < maxTries - 1) {
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e1) {
            // Ignore this... would only hide the proper exception
            // ...but make sure to preserve the interrupted status
            Thread.currentThread().interrupt();
          }
        }
      } catch (Exception e) {
        caught = e;
      }
    }
    throw KubernetesClientException.launderThrowable(forOperationType("patch"), caught);
  }
}
