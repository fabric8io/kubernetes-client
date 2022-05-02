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

public class BuildOperationContext {

  private boolean terminatedStatus;
  private boolean timestamps;
  private String sinceTimestamp;
  private Integer sinceSeconds;
  private Integer tailingLines;
  private boolean prettyOutput;
  private Integer limitBytes;
  private String version;

  public BuildOperationContext() {
  }

  public BuildOperationContext(Boolean terminatedStatus, Boolean timestamps, String sinceTimestamp, Integer sinceSeconds,
      Integer tailingLines, Boolean prettyOutput, Integer limitBytes, String version) {
    this.terminatedStatus = terminatedStatus;
    this.timestamps = timestamps;
    this.sinceTimestamp = sinceTimestamp;
    this.sinceSeconds = sinceSeconds;
    this.tailingLines = tailingLines;
    this.prettyOutput = prettyOutput;
    this.limitBytes = limitBytes;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public boolean isTerminatedStatus() {
    return terminatedStatus;
  }

  public boolean isTimestamps() {
    return timestamps;
  }

  public String getSinceTimestamp() {
    return sinceTimestamp;
  }

  public Integer getSinceSeconds() {
    return sinceSeconds;
  }

  public Integer getTailingLines() {
    return tailingLines;
  }

  public boolean isPrettyOutput() {
    return prettyOutput;
  }

  public Integer getLimitBytes() {
    return limitBytes;
  }

  public BuildOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

  public BuildOperationContext withTimestamps(boolean timestamps) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

  public BuildOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

  public BuildOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

  public BuildOperationContext withTailingLines(Integer tailingLines) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

  public BuildOperationContext withPrettyOutput(boolean prettyOutput) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

  public BuildOperationContext withLimitBytes(Integer limitBytes) {
    return new BuildOperationContext(terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput,
        limitBytes, version);
  }

}
