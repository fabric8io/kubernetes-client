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

import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderCallbacks;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectionConfigBuilder;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.ConfigMapLock;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaseLock;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class LeaderElectionTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void singleLeaderConfigMapLockCreateTest() throws Exception {
    // Given
    server.expect()
        .post()
        .withPath("/api/v1/namespaces/namespace/configmaps")
        .andReturn(200, null)
        .once();
    // When - Then
    testAndAssertSingleLeader(client, "lead-config-map",
        new ConfigMapLock("namespace", "name", "lead-config-map"));
  }

  @Test
  void singleLeaderConfigMapLockUpdateTest() throws Exception {
    // Given
    server.expect()
        .get()
        .withPath("/api/v1/namespaces/namespace/configmaps/name")
        .andReturn(200, new ConfigMapBuilder()
            .withNewMetadata()
            .withName("name")
            .withResourceVersion("1")
            .withAnnotations(Collections.singletonMap(
                "control-plane.alpha.kubernetes.io/leader",
                "{\"holderIdentity\": \"not-lead-config-map\", \"leaseDuration\": 100, \"acquireTime\": 0, \"renewTime\": 0}"))
            .endMetadata()
            .build())
        .always();
    server.expect()
        .patch()
        .withPath("/api/v1/namespaces/namespace/configmaps/name")
        .andReturn(200, null)
        .once();
    // When - Then
    testAndAssertSingleLeader(client, "lead-config-map",
        new ConfigMapLock("namespace", "name", "lead-config-map"));
  }

  @Test
  void singleLeaderLeaseLockCreateTest() throws Exception {
    // Given
    server.expect()
        .post()
        .withPath("/apis/coordination.k8s.io/v1/namespaces/namespace/leases")
        .andReturn(200, null)
        .once();
    // When - Then
    testAndAssertSingleLeader(client, "lead-lease",
        new LeaseLock("namespace", "name", "lead-lease"));
  }

  @Test
  void singleLeaderLeaseLockUpdateTest() throws Exception {
    // Given
    server.expect()
        .get()
        .withPath("/apis/coordination.k8s.io/v1/namespaces/namespace/leases/name")
        .andReturn(200, new LeaseBuilder()
            .withNewMetadata()
            .withResourceVersion("1")
            .endMetadata()
            .withNewSpec()
            .withHolderIdentity("not-lead-lease")
            .withLeaseDurationSeconds(1)
            .withAcquireTime(ZonedDateTime.now().minus(1, ChronoUnit.YEARS))
            .withRenewTime(ZonedDateTime.now().minus(1, ChronoUnit.YEARS))
            .withLeaseTransitions(0)
            .endSpec()
            .build())
        .always();
    server.expect()
        .patch()
        .withPath("/apis/coordination.k8s.io/v1/namespaces/namespace/leases/name")
        .andReturn(200, null)
        .once();
    // When - Then
    testAndAssertSingleLeader(client, "lead-lease",
        new LeaseLock("namespace", "name", "lead-lease"));
  }

  static void testAndAssertSingleLeader(KubernetesClient client, String id, Lock lock) throws Exception {
    // Given
    final CountDownLatch leaderLatch = new CountDownLatch(1);
    final AtomicReference<String> newLeaderRecord = new AtomicReference<>();
    final CountDownLatch stoppedLeading = new CountDownLatch(1);
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    // When
    final Future<?> leaderElectorTask = executorService.submit(() -> assertThrows(InterruptedException.class,
        () -> client.leaderElector()
            .withConfig(new LeaderElectionConfigBuilder()
                .withName("Integration test leader election configuration")
                .withLeaseDuration(Duration.ofSeconds(15L))
                .withLock(lock)
                .withRenewDeadline(Duration.ofSeconds(10L))
                .withRetryPeriod(Duration.ofSeconds(2L))
                .withLeaderCallbacks(new LeaderCallbacks(
                    leaderLatch::countDown,
                    stoppedLeading::countDown,
                    newLeaderRecord::set))
                .build())
            .build()
            .run()));
    // Then
    assertTrue(leaderLatch.await(10, TimeUnit.SECONDS));
    assertEquals(id, newLeaderRecord.get());
    assertEquals(0, leaderLatch.getCount());
    leaderElectorTask.cancel(true);
    executorService.shutdownNow();
    assertTrue(executorService.awaitTermination(10, TimeUnit.SECONDS));
    assertTrue(stoppedLeading.await(10, TimeUnit.SECONDS));
  }
}
