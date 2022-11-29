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
package io.fabric8.openshift.api.model.hive.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class DNSZoneTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-dnszone.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final DNSZone dnsZone = mapper.readValue(originalJson, DNSZone.class);
    final String serializedJson = mapper.writeValueAsString(dnsZone);
    final DNSZone dnsZoneFromSerializedJson = mapper.readValue(serializedJson, DNSZone.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(dnsZone)
        .isNotNull()
        .isEqualTo(dnsZoneFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "dnszone-sample")
        .hasFieldOrPropertyWithValue("spec.zone", "testzone.testdomain.com")
        .hasFieldOrPropertyWithValue("spec.aws.credentialsSecretRef.name", "route53-creds-secret");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    DNSZoneBuilder dnsZoneBuilder = new DNSZoneBuilder()
        .withNewMetadata()
        .addToAnnotations(Collections.singletonMap("hive.openshift.io/delete-after", "8h"))
        .withName("dnszone-sample")
        .endMetadata()
        .withNewSpec()
        .withPreserveOnDelete(false)
        .withZone("testzone.testdomain.com")
        .withNewAws()
        .withNewCredentialsSecretRef().withName("route53-creds-secret").endCredentialsSecretRef()
        .endAws()
        .endSpec();

    // When
    DNSZone dnsZone = dnsZoneBuilder.build();

    // Then
    assertThat(dnsZone)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "dnszone-sample")
        .hasFieldOrPropertyWithValue("spec.zone", "testzone.testdomain.com")
        .hasFieldOrPropertyWithValue("spec.aws.credentialsSecretRef.name", "route53-creds-secret");
  }
}
