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

import io.fabric8.kubernetes.client.dsl.ExecListener;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PodOperationContext {

    private String containerId;
    private InputStream in;
    private OutputStream out;
    private OutputStream err;
    private OutputStream errChannel;

    private PipedOutputStream inPipe;
    private PipedInputStream outPipe;
    private PipedInputStream errPipe;
    private PipedInputStream errChannelPipe;
    private boolean tty;
    private boolean terminatedStatus;
    private boolean timestamps;
    private String sinceTimestamp;
    private Integer sinceSeconds;
    private Integer tailingLines;
    private Integer logWaitTimeout;
    private boolean prettyOutput;
    private ExecListener execListener;
    private Integer limitBytes;
    private Integer bufferSize;
    private String file;
    private String dir;

  public PodOperationContext() {
  }

  public PodOperationContext(String containerId, InputStream in, OutputStream out, OutputStream err, OutputStream errChannel, PipedOutputStream inPipe, PipedInputStream outPipe, PipedInputStream errPipe, PipedInputStream errChannelPipe, Boolean tty, Boolean terminatedStatus, Boolean timestampes, String sinceTimestamp, Integer sinceSeconds, Integer tailingLines, Boolean prettyOutput, Integer limitBytes, Integer bufferSize, ExecListener execListener, String file, String dir, Integer logWaitTimeout) {
    this.containerId = containerId;
    this.in = in;
    this.out = out;
    this.err = err;
    this.errChannel = errChannel;
    this.inPipe = inPipe;
    this.outPipe = outPipe;
    this.errPipe = errPipe;
    this.errChannelPipe = errChannelPipe;
    this.tty = tty;
    this.terminatedStatus = terminatedStatus;
    this.timestamps = timestampes;
    this.sinceTimestamp = sinceTimestamp;
    this.sinceSeconds = sinceSeconds;
    this.tailingLines = tailingLines;
    this.prettyOutput = prettyOutput;
    this.execListener = execListener;
    this.limitBytes = limitBytes;
    this.bufferSize = bufferSize;
    this.file = file;
    this.dir = dir;
    this.logWaitTimeout = logWaitTimeout;
  }

  public String getContainerId() {
    return containerId;
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

  public OutputStream getErrChannel() {
    return errChannel;
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

  public PipedInputStream getErrChannelPipe() {
    return errChannelPipe;
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

  public ExecListener getExecListener() {
    return execListener;
  }

  public Integer getLimitBytes() {
    return limitBytes;
  }

  public Integer getBufferSize() {
    return bufferSize;
  }

  public String getFile() {
    return file;
  }

  public String getDir() {
    return dir;
  }

  public Integer getLogWaitTimeout() {
    return logWaitTimeout;
  }

  public PodOperationContext withContainerId(String containerId) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withIn(InputStream in) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withOut(OutputStream out) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErr(OutputStream err) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErrChannel(OutputStream errChannel) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withInPipe(PipedOutputStream inPipe) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withOutPipe(PipedInputStream outPipe) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErrPipe(PipedInputStream errPipe) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErrChannelPipe(PipedInputStream errChannelPipe) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTty(boolean tty) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTimestamps(boolean timestamps) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTailingLines(Integer tailingLines) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withPrettyOutput(boolean prettyOutput) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withExecListener(ExecListener execListener) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLimitBytes(Integer limitBytes) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withBufferSize(Integer bufferSize) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withFile(String file) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withDir(String dir) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLogWaitTimeout(Integer logWaitTimeout) {
    return new PodOperationContext(containerId, in, out, err, errChannel, inPipe, outPipe, errPipe,errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

}
