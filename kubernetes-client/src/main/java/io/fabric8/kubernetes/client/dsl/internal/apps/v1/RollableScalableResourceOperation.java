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

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

/**
 * Operations for resources that represent scalable, rolling-updatable sets of Pods.
 */
public abstract class RollableScalableResourceOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends HasMetadataOperation<T, L, R> implements RollableScalableResource<T>, TimeoutImageEditReplacePatchable<T> {

  protected final PodOperationContext rollingOperationContext;

  protected RollableScalableResourceOperation(PodOperationContext context, OperationContext superContext, Class<T> type,
      Class<L> listType) {
    super(superContext, type, listType);
    this.rollingOperationContext = context;
  }

  protected abstract RollingUpdater<T, L> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit);

  @Override
  public T edit(UnaryOperator<T> function) {
    RollingUpdater<T, L> rollingUpdater = getRollingUpdater(context.getTimeout(), context.getTimeoutUnit());
    if (!rollingOperationContext.isRolling() || rollingUpdater == null) {
      return super.edit(function);
    }
    T oldObj = getItemOrRequireFromServer();
    T newObj = function.apply(getKubernetesSerialization().clone(oldObj));
    return rollingUpdater.rollUpdate(oldObj, newObj);
  }

  public abstract RollableScalableResourceOperation<T, L, R> newInstance(PodOperationContext context,
      OperationContext superContext);

  @Override
  public Loggable withLogWaitTimeout(Integer logWaitTimeout) {
    return withReadyWaitTimeout(logWaitTimeout);
  }

  @Override
  public Loggable withReadyWaitTimeout(Integer timeout) {
    return newInstance(rollingOperationContext.withReadyWaitTimeout(timeout), context);
  }

  @Override
  public Loggable inContainer(String id) {
    return newInstance(rollingOperationContext.withContainerId(id), context);
  }

  @Override
  public TimeoutImageEditReplacePatchable<T> rolling() {
    return newInstance(rollingOperationContext.toBuilder().rolling(true).build(), context);
  }

  @Override
  public String getLog() {
    return getLog(rollingOperationContext.isPrettyOutput());
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public T updateImage(String image) {
    T value = get();

    if (value == null) {
      throw new KubernetesClientException("Resource doesn't exist");
    }

    List<Container> containers = getContainers(value);

    if (containers.size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multicontainer pods");
    }
    if (containers.isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container container = containers.iterator().next();
    return updateImage(Collections.singletonMap(container.getName(), image));
  }

  protected abstract List<Container> getContainers(T value);

  @Override
  public T updateImage(Map<String, String> containerToImageMap) {
    T value = get();
    if (value == null) {
      throw new KubernetesClientException("Resource doesn't exist");
    }

    T base = getKubernetesSerialization().clone(value);

    List<Container> containers = getContainers(value);

    if (containers.isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    for (Container container : containers) {
      if (containerToImageMap.containsKey(container.getName())) {
        container.setImage(containerToImageMap.get(container.getName()));
      }
    }

    return sendPatchedObject(base, value);
  }

  protected T sendPatchedObject(T oldObject, T updatedObject) {
    return this.patch(null, oldObject, updatedObject);
  }

  @Override
  public RollableScalableResourceOperation<T, L, R> withTimeout(long timeout, TimeUnit unit) {
    return newInstance(rollingOperationContext, context.withTimeout(timeout, unit));
  }

  @Override
  public RollableScalableResourceOperation<T, L, R> withTimeoutInMillis(long timeoutInMillis) {
    return withTimeout(timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  public T pause() {
    throw new KubernetesClientException(context.getPlural() + " pausing is not supported");
  }

  @Override
  public T resume() {
    throw new KubernetesClientException(context.getPlural() + " resuming is not supported");
  }

  @Override
  public T restart() {
    throw new KubernetesClientException(context.getPlural() + " restarting is not supported");
  }

  @Override
  public T undo() {
    throw new KubernetesClientException(context.getPlural() + " undo is not supported");
  }

}
