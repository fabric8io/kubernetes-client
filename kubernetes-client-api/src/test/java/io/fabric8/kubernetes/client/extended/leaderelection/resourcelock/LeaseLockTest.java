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
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseSpec;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.ReplaceDeletable;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Answers;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LeaseLockTest {

  private KubernetesClient kc;
  private MixedOperation<Lease, LeaseList, Resource<Lease>> leases;
  private LeaseBuilder leaserBuilder;
  private LeaseBuilder.MetadataNested<LeaseBuilder> metadata;
  private LeaseBuilder.SpecNested<LeaseBuilder> spec;

  @BeforeEach
  void setUp() {
    kc = mock(KubernetesClient.class, RETURNS_DEEP_STUBS);
    leases = mock(MixedOperation.class, RETURNS_DEEP_STUBS);
    leaserBuilder = mock(LeaseBuilder.class, RETURNS_DEEP_STUBS);
    metadata = mock(LeaseBuilder.MetadataNested.class, RETURNS_DEEP_STUBS);
    spec = mock(LeaseBuilder.SpecNested.class, RETURNS_DEEP_STUBS);
    when(kc.leases().inNamespace(anyString())).thenReturn(leases);
    when(leaserBuilder.withNewMetadata()).thenReturn(metadata);
    when(leaserBuilder.withNewSpec()).thenReturn(spec);
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
    when(leases.withName(eq("name")).get()).thenReturn(lease);
    lease.setMetadata(new ObjectMetaBuilder().withResourceVersion("313373").build());
    final LeaseLock lock = new LeaseLock("namespace", "name", "1337");
    // When
    final LeaderElectionRecord result = lock.get(kc);
    // Then
    assertNotNull(result);
    assertEquals("313373", result.getVersion());
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
    verify(leases.withName("name"), times(1)).create(any(Lease.class));
  }

  @Test
  void updateWithValidLeaderElectionRecordShouldSendPutRequest() throws Exception {
    // Given
    final Resource<Lease> leaseResource = leases.withName("name");
    final ReplaceDeletable<Lease> replaceable = mock(ReplaceDeletable.class, Answers.RETURNS_DEEP_STUBS);
    when(leaseResource.lockResourceVersion(any())).thenReturn(replaceable);
    final Lease leaseInTheCluster = new Lease();
    leaseInTheCluster.setSpec(new LeaseSpec());
    when(leaseResource.get()).thenReturn(leaseInTheCluster);
    final LeaderElectionRecord record = new LeaderElectionRecord(
        "1337", Duration.ofSeconds(1), ZonedDateTime.now(), ZonedDateTime.now(), 0);
    record.setVersion("313373");
    final LeaseLock lock = new LeaseLock("namespace", "name", "1337");
    // When
    lock.update(kc, record);
    // Then
    verify(replaceable, times(1)).replace(eq(leaseInTheCluster));
    assertEquals("1337", leaseInTheCluster.getSpec().getHolderIdentity());
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
