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

import io.fabric8.openshift.api.model.ImageStreamMapping;
import io.fabric8.openshift.api.model.ImageStreamMappingBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ImageStreamMappingTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void create() {
    // Given
    ImageStreamMapping isi1 = createImageStreamMappingBuilder("isi1").build();
    server.expect().post().withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagestreammappings")
        .andReturn(HttpURLConnection.HTTP_CREATED,
            createImageStreamMappingBuilder("sha256:c5c25414687677f55e897e1e06cf79b93e58c2324b1531dadcd5b159bdf42b75")
                .build())
        .once();

    // When
    ImageStreamMapping result = client.imageStreamMappings().inNamespace("ns1").create(isi1);

    // Then
    assertThat(result).isNotNull();
  }

  private ImageStreamMappingBuilder createImageStreamMappingBuilder(String name) {
    return new ImageStreamMappingBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withTag("latest123")
        .withNewImage()
        .withDockerImageReference("image-registry.openshift-image-registry.svc:5000/openshift/ubi8-openjdk-8")
        .addNewDockerImageLayer()
        .withName("sha256:5f70bf18a086007016e948b04aed3b82103a36bea41755b6cddfaf10ace3c6ef")
        .withSize(0L)
        .endDockerImageLayer()
        .withNewMetadata().withName(name).endMetadata()
        .endImage();
  }
}
