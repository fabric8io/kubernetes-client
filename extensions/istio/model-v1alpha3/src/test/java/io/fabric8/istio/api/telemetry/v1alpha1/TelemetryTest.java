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
package io.fabric8.istio.api.telemetry.v1alpha1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class TelemetryTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new Telemetry().getApiVersion()).isEqualTo("telemetry.istio.io/v1alpha1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new Telemetry().getPlural()).isEqualTo("telemetries");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new Telemetry().getKind()).isEqualTo("Telemetry");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(Telemetry.class.getInterfaces()).contains(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/telemetry-v1alpha1.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Telemetry telemetry = mapper.readValue(originalJson, Telemetry.class);
    final String serializedJson = mapper.writeValueAsString(telemetry);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(telemetry)
        .hasFieldOrPropertyWithValue("metadata.name", "foo-tracing-alternate")
        .hasFieldOrPropertyWithValue("spec.selector.matchLabels",
            Collections.singletonMap("service.istio.io/canonical-name", "foo"))
        .satisfies(t -> assertThat(t.getSpec().getTracing())
            .singleElement(InstanceOfAssertFactories.type(Tracing.class))
            .hasFieldOrPropertyWithValue("randomSamplingPercentage", 10d))
        .satisfies(t -> assertThat(t.getSpec().getTracing().get(0).getProviders())
            .singleElement(InstanceOfAssertFactories.type(ProviderRef.class))
            .hasFieldOrPropertyWithValue("name", "zipkin-alternate"));
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    TelemetryBuilder telemetryBuilder = new TelemetryBuilder()
        .withNewMetadata()
        .withName("foo-tracing-alternate")
        .endMetadata()
        .withNewSpec()
        .withNewSelector()
        .addToMatchLabels(Collections.singletonMap("service.istio.io/canonical-name", "foo"))
        .endV1beta1Selector()
        .addNewTracing()
        .addNewProvider()
        .withName("zipkin-alternate")
        .endProvider()
        .withRandomSamplingPercentage(10d)
        .endTracing()
        .endSpec();
    // When
    Telemetry telemetry = telemetryBuilder.build();

    // Then
    assertThat(telemetry)
        .hasFieldOrPropertyWithValue("metadata.name", "foo-tracing-alternate")
        .hasFieldOrPropertyWithValue("spec.selector.matchLabels",
            Collections.singletonMap("service.istio.io/canonical-name", "foo"))
        .satisfies(t -> assertThat(t.getSpec().getTracing())
            .singleElement(InstanceOfAssertFactories.type(Tracing.class))
            .hasFieldOrPropertyWithValue("randomSamplingPercentage", 10d))
        .satisfies(t -> assertThat(t.getSpec().getTracing().get(0).getProviders())
            .singleElement(InstanceOfAssertFactories.type(ProviderRef.class))
            .hasFieldOrPropertyWithValue("name", "zipkin-alternate"));
  }
}
