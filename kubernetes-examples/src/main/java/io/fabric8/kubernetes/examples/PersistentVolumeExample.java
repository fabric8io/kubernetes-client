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

package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.NodeSelectorRequirementBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;

public class PersistentVolumeExample {
  private static final Logger logger = LoggerFactory.getLogger(PodDisruptionBudgetExample.class);

  public static void main(String args[]) throws InterruptedException {
    String master = "https://192.168.99.100:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    log("Using master with url ", master);
    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
      log("Creating persistent volume object");
      PersistentVolume pv = new PersistentVolumeBuilder()
        .withNewMetadata().withName("example-local-pv").endMetadata()
        .withNewSpec()
        .addToCapacity(Collections.singletonMap("storage", new Quantity("500Gi")))
        .withAccessModes("ReadWriteOnce")
        .withPersistentVolumeReclaimPolicy("Retain")
        .withStorageClassName("local-storage")
        .withNewLocal()
        .withPath("/mnt/disks/vol1")
        .endLocal()
        .withNewNodeAffinity()
        .withNewRequired()
        .addNewNodeSelectorTerm()
        .withMatchExpressions(Arrays.asList(new NodeSelectorRequirementBuilder()
          .withKey("kubernetes.io/hostname")
          .withOperator("In")
          .withValues("my-node")
          .build()
          ))
        .endNodeSelectorTerm()
        .endRequired()
        .endNodeAffinity()
        .endSpec()
        .build();

      client.persistentVolumes().create(pv);
      log("Successfully created Persistent Volume object");
    } catch (KubernetesClientException e) {
      log("Could not create resource", e.getMessage());
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
