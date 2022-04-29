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
import io.fabric8.kubernetes.client.utils.URLUtils.URLBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
  private boolean forUpload;

  public PodOperationContext withContainerId(String containerId) {
    return this.toBuilder().containerId(containerId).build();
  }

  public PodOperationContext withIn(InputStream in) {
    return this.toBuilder().in(in).build();
  }

  public PodOperationContext withOut(OutputStream out) {
    return this.toBuilder().out(out).build();
  }

  public PodOperationContext withErr(OutputStream err) {
    return this.toBuilder().err(err).build();
  }

  public PodOperationContext withErrChannel(OutputStream errChannel) {
    return this.toBuilder().errChannel(errChannel).build();
  }

  public PodOperationContext withInPipe(PipedOutputStream inPipe) {
    return this.toBuilder().inPipe(inPipe).build();
  }

  public PodOperationContext withOutPipe(PipedInputStream outPipe) {
    return this.toBuilder().outPipe(outPipe).build();
  }

  public PodOperationContext withErrPipe(PipedInputStream errPipe) {
    return this.toBuilder().errPipe(errPipe).build();
  }

  public PodOperationContext withErrChannelPipe(PipedInputStream errChannelPipe) {
    return this.toBuilder().errChannelPipe(errChannelPipe).build();
  }

  public PodOperationContext withTty(boolean tty) {
    return this.toBuilder().tty(tty).build();
  }

  public PodOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return this.toBuilder().terminatedStatus(terminatedStatus).build();
  }

  public PodOperationContext withTimestamps(boolean timestamps) {
    return this.toBuilder().timestamps(timestamps).build();
  }

  public PodOperationContext withSinceTimestamp(String sinceTimestamp) {
    return this.toBuilder().sinceTimestamp(sinceTimestamp).build();
  }

  public PodOperationContext withSinceSeconds(Integer sinceSeconds) {
    return this.toBuilder().sinceSeconds(sinceSeconds).build();
  }

  public PodOperationContext withTailingLines(Integer tailingLines) {
    return this.toBuilder().tailingLines(tailingLines).build();
  }

  public PodOperationContext withPrettyOutput(boolean prettyOutput) {
    return this.toBuilder().prettyOutput(prettyOutput).build();
  }

  public PodOperationContext withExecListener(ExecListener execListener) {
    return this.toBuilder().execListener(execListener).build();
  }

  public PodOperationContext withLimitBytes(Integer limitBytes) {
    return this.toBuilder().limitBytes(limitBytes).build();
  }

  public PodOperationContext withBufferSize(Integer bufferSize) {
    return this.toBuilder().bufferSize(bufferSize).build();
  }

  public PodOperationContext withFile(String file) {
    return this.toBuilder().file(file).build();
  }

  public PodOperationContext withDir(String dir) {
    return this.toBuilder().dir(dir).build();
  }

  public PodOperationContext withLogWaitTimeout(Integer logWaitTimeout) {
    return this.toBuilder().logWaitTimeout(logWaitTimeout).build();
  }

  public String getLogParameters() {
    StringBuilder sb = new StringBuilder();
    sb.append("log?pretty=").append(prettyOutput);

    if (containerId != null && !containerId.isEmpty()) {
      sb.append("&container=").append(containerId);
    }
    if (terminatedStatus) {
      sb.append("&previous=true");
    }
    if (sinceSeconds != null) {
      sb.append("&sinceSeconds=").append(sinceSeconds);
    } else if (sinceTimestamp != null) {
      sb.append("&sinceTime=").append(sinceTimestamp);
    }
    if (tailingLines != null) {
      sb.append("&tailLines=").append(tailingLines);
    }
    if (limitBytes != null) {
      sb.append("&limitBytes=").append(limitBytes);
    }
    if (timestamps) {
      sb.append("&timestamps=true");
    }
    return sb.toString();
  }

  public void addQueryParameters(URLBuilder httpUrlBuilder) {
    if (containerId != null && !containerId.isEmpty()) {
      httpUrlBuilder.addQueryParameter("container", containerId);
    }
    if (tty) {
      httpUrlBuilder.addQueryParameter("tty", "true");
    }
    if (in != null || inPipe != null || forUpload) {
      httpUrlBuilder.addQueryParameter("stdin", "true");
    }
    if (out != null || outPipe != null) {
      httpUrlBuilder.addQueryParameter("stdout", "true");
    }
    if (err != null || errPipe != null || forUpload) {
      httpUrlBuilder.addQueryParameter("stderr", "true");
    }
  }

}
