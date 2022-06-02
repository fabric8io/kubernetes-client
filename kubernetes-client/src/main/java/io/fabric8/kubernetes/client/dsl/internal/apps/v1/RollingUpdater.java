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
package io.fabric8.kubernetes.client.dsl.internal.apps.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodCondition;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.internal.PatchUtils;
import io.fabric8.kubernetes.client.internal.PatchUtils.Format;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class RollingUpdater<T extends HasMetadata, L> {
  public static final String DEPLOYMENT_KEY = "deployment";

  private static final Long DEFAULT_ROLLING_TIMEOUT = 15 * 60 * 1000L; // 15 mins

  private static final Long DEFAULT_SERVER_GC_WAIT_TIMEOUT = 60 * 1000L; // 60 seconds

  private static final transient Logger LOG = LoggerFactory.getLogger(RollingUpdater.class);

  protected final Client client;
  protected final String namespace;
  private final long rollingTimeoutMillis;
  private final long loggingIntervalMillis;

  protected RollingUpdater(Client client, String namespace) {
    this(client, namespace, DEFAULT_ROLLING_TIMEOUT, Config.DEFAULT_LOGGING_INTERVAL);
  }

  protected RollingUpdater(Client client, String namespace, long rollingTimeoutMillis, long loggingIntervalMillis) {
    this.client = client;
    this.namespace = namespace;
    this.rollingTimeoutMillis = rollingTimeoutMillis;
    this.loggingIntervalMillis = loggingIntervalMillis;
  }

  protected abstract T createClone(T obj, String newName, String newDeploymentHash);

  protected abstract FilterWatchListDeletable<Pod, PodList, PodResource> selectedPodLister(T obj);

  protected abstract T updateDeploymentKey(String name, String hash);

  protected abstract T removeDeploymentKey(String name);

  protected abstract int getReplicas(T obj);

  protected abstract T setReplicas(T obj, int replicas);

  public T rollUpdate(T oldObj, T newObj) {
    try {
      // Get what namespace we're working in
      String namespace = oldObj.getMetadata().getNamespace();
      // And the old RC name
      String oldName = oldObj.getMetadata().getName();

      // Update the old to ensure there's no overlap between the new & old selectors
      String oldDeploymentHash = md5sum(oldObj);

      //Before we update the resource though we need to add the labels to the existing managed pods
      PodList oldPods = selectedPodLister(oldObj).list();

      for (Pod pod : oldPods.getItems()) {
        try {
          Pod old = pods().inNamespace(namespace).withName(pod.getMetadata().getName()).get();
          Pod updated = new PodBuilder(old)
              .editMetadata().addToLabels(DEPLOYMENT_KEY, oldDeploymentHash).endMetadata()
              .build();
          pods().inNamespace(namespace).withName(pod.getMetadata().getName()).replace(updated);
        } catch (KubernetesClientException e) {
          LOG.warn("Unable to add deployment key to pod: {}", e.getMessage());
        }
      }

      // Now we can update the old object with the new selector

      oldObj = updateDeploymentKey(oldName, oldDeploymentHash);

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
        // first delete the resource and orphan its pods.
        resources().inNamespace(namespace).withName(newName).cascading(false).delete();

        waitUntilDeleted(namespace, newName);

        createdObj.getMetadata().setResourceVersion(null);
        createdObj.getMetadata().setName(oldName);

        createdObj = resources().inNamespace(namespace).create(createdObj);
        createdObj = removeDeploymentKey(createdObj.getMetadata().getName());
      }

      return createdObj;
    } catch (NoSuchAlgorithmException | JsonProcessingException e) {
      throw new KubernetesClientException("Could not calculate MD5 of RC", e);
    }
  }

  private static <T> T applyPatch(Resource<T> resource, Map<String, Object> map) {
    return resource.patch(PatchContext.of(PatchType.STRATEGIC_MERGE), Serialization.asJson(map));
  }

  public static <T> T resume(Resource<T> resource) {
    return applyPatch(resource, RollingUpdater.requestPayLoadForRolloutResume());
  }

  public static <T> T pause(Resource<T> resource) {
    return applyPatch(resource, RollingUpdater.requestPayLoadForRolloutPause());
  }

  public static <T> T restart(Resource<T> resource) {
    return applyPatch(resource, RollingUpdater.requestPayLoadForRolloutRestart());
  }

  public static Map<String, Object> requestPayLoadForRolloutPause() {
    Map<String, Object> jsonPatchPayload = new HashMap<>();
    Map<String, Object> spec = new HashMap<>();
    spec.put("paused", true);
    jsonPatchPayload.put("spec", spec);
    return jsonPatchPayload;
  }

  public static Map<String, Object> requestPayLoadForRolloutResume() {
    Map<String, Object> jsonPatchPayload = new HashMap<>();
    Map<String, Object> spec = new HashMap<>();
    spec.put("paused", null);
    jsonPatchPayload.put("spec", spec);
    return jsonPatchPayload;
  }

  public static Map<String, Object> requestPayLoadForRolloutRestart() {
    Map<String, Object> jsonPatchPayload = new HashMap<>();
    Map<String, String> annotations = new HashMap<>();
    annotations.put("kubectl.kubernetes.io/restartedAt",
        new Date().toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    Map<String, Object> templateMetadata = new HashMap<>();
    templateMetadata.put("annotations", annotations);
    Map<String, Object> template = new HashMap<>();
    template.put("metadata", templateMetadata);
    Map<String, Object> deploymentSpec = new HashMap<>();
    deploymentSpec.put("template", template);
    jsonPatchPayload.put("spec", deploymentSpec);
    return jsonPatchPayload;
  }

  /**
   * Lets wait until there are enough Ready pods of the given RC
   */
  private void waitUntilPodsAreReady(final T obj, final String namespace, final int requiredPodCount) {
    final AtomicInteger podCount = new AtomicInteger(0);

    CompletableFuture<List<Pod>> future = selectedPodLister(obj).informOnCondition(items -> {
      int count = 0;
      for (Pod item : items) {
        for (PodCondition c : item.getStatus().getConditions()) {
          if (c.getType().equals("Ready") && c.getStatus().equals("True")) {
            count++;
          }
        }
      }
      podCount.set(count);
      return count == requiredPodCount;
    });

    Future<?> logger = Utils.scheduleAtFixedRate(Runnable::run,
        () -> LOG.debug("Only {}/{} pod(s) ready for {}: {} in namespace: {} seconds so waiting...",
            podCount.get(), requiredPodCount, obj.getKind(), obj.getMetadata().getName(), namespace),
        0, loggingIntervalMillis, TimeUnit.MILLISECONDS);

    try {
      if (!Utils.waitUntilReady(future, rollingTimeoutMillis, TimeUnit.MILLISECONDS)) {
        LOG.warn("Only {}/{} pod(s) ready for {}: {} in namespace: {}  after waiting for {} seconds so giving up",
            podCount.get(), requiredPodCount, obj.getKind(), obj.getMetadata().getName(), namespace,
            TimeUnit.MILLISECONDS.toSeconds(rollingTimeoutMillis));
      }
    } finally {
      future.cancel(true);
      logger.cancel(true);
    }
  }

  /**
   * Since k8s v1.4.x, rc/rs deletes are asynchronous.
   * Lets wait until the resource is actually deleted in the server
   */
  private void waitUntilDeleted(final String namespace, final String name) {
    Future<?> logger = Utils.scheduleAtFixedRate(Runnable::run,
        () -> LOG.debug("Found resource {}/{} not yet deleted on server, so waiting...", namespace, name),
        0, loggingIntervalMillis, TimeUnit.MILLISECONDS);
    try {
      resources().inNamespace(namespace)
          .withName(name)
          .waitUntilCondition(Objects::isNull, DEFAULT_SERVER_GC_WAIT_TIMEOUT, TimeUnit.MILLISECONDS);
    } finally {
      logger.cancel(true); // since we're using the common pool, we must shutdown manually
    }
  }

  private String md5sum(HasMetadata obj) throws NoSuchAlgorithmException, JsonProcessingException {
    byte[] digest = MessageDigest.getInstance("MD5").digest(PatchUtils.withoutRuntimeState(obj, Format.YAML, true).getBytes());
    BigInteger i = new BigInteger(1, digest);
    return String.format("%1$032x", i);
  }

  protected abstract MixedOperation<T, L, RollableScalableResource<T>> resources();

  protected MixedOperation<Pod, PodList, PodResource> pods() {
    return new PodOperationsImpl(client);
  }

  protected FilterWatchListDeletable<Pod, PodList, PodResource> selectedPodLister(LabelSelector selector) {
    return pods().inNamespace(namespace).withLabelSelector(selector);
  }

}
