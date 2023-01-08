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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.NodeSelectorRequirementBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.PersistentVolumeListBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class PersistentVolumeTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void testList() {
    server.expect().withPath("/api/v1/persistentvolumes").andReturn(200, new PersistentVolumeListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .build()).once();

    PersistentVolumeList persistentVolumeList = client.persistentVolumes().list();
    assertNotNull(persistentVolumeList);
    assertEquals(2, persistentVolumeList.getItems().size());
  }

  @Test
  public void testListWithLables() {
    server.expect().withPath("/api/v1/persistentvolumes?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new PersistentVolumeListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    PersistentVolumeList persistentVolumeList = client.persistentVolumes()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();

    assertNotNull(persistentVolumeList);
    assertEquals(3, persistentVolumeList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/api/v1/persistentvolumes/persistentvolume1")
        .andReturn(200, new PersistentVolumeBuilder().build()).once();
    PersistentVolume persistentVolume = client.persistentVolumes().withName("persistentvolume1").get();
    assertNotNull(persistentVolume);
  }

  @Test
  public void testEditMissing() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      server.expect().withPath("/api/v1/persistentvolumes/persistentvolume").andReturn(404, "error message from kubernetes")
          .always();

      client.persistentVolumes().withName("persistentvolume").edit(p -> p);
    });

  }

  @Test
  public void testDelete() {
    server.expect().withPath("/api/v1/persistentvolumes/persistentvolume1")
        .andReturn(200, new PersistentVolumeBuilder().build()).once();
    boolean deleted = client.persistentVolumes().withName("persistentvolume1").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  public void testDeleteMulti() {
    PersistentVolume persistentVolume1 = new PersistentVolumeBuilder().withNewMetadata().withName("persistentvolume1")
        .endMetadata().build();
    PersistentVolume persistentVolume2 = new PersistentVolumeBuilder().withNewMetadata().withName("persistentvolume2")
        .endMetadata().build();

    server.expect().withPath("/api/v1/persistentvolumes/persistentvolume1").andReturn(200, persistentVolume1).once();
    server.expect().withPath("/api/v1/persistentvolumes/persistentvolume2").andReturn(200, persistentVolume2).once();

    Boolean deleted = client.persistentVolumes().delete(persistentVolume1, persistentVolume2);
    assertTrue(deleted);
  }

  @Test
  public void testLoadFromFile() {
    PersistentVolume persistentVolume = client.persistentVolumes()
        .load(getClass().getResourceAsStream("/test-persistentvolume.yml")).item();
    assertEquals("pv-test", persistentVolume.getMetadata().getName());
  }

  @Test
  public void testBuild() {
    PersistentVolume persistentVolume = new PersistentVolumeBuilder()
        .withNewMetadata().withName("persistentvolume").endMetadata()
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
            .build()))
        .endNodeSelectorTerm()
        .endRequired()
        .endNodeAffinity()
        .endSpec()
        .build();

    server.expect().withPath("/api/v1/persistentvolumes/persistentvolume").andReturn(200, persistentVolume).once();

    persistentVolume = client.persistentVolumes().withName("persistentvolume").get();
    assertNotNull(persistentVolume);
  }

}
