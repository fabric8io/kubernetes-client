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

package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderCallbacks;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectionConfigBuilder;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElector;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaseLock;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(Lease.class)
class LeaderIT {

  KubernetesClient client;

  @Test
  void testLeadershipCycle() throws InterruptedException, ExecutionException, TimeoutException {
    final String lockIdentity = UUID.randomUUID().toString();
    CompletableFuture<Void> leading = new CompletableFuture<>();
    CompletableFuture<Void> stopped = new CompletableFuture<>();
    CompletableFuture<String> changed = new CompletableFuture<>();
    LeaderElector leader = client.leaderElector()
        .withConfig(
            new LeaderElectionConfigBuilder()
                .withReleaseOnCancel()
                .withName("Sample Leader Election configuration")
                .withLeaseDuration(Duration.ofSeconds(30L))
                .withLock(new LeaseLock(new ObjectMetaBuilder().withName("sample").withNamespace(client.getNamespace()).build(),
                    lockIdentity))
                .withRenewDeadline(Duration.ofSeconds(10L))
                .withRetryPeriod(Duration.ofSeconds(2L))
                .withLeaderCallbacks(new LeaderCallbacks(
                    () -> leading.complete(null),
                    () -> stopped.complete(null),
                    changed::complete))
                .build())
        .build();
    CompletableFuture<?> f = leader.start();

    leading.get(10, TimeUnit.SECONDS);
    assertTrue(!stopped.isDone());
    f.cancel(true);
    stopped.get(10, TimeUnit.SECONDS);
    assertEquals(lockIdentity, changed.getNow(null));
  }

}
