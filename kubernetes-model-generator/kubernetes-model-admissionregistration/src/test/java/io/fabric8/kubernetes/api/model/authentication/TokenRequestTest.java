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
package io.fabric8.kubernetes.api.model.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class TokenRequestTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-tokenrequest.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final TokenRequest tokenRequest = mapper.readValue(originalJson, TokenRequest.class);
    final String serializedJson = mapper.writeValueAsString(tokenRequest);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(tokenRequest)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "my-service-account")
        .hasFieldOrPropertyWithValue("spec.audiences", Collections.singletonList("https://kubernetes.default.svc"))
        .hasFieldOrPropertyWithValue("spec.expirationSeconds", 3600L)
        .hasFieldOrPropertyWithValue("spec.boundObjectRef.kind", "Pod")
        .hasFieldOrPropertyWithValue("spec.boundObjectRef.apiVersion", "v1")
        .hasFieldOrPropertyWithValue("spec.boundObjectRef.name", "pod-foo-346acf")
        .hasFieldOrPropertyWithValue("status.token", "my.secret.token");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    TokenRequestBuilder tokenRequestBuilder = new TokenRequestBuilder()
        .withNewMetadata()
        .withName("my-service-account")
        .endMetadata()
        .withNewSpec()
        .withAudiences("https://kubernetes.default.svc")
        .withExpirationSeconds(3600L)
        .withNewBoundObjectRef()
        .withKind("Pod")
        .withApiVersion("v1")
        .withName("pod-foo-346acf")
        .endBoundObjectRef()
        .endSpec()
        .withNewStatus()
        .withToken("my.secret.token")
        .endStatus();
    // When
    TokenRequest tokenRequest = tokenRequestBuilder.build();

    // Then
    assertThat(tokenRequest)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "my-service-account")
        .hasFieldOrPropertyWithValue("spec.audiences", Collections.singletonList("https://kubernetes.default.svc"))
        .hasFieldOrPropertyWithValue("spec.expirationSeconds", 3600L)
        .hasFieldOrPropertyWithValue("spec.boundObjectRef.kind", "Pod")
        .hasFieldOrPropertyWithValue("spec.boundObjectRef.apiVersion", "v1")
        .hasFieldOrPropertyWithValue("spec.boundObjectRef.name", "pod-foo-346acf")
        .hasFieldOrPropertyWithValue("status.token", "my.secret.token");
  }
}
