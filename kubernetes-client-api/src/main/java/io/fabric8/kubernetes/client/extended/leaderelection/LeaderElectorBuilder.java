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
package io.fabric8.kubernetes.client.extended.leaderelection;

import io.fabric8.kubernetes.client.KubernetesClient;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Executor;

import static io.fabric8.kubernetes.client.extended.leaderelection.LeaderElector.JITTER_FACTOR;

public class LeaderElectorBuilder {

  private final KubernetesClient client;
  private final Executor executor;
  private LeaderElectionConfig leaderElectionConfig;

  public LeaderElectorBuilder(KubernetesClient client, Executor executor) {
    this.client = client;
    this.executor = executor;
  }

  public LeaderElectorBuilder withConfig(LeaderElectionConfig leaderElectionConfig) {
    this.leaderElectionConfig = validate(leaderElectionConfig);
    return this;
  }

  public LeaderElector build() {
    return new LeaderElector(client, leaderElectionConfig, executor);
  }

  private static LeaderElectionConfig validate(LeaderElectionConfig leaderElectionConfig) {
    Objects.requireNonNull(leaderElectionConfig, "LeaderElectionConfig is required");
    Objects.requireNonNull(leaderElectionConfig.getName(), "name is required");
    Objects.requireNonNull(leaderElectionConfig.getLeaseDuration(), "leaseDuration is required");
    Objects.requireNonNull(leaderElectionConfig.getRenewDeadline(), "renewDeadLine is required");
    Objects.requireNonNull(leaderElectionConfig.getRetryPeriod(), "retryPeriod is required");
    Objects.requireNonNull(leaderElectionConfig.getLeaderCallbacks(), "leaderCallbacks are required");
    Objects.requireNonNull(leaderElectionConfig.getLock(), "lock is required");
    if (leaderElectionConfig.getLeaseDuration().compareTo(leaderElectionConfig.getRenewDeadline()) <= 0) {
      throw new IllegalArgumentException("leaseDuration must be greater than renewDeadLine");
    }
    final Duration maxRetryPeriod = leaderElectionConfig.getRetryPeriod().plusMillis(
        (long) Math.ceil(leaderElectionConfig.getRetryPeriod().toMillis() * JITTER_FACTOR));
    if (leaderElectionConfig.getRenewDeadline().compareTo(maxRetryPeriod) <= 0) {
      throw new IllegalArgumentException("renewDeadline must be greater than retryPeriod + retryPeriod*JITTER_FACTOR");
    }
    if (leaderElectionConfig.getLeaseDuration().toMillis() < 1L) {
      throw new IllegalArgumentException("leaseDuration must be greater than zero");
    }
    if (leaderElectionConfig.getRenewDeadline().toMillis() < 1L) {
      throw new IllegalArgumentException("renewDeadline must be greater than zero");
    }
    if (leaderElectionConfig.getRetryPeriod().toMillis() < 1L) {
      throw new IllegalArgumentException("retryPeriod must be greater than zero");
    }
    return leaderElectionConfig;
  }
}
