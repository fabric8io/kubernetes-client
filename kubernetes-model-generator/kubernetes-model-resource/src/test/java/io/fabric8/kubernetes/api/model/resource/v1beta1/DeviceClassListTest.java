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

class DeviceClassListTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Test
  void serializationWorksAsExpected() {
    // Given
    final var deviceClassList = new DeviceClassListBuilder()
        .addToItems(new DeviceClassBuilder()
            .withNewMetadata().withName("device-class").endMetadata()
            .withNewSpec().addNewConfig().withNewOpaque().withDriver("the-driver").endOpaque().endConfig().endSpec()
            .build())
        .build();
    // When
    final Map<String, Object> serialized = mapper.convertValue(deviceClassList, new TypeReference<>() {
    });
    // Then
    assertThat(serialized)
        .extracting("items").asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "device-class")
        .extracting("spec.config").asInstanceOf(InstanceOfAssertFactories.LIST)
        .extracting("opaque.driver")
        .containsExactly("the-driver");
  }

  @Test
  void deserialization() throws Exception {
    // Given
    final String originalResource = Helper.loadJson("/device-class-list.json");
    // When
    final var result = mapper.readValue(originalResource, DeviceClassList.class);
    // Then
    assertThat(result)
        .extracting(DeviceClassList::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(DeviceClass.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .extracting("spec.config").asInstanceOf(InstanceOfAssertFactories.LIST)
        .extracting("opaque.driver")
        .containsExactly("driverValue");
  }

}
