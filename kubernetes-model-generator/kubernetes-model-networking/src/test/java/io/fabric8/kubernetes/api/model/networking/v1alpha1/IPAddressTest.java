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
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class IPAddressTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(IPAddress.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-ipaddress.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final IPAddress ipAddress = mapper.readValue(originalJson, IPAddress.class);
    final String serializedJson = mapper.writeValueAsString(ipAddress);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(ipAddress)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "192.168.1.5")
        .hasFieldOrPropertyWithValue("spec.parentRef.group", "apps")
        .hasFieldOrPropertyWithValue("spec.parentRef.resource", "Deployment")
        .hasFieldOrPropertyWithValue("spec.parentRef.namespace", "default")
        .hasFieldOrPropertyWithValue("spec.parentRef.name", "test-deploy")
        .hasFieldOrPropertyWithValue("spec.parentRef.uid", "95f24228-b0fb-499c-94f0-801a707c6875");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    IPAddressBuilder ipAddressBuilder = new IPAddressBuilder()
        .withNewMetadata()
        .withName("192.168.1.5")
        .endMetadata()
        .withNewSpec()
        .withNewParentRef()
        .withGroup("apps")
        .withResource("Deployment")
        .withNamespace("default")
        .withName("test-deploy")
        .withUid("95f24228-b0fb-499c-94f0-801a707c6875")
        .endParentRef()
        .endSpec();
    // When
    IPAddress ipAddress = ipAddressBuilder.build();

    // Then
    assertThat(ipAddress)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "192.168.1.5")
        .hasFieldOrPropertyWithValue("spec.parentRef.group", "apps")
        .hasFieldOrPropertyWithValue("spec.parentRef.resource", "Deployment")
        .hasFieldOrPropertyWithValue("spec.parentRef.namespace", "default")
        .hasFieldOrPropertyWithValue("spec.parentRef.name", "test-deploy")
        .hasFieldOrPropertyWithValue("spec.parentRef.uid", "95f24228-b0fb-499c-94f0-801a707c6875");
  }
}
