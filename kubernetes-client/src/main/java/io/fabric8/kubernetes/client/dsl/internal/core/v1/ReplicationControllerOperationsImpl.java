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
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.PodOperationUtil;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollableScalableResourceOperation;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollingUpdater;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReplicationControllerOperationsImpl extends RollableScalableResourceOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>>
  implements TimeoutImageEditReplacePatchable<ReplicationController> {

  private Integer podLogWaitTimeout;
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
  }

  private ReplicationControllerOperationsImpl(RollingOperationContext context, Integer podLogWaitTimeout) {
    this(context);
    this.podLogWaitTimeout = podLogWaitTimeout;
  }

  @Override
  public ReplicationControllerOperationsImpl newInstance(OperationContext context) {
    return new ReplicationControllerOperationsImpl((RollingOperationContext) context);
  }

  @Override
  public RollableScalableResource<ReplicationController> load(InputStream is) {
      ReplicationController item = unmarshal(is, ReplicationController.class);
      return new ReplicationControllerOperationsImpl((RollingOperationContext) context.withItem(item));
  }

  @Override
  public ReplicationController withReplicas(int count) {
      return cascading(false).accept(r -> r.getSpec().setReplicas(count));
  }

  @Override
  public RollingUpdater<ReplicationController, ReplicationControllerList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
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
  public ImageEditReplacePatchable<ReplicationController> withTimeout(long timeout, TimeUnit unit) {
    return new ReplicationControllerOperationsImpl(((RollingOperationContext)context).withRollingTimeout(unit.toMillis(timeout)).withRollingTimeUnit(TimeUnit.MILLISECONDS));
  }

  @Override
  public ImageEditReplacePatchable<ReplicationController> withTimeoutInMillis(long timeoutInMillis) {
    return new ReplicationControllerOperationsImpl(((RollingOperationContext)context).withRollingTimeout(timeoutInMillis));
  }

  public String getLog() {
    return getLog(false);
  }

  public String getLog(Boolean isPretty) {
    return PodOperationUtil.getLog(doGetLog(isPretty), isPretty);
  }

  private List<PodResource<Pod>> doGetLog(boolean isPretty) {
    ReplicationController rc = requireFromServer();

    return PodOperationUtil.getPodOperationsForController(context, rc.getMetadata().getUid(),
      getReplicationControllerPodLabels(rc), isPretty, podLogWaitTimeout, ((RollingOperationContext)context).getContainerId());
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
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    return PodOperationUtil.watchLog(doGetLog(false), out);
  }

  @Override
  public Loggable<LogWatch> withLogWaitTimeout(Integer logWaitTimeout) {
    return new ReplicationControllerOperationsImpl((RollingOperationContext)context, logWaitTimeout);
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

  static Map<String, String> getReplicationControllerPodLabels(ReplicationController replicationController) {
    Map<String, String> labels = new HashMap<>();
    if (replicationController != null && replicationController.getSpec() != null && replicationController.getSpec().getSelector() != null) {
      labels.putAll(replicationController.getSpec().getSelector());
    }
    return labels;
  }

  @Override
  public Loggable<LogWatch> inContainer(String id) {
    return newInstance(((RollingOperationContext) context).withContainerId(id));
  }
}
