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
package io.fabric8.openshift.api.model.config.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ImageTagMirrorSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ImageTagMirrorSet.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/test-imagetagmirrorset.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ImageTagMirrorSet imageTagMirrorSet = mapper.readValue(originalJson, ImageTagMirrorSet.class);
    final String serializedJson = mapper.writeValueAsString(imageTagMirrorSet);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(imageTagMirrorSet)
        .hasFieldOrPropertyWithValue("metadata.name", "tag-mirror")
        .extracting(ImageTagMirrorSet::getSpec)
        .extracting(ImageTagMirrorSetSpec::getImageTagMirrors)
        .asList()
        .singleElement(InstanceOfAssertFactories.type(ImageTagMirrors.class))
        .hasFieldOrPropertyWithValue("mirrors", Collections.singletonList("mirror.example.com/redhat"))
        .hasFieldOrPropertyWithValue("source", "registry.redhat.io/openshift4")
        .hasFieldOrPropertyWithValue("mirrorSourcePolicy", "AllowContactingSource");
  }

  @Test
  void builder() {
    // Given
    ImageTagMirrorSetBuilder imageTagMirrorSetBuilder = new ImageTagMirrorSetBuilder()
        .withNewMetadata()
        .withName("tag-mirror")
        .endMetadata()
        .withNewSpec()
        .addNewImageTagMirror()
        .withMirrors("example.com/example/ubi-minimal")
        .withSource("registry.access.redhat.com/ubi9/ubi-minimal")
        .withMirrorSourcePolicy("AllowContactingSource")
        .endImageTagMirror()
        .endSpec();

    // When
    ImageTagMirrorSet imageTagMirrorSet = imageTagMirrorSetBuilder.build();

    // Then
    assertThat(imageTagMirrorSet)
        .hasFieldOrPropertyWithValue("metadata.name", "tag-mirror")
        .extracting(ImageTagMirrorSet::getSpec)
        .extracting(ImageTagMirrorSetSpec::getImageTagMirrors)
        .asList()
        .singleElement(InstanceOfAssertFactories.type(ImageTagMirrors.class))
        .hasFieldOrPropertyWithValue("mirrors", Collections.singletonList("example.com/example/ubi-minimal"))
        .hasFieldOrPropertyWithValue("source", "registry.access.redhat.com/ubi9/ubi-minimal")
        .hasFieldOrPropertyWithValue("mirrorSourcePolicy", "AllowContactingSource");
  }
}
