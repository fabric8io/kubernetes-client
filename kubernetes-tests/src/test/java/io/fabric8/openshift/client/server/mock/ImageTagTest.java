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

import io.fabric8.openshift.api.model.ImageTag;
import io.fabric8.openshift.api.model.ImageTagBuilder;
import io.fabric8.openshift.api.model.ImageTagList;
import io.fabric8.openshift.api.model.ImageTagListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ImageTagTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ImageTag imageTag = getImageTag();
    server.expect().post()
        .withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagetags")
        .andReturn(HttpURLConnection.HTTP_OK, imageTag)
        .once();

    // When
    imageTag = client.imageTags().inNamespace("ns1").create(imageTag);

    // Then
    assertNotNull(imageTag);
    assertEquals("foo", imageTag.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagetags/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getImageTag())
        .once();

    // When
    ImageTag f = client.imageTags().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagetags")
        .andReturn(HttpURLConnection.HTTP_OK, new ImageTagListBuilder().withItems(getImageTag()).build())
        .once();

    // When
    ImageTagList fgList = client.imageTags().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagetags/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getImageTag())
        .once();

    // When
    boolean deleted = client.imageTags().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ImageTag getImageTag() {
    return new ImageTagBuilder()
        .withNewMetadata()
        .withName("foo")
        .endMetadata()
        .build();
  }
}
