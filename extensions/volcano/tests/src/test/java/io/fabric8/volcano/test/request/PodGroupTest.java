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
package io.fabric8.volcano.test.request;

import io.fabric8.volcano.client.VolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.volcano.server.mock.EnableVolcanoMockClient;
import io.fabric8.volcano.server.mock.VolcanoMockServer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableVolcanoMockClient
class PodGroupTest {

  VolcanoClient client;
  VolcanoMockServer server;

  @Test
  @DisplayName("Should get a pod group")
  void testGet() {
    server.expect().get().withPath("/apis/scheduling.volcano.sh/v1beta1/namespaces/ns1/podgroups/pg1")
      .andReturn(HttpURLConnection.HTTP_OK, createPodGroup()).once();
    PodGroup podGroup = client.v1beta1().podGroups().inNamespace("ns1").withName("pg1").get();
    assertNotNull(podGroup);
  }

  @Test
  @DisplayName("Should create a pod group")
  void testCreate() {
    PodGroup podGroup = createPodGroup();
    server.expect().post().withPath("/apis/scheduling.volcano.sh/v1beta1/namespaces/ns1/podgroups")
      .andReturn(HttpURLConnection.HTTP_CREATED, podGroup).once();
    podGroup = client.v1beta1().podGroups().inNamespace("ns1").create(createPodGroup());
    assertNotNull(podGroup);
    assertEquals("pg1", podGroup.getMetadata().getName());
  }

  private PodGroup createPodGroup() {
    return new PodGroupBuilder()
      .withNewMetadata().withName("pg1").endMetadata()
      .build();
  }
}
