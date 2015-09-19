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
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.GenericKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;

import static io.fabric8.kubernetes.client.internal.SerializationUtils.dumpWithoutRuntimeStateAsYaml;

class RollingUpdater<C extends Client> {

  static final String DEPLOYMENT_KEY = "deployment";

  private C client;

  RollingUpdater(C client) {
    this.client = client;
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
        pods().inNamespace(namespace).withName(pod.getMetadata().getName()).replace(pod);
      }

      // Now we can update the old RC with the new selector
      oldRC.getSpec().getSelector().put(DEPLOYMENT_KEY, oldDeploymentHash);
      oldRC.getSpec().getTemplate().getMetadata().getLabels().put(DEPLOYMENT_KEY, oldDeploymentHash);
      replicationControllers().inNamespace(namespace).withName(oldRCName).cascading(false).replace(oldRC);

      // Ensure it looks like a new RC
      newRC.getMetadata().setResourceVersion(null);

      int requestedNewReplicas = newRC.getSpec().getReplicas();

      // Set the new RC replicas to 0 before we do anything so we can scale up ourselves
      newRC.getSpec().setReplicas(0);

      // Set the selector for the new deployment
      String newDeploymentHash = md5sum(newRC);
      newRC.getSpec().getSelector().put(DEPLOYMENT_KEY, newDeploymentHash);
      newRC.getSpec().getTemplate().getMetadata().getLabels().put(DEPLOYMENT_KEY, newDeploymentHash);

      String newRCName = newRC.getMetadata().getName();

      if (newRCName == null || newRCName.equals(oldRC.getMetadata().getName())) {
        newRC.getMetadata().setName(oldRCName + "-" + newDeploymentHash);
      }

      ReplicationController createdRC = replicationControllers().inNamespace(namespace).create(newRC);

      // Now do the scale up/scale down dance
      int oldReplicas = oldRC.getSpec().getReplicas();
      while (createdRC.getSpec().getReplicas() < requestedNewReplicas) {
        int newReplicas = createdRC.getSpec().getReplicas() + 1;
        replicationControllers().inNamespace(namespace).withName(createdRC.getMetadata().getName()).scale(newReplicas, true);
        createdRC.getSpec().setReplicas(newReplicas);

        if (oldReplicas > 0) {
          replicationControllers().inNamespace(namespace).withName(oldRCName).scale(--oldReplicas, true);
        }
      }

      // Now delete all existing remaining resources, ensure to cascade
      replicationControllers().inNamespace(namespace).withName(oldRCName).delete();

      // Check if we need to rename it back to the original RC name
      if (Objects.equals(oldRCName, newRCName)) {
        createdRC.getMetadata().setResourceVersion(null);
        createdRC.getMetadata().setName(oldRCName);

        createdRC = replicationControllers().inNamespace(namespace).create(createdRC);

        replicationControllers().inNamespace(namespace).withName(oldRCName + "-" + newDeploymentHash).cascading(false).delete();

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

  private String md5sum(HasMetadata obj) throws NoSuchAlgorithmException, JsonProcessingException {
    byte[] digest = MessageDigest.getInstance("MD5").digest(dumpWithoutRuntimeStateAsYaml(obj).getBytes());
    BigInteger i = new BigInteger(1, digest);
    return String.format("%1$032x", i);
  }

  private ClientOperation<C, ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl<C>(client);
  }

  private ClientOperation<C, Pod, PodList, DoneablePod, ClientLoggableResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl<C>(client);
  }

}
