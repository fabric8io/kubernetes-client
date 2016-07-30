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
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.DoneableDeployment;
import io.fabric8.kubernetes.api.model.extensions.LabelSelector;
import io.fabric8.kubernetes.api.model.extensions.LabelSelectorRequirement;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientScaleableResource;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class DeploymentOperationsImpl extends HasMetadataOperation<Deployment, DeploymentList, DoneableDeployment, ClientScaleableResource<Deployment, DoneableDeployment>>
  implements ClientScaleableResource<Deployment, DoneableDeployment> {

  static final transient Logger LOG = LoggerFactory.getLogger(DeploymentOperationsImpl.class);

  public DeploymentOperationsImpl(OkHttpClient client, Config config, String namespace) {
      this(client, config, "v1beta1", namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public DeploymentOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Deployment item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, "extensions", apiVersion, "deployments", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    reaper = new DeploymentReaper(this);
  }

  @Override
  public Deployment scale(int count) {
    return scale(count, false);
  }

  @Override
  public Deployment scale(int count, boolean wait) {
    Deployment res = cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      waitUntilDeploymentIsScaled();
      res = getMandatory();
    }
    return res;
  }

  @Override
  public DoneableDeployment edit() {
    if (isCascading()) {
      return cascading(false).edit();
    }
    return super.edit();
  }

  @Override
  public Deployment replace(Deployment item) {
    if (isCascading()) {
      return cascading(false).replace(item);
    }
    return super.replace(item);
  }

  @Override
  public Deployment patch(Deployment item) {
    if (isCascading()) {
      return cascading(false).patch(item);
    }
    return super.patch(item);
  }

  /**
   * Lets wait until there are enough Ready pods of the given Deployment
   */
  private void waitUntilDeploymentIsScaled() {
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    final AtomicReference<Deployment> atomicDeployment = new AtomicReference<>();

    final Runnable deploymentPoller = new Runnable() {
      public void run() {
        Deployment deployment = getMandatory();
        atomicDeployment.set(deployment);
        int currentReplicas = deployment.getStatus().getReplicas() != null ? deployment.getStatus().getReplicas() : 0;
        if (deployment.getStatus().getObservedGeneration() >= deployment.getMetadata().getGeneration() && Objects.equals(deployment.getSpec().getReplicas(), currentReplicas)) {
          countDownLatch.countDown();
        } else {
          LOG.debug("Only {}/{} pods scheduled for Deployment: {} in namespace: {} seconds so waiting...",
            deployment.getStatus().getReplicas(), deployment.getSpec().getReplicas(), deployment.getMetadata().getName(), namespace);
        }
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(deploymentPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await(getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS);
      executor.shutdown();
    } catch (InterruptedException e) {
      poller.cancel(true);
      executor.shutdown();
      int currentReplicas = atomicDeployment.get().getStatus().getReplicas() != null ? atomicDeployment.get().getStatus().getReplicas() : 0;
      LOG.error("Only {}/{} pod(s) ready for Deployment: {} in namespace: {} - giving up",
        currentReplicas, atomicDeployment.get().getSpec().getReplicas(), atomicDeployment.get().getMetadata().getName(), namespace);
    }
  }

  private static class DeploymentReaper implements Reaper {
    private DeploymentOperationsImpl oper;

    public DeploymentReaper(DeploymentOperationsImpl oper) {
      this.oper = oper;
    }

    @Override
    public void reap() {
      Deployment deployment = oper.cascading(false).edit().editSpec().withReplicas(0).withPaused(true).withRevisionHistoryLimit(0).endSpec().done();
      waitForObservedGeneration(deployment.getStatus().getObservedGeneration());
      reapMatchingReplicaSets(deployment.getSpec().getSelector());
    }

    private void waitForObservedGeneration(final long observedGeneration) {
      final CountDownLatch countDownLatch = new CountDownLatch(1);

      final Runnable deploymentPoller = new Runnable() {
        public void run() {
          Deployment deployment = oper.getMandatory();
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

    private void reapMatchingReplicaSets(LabelSelector selector) {
      if (selector == null || (selector.getMatchLabels() == null && selector.getMatchExpressions() == null)) {
        return;
      }
      ReplicaSetOperationsImpl rsOper = new ReplicaSetOperationsImpl(oper.client, oper.getConfig(), oper.getNamespace());
      rsOper.inNamespace(oper.getNamespace());
      if (selector.getMatchLabels() != null) {
        for (Map.Entry<String, String> entry : selector.getMatchLabels().entrySet()) {
          rsOper.withLabel(entry.getKey(), entry.getValue());
        }
      }
      if (selector.getMatchExpressions() != null) {
        for (LabelSelectorRequirement req : selector.getMatchExpressions()) {
          switch (req.getOperator()) {
            case "In":
              rsOper.withLabelIn(req.getKey(), req.getValues().toArray(new String[]{}));
              break;
            case "NotIn":
              rsOper.withLabelNotIn(req.getKey(), req.getValues().toArray(new String[]{}));
              break;
            case "DoesNotExist":
              rsOper.withoutLabel(req.getKey());
              break;
            case "Exists":
              rsOper.withLabel(req.getKey());
              break;
          }
        }
      }

      rsOper.delete();
    }
  }
}
