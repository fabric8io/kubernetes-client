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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * LeaderElectionRecord is the record that is stored in the leader election annotation.
 * This information should be used for observational purposes only and could be replaced
 * with a random string (e.g. UUID) with only slight modification of this code.
 *
 * @see <a href=
 *      "https://github.com/kubernetes/client-go/blob/1aa326d7304eba6aedc8c89daad615cc7499d1f7/tools/leaderelection/resourcelock/interface.go">leaderelection/resourcelock/interface.go</a>
 */
@Builder(toBuilder = true)
public class LeaderElectionRecord {

  private final String holderIdentity;
  private final Duration leaseDuration;
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
  private final ZonedDateTime acquireTime;
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
  private final ZonedDateTime renewTime;
  private final int leaderTransitions;

  @JsonCreator
  public LeaderElectionRecord(
      @JsonProperty("holderIdentity") String holderIdentity, @JsonProperty("leaseDuration") Duration leaseDuration,
      @JsonProperty("acquireTime") ZonedDateTime acquireTime, @JsonProperty("renewTime") ZonedDateTime renewTime,
      @JsonProperty("leaderTransitions") int leaderTransitions) {

    this.holderIdentity = holderIdentity;
    this.leaseDuration = Objects.requireNonNull(leaseDuration, "leaseDuration is required");
    this.acquireTime = Objects.requireNonNull(acquireTime, "acquireTime is required");
    this.renewTime = Objects.requireNonNull(renewTime, "renewTime is required");
    this.leaderTransitions = leaderTransitions;
  }

  public String getHolderIdentity() {
    return holderIdentity;
  }

  public Duration getLeaseDuration() {
    return leaseDuration;
  }

  public ZonedDateTime getAcquireTime() {
    return acquireTime;
  }

  public ZonedDateTime getRenewTime() {
    return renewTime;
  }

  public int getLeaderTransitions() {
    return leaderTransitions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    LeaderElectionRecord that = (LeaderElectionRecord) o;
    return leaderTransitions == that.leaderTransitions &&
        Objects.equals(holderIdentity, that.holderIdentity) &&
        Objects.equals(leaseDuration, that.leaseDuration) &&
        Objects.equals(acquireTime, that.acquireTime) &&
        Objects.equals(renewTime, that.renewTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(holderIdentity, leaseDuration, acquireTime, renewTime, leaderTransitions);
  }

}
