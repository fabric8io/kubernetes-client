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
package io.fabric8.kubernetes.client.dsl.internal;

import java.util.concurrent.TimeUnit;

public class RollingOperationContext {

  private final PodOperationContext podOperationContext;
  private boolean rolling;
  private long rollingTimeout;
  private TimeUnit rollingTimeUnit;

  public RollingOperationContext() {
    this.podOperationContext = new PodOperationContext();
  }

  public RollingOperationContext(PodOperationContext podOperationContext, boolean rolling, long rollingTimeout,
      TimeUnit rollingTimeUnit) {
    this.podOperationContext = podOperationContext;
    this.rolling = rolling;
    this.rollingTimeout = rollingTimeout;
    this.rollingTimeUnit = rollingTimeUnit != null ? rollingTimeUnit : TimeUnit.MILLISECONDS;
  }

  public PodOperationContext getPodOperationContext() {
    return podOperationContext;
  }

  public Boolean getRolling() {
    return rolling;
  }

  public long getRollingTimeout() {
    return rollingTimeout;
  }

  public TimeUnit getRollingTimeUnit() {
    return rollingTimeUnit;
  }

  public RollingOperationContext withRolling(boolean rolling) {
    return new RollingOperationContext(podOperationContext, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withRollingTimeout(long rollingTimeout) {
    return new RollingOperationContext(podOperationContext, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withRollingTimeUnit(TimeUnit rollingTimeUnit) {
    return new RollingOperationContext(podOperationContext, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withContainerId(String containerId) {
    return new RollingOperationContext(podOperationContext.withContainerId(containerId), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withLogWaitTimeout(Integer logWaitTimeout) {
    return new RollingOperationContext(podOperationContext.withLogWaitTimeout(logWaitTimeout), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withLimitBytes(Integer limitBytes) {
    return new RollingOperationContext(podOperationContext.withLimitBytes(limitBytes), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new RollingOperationContext(podOperationContext.withTerminatedStatus(terminatedStatus), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withPrettyOutput(boolean prettyOutput) {
    return new RollingOperationContext(podOperationContext.withPrettyOutput(prettyOutput), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withTailingLines(Integer tailingLines) {
    return new RollingOperationContext(podOperationContext.withTailingLines(tailingLines), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new RollingOperationContext(podOperationContext.withSinceTimestamp(sinceTimestamp), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new RollingOperationContext(podOperationContext.withSinceSeconds(sinceSeconds), rolling, rollingTimeout,
        rollingTimeUnit);
  }

  public RollingOperationContext withTimestamps(boolean timestamps) {
    return new RollingOperationContext(podOperationContext.withTimestamps(timestamps), rolling, rollingTimeout,
        rollingTimeUnit);
  }

}
