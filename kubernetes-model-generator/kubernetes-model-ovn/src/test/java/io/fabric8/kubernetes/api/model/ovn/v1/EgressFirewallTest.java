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
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EgressFirewallTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isNamespaceScoped() {
    assertThat(EgressFirewall.class.getInterfaces()).contains(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/v1-egressfirewall.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final EgressFirewall egressFirewall = mapper.readValue(originalJson, EgressFirewall.class);
    final String serializedJson = mapper.writeValueAsString(egressFirewall);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(egressFirewall)
        .hasFieldOrPropertyWithValue("metadata.name", "default")
        .hasFieldOrPropertyWithValue("spec.egress", Arrays.asList(
            new EgressFirewallRuleBuilder()
                .withType("Allow")
                .withNewTo()
                .withDnsName("www.openvswitch.org")
                .endTo()
                .build(),
            new EgressFirewallRuleBuilder()
                .withType("Allow")
                .withNewTo()
                .withCidrSelector("1.2.3.0/24")
                .endTo()
                .addNewPort()
                .withProtocol("UDP")
                .withPort(55)
                .endPort()
                .build(),
            new EgressFirewallRuleBuilder()
                .withType("Deny")
                .withNewTo()
                .withCidrSelector("0.0.0.0/0")
                .endTo()
                .build()));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    EgressFirewallBuilder egressFirewallBuilder = new EgressFirewallBuilder()
        .withNewMetadata()
        .withName("default")
        .endMetadata()
        .withNewSpec()
        .addNewEgress()
        .withType("Allow")
        .withNewTo()
        .withDnsName("www.openvswitch.org")
        .endTo()
        .endEgress()
        .addNewEgress()
        .withType("Allow")
        .withNewTo()
        .withCidrSelector("1.2.3.0/24")
        .endTo()
        .addNewPort()
        .withProtocol("UDP")
        .withPort(55)
        .endPort()
        .endEgress()
        .addNewEgress()
        .withType("Deny")
        .withNewTo()
        .withCidrSelector("0.0.0.0/0")
        .endTo()
        .endEgress()
        .endSpec();
    // When
    EgressFirewall egressFirewall = egressFirewallBuilder.build();

    // Then
    assertThat(egressFirewall)
        .hasFieldOrPropertyWithValue("metadata.name", "default")
        .hasFieldOrPropertyWithValue("spec.egress", Arrays.asList(
            new EgressFirewallRuleBuilder()
                .withType("Allow")
                .withNewTo()
                .withDnsName("www.openvswitch.org")
                .endTo()
                .build(),
            new EgressFirewallRuleBuilder()
                .withType("Allow")
                .withNewTo()
                .withCidrSelector("1.2.3.0/24")
                .endTo()
                .addNewPort()
                .withProtocol("UDP")
                .withPort(55)
                .endPort()
                .build(),
            new EgressFirewallRuleBuilder()
                .withType("Deny")
                .withNewTo()
                .withCidrSelector("0.0.0.0/0")
                .endTo()
                .build()));
  }
}
