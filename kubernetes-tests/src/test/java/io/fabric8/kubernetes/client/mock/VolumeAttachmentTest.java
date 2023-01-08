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
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentBuilder;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class VolumeAttachmentTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-volumeattachment.yml")).items();
    assertThat(items).isNotNull();
    assertThat(items.get(0))
        .isInstanceOf(VolumeAttachment.class)
        .hasFieldOrPropertyWithValue("metadata.name", "test-volumeattachment");
  }

  @Test
  void create() {
    // Given
    VolumeAttachment volumeAttachment = createNewVolumeAttachment("volumeattachment1");
    server.expect().post().withPath("/apis/storage.k8s.io/v1/volumeattachments")
        .andReturn(HttpURLConnection.HTTP_CREATED, volumeAttachment)
        .once();

    // When
    VolumeAttachment createdCsiDriver = client.storage().volumeAttachments().create(volumeAttachment);

    // Then
    assertThat(createdCsiDriver)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "volumeattachment1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/storage.k8s.io/v1/volumeattachments")
        .andReturn(HttpURLConnection.HTTP_OK,
            new VolumeAttachmentListBuilder().addToItems(createNewVolumeAttachment("va1")).build())
        .once();

    // When
    VolumeAttachmentList volumeAttachmentList = client.storage().volumeAttachments().list();

    // Then
    assertThat(volumeAttachmentList).isNotNull();
    assertThat(volumeAttachmentList.getItems()).hasSize(1);
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/storage.k8s.io/v1/volumeattachments/va1")
        .andReturn(HttpURLConnection.HTTP_CREATED, createNewVolumeAttachment("va1"))
        .once();

    // When
    boolean isDeleted = client.storage().volumeAttachments().withName("va1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private VolumeAttachment createNewVolumeAttachment(String name) {
    return new VolumeAttachmentBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withAttacher("volumedriver1")
        .withNodeName("minikube")
        .withNewSource()
        .withPersistentVolumeName("pv1")
        .endSource()
        .endSpec()
        .build();
  }
}
