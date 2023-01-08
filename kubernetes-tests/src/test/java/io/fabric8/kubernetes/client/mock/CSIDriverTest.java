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
import io.fabric8.kubernetes.api.model.storage.CSIDriver;
import io.fabric8.kubernetes.api.model.storage.CSIDriverBuilder;
import io.fabric8.kubernetes.api.model.storage.CSIDriverList;
import io.fabric8.kubernetes.api.model.storage.CSIDriverListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class CSIDriverTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-csidriver.yml")).items();
    assertThat(items).isNotNull();
    assertThat(items.get(0))
        .isInstanceOf(CSIDriver.class)
        .hasFieldOrPropertyWithValue("metadata.name", "mycsidriver.example.com");
  }

  @Test
  void create() {
    // Given
    CSIDriver csiDriver = createNewCSIDriver("csidriver1");
    server.expect().post().withPath("/apis/storage.k8s.io/v1/csidrivers")
        .andReturn(HttpURLConnection.HTTP_CREATED, csiDriver)
        .once();

    // When
    CSIDriver createdCsiDriver = client.storage().csiDrivers().create(csiDriver);

    // Then
    assertThat(createdCsiDriver)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "csidriver1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/storage.k8s.io/v1/csidrivers")
        .andReturn(HttpURLConnection.HTTP_OK, new CSIDriverListBuilder().addToItems(createNewCSIDriver("c1")).build())
        .once();

    // When
    CSIDriverList csiDriverList = client.storage().csiDrivers().list();

    // Then
    assertThat(csiDriverList).isNotNull();
    assertThat(csiDriverList.getItems()).hasSize(1);
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/storage.k8s.io/v1/csidrivers/c1")
        .andReturn(HttpURLConnection.HTTP_CREATED, createNewCSIDriver("c1"))
        .once();

    // When
    boolean isDeleted = client.storage().csiDrivers().withName("c1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private CSIDriver createNewCSIDriver(String name) {
    return new CSIDriverBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withAttachRequired(true)
        .withPodInfoOnMount(true)
        .withFsGroupPolicy("File")
        .addToVolumeLifecycleModes("Persistent", "Ephermal")
        .addNewTokenRequest()
        .withAudience("gcp")
        .endTokenRequest()
        .withRequiresRepublish(true)
        .endSpec()
        .build();
  }
}
