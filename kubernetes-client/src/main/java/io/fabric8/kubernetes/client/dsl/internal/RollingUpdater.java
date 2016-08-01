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
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodCondition;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static io.fabric8.kubernetes.client.internal.SerializationUtils.dumpWithoutRuntimeStateAsYaml;

abstract class RollingUpdater<T extends HasMetadata, L, D extends Doneable<T>> {
  static final String DEPLOYMENT_KEY = "deployment";

  private static final Long DEFAULT_ROLLING_TIMEOUT = 15 * 60 * 1000L; // 15 mins

  private static final transient Logger LOG = LoggerFactory.getLogger(RollingUpdater.class);

  protected final OkHttpClient client;
  protected final Config config;
  protected final String namespace;
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

  protected abstract T createClone(T obj, String newName, String newDeploymentHash);

  protected abstract PodList listSelectedPods(T obj);

  protected abstract void updateDeploymentKey(D obj, String hash);

  protected abstract void removeDeploymentKey(D obj);

  protected abstract int getReplicas(T obj);

  protected abstract T setReplicas(T obj, int replicas);

  T rollUpdate(T oldObj, T newObj) {
    try {
      // Get what namespace we're working in
      String namespace = oldObj.getMetadata().getNamespace();
      // And the old RC name
      String oldName = oldObj.getMetadata().getName();

      // Update the old to ensure there's no overlap between the new & old selectors
      String oldDeploymentHash = md5sum(oldObj);

      //Before we update the resource though we need to add the labels to the existing managed pods
      PodList oldPods = listSelectedPods(oldObj);

      for (Pod pod : oldPods.getItems()) {
        try {
          pods().inNamespace(namespace).withName(pod.getMetadata().getName())
            .edit()
            .editMetadata().addToLabels(DEPLOYMENT_KEY, oldDeploymentHash)
            .and().done();
        } catch (KubernetesClientException e) {
          LOG.warn("Unable to add deployment key to pod: {}", e.getMessage());
        }
      }

      // Now we can update the old object with the new selector
      D editable = resources().inNamespace(namespace).withName(oldName).cascading(false).edit();
      updateDeploymentKey(editable, oldDeploymentHash);
      oldObj = editable.done();

      // Get a hash of the new RC for
      String newDeploymentHash = md5sum(newObj);

      // And a name for the cloned object
      String newName = newObj.getMetadata().getName();
      if (newName == null || newName.equals(oldName)) {
        newName = newName + "-" + newDeploymentHash;
      }

      // Create a clone of the requested RC ready for the rolling update:
      //   - Set the new RC replicas to 0 before we do anything so we can scale up ourselves.
      //   - Set the new RC name to contain the hash if matches old RC name.
      //   - Add selector containing deployment hash.
      //   - Ensure it looks like a new RC by resetting resource version.
      T clonedObj = createClone(newObj, newName, newDeploymentHash);
      T createdObj = resources().inNamespace(namespace).create(clonedObj);

      // Now do the scale up/scale down dance
      int oldReplicas = getReplicas(oldObj);
      while (getReplicas(createdObj) < getReplicas(newObj)) {
        int newReplicas = getReplicas(createdObj) + 1;
        resources().inNamespace(namespace).withName(createdObj.getMetadata().getName()).scale(newReplicas, true);
        waitUntilPodsAreReady(createdObj, namespace, newReplicas);
        createdObj = setReplicas(createdObj, newReplicas);

        if (oldReplicas > 0) {
          resources().inNamespace(namespace).withName(oldName).scale(--oldReplicas, true);
          waitUntilPodsAreReady(oldObj, namespace, oldReplicas);
        }
      }

      // Now delete all existing remaining resources, ensure to cascade
      resources().inNamespace(namespace).withName(oldName).delete();

      // Check if we need to rename it back to the original RC name
      if (Objects.equals(oldName, newObj.getMetadata().getName())) {
        createdObj.getMetadata().setResourceVersion(null);
        createdObj.getMetadata().setName(oldName);

        createdObj = resources().inNamespace(namespace).create(createdObj);

        resources().inNamespace(namespace).withName(newName).cascading(false).delete();

        editable = resources().inNamespace(namespace).withName(createdObj.getMetadata().getName()).cascading(false).edit();
        removeDeploymentKey(editable);
        createdObj = editable.done();
      }

      return createdObj;
    } catch (NoSuchAlgorithmException | JsonProcessingException e) {
      throw new KubernetesClientException("Could not calculate MD5 of RC", e);
    }
  }

  /**
   * Lets wait until there are enough Ready pods of the given RC
   */
  private void waitUntilPodsAreReady(final T obj, final String namespace, final int requiredPodCount) {
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    final AtomicInteger podCount = new AtomicInteger(0);

    final Runnable readyPodsPoller = new Runnable() {
      public void run() {
        PodList podList = listSelectedPods(obj);
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
        LOG.debug("Only {}/{} pod(s) ready for {}: {} in namespace: {} seconds so waiting...",
            podCount.get(), requiredPodCount, obj.getKind(), obj.getMetadata().getName(), namespace);
      }
    }, 0, loggingIntervalMillis, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await(rollingTimeoutMillis, TimeUnit.MILLISECONDS);
      executor.shutdown();
    } catch (InterruptedException e) {
      poller.cancel(true);
      logger.cancel(true);
      executor.shutdown();
      LOG.warn("Only {}/{} pod(s) ready for {}: {} in namespace: {}  after waiting for {} seconds so giving up",
          podCount.get(), requiredPodCount, obj.getKind(), obj.getMetadata().getName(), namespace, TimeUnit.MILLISECONDS.toSeconds(rollingTimeoutMillis));
    }
  }

  private String md5sum(HasMetadata obj) throws NoSuchAlgorithmException, JsonProcessingException {
    byte[] digest = MessageDigest.getInstance("MD5").digest(dumpWithoutRuntimeStateAsYaml(obj).getBytes());
    BigInteger i = new BigInteger(1, digest);
    return String.format("%1$032x", i);
  }

  protected abstract ClientOperation<T, L, D, ClientRollableScallableResource<T, D>> resources();

  protected ClientOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(client, config, namespace);
  }

}
