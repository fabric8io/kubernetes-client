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
package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class GatewayTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException, ParseException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-gateway.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Gateway gateway = mapper.readValue(originalJson, Gateway.class);
    final String serializedJson = mapper.writeValueAsString(gateway);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(gateway)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-gateway")
        .hasFieldOrPropertyWithValue("spec.gatewayClassName", "example-gateway-class")
        .hasFieldOrPropertyWithValue("spec.listeners", Collections.singletonList(new ListenerBuilder()
            .withName("http")
            .withProtocol("HTTP")
            .withPort(80)
            .build()));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    GatewayBuilder gatewayBuilder = new GatewayBuilder()
        .withNewMetadata()
        .withName("example-gateway")
        .endMetadata()
        .withNewSpec()
        .withGatewayClassName("example-gateway-class")
        .addNewListener()
        .withName("http")
        .withProtocol("HTTP")
        .withPort(80)
        .endListener()
        .endSpec();

    // When
    Gateway gateway = gatewayBuilder.build();

    // Then
    assertThat(gateway)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-gateway")
        .hasFieldOrPropertyWithValue("spec.gatewayClassName", "example-gateway-class")
        .hasFieldOrPropertyWithValue("spec.listeners", Collections.singletonList(new ListenerBuilder()
            .withName("http")
            .withProtocol("HTTP")
            .withPort(80)
            .build()));
  }
}
