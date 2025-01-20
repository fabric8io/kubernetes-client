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
package io.fabric8.kubernetes.api.model.coordination.v1alpha2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class LeaseCandidateListTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void serializationWorksAsExpected() {
    // Given
    final LeaseCandidateList leaseCandidateList = new LeaseCandidateListBuilder()
        .addToItems(new LeaseCandidateBuilder()
            .withNewMetadata().withName("lease-candidate").endMetadata()
            .withNewSpec().withLeaseName("lease-name").endSpec()
            .build())
        .build();
    // When
    final Map<String, Object> serialized = mapper.convertValue(leaseCandidateList, new TypeReference<>() {
    });
    // Then
    assertThat(serialized)
        .extracting("items").asInstanceOf(InstanceOfAssertFactories.LIST)
        .extracting("metadata.name", "spec.leaseName")
        .containsExactly(tuple("lease-candidate", "lease-name"));
  }

  @Test
  void deserialization() throws Exception {
    // Given
    final String originalResource = Helper.loadJson("/lease-candidate-list.json");
    // When
    final LeaseCandidateList result = mapper.readValue(originalResource, LeaseCandidateList.class);
    // Then
    assertThat(result)
        .extracting(LeaseCandidateList::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(Lease.class))
        .extracting("metadata.name", "spec.leaseName")
        .containsExactly(
            tuple("lease-candidate", "the-lease-name"));
  }

}
