
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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.NodeSelectorRequirementBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;

public class PersistentVolumeClaimExample {
  private static final Logger logger = LoggerFactory.getLogger(PersistentVolumeClaimExample.class);

  public static void main(String[] args) {
    String master = "https://localhost:8443";
    String namespace = "default";
    String storageClassName = "my-local-storage";
    if (args.length == 1) {
      master = args[0];
    }

    log("Using master with url ", master);
    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
      try {

        StorageClass storageClass = client.storage().storageClasses().load(PersistentVolumeClaimExample.class.getResourceAsStream("/test-storage.yml")).get();
        client.storage().storageClasses().create(storageClass);

        log("Creating PersistentVolume object");
        PersistentVolume pv = new PersistentVolumeBuilder()
          .withNewMetadata().withName("test-local-pv").endMetadata()
          .withNewSpec()
          .addToCapacity(Collections.singletonMap("storage", new Quantity("500Gi")))
          .withAccessModes("ReadWriteOnce")
          .withPersistentVolumeReclaimPolicy("Retain")
          .withStorageClassName(storageClassName)
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

        log("Successfully created PersistentVolume object");

        log("Creating PersistentVolumeClaim object");
        PersistentVolumeClaim persistentVolumeClaim = new PersistentVolumeClaimBuilder()
          .withNewMetadata().withName("test-pv-claim").withNamespace(namespace).endMetadata()
          .withNewSpec()
          .withStorageClassName(storageClassName)
          .withAccessModes("ReadWriteOnce")
          .withNewResources()
          .addToRequests("storage", new Quantity("500Gi"))
          .endResources()
          .endSpec()
          .build();

        client.persistentVolumeClaims().create(persistentVolumeClaim);
        log("Successfully created PersistentVolumeClaim object");

        log("Creating pod");
        Pod pod = client.pods().inNamespace(namespace).load(PersistentVolumeClaimExample.class.getResourceAsStream("/test-pv-pod.yml")).get();
        client.pods().inNamespace(namespace).create(pod);

        log("Successfully created pod");
      } finally {
        client.persistentVolumeClaims().inNamespace(namespace).withName("test-pv-claim").delete();
        client.persistentVolumes().withName("test-local-pv").delete(); //fixed the name
        client.pods().inNamespace("default").withName("test-pv-pod").delete(); // you forgot to remove the pod
        client.storage().storageClasses().withName(storageClassName).delete();
      }
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
