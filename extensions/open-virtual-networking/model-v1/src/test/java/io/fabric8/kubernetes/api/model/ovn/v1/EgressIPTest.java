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
package io.fabric8.kubernetes.api.model.ovn.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirementBuilder;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EgressIPTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new EgressIP().getApiVersion()).isEqualTo("k8s.ovn.org/v1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new EgressIP().getPlural()).isEqualTo("egressips");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new EgressIP().getKind()).isEqualTo("EgressIP");
  }

  @Test
  void isClusterScoped() {
    assertThat(EgressIP.class.getInterfaces()).doesNotContain(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/v1-egressip.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final EgressIP egressIP = mapper.readValue(originalJson, EgressIP.class);
    final String serializedJson = mapper.writeValueAsString(egressIP);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(egressIP)
        .hasFieldOrPropertyWithValue("metadata.name", "egressip-prod")
        .hasFieldOrPropertyWithValue("spec.egressIPs", Arrays.asList("172.18.0.33", "172.18.0.44"))
        .hasFieldOrPropertyWithValue("spec.namespaceSelector.matchExpressions",
            Collections.singletonList(new LabelSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("NotIn")
                .withValues("development")
                .build()))
        .hasFieldOrPropertyWithValue("spec.podSelector.matchLabels", Collections.singletonMap("app", "web"));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    EgressIPBuilder egressIPBuilder = new EgressIPBuilder()
        .withNewMetadata()
        .withName("egressip-prod")
        .endMetadata()
        .withNewSpec()
        .addToEgressIPs("172.18.0.33", "172.18.0.44")
        .withNewNamespaceSelector()
        .addNewMatchExpression()
        .withKey("environment")
        .withOperator("NotIn")
        .withValues("development")
        .endMatchExpression()
        .endNamespaceSelector()
        .withNewPodSelector()
        .withMatchLabels(Collections.singletonMap("app", "web"))
        .endPodSelector()
        .endSpec();
    // When
    EgressIP egressIP = egressIPBuilder.build();

    // Then
    assertThat(egressIP)
        .hasFieldOrPropertyWithValue("metadata.name", "egressip-prod")
        .hasFieldOrPropertyWithValue("spec.egressIPs", Arrays.asList("172.18.0.33", "172.18.0.44"))
        .hasFieldOrPropertyWithValue("spec.namespaceSelector.matchExpressions",
            Collections.singletonList(new LabelSelectorRequirementBuilder()
                .withKey("environment")
                .withOperator("NotIn")
                .withValues("development")
                .build()))
        .hasFieldOrPropertyWithValue("spec.podSelector.matchLabels", Collections.singletonMap("app", "web"));
  }
}
