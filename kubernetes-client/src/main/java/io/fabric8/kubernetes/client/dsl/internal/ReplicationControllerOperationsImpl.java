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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.RollableScallableResource;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.internal.readiness.ReadinessWatcher;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

public class ReplicationControllerOperationsImpl extends HasMetadataOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScallableResource<ReplicationController, DoneableReplicationController>>
  implements RollableScallableResource<ReplicationController, DoneableReplicationController>,
  TimeoutImageEditReplacePatchable<ReplicationController, ReplicationController, DoneableReplicationController> {

  static final transient Logger LOG = LoggerFactory.getLogger(ReplicationControllerOperationsImpl.class);

  private final Boolean rolling;
  private final long rollingTimeout;
  private final TimeUnit rollingTimeUnit;

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicationController item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, false, config.getRollingTimeout(), TimeUnit.MILLISECONDS);
  }

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicationController item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, null, apiVersion, "replicationcontrollers", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    this.rolling = rolling;
    this.rollingTimeout = rollingTimeout;
    this.rollingTimeUnit = rollingTimeUnit;
    reaper = new ReplicationControllerReaper(this);
  }

  @Override
  public RollableScallableResource<ReplicationController, DoneableReplicationController> load(InputStream is) {
    try {
      ReplicationController item = unmarshal(is, ReplicationController.class);
      return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), item, getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public NonNamespaceOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScallableResource<ReplicationController, DoneableReplicationController>> inNamespace(String namespace) {
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
  public ReplicationController scale(int count) {
    return scale(count, false);
  }

  @Override
  public RollableScallableResource<ReplicationController, DoneableReplicationController> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public RollableScallableResource<ReplicationController, DoneableReplicationController> fromServer() {
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
  public ReplicationController scale(int count, boolean wait) {
    ReplicationController res = cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      waitUntilRCIsScaled(count);
      res = getMandatory();
    }
    return res;
  }

  /**
   * Lets wait until there are enough Ready pods of the given RC
   */
  private void waitUntilRCIsScaled(final int count) {
    final BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    final Runnable rcPoller = new Runnable() {
      public void run() {
        try {
          ReplicationController rc = get();
          //If the rc is gone, we shouldn't wait.
          if (rc == null) {
            if (count == 0) {
              queue.put(true);
              return;
            } else {
              queue.put(new IllegalStateException("Can't wait for ReplicationController: " + checkName(getItem()) + " in namespace: " + checkName(getItem()) + " to scale. Resource is no longer available."));
            }
          }

          replicasRef.set(rc.getStatus().getReplicas());
          if (Objects.equals(rc.getSpec().getReplicas(), rc.getStatus().getReplicas())) {
            queue.put(true);
          } else {
            LOG.debug("Only {}/{} replicas scheduled for ReplicationController: {} in namespace: {} seconds so waiting...",
              rc.getStatus().getReplicas(), rc.getSpec().getReplicas(), rc.getMetadata().getName(), namespace);
          }
        } catch (Throwable t) {
          LOG.error("Error while waiting for ReplicationController to be scaled.", t);
        }
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(rcPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
    try {
      if (Utils.waitUntilReady(queue, rollingTimeout, rollingTimeUnit)) {
        LOG.debug("{}/{} pod(s) ready for ReplicationController: {} in namespace: {}.",
          replicasRef.get(), count, name, namespace);
      } else {
        LOG.error("{}/{} pod(s) ready for ReplicationController: {} in namespace: {}  after waiting for {} seconds so giving up",
          replicasRef.get(), count, name, namespace, rollingTimeUnit.toSeconds(rollingTimeout));
      }
    } finally {
      poller.cancel(true);
      executor.shutdown();
    }
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

  @Override
  public DoneableReplicationController edit() {
    if (!rolling) {
      return super.edit();
    }

    final Visitor<ReplicationController> visitor = new Visitor<ReplicationController>() {
      @Override
      public void visit(ReplicationController rc) {
        try {
          new ReplicationControllerRollingUpdater(client, config, namespace).rollUpdate(getMandatory(), rc);
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
  public ReplicationController replace(ReplicationController rc) {
    if (!rolling) {
      return super.replace(rc);
    }
    return new ReplicationControllerRollingUpdater(client, config, namespace, rollingTimeUnit.toMillis(rollingTimeout), getConfig().getLoggingInterval()).rollUpdate(getMandatory(), rc);
  }


  @Override
  public ReplicationController waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    ReplicationController rc = get();
    if (rc == null) {
      throw new IllegalArgumentException("ReplicationController with name:[" + name + "] in namespace:[" + namespace + "] not found!");
    }

    return periodicWatchUntilReady(10, System.currentTimeMillis(), Math.max(timeUnit.toMillis(amount) / 10, 1000L), amount);
  }

  private static class ReplicationControllerReaper implements Reaper {
    private ReplicationControllerOperationsImpl oper;

    public ReplicationControllerReaper(ReplicationControllerOperationsImpl oper) {
      this.oper = oper;
    }

    @Override
    public boolean reap() {
      oper.scale(0, true);
      return false;
    }
  }
}
