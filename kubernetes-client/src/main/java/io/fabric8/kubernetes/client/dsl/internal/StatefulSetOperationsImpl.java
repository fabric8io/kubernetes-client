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

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.apps.DoneableStatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class StatefulSetOperationsImpl extends RollableScalableResourceOperation<StatefulSet, StatefulSetList, DoneableStatefulSet, RollableScalableResource<StatefulSet, DoneableStatefulSet>>
  implements TimeoutImageEditReplacePatchable<StatefulSet, StatefulSet, DoneableStatefulSet>
{
  public StatefulSetOperationsImpl(OkHttpClient client, Config config) {
    this(new RollingOperationContext().withOkhttpClient(client).withConfig(config));
  }

  public StatefulSetOperationsImpl(RollingOperationContext context) {
    super(context.withApiGroupName("apps")
      .withApiGroupVersion("v1")
      .withPlural("statefulsets"));
    this.type = StatefulSet.class;
    this.listType = StatefulSetList.class;
    this.doneableType = DoneableStatefulSet.class;
  }

  @Override
  public StatefulSetOperationsImpl newInstance(OperationContext context) {
    return new StatefulSetOperationsImpl((RollingOperationContext) context);
  }

  @Override
  StatefulSet withReplicas(int count) {
    return cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
  }

  @Override
  RollingUpdater<StatefulSet, StatefulSetList, DoneableStatefulSet> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new StatefulSetRollingUpdater(client, config, getNamespace(), rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  int getCurrentReplicas(StatefulSet current) {
    return current.getStatus().getReplicas();
  }

  @Override
  int getDesiredReplicas(StatefulSet item) {
    return item.getSpec().getReplicas();
  }

  @Override
  long getObservedGeneration(StatefulSet current) {
    return (current != null && current.getStatus() != null && current.getStatus().getObservedGeneration() != null)
      ? current.getStatus().getObservedGeneration() : -1;
  }


  @Override
  public StatefulSetOperationsImpl rolling() {
    return new StatefulSetOperationsImpl(((RollingOperationContext)context).withRolling(true));
  }

  @Override
  public StatefulSet updateImage(String image) {
    StatefulSet oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing StatefulSet doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multicontainer pods");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() == 0) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container updatedContainer = new ContainerBuilder(oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next()).withImage(image).build();

    StatefulSetBuilder newRCBuilder = new StatefulSetBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    return new StatefulSetRollingUpdater(client, config, namespace).rollUpdate(oldRC, newRCBuilder.build());
  }

  @Override
  public ImageEditReplacePatchable<StatefulSet, StatefulSet, DoneableStatefulSet> withTimeout(long timeout, TimeUnit unit) {
    return new StatefulSetOperationsImpl(((RollingOperationContext)context).withRollingTimeout(unit.toMillis(timeout)).withRollingTimeUnit(TimeUnit.MILLISECONDS));
  }

  @Override
  public ImageEditReplacePatchable<StatefulSet, StatefulSet, DoneableStatefulSet> withTimeoutInMillis(long timeoutInMillis) {
    return new StatefulSetOperationsImpl(((RollingOperationContext)context).withRollingTimeout(timeoutInMillis));
  }
}
