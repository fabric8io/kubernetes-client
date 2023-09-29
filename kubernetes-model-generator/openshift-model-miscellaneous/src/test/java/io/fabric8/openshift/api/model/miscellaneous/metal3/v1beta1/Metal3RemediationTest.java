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
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Metal3RemediationTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isNamespaceScoped() {
    assertThat(Namespaced.class.isAssignableFrom(Metal3Remediation.class)).isTrue();
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException, ParseException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/test-v1beta1-metal3remediation.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Metal3Remediation metal3Remediation = mapper.readValue(originalJson, Metal3Remediation.class);
    final String serializedJson = mapper.writeValueAsString(metal3Remediation);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(metal3Remediation)
        .hasFieldOrPropertyWithValue("metadata.name", "test-remediation")
        .extracting(Metal3Remediation::getSpec)
        .hasFieldOrPropertyWithValue("strategy.retryLimit", 1)
        .hasFieldOrPropertyWithValue("strategy.timeout", Duration.parse("5m0s"))
        .hasFieldOrPropertyWithValue("strategy.type", "Reboot");
  }

  @Test
  void builder() throws ParseException {
    // Given
    Metal3RemediationBuilder metal3RemediationBuilder = new Metal3RemediationBuilder()
        .withNewMetadata()
        .withName("test-remediation")
        .endMetadata()
        .withNewSpec()
        .withNewStrategy()
        .withTimeout(Duration.parse("5s"))
        .withRetryLimit(5)
        .withType("Done")
        .endStrategy()
        .endSpec();

    // When
    Metal3Remediation metal3Remediation = metal3RemediationBuilder.build();

    // Then
    assertThat(metal3Remediation)
        .hasFieldOrPropertyWithValue("metadata.name", "test-remediation")
        .extracting(Metal3Remediation::getSpec)
        .hasFieldOrPropertyWithValue("strategy.retryLimit", 5)
        .hasFieldOrPropertyWithValue("strategy.timeout", Duration.parse("5s"))
        .hasFieldOrPropertyWithValue("strategy.type", "Done");
  }
}
