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

import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.openshift.api.model.ImageSignature;
import io.fabric8.openshift.api.model.ImageSignatureBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ImageSignatureTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void create() {
    // Given
    ImageSignature is = createImageSignatureBuilder("test-get").build();
    server.expect().post().withPath("/apis/image.openshift.io/v1/imagesignatures")
        .andReturn(HttpURLConnection.HTTP_CREATED, createImageSignatureBuilder(
            "sha256:e8250ef60f2936e631da0c1c0f1f6b6e3dc118f6bfc46e605148e52edb24d158@sha256:e8250ef60f2936e631da0c1c0f1f6b6e3dc118f6bfc46e605148e52edb24d158")
            .build())
        .once();

    // When
    ImageSignature createdIs = client.imageSignatures().create(is);

    // Then
    assertThat(createdIs).isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name",
            "sha256:e8250ef60f2936e631da0c1c0f1f6b6e3dc118f6bfc46e605148e52edb24d158@sha256:e8250ef60f2936e631da0c1c0f1f6b6e3dc118f6bfc46e605148e52edb24d158");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/image.openshift.io/v1/imagesignatures/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, new StatusBuilder().withStatus("Success").build())
        .once();

    // When
    boolean isDeleted = client.imageSignatures().withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ImageSignatureBuilder createImageSignatureBuilder(String name) {
    return new ImageSignatureBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewMetadata().withName(name).endMetadata()
        .withType("DockerImage")
        .withContent("VGVzdENvbnRlbnQK")
        .addNewCondition()
        .withMessage("testMessage")
        .withLastProbeTime("2006-01-02T15:04:05Z")
        .withReason("SomeReason")
        .withStatus("TestStatus")
        .endCondition();
  }
}
