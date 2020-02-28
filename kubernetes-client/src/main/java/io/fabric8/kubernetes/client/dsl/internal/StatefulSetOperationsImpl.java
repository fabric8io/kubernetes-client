/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.apps.DoneableStatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import okhttp3.OkHttpClient;

import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StatefulSetOperationsImpl extends RollableScalableResourceOperation<StatefulSet, StatefulSetList, DoneableStatefulSet, RollableScalableResource<StatefulSet, DoneableStatefulSet>>
  implements TimeoutImageEditReplacePatchable<StatefulSet, StatefulSet, DoneableStatefulSet>
{
  public StatefulSetOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null);
  }

  public StatefulSetOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(new RollingOperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withCascading(true));
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

  @Override
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of StatefulSets");
  }

  public String getLog() {
    return getLog(false);
  }

  public String getLog(Boolean isPretty) {
    StringBuilder stringBuilder = new StringBuilder();
    List<PodResource<Pod, DoneablePod>> podOperationList = doGetLog(isPretty);
    for (PodResource<Pod, DoneablePod> podOperation : podOperationList) {
      stringBuilder.append(podOperation.getLog(isPretty));
    }
    return stringBuilder.toString();
  }

  private List<PodResource<Pod, DoneablePod>> doGetLog(boolean isPretty) {
    List<PodResource<Pod, DoneablePod>> pods = new ArrayList<>();
    StatefulSet statefulSet = fromServer().get();
    String rcUid = statefulSet.getMetadata().getUid();

    PodOperationsImpl podOperations = new PodOperationsImpl(new PodOperationContext(context.getClient(),
      context.getConfig(), context.getPlural(), context.getNamespace(), context.getName(), null,
      "v1", context.getCascading(), context.getItem(), context.getLabels(), context.getLabelsNot(),
      context.getLabelsIn(), context.getLabelsNotIn(), context.getFields(), context.getFieldsNot(), context.getResourceVersion(),
      context.getReloadingFromServer(), context.getGracePeriodSeconds(), context.getPropagationPolicy(), null, null, null, null, null,
      null, null, null, null, false, false, false, null, null,
      null, isPretty, null, null, null, null, null));
    PodList jobPodList = podOperations.withLabels(statefulSet.getMetadata().getLabels()).list();

    for (Pod pod : jobPodList.getItems()) {
      OwnerReference ownerReference = KubernetesResourceUtil.getControllerUid(pod);
      if (ownerReference != null && ownerReference.getUid().equals(rcUid)) {
        pods.add(podOperations.withName(pod.getMetadata().getName()));
      }
    }
    return pods;
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    List<PodResource<Pod, DoneablePod>> podResources = doGetLog(false);
    if (podResources.size() > 1) {
      throw new KubernetesClientException("Reading logs is not supported for multicontainer jobs");
    } else if (podResources.size() == 1) {
      return podResources.get(0).getLogReader();
    }
    return null;
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    List<PodResource<Pod, DoneablePod>> podResources = doGetLog(false);
    if (podResources.size() > 1) {
      throw new KubernetesClientException("Watching logs is not supported for multicontainer jobs");
    } else if (podResources.size() == 1) {
      return podResources.get(0).watchLog(out);
    }
    return null;
  }
}
