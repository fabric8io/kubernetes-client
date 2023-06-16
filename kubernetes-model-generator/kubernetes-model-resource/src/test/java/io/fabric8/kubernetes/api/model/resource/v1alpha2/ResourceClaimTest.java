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
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceClaimTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-resourceclaim.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ResourceClaim resourceClaim = mapper.readValue(originalJson, ResourceClaim.class);
    final String serializedJson = mapper.writeValueAsString(resourceClaim);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(resourceClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-resourceclaim")
        .hasFieldOrPropertyWithValue("spec.allocationMode", "Immediate")
        .hasFieldOrPropertyWithValue("spec.parametersRef.kind", "kindValue")
        .hasFieldOrPropertyWithValue("spec.parametersRef.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.parametersRef.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("spec.resourceClassName", "resource-class-name-value");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ResourceClaimBuilder resourceClaimBuilder = new ResourceClaimBuilder()
        .withNewMetadata()
        .withName("test-resourceclaim")
        .endMetadata()
        .withNewSpec()
        .withNewParametersRef()
        .withKind("kindValue")
        .withName("nameValue")
        .withApiGroup("apiGroupValue")
        .endParametersRef()
        .withAllocationMode("Immediate")
        .withResourceClassName("resource-class-name-value")
        .endSpec();

    // When
    ResourceClaim resourceClaim = resourceClaimBuilder.build();

    // Then
    assertThat(resourceClaim)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-resourceclaim")
        .hasFieldOrPropertyWithValue("spec.allocationMode", "Immediate")
        .hasFieldOrPropertyWithValue("spec.parametersRef.kind", "kindValue")
        .hasFieldOrPropertyWithValue("spec.parametersRef.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.parametersRef.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("spec.resourceClassName", "resource-class-name-value");
  }
}
