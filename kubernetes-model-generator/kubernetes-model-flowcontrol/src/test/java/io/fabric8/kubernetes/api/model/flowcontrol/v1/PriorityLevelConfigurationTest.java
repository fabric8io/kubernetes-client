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
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class PriorityLevelConfigurationTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(PriorityLevelConfiguration.class.getInterfaces()).doesNotContain(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-v1-prioritylevelconfiguration.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final PriorityLevelConfiguration priorityLevelConfiguration = mapper.readValue(originalJson,
        PriorityLevelConfiguration.class);
    final String serializedJson = mapper.writeValueAsString(priorityLevelConfiguration);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(priorityLevelConfiguration)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-prioritylevelconfiguration")
        .hasFieldOrPropertyWithValue("spec.type", "typeValue")
        .hasFieldOrPropertyWithValue("spec.limited.nominalConcurrencyShares", 1)
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.type", "typeValue")
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.queuing.queues", 1)
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.queuing.handSize", 2)
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.queuing.queueLengthLimit", 3)
        .hasFieldOrPropertyWithValue("spec.limited.lendablePercent", 3)
        .hasFieldOrPropertyWithValue("spec.limited.borrowingLimitPercent", 4)
        .hasFieldOrPropertyWithValue("spec.exempt.nominalConcurrencyShares", 1)
        .hasFieldOrPropertyWithValue("spec.exempt.lendablePercent", 2);
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    PriorityLevelConfigurationBuilder priorityLevelConfigurationBuilder = new PriorityLevelConfigurationBuilder()
        .withNewMetadata()
        .withName("test-prioritylevelconfiguration")
        .endMetadata()
        .withNewSpec()
        .withType("typeValue")
        .withNewLimited()
        .withNominalConcurrencyShares(1)
        .withNewLimitResponse()
        .withType("typeValue")
        .withNewQueuing()
        .withQueues(1)
        .withHandSize(2)
        .withQueueLengthLimit(3)
        .endQueuing()
        .endLimitResponse()
        .withLendablePercent(3)
        .withBorrowingLimitPercent(4)
        .endLimited()
        .withNewExempt(2, 1)
        .endSpec();
    // When
    PriorityLevelConfiguration priorityLevelConfiguration = priorityLevelConfigurationBuilder.build();

    // Then
    assertThat(priorityLevelConfiguration)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-prioritylevelconfiguration")
        .hasFieldOrPropertyWithValue("spec.type", "typeValue")
        .hasFieldOrPropertyWithValue("spec.limited.nominalConcurrencyShares", 1)
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.type", "typeValue")
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.queuing.queues", 1)
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.queuing.handSize", 2)
        .hasFieldOrPropertyWithValue("spec.limited.limitResponse.queuing.queueLengthLimit", 3)
        .hasFieldOrPropertyWithValue("spec.limited.lendablePercent", 3)
        .hasFieldOrPropertyWithValue("spec.limited.borrowingLimitPercent", 4)
        .hasFieldOrPropertyWithValue("spec.exempt.nominalConcurrencyShares", 1)
        .hasFieldOrPropertyWithValue("spec.exempt.lendablePercent", 2);
  }
}
