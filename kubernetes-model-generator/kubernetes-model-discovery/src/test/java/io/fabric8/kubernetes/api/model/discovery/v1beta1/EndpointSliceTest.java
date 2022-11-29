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
package io.fabric8.kubernetes.api.model.discovery.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EndpointSliceTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void loadTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-endpointslice.json");

    // when
    final EndpointSlice endpointSlice = mapper.readValue(originalJson, EndpointSlice.class);
    final String serializedJson = mapper.writeValueAsString(endpointSlice);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  void testBuilder() {
    // Given + When      
    EndpointSlice endpointSlice = new EndpointSliceBuilder()
        .withNewMetadata()
        .withName("example-abc")
        .addToLabels("kubernetes.io/service-name", "example")
        .endMetadata()
        .withAddressType("IPv4")
        .addNewPort()
        .withName("http")
        .withPort(80)
        .endPort()
        .addNewEndpoint()
        .withAddresses("10.1.2.3")
        .withNewConditions().withReady(true).endConditions()
        .withHostname("pod-1")
        .addToTopology("kubernetes.io/hostname", "node-1")
        .addToTopology("topology.kubernetes.io/zone", "us-west2-a")
        .endEndpoint()
        .build();

    // Then
    assertEquals("discovery.k8s.io/v1beta1", endpointSlice.getApiVersion());
    assertEquals("example-abc", endpointSlice.getMetadata().getName());
    assertEquals("example", endpointSlice.getMetadata().getLabels().get("kubernetes.io/service-name"));
    assertEquals("IPv4", endpointSlice.getAddressType());
    assertEquals(1, endpointSlice.getPorts().size());
    assertEquals(1, endpointSlice.getEndpoints().size());
    assertEquals("pod-1", endpointSlice.getEndpoints().get(0).getHostname());
    assertEquals("node-1", endpointSlice.getEndpoints().get(0).getTopology().get("kubernetes.io/hostname"));
    assertEquals("us-west2-a", endpointSlice.getEndpoints().get(0).getTopology().get("topology.kubernetes.io/zone"));
  }
}
