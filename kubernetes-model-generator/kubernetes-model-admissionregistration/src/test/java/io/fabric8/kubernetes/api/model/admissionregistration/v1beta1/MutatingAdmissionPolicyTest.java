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
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class MutatingAdmissionPolicyTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(
        Objects.requireNonNull(getClass().getResourceAsStream("/test-mutatingadmissionpolicy-v1beta1.json")))
        .useDelimiter("\\A")
        .next();

    // When
    final MutatingAdmissionPolicy validatingAdmissionPolicy = mapper.readValue(originalJson, MutatingAdmissionPolicy.class);
    final String serializedJson = mapper.writeValueAsString(validatingAdmissionPolicy);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(validatingAdmissionPolicy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "mutating-policy.example.com")
        .hasFieldOrPropertyWithValue("spec.matchConstraints.resourceRules",
            Collections.singletonList(new NamedRuleWithOperationsBuilder()
                .addToApiGroups("apps")
                .addToApiVersions("v1beta1")
                .addToOperations("CREATE", "UPDATE")
                .addToResources("deployments")
                .addToResourceNames("resourceNamesValue")
                .withScope("scopeValue")
                .build()))
        .hasFieldOrPropertyWithValue("spec.mutations", Collections.singletonList(new MutationBuilder()
            .withNewApplyConfiguration("newExpression")
            .withJsonPatch(new JSONPatch("newJsonPatch"))
            .withPatchType("newPatchType")
            .build()));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    MutatingAdmissionPolicyBuilder mutatingAdmissionPolicyBuilder = new MutatingAdmissionPolicyBuilder()
        .withNewMetadata().withName("mutating-policy.example.com").endMetadata()
        .withNewSpec()
        .addNewMutation()
        .withNewApplyConfiguration("newExpression")
        .withJsonPatch(new JSONPatch("newJsonPatch"))
        .withPatchType("newPatchType")
        .endMutation()
        .withNewMatchConstraints()
        .addNewResourceRule()
        .addToApiGroups("apps")
        .addToApiVersions("v1beta1")
        .addToOperations("CREATE", "UPDATE")
        .addToResources("deployments")
        .endResourceRule()
        .endMatchConstraints()
        .endSpec();

    // When
    MutatingAdmissionPolicy mutatingAdmissionPolicy = mutatingAdmissionPolicyBuilder.build();

    // Then
    assertThat(mutatingAdmissionPolicy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "mutating-policy.example.com")
        .hasFieldOrPropertyWithValue("spec.matchConstraints.resourceRules",
            Collections.singletonList(new NamedRuleWithOperationsBuilder()
                .addToApiGroups("apps")
                .addToApiVersions("v1beta1")
                .addToOperations("CREATE", "UPDATE")
                .addToResources("deployments")
                .build()))
        .hasFieldOrPropertyWithValue("spec.mutations", Collections.singletonList(new MutationBuilder()
            .withNewApplyConfiguration("newExpression")
            .withJsonPatch(new JSONPatch("newJsonPatch"))
            .withPatchType("newPatchType")
            .build()));
  }
}
