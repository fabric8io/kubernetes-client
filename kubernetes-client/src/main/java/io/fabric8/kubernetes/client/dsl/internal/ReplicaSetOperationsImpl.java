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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.extensions.DoneableReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Watchable;
import okhttp3.OkHttpClient;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class ReplicaSetOperationsImpl extends RollableScalableResourceOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet, RollableScalableResource<ReplicaSet, DoneableReplicaSet>>
  implements TimeoutImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> {

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, "v1beta1", namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicaSet item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicaSet item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, "extensions", apiVersion, "replicasets", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> withTimeout(long timeout, TimeUnit unit) {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, timeout, unit);
  }

  @Override
  public ImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> withTimeoutInMillis(long timeoutInMillis) {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  public RollableScalableResource<ReplicaSet, DoneableReplicaSet> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public RollableScalableResource<ReplicaSet, DoneableReplicaSet> fromServer() {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), true, getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public Watchable<Watch, Watcher<ReplicaSet>> withResourceVersion(String resourceVersion) {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public EditReplacePatchDeletable<ReplicaSet, ReplicaSet, DoneableReplicaSet, Boolean> cascading(boolean enabled) {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), enabled, getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ReplicaSetOperationsImpl rolling() {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), true, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ReplicaSet updateImage(String image) {
    ReplicaSet oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing replica set doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multicontainer pods");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() == 0) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container updatedContainer = new ContainerBuilder(oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next()).withImage(image).build();

    ReplicaSetBuilder newRCBuilder = new ReplicaSetBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    return new ReplicaSetRollingUpdater(client, config, namespace).rollUpdate(oldRC, newRCBuilder.build());
  }

  @Override
  public ReplicaSet waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    ReplicaSet rs = get();
    if (rs == null) {
      throw new IllegalArgumentException("ReplicaSet with name:[" + name + "] in namespace:[" + namespace + "] not found!");
    }

    return periodicWatchUntilReady(10, System.currentTimeMillis(), Math.max(timeUnit.toMillis(amount) / 10, 1000L), amount);
  }

  @Override
  ReplicaSet withReplicas(int count) {
    return cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
  }

  @Override
  RollingUpdater<ReplicaSet, ReplicaSetList, DoneableReplicaSet> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new ReplicaSetRollingUpdater(client, config, getNamespace(), rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  int getCurrentReplicas(ReplicaSet current) {
    return current.getStatus().getReplicas();
  }

  @Override
  int getDesiredReplicas(ReplicaSet item) {
    return item.getSpec().getReplicas();
  }

  @Override
  long getObservedGeneration(ReplicaSet current) {
    return (current != null && current.getStatus() != null
      && current.getStatus().getObservedGeneration() != null)? current.getStatus().getObservedGeneration() : -1;
  }
}
