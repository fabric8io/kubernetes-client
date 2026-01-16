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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.storage.VolumeAttributesClass;
import io.fabric8.kubernetes.api.model.storage.VolumeAttributesClassBuilder;
import io.fabric8.kubernetes.api.model.storage.VolumeAttributesClassList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttributesClassListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class VolumeAttributesClassTest {
  KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-volumeattributesclass.yml")).items();
    assertThat(items).isNotNull();
    assertThat(items.get(0))
        .isInstanceOf(VolumeAttributesClass.class)
        .hasFieldOrPropertyWithValue("metadata.name", "silver");
  }

  @Test
  void create() {
    // Given
    VolumeAttributesClass volumeAttributesClass = createNewVolumeAttributesClass("gold");
    server.expect().post().withPath("/apis/storage.k8s.io/v1/volumeattributesclasses")
        .andReturn(HttpURLConnection.HTTP_CREATED, volumeAttributesClass)
        .once();

    // When
    VolumeAttributesClass createdVolumeAttributesClass = client.storage().v1().volumeAttributesClasses()
        .resource(volumeAttributesClass).create();

    // Then
    assertThat(createdVolumeAttributesClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "gold");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/storage.k8s.io/v1/volumeattributesclasses")
        .andReturn(HttpURLConnection.HTTP_OK,
            new VolumeAttributesClassListBuilder().addToItems(createNewVolumeAttributesClass("silver")).build())
        .once();

    // When
    VolumeAttributesClassList volumeAttributesClassList = client.storage().v1().volumeAttributesClasses().list();

    // Then
    assertThat(volumeAttributesClassList).isNotNull();
    assertThat(volumeAttributesClassList.getItems()).hasSize(1);
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/storage.k8s.io/v1/volumeattributesclasses/gold")
        .andReturn(HttpURLConnection.HTTP_OK, createNewVolumeAttributesClass("gold"))
        .once();

    // When
    boolean isDeleted = client.storage().v1().volumeAttributesClasses().withName("gold").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/storage.k8s.io/v1/volumeattributesclasses/silver")
        .andReturn(HttpURLConnection.HTTP_OK, createNewVolumeAttributesClass("silver"))
        .once();

    // When
    VolumeAttributesClass volumeAttributesClass = client.storage().v1().volumeAttributesClasses().withName("silver").get();

    // Then
    assertThat(volumeAttributesClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "silver");
  }

  private VolumeAttributesClass createNewVolumeAttributesClass(String name) {
    return new VolumeAttributesClassBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withDriverName("pd.csi.storage.gke.io")
        .addToParameters("provisioned-iops-on-create", "3000")
        .addToParameters("provisioned-throughput-on-create", "140")
        .build();
  }
}
