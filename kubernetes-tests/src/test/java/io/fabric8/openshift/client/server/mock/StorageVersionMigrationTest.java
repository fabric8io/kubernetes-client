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

import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigration;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationBuilder;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationList;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class StorageVersionMigrationTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/migration.k8s.io/v1alpha1/storageversionmigrations/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorageVersionMigration("test-get"))
        .once();

    // When
    StorageVersionMigration storageVersionMigration = client.kubeStorageVersionMigrator().storageVersionMigrations()
        .withName("test-get").get();

    // Then
    assertThat(storageVersionMigration)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/migration.k8s.io/v1alpha1/storageversionmigrations")
        .andReturn(HttpURLConnection.HTTP_OK, new StorageVersionMigrationListBuilder()
            .addToItems(createNewStorageVersionMigration("test-list"))
            .build())
        .once();

    // When
    StorageVersionMigrationList storageVersionMigrationList = client.kubeStorageVersionMigrator().storageVersionMigrations()
        .list();

    // Then
    assertThat(storageVersionMigrationList).isNotNull();
    assertThat(storageVersionMigrationList.getItems()).hasSize(1);
    assertThat(storageVersionMigrationList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/migration.k8s.io/v1alpha1/storageversionmigrations/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorageVersionMigration("cluster"))
        .once();

    // When
    boolean isDeleted = client.kubeStorageVersionMigrator().storageVersionMigrations().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private StorageVersionMigration createNewStorageVersionMigration(String name) {
    return new StorageVersionMigrationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withContinueToken("testtoken")
        .withNewResource()
        .withGroup("example.k8s.io")
        .withResource("TestResource")
        .endResource()
        .endSpec()
        .build();
  }
}
