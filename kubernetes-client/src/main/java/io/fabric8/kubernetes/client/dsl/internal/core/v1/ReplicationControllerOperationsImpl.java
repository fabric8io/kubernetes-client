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
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollableScalableResourceOperation;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollingUpdater;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReplicationControllerOperationsImpl extends
    RollableScalableResourceOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>>
    implements TimeoutImageEditReplacePatchable<ReplicationController> {

  public ReplicationControllerOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  public ReplicationControllerOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(context, superContext.withPlural("replicationcontrollers"), ReplicationController.class,
        ReplicationControllerList.class);
  }

  @Override
  public ReplicationControllerOperationsImpl newInstance(OperationContext context) {
    return new ReplicationControllerOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public ReplicationControllerOperationsImpl newInstance(PodOperationContext context,
      OperationContext superContext) {
    return new ReplicationControllerOperationsImpl(context, superContext);
  }

  @Override
  public ReplicationController withReplicas(int count) {
    return accept(r -> r.getSpec().setReplicas(count));
  }

  @Override
  public RollingUpdater<ReplicationController, ReplicationControllerList> getRollingUpdater(long rollingTimeout,
      TimeUnit rollingTimeUnit) {
    return new ReplicationControllerRollingUpdater(context.getClient(), namespace, rollingTimeUnit.toMillis(rollingTimeout),
        getRequestConfig().getLoggingInterval());
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
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of ReplicationControllers");
  }

  @Override
  public String getLog(boolean isPretty) {
    return PodOperationUtil.getLog(
        new ReplicationControllerOperationsImpl(rollingOperationContext.withPrettyOutput(isPretty), context).doGetLog(),
        isPretty);
  }

  private List<PodResource> doGetLog() {
    ReplicationController rc = requireFromServer();

    return PodOperationUtil.getPodOperationsForController(context,
        rollingOperationContext, rc.getMetadata().getUid(),
        getReplicationControllerPodLabels(rc));
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   *
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return PodOperationUtil.getLogReader(doGetLog());
  }

  /**
   * Returns an unclosed InputStream. It's the caller responsibility to close it.
   *
   * @return InputStream
   */
  @Override
  public InputStream getLogInputStream() {
    return PodOperationUtil.getLogInputStream(doGetLog());
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    return PodOperationUtil.watchLog(doGetLog(), out);
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
    throw new UnsupportedOperationException("no rollbacker has been implemented for \"" + get().getKind() + "\"");
  }

  static Map<String, String> getReplicationControllerPodLabels(ReplicationController replicationController) {
    Map<String, String> labels = new HashMap<>();
    if (replicationController != null && replicationController.getSpec() != null
        && replicationController.getSpec().getSelector() != null) {
      labels.putAll(replicationController.getSpec().getSelector());
    }
    return labels;
  }

  @Override
  protected List<Container> getContainers(ReplicationController value) {
    return value.getSpec().getTemplate().getSpec().getContainers();
  }

  @Override
  public TimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withLimitBytes(limitBytes), context);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withTerminatedStatus(true), context);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable tailingLines(int lines) {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withTailingLines(lines), context);
  }

  @Override
  public TailPrettyLoggable sinceTime(String timestamp) {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withSinceTimestamp(timestamp), context);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int seconds) {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withSinceSeconds(seconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new ReplicationControllerOperationsImpl(rollingOperationContext.withTimestamps(true), context);
  }
}
