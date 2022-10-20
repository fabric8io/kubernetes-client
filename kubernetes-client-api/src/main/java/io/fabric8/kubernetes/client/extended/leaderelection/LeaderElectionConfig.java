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

import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import io.sundr.builder.annotations.Buildable;

import java.time.Duration;

@Buildable(editableEnabled = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class LeaderElectionConfig {

  private final Lock lock;
  private final Duration leaseDuration;
  private final Duration renewDeadline;
  private final Duration retryPeriod;
  private final LeaderCallbacks leaderCallbacks;
  private final boolean releaseOnCancel;
  private final String name;

  public LeaderElectionConfig(Lock lock, Duration leaseDuration, Duration renewDeadline, Duration retryPeriod,
      LeaderCallbacks leaderCallbacks, boolean releaseOnCancel, String name) {
    this.lock = lock;
    this.leaseDuration = leaseDuration;
    this.renewDeadline = renewDeadline;
    this.retryPeriod = retryPeriod;
    this.leaderCallbacks = leaderCallbacks;
    this.releaseOnCancel = releaseOnCancel;
    this.name = name;
  }

  public Lock getLock() {
    return lock;
  }

  public Duration getLeaseDuration() {
    return leaseDuration;
  }

  public Duration getRenewDeadline() {
    return renewDeadline;
  }

  public Duration getRetryPeriod() {
    return retryPeriod;
  }

  public LeaderCallbacks getLeaderCallbacks() {
    return leaderCallbacks;
  }

  public boolean isReleaseOnCancel() {
    return releaseOnCancel;
  }

  public String getName() {
    return name;
  }

}
