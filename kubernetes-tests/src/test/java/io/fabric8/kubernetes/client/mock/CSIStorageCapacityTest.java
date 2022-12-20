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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityBuilder;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class CSIStorageCapacityTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-csistoragecapacity.yml")).items();
    assertThat(items).isNotNull();
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(CSIStorageCapacity.class)
        .hasFieldOrPropertyWithValue("metadata.name", "csisc-64103396-0d32-11ea-945c-e3ede5f0f3ae");
  }

  @Test
  void create() {
    // Given
    CSIStorageCapacity csiStorageCapacity = createNewCSIStorageCapacity("csidriver1");
    server.expect().post().withPath("/apis/storage.k8s.io/v1beta1/namespaces/default/csistoragecapacities")
        .andReturn(HttpURLConnection.HTTP_CREATED, csiStorageCapacity)
        .once();

    // When
    CSIStorageCapacity createdCsiStorageCapacity = client.storage().v1beta1().csiStorageCapacities().inNamespace("default")
        .create(csiStorageCapacity);

    // Then
    AssertionsForClassTypes.assertThat(createdCsiStorageCapacity)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "csidriver1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/storage.k8s.io/v1beta1/namespaces/default/csistoragecapacities")
        .andReturn(HttpURLConnection.HTTP_OK,
            new CSIStorageCapacityListBuilder().addToItems(createNewCSIStorageCapacity("c1")).build())
        .once();

    // When
    CSIStorageCapacityList csiStorageCapacityList = client.storage().v1beta1().csiStorageCapacities().inNamespace("default")
        .list();

    // Then
    AssertionsForClassTypes.assertThat(csiStorageCapacityList).isNotNull();
    assertThat(csiStorageCapacityList.getItems()).hasSize(1);
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/storage.k8s.io/v1beta1/namespaces/default/csistoragecapacities/c1")
        .andReturn(HttpURLConnection.HTTP_CREATED, createNewCSIStorageCapacity("c1"))
        .once();

    // When
    boolean isDeleted = client.storage().v1beta1().csiStorageCapacities().inNamespace("default").withName("c1").delete()
        .size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private CSIStorageCapacity createNewCSIStorageCapacity(String name) {
    return new CSIStorageCapacityBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withStorageClassName("foo")
        .withNewNodeTopology()
        .addNewMatchExpression()
        .withKey("kubernetes.io/hostname")
        .withValues("node-1")
        .withOperator("In")
        .endMatchExpression()
        .endNodeTopology()
        .build();
  }
}
