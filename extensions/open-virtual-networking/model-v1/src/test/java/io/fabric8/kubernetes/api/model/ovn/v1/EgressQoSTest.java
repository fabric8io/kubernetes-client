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
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EgressQoSTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new EgressQoS().getApiVersion()).isEqualTo("k8s.ovn.org/v1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new EgressQoS().getPlural()).isEqualTo("egressqoses");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new EgressQoS().getKind()).isEqualTo("EgressQoS");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(EgressQoS.class.getInterfaces()).contains(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/v1-egressqos.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final EgressQoS egressQoS = mapper.readValue(originalJson, EgressQoS.class);
    final String serializedJson = mapper.writeValueAsString(egressQoS);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(egressQoS)
        .hasFieldOrPropertyWithValue("metadata.name", "default")
        .hasFieldOrPropertyWithValue("spec.egress", Arrays.asList(new EgressQoSRuleBuilder()
            .withDscp(48)
            .withNewPodSelector()
            .withMatchLabels(Collections.singletonMap("app", "updated-example"))
            .endPodSelector()
            .build(),
            new EgressQoSRuleBuilder()
                .withDscp(28)
                .build()));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    EgressQoSBuilder egressQoSBuilder = new EgressQoSBuilder()
        .withNewMetadata()
        .withName("default")
        .endMetadata()
        .withNewSpec()
        .addNewEgress()
        .withDscp(48)
        .withNewPodSelector()
        .withMatchLabels(Collections.singletonMap("app", "updated-example"))
        .endPodSelector()
        .endEgress()
        .addNewEgress()
        .withDscp(28)
        .endEgress()
        .endSpec();
    // When
    EgressQoS egressQoS = egressQoSBuilder.build();

    // Then
    assertThat(egressQoS)
        .hasFieldOrPropertyWithValue("metadata.name", "default")
        .hasFieldOrPropertyWithValue("spec.egress", Arrays.asList(new EgressQoSRuleBuilder()
            .withDscp(48)
            .withNewPodSelector()
            .withMatchLabels(Collections.singletonMap("app", "updated-example"))
            .endPodSelector()
            .build(),
            new EgressQoSRuleBuilder()
                .withDscp(28)
                .build()));
  }
}
