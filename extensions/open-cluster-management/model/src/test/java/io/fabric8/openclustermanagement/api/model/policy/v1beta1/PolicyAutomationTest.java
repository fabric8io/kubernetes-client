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
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.runtime.RawExtensionBuilder;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PolicyAutomationTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = Helper.loadJson("/valid-policyautomation.json");

    // When
    final PolicyAutomation policyAutomation = mapper.readValue(originalJson, PolicyAutomation.class);
    final String serializedJson = mapper.writeValueAsString(policyAutomation);
    final PolicyAutomation paFromSerializedJson = mapper.readValue(serializedJson, PolicyAutomation.class);

    // Then
    assertNotNull(policyAutomation);
    assertNotNull(serializedJson);
    assertNotNull(paFromSerializedJson);
    assertEquals(policyAutomation.getMetadata().getName(), paFromSerializedJson.getMetadata().getName());
    assertEquals("case5-test-policy", policyAutomation.getSpec().getPolicyRef());
    assertEquals("noncompliant", policyAutomation.getSpec().getEventHook());
    assertEquals("disabled", policyAutomation.getSpec().getMode());
    assertEquals("Demo Job Template", policyAutomation.getSpec().getAutomationDef().getName());
    assertEquals("toweraccess", policyAutomation.getSpec().getAutomationDef().getSecret());
    assertEquals(new RawExtensionBuilder()
        .withValue(Map.of(
            "sn_severity", 1,
            "sn_priority", 1,
            "target_clusters", Collections.singletonList("cluster1")))
        .build(),
        policyAutomation.getSpec().getAutomationDef().getExtraVars());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PolicyAutomationBuilder policyAutomationBuilder = new PolicyAutomationBuilder()
        .withNewMetadata()
        .withName("create-service-now-ticket")
        .endMetadata()
        .withNewSpec()
        .withEventHook("noncompliant")
        .withPolicyRef("case5-test-policy")
        .withMode("disabled")
        .withNewAutomationDef()
        .withName("Demo Job Template")
        .withSecret("toweraccess")
        .withExtraVars(Map.of(
            "sn_severity", 1,
            "sn_priority", 1,
            "target_clusters", Collections.singletonList("cluster1")))
        .endAutomationDef()
        .endSpec();

    // When
    PolicyAutomation policyAutomation = policyAutomationBuilder.build();

    // Then
    assertNotNull(policyAutomation);
    assertEquals("create-service-now-ticket", policyAutomation.getMetadata().getName());
    assertEquals("case5-test-policy", policyAutomation.getSpec().getPolicyRef());
    assertEquals("noncompliant", policyAutomation.getSpec().getEventHook());
    assertEquals("disabled", policyAutomation.getSpec().getMode());
    assertEquals("Demo Job Template", policyAutomation.getSpec().getAutomationDef().getName());
    assertEquals("toweraccess", policyAutomation.getSpec().getAutomationDef().getSecret());
    assertEquals(Map.of(
        "sn_severity", 1,
        "sn_priority", 1,
        "target_clusters", Collections.singletonList("cluster1")),
        policyAutomation.getSpec().getAutomationDef().getExtraVars());
  }

}
