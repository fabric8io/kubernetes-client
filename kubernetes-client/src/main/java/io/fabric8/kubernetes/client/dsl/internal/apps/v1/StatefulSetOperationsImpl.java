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
import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionList;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
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
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
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

public class StatefulSetOperationsImpl
    extends RollableScalableResourceOperation<StatefulSet, StatefulSetList, RollableScalableResource<StatefulSet>>
    implements TimeoutImageEditReplacePatchable<StatefulSet> {
  public StatefulSetOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  public StatefulSetOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(context, superContext.withApiGroupName("apps")
        .withApiGroupVersion("v1")
        .withPlural("statefulsets"), StatefulSet.class, StatefulSetList.class);
  }

  @Override
  public StatefulSetOperationsImpl newInstance(OperationContext context) {
    return new StatefulSetOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public StatefulSetOperationsImpl newInstance(PodOperationContext context,
      OperationContext superContext) {
    return new StatefulSetOperationsImpl(context, superContext);
  }

  @Override
  public RollingUpdater<StatefulSet, StatefulSetList> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return null;
  }

  @Override
  public Status rollback(DeploymentRollback deploymentRollback) {
    throw new KubernetesClientException("rollback not supported in case of StatefulSets");
  }

  @Override
  public String getLog(boolean isPretty) {
    return PodOperationUtil.getLog(
        new StatefulSetOperationsImpl(rollingOperationContext.withPrettyOutput(isPretty), context).doGetLog(), isPretty);
  }

  private List<PodResource> doGetLog() {
    StatefulSet statefulSet = requireFromServer();

    return PodOperationUtil.getPodOperationsForController(context,
        rollingOperationContext, statefulSet.getMetadata().getUid(),
        getStatefulSetSelectorLabels(statefulSet));
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
  public StatefulSet restart() {
    return RollingUpdater.restart(this);
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

    return patch(PatchContext.of(PatchType.STRATEGIC_MERGE),
        getKubernetesSerialization().asJson(previousControllerRevision.getData()));
  }

  private ControllerRevisionList getControllerRevisionListForStatefulSet(StatefulSet statefulSet) {
    return this.context.getClient().resources(ControllerRevision.class, ControllerRevisionList.class).inNamespace(namespace)
        .withLabels(statefulSet.getSpec().getSelector().getMatchLabels()).list();
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

  @Override
  protected List<Container> getContainers(StatefulSet value) {
    return value.getSpec().getTemplate().getSpec().getContainers();
  }

  @Override
  public TimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new StatefulSetOperationsImpl(rollingOperationContext.withLimitBytes(limitBytes), context);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new StatefulSetOperationsImpl(rollingOperationContext.withTerminatedStatus(true), context);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new StatefulSetOperationsImpl(rollingOperationContext.withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable tailingLines(int lines) {
    return new StatefulSetOperationsImpl(rollingOperationContext.withTailingLines(lines), context);
  }

  @Override
  public TailPrettyLoggable sinceTime(String timestamp) {
    return new StatefulSetOperationsImpl(rollingOperationContext.withSinceTimestamp(timestamp), context);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int seconds) {
    return new StatefulSetOperationsImpl(rollingOperationContext.withSinceSeconds(seconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new StatefulSetOperationsImpl(rollingOperationContext.withTimestamps(true), context);
  }
}
