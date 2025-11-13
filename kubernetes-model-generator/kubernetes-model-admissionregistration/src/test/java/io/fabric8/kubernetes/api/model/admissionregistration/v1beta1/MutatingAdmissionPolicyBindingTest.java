/*
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
package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirementBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class MutatingAdmissionPolicyBindingTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(
        Objects.requireNonNull(getClass().getResourceAsStream("/test-mutatingadmissionpolicybinding-v1beta1.json")))
        .useDelimiter("\\A")
        .next();

    // When
    final MutatingAdmissionPolicyBinding validatingAdmissionPolicyBinding = mapper.readValue(originalJson,
        MutatingAdmissionPolicyBinding.class);
    final String serializedJson = mapper.writeValueAsString(validatingAdmissionPolicyBinding);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(validatingAdmissionPolicyBinding)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("spec.matchResources.namespaceSelector.matchExpressions",
            Collections.singletonList(new LabelSelectorRequirementBuilder()
                .withKey("keyValue")
                .withOperator("operatorValue")
                .withValues("valuesValue")
                .build()))
        .hasFieldOrPropertyWithValue("spec.policyName", "policyNameValue");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    MutatingAdmissionPolicyBindingBuilder validatingAdmissionPolicyBindingBuilder = new MutatingAdmissionPolicyBindingBuilder()
        .withNewMetadata().withName("demo-binding-test.example.com").endMetadata()
        .withNewSpec()
        .withPolicyName("demo-policy.example.com")
        .withNewMatchResources()
        .withNewNamespaceSelector()
        .addNewMatchExpression()
        .withKey("environment")
        .withOperator("In")
        .withValues("test")
        .endMatchExpression()
        .endNamespaceSelector()
        .endMatchResources()
        .endSpec();

    // When
    MutatingAdmissionPolicyBinding validatingAdmissionPolicyBinding = validatingAdmissionPolicyBindingBuilder.build();

    // Then
    assertThat(validatingAdmissionPolicyBinding)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "demo-binding-test.example.com")
        .hasFieldOrPropertyWithValue("spec.matchResources.namespaceSelector.matchExpressions",
            Collections.singletonList(new LabelSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("In")
                .withValues("test")
                .build()))
        .hasFieldOrPropertyWithValue("spec.policyName", "demo-policy.example.com");
  }
}
