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
package io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Policy;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PolicyTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-policy.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Policy policy = mapper.readValue(originalJson, Policy.class);
    final String serializedJson = mapper.writeValueAsString(policy);
    final Policy policyFromSerializedJson = mapper.readValue(serializedJson, Policy.class);

    // Then
    assertNotNull(policy);
    assertNotNull(serializedJson);
    assertNotNull(policyFromSerializedJson);
    assertEquals(policy.getMetadata().getName(), policyFromSerializedJson.getMetadata().getName());
    assertEquals("inform", policy.getSpec().getRemediationAction());
    assertEquals(1, policy.getSpec().getPolicyTemplates().size());
    assertNotNull(policy.getSpec().getPolicyTemplates().get(0));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PolicyBuilder policyBuilder = new PolicyBuilder()
        .withNewMetadata()
        .withName("test-policy-swagger")
        .endMetadata()
        .withNewSpec()
        .withDisabled(false)
        .withRemediationAction("enforce")
        .addNewPolicyTemplate()
        .withObjectDefinition(Collections.singletonMap("kind", "ConfigurationPolicy"))
        .endPolicyTemplate()
        .endSpec();

    // When
    Policy policy = policyBuilder.build();

    // Then
    assertNotNull(policy);
    assertEquals("test-policy-swagger", policy.getMetadata().getName());
    assertEquals("enforce", policy.getSpec().getRemediationAction());
    assertFalse(policy.getSpec().getDisabled());
    assertEquals(Collections.singletonMap("kind", "ConfigurationPolicy"),
        policy.getSpec().getPolicyTemplates().get(0).getObjectDefinition());
  }
}
