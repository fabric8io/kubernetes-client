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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.VersionInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesMockServerTest {

  KubernetesMockServer server;
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
  @DisplayName("versionInfo can be modified after start")
  void versionInfoModified() {
    // When
    server.setVersionInfo(new VersionInfo.Builder().withMajor("1").withMinor("337").build());
    // Then
    assertThat(client.getKubernetesVersion())
        .hasFieldOrPropertyWithValue("major", "1")
        .hasFieldOrPropertyWithValue("minor", "337");
  }

  @Test
  @DisplayName("clearExpectations, removes pre-recorded versionInfo expectation")
  void clearExpectationsRemovesVersionInfo() {
    // When
    server.clearExpectations();
    // Then
    assertThat(client.getKubernetesVersion()).isNull();
  }

  @Test
  @DisplayName("reset, removes expectation")
  void resetRemovesExpectation() {
    // Given
    server.expect().get().withPath("/test").andReturn(200, "OK").always();
    assertThat(client.raw("/test")).isEqualTo("OK");
    // When
    server.reset();
    // Then
    assertThat(client.raw("/test")).isNull();
  }

  @Test
  @DisplayName("reset, sets request count to 0")
  void resetSetsRequestCountToZero() {
    // Given
    server.expect().get().withPath("/test").andReturn(200, "OK").always();
    client.raw("/test");
    assertThat(server.getRequestCount()).isEqualTo(1);
    // When
    server.reset();
    // Then
    assertThat(server.getRequestCount()).isEqualTo(0);
  }

  @Test
  @DisplayName("reset, resets last request")
  void resetResetsLastRequest() throws Exception {
    // Given
    server.expect().get().withPath("/test").andReturn(200, "OK").always();
    client.raw("/test");
    assertThat(server.getLastRequest()).isNotNull();
    // When
    server.reset();
    // Then
    assertThat(server.getLastRequest()).isNull();
  }
}
