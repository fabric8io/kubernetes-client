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

import io.fabric8.openshift.api.model.operator.v1.ImagePruner;
import io.fabric8.openshift.api.model.operator.v1.ImagePrunerBuilder;
import io.fabric8.openshift.api.model.operator.v1.ImagePrunerList;
import io.fabric8.openshift.api.model.operator.v1.ImagePrunerListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ImagePrunerTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ImagePruner imagePruner = getImagePruner();
    server.expect().post()
        .withPath("/apis/imageregistry.operator.openshift.io/v1/imagepruners")
        .andReturn(HttpURLConnection.HTTP_OK, imagePruner)
        .once();

    // When
    imagePruner = client.operator().imagePruners().create(imagePruner);

    // Then
    assertNotNull(imagePruner);
    assertEquals("foo", imagePruner.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/imageregistry.operator.openshift.io/v1/imagepruners/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getImagePruner())
        .once();

    // When
    ImagePruner f = client.operator().imagePruners().withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/imageregistry.operator.openshift.io/v1/imagepruners")
        .andReturn(HttpURLConnection.HTTP_OK, new ImagePrunerListBuilder().withItems(getImagePruner()).build())
        .once();

    // When
    ImagePrunerList fgList = client.operator().imagePruners().list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/imageregistry.operator.openshift.io/v1/imagepruners/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getImagePruner())
        .once();

    // When
    boolean deleted = client.operator().imagePruners().withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ImagePruner getImagePruner() {
    return new ImagePrunerBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .build();
  }
}
