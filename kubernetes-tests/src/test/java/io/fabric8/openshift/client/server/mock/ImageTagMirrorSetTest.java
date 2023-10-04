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

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSet;
import io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSetBuilder;
import io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSetList;
import io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ImageTagMirrorSetTest {
  private OpenShiftClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/imagetagmirrorsets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewImageTagMirrorSet("test-get"))
        .once();

    // When
    ImageTagMirrorSet imageTagMirrorSet = client.config().imageTagMirrorSets().withName("test-get").get();

    // Then
    assertThat(imageTagMirrorSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/imagetagmirrorsets")
        .andReturn(HttpURLConnection.HTTP_OK, new ImageTagMirrorSetListBuilder()
            .addToItems(createNewImageTagMirrorSet("test-list"))
            .build())
        .once();

    // When
    ImageTagMirrorSetList imageTagMirrorSetList = client.config().imageTagMirrorSets().list();

    // Then
    assertThat(imageTagMirrorSetList).isNotNull();
    assertThat(imageTagMirrorSetList.getItems()).hasSize(1);
    assertThat(imageTagMirrorSetList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/config.openshift.io/v1/imagetagmirrorsets/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewImageTagMirrorSet("cluster"))
        .once();

    // When
    boolean isDeleted = client.config().imageTagMirrorSets().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ImageTagMirrorSet createNewImageTagMirrorSet(String name) {
    return new ImageTagMirrorSetBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addNewImageTagMirror()
        .withMirrors("example.com/example/ubi-minimal")
        .withSource("registry.access.redhat.com/ubi9/ubi-minimal")
        .withMirrorSourcePolicy("AllowContactingSource")
        .endImageTagMirror()
        .endSpec()
        .build();
  }
}
