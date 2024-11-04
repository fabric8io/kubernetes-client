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
package io.fabric8.kubernetes.api.model.ovn.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EgressServiceTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new EgressService().getApiVersion()).isEqualTo("k8s.ovn.org/v1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new EgressService().getPlural()).isEqualTo("egressservices");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new EgressService().getKind()).isEqualTo("EgressService");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(EgressService.class.getInterfaces()).contains(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/v1-egressservice.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final EgressService egressService = mapper.readValue(originalJson, EgressService.class);
    final String serializedJson = mapper.writeValueAsString(egressService);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(egressService)
        .hasFieldOrPropertyWithValue("metadata.name", "test-svc")
        .hasFieldOrPropertyWithValue("spec.sourceIPBy", "LoadBalancerIP")
        .hasFieldOrPropertyWithValue("spec.nodeSelector.matchLabels",
            Collections.singletonMap("node-role.kubernetes.io/worker", ""));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    EgressServiceBuilder egressServiceBuilder = new EgressServiceBuilder()
        .withNewMetadata()
        .withName("test-svc")
        .endMetadata()
        .withNewSpec()
        .withSourceIPBy("LoadBalancerIP")
        .withNewNodeSelector()
        .withMatchLabels(Collections.singletonMap("node-role.kubernetes.io/worker", ""))
        .endNodeSelector()
        .endSpec();
    // When
    EgressService egressService = egressServiceBuilder.build();

    // Then
    assertThat(egressService)
        .hasFieldOrPropertyWithValue("metadata.name", "test-svc")
        .hasFieldOrPropertyWithValue("spec.sourceIPBy", "LoadBalancerIP")
        .hasFieldOrPropertyWithValue("spec.nodeSelector.matchLabels",
            Collections.singletonMap("node-role.kubernetes.io/worker", ""));
  }
}
