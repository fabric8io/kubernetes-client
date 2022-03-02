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
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionList;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StatefulSetOperationsImpl extends RollableScalableResourceOperation<StatefulSet, StatefulSetList, RollableScalableResource<StatefulSet>>
  implements TimeoutImageEditReplacePatchable<StatefulSet>
{
  public StatefulSetOperationsImpl(ClientContext clientContext) {
    this(new RollingOperationContext(), HasMetadataOperationsImpl.defaultContext(clientContext));
  }

  public StatefulSetOperationsImpl(RollingOperationContext context, OperationContext superContext) {
    super(context, superContext.withApiGroupName("apps")
      .withApiGroupVersion("v1")
      .withPlural("statefulsets"), StatefulSet.class, StatefulSetList.class);
  }

  @Override
  public StatefulSetOperationsImpl newInstance(OperationContext context) {
    return new StatefulSetOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public StatefulSetOperationsImpl newInstance(RollingOperationContext context) {
    return new StatefulSetOperationsImpl(context, this.context);
  }

  @Override
  public StatefulSet withReplicas(int count) {
    return cascading(false).accept(s -> s.getSpec().setReplicas(count));
  }

  @Override
  public RollingUpdater<StatefulSet, StatefulSetList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new StatefulSetRollingUpdater(context, getNamespace(), rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  public int getCurrentReplicas(StatefulSet current) {
    return current.getStatus().getReplicas();
  }

  @Override
  public int getDesiredReplicas(StatefulSet item) {
    return item.getSpec().getReplicas();
  }

  @Override
  public long getObservedGeneration(StatefulSet current) {
    return (current != null && current.getStatus() != null && current.getStatus().getObservedGeneration() != null)
      ? current.getStatus().getObservedGeneration() : -1;
  }

  @Override
  public StatefulSet updateImage(Map<String, String> containerToImageMap) {
    StatefulSet statefulSet = get();
    if (statefulSet == null) {
      throw new KubernetesClientException("Existing replica set doesn't exist");
    }
    if (statefulSet.getSpec().getTemplate().getSpec().getContainers().isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    List<Container> containers = statefulSet.getSpec().getTemplate().getSpec().getContainers();
    for (Container container : containers) {
      if (containerToImageMap.containsKey(container.getName())) {
        container.setImage(containerToImageMap.get(container.getName()));
      }
    }
    statefulSet.getSpec().getTemplate().getSpec().setContainers(containers);
    return sendPatchedObject(get(), statefulSet);
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
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container container = oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next();
    return updateImage(Collections.singletonMap(container.getName(), image));
  }

  @Override
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of StatefulSets");
  }

  @Override
  public String getLog(boolean isPretty) {
    return PodOperationUtil.getLog(doGetLog(isPretty), isPretty);
  }

  private List<PodResource<Pod>> doGetLog(boolean isPretty) {
    StatefulSet statefulSet = requireFromServer();

    return PodOperationUtil.getPodOperationsForController(context, statefulSet.getMetadata().getUid(),
      getStatefulSetSelectorLabels(statefulSet), isPretty, rollingOperationContext.getLogWaitTimeout(), rollingOperationContext.getContainerId());
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
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

  @Override
  public StatefulSet pause() {
    return sendPatchedStatefulSet(RollingUpdater.requestPayLoadForRolloutPause());
  }

  @Override
  public StatefulSet resume() {
    return sendPatchedStatefulSet(RollingUpdater.requestPayLoadForRolloutResume());
  }

  @Override
  public StatefulSet restart() {
    return sendPatchedStatefulSet(RollingUpdater.requestPayLoadForRolloutRestart());
  }

  @Override
  public StatefulSet undo() {
    List<ControllerRevision> controllerRevisions = getControllerRevisionListForStatefulSet(get()).getItems();
    if (controllerRevisions.size() < 2) {
      throw new IllegalStateException("No revision to rollback to!");
    }

    // Sort list of replicaSets based on revision annotation
    controllerRevisions.sort((o1, o2) -> {
      Long revision2 = o2.getRevision();
      Long revision1 = o1.getRevision();
      if (revision1 != null && revision2 != null) {
        return revision2.intValue() - revision1.intValue();
      } else if (revision1 != null) {
        return revision1.intValue();
      } else if (revision2 != null) {
        return revision2.intValue();
      } else {
        return 0;
      }
    });
    ControllerRevision previousControllerRevision = controllerRevisions.get(1);

    return sendPatchedStatefulSetData(previousControllerRevision.getData());
  }

  private StatefulSet sendPatchedStatefulSet(Map<String, Object> patchedUpdate) {
    StatefulSet oldStatefulSet = get();
    try {
      return handlePatch(oldStatefulSet, patchedUpdate);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(interruptedException);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private StatefulSet sendPatchedStatefulSetData(HasMetadata patchedUpdate) {
    return sendPatchedStatefulSet(getObjectValueAsMap(patchedUpdate));
  }

  private ControllerRevisionList getControllerRevisionListForStatefulSet(StatefulSet statefulSet) {
    return Handlers.getOperation(ControllerRevision.class, ControllerRevisionList.class, this.context).inNamespace(namespace).withLabels(statefulSet.getSpec().getSelector().getMatchLabels()).list();
  }

  static Map<String, String> getStatefulSetSelectorLabels(StatefulSet statefulSet) {
    Map<String, String> labels = new HashMap<>();
    if (statefulSet != null && statefulSet.getSpec() != null
      && statefulSet.getSpec().getTemplate() != null
      && statefulSet.getSpec().getTemplate().getMetadata() != null) {
      labels.putAll(statefulSet.getSpec().getTemplate().getMetadata().getLabels());
    }
    return labels;
  }

}
