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

import io.fabric8.openshift.api.model.ImageStreamImport;
import io.fabric8.openshift.api.model.ImageStreamImportBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ImageStreamImportTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void create() {
    // Given
    ImageStreamImport isi1 = createImageStreamImportBuilder("isi1").build();
    server.expect().post().withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagestreamimports")
        .andReturn(HttpURLConnection.HTTP_CREATED, createImageStreamImportBuilder("isi1")
            .build())
        .once();

    // When
    ImageStreamImport result = client.imageStreamImports().inNamespace("ns1").create(isi1);

    // Then
    assertThat(result).isNotNull();
  }

  private ImageStreamImportBuilder createImageStreamImportBuilder(String name) {
    return new ImageStreamImportBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewImage()
        .withNewFrom()
        .withName("registry.example.dk:5000/spilbraet/fafnir-sso:1.0.84")
        .withKind("DockerImage")
        .endFrom()
        .withNewTo()
        .withName("latest")
        .endTo()
        .withNewReferencePolicy("Source")
        .endImage()
        .endSpec();
  }
}
