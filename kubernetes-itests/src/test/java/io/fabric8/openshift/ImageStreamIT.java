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

package io.fabric8.openshift;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(ImageStream.class)
@LoadKubernetesManifests("/imagestream-it.yml")
class ImageStreamIT {

  OpenShiftClient client;

  @Test
  void load() {
    ImageStream aImageStream = client.imageStreams()
        .load(getClass().getResourceAsStream("/test-imagestream.yml")).item();
    assertThat(aImageStream).isNotNull();
    assertEquals("my-ruby", aImageStream.getMetadata().getName());
  }

  @Test
  void get() {
    assertNotNull(client.imageStreams().withName("is-get").get());
  }

  @Test
  void list() {
    ImageStreamList aImageStreamList = client.imageStreams().list();
    assertThat(aImageStreamList).isNotNull();
    assertTrue(aImageStreamList.getItems().size() >= 1);
  }

  @Test
  void update() {
    client.imageStreams().withName("is-update").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    ImageStream imageStream1 = client.imageStreams().withName("is-update").edit(i -> new ImageStreamBuilder(i)
        .editMetadata().withResourceVersion(null).endMetadata()
        .editSpec().withDockerImageRepository("fabric8/s2i-java").endSpec()
        .build());
    assertThat(imageStream1).isNotNull();
    assertEquals("fabric8/s2i-java", imageStream1.getSpec().getDockerImageRepository());
  }

  @Test
  void delete() {
    client.imageStreams().withName("is-delete").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.imageStreams().withName("is-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    // Given
    ImageStream imageStream = client.imageStreams().withName("is-createorreplace").get();

    // When
    imageStream.getSpec().setDockerImageRepository("docker.io/openshift/ruby-centos-2");
    imageStream = client.imageStreams().createOrReplace(imageStream);

    // Then
    assertNotNull(imageStream);
    assertEquals("is-createorreplace", imageStream.getMetadata().getName());
    assertEquals("docker.io/openshift/ruby-centos-2", imageStream.getSpec().getDockerImageRepository());
  }

}
