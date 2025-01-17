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
package io.fabric8.kubernetes.api.model.coordination.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class LeaseListTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void serializationWorksAsExpected() {
    // Given
    final LeaseList leaseList = new LeaseListBuilder()
        .addToItems(new LeaseBuilder()
            .withNewMetadata().withName("lease").endMetadata()
            .withNewSpec().withHolderIdentity("holder-identity").endSpec()
            .build())
        .build();
    // When
    final Map<String, Object> serialized = mapper.convertValue(leaseList, new TypeReference<>() {
    });
    // Then
    assertThat(serialized)
        .extracting("items").asInstanceOf(InstanceOfAssertFactories.LIST)
        .extracting("metadata.name", "spec.holderIdentity")
        .containsExactly(tuple("lease", "holder-identity"));
  }

  @Test
  void deserialization() throws Exception {
    // Given
    final String originalResource = Helper.loadJson("/lease-list.json");
    // When
    final LeaseList leaseList = mapper.readValue(originalResource, LeaseList.class);
    // Then
    assertThat(leaseList)
        .extracting(LeaseList::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(Lease.class))
        .extracting("metadata.name", "spec.acquireTime")
        .containsExactly(
            tuple("nameValue", ZonedDateTime.of(2003, 1, 1, 1, 1, 1, 0, ZoneId.of("Z"))));
  }
}
