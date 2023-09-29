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

class ImageDigestMirrorSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ImageDigestMirrorSet.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/test-imagedigestmirrorset.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ImageDigestMirrorSet imageDigestMirrorSet = mapper.readValue(originalJson, ImageDigestMirrorSet.class);
    final String serializedJson = mapper.writeValueAsString(imageDigestMirrorSet);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(imageDigestMirrorSet)
        .hasFieldOrPropertyWithValue("metadata.name", "ubi9repo")
        .extracting(ImageDigestMirrorSet::getSpec)
        .extracting(ImageDigestMirrorSetSpec::getImageDigestMirrors)
        .asList()
        .singleElement(InstanceOfAssertFactories.type(ImageDigestMirrors.class))
        .hasFieldOrPropertyWithValue("mirrors", Collections.singletonList("example.com/example/ubi-minimal"))
        .hasFieldOrPropertyWithValue("source", "registry.access.redhat.com/ubi9/ubi-minimal")
        .hasFieldOrPropertyWithValue("mirrorSourcePolicy", "AllowContactingSource");
  }

  @Test
  void builder() {
    // Given
    ImageDigestMirrorSetBuilder imageDigestMirrorSetBuilder = new ImageDigestMirrorSetBuilder()
        .withNewMetadata()
        .withName("ubi9repo")
        .endMetadata()
        .withNewSpec()
        .addNewImageDigestMirror()
        .withMirrors("example.com/example/ubi-minimal")
        .withSource("registry.access.redhat.com/ubi9/ubi-minimal")
        .withMirrorSourcePolicy("AllowContactingSource")
        .endImageDigestMirror()
        .endSpec();

    // When
    ImageDigestMirrorSet imageDigestMirrorSet = imageDigestMirrorSetBuilder.build();

    // Then
    assertThat(imageDigestMirrorSet)
        .hasFieldOrPropertyWithValue("metadata.name", "ubi9repo")
        .extracting(ImageDigestMirrorSet::getSpec)
        .extracting(ImageDigestMirrorSetSpec::getImageDigestMirrors)
        .asList()
        .singleElement(InstanceOfAssertFactories.type(ImageDigestMirrors.class))
        .hasFieldOrPropertyWithValue("mirrors", Collections.singletonList("example.com/example/ubi-minimal"))
        .hasFieldOrPropertyWithValue("source", "registry.access.redhat.com/ubi9/ubi-minimal")
        .hasFieldOrPropertyWithValue("mirrorSourcePolicy", "AllowContactingSource");
  }
}
