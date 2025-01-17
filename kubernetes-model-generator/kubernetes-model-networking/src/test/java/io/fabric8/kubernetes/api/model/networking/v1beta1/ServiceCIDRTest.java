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
package io.fabric8.kubernetes.api.model.networking.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceCIDRTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ServiceCIDR.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-servicecidr.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ServiceCIDR serviceCIDR = mapper.readValue(originalJson, ServiceCIDR.class);
    final String serializedJson = mapper.writeValueAsString(serviceCIDR);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(serviceCIDR)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-servicecidr")
        .hasFieldOrPropertyWithValue("spec.cidrs", Collections.singletonList("192.168.0.0/24"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ServiceCIDRBuilder serviceCIDRBuilder = new ServiceCIDRBuilder()
        .withNewMetadata()
        .withName("test-servicecidr")
        .endMetadata()
        .withNewSpec()
        .withCidrs("192.168.0.0/24")
        .endSpec();
    // When
    ServiceCIDR serviceCIDR = serviceCIDRBuilder.build();

    // Then
    assertThat(serviceCIDR)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-servicecidr")
        .hasFieldOrPropertyWithValue("spec.cidrs", Collections.singletonList("192.168.0.0/24"));
  }
}
