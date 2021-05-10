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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static io.fabric8.kubernetes.client.utils.IOHelpers.convertToJson;

public class HasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> extends BaseOperation< T, L, R> {
  private static final String NO_BUILDER = "Cannot edit with visitors, no builder is associated";
  
  public static final DeletionPropagation DEFAULT_PROPAGATION_POLICY = DeletionPropagation.BACKGROUND;
  public static final long DEFAULT_GRACE_PERIOD_IN_SECONDS = -1L;
  private static final String PATCH_OPERATION = "patch";

  public HasMetadataOperation(OperationContext ctx) {
    super(ctx);
  }

  @Override
  public T edit(UnaryOperator<T> function) {
    T item = getMandatory();
    return patch(Serialization.clone(item), function.apply(item), false);
  }

  @Override
  public T accept(Consumer<T> consumer) {
    T item = getMandatory();
    T clone = Serialization.clone(item);
    consumer.accept(item);
    return patch(clone, item, false);
  }
  
  protected VisitableBuilder<T, ?> createVisitableBuilder(T item) {
    throw new KubernetesClientException(NO_BUILDER);
  }
  
  @Override
  public T edit(Visitor... visitors) {
    T item = getMandatory();
    T clone = Serialization.clone(item);
    return patch(clone, createVisitableBuilder(item).accept(visitors).build(), false);
  }
  
  /**
   * Get the current item from the server, consulting the metadata for the name if needed
   */
  protected Gettable<T> fromServer(ObjectMeta metadata) {
    if (getName() != null) {
      return fromServer();
    }
    if (metadata != null) {
      return withName(metadata.getName()).fromServer();
    }
    throw new KubernetesClientException("Name not specified. But operation requires name.");
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
          T got = fromServer(item.getMetadata()).get();
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
            return handleReplace(resource, false);
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

  @Override
  public T patch(T item) {
    return patch(fromServer(item.getMetadata()).get(), item, false);
  }
  
  @Override
  public T patch(T base, T item) {
      return patch(base, item, false);
  }

  public T patch(T base, T item, boolean status) {
    final UnaryOperator<T> visitor = resource -> {
      try {
        if (base != null) {
          if (item.getMetadata() == null) {
            item.setMetadata(new ObjectMeta());
          }
          if (base.getMetadata() != null) {
            item.getMetadata().setResourceVersion(base.getMetadata().getResourceVersion());  
          }
        }  
        return handlePatch(base, resource, status);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), e);
      }
    };
    return visitor.apply(item);
  }
  
  @Override
  public T applyStatus(T item) {
    return patch(null, item, true);
  }

  @Override
  public T patch(PatchContext patchContext, String patch) {
    try {
      final T got = fromServer().get();
      if (got == null) {
        return null;
      }
      return handlePatch(patchContext, got, convertToJson(patch), getType(), false);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), interruptedException);
    } catch (IOException | ExecutionException e) {
      throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), e);
    }
  }
}
