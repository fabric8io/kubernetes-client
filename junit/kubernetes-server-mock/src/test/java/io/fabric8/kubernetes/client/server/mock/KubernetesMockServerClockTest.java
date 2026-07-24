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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class KubernetesMockServerClockTest {

  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    server = new KubernetesMockServer(new Context(),
        new MockWebServer(), new HashMap<>(),
        new KubernetesMixedDispatcher(new HashMap<>()), false);
    server.start();
    client = server.createClient();
  }

  @AfterEach
  void tearDown() {
    client.close();
    server.shutdown();
  }

  @Test
  @DisplayName("setClock with fixed clock controls creationTimestamp on resource creation")
  void fixedClockControlsCreationTimestamp() {
    server.setClock(Clock.fixed(Instant.parse("2024-01-15T10:30:00Z"), ZoneOffset.UTC));

    ConfigMap cm = client.configMaps().inNamespace("default").create(
        new ConfigMapBuilder().withNewMetadata().withName("test-cm").endMetadata().build());

    assertThat(cm.getMetadata().getCreationTimestamp()).isEqualTo("2024-01-15T10:30:00Z");
  }

  @Test
  @DisplayName("setClock with fixed clock controls deletionTimestamp when resource has finalizers")
  void fixedClockControlsDeletionTimestamp() {
    server.setClock(Clock.fixed(Instant.parse("2024-06-20T14:00:00Z"), ZoneOffset.UTC));

    client.pods().inNamespace("default").create(
        new PodBuilder().withNewMetadata().withName("test-pod").withFinalizers("test/finalizer").endMetadata().build());

    client.pods().inNamespace("default").withName("test-pod").delete();

    Pod deleted = client.pods().inNamespace("default").withName("test-pod").get();
    assertThat(deleted.getMetadata().getDeletionTimestamp()).isEqualTo("2024-06-20T14:00:00Z");
  }

  @Test
  @DisplayName("setClock throws IllegalStateException when dispatcher is not CRUD-enabled")
  void setClockOnNonCrudServerThrows() {
    KubernetesMockServer nonCrudServer = new KubernetesMockServer(false);
    nonCrudServer.start();
    try {
      assertThatIllegalStateException()
          .isThrownBy(() -> nonCrudServer.setClock(Clock.systemUTC()))
          .withMessageContaining("CRUD dispatcher");
    } finally {
      nonCrudServer.shutdown();
    }
  }

  @Test
  @DisplayName("setClock with null throws NullPointerException")
  void setClockNullThrows() {
    assertThatNullPointerException()
        .isThrownBy(() -> server.setClock(null));
  }

  @Test
  @DisplayName("clock can be changed between operations to simulate time progression")
  void clockCanBeChangedMidTest() {
    server.setClock(Clock.fixed(Instant.parse("2024-01-01T00:00:00Z"), ZoneOffset.UTC));
    ConfigMap first = client.configMaps().inNamespace("default").create(
        new ConfigMapBuilder().withNewMetadata().withName("first").endMetadata().build());

    server.setClock(Clock.fixed(Instant.parse("2024-06-01T12:00:00Z"), ZoneOffset.UTC));
    ConfigMap second = client.configMaps().inNamespace("default").create(
        new ConfigMapBuilder().withNewMetadata().withName("second").endMetadata().build());

    assertThat(first.getMetadata().getCreationTimestamp()).isEqualTo("2024-01-01T00:00:00Z");
    assertThat(second.getMetadata().getCreationTimestamp()).isEqualTo("2024-06-01T12:00:00Z");
  }

  @Test
  @DisplayName("multiple resources created with same fixed clock get identical timestamps")
  void multipleResourcesSameTimestamp() {
    server.setClock(Clock.fixed(Instant.parse("2024-03-10T08:15:00Z"), ZoneOffset.UTC));

    ConfigMap cm = client.configMaps().inNamespace("default").create(
        new ConfigMapBuilder().withNewMetadata().withName("cm1").endMetadata().build());
    Secret secret = client.secrets().inNamespace("default").create(
        new SecretBuilder().withNewMetadata().withName("s1").endMetadata().build());

    assertThat(cm.getMetadata().getCreationTimestamp())
        .isEqualTo(secret.getMetadata().getCreationTimestamp())
        .isEqualTo("2024-03-10T08:15:00Z");
  }

  @Test
  @DisplayName("without setClock, creationTimestamp is still set (uses system clock)")
  void defaultClockStillSetsTimestamp() {
    ConfigMap cm = client.configMaps().inNamespace("default").create(
        new ConfigMapBuilder().withNewMetadata().withName("default-clock").endMetadata().build());

    assertThat(cm.getMetadata().getCreationTimestamp())
        .isNotNull()
        .matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z");
  }

  @Test
  @DisplayName("fixed clock applies to both creationTimestamp and deletionTimestamp consistently")
  void sameClockForCreateAndDelete() {
    server.setClock(Clock.fixed(Instant.parse("2024-09-01T06:00:00Z"), ZoneOffset.UTC));

    Pod pod = client.pods().inNamespace("default").create(
        new PodBuilder().withNewMetadata().withName("consistent-pod").withFinalizers("keep/alive").endMetadata().build());

    assertThat(pod.getMetadata().getCreationTimestamp()).isEqualTo("2024-09-01T06:00:00Z");

    client.pods().inNamespace("default").withName("consistent-pod").delete();

    Pod deleted = client.pods().inNamespace("default").withName("consistent-pod").get();
    assertThat(deleted.getMetadata().getDeletionTimestamp()).isEqualTo("2024-09-01T06:00:00Z");
  }
}
