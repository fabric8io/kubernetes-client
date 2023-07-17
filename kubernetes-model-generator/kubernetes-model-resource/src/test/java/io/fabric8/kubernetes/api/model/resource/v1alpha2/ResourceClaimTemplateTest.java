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

class ResourceClaimTemplateTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-resourceclaimtemplate.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ResourceClaimTemplate resourceClaimTemplate = mapper.readValue(originalJson, ResourceClaimTemplate.class);
    final String serializedJson = mapper.writeValueAsString(resourceClaimTemplate);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(resourceClaimTemplate)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-resourceclaimtemplate")
        .hasFieldOrPropertyWithValue("spec.metadata.annotations.annotationKey", "annotationValue")
        .hasFieldOrPropertyWithValue("spec.spec.allocationMode", "Immediate")
        .hasFieldOrPropertyWithValue("spec.spec.parametersRef.kind", "kindValue")
        .hasFieldOrPropertyWithValue("spec.spec.parametersRef.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.spec.parametersRef.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("spec.spec.resourceClassName", "resource-class-name-value");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ResourceClaimTemplateBuilder resourceClaimTemplateBuilder = new ResourceClaimTemplateBuilder()
        .withNewMetadata()
        .withName("test-resourceclaimtemplate")
        .endMetadata()
        .withNewSpec()
        .withNewMetadata()
        .addToAnnotations("annotationKey", "annotationValue")
        .endMetadata()
        .withNewSpec()
        .withNewParametersRef()
        .withKind("kindValue")
        .withName("nameValue")
        .withApiGroup("apiGroupValue")
        .endParametersRef()
        .withAllocationMode("Immediate")
        .withResourceClassName("resource-class-name-value")
        .endSpec()
        .endSpec();

    // When
    ResourceClaimTemplate resourceClaimTemplate = resourceClaimTemplateBuilder.build();

    // Then
    assertThat(resourceClaimTemplate)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-resourceclaimtemplate")
        .hasFieldOrPropertyWithValue("spec.metadata.annotations.annotationKey", "annotationValue")
        .hasFieldOrPropertyWithValue("spec.spec.allocationMode", "Immediate")
        .hasFieldOrPropertyWithValue("spec.spec.parametersRef.kind", "kindValue")
        .hasFieldOrPropertyWithValue("spec.spec.parametersRef.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.spec.parametersRef.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("spec.spec.resourceClassName", "resource-class-name-value");
  }

}
