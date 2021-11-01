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
package io.fabric8.openshift.client.dsl.internal.build;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.internal.PatchUtils;
import io.fabric8.kubernetes.client.utils.PodOperationUtil;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.BuildResource;
import io.fabric8.openshift.client.dsl.internal.BuildOperationContext;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;
import io.fabric8.openshift.client.internal.patchmixins.BuildMixIn;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.BUILD;

public class BuildOperationsImpl extends OpenShiftOperation<Build, BuildList,
  BuildResource<Build, LogWatch>> implements
  BuildResource<Build, LogWatch> {

  public static final String OPENSHIFT_IO_BUILD_NAME = "openshift.io/build.name";
  private final boolean withTerminatedStatus;
  private final boolean withTimestamps;
  private final String sinceTimestamp;
  private final Integer sinceSeconds;
  private final Integer withTailingLines;
  private final boolean withPrettyOutput;
  private final String version;
  private final Integer limitBytes;
  private static final Integer DEFAULT_POD_LOG_WAIT_TIMEOUT = 5;
  private Integer podLogWaitTimeout;
  private final BuildOperationContext buildOperationContext;

  public BuildOperationsImpl(HttpClient client, OpenShiftConfig config) {
    this(new BuildOperationContext(), new OperationContext().withHttpClient(client).withConfig(config));
  }

  public BuildOperationsImpl(BuildOperationContext context, OperationContext superContext) {
    super(superContext.withApiGroupName(BUILD)
      .withPlural("builds"), Build.class, BuildList.class);
    this.buildOperationContext = context;
    this.withTerminatedStatus = context.isTerminatedStatus();
    this.withTimestamps = context.isTimestamps();
    this.sinceTimestamp = context.getSinceTimestamp();
    this.sinceSeconds = context.getSinceSeconds();
    this.withTailingLines = context.getTailingLines();
    this.withPrettyOutput = context.isPrettyOutput();
    this.version = context.getVersion();
    this.limitBytes = context.getLimitBytes();
    PatchUtils.addMixInToMapper(Build.class, BuildMixIn.class);
  }

  @Override
  public BuildOperationsImpl newInstance(OperationContext context) {
    return new BuildOperationsImpl(buildOperationContext, context);
  }

  BuildOperationContext getContext() {
    return buildOperationContext;
  }

  protected String getLogParameters() {
    StringBuilder sb = new StringBuilder();
    sb.append("log?pretty=").append(withPrettyOutput);
    if (version != null && !version.isEmpty()) {
      sb.append("&version=").append(version);
    }
    if (withTerminatedStatus) {
      sb.append("&previous=true");
    }
    if (sinceSeconds != null) {
      sb.append("&sinceSeconds=").append(sinceSeconds);
    } else if (sinceTimestamp != null) {
      sb.append("&sinceTime=").append(sinceTimestamp);
    }
    if (withTailingLines != null) {
      sb.append("&tailLines=").append(withTailingLines);
    }
    if (limitBytes != null) {
      sb.append("&limitBytes=").append(limitBytes);
    }
    if (withTimestamps) {
      sb.append("&timestamps=true");
    }
    return sb.toString();
  }

  protected <T> T doGetLog(Class<T> type){
    try {
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters()));
      return handleRawGet(url, type);
    } catch (IOException t) {
      throw KubernetesClientException.launderThrowable(forOperationType("doGetLog"), t);
    }
  }

  @Override
  public String getLog() {
    return doGetLog(String.class);
  }

  @Override
  public String getLog(Boolean isPretty) {
    return new BuildOperationsImpl(getContext().withPrettyOutput(isPretty), context).getLog();
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader(){
    return doGetLog(Reader.class);
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    try {
      // In case of Build we directly get logs at Build Url, but we need to wait for Pods
      waitUntilBuildPodBecomesReady(fromServer().get());
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters() + "&follow=true"));
      final LogWatchCallback callback = new LogWatchCallback(config, out);
      return callback.callAndWait(client, url);
    } catch (IOException t) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), t);
    }
  }

  @Override
  public Loggable<LogWatch> withLogWaitTimeout(Integer logWaitTimeout) {
    BuildOperationsImpl result = newInstance(context);
    result.podLogWaitTimeout = logWaitTimeout;
    return result;
  }

  @Override
  public Loggable<LogWatch> withPrettyOutput() {
    return new BuildOperationsImpl(getContext().withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable<LogWatch> tailingLines(int tailingLines) {
    return new BuildOperationsImpl(getContext().withTailingLines(tailingLines), context);
  }

  @Override
  public TimeTailPrettyLoggable<LogWatch> terminated() {
    return new BuildOperationsImpl(getContext().withTerminatedStatus(true), context);
  }

  @Override
  public TailPrettyLoggable<LogWatch> sinceTime(String sinceTimestamp) {
    return new BuildOperationsImpl(getContext().withSinceTimestamp(sinceTimestamp), context);
  }

  @Override
  public TailPrettyLoggable<LogWatch> sinceSeconds(int sinceSeconds) {
    return new BuildOperationsImpl(getContext().withSinceSeconds(sinceSeconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable<LogWatch> limitBytes(int limitBytes) {
    return new BuildOperationsImpl(getContext().withLimitBytes(limitBytes), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable<LogWatch> usingTimestamps() {
    return new BuildOperationsImpl(getContext().withTimestamps(true), context);
  }

  @Override
  protected VisitableBuilder<Build, ?> createVisitableBuilder(Build item) {
    return new BuildBuilder(item);
  }

  private void waitUntilBuildPodBecomesReady(Build build) {
    List<PodResource<Pod>> podOps = PodOperationUtil.getPodOperationsForController(context, build.getMetadata().getUid(),
      getBuildPodLabels(build), withPrettyOutput, podLogWaitTimeout, null);

    waitForBuildPodToBecomeReady(podOps, podLogWaitTimeout != null ? podLogWaitTimeout : DEFAULT_POD_LOG_WAIT_TIMEOUT);
  }

  private static void waitForBuildPodToBecomeReady(List<PodResource<Pod>> podOps, Integer podLogWaitTimeout) {
    for (PodResource<Pod> podOp : podOps) {
      PodOperationUtil.waitUntilReadyBeforeFetchingLogs(podOp, podLogWaitTimeout);
    }
  }

  static Map<String, String> getBuildPodLabels(Build build) {
    Map<String, String> labels = new HashMap<>();
    if (build != null && build.getMetadata() != null) {
      labels.put(OPENSHIFT_IO_BUILD_NAME, build.getMetadata().getName());
    }
    return labels;
  }
}
