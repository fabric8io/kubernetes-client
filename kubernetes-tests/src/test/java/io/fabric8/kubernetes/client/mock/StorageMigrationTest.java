/*
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

import io.fabric8.kubernetes.api.model.storagemigration.v1.StorageVersionMigration;
import io.fabric8.kubernetes.api.model.storagemigration.v1.StorageVersionMigrationBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class StorageMigrationTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("storageMigration().v1().storageVersionMigrations() manages cluster-scoped storagemigration.k8s.io/v1 resources")
  void v1StorageVersionMigrations() throws InterruptedException {
    // Given
    client.storageMigration().v1().storageVersionMigrations().resource(new StorageVersionMigrationBuilder()
        .withNewMetadata().withName("migrate-secrets").endMetadata()
        .withNewSpec().withNewResource("", "secrets").endSpec()
        .build()).create();

    // When
    final StorageVersionMigration result = client.storageMigration().v1().storageVersionMigrations()
        .withName("migrate-secrets").get();

    // Then
    assertThat(server.getLastRequest().getPath())
        .isEqualTo("/apis/storagemigration.k8s.io/v1/storageversionmigrations/migrate-secrets");
    assertThat(result)
        .hasFieldOrPropertyWithValue("apiVersion", "storagemigration.k8s.io/v1")
        .hasFieldOrPropertyWithValue("spec.resource.resource", "secrets");
    assertThat(client.storageMigration().v1().storageVersionMigrations().list().getItems()).hasSize(1);
  }

  @Test
  @DisplayName("storageMigration().v1beta1().storageVersionMigrations() manages cluster-scoped storagemigration.k8s.io/v1beta1 resources")
  void v1beta1StorageVersionMigrations() throws InterruptedException {
    // Given
    client.storageMigration().v1beta1().storageVersionMigrations()
        .resource(new io.fabric8.kubernetes.api.model.storagemigration.v1beta1.StorageVersionMigrationBuilder()
            .withNewMetadata().withName("migrate-configmaps").endMetadata()
            .withNewSpec().withNewResource("", "configmaps").endSpec()
            .build())
        .create();

    // When
    final io.fabric8.kubernetes.api.model.storagemigration.v1beta1.StorageVersionMigration result = client.storageMigration()
        .v1beta1().storageVersionMigrations().withName("migrate-configmaps").get();

    // Then
    assertThat(server.getLastRequest().getPath())
        .isEqualTo("/apis/storagemigration.k8s.io/v1beta1/storageversionmigrations/migrate-configmaps");
    assertThat(result)
        .hasFieldOrPropertyWithValue("apiVersion", "storagemigration.k8s.io/v1beta1")
        .hasFieldOrPropertyWithValue("spec.resource.resource", "configmaps");
  }
}
