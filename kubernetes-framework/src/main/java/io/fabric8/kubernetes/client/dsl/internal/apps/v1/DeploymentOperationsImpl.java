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
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DeploymentOperationsImpl
    extends RollableScalableResourceOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>>
    implements TimeoutImageEditReplacePatchable<Deployment> {

  static final transient Logger LOG = LoggerFactory.getLogger(DeploymentOperationsImpl.class);
  public static final String DEPLOYMENT_KUBERNETES_IO_REVISION = "deployment.kubernetes.io/revision";

  public DeploymentOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  public DeploymentOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(context, superContext.withApiGroupName("apps")
        .withApiGroupVersion("v1")
        .withPlural("deployments"), Deployment.class, DeploymentList.class);
  }

  @Override
  public DeploymentOperationsImpl newInstance(OperationContext context) {
    return new DeploymentOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public DeploymentOperationsImpl newInstance(PodOperationContext context,
      OperationContext superContext) {
    return new DeploymentOperationsImpl(context, superContext);
  }

  @Override
  public Status rollback(DeploymentRollback rollback) {
    return handleDeploymentRollback(rollback);
  }

  @Override
  public RollingUpdater<Deployment, DeploymentList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return null;
  }

  @Override
  public Deployment resume() {
    return RollingUpdater.resume(this);
  }

  @Override
  public Deployment pause() {
    return RollingUpdater.pause(this);
  }

  @Override
  public Deployment restart() {
    return RollingUpdater.restart(this);
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
    deployment.getMetadata().getAnnotations().put(DEPLOYMENT_KUBERNETES_IO_REVISION,
        latestReplicaSet.getMetadata().getAnnotations().get(DEPLOYMENT_KUBERNETES_IO_REVISION));
    deployment.getSpec().setTemplate(previousRevisionReplicaSet.getSpec().getTemplate());

    return sendPatchedObject(get(), deployment);
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

    ReplicaSetOperationsImpl rsOperations = new ReplicaSetOperationsImpl(rollingOperationContext,
        context.withName(null));
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
   *
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return findFirstPodResource().map(Loggable::getLogReader).orElse(null);
  }

  /**
   * Returns an unclosed InputStream. It's the caller responsibility to close it.
   *
   * @return InputStream
   */
  @Override
  public InputStream getLogInputStream() {
    return findFirstPodResource().map(Loggable::getLogInputStream).orElse(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    return findFirstPodResource().map(it -> it.watchLog(out)).orElse(null);
  }

  private Optional<RollableScalableResource<ReplicaSet>> findFirstPodResource() {
    List<RollableScalableResource<ReplicaSet>> podResources = doGetLog();
    if (!podResources.isEmpty()) {
      if (podResources.size() > 1) {
        LOG.debug("Found {} pods, Using first one to get log", podResources.size());
      }
      return Optional.of(podResources.get(0));
    }
    return Optional.empty();
  }

  private ReplicaSetList getReplicaSetListForDeployment(Deployment deployment) {
    return new ReplicaSetOperationsImpl(context.getClient()).inNamespace(getNamespace())
        .withLabels(deployment.getSpec().getSelector().getMatchLabels()).list();
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

  @Override
  protected List<Container> getContainers(Deployment value) {
    return value.getSpec().getTemplate().getSpec().getContainers();
  }

  @Override
  public TimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new DeploymentOperationsImpl(rollingOperationContext.withLimitBytes(limitBytes), context);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new DeploymentOperationsImpl(rollingOperationContext.withTerminatedStatus(true), context);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new DeploymentOperationsImpl(rollingOperationContext.withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable tailingLines(int lines) {
    return new DeploymentOperationsImpl(rollingOperationContext.withTailingLines(lines), context);
  }

  @Override
  public TailPrettyLoggable sinceTime(String timestamp) {
    return new DeploymentOperationsImpl(rollingOperationContext.withSinceTimestamp(timestamp), context);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int seconds) {
    return new DeploymentOperationsImpl(rollingOperationContext.withSinceSeconds(seconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new DeploymentOperationsImpl(rollingOperationContext.withTimestamps(true), context);
  }

}
