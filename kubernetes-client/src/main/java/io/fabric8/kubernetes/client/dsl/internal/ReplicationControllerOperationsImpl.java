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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.builder.Visitor;
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
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.EditReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.ImageEditReplaceable;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplaceable;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ReplicationControllerOperationsImpl extends HasMetadataOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>>
  implements ClientRollableScallableResource<ReplicationController, DoneableReplicationController>,
  TimeoutImageEditReplaceable<ReplicationController, ReplicationController, DoneableReplicationController> {

  static final transient Logger LOG = LoggerFactory.getLogger(ReplicationControllerOperationsImpl.class);

  private final Boolean rolling;
  private final long rollingTimeout;
  private final TimeUnit rollingTimeUnit;

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, false, config.getRollingTimeout(), TimeUnit.MINUTES );
  }

  public ReplicationControllerOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, ReplicationController item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, null, apiVersion, "replicationcontrollers", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
    this.rolling = rolling;
    this.rollingTimeout = rollingTimeout;
    this.rollingTimeUnit = rollingTimeUnit;
    reaper = new ReplicationControllerReaper(this);
  }

  @Override
  public ClientRollableScallableResource<ReplicationController, DoneableReplicationController> load(InputStream is) {
    try {
      ReplicationController item = unmarshal(is, ReplicationController.class);
      return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), item, getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), rolling, rollingTimeout, rollingTimeUnit);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ClientNonNamespaceOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> inNamespace(String namespace) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), rolling, rollingTimeout, rollingTimeUnit);
  }


  @Override
  public ImageEditReplaceable<ReplicationController, ReplicationController, DoneableReplicationController> withTimeout(long timeout, TimeUnit unit) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), rolling, timeout, rollingTimeUnit);
  }

  @Override
  public ImageEditReplaceable<ReplicationController, ReplicationController, DoneableReplicationController> withTimeoutInMillis(long timeoutInMillis) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), rolling, timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  public ReplicationController scale(int count) {
    return scale(count, false);
  }

  @Override
  public ClientRollableScallableResource<ReplicationController, DoneableReplicationController> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), rolling, rollingTimeout, rollingTimeUnit );
  }

  @Override
  public ClientRollableScallableResource<ReplicationController, DoneableReplicationController> fromServer() {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), true, getGracePeriodSeconds(), rolling, rollingTimeout, rollingTimeUnit );
  }

  @Override
  public Watchable<Watch, Watcher<ReplicationController>> withResourceVersion(String resourceVersion) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), resourceVersion, getReloadingFromServer(), getGracePeriodSeconds(), rolling, rollingTimeout, rollingTimeUnit );
  }

  @Override
  public EditReplaceDeletable<ReplicationController, ReplicationController, DoneableReplicationController, Boolean> cascading(boolean enabled) {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), enabled, getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public ReplicationController scale(int count, boolean wait) {
    ReplicationController res = cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      waitUntilRCIsScaled();
      res = getMandatory();
    }
    return res;
  }

  /**
   * Lets wait until there are enough Ready pods of the given RC
   */
  private void waitUntilRCIsScaled() {
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    final AtomicReference<ReplicationController> atomicRC = new AtomicReference<>();

    final Runnable rcPoller = new Runnable() {
      public void run() {
        ReplicationController rc = getMandatory();
        atomicRC.set(rc);
        if (Objects.equals(rc.getSpec().getReplicas(), rc.getStatus().getReplicas())) {
          countDownLatch.countDown();
        } else {
          LOG.debug("Only {}/{} replicas scheduled for ReplicationController: {} in namespace: {} seconds so waiting...",
              rc.getStatus().getReplicas(), rc.getSpec().getReplicas(), rc.getMetadata().getName(), namespace);
        }
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(rcPoller, 0, 100, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await(rollingTimeout, rollingTimeUnit);
      executor.shutdown();
    } catch (InterruptedException e) {
      poller.cancel(true);
      executor.shutdown();
      LOG.error("Only {}/{} pod(s) ready for ReplicationController: {} in namespace: {}  after waiting for {} seconds so giving up",
          atomicRC.get().getStatus().getReplicas(), atomicRC.get().getSpec().getReplicas(), atomicRC.get().getMetadata().getName(), namespace, rollingTimeUnit.toSeconds(rollingTimeout));
    }
  }

  @Override
  public ReplicationControllerOperationsImpl rolling() {
    return new ReplicationControllerOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), true, rollingTimeout, rollingTimeUnit);
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

    return new  RollingUpdater(client, config, namespace).rollUpdate(oldRC, newRCBuilder.build());
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
          new RollingUpdater(client, config, namespace).rollUpdate(getMandatory(), rc);
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
    return new RollingUpdater(client, config, namespace, rollingTimeUnit.toMillis(rollingTimeout), getConfig().getLoggingInterval()).rollUpdate(getMandatory(), rc);
  }

  private static class ReplicationControllerReaper implements Reaper {
    private ReplicationControllerOperationsImpl oper;

    public ReplicationControllerReaper(ReplicationControllerOperationsImpl oper) {
      this.oper = oper;
    }

    @Override
    public void reap() {
      oper.scale(0, true);
    }
  }
}
