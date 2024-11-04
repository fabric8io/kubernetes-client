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

class AdminPolicyBasedExternalRouteTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new AdminPolicyBasedExternalRoute().getApiVersion()).isEqualTo("k8s.ovn.org/v1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new AdminPolicyBasedExternalRoute().getPlural()).isEqualTo("adminpolicybasedexternalroutes");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new AdminPolicyBasedExternalRoute().getKind()).isEqualTo("AdminPolicyBasedExternalRoute");
  }

  @Test
  void isClusterScoped() {
    assertThat(AdminPolicyBasedExternalRoute.class.getInterfaces()).doesNotContain(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/v1-adminpolicybasedexternalroute.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final AdminPolicyBasedExternalRoute adminPolicyBasedExternalRoute = mapper.readValue(originalJson,
        AdminPolicyBasedExternalRoute.class);
    final String serializedJson = mapper.writeValueAsString(adminPolicyBasedExternalRoute);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(adminPolicyBasedExternalRoute)
        .hasFieldOrPropertyWithValue("metadata.name", "test-adminpolicybasedexternalroute")
        .hasFieldOrPropertyWithValue("spec.nextHops.static", Collections.singletonList(new StaticHopBuilder()
            .withIp("172.18.0.2")
            .withBfdEnabled(true)
            .build()))
        .hasFieldOrPropertyWithValue("spec.nextHops.dynamic", Collections.singletonList(new DynamicHopBuilder()
            .withBfdEnabled(true)
            .withNetworkAttachmentName("sriov1")
            .withNewNamespaceSelector()
            .withMatchLabels(Collections.singletonMap("gateway", "true"))
            .endNamespaceSelector()
            .withNewPodSelector()
            .withMatchLabels(Collections.singletonMap("external-gateway", "true"))
            .endPodSelector()
            .build()))
        .hasFieldOrPropertyWithValue("spec.from.namespaceSelector.matchLabels",
            Collections.singletonMap("multiple_gws", "true"));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    AdminPolicyBasedExternalRouteBuilder egressIPBuilder = new AdminPolicyBasedExternalRouteBuilder()
        .withNewMetadata()
        .withName("test-adminpolicybasedexternalroute")
        .endMetadata()
        .withNewSpec()
        .withNewFrom()
        .withNewNamespaceSelector()
        .withMatchLabels(Collections.singletonMap("multiple_gws", "true"))
        .endNamespaceSelector()
        .endFrom()
        .withNewNextHops()
        .addNewStatic()
        .withIp("172.18.0.2")
        .withBfdEnabled(true)
        .endStatic()
        .addNewDynamic()
        .withBfdEnabled(true)
        .withNewNamespaceSelector()
        .withMatchLabels(Collections.singletonMap("gateway", "true"))
        .endNamespaceSelector()
        .withNewPodSelector()
        .withMatchLabels(Collections.singletonMap("external-gateway", "true"))
        .endPodSelector()
        .endDynamic()
        .endNextHops()
        .endSpec();
    // When
    AdminPolicyBasedExternalRoute adminPolicyBasedExternalRoute = egressIPBuilder.build();

    // Then
    assertThat(adminPolicyBasedExternalRoute)
        .hasFieldOrPropertyWithValue("metadata.name", "test-adminpolicybasedexternalroute")
        .hasFieldOrPropertyWithValue("spec.nextHops.static", Collections.singletonList(new StaticHopBuilder()
            .withIp("172.18.0.2")
            .withBfdEnabled(true)
            .build()))
        .hasFieldOrPropertyWithValue("spec.nextHops.dynamic", Collections.singletonList(new DynamicHopBuilder()
            .withBfdEnabled(true)
            .withNewNamespaceSelector()
            .withMatchLabels(Collections.singletonMap("gateway", "true"))
            .endNamespaceSelector()
            .withNewPodSelector()
            .withMatchLabels(Collections.singletonMap("external-gateway", "true"))
            .endPodSelector()
            .build()))
        .hasFieldOrPropertyWithValue("spec.from.namespaceSelector.matchLabels",
            Collections.singletonMap("multiple_gws", "true"));
  }
}
