
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class PersistentVolumeClaimExample {
  private static final Logger logger = LoggerFactory.getLogger(PersistentVolumeClaimExample.class);

  public static void main(String[] args) {
    String namespace = "default";
    String storageClassName = "my-local-storage";
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      try {

        StorageClass storageClass = client.storage().v1().storageClasses()
            .load(PersistentVolumeClaimExample.class.getResourceAsStream("/test-storage.yml")).item();
        client.storage().v1().storageClasses().resource(storageClass).create();

        logger.info("Creating PersistentVolume object");
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
            .withMatchExpressions(Collections.singletonList(new NodeSelectorRequirementBuilder()
                .withKey("kubernetes.io/hostname")
                .withOperator("In")
                .withValues("my-node")
                .build()))
            .endNodeSelectorTerm()
            .endRequired()
            .endNodeAffinity()
            .endSpec()
            .build();

        client.persistentVolumes().resource(pv).create();

        logger.info("Successfully created PersistentVolume object");

        logger.info("Creating PersistentVolumeClaim object");
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

        client.persistentVolumeClaims().resource(persistentVolumeClaim).create();
        logger.info("Successfully created PersistentVolumeClaim object");

        logger.info("Creating pod");
        Pod pod = client.pods().inNamespace(namespace)
            .load(PersistentVolumeClaimExample.class.getResourceAsStream("/test-pv-pod.yml")).item();
        client.pods().inNamespace(namespace).resource(pod).create();
        logger.info("Successfully created pod");
      } finally {
        client.persistentVolumeClaims().inNamespace(namespace).withName("test-pv-claim").delete();
        client.persistentVolumes().withName("test-local-pv").delete();
        client.pods().inNamespace("default").withName("test-pv-pod").delete();
        client.storage().v1().storageClasses().withName(storageClassName).delete();
      }
    } catch (KubernetesClientException e) {
      logger.error("Could not create resource: {}", e.getMessage(), e);
    }
  }
}
