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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodCondition;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static io.fabric8.kubernetes.client.internal.SerializationUtils.dumpWithoutRuntimeStateAsYaml;

class RollingUpdater<C extends Client> {
  static final String DEPLOYMENT_KEY = "deployment";

  private static final Long DEFAULT_ROLLING_TIMEOUT = 15 * 60 * 1000L;// 15 mins

  private static final transient Logger LOG = LoggerFactory.getLogger(RollingUpdater.class);

  private final OkHttpClient client;
  private final Config config;
  private final String namespace;
  private final long rollingTimeoutMillis;
  private final long loggingIntervalMillis;

  RollingUpdater(OkHttpClient client, Config config, String namespace) {
    this(client, config, namespace, DEFAULT_ROLLING_TIMEOUT, Config.DEFAULT_LOGGING_INTERVAL);
  }

  RollingUpdater(OkHttpClient client, Config config, String namespace, long rollingTimeoutMillis, long loggingIntervalMillis) {
    this.client = client;
    this.config = config;
    this.namespace = namespace;
    this.rollingTimeoutMillis = rollingTimeoutMillis;
    this.loggingIntervalMillis = loggingIntervalMillis;
  }

  ReplicationController rollUpdate(ReplicationController oldRC, ReplicationController newRC) {
    try {
      // Get what namespace we're working in
      String namespace = oldRC.getMetadata().getNamespace();
      // And the old RC name
      String oldRCName = oldRC.getMetadata().getName();

      // Update the old RC to ensure there's no overlap between the new & old RCs' selectors
      String oldDeploymentHash = md5sum(oldRC);

      //Before we update the RC though we need to add the labels to the existing managed pods
      PodList oldRCPods = pods().inNamespace(namespace).withLabels(oldRC.getSpec().getSelector()).list();

      for (Pod pod : oldRCPods.getItems()) {
        pod.getMetadata().getLabels().put(DEPLOYMENT_KEY, oldDeploymentHash);
        try {
          pods().inNamespace(namespace).withName(pod.getMetadata().getName()).replace(pod);
        } catch (KubernetesClientException e) {
          LOG.warn("Unable to add deployment key to pod: {}", e.getMessage());
        }
      }

      // Now we can update the old RC with the new selector
      oldRC.getSpec().getSelector().put(DEPLOYMENT_KEY, oldDeploymentHash);
      oldRC.getSpec().getTemplate().getMetadata().getLabels().put(DEPLOYMENT_KEY, oldDeploymentHash);
      replicationControllers().inNamespace(namespace).withName(oldRCName).cascading(false).replace(oldRC);

      // Get a hash of the new RC for
      String newDeploymentHash = md5sum(newRC);

      // And a name for the cloned RC
      String newRCName = newRC.getMetadata().getName();
      if (newRCName == null || newRCName.equals(oldRC.getMetadata().getName())) {
        newRCName = newRCName + "-" + newDeploymentHash;
      }

      // Create a clone of the requested RC ready for the rolling update:
      //   - Set the new RC replicas to 0 before we do anything so we can scale up ourselves.
      //   - Set the new RC name to contain the hash if matches old RC name.
      //   - Add selector containing deployment hash.
      //   - Ensure it looks like a new RC by resetting resource version.
      ReplicationController clonedRC = new ReplicationControllerBuilder(newRC)
          .editMetadata()
            .withResourceVersion(null)
            .withName(newRCName)
          .endMetadata()
          .editSpec()
            .withReplicas(0).addToSelector(DEPLOYMENT_KEY, newDeploymentHash)
            .editTemplate().editMetadata().addToLabels(DEPLOYMENT_KEY, newDeploymentHash).endMetadata().endTemplate()
          .endSpec()
          .build();

      ReplicationController createdRC = replicationControllers().inNamespace(namespace).create(clonedRC);

      // Now do the scale up/scale down dance
      int oldReplicas = oldRC.getSpec().getReplicas();
      while (createdRC.getSpec().getReplicas() < newRC.getSpec().getReplicas()) {
        int newReplicas = createdRC.getSpec().getReplicas() + 1;
        replicationControllers().inNamespace(namespace).withName(createdRC.getMetadata().getName()).scale(newReplicas, true);
        waitUntilPodsAreReady(createdRC, namespace, newReplicas);
        createdRC.getSpec().setReplicas(newReplicas);

        if (oldReplicas > 0) {
          replicationControllers().inNamespace(namespace).withName(oldRCName).scale(--oldReplicas, true);
          waitUntilPodsAreReady(oldRC, namespace, oldReplicas);
        }
      }

      // Now delete all existing remaining resources, ensure to cascade
      replicationControllers().inNamespace(namespace).withName(oldRCName).delete();

      // Check if we need to rename it back to the original RC name
      if (Objects.equals(oldRCName, newRC.getMetadata().getName())) {
        createdRC.getMetadata().setResourceVersion(null);
        createdRC.getMetadata().setName(oldRCName);

        createdRC = replicationControllers().inNamespace(namespace).create(createdRC);

        replicationControllers().inNamespace(namespace).withName(newRCName).cascading(false).delete();

        Map<String, String> createdRCSelector = createdRC.getSpec().getSelector();
        createdRCSelector.remove(DEPLOYMENT_KEY);
        createdRC.getSpec().getTemplate().getMetadata().getLabels().remove(DEPLOYMENT_KEY);
        createdRC = replicationControllers().inNamespace(namespace).withName(createdRC.getMetadata().getName()).cascading(false).replace(createdRC);
      }

      return createdRC;
    } catch (NoSuchAlgorithmException | JsonProcessingException e) {
      throw new KubernetesClientException("Could not calculate MD5 of RC", e);
    }
  }

  /**
   * Lets wait until there are enough Ready pods of the given RC
   */
  private void waitUntilPodsAreReady(final ReplicationController rc, final String namespace, final int requiredPodCount) {
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    final AtomicInteger podCount = new AtomicInteger(0);

    final Runnable readyPodsPoller = new Runnable() {
      public void run() {
        PodList podList = pods().inNamespace(namespace).withLabels(rc.getSpec().getSelector()).list();
        int count = 0;
        List<Pod> items = podList.getItems();
        for (Pod item : items) {
          for (PodCondition c : item.getStatus().getConditions()) {
            if (c.getType().equals("Ready") && c.getStatus().equals("True")) {
              count++;
            }
          }
        }
        podCount.set(count);
        if (count == requiredPodCount) {
          countDownLatch.countDown();
        }
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(readyPodsPoller, 0, 1, TimeUnit.SECONDS);
    ScheduledFuture logger = executor.scheduleWithFixedDelay(new Runnable() {
      @Override
      public void run() {
        LOG.debug("Only {}/{} pod(s) ready for ReplicationController: {} in namespace: {} seconds so waiting...",
            podCount.get(), requiredPodCount, rc.getMetadata().getName(), namespace);
      }
    }, 0, loggingIntervalMillis, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await(rollingTimeoutMillis, TimeUnit.MILLISECONDS);
      executor.shutdown();
    } catch (InterruptedException e) {
      poller.cancel(true);
      logger.cancel(true);
      executor.shutdown();
      LOG.warn("Only {}/{} pod(s) ready for ReplicationController: {} in namespace: {}  after waiting for {} seconds so giving up",
          podCount.get(), requiredPodCount, rc.getMetadata().getName(), namespace, TimeUnit.MILLISECONDS.toSeconds(rollingTimeoutMillis));
    }
  }

  private String md5sum(HasMetadata obj) throws NoSuchAlgorithmException, JsonProcessingException {
    byte[] digest = MessageDigest.getInstance("MD5").digest(dumpWithoutRuntimeStateAsYaml(obj).getBytes());
    BigInteger i = new BigInteger(1, digest);
    return String.format("%1$032x", i);
  }

  private ClientOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(client, config, namespace);
  }

  private ClientOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(client, config, namespace);
  }

}
