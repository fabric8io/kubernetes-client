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
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
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
      waitUntilScaled(count);
      res = getMandatory();
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
  private void waitUntilScaled(final int count) {
    final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    final Runnable tPoller = () -> {
      try {
        T t = get();
        //If the resource is gone, we shouldn't wait.
        if (t == null) {
          if (count == 0) {
            queue.put(true);
          } else {
            queue.put(new IllegalStateException("Can't wait for " + getType().getSimpleName() + ": " +name + " in namespace: " + namespace + " to scale. Resource is no longer available."));
          }
          return;
        }
        int currentReplicas = getCurrentReplicas(t);
        int desiredReplicas = getDesiredReplicas(t);
        replicasRef.set(currentReplicas);
        long generation = t.getMetadata().getGeneration() != null ? t.getMetadata().getGeneration() : -1;
        long observedGeneration = getObservedGeneration(t);
        if (observedGeneration >= generation && Objects.equals(desiredReplicas, currentReplicas)) {
          queue.put(true);
        }
        Log.debug("Only {}/{} replicas scheduled for {}: {} in namespace: {} seconds so waiting...",
          currentReplicas, desiredReplicas, t.getKind(), t.getMetadata().getName(), namespace);
      } catch (Throwable t) {
        Log.error("Error while waiting for resource to be scaled.", t);
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(tPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
    try {
      if (Utils.waitUntilReady(queue, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS)) {
        Log.debug("{}/{} pod(s) ready for {}: {} in namespace: {}.",
          replicasRef.get(), count, getType().getSimpleName(), name, namespace);
      } else {
        Log.error("{}/{} pod(s) ready for {}: {} in namespace: {}  after waiting for {} seconds so giving up",
          replicasRef.get(), count, getType().getSimpleName(), name, namespace, TimeUnit.MILLISECONDS.toSeconds(getConfig().getScaleTimeout()));
      }
    } finally {
      poller.cancel(true);
      executor.shutdown();
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
  public T patch(T base, T item) {
    if (!rolling) {
      return super.patch(base, item);
    }
    return getRollingUpdater(rollingTimeout, rollingTimeUnit).rollUpdate(getMandatory(), item);
  }

}
