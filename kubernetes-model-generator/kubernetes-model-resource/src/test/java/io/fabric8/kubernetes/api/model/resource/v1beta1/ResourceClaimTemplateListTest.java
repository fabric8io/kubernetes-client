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
package io.fabric8.kubernetes.api.model.resource.v1beta1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceClaimTemplateListTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Test
  void serializationWorksAsExpected() {
    // Given
    final var resourceClaimTemplateList = new ResourceClaimTemplateListBuilder()
        .addToItems(new ResourceClaimTemplateBuilder()
            .withNewMetadata().withName("resource-claim-template").endMetadata()
            .withNewSpec().withNewSpec().withNewDevices().addNewConfig().withNewOpaque().withDriver("the-driver").endOpaque()
            .endConfig().endDevices().endSpec().endSpec()
            .build())
        .build();
    // When
    final Map<String, Object> serialized = mapper.convertValue(resourceClaimTemplateList, new TypeReference<>() {
    });
    // Then
    assertThat(serialized)
        .extracting("items").asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "resource-claim-template")
        .extracting("spec.spec.devices.config").asInstanceOf(InstanceOfAssertFactories.LIST)
        .extracting("opaque.driver")
        .containsExactly("the-driver");
  }

  @Test
  void deserialization() throws Exception {
    // Given
    final String originalResource = Helper.loadJson("/resource-claim-template-list.json");
    // When
    final var result = mapper.readValue(originalResource, ResourceClaimTemplateList.class);
    // Then
    assertThat(result)
        .extracting(ResourceClaimTemplateList::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(ResourceClaimTemplate.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .extracting("spec.spec.devices.config").asInstanceOf(InstanceOfAssertFactories.LIST)
        .extracting("opaque.driver")
        .containsExactly("driverValue");
  }

}
