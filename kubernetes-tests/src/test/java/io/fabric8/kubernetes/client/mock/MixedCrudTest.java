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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.server.mock.KubernetesMixedDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MixedCrudTest {

  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeAll
  static void beforeAll() {
  }

  @BeforeEach
  void setUp() {
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    server = new KubernetesMockServer(new Context(Serialization.jsonMapper()),
      new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), false);
    client = server.createClient();
  }

  @AfterEach
  void tearDown() {
    client.close();
    server.destroy();
  }

  @Test
  @DisplayName("client.getKubernetesVersion, with no expectations, should throw Exception")
  void versionWithNoExpectationsShouldFail() {
    // When
    final RuntimeException exception = assertThrows(RuntimeException.class, client::getKubernetesVersion);
    // Then
    assertThat(exception).isNotNull().isInstanceOf(KubernetesClientException.class);
  }

  @Test
  @DisplayName("client.getKubernetesVersion, with expectation for version, should return version")
  void versionWithExpectationsShouldReturnVersion() {
    // Given
    server.expect().get().withPath("/version")
      .andReturn(200, "{\"major\": \"13\", \"minor\": \"37\"}").always();
    // When
    final VersionInfo result = client.getKubernetesVersion();
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("major", "13")
      .hasFieldOrPropertyWithValue("minor", "37");
  }

  @Test
  @DisplayName("CRUD get, with no expectations, should return managed resource")
  void crudGetWithNoExpectations() {
    // Given
    client.pods().inNamespace("ns")
      .create(new PodBuilder().editOrNewMetadata().withName("my-pod").addToAnnotations("my", "pod").endMetadata().build());
    // When
    final Pod result = client.pods().inNamespace("ns").withName("my-pod").get();
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("metadata.annotations.my", "pod")
      .hasFieldOrPropertyWithValue("metadata.generation", 1L);
  }

  @Test
  @DisplayName("CRUD get, with expectations, should return expectation")
  void crudGetWithExpectations() {
    // Given
    client.pods().inNamespace("ns")
      .create(new PodBuilder().editOrNewMetadata().withName("my-pod").addToAnnotations("my", "pod").endMetadata().build());
    server.expect().get().withPath("/api/v1/namespaces/ns/pods/my-pod")
      .andReturn(200, "{\"metadata\": {\"name\": \"override\"}}").always();
    // When
    final Pod result = client.pods().inNamespace("ns").withName("my-pod").get();
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("metadata.name", "override")
      .hasFieldOrPropertyWithValue("metadata.generation", null);
  }
}
