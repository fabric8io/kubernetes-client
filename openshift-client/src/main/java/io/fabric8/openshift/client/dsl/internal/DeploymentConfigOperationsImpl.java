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
package io.fabric8.openshift.client.dsl.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import okhttp3.OkHttpClient;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.APPS;

public class DeploymentConfigOperationsImpl extends OpenShiftOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig,
  DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig>> implements DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(DeploymentConfigOperationsImpl.class);
  private static final String DEPLOYMENT_CONFIG_REF = "openshift.io/deployment-config.name";


  public DeploymentConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public DeploymentConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, DeploymentConfig item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, OpenShiftOperation.withApiGroup(client, APPS, apiVersion, config), "deploymentconfigs", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    reaper = new DeploymentConfigReaper(this, client);
  }

  @Override
  public DoneableDeploymentConfig edit() {
    if (isCascading()) {
      return cascading(false).edit();
    }
    return super.edit();
  }

  @Override
  public DeploymentConfig replace(DeploymentConfig item) {
    if (isCascading()) {
      return cascading(false).replace(item);
    }
    return super.replace(item);
  }

  @Override
  public DeploymentConfig patch(DeploymentConfig item) {
    if (isCascading()) {
      return cascading(false).patch(item);
    }
    return super.patch(item);
  }

  @Override
  public DeploymentConfig deployLatest() {
    return deployLatest(false);
  }

  @Override
  public DeploymentConfig deployLatest(boolean wait) {
    Long currentVersion = getMandatory().getStatus().getLatestVersion();
    if(currentVersion == null){
      currentVersion = 1L;
    }
    DeploymentConfig deployment = cascading(false).edit().editStatus().withLatestVersion(++currentVersion).endStatus().done();
    if (wait) {
      waitUntilDeploymentConfigIsScaled(deployment.getSpec().getReplicas());
      deployment = getMandatory();
    }
    return deployment;
  }

  private static class DeploymentConfigReaper implements Reaper {

    private final DeploymentConfigOperationsImpl operation;
    private final OkHttpClient client;

    public DeploymentConfigReaper(DeploymentConfigOperationsImpl operation, OkHttpClient client) {
      this.operation = operation;
      this.client = client;
    }

    @Override
    public boolean reap() {
      DeploymentConfig deployment = operation.cascading(false).edit().editSpec().withReplicas(0).endSpec().done();
      waitForObservedGeneration(deployment.getStatus().getObservedGeneration());

      //We are deleting the DC before reaping the replication controller, because the RC's won't go otherwise.
      Boolean reaped = operation.cascading(false).delete();

      Map<String, String> selector = new HashMap<>();
      selector.put(DEPLOYMENT_CONFIG_REF, deployment.getMetadata().getName());
      if (selector != null && !selector.isEmpty()) {
        Boolean deleted = new ReplicationControllerOperationsImpl(client, operation.getConfig(), operation.getNamespace())
          .withLabels(selector)
          .delete();
      }

      return reaped;
    }

    private void waitForObservedGeneration(final long observedGeneration) {
      final CountDownLatch countDownLatch = new CountDownLatch(1);

      final Runnable deploymentPoller = new Runnable() {
        public void run() {
          DeploymentConfig deployment = operation.getMandatory();
          if (observedGeneration <= deployment.getStatus().getObservedGeneration()) {
            countDownLatch.countDown();
          }
        }
      };

      ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
      ScheduledFuture poller = executor.scheduleWithFixedDelay(deploymentPoller, 0, 10, TimeUnit.MILLISECONDS);
      try {
        countDownLatch.await(1, TimeUnit.MINUTES);
        executor.shutdown();
      } catch (InterruptedException e) {
        poller.cancel(true);
        executor.shutdown();
        throw KubernetesClientException.launderThrowable(e);
      }
    }
  }

  @Override
  public DeploymentConfig scale(int count) {
    return scale(count, false);
  }

  @Override
  public DeploymentConfig scale(int count, boolean wait) {
    DeploymentConfig deployment = cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      waitUntilDeploymentConfigIsScaled(count);
      deployment = getMandatory();
    }
    return deployment;
  }

  @Override
  public DeploymentConfig waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    DeploymentConfig dc = get();
    if (dc == null) {
      throw new IllegalArgumentException("DeploymentConfig with name:[" + name + "] in namespace:[" + namespace + "] not found!");
    }
    return periodicWatchUntilReady(10, System.currentTimeMillis(), Math.max(timeUnit.toMillis(amount) / 10, 1000L), amount);
  }

  /**
   * Lets wait until there are enough Ready pods of the given Deployment
   */
  private void waitUntilDeploymentConfigIsScaled(final int count) {
    final BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(1);
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    final Runnable deploymentPoller = new Runnable() {
      public void run() {
        try {
          DeploymentConfig deploymentConfig = get();
          //If the rs is gone, we shouldn't wait.
          if (deploymentConfig == null) {
            if (count == 0) {
              queue.put(true);
              return;
            } else {
              queue.put(new IllegalStateException("Can't wait for DeploymentConfig: " + checkName(getItem()) + " in namespace: " + checkName(getItem()) + " to scale. Resource is no longer available."));
              return;
            }
          }
          replicasRef.set(deploymentConfig.getStatus().getReplicas());
          int currentReplicas = deploymentConfig.getStatus().getReplicas() != null ? deploymentConfig.getStatus().getReplicas() : 0;
          if (deploymentConfig.getStatus().getObservedGeneration() >= deploymentConfig.getMetadata().getGeneration() && Objects.equals(deploymentConfig.getSpec().getReplicas(), currentReplicas)) {
            queue.put(true);
          } else {
            LOG.debug("Only {}/{} pods scheduled for DeploymentConfig: {} in namespace: {} seconds so waiting...",
              deploymentConfig.getStatus().getReplicas(), deploymentConfig.getSpec().getReplicas(), deploymentConfig.getMetadata().getName(), namespace);
          }
        } catch (Throwable t) {
          LOG.error("Error while waiting for Deployment to be scaled.", t);
        }
      }
    };

      ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
      ScheduledFuture poller = executor.scheduleWithFixedDelay(deploymentPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
      try {
        if (Utils.waitUntilReady(queue, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS)) {
          LOG.debug("{}/{} pod(s) ready for DeploymentConfig: {} in namespace: {}.",
            replicasRef.get(), count, name, namespace);
        } else {
          LOG.error("{}/{} pod(s) ready for DeploymentConfig: {} in namespace: {}  after waiting for {} seconds so giving up",
            replicasRef.get(), count, name, namespace, TimeUnit.MILLISECONDS.toSeconds(getConfig().getScaleTimeout()));
        }
      } finally {
        poller.cancel(true);
        executor.shutdown();
      }
  }
}
