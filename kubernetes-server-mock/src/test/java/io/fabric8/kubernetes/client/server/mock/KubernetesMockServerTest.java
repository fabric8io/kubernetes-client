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

import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesMockServerTest {

  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    server = new KubernetesMockServer();
    server.start();
    client = server.createClient();
  }

  @AfterEach
  void tearDown() {
    client.close();
    server.shutdown();
  }

  @Test
  @DisplayName("onStart, generates version endpoint")
  void onStartVersionInfo() {
    // Then
    assertThat(client.getKubernetesVersion())
      .hasFieldOrPropertyWithValue("major", "0")
      .hasFieldOrPropertyWithValue("minor", "0");
  }

  @Test
  @DisplayName("clearExpectations, removes pre-recorded versionInfo expectation")
  void clearExpectationsRemovesVersionInfo() {
    // When
    server.clearExpectations();
    // Then
    assertThat(client.getKubernetesVersion()).isNull();
  }
}
