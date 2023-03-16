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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
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
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReplicaSetOperationsImpl
    extends RollableScalableResourceOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>>
    implements TimeoutImageEditReplacePatchable<ReplicaSet> {

  public ReplicaSetOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  ReplicaSetOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(context, superContext.withApiGroupName("apps")
        .withApiGroupVersion("v1")
        .withPlural("replicasets"), ReplicaSet.class, ReplicaSetList.class);
  }

  @Override
  public ReplicaSetOperationsImpl newInstance(OperationContext context) {
    return new ReplicaSetOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public ReplicaSetOperationsImpl newInstance(PodOperationContext context,
      OperationContext superContext) {
    return new ReplicaSetOperationsImpl(context, superContext);
  }

  @Override
  public RollingUpdater<ReplicaSet, ReplicaSetList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new ReplicaSetRollingUpdater(context.getClient(), getNamespace(), rollingTimeUnit.toMillis(rollingTimeout),
        getRequestConfig().getLoggingInterval());
  }

  @Override
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of ReplicaSets");
  }

  @Override
  public String getLog(boolean isPretty) {
    return PodOperationUtil
        .getLog(new ReplicaSetOperationsImpl(rollingOperationContext.withPrettyOutput(isPretty), context).doGetLog(), isPretty);
  }

  private List<PodResource> doGetLog() {
    ReplicaSet replicaSet = requireFromServer();
    return PodOperationUtil.getPodOperationsForController(context,
        rollingOperationContext, replicaSet.getMetadata().getUid(),
        getReplicaSetSelectorLabels(replicaSet));
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

  static Map<String, String> getReplicaSetSelectorLabels(ReplicaSet replicaSet) {
    Map<String, String> labels = new HashMap<>();

    if (replicaSet != null && replicaSet.getSpec() != null && replicaSet.getSpec().getSelector() != null) {
      labels.putAll(replicaSet.getSpec().getSelector().getMatchLabels());
    }
    return labels;
  }

  @Override
  protected List<Container> getContainers(ReplicaSet value) {
    return value.getSpec().getTemplate().getSpec().getContainers();
  }

  @Override
  public TimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withLimitBytes(limitBytes), context);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withTerminatedStatus(true), context);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable tailingLines(int lines) {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withTailingLines(lines), context);
  }

  @Override
  public TailPrettyLoggable sinceTime(String timestamp) {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withSinceTimestamp(timestamp), context);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int seconds) {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withSinceSeconds(seconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new ReplicaSetOperationsImpl(rollingOperationContext.withTimestamps(true), context);
  }
}
