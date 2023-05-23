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
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.autoscaling.v1.ScaleBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Scalable;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class HasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends BaseOperation<T, L, R> {

  private static final Logger LOGGER = LoggerFactory.getLogger(HasMetadataOperation.class);

  public static final DeletionPropagation DEFAULT_PROPAGATION_POLICY = DeletionPropagation.BACKGROUND;
  public static final long DEFAULT_GRACE_PERIOD_IN_SECONDS = -1L;
  private static final String PATCH_OPERATION = "patch";
  private static final String REPLACE_OPERATION = "replace";
  private static final String UPDATE_OPERATION = "update";

  public HasMetadataOperation(OperationContext ctx, Class<T> type, Class<L> listType) {
    super(ctx);
    this.type = type;
    this.listType = listType;
  }

  @Override
  public T edit(UnaryOperator<T> function) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    return patch(null, clone, function.apply(item));
  }

  private T clone(T item) {
    return this.getKubernetesSerialization().clone(item);
  }

  @Override
  public T editStatus(UnaryOperator<T> function) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    return statusSubresource().patch(null, clone, function.apply(item));
  }

  private HasMetadataOperation<T, L, R> statusSubresource() {
    return newInstance(context.withSubresource("status"));
  }

  @Override
  public T accept(Consumer<T> consumer) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    consumer.accept(item);
    return patch(null, clone, item);
  }

  @Override
  public T edit(Visitor... visitors) {
    T item = getItemOrRequireFromServer();
    T clone = clone(item);
    return patch(null, clone, context.getHandler(item).edit(item).accept(visitors).build());
  }

  @Override
  public T replace() {
    return handleReplace(getItem());
  }

  @Override
  public T replaceStatus() {
    return statusSubresource().replace();
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

  @Override
  public T update() {
    return this.update(getItem());
  }

  @Override
  public T updateStatus() {
    return statusSubresource().update();
  }

  protected T update(T item) {
    String existingResourceVersion = KubernetesResourceUtil.getResourceVersion(item);
    try {
      if (existingResourceVersion == null) {
        T got = requireFromServer();
        String resourceVersion = KubernetesResourceUtil.getResourceVersion(got);
        item = clone(item);
        item.getMetadata().setResourceVersion(resourceVersion);
      }
      return handleUpdate(item);
    } catch (KubernetesClientException e) {
      throw KubernetesClientException.launderThrowable(forOperationType(UPDATE_OPERATION), e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(forOperationType(UPDATE_OPERATION), e);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType(UPDATE_OPERATION), e);
    }
  }

  /**
   * base replace operation, which is effectively a forced update with retries
   */
  protected T handleReplace(T item) {
    String fixedResourceVersion = getResourceVersion();
    Exception caught = null;
    int maxTries = 10;
    item = clone(item);
    if (item.getMetadata() == null) {
      item.setMetadata(new ObjectMeta());
    }
    if (context.getSubresource() == null) {
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
            return handleUpdate(resource);
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
  protected T patch(PatchContext context, T base, T item) {
    if ((context == null || context.getPatchType() == PatchType.JSON) && base == null) {
      if (base == null) {
        base = requireFromServer();
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
        return handlePatch(context, theBase, resource);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(forOperationType(PATCH_OPERATION), e);
      }
    };
    return visitor.apply(item);
  }

  @Override
  public T patchStatus() {
    return statusSubresource().patch(PatchContext.of(PatchType.JSON_MERGE), null, getNonNullItem());
  }

  @Override
  public T patch() {
    return patch(null, null, getNonNullItem());
  }

  @Override
  public T patch(PatchContext patchContext) {
    return patch(patchContext, null, getNonNullItem());
  }

  @Override
  public T patchStatus(T item) {
    return statusSubresource().patch(PatchContext.of(PatchType.JSON_MERGE), getItem(), clone(item));
  }

  @Override
  public T patch(PatchContext patchContext, T item) {
    return patch(patchContext, getItem(), clone(item));
  }

  @Override
  public T patch(PatchContext patchContext, String patch) {
    try {
      final T got = getItemOrRequireFromServer();
      return handlePatch(patchContext, got, getKubernetesSerialization().convertToJson(patch), getType());
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

  @Override
  public T scale(int count) {
    // TODO: this could be a simple patch, rather than an edit
    // we're also not giving the user the option here of doing this as a locked operation
    // kubectl does support specifying the resourceVersion
    scale(new ScaleBuilder(scale()).editOrNewMetadata().withResourceVersion(null).endMetadata().editOrNewSpec()
        .withReplicas(count)
        .endSpec().build());
    if (context.getTimeout() > 0) {
      waitUntilScaled(count);
    }
    return get();
  }

  @Override
  public T scale(int count, boolean wait) {
    Scalable<T> scalable = this;
    if (wait) {
      scalable = this.withTimeoutInMillis(getRequestConfig().getScaleTimeout());
    }
    return scalable.scale(count);
  }

  @Override
  public Scale scale(Scale scaleParam) {
    return handleScale(scaleParam, Scale.class);
  }

  /**
   * Let's wait until there are enough Ready pods.
   */
  protected void waitUntilScaled(final int count) {
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    CompletableFuture<Void> completion = new CompletableFuture<>();
    Utils.scheduleWithVariableRate(completion, getOperationContext().getExecutor(), () -> {
      try {
        Scale scale = scale();
        int statusReplicas = Optional.ofNullable(scale.getStatus().getReplicas()).orElse(0);
        int specReplicas = Optional.ofNullable(scale.getSpec().getReplicas()).orElse(0);
        if (count == statusReplicas && count == specReplicas) {
          completion.complete(null);
        } else if (LOGGER.isDebugEnabled()) {
          LOGGER.debug("Only {}/{} replicas scheduled for {}: {} in namespace: {} seconds so waiting...",
              specReplicas, count, getKind(), getName(), namespace);
        }
      } catch (KubernetesClientException e) {
        completion.completeExceptionally(e);
      }
    }, 0, () -> 1, TimeUnit.SECONDS);

    if (!Utils.waitUntilReady(completion, this.context.getTimeout(), this.context.getTimeoutUnit())) {
      completion.complete(null);
      throw new KubernetesClientException(
          String.format("%s/%s pod(s) ready for %s: %s in namespace: %s  after waiting for %s seconds so giving up",
              replicasRef.get(), count, getType().getSimpleName(), name, namespace,
              this.context.getTimeoutUnit().toSeconds(this.context.getTimeout())));
    }
  }

}
