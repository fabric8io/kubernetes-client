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
package io.fabric8.kubernetes.api.model.networking.v1alpha1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.NodeSelectorBuilder;
import io.fabric8.kubernetes.api.model.NodeSelectorTermBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ClusterCIDRTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ClusterCIDR.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clustercidr.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterCIDR clusterCIDR = mapper.readValue(originalJson, ClusterCIDR.class);
    final String serializedJson = mapper.writeValueAsString(clusterCIDR);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(clusterCIDR)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-clustercidr")
        .hasFieldOrPropertyWithValue("spec.nodeSelector.nodeSelectorTerms",
            Collections.singletonList(new NodeSelectorTermBuilder()
                .addNewMatchField()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchField()
                .addNewMatchExpression()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchExpression()
                .build()))
        .hasFieldOrPropertyWithValue("spec.perNodeHostBits", 4)
        .hasFieldOrPropertyWithValue("spec.ipv4", "10.0.0.0/8")
        .hasFieldOrPropertyWithValue("spec.ipv6", "2001:db8::/64");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterCIDRBuilder clusterCIDRBuilder = new ClusterCIDRBuilder()
        .withNewMetadata()
        .withName("test-clustercidr")
        .endMetadata()
        .withNewSpec()
        .withIpv4("10.0.0.0/8")
        .withIpv6("2001:db8::/64")
        .withPerNodeHostBits(4)
        .withNodeSelector(new NodeSelectorBuilder()
            .withNodeSelectorTerms(Collections.singletonList(new NodeSelectorTermBuilder()
                .addNewMatchField()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchField()
                .addNewMatchExpression()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchExpression()
                .build()))
            .build())
        .endSpec();
    // When
    ClusterCIDR clusterCIDR = clusterCIDRBuilder.build();

    // Then
    assertThat(clusterCIDR)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-clustercidr")
        .hasFieldOrPropertyWithValue("spec.nodeSelector.nodeSelectorTerms",
            Collections.singletonList(new NodeSelectorTermBuilder()
                .addNewMatchField()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchField()
                .addNewMatchExpression()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchExpression()
                .build()))
        .hasFieldOrPropertyWithValue("spec.perNodeHostBits", 4)
        .hasFieldOrPropertyWithValue("spec.ipv4", "10.0.0.0/8")
        .hasFieldOrPropertyWithValue("spec.ipv6", "2001:db8::/64");
  }
}
