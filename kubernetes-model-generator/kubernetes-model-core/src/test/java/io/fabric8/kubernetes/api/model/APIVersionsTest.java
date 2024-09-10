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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class APIVersionsTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = Helper.loadJson("/valid-apiversions.json");

    // When
    final APIVersions apiVersions = mapper.readValue(originalJson, APIVersions.class);
    final String serializedJson = mapper.writeValueAsString(apiVersions);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(apiVersions)
        .isNotNull()
        .hasFieldOrPropertyWithValue("versions", Collections.singletonList("v1"))
        .extracting(APIVersions::getServerAddressByClientCIDRs)
        .asInstanceOf(InstanceOfAssertFactories.list(ServerAddressByClientCIDR.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("clientCIDR", "0.0.0.0/0")
        .hasFieldOrPropertyWithValue("serverAddress", "192.168.39.244:8443");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    APIVersionsBuilder apiVersionsBuilder = new APIVersionsBuilder()
        .addToVersions("v1")
        .addNewServerAddressByClientCIDR()
        .withClientCIDR("0.0.0.0/0")
        .withServerAddress("192.168.39.244:8443")
        .endServerAddressByClientCIDR();
    // When
    APIVersions apiVersions = apiVersionsBuilder.build();

    // Then
    assertThat(apiVersions)
        .isNotNull()
        .hasFieldOrPropertyWithValue("versions", Collections.singletonList("v1"))
        .extracting(APIVersions::getServerAddressByClientCIDRs)
        .asInstanceOf(InstanceOfAssertFactories.list(ServerAddressByClientCIDR.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("clientCIDR", "0.0.0.0/0")
        .hasFieldOrPropertyWithValue("serverAddress", "192.168.39.244:8443");
  }
}
