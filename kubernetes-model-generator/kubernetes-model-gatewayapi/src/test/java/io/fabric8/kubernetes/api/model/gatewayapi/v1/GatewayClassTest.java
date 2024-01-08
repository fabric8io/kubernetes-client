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
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class GatewayClassTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScopedResource() {
    assertThat(GatewayClass.class.getInterfaces()).doesNotContain(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/v1-valid-gatewayclass.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final GatewayClass gatewayClass = mapper.readValue(originalJson, GatewayClass.class);
    final String serializedJson = mapper.writeValueAsString(gatewayClass);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(gatewayClass)
        .hasFieldOrPropertyWithValue("metadata.name", "cluster-gateway")
        .hasFieldOrPropertyWithValue("spec.controllerName", "example.com/gateway-controller")
        .hasFieldOrPropertyWithValue("spec.parametersRef.name", "acme-lb")
        .hasFieldOrPropertyWithValue("spec.parametersRef.group", "example.com")
        .hasFieldOrPropertyWithValue("spec.parametersRef.kind", "Parameters");
    ;
  }

  @Test
  void builder() {
    // Given
    GatewayClassBuilder gatewayClassBuilder = new GatewayClassBuilder()
        .withNewMetadata()
        .withName("cluster-gateway")
        .endMetadata()
        .withNewSpec()
        .withControllerName("example.com/gateway-controller")
        .withNewParametersRef()
        .withName("acme-lb")
        .withGroup("example.com")
        .withKind("Parameters")
        .endParametersRef()
        .endSpec();

    // When
    GatewayClass gatewayClass = gatewayClassBuilder.build();

    // Then
    assertThat(gatewayClass)
        .hasFieldOrPropertyWithValue("metadata.name", "cluster-gateway")
        .hasFieldOrPropertyWithValue("spec.controllerName", "example.com/gateway-controller")
        .hasFieldOrPropertyWithValue("spec.parametersRef.name", "acme-lb")
        .hasFieldOrPropertyWithValue("spec.parametersRef.group", "example.com")
        .hasFieldOrPropertyWithValue("spec.parametersRef.kind", "Parameters");
  }
}
