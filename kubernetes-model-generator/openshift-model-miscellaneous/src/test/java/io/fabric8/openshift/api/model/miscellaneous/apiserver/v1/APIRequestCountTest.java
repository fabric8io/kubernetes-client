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
package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class APIRequestCountTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-apirequestcount.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final APIRequestCount apiRequestCount = mapper.readValue(originalJson, APIRequestCount.class);
    final String serializedJson = mapper.writeValueAsString(apiRequestCount);
    final APIRequestCount apiRequestCountFromSerializedJson = mapper.readValue(serializedJson, APIRequestCount.class);

    // Then
    assertNotNull(apiRequestCount);
    assertNotNull(serializedJson);
    assertNotNull(apiRequestCountFromSerializedJson);
    assertEquals(apiRequestCount.getMetadata().getName(), apiRequestCountFromSerializedJson.getMetadata().getName());
    assertEquals(apiRequestCount.getSpec().getNumberOfUsersToReport(),
        apiRequestCountFromSerializedJson.getSpec().getNumberOfUsersToReport());
    assertEquals(apiRequestCount.getStatus().getCurrentHour(), apiRequestCountFromSerializedJson.getStatus().getCurrentHour());
    assertEquals(apiRequestCount.getStatus().getLast24h(), apiRequestCountFromSerializedJson.getStatus().getLast24h());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    APIRequestCountBuilder apiRequestCountBuilder = new APIRequestCountBuilder()
        .withNewMetadata().withName("users.v1.user.openshift.io").endMetadata()
        .withNewSpec().withNumberOfUsersToReport(10L).endSpec()
        .withNewStatus()
        .withNewCurrentHour()
        .addNewByNode()
        .addNewByUser()
        .addNewByVerb()
        .withRequestCount(4L)
        .withVerb("get")
        .endByVerb()
        .withRequestCount(4L)
        .withUserAgent("oc/v1.11.0+d4cacc0")
        .withUsername("kubeadmin")
        .endByUser()
        .endByNode()
        .endCurrentHour()
        .addNewLast24h()
        .addNewByNode()
        .withNodeName("192.168.126.11")
        .withRequestCount(0L)
        .endByNode()
        .withRequestCount(0L)
        .endLast24h()
        .endStatus();

    // When
    APIRequestCount apiRequestCount = apiRequestCountBuilder.build();

    // Then
    assertNotNull(apiRequestCount);
    assertEquals("users.v1.user.openshift.io", apiRequestCount.getMetadata().getName());
    assertEquals(10, apiRequestCount.getSpec().getNumberOfUsersToReport());
    assertEquals(1, apiRequestCount.getStatus().getCurrentHour().getByNode().size());
    assertEquals(1, apiRequestCount.getStatus().getLast24h().size());
  }
}
