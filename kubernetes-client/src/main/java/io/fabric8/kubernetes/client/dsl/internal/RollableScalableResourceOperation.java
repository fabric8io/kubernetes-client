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
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Operations for resources that represent scalable, rolling-updatable sets of Pods.
 */
public abstract class RollableScalableResourceOperation<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends Resource<T, D>>
  extends HasMetadataOperation<T, L, D, R> implements RollableScalableResource<T, D> {

  private final Logger Log = LoggerFactory.getLogger(this.getClass());

  final Boolean rolling;
  final long rollingTimeout;
  final TimeUnit rollingTimeUnit;

  public RollableScalableResourceOperation(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, apiGroup, apiVersion, resourceT, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    this.rolling = rolling;
    this.rollingTimeout = rollingTimeout;
    this.rollingTimeUnit = rollingTimeUnit;
    reaper = new ScalableReaper(this);
  }

  abstract T withReplicas(int count);
  abstract RollingUpdater<T, L, D> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit);

  // There are no common interfaces through which we could get these values.
  abstract int getCurrentReplicas(T current);
  abstract int getDesiredReplicas(T item);
  abstract long getObservedGeneration(T current);

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
  public T waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    T t = get();
    if (t == null) {
      throw new IllegalArgumentException(getType().getSimpleName() + " with name:[" + name + "] in namespace:[" + namespace + "] not found!");
    }

    return periodicWatchUntilReady(10, System.currentTimeMillis(), Math.max(timeUnit.toMillis(amount) / 10, 1000L), amount);
  }

  /**
   * Let's wait until there are enough Ready pods.
   */
  private void waitUntilScaled(final int count) {
    final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    final Runnable tPoller = new Runnable() {
      public void run() {
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
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(tPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
    try {
      if (Utils.waitUntilReady(queue, rollingTimeout, rollingTimeUnit)) {
        Log.debug("{}/{} pod(s) ready for {}: {} in namespace: {}.",
          replicasRef.get(), count, getType().getSimpleName(), name, namespace);
      } else {
        Log.error("{}/{} pod(s) ready for {}: {} in namespace: {}  after waiting for {} seconds so giving up",
          replicasRef.get(), count, getType().getSimpleName(), name, namespace, rollingTimeUnit.toSeconds(rollingTimeout));
      }
    } finally {
      poller.cancel(true);
      executor.shutdown();
    }
  }

  @Override
  public D edit() {
    if (!rolling) {
      return super.edit();
    }

    final Visitor<T> visitor = new Visitor<T>() {
      @Override
      public void visit(T t) {
        try {
          getRollingUpdater(rollingTimeout, rollingTimeUnit).rollUpdate(getMandatory(), t);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(getType(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
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
  public T patch(T t) {
    if (!rolling) {
      return super.patch(t);
    }
    return getRollingUpdater(rollingTimeout, rollingTimeUnit).rollUpdate(getMandatory(), t);
  }

}
