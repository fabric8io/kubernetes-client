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

import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimListBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class PersistentVolumeClaimTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testList() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims")
        .andReturn(200, new PersistentVolumeClaimListBuilder().build()).once();

    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims")
        .andReturn(200, new PersistentVolumeClaimListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    PersistentVolumeClaimList persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("test").list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(0, persistentVolumeClaimList.getItems().size());

    persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("ns1").list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(2, persistentVolumeClaimList.getItems().size());
  }

  @Test
  void testListWithlabels() {
    server.expect()
        .withPath("/api/v1/namespaces/test/persistentvolumeclaims?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(200, new PersistentVolumeClaimListBuilder().build()).once();

    server.expect()
        .withPath(
            "/api/v1/namespaces/test/persistentvolumeclaims?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new PersistentVolumeClaimListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    PersistentVolumeClaimList persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("test")
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(0, persistentVolumeClaimList.getItems().size());

    persistentVolumeClaimList = client.persistentVolumeClaims().inNamespace("test")
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();
    assertNotNull(persistentVolumeClaimList);
    assertEquals(3, persistentVolumeClaimList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim1")
        .andReturn(200, new PersistentVolumeClaimBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/persistentvolumeclaim2")
        .andReturn(200, new PersistentVolumeClaimBuilder().build()).once();

    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims().inNamespace("test")
        .withName("persistentvolumeclaim1").get();
    assertNotNull(persistentVolumeClaim);

    persistentVolumeClaim = client.persistentVolumeClaims().withName("persistentvolumeclaim2").get();
    assertNull(persistentVolumeClaim);

    persistentVolumeClaim = client.persistentVolumeClaims().inNamespace("ns1").withName("persistentvolumeclaim2").get();
    assertNotNull(persistentVolumeClaim);
  }

  @Test
  void testEditMissing() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim")
        .andReturn(404, "error message from kubernetes").always();
    Resource<PersistentVolumeClaim> pvcResource = client.persistentVolumeClaims().inNamespace("test")
        .withName("persistentvolumeclaim");
    Assertions.assertThrows(KubernetesClientException.class, () -> pvcResource.edit(r -> r));
  }

  @Test
  void testDelete() {
    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim1")
        .andReturn(200, new PersistentVolumeClaimBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/persistentvolumeclaim2")
        .andReturn(200, new PersistentVolumeClaimBuilder().build()).once();

    boolean deleted = client.persistentVolumeClaims().inNamespace("test").withName("persistentvolumeclaim1").delete()
        .size() == 1;
    assertTrue(deleted);

    deleted = client.persistentVolumeClaims().withName("persistentvolumeclaim2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.persistentVolumeClaims().inNamespace("ns1").withName("persistentvolumeclaim2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  void testDeleteMulti() {
    PersistentVolumeClaim persistentVolumeClaim1 = new PersistentVolumeClaimBuilder().withNewMetadata()
        .withName("persistentvolumeclaim1").withNamespace("test").endMetadata().build();
    PersistentVolumeClaim persistentVolumeClaim2 = new PersistentVolumeClaimBuilder().withNewMetadata()
        .withName("persistentvolumeclaim2").withNamespace("ns1").endMetadata().build();
    PersistentVolumeClaim persistentVolumeClaim3 = new PersistentVolumeClaimBuilder().withNewMetadata()
        .withName("persistentvolumeclaim3").withNamespace("any").endMetadata().build();

    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/persistentvolumeclaim1")
        .andReturn(200, persistentVolumeClaim1).once();
    server.expect().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/persistentvolumeclaim2")
        .andReturn(200, persistentVolumeClaim2).once();

    Boolean deleted = client.persistentVolumeClaims().inAnyNamespace().delete(persistentVolumeClaim1, persistentVolumeClaim2);
    assertTrue(deleted);

    deleted = client.persistentVolumeClaims().inAnyNamespace().delete(persistentVolumeClaim3).size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testLoadFromFile() {
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims()
        .load(getClass().getResourceAsStream("/test-persistentvolumeclaim.yml")).item();
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

    server.expect().withPath("/api/v1/namespaces/test/persistentvolumeclaims/test-pv-claim")
        .andReturn(200, persistentVolumeClaim).once();

    persistentVolumeClaim = client.persistentVolumeClaims().inNamespace("test").withName("test-pv-claim").get();
    assertNotNull(persistentVolumeClaim);
  }

  @Test
  @DisplayName("createOrReplace, resource is new, should successfully POST to server")
  void testCreateOrReplaceWhenNotExists() {
    // Given
    server.expect().post().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims")
        .andReturn(HttpURLConnection.HTTP_CREATED, mockPVCBuilder().build()).once();
    // @formatter:off
    final PersistentVolumeClaim toCreate = mockPVCBuilder()
      .editMetadata()
        .withResourceVersion(null)
        .withCreationTimestamp(null)
      .endMetadata()
      .build();
    // @formatter:on
    // When
    final PersistentVolumeClaim result = client.persistentVolumeClaims().inNamespace("ns1")
        .createOrReplace(toCreate);
    // Then
    assertThat(result)
        .isNotNull()
        .extracting("metadata")
        .hasFieldOrPropertyWithValue("resourceVersion", "1")
        .extracting("creationTimestamp").asString().isNotBlank();
  }

  @Test
  @DisplayName("createOrReplace, resource exists on server, should PUT updated resource")
  void testCreateOrReplaceWhenExists() {
    // Given
    final PersistentVolumeClaim existent = mockPVCBuilder().build();
    server.expect().post().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, "").once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/my-pvc")
        .andReturn(HttpURLConnection.HTTP_OK, existent).times(2);
    server.expect().put().withPath("/api/v1/namespaces/ns1/persistentvolumeclaims/my-pvc")
        .andReturn(HttpURLConnection.HTTP_OK, mockPVCBuilder()
            .editMetadata().withResourceVersion("2").endMetadata().build())
        .once();
    // @formatter:off
    final PersistentVolumeClaim toReplace = mockPVCBuilder()
      .editMetadata()
        .withResourceVersion(null)
        .withCreationTimestamp(null)
      .endMetadata()
      .build();
    // @formatter:on
    // When
    final PersistentVolumeClaim result = client.persistentVolumeClaims().inNamespace("ns1")
        .createOrReplace(toReplace);
    // Then
    assertThat(result)
        .isNotNull()
        .extracting("metadata")
        .hasFieldOrPropertyWithValue("resourceVersion", "2")
        .hasFieldOrPropertyWithValue("creationTimestamp", existent.getMetadata().getCreationTimestamp());
  }

  private static PersistentVolumeClaimBuilder mockPVCBuilder() {
    // @formatter:off
    return new PersistentVolumeClaimBuilder()
      .withNewMetadata()
        .withName("my-pvc")
        .withCreationTimestamp("2020-07-27T11:02:15Z")
        .addToFinalizers("kubernetes.io/pvc-protection")
        .withNamespace("ns1")
        .withResourceVersion("1")
        .withSelfLink("/api/v1/namespaces/default/persistentvolumeclaims/my-pvc")
        .withUid("60817eaa-19d8-41ba-adb4-3ea75860e1f8")
      .endMetadata()
      .withNewSpec()
        .withAccessModes("ReadWriteOnce")
        .withNewResources()
          .withRequests(Collections.singletonMap("storage", new Quantity("20Gi")))
        .endResources()
        .withStorageClassName("standard")
        .withVolumeMode("Filesystem")
        .withVolumeName("pvc-60817eaa-19d8-41ba-adb4-3ea75860e1f8")
      .endSpec();
    // @formatter:on
  }

}
