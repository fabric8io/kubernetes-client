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

import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifest;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifestBuilder;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifestList;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifestListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class PackageManifestTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/packages.operators.coreos.com/v1/namespaces/ns1/packagemanifests/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPackageManifest("test-get"))
        .once();

    // When
    PackageManifest packageManifest = client.operatorHub().packageManifests().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(packageManifest)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/packages.operators.coreos.com/v1/namespaces/ns1/packagemanifests")
        .andReturn(HttpURLConnection.HTTP_OK, new PackageManifestListBuilder()
            .addToItems(createNewPackageManifest("test-list"))
            .build())
        .once();

    // When
    PackageManifestList packageManifestList = client.operatorHub().packageManifests().inNamespace("ns1").list();

    // Then
    assertThat(packageManifestList).isNotNull();
    assertThat(packageManifestList.getItems()).hasSize(1);
    assertThat(packageManifestList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/packages.operators.coreos.com/v1/namespaces/ns1/packagemanifests/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPackageManifest("cluster"))
        .once();

    // When
    boolean isDeleted = client.operatorHub().packageManifests().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PackageManifest createNewPackageManifest(String name) {
    return new PackageManifestBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .endSpec()
        .build();
  }
}
