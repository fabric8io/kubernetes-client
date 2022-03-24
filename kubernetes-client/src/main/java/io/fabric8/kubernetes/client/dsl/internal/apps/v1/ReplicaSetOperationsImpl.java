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
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;

import java.io.OutputStream;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReplicaSetOperationsImpl
    extends RollableScalableResourceOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>>
    implements TimeoutImageEditReplacePatchable<ReplicaSet> {

  public ReplicaSetOperationsImpl(Client client) {
    this(new RollingOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  ReplicaSetOperationsImpl(RollingOperationContext context, OperationContext superContext) {
    super(context, superContext.withApiGroupName("apps")
        .withApiGroupVersion("v1")
        .withPlural("replicasets"), ReplicaSet.class, ReplicaSetList.class);
  }

  @Override
  public ReplicaSetOperationsImpl newInstance(OperationContext context) {
    return new ReplicaSetOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public ReplicaSetOperationsImpl newInstance(RollingOperationContext context) {
    return new ReplicaSetOperationsImpl(context, this.context);
  }

  @Override
  public ReplicaSet updateImage(String image) {
    ReplicaSet oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing replication controller doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multicontainer pods");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container container = oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next();
    return updateImage(Collections.singletonMap(container.getName(), image));
  }

  @Override
  public ReplicaSet updateImage(Map<String, String> containerToImageMap) {
    ReplicaSet replicationController = get();
    if (replicationController == null) {
      throw new KubernetesClientException("Existing replica set doesn't exist");
    }
    if (replicationController.getSpec().getTemplate().getSpec().getContainers().isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    List<Container> containers = replicationController.getSpec().getTemplate().getSpec().getContainers();
    for (Container container : containers) {
      if (containerToImageMap.containsKey(container.getName())) {
        container.setImage(containerToImageMap.get(container.getName()));
      }
    }
    replicationController.getSpec().getTemplate().getSpec().setContainers(containers);
    return sendPatchedObject(get(), replicationController);
  }

  @Override
  public ReplicaSet pause() {
    throw new UnsupportedOperationException(context.getPlural() + " \"" + name + "\" pausing is not supported");
  }

  @Override
  public ReplicaSet resume() {
    throw new UnsupportedOperationException(context.getPlural() + " \"" + name + "\" resuming is not supported");
  }

  @Override
  public ReplicaSet restart() {
    throw new UnsupportedOperationException(context.getPlural() + " \"" + name + "\" restarting is not supported");
  }

  @Override
  public ReplicaSet undo() {
    throw new UnsupportedOperationException("no rollbacker has been implemented for \"" + get().getKind() + "\"");
  }

  @Override
  public ReplicaSet withReplicas(int count) {
    return cascading(false).accept(r -> r.getSpec().setReplicas(count));
  }

  @Override
  public RollingUpdater<ReplicaSet, ReplicaSetList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new ReplicaSetRollingUpdater(context.getClient(), getNamespace(), rollingTimeUnit.toMillis(rollingTimeout),
        config.getLoggingInterval());
  }

  @Override
  public int getCurrentReplicas(ReplicaSet current) {
    return current.getStatus().getReplicas();
  }

  @Override
  public int getDesiredReplicas(ReplicaSet item) {
    return item.getSpec().getReplicas();
  }

  @Override
  public long getObservedGeneration(ReplicaSet current) {
    return (current != null && current.getStatus() != null
        && current.getStatus().getObservedGeneration() != null) ? current.getStatus().getObservedGeneration() : -1;
  }

  @Override
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of ReplicaSets");
  }

  @Override
  public String getLog(boolean isPretty) {
    return PodOperationUtil.getLog(doGetLog(isPretty), isPretty);
  }

  private List<PodResource> doGetLog(boolean isPretty) {
    ReplicaSet replicaSet = requireFromServer();
    return PodOperationUtil.getPodOperationsForController(context, replicaSet.getMetadata().getUid(),
        getReplicaSetSelectorLabels(replicaSet), isPretty, rollingOperationContext.getLogWaitTimeout(),
        rollingOperationContext.getContainerId());
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * 
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return PodOperationUtil.getLogReader(doGetLog(false));
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    return PodOperationUtil.watchLog(doGetLog(false), out);
  }

  static Map<String, String> getReplicaSetSelectorLabels(ReplicaSet replicaSet) {
    Map<String, String> labels = new HashMap<>();

    if (replicaSet != null && replicaSet.getSpec() != null && replicaSet.getSpec().getSelector() != null) {
      labels.putAll(replicaSet.getSpec().getSelector().getMatchLabels());
    }
    return labels;
  }
}
