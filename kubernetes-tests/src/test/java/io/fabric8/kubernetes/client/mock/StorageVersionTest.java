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

import io.fabric8.kubernetes.api.model.internal.apiserver.v1alpha1.StorageVersion;
import io.fabric8.kubernetes.api.model.internal.apiserver.v1alpha1.StorageVersionBuilder;
import io.fabric8.kubernetes.api.model.internal.apiserver.v1alpha1.StorageVersionList;
import io.fabric8.kubernetes.api.model.internal.apiserver.v1alpha1.StorageVersionListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class StorageVersionTest {
  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/internal.apiserver.k8s.io/v1alpha1/storageversions/apps.deployments")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorageVersion())
        .once();

    // When
    StorageVersion storageVersion = client.resources(StorageVersion.class, StorageVersionList.class)
        .withName("apps.deployments").get();

    // Then
    assertThat(storageVersion)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "apps.deployments");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/internal.apiserver.k8s.io/v1alpha1/storageversions")
        .andReturn(HttpURLConnection.HTTP_OK, new StorageVersionListBuilder()
            .addToItems(createNewStorageVersion())
            .build())
        .once();

    // When
    StorageVersionList storageVersionList = client.resources(StorageVersion.class, StorageVersionList.class).list();

    // Then
    assertThat(storageVersionList).isNotNull();
    assertThat(storageVersionList.getItems()).hasSize(1);
    assertThat(storageVersionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "apps.deployments");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/internal.apiserver.k8s.io/v1alpha1/storageversions/apps.deployments")
        .andReturn(HttpURLConnection.HTTP_OK, createNewStorageVersion())
        .once();

    // When
    boolean isDeleted = client.resources(StorageVersion.class, StorageVersionList.class).withName("apps.deployments").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private StorageVersion createNewStorageVersion() {
    return new StorageVersionBuilder()
        .withNewMetadata()
        .withName("apps.deployments")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .withNewStatus()
        .withCommonEncodingVersion("apps/v1")
        .addNewCondition()
        .withLastTransitionTime("2023-06-04T17:16:57Z")
        .withMessage("Common encoding version set")
        .withReason("CommonEncodingVersionSet")
        .withStatus("True")
        .withType("AllEncodingVersionsEqual")
        .endCondition()
        .addNewStorageVersion()
        .withApiServerID("kube-apiserver-803c62b1-340f-4055-93ca-44aba8a35574")
        .addToDecodableVersions("apps/v1", "apps/v1beta2", "apps/v1beta1")
        .withEncodingVersion("apps/v1")
        .endStorageVersion()
        .endStatus()
        .build();
  }
}
