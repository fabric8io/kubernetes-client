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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageState;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateBuilder;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateList;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class StorageStateTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/migration.k8s.io/v1alpha1/storagestates/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorageState("test-get"))
        .once();

    // When
    StorageState storageState = client.kubeStorageVersionMigrator().storageStates().withName("test-get").get();

    // Then
    assertThat(storageState)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/migration.k8s.io/v1alpha1/storagestates")
        .andReturn(HttpURLConnection.HTTP_OK, new StorageStateListBuilder()
            .addToItems(createNewStorageState("test-list"))
            .build())
        .once();

    // When
    StorageStateList storageStateList = client.kubeStorageVersionMigrator().storageStates().list();

    // Then
    assertThat(storageStateList).isNotNull();
    assertThat(storageStateList.getItems()).hasSize(1);
    assertThat(storageStateList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/migration.k8s.io/v1alpha1/storagestates/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorageState("cluster"))
        .once();

    // When
    boolean isDeleted = client.kubeStorageVersionMigrator().storageStates().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private StorageState createNewStorageState(String name) {
    return new StorageStateBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewResource()
        .withGroup("example.k8s.io")
        .withResource("TestResource")
        .endResource()
        .endSpec()
        .build();
  }
}
