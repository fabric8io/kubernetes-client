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

import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.builder.Visitor;
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
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ReplicaSetOperationsImpl extends HasMetadataOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet, ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet>>
  implements ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet>,
  TimeoutImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> {

  static final transient Logger LOG = LoggerFactory.getLogger(ReplicationControllerOperationsImpl.class);

  private final Boolean rolling;
  private final long rollingTimeout;
  private final TimeUnit rollingTimeUnit;

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, "v1beta1", namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicaSet item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicaSetOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicaSet item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, "extensions", apiVersion, "replicasets", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    this.rolling = rolling;
    this.rollingTimeout = rollingTimeout;
    this.rollingTimeUnit = rollingTimeUnit;
    reaper = new ReplicaSetReaper(this);
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
  public ReplicaSet scale(int count) {
    return scale(count, false);
  }

  @Override
  public ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet> fromServer() {
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
  public ReplicaSet scale(int count, boolean wait) {
    ReplicaSet res = cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      waitUntilScaled();
      res = getMandatory();
    }
    return res;
  }

  /**
   * Lets wait until there are enough Ready pods
   */
  private void waitUntilScaled() {
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    final AtomicReference<ReplicaSet> atomicRC = new AtomicReference<>();

    final Runnable rcPoller = new Runnable() {
      public void run() {
        ReplicaSet rc = getMandatory();
        atomicRC.set(rc);
        if (rc.getStatus().getObservedGeneration() >= rc.getMetadata().getGeneration() && Objects.equals(rc.getSpec().getReplicas(), rc.getStatus().getReplicas())) {
          countDownLatch.countDown();
        } else {
          LOG.debug("Only {}/{} replicas scheduled for ReplicaSet: {} in namespace: {} seconds so waiting...",
            rc.getStatus().getReplicas(), rc.getSpec().getReplicas(), rc.getMetadata().getName(), namespace);
        }
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(rcPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await(rollingTimeout, rollingTimeUnit);
      executor.shutdown();
    } catch (InterruptedException e) {
      poller.cancel(true);
      executor.shutdown();
      LOG.error("Only {}/{} pod(s) ready for ReplicaSet: {} in namespace: {}  after waiting for {} seconds so giving up",
        atomicRC.get().getStatus().getReplicas(), atomicRC.get().getSpec().getReplicas(), atomicRC.get().getMetadata().getName(), namespace, rollingTimeUnit.toSeconds(rollingTimeout));
    }
  }

  @Override
  public ReplicaSetOperationsImpl rolling() {
    return new ReplicaSetOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), true, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ReplicaSet updateImage(String image) {
    ReplicaSet oldRC = get();

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

    ReplicaSetBuilder newRCBuilder = new ReplicaSetBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    return new ReplicaSetRollingUpdater(client, config, namespace).rollUpdate(oldRC, newRCBuilder.build());
  }

  @Override
  public DoneableReplicaSet edit() {
    if (!rolling) {
      return super.edit();
    }

    final Visitor<ReplicaSet> visitor = new Visitor<ReplicaSet>() {
      @Override
      public void visit(ReplicaSet rc) {
        try {
          new ReplicaSetRollingUpdater(client, config, namespace).rollUpdate(getMandatory(), rc);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(getType(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public ReplicaSet replace(ReplicaSet rc) {
    if (!rolling) {
      return super.replace(rc);
    }
    return new ReplicaSetRollingUpdater(client, config, namespace, rollingTimeUnit.toMillis(rollingTimeout), getConfig().getLoggingInterval()).rollUpdate(getMandatory(), rc);
  }

  @Override
  public ReplicaSet patch(ReplicaSet rc) {
    if (!rolling) {
      return super.patch(rc);
    }
    return new ReplicaSetRollingUpdater(client, config, namespace, rollingTimeUnit.toMillis(rollingTimeout), getConfig().getLoggingInterval()).rollUpdate(getMandatory(), rc);
  }

  private static class ReplicaSetReaper implements Reaper {
    private ReplicaSetOperationsImpl oper;

    public ReplicaSetReaper(ReplicaSetOperationsImpl oper) {
      this.oper = oper;
    }

    @Override
    public void reap() {
      oper.scale(0, true);
    }
  }
}
