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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;

public class BuildOperationContext {

  private final PodOperationContext podOperationContext;
  private String version;

  public BuildOperationContext() {
    this.podOperationContext = new PodOperationContext();
  }

  public BuildOperationContext(PodOperationContext podOperationContext, String version) {
    this.podOperationContext = podOperationContext;
    this.version = version;
  }

  public PodOperationContext getPodOperationContext() {
    return podOperationContext;
  }

  public String getVersion() {
    return version;
  }

  public boolean isTerminatedStatus() {
    return this.podOperationContext.isTerminatedStatus();
  }

  public boolean isTimestamps() {
    return this.podOperationContext.isTimestamps();
  }

  public String getSinceTimestamp() {
    return this.podOperationContext.getSinceTimestamp();
  }

  public Integer getSinceSeconds() {
    return this.podOperationContext.getSinceSeconds();
  }

  public Integer getTailingLines() {
    return this.podOperationContext.getTailingLines();
  }

  public boolean isPrettyOutput() {
    return this.podOperationContext.isPrettyOutput();
  }

  public Integer getLimitBytes() {
    return this.podOperationContext.getLimitBytes();
  }

  public BuildOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new BuildOperationContext(podOperationContext.withTerminatedStatus(terminatedStatus), version);
  }

  public BuildOperationContext withTimestamps(boolean timestamps) {
    return new BuildOperationContext(podOperationContext.withTimestamps(timestamps), version);
  }

  public BuildOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new BuildOperationContext(podOperationContext.withSinceTimestamp(sinceTimestamp), version);
  }

  public BuildOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new BuildOperationContext(podOperationContext.withSinceSeconds(sinceSeconds), version);
  }

  public BuildOperationContext withTailingLines(Integer tailingLines) {
    return new BuildOperationContext(podOperationContext.withTailingLines(tailingLines), version);
  }

  public BuildOperationContext withPrettyOutput(boolean prettyOutput) {
    return new BuildOperationContext(podOperationContext.withPrettyOutput(prettyOutput), version);
  }

  public BuildOperationContext withLimitBytes(Integer limitBytes) {
    return new BuildOperationContext(podOperationContext.withLimitBytes(limitBytes), version);
  }

}
