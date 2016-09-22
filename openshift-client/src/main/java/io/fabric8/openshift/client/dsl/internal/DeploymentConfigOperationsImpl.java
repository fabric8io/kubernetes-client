/**
 * Copyright (C) 2015 Red Hat, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DeploymentConfigOperationsImpl extends OpenShiftOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig,
  ClientResource<DeploymentConfig, DoneableDeploymentConfig>> {

  public DeploymentConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public DeploymentConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, DeploymentConfig item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, null, apiVersion, "deploymentconfigs", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
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

  private static class DeploymentConfigReaper implements Reaper {

    private final DeploymentConfigOperationsImpl operation;
    private final OkHttpClient client;

    public DeploymentConfigReaper(DeploymentConfigOperationsImpl operation, OkHttpClient client) {
      this.operation = operation;
      this.client = client;
    }

    @Override
    public void reap() {
      DeploymentConfig deployment = operation.cascading(false).edit().editSpec().withReplicas(0).endSpec().done();
      waitForObservedGeneration(deployment.getStatus().getObservedGeneration());
      Map<String, String> selector = deployment.getSpec().getSelector();
      if (selector != null && !selector.isEmpty()) {
        Boolean deleted = new ReplicationControllerOperationsImpl(client, operation.getConfig(), operation.getNamespace())
          .withLabels(selector)
          .delete();
      }
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
}
