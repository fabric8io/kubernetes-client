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
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class SelectorSyncSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-selectorsyncset.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final SelectorSyncSet selectorSyncSet = mapper.readValue(originalJson, SelectorSyncSet.class);
    final String serializedJson = mapper.writeValueAsString(selectorSyncSet);
    final SelectorSyncSet selectorSyncSetFromSerializedJson = mapper.readValue(serializedJson, SelectorSyncSet.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(selectorSyncSet)
        .isNotNull()
        .isEqualTo(selectorSyncSetFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "mygroup")
        .hasFieldOrPropertyWithValue("spec.clusterDeploymentSelector.matchLabels",
            Collections.singletonMap("cluster-group", "abutcher"))
        .extracting("spec.resources").asList()
        .hasSize(1);
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    Group group = new GroupBuilder()
        .withNewMetadata().withName("mygroup").endMetadata()
        .addToUsers("abutcher")
        .build();
    Map<String, Object> groupResource = mapper.convertValue(group, Map.class);
    SelectorSyncSetBuilder selectorSyncSetBuilder = new SelectorSyncSetBuilder()
        .withNewMetadata()
        .withName("mygroup")
        .endMetadata()
        .withNewSpec()
        .withNewClusterDeploymentSelector()
        .addToMatchLabels("cluster-group", "abutcher")
        .endClusterDeploymentSelector()
        .withResources(Collections.singletonList(groupResource))
        .endSpec();

    // When
    SelectorSyncSet selectorSyncSet = selectorSyncSetBuilder.build();

    // Then
    assertThat(selectorSyncSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "mygroup")
        .hasFieldOrPropertyWithValue("spec.clusterDeploymentSelector.matchLabels",
            Collections.singletonMap("cluster-group", "abutcher"))
        .extracting("spec.resources").asList()
        .hasSize(1);
  }
}
