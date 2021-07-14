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
package io.fabric8.kubernetes.client.dsl.internal.apps.v1;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;

/**
 * Operations for resources that represent scalable, rolling-updatable sets of Pods.
 */
public abstract class RollableScalableResourceOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
  extends HasMetadataOperation<T, L, R> implements RollableScalableResource<T> {

  private static final Logger Log = LoggerFactory.getLogger(RollableScalableResourceOperation.class);

  final boolean rolling;
  final long rollingTimeout;
  final TimeUnit rollingTimeUnit;

  public RollableScalableResourceOperation(RollingOperationContext context) {
    super(context);
    this.rolling = context.getRolling();
    this.rollingTimeout = context.getRollingTimeout();
    this.rollingTimeUnit = context.getRollingTimeUnit();
  }

  protected abstract T withReplicas(int count);
  protected abstract RollingUpdater<T, L> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit);

  // There are no common interfaces through which we could get these values.
  protected abstract int getCurrentReplicas(T current);
  protected abstract int getDesiredReplicas(T item);
  protected abstract long getObservedGeneration(T current);

  @Override
  public T scale(int count) {
    return scale(count, false);
  }

  @Override
  public T scale(int count, boolean wait) {
    T res = withReplicas(count);
    if (wait) {
      res = waitUntilScaled(count);
      if (res == null) {
        res = getMandatory();
      }
    }
    return res;
  }

  @Override
  public Scale scale() {
    return handleScale(null);
  }

  @Override
  public Scale scale(Scale scaleParam) {
    return handleScale(scaleParam);
  }

  /**
   * Let's wait until there are enough Ready pods.
   */
  private T waitUntilScaled(final int count) {
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    try {
      return waitUntilCondition(t -> {
          //If the resource is gone, we shouldn't wait.
          if (t == null) {
            if (count == 0) {
              return true;
            }
            throw new IllegalStateException("Can't wait for " + getType().getSimpleName() + ": " +name + " in namespace: " + namespace + " to scale. Resource is no longer available.");
          }
          int currentReplicas = getCurrentReplicas(t);
          int desiredReplicas = getDesiredReplicas(t);
          replicasRef.set(currentReplicas);
          long generation = t.getMetadata().getGeneration() != null ? t.getMetadata().getGeneration() : -1;
          long observedGeneration = getObservedGeneration(t);
          if (observedGeneration >= generation && Objects.equals(desiredReplicas, currentReplicas)) {
            return true;
          }
          Log.debug("Only {}/{} replicas scheduled for {}: {} in namespace: {} seconds so waiting...",
            currentReplicas, desiredReplicas, t.getKind(), t.getMetadata().getName(), namespace);
          return false;
        }, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS);
    } catch (KubernetesClientTimeoutException e) {
      Log.error("{}/{} pod(s) ready for {}: {} in namespace: {}  after waiting for {} seconds so giving up",
          replicasRef.get(), count, getType().getSimpleName(), name, namespace, TimeUnit.MILLISECONDS.toSeconds(getConfig().getScaleTimeout()));
      return null;
    }
  }

  @Override
  public T edit(UnaryOperator<T> function) {
    if (!rolling) {
      return super.edit(function);
    }
    try {
        T oldObj = getMandatory();
        T newObj = function.apply(oldObj);
        return getRollingUpdater(rollingTimeout, rollingTimeUnit).rollUpdate(oldObj, newObj);
    } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public T replace(T t) {
    if (!rolling) {
      return super.replace(t);
    }
    return getRollingUpdater(rollingTimeout, rollingTimeUnit).rollUpdate(getMandatory(), t);
  }

  @Override
  public T patch(PatchContext patchContext, T item) {
    if (!rolling  || patchContext == null || patchContext.getPatchType() != PatchType.JSON) {
      return super.patch(patchContext, item);
    }
    return getRollingUpdater(rollingTimeout, rollingTimeUnit).rollUpdate(getMandatory(), item);
  }

}
