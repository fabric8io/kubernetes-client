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
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class HTTPRouteTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-httproute.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final HTTPRoute httpRoute = mapper.readValue(originalJson, HTTPRoute.class);
    final String serializedJson = mapper.writeValueAsString(httpRoute);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(httpRoute)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-route")
        .hasFieldOrPropertyWithValue("spec.parentRefs", Collections.singletonList(new ParentReferenceBuilder()
            .withName("example-gateway")
            .build()))
        .hasFieldOrPropertyWithValue("spec.hostnames", Collections.singletonList("example.com"))
        .hasFieldOrPropertyWithValue("spec.rules", Collections.singletonList(new HTTPRouteRuleBuilder()
            .addNewBackendRef()
            .withName("example-svc")
            .withPort(80)
            .endBackendRef()
            .build()));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    HTTPRouteBuilder httpRouteBuilder = new HTTPRouteBuilder()
        .withNewMetadata()
        .withName("example-route")
        .endMetadata()
        .withNewSpec()
        .addNewParentRef()
        .withName("example-gateway")
        .endParentRef()
        .addToHostnames("example.com")
        .addNewRule()
        .addNewBackendRef()
        .withName("example-svc")
        .withPort(80)
        .endBackendRef()
        .endRule()
        .endSpec();

    // When
    HTTPRoute httpRoute = httpRouteBuilder.build();

    // Then
    assertThat(httpRoute)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-route")
        .hasFieldOrPropertyWithValue("spec.parentRefs", Collections.singletonList(new ParentReferenceBuilder()
            .withName("example-gateway")
            .build()))
        .hasFieldOrPropertyWithValue("spec.hostnames", Collections.singletonList("example.com"))
        .hasFieldOrPropertyWithValue("spec.rules", Collections.singletonList(new HTTPRouteRuleBuilder()
            .addNewBackendRef()
            .withName("example-svc")
            .withPort(80)
            .endBackendRef()
            .build()));
  }
}
