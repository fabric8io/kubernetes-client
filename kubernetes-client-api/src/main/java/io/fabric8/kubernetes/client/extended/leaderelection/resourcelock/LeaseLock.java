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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseBuilder;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class LeaseLock extends ResourceLock<Lease> {

  public LeaseLock(String leaseNamespace, String leaseName, String identity) {
    super(leaseNamespace, leaseName, identity);
  }

  public LeaseLock(ObjectMeta meta, String identity) {
    super(meta, identity);
  }

  @Override
  protected Class<Lease> getKind() {
    return Lease.class;
  }

  @Override
  protected Lease toResource(LeaderElectionRecord leaderElectionRecord, ObjectMetaBuilder meta) {
    return new LeaseBuilder().withMetadata(meta.build())
        .withNewSpec()
        .withHolderIdentity(leaderElectionRecord.getHolderIdentity())
        .withLeaseDurationSeconds((int) leaderElectionRecord.getLeaseDuration().get(ChronoUnit.SECONDS))
        .withAcquireTime(leaderElectionRecord.getAcquireTime())
        .withRenewTime(leaderElectionRecord.getRenewTime())
        .withLeaseTransitions(leaderElectionRecord.getLeaderTransitions())
        .endSpec()
        .build();
  }

  @Override
  protected LeaderElectionRecord toRecord(Lease resource) {
    return Optional.ofNullable(resource.getSpec()).map(spec -> new LeaderElectionRecord(
        spec.getHolderIdentity(),
        Duration.ofSeconds(spec.getLeaseDurationSeconds()),
        spec.getAcquireTime(),
        spec.getRenewTime(),
        Optional.ofNullable(spec.getLeaseTransitions()).orElse(0))).orElse(null);
  }

}
