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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static io.fabric8.kubernetes.client.utils.IOHelpers.convertToJson;

public class HasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends BaseOperation<T, L, R> {
  public static final DeletionPropagation DEFAULT_PROPAGATION_POLICY = DeletionPropagation.BACKGROUND;
  public static final long DEFAULT_GRACE_PERIOD_IN_SECONDS = -1L;
  private static final String PATCH_OPERATION = "patch";
  private static final String REPLACE_OPERATION = "replace";

  public HasMetadataOperation(OperationContext ctx, Class<T> type, Class<L> listType) {
    super(ctx);
    this.type = type;
    this.listType = listType;
  }

  @Override
  public T edit(UnaryOperator<T> function) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    return patch(null, clone, function.apply(item), false);
  }

  private T clone(T item) {
    return Serialization.clone(item);
  }

  @Override
  public T editStatus(UnaryOperator<T> function) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    return patch(null, clone, function.apply(item), true);
  }

  @Override
  public T accept(Consumer<T> consumer) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    consumer.accept(item);
    return patch(null, clone, item, false);
  }

  @Override
  public T edit(Visitor... visitors) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    return patch(null, clone, context.getHandler(item).edit(item).accept(visitors).build(), false);
  }

  @Override
  public T replace() {
    return replace(getItem(), false);
  }

  @Override
  public T replaceStatus() {
    return replace(getItem(), true);
  }

  /**
   * Modify the item prior to a replace or a JSON patch diff
   *
   * @param current item from the server
   * @param item to be modified
   * @return the modified item
   */
  protected T modifyItemForReplaceOrPatch(Supplier<T> current, T item) {
    return item;
  }

  /**
   * base replace operation, which is effectively a forced update with retries
   */
  protected T replace(T item, boolean status) {
    String fixedResourceVersion = getResourceVersion();
    Exception caught = null;
    int maxTries = 10;
    item = clone(item);
    if (item.getMetadata() == null) {
      item.setMetadata(new ObjectMeta());
    }
    if (!status) {
      try {
        item = modifyItemForReplaceOrPatch(this::requireFromServer, item);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType(REPLACE_OPERATION), e);
      }
    }
    String existingResourceVersion = KubernetesResourceUtil.getResourceVersion(item);
    for (int i = 0; i < maxTries; i++) {
      try {
        final String resourceVersion;
        if (fixedResourceVersion != null) {
          resourceVersion = fixedResourceVersion;
        } else if (i == 0 && existingResourceVersion != null) {
          // if a resourceVersion is already there, try it first
          resourceVersion = existingResourceVersion;
        } else {
          T got = requireFromServer();
          resourceVersion = KubernetesResourceUtil.getResourceVersion(got);
        }

        final UnaryOperator<T> visitor = resource -> {
          try {
            resource.getMetadata().setResourceVersion(resourceVersion);
            return handleUpdate(resource, status);
          } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(forOperationType(REPLACE_OPERATION), e);
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
    throw KubernetesClientException.launderThrowable(forOperationType(REPLACE_OPERATION), caught);
  }

  /**
   * Perform a patch. If the base is not provided and one is required, it will
   * be fetched from the server.
   */
  protected T patch(PatchContext context, T base, T item, boolean status) {
    if (context == null || context.getPatchType() == PatchType.JSON) {
      if (base == null) {
        base = requireFromServer();
      }
      if (base.getMetadata() != null) {
        // prevent the resourceVersion from being modified in the patch
        if (item.getMetadata() == null) {
          item.setMetadata(new ObjectMeta());
        }
        item.getMetadata().setResourceVersion(base.getMetadata().getResourceVersion());
      }
      final T current = base;
      try {
        item = modifyItemForReplaceOrPatch(() -> current, item);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), e);
      }
    }
    final T theBase = base;
    final UnaryOperator<T> visitor = resource -> {
      try {
        return handlePatch(context, theBase, resource, status);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), e);
      }
    };
    return visitor.apply(item);
  }

  @Override
  public T patchStatus() {
    return patch(PatchContext.of(PatchType.JSON_MERGE), null, getNonNullItem(), true);
  }

  @Override
  public T patch() {
    return patch(null, null, getNonNullItem(), false);
  }

  @Override
  public T patch(PatchContext patchContext) {
    return patch(patchContext, null, getNonNullItem(), false);
  }

  @Override
  public T patchStatus(T item) {
    return patch(PatchContext.of(PatchType.JSON_MERGE), getItem(), clone(item), true);
  }

  @Override
  public T patch(PatchContext patchContext, T item) {
    return patch(patchContext, getItem(), clone(item), false);
  }

  @Override
  public T patch(PatchContext patchContext, String patch) {
    try {
      final T got = getItemOrRequireFromServer();
      return handlePatch(patchContext, got, convertToJson(patch), getType(), false);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), interruptedException);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), e);
    }
  }

  @Override
  public HasMetadataOperation<T, L, R> newInstance(OperationContext context) {
    return new HasMetadataOperation<>(context, type, listType);
  }

}
