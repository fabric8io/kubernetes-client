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

import io.fabric8.kubernetes.api.model.DoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Utils;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableRuleMigrationSupport
class PersistentVolumeClaimTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  void testList() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims").andReturn(200, new PersistentVolumeClaimListBuilder().build()).once();

    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims").andReturn(200, new PersistentVolumeClaimListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    PersistentVolumeClaimList persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("test").list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(0, persistentVolumeClaimList.getItems().size());

    persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("ns1").list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(2, persistentVolumeClaimList.getItems().size());
  }

  @Test
  void testListWithlabels() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new PersistentVolumeClaimListBuilder().build()).once();

    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new PersistentVolumeClaimListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    PersistentVolumeClaimList persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("test")
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(0, persistentVolumeClaimList.getItems().size());

    persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("test")
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(3, persistentVolumeClaimList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim1").andReturn(200, new PersistentVolumeClaimBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/persistentvolumeclaim2").andReturn(200, new PersistentVolumeClaimBuilder().build()).once();

    KubernetesClient client = server.getClient();
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims().inNamespace("test").withName("persistentvolumeclaim1").get();
    assertNotNull(persistentVolumeClaim);

    persistentVolumeClaim = client.persistentVolumeClaims().withName("persistentvolumeclaim2").get();
    assertNull(persistentVolumeClaim);

    persistentVolumeClaim = client.persistentVolumeClaims().inNamespace("ns1").withName("persistentvolumeclaim2").get();
    assertNotNull(persistentVolumeClaim);
  }

  @Test
  void testEditMissing() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim").andReturn(404, "error message from kubernetes").always();
    KubernetesClient client = server.getClient();
    Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim> pvcResource =  client.persistentVolumeClaims().inNamespace("test").withName("persistentvolumeclaim");
    Assertions.assertThrows(KubernetesClientException.class, pvcResource::edit);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim1").andReturn(200, new PersistentVolumeClaimBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/persistentvolumeclaim2").andReturn(200, new PersistentVolumeClaimBuilder().build()).once();

    KubernetesClient client = server.getClient();
    Boolean deleted = client.persistentVolumeClaims().inNamespace("test").withName("persistentvolumeclaim1").delete();
    assertTrue(deleted);

    deleted = client.persistentVolumeClaims().withName("persistentvolumeclaim2").delete();
    assertFalse(deleted);

    deleted = client.persistentVolumeClaims().inNamespace("ns1").withName("persistentvolumeclaim2").delete();
    assertTrue(deleted);
  }

  @Test
  void testDeleteMulti() {
    PersistentVolumeClaim persistentVolumeClaim1 = new PersistentVolumeClaimBuilder().withNewMetadata().withName("persistentvolumeclaim1").withNamespace("test").endMetadata().build();
    PersistentVolumeClaim persistentVolumeClaim2 = new PersistentVolumeClaimBuilder().withNewMetadata().withName("persistentvolumeclaim2").withNamespace("ns1").endMetadata().build();
    PersistentVolumeClaim persistentVolumeClaim3 = new PersistentVolumeClaimBuilder().withNewMetadata().withName("persistentvolumeclaim3").withNamespace("any").endMetadata().build();

    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim1").andReturn(200, persistentVolumeClaim1).once();
    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/persistentvolumeclaim2").andReturn(200, persistentVolumeClaim2).once();

    KubernetesClient client = server.getClient();
    Boolean deleted = client.persistentVolumeClaims().inAnyNamespace().delete(persistentVolumeClaim1, persistentVolumeClaim2);
    assertTrue(deleted);

    deleted = client.persistentVolumeClaims().inAnyNamespace().delete(persistentVolumeClaim3);
    assertFalse(deleted);
  }

  @Test
  void testLoadFromFile() {
    KubernetesClient client = server.getClient();
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims().load(getClass().getResourceAsStream("/test-persistentvolumeclaim.yml")).get();
    assertEquals("task-pv-claim", persistentVolumeClaim.getMetadata().getName());
  }

  @Test
  void testBuild() {
    PersistentVolumeClaim persistentVolumeClaim = new PersistentVolumeClaimBuilder()
      .withNewMetadata().withName("test-pv-claim").withNamespace("test").endMetadata()
      .withNewSpec()
      .withStorageClassName("my-local-storage")
      .withAccessModes("ReadWriteOnce")
      .withNewResources()
      .addToRequests("storage", new Quantity("500Gi"))
      .endResources()
      .endSpec()
      .build();

    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/test-pv-claim").andReturn(200, persistentVolumeClaim).once();

    KubernetesClient client = server.getClient();
    persistentVolumeClaim = client.persistentVolumeClaims().inNamespace("test").withName("test-pv-claim").get();
    assertNotNull(persistentVolumeClaim);
  }

}
