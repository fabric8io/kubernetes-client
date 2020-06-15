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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollableScalableResourceOperation;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollingUpdater;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReplicationControllerOperationsImpl extends RollableScalableResourceOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>>
  implements TimeoutImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> {

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null);
  }

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(new RollingOperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public ReplicationControllerOperationsImpl(RollingOperationContext context) {
    super(context.withPlural("replicationcontrollers"));
    this.type = ReplicationController.class;
    this.listType = ReplicationControllerList.class;
    this.doneableType = DoneableReplicationController.class;
  }

  @Override
  public ReplicationControllerOperationsImpl newInstance(OperationContext context) {
    return new ReplicationControllerOperationsImpl((RollingOperationContext) context);
  }

  @Override
  public RollableScalableResource<ReplicationController, DoneableReplicationController> load(InputStream is) {
      ReplicationController item = unmarshal(is, ReplicationController.class);
      return new ReplicationControllerOperationsImpl((RollingOperationContext) context.withItem(item));
  }

  @Override
  public ReplicationController withReplicas(int count) {
    return cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
  }

  @Override
  public RollingUpdater<ReplicationController, ReplicationControllerList, DoneableReplicationController> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new ReplicationControllerRollingUpdater(client, config, namespace, rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  public int getCurrentReplicas(ReplicationController current) {
    return current.getStatus().getReplicas();
  }

  @Override
  public int getDesiredReplicas(ReplicationController item) {
    return item.getSpec().getReplicas();
  }

  @Override
  public long getObservedGeneration(ReplicationController current) {
    return (current != null && current.getStatus() != null
      && current.getStatus().getObservedGeneration() != null) ? current.getStatus().getObservedGeneration() : -1;
  }

  @Override
  public ReplicationController updateImage(Map<String, String> containerToImageMap) {
    ReplicationController replicationController = get();
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
  public ReplicationController updateImage(String image) {
    ReplicationController oldRC = get();

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
  public TimeoutImageEditReplacePatchable rolling() {
    return new ReplicationControllerOperationsImpl(((RollingOperationContext)context).withRolling(true));
  }

  @Override
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of ReplicationControllers");
  }

  @Override
  public ImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> withTimeout(long timeout, TimeUnit unit) {
    return new ReplicationControllerOperationsImpl(((RollingOperationContext)context).withRollingTimeout(unit.toMillis(timeout)).withRollingTimeUnit(TimeUnit.MILLISECONDS));
  }

  @Override
  public ImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> withTimeoutInMillis(long timeoutInMillis) {
    return new ReplicationControllerOperationsImpl(((RollingOperationContext)context).withRollingTimeout(timeoutInMillis));
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
    ReplicationController rc = fromServer().get();
    String rcUid = rc.getMetadata().getUid();

    PodOperationsImpl podOperations = new PodOperationsImpl(new PodOperationContext(context.getClient(),
      context.getConfig(), context.getPlural(), context.getNamespace(), context.getName(), null,
      "v1", context.getCascading(), context.getItem(), context.getLabels(), context.getLabelsNot(),
      context.getLabelsIn(), context.getLabelsNotIn(), context.getFields(), context.getFieldsNot(), context.getResourceVersion(),
      context.getReloadingFromServer(), context.getGracePeriodSeconds(), context.getPropagationPolicy(),
      context.getWatchRetryInitialBackoffMillis(), context.getWatchRetryBackoffMultiplier(), null, null, null, null, null,
      null, null, null, null, false, false, false, null, null,
      null, isPretty, null, null, null, null, null));
    PodList jobPodList = podOperations.withLabels(rc.getMetadata().getLabels()).list();

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

  @Override
  public ReplicationController pause() {
    throw new UnsupportedOperationException(context.getPlural() + " \"" + name + "\" pausing is not supported");
  }

  @Override
  public ReplicationController resume() {
    throw new UnsupportedOperationException(context.getPlural() + " \"" + name + "\" resuming is not supported");
  }

  @Override
  public ReplicationController restart() {
    throw new UnsupportedOperationException(context.getPlural() + " \"" + name + "\" restarting is not supported");
  }

  @Override
  public ReplicationController undo() {
    throw new UnsupportedOperationException("no rollbacker has been implemented for \"" + get().getKind() +"\"");
  }

}
