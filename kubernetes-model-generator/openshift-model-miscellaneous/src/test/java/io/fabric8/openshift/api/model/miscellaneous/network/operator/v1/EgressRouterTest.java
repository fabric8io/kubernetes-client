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
package io.fabric8.openshift.api.model.miscellaneous.network.operator.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EgressRouterTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    final String originalJson = new Scanner(getClass().getResourceAsStream("/valid-egressrouter.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final EgressRouter egressRouter = mapper.readValue(originalJson, EgressRouter.class);
    final String serializedJson = mapper.writeValueAsString(egressRouter);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    EgressRouterBuilder egressRouterBuilder = new EgressRouterBuilder()
        .withNewMetadata().withName("test-er").endMetadata()
        .withNewSpec()
        .addNewAddress()
        .withGateway("192.168.3.1")
        .withIp("192.168.3.10/24")
        .endAddress()
        .withMode("Redirect")
        .withNewNetworkInterface()
        .withNewMacvlan()
        .withMode("Bridge")
        .endMacvlan()
        .endNetworkInterface()
        .withNewRedirect()
        .withFallbackIP("203.0.113.25")
        .endRedirect()
        .endSpec();

    // When
    final EgressRouter egressRouter = egressRouterBuilder.build();

    // Then
    assertNotNull(egressRouter);
    assertEquals("test-er", egressRouter.getMetadata().getName());
    assertEquals(1, egressRouter.getSpec().getAddresses().size());
    assertEquals("192.168.3.1", egressRouter.getSpec().getAddresses().get(0).getGateway());
    assertEquals("192.168.3.10/24", egressRouter.getSpec().getAddresses().get(0).getIp());
    assertEquals("Redirect", egressRouter.getSpec().getMode());
    assertEquals("Bridge", egressRouter.getSpec().getNetworkInterface().getMacvlan().getMode());
    assertEquals("203.0.113.25", egressRouter.getSpec().getRedirect().getFallbackIP());
  }
}
