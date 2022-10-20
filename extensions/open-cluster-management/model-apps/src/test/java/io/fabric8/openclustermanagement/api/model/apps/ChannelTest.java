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
package io.fabric8.openclustermanagement.api.model.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.Channel;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ChannelTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-channel.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Channel channel = mapper.readValue(originalJson, Channel.class);
    final String serializedJson = mapper.writeValueAsString(channel);
    final Channel apiRequestCountFromSerializedJson = mapper.readValue(serializedJson, Channel.class);

    // Then
    assertNotNull(channel);
    assertNotNull(serializedJson);
    assertNotNull(apiRequestCountFromSerializedJson);
    assertEquals(channel.getMetadata().getName(), apiRequestCountFromSerializedJson.getMetadata().getName());
    assertEquals("HelmRepo", channel.getSpec().getType());
    assertEquals("https://charts.helm.sh/stable", channel.getSpec().getPathname());
    assertEquals("bookinfo-resource-filter-configmap", channel.getSpec().getConfigMapRef().getName());
    assertEquals("configmap", channel.getSpec().getConfigMapRef().getKind());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ChannelBuilder channelBuilder = new ChannelBuilder()
        .withNewMetadata()
        .addToLabels("vendor", "OpenShift")
        .withName("sample-channel")
        .endMetadata()
        .withNewSpec()
        .withType("HelmRepo")
        .withPathname("https://charts.helm.sh/stable")
        .withNewConfigMapRef()
        .withKind("ConfigMap")
        .withName("test-configmap")
        .endConfigMapRef()
        .endSpec();

    // When
    Channel channel = channelBuilder.build();

    // Then
    assertNotNull(channel);
    assertEquals("sample-channel", channel.getMetadata().getName());
    assertEquals(1, channel.getMetadata().getLabels().size());
    assertEquals("HelmRepo", channel.getSpec().getType());
    assertEquals("https://charts.helm.sh/stable", channel.getSpec().getPathname());
    assertEquals("test-configmap", channel.getSpec().getConfigMapRef().getName());
    assertEquals("ConfigMap", channel.getSpec().getConfigMapRef().getKind());
  }
}
