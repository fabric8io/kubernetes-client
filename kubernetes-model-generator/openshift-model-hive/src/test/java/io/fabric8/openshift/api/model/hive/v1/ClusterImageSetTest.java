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
package io.fabric8.openshift.api.model.hive.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ClusterImageSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clusterimageset.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterImageSet clusterImageSet = mapper.readValue(originalJson, ClusterImageSet.class);
    final String serializedJson = mapper.writeValueAsString(clusterImageSet);
    final ClusterImageSet clusterImageSetFromSerializedJson = mapper.readValue(serializedJson, ClusterImageSet.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterImageSet)
        .isNotNull()
        .isEqualTo(clusterImageSetFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "clusterimageset-sample")
        .hasFieldOrPropertyWithValue("spec.releaseImage", "quay.io/openshift-release-dev/ocp-release:4.0.0-0.6");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterImageSetBuilder clusterImageSetBuilder = new ClusterImageSetBuilder()
        .withNewMetadata()
        .withName("clusterimageset-sample")
        .endMetadata()
        .withNewSpec()
        .withReleaseImage("quay.io/openshift-release-dev/ocp-release:4.0.0-0.6")
        .endSpec();

    // When
    ClusterImageSet clusterImageSet = clusterImageSetBuilder.build();

    // Then
    assertThat(clusterImageSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "clusterimageset-sample")
        .hasFieldOrPropertyWithValue("spec.releaseImage", "quay.io/openshift-release-dev/ocp-release:4.0.0-0.6");
  }
}
