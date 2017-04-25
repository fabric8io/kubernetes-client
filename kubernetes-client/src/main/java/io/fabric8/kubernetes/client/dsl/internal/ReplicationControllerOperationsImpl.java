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
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Watchable;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class ReplicationControllerOperationsImpl extends RollableScalableResourceOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>>
  implements TimeoutImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> {

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicationController item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicationController item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, null, apiVersion, "replicationcontrollers", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public RollableScalableResource<ReplicationController, DoneableReplicationController> load(InputStream is) {
    try {
      ReplicationController item = unmarshal(is, ReplicationController.class);
      return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), item, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public NonNamespaceOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>> inNamespace(String namespace) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }


  @Override
  public ImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> withTimeout(long timeout, TimeUnit unit) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, timeout, unit);
  }

  @Override
  public ImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> withTimeoutInMillis(long timeoutInMillis) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  ReplicationController withReplicas(int count) {
    return cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
  }

  @Override
  RollingUpdater<ReplicationController, ReplicationControllerList, DoneableReplicationController> getRollingUpdater(long rollingTimeout, TimeUnit rollingTimeUnit) {
    return new ReplicationControllerRollingUpdater(client, config, namespace, rollingTimeUnit.toMillis(rollingTimeout), config.getLoggingInterval());
  }

  @Override
  int getCurrentReplicas(ReplicationController current) {
    return current.getStatus().getReplicas();
  }

  @Override
  int getDesiredReplicas(ReplicationController item) {
    return item.getSpec().getReplicas();
  }

  @Override
  long getObservedGeneration(ReplicationController current) {
    return (current != null && current.getStatus() != null
      && current.getStatus().getObservedGeneration() != null) ? current.getStatus().getObservedGeneration() : -1;
  }

  @Override
  public RollableScalableResource<ReplicationController, DoneableReplicationController> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public RollableScalableResource<ReplicationController, DoneableReplicationController> fromServer() {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), true, getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public Watchable<Watch, Watcher<ReplicationController>> withResourceVersion(String resourceVersion) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public EditReplacePatchDeletable<ReplicationController, ReplicationController, DoneableReplicationController, Boolean> cascading(boolean enabled) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), enabled, getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ReplicationControllerOperationsImpl rolling() {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), true, rollingTimeout, rollingTimeUnit);
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
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() == 0) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container updatedContainer = new ContainerBuilder(oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next()).withImage(image).build();

    ReplicationControllerBuilder newRCBuilder = new ReplicationControllerBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    return new ReplicationControllerRollingUpdater(client, config, namespace).rollUpdate(oldRC, newRCBuilder.build());
  }

}
