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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class BuildOperationContext {

    private InputStream in;
    private OutputStream out;
    private OutputStream err;

    private PipedOutputStream inPipe;
    private PipedInputStream outPipe;
    private PipedInputStream errPipe;
    private boolean tty;
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

  public BuildOperationContext(InputStream in, OutputStream out, OutputStream err, PipedOutputStream inPipe, PipedInputStream outPipe, PipedInputStream errPipe, Boolean tty, Boolean terminatedStatus, Boolean timestamps, String sinceTimestamp, Integer sinceSeconds, Integer tailingLines, Boolean prettyOutput, Integer limitBytes, String version) {
    this.in = in;
    this.out = out;
    this.err = err;
    this.inPipe = inPipe;
    this.outPipe = outPipe;
    this.errPipe = errPipe;
    this.tty = tty;
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

  public InputStream getIn() {
    return in;
  }

  public OutputStream getOut() {
    return out;
  }

  public OutputStream getErr() {
    return err;
  }


  public PipedOutputStream getInPipe() {
    return inPipe;
  }

  public PipedInputStream getOutPipe() {
    return outPipe;
  }

  public PipedInputStream getErrPipe() {
    return errPipe;
  }


  public boolean isTty() {
    return tty;
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


  public BuildOperationContext withIn(InputStream in) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withOut(OutputStream out) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withErr(OutputStream err) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withInPipe(PipedOutputStream inPipe) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withOutPipe(PipedInputStream outPipe) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withErrPipe(PipedInputStream errPipe) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withTty(boolean tty) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withTimestamps(boolean timestamps) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withTailingLines(Integer tailingLines) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withPrettyOutput(boolean prettyOutput) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

  public BuildOperationContext withLimitBytes(Integer limitBytes) {
    return new BuildOperationContext(in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus,timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version);
  }

}
