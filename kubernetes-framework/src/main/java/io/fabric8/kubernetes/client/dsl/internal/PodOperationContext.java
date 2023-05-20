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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.utils.URLUtils.URLBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.io.OutputStream;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PodOperationContext {

  @Getter
  public static final class StreamContext {
    private OutputStream outputStream;

    public StreamContext(OutputStream outputStream) {
      this.outputStream = outputStream;
    }

    public StreamContext() {
    }
  }

  private String containerId;

  private StreamContext output;
  private StreamContext error;
  private StreamContext errorChannel;

  private boolean redirectingIn;
  private InputStream in;

  private boolean tty;
  private boolean terminatedStatus;
  private boolean timestamps;
  private String sinceTimestamp;
  private Integer sinceSeconds;
  private Integer tailingLines;
  private Integer readyWaitTimeout;
  private boolean prettyOutput;
  private ExecListener execListener;
  private Integer limitBytes;
  private Integer bufferSize;
  private String file;
  private String dir;
  private boolean terminateOnError;

  private boolean rolling;

  public PodOperationContext withContainerId(String containerId) {
    return this.toBuilder().containerId(containerId).build();
  }

  public PodOperationContext withIn(InputStream in) {
    return this.toBuilder().in(in).build();
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

  public PodOperationContext withReadyWaitTimeout(Integer logWaitTimeout) {
    return this.toBuilder().readyWaitTimeout(logWaitTimeout).build();
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
    boolean usingStream = false;
    if (in != null || redirectingIn) {
      httpUrlBuilder.addQueryParameter("stdin", "true");
      usingStream = true;
    }
    boolean debug = ExecWebSocketListener.LOGGER.isDebugEnabled();
    if (output != null || debug) {
      httpUrlBuilder.addQueryParameter("stdout", "true");
      usingStream = true;
    }
    if (error != null || terminateOnError || debug) {
      httpUrlBuilder.addQueryParameter("stderr", "true");
      usingStream = true;
    }
    if (!usingStream) {
      throw new KubernetesClientException("Pod operation is not valid unless an in, out, or error stream is used.");
    }
  }

}
