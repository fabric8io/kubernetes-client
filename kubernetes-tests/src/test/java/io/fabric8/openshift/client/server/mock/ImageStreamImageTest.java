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

import io.fabric8.openshift.api.model.ImageStreamImage;
import io.fabric8.openshift.api.model.ImageStreamImageBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ImageStreamImageTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/image.openshift.io/v1/namespaces/ns1/imagestreamimages/isi1")
        .andReturn(HttpURLConnection.HTTP_CREATED, createImageStreamImageBuilder("isi1")
            .build())
        .once();

    // When
    ImageStreamImage result = client.imageStreamImages().inNamespace("ns1").withName("isi1").get();

    // Then
    assertThat(result).isNotNull();
  }

  private ImageStreamImageBuilder createImageStreamImageBuilder(String name) {
    return new ImageStreamImageBuilder()
        .withNewMetadata().withName(name).endMetadata();
  }
}
