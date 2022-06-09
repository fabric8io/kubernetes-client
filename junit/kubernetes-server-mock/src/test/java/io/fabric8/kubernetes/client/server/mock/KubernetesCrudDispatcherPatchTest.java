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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesCrudDispatcherPatchTest {

  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    server = new KubernetesMockServer(new Context(Serialization.jsonMapper()),
        new MockWebServer(), new HashMap<>(), new KubernetesCrudDispatcher(), false);
    server.start();
    client = server.createClient();
  }

  @AfterEach
  void tearDown() {
    client.close();
    server.shutdown();
  }

  @Test
  @DisplayName("editStatus, updates status values ignoring other fields and leaving generation unchanged")
  void editStatusUpdatesOnlyStatusWithNoGenerationIncrement() {
    // Given
    final Pod created = client.resources(Pod.class)
        .resource(new PodBuilder()
            .withNewSpec().withDnsPolicy("always-dns").endSpec()
            .withNewMetadata().withName("foo").addToLabels("app", "bar").endMetadata()
            .build())
        .create();
    // When
    final Pod patched = client.resources(Pod.class).withName("foo").editStatus(p -> new PodBuilder(p)
        .editOrNewSpec().withDnsPolicy("come-on").endSpec()
        .withNewStatus().withMessage("changed").endStatus()
        .build());
    // Then
    assertThat(patched)
        .returns(created.getMetadata().getGeneration(), p -> p.getMetadata().getGeneration())
        .hasFieldOrPropertyWithValue("spec.dnsPolicy", "always-dns");
  }
}
