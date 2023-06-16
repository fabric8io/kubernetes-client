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
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.NodeSelectorBuilder;
import io.fabric8.kubernetes.api.model.NodeSelectorRequirementBuilder;
import io.fabric8.kubernetes.api.model.NodeSelectorTermBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceClassTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-resourceclass.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ResourceClass resourceClass = mapper.readValue(originalJson, ResourceClass.class);
    final String serializedJson = mapper.writeValueAsString(resourceClass);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(resourceClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-rc")
        .hasFieldOrPropertyWithValue("parametersRef.kind", "kindValue")
        .hasFieldOrPropertyWithValue("parametersRef.name", "nameValue")
        .hasFieldOrPropertyWithValue("parametersRef.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("suitableNodes.nodeSelectorTerms", Collections.singletonList(new NodeSelectorTermBuilder()
            .addToMatchExpressions(new NodeSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("In")
                .addToValues("dev")
                .build())
            .addToMatchFields(new NodeSelectorRequirementBuilder()
                .withKey("metadata.name")
                .withOperator("In")
                .addToValues("backend")
                .build())
            .build()));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ResourceClassBuilder resourceClassBuilder = new ResourceClassBuilder()
        .withNewMetadata()
        .withName("example-rc")
        .endMetadata()
        .withNewParametersRef()
        .withKind("kindValue")
        .withName("nameValue")
        .withApiGroup("apiGroupValue")
        .endParametersRef()
        .withSuitableNodes(new NodeSelectorBuilder()
            .addNewNodeSelectorTerm()
            .addToMatchExpressions(new NodeSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("In")
                .addToValues("dev")
                .build())
            .addToMatchFields(new NodeSelectorRequirementBuilder()
                .withKey("metadata.name")
                .withOperator("In")
                .addToValues("backend")
                .build())
            .endNodeSelectorTerm()
            .build());

    // When
    ResourceClass resourceClass = resourceClassBuilder.build();

    // Then
    assertThat(resourceClass)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-rc")
        .hasFieldOrPropertyWithValue("parametersRef.kind", "kindValue")
        .hasFieldOrPropertyWithValue("parametersRef.name", "nameValue")
        .hasFieldOrPropertyWithValue("parametersRef.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("suitableNodes.nodeSelectorTerms", Collections.singletonList(new NodeSelectorTermBuilder()
            .addToMatchExpressions(new NodeSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("In")
                .addToValues("dev")
                .build())
            .addToMatchFields(new NodeSelectorRequirementBuilder()
                .withKey("metadata.name")
                .withOperator("In")
                .addToValues("backend")
                .build())
            .build()));
  }
}
