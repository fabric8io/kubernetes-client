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
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatingAdmissionPolicyBindingTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ValidatingAdmissionPolicyBinding.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void apiGroup() {
    assertThat(new ValidatingAdmissionPolicyBinding().getApiVersion()).isEqualTo("admissionregistration.k8s.io/v1");
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/test-v1-validatingadmissionpolicybinding.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ValidatingAdmissionPolicyBinding validatingAdmissionPolicyBinding = mapper.readValue(originalJson,
        ValidatingAdmissionPolicyBinding.class);
    final String serializedJson = mapper.writeValueAsString(validatingAdmissionPolicyBinding);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(validatingAdmissionPolicyBinding)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "demo-binding-test.example.com")
        .hasFieldOrPropertyWithValue("spec.matchResources.namespaceSelector.matchLabels",
            Collections.singletonMap("environment", "test"))
        .hasFieldOrPropertyWithValue("spec.policyName", "demo-policy.example.com");
  }
}
