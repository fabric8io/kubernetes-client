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
import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class DeploymentOperationsImpl extends RollableScalableResourceOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>>
  implements TimeoutImageEditReplacePatchable<Deployment>  {

  static final transient Logger LOG = LoggerFactory.getLogger(DeploymentOperationsImpl.class);
  public static final String DEPLOYMENT_KUBERNETES_IO_REVISION = "deployment.kubernetes.io/revision";

  public DeploymentOperationsImpl(ClientContext clientContext) {
    this(new RollingOperationContext(), HasMetadataOperationsImpl.defaultContext(clientContext));
  }

  public DeploymentOperationsImpl(RollingOperationContext context, OperationContext superContext) {
    super(context, superContext.withApiGroupName("apps")
      .withApiGroupVersion("v1")
      .withPlural("deployments"), Deployment.class, DeploymentList.class);
  }

  @Override
  public DeploymentOperationsImpl newInstance(OperationContext context) {
    return new DeploymentOperationsImpl(rollingOperationContext, context);
  }
  
  @Override
  public DeploymentOperationsImpl newInstance(RollingOperationContext context) {
    return new DeploymentOperationsImpl(context, this.context);
  }

  @Override
  public Deployment scale(int count) {
    return scale(count, false);
  }

  @Override
  public Deployment scale(int count, boolean wait) {
    Deployment res = cascading(false).accept(d -> d.getSpec().setReplicas(count));
    if (wait) {
      waitUntilDeploymentIsScaled(count);
      res = getMandatory();
    }
    return res;
  }

  @Override
  public Deployment edit(UnaryOperator<Deployment> function) {
    if (isCascading()) {
      return cascading(false).edit(function);
    }
    return super.edit(function);
  }

  @Override
  public Deployment accept(Consumer<Deployment> consumer) {
    if (isCascading()) {
      return cascading(false).accept(consumer);
    }
    return super.accept(consumer);
  }

  @Override
  public Deployment replace(Deployment item) {
    if (isCascading()) {
      return cascading(false).replace(item);
    }
    return super.replace(item);
  }

  @Override
  public Deployment patch(PatchContext patchContext, Deployment item) {
    if (isCascading()) {
      return cascading(false).patch(patchContext, item);
    }
    return super.patch(patchContext, item);
  }

  @Override
  public Status rollback(DeploymentRollback rollback) {
    return handleDeploymentRollback(rollback);
  }

  @Override
  public RollingUpdater<Deployment, DeploymentList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new DeploymentRollingUpdater(context, getNamespace(), rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  public Deployment withReplicas(int count) {
    return cascading(false).accept(d -> d.getSpec().setReplicas(count));
  }

  @Override
  public int getCurrentReplicas(Deployment current) {
    return current.getStatus().getReplicas();
  }

  @Override
  public int getDesiredReplicas(Deployment item) {
    return item.getSpec().getReplicas();
  }

  @Override
  public long getObservedGeneration(Deployment current) {
    return (current != null && current.getStatus() != null
      && current.getStatus().getObservedGeneration() != null) ? current.getStatus().getObservedGeneration() : -1;
  }

  @Override
  public Deployment updateImage(String image) {
    Deployment oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing replica set doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("updateImage(image) does not supported for multicontainer pods, use updateImage(Map<String, String>) instead");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container container = oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next();
    return updateImage(Collections.singletonMap(container.getName(), image));
  }

  @Override
  public Deployment updateImage(Map<String, String> containerToImageMap) {
    Deployment deployment = get();
    if (deployment == null) {
      throw new KubernetesClientException("Existing replica set doesn't exist");
    }
    if (deployment.getSpec().getTemplate().getSpec().getContainers().isEmpty()) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    List<Container> containers = deployment.getSpec().getTemplate().getSpec().getContainers();
    for (Container container : containers) {
      if (containerToImageMap.containsKey(container.getName())) {
        container.setImage(containerToImageMap.get(container.getName()));
      }
    }
    deployment.getSpec().getTemplate().getSpec().setContainers(containers);
    return sendPatchedObject(get(), deployment);
  }


  @Override
  public Deployment resume() {
    return sendPatchedDeployment(RollingUpdater.requestPayLoadForRolloutResume());
  }

  @Override
  public Deployment pause() {
    return sendPatchedDeployment(RollingUpdater.requestPayLoadForRolloutPause());
  }

  @Override
  public Deployment restart() {
    return sendPatchedDeployment(RollingUpdater.requestPayLoadForRolloutRestart());
  }

  @Override
  public Deployment undo() {
    List<ReplicaSet> replicaSets = getReplicaSetListForDeployment(get()).getItems();
    // Sort list of replicaSets based on revision annotation
    replicaSets.sort((o1, o2) -> {
      String revisionO1 = o1.getMetadata().getAnnotations().get(DEPLOYMENT_KUBERNETES_IO_REVISION);
      String revisionO2 = o2.getMetadata().getAnnotations().get(DEPLOYMENT_KUBERNETES_IO_REVISION);
      return Integer.parseInt(revisionO2) - Integer.parseInt(revisionO1);
    });

    ReplicaSet latestReplicaSet = replicaSets.get(0);
    ReplicaSet previousRevisionReplicaSet = replicaSets.get(1);
    Deployment deployment = get();
    deployment.getMetadata().getAnnotations().put(DEPLOYMENT_KUBERNETES_IO_REVISION, latestReplicaSet.getMetadata().getAnnotations().get(DEPLOYMENT_KUBERNETES_IO_REVISION));
    deployment.getSpec().setTemplate(previousRevisionReplicaSet.getSpec().getTemplate());

    return sendPatchedObject(get(), deployment);
  }

  /**
   * Lets wait until there are enough Ready pods of the given Deployment
   */
  private void waitUntilDeploymentIsScaled(final int count) {
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    try {
      waitUntilCondition(deployment -> {
        // If the deployment is gone, we shouldn't wait.
        if (deployment == null) {
          if (count == 0) {
            return true;
          }
          throw new IllegalStateException("Can't wait for Deployment: " + checkName(getItem()) + " in namespace: " + checkName(getItem()) + " to scale. Resource is no longer available.");
        }

        replicasRef.set(deployment.getStatus().getReplicas());
        int currentReplicas = deployment.getStatus().getReplicas() != null ? deployment.getStatus().getReplicas() : 0;
        long generation = deployment.getMetadata().getGeneration() != null ? deployment.getMetadata().getGeneration() : 0;
        long observedGeneration = deployment.getStatus() != null && deployment.getStatus().getObservedGeneration() != null ? deployment.getStatus().getObservedGeneration() : -1;
        if (observedGeneration >= generation && Objects.equals(deployment.getSpec().getReplicas(), currentReplicas)) {
          return true;
        }
        LOG.debug("Only {}/{} pods scheduled for Deployment: {} in namespace: {} seconds so waiting...",
          deployment.getStatus().getReplicas(), deployment.getSpec().getReplicas(), deployment.getMetadata().getName(), namespace);
        return false;
      }, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS);
      LOG.debug("{}/{} pod(s) ready for Deployment: {} in namespace: {}.",
          replicasRef.get(), count, name, namespace);
    } catch (KubernetesClientTimeoutException e) {
      LOG.error("{}/{} pod(s) ready for Deployment: {} in namespace: {}  after waiting for {} seconds so giving up",
          replicasRef.get(), count, name, namespace, TimeUnit.MILLISECONDS.toSeconds(getConfig().getScaleTimeout()));
    }
  }

  @Override
  public String getLog(boolean isPretty) {
    StringBuilder stringBuilder = new StringBuilder();
    List<RollableScalableResource<ReplicaSet>> rcList = doGetLog();
    for (RollableScalableResource<ReplicaSet> rcOperation : rcList) {
      stringBuilder.append(rcOperation.getLog(isPretty));
    }
    return stringBuilder.toString();
  }

  private List<RollableScalableResource<ReplicaSet>> doGetLog() {
    List<RollableScalableResource<ReplicaSet>> rcs = new ArrayList<>();
    Deployment deployment = requireFromServer();
    String rcUid = deployment.getMetadata().getUid();

    ReplicaSetOperationsImpl rsOperations = new ReplicaSetOperationsImpl(
      new RollingOperationContext(rollingOperationContext.getContainerId(), false, 0, null, rollingOperationContext.getLogWaitTimeout()), context.withName(null));
    ReplicaSetList rcList = rsOperations.withLabels(getDeploymentSelectorLabels(deployment)).list();

    for (ReplicaSet rs : rcList.getItems()) {
      OwnerReference ownerReference = KubernetesResourceUtil.getControllerUid(rs);
      if (ownerReference != null && ownerReference.getUid().equals(rcUid)) {
        rcs.add(rsOperations.withName(rs.getMetadata().getName()));
      }
    }
    return rcs;
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    List<RollableScalableResource<ReplicaSet>> podResources = doGetLog();
    if (!podResources.isEmpty()) {
      if (podResources.size() > 1) {
        LOG.debug("Found {} pods, Using first one to get log reader", podResources.size());
      }
      return podResources.get(0).getLogReader();
    }
    return null;
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    List<RollableScalableResource<ReplicaSet>> replicaSetResources = doGetLog();
    if (!replicaSetResources.isEmpty()) {
      if (replicaSetResources.size() > 1) {
        LOG.debug("Found {} pods, Using first one to get logs", replicaSetResources.size());
      }
      return replicaSetResources.get(0).watchLog(out);
    }
    return null;
  }

  private Deployment sendPatchedDeployment(Map<String, Object> patchedUpdate) {
    Deployment oldDeployment = get();
    try {
      return handlePatch(oldDeployment, patchedUpdate);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(interruptedException);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private ReplicaSetList getReplicaSetListForDeployment(Deployment deployment) {
    return new ReplicaSetOperationsImpl(context).inNamespace(getNamespace()).withLabels(deployment.getSpec().getSelector().getMatchLabels()).list();
  }

  static Map<String, String> getDeploymentSelectorLabels(Deployment deployment) {
    Map<String, String> labels = new HashMap<>();
    if (deployment != null && deployment.getSpec() != null &&
      deployment.getSpec().getTemplate() != null &&
      deployment.getSpec().getTemplate().getMetadata() != null) {
      labels.putAll(deployment.getSpec().getTemplate().getMetadata().getLabels());
    }
    return labels;
  }

}
