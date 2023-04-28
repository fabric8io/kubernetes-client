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
package io.fabric8.kubernetes.client.extended.leaderelection.resourcelock;

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LeaseLockTest {

  private KubernetesClient kc;

  @BeforeEach
  void setUp() {
    kc = mock(KubernetesClient.class, RETURNS_DEEP_STUBS);
  }

  @Test
  void missingNamespaceShouldThrowException() {
    // Given
    final Executable newInstance = () -> new LeaseLock(null, "name", "1337");
    // When - Then
    assertThrows(NullPointerException.class, newInstance);
  }

  @Test
  void missingNameShouldThrowException() {
    // Given
    final Executable newInstance = () -> new LeaseLock("namespace", null, "1337");
    // When - Then
    assertThrows(NullPointerException.class, newInstance);
  }

  @Test
  void missingIdentityShouldThrowException() {
    // Given
    final Executable newInstance = () -> new LeaseLock("namespace", "name", null);
    // When - Then
    assertThrows(NullPointerException.class, newInstance);
  }

  @Test
  void getWithExistingLeaseShouldReturnLeaderElectionRecord() {
    // Given
    final Lease lease = new LeaseBuilder().withNewSpec()
        .withHolderIdentity("1337")
        .withLeaseDurationSeconds(15)
        .withAcquireTime(ZonedDateTime.of(2015, 10, 21, 4, 29, 0, 0, ZoneId.of("UTC")))
        .withRenewTime(ZonedDateTime.of(2015, 10, 21, 7, 28, 0, 0, ZoneId.of("UTC")))
        .withLeaseTransitions(0)
        .endSpec().build();
    lease.setMetadata(new ObjectMetaBuilder().withResourceVersion("313373").build());
    final LeaseLock lock = new LeaseLock("namespace", "name", "1337");
    // When
    final LeaderElectionRecord result = lock.toRecord(lease);
    // Then
    assertNotNull(result);
    assertEquals("1337", result.getHolderIdentity());
    assertEquals(15, result.getLeaseDuration().getSeconds());
    assertEquals(ZonedDateTime.of(2015, 10, 21, 4, 29, 0, 0, ZoneId.of("UTC")), result.getAcquireTime());
  }

  @Test
  void createWithValidLeaderElectionRecordShouldSendPostRequest() throws Exception {
    // Given
    final LeaderElectionRecord record = new LeaderElectionRecord(
        "1", Duration.ofSeconds(1), ZonedDateTime.now(), ZonedDateTime.now(), 0);
    final LeaseLock lock = new LeaseLock("namespace", "name", "1337");
    // When
    lock.create(kc, record);
    // Then
    verify(kc.resource(any(Lease.class))).create();
  }

  @Test
  void updateWithValidLeaderElectionRecordShouldSendPatchRequest() throws Exception {
    // Given
    final LeaderElectionRecord record = new LeaderElectionRecord(
        "1337", Duration.ofSeconds(1), ZonedDateTime.now(), ZonedDateTime.now(), 0);
    final LeaseLock lock = new LeaseLock("namespace", "name", "1337");
    Lease lease = lock.toResource(record, lock.getObjectMeta("313373"));
    lock.setResource(lease);
    // When
    lock.update(kc, record.toBuilder().leaseDuration(Duration.ofSeconds(2)).build());
    // Then
    verify(kc.resource(Mockito.any(Lease.class))).patch(any(PatchContext.class));
  }

  @Test
  void identityShouldReturnProvidedIdentity() {
    // Given
    final LeaseLock leaseLock = new LeaseLock("namespace", "name", "1337");
    // When
    final String identity = leaseLock.identity();
    // Then
    assertEquals("1337", identity);
  }

  @Test
  void describeShouldReturnAnIdentifiableDescription() {
    // Given
    final LeaseLock leaseLock = new LeaseLock("namespace", "name", "1337");
    // When
    final String description = leaseLock.describe();
    // Then
    assertEquals("LeaseLock: namespace - name (1337)", description);
  }
}
