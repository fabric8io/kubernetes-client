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

import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

public class LeaseLock implements Lock {

  private final String leaseNamespace;
  private final String leaseName;
  private final String identity;

  public LeaseLock(String leaseNamespace, String leaseName, String identity) {
    this.leaseNamespace = Objects.requireNonNull(leaseNamespace, "leaseNamespace is required");
    this.leaseName = Objects.requireNonNull(leaseName, "leaseName is required");
    this.identity = Objects.requireNonNull(identity, "identity is required");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LeaderElectionRecord get(KubernetesClient client) {
    final Lease lease = client.leases().inNamespace(leaseNamespace).withName(leaseName).get();
    return Optional.ofNullable(lease)
        .map(Lease::getSpec)
        .map(spec -> {
          final LeaderElectionRecord ret = new LeaderElectionRecord(
              spec.getHolderIdentity(),
              Duration.ofSeconds(spec.getLeaseDurationSeconds()),
              spec.getAcquireTime(),
              spec.getRenewTime(),
              Optional.ofNullable(spec.getLeaseTransitions()).orElse(0));
          ret.setVersion(lease.getMetadata().getResourceVersion());
          return ret;
        })
        .orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create(
      KubernetesClient client, LeaderElectionRecord leaderElectionRecord) throws LockException {

    try {
      client.leases().inNamespace(leaseNamespace).withName(leaseName).create(new LeaseBuilder()
          .withNewMetadata().withNamespace(leaseNamespace).withName(leaseName).endMetadata()
          .withNewSpec()
          .withHolderIdentity(leaderElectionRecord.getHolderIdentity())
          .withLeaseDurationSeconds((int) leaderElectionRecord.getLeaseDuration().get(ChronoUnit.SECONDS))
          .withAcquireTime(leaderElectionRecord.getAcquireTime())
          .withRenewTime(leaderElectionRecord.getRenewTime())
          .withLeaseTransitions(leaderElectionRecord.getLeaderTransitions())
          .endSpec()
          .build());
    } catch (Exception e) {
      throw new LockException("Unable to create LeaseLock", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update(
      KubernetesClient client, LeaderElectionRecord leaderElectionRecord) throws LockException {

    try {
      final Lease toReplace = client.leases().inNamespace(leaseNamespace).withName(leaseName).get();
      toReplace.getSpec().setHolderIdentity(leaderElectionRecord.getHolderIdentity());
      toReplace.getSpec().setLeaseDurationSeconds((int) leaderElectionRecord.getLeaseDuration().get(ChronoUnit.SECONDS));
      toReplace.getSpec().setAcquireTime(leaderElectionRecord.getAcquireTime());
      toReplace.getSpec().setRenewTime(leaderElectionRecord.getRenewTime());
      toReplace.getSpec().setLeaseTransitions(leaderElectionRecord.getLeaderTransitions());
      // Use replace instead of edit to avoid concurrent modifications, resourceVersion is locked to original record version
      client.leases().inNamespace(leaseNamespace).withName(leaseName)
          .lockResourceVersion((String) Objects.requireNonNull(leaderElectionRecord.getVersion()))
          .replace(toReplace);
    } catch (Exception e) {
      throw new LockException("Unable to update LeaseLock", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String identity() {
    return identity;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String describe() {
    return String.format("LeaseLock: %s - %s (%s)", leaseNamespace, leaseName, identity);
  }
}
