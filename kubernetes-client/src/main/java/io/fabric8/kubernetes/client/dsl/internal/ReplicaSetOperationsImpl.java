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
import io.fabric8.kubernetes.api.model.apps.DoneableReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ReplicaSetOperationsImpl extends RollableScalableResourceOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet, RollableScalableResource<ReplicaSet, DoneableReplicaSet>>
  implements TimeoutImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> {

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config) {
    this(new RollingOperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ReplicaSetOperationsImpl(RollingOperationContext context) {
    super(context.withApiGroupName("apps")
      .withApiGroupVersion("v1")
      .withPlural("replicasets"));
    this.type = ReplicaSet.class;
    this.listType = ReplicaSetList.class;
    this.doneableType = DoneableReplicaSet.class;
  }

  @Override
  public ReplicaSetOperationsImpl newInstance(OperationContext context) {
    return new ReplicaSetOperationsImpl((RollingOperationContext) context);
  }

  @Override
  public ReplicaSet updateImage(String image) {
    ReplicaSet oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing replica set doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multicontainer pods");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() == 0) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container updatedContainer = new ContainerBuilder(oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next()).withImage(image).build();

    ReplicaSetBuilder newRCBuilder = new ReplicaSetBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    return new ReplicaSetRollingUpdater(client, config, namespace).rollUpdate(oldRC, newRCBuilder.build());
  }

  @Override
  ReplicaSet withReplicas(int count) {
    return cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
  }

  @Override
  RollingUpdater<ReplicaSet, ReplicaSetList, DoneableReplicaSet> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new ReplicaSetRollingUpdater(client, config, getNamespace(), rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  int getCurrentReplicas(ReplicaSet current) {
    return current.getStatus().getReplicas();
  }

  @Override
  int getDesiredReplicas(ReplicaSet item) {
    return item.getSpec().getReplicas();
  }

  @Override
  long getObservedGeneration(ReplicaSet current) {
    return (current != null && current.getStatus() != null
      && current.getStatus().getObservedGeneration() != null)? current.getStatus().getObservedGeneration() : -1;
  }
  @Override
  public TimeoutImageEditReplacePatchable rolling() {
    return new ReplicaSetOperationsImpl(((RollingOperationContext)context).withRolling(true));
  }

  @Override
  public ImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> withTimeout(long timeout, TimeUnit unit) {
    return new ReplicaSetOperationsImpl(((RollingOperationContext)context).withRollingTimeout(unit.toMillis(timeout)).withRollingTimeUnit(TimeUnit.MILLISECONDS));
  }

  @Override
  public ImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> withTimeoutInMillis(long timeoutInMillis) {
    return new ReplicaSetOperationsImpl(((RollingOperationContext)context).withRollingTimeout(timeoutInMillis));
  }
}
