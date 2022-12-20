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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimestampBytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.client.dsl.BuildResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.BUILD;

public class BuildOperationsImpl extends HasMetadataOperation<Build, BuildList, BuildResource> implements
    BuildResource {

  public static final String OPENSHIFT_IO_BUILD_NAME = "openshift.io/build.name";
  private Integer version;
  private static final Integer DEFAULT_POD_LOG_WAIT_TIMEOUT = 5;
  private final PodOperationContext operationContext;

  public BuildOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client), null);
  }

  public BuildOperationsImpl(PodOperationContext context, OperationContext superContext, Integer version) {
    super(superContext.withApiGroupName(BUILD)
        .withPlural("builds"), Build.class, BuildList.class);
    this.operationContext = context;
    this.context = superContext;
    this.version = version;
  }

  @Override
  public BuildOperationsImpl newInstance(OperationContext context) {
    return new BuildOperationsImpl(operationContext, context, version);
  }

  PodOperationContext getContext() {
    return operationContext;
  }

  protected String getLogParameters() {
    String params = operationContext.getLogParameters();
    if (version != null) {
      params += ("&version=" + version);
    }
    return params;
  }

  protected <T> T doGetLog(Class<T> type) {
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
  public String getLog(boolean isPretty) {
    return new BuildOperationsImpl(getContext().withPrettyOutput(isPretty), context, version).getLog();
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   *
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return doGetLog(Reader.class);
  }

  /**
   * Returns an unclosed InputStream. It's the caller responsibility to close it.
   *
   * @return InputStream
   */
  @Override
  public InputStream getLogInputStream() {
    return doGetLog(InputStream.class);
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    try {
      // In case of Build we directly get logs at Build Url, but we need to wait for Pods
      waitUntilBuildPodBecomesReady(get());
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters() + "&follow=true"));
      final LogWatchCallback callback = new LogWatchCallback(out, this.context.getExecutor());
      return callback.callAndWait(this.httpClient, url);
    } catch (IOException t) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), t);
    }
  }

  @Override
  public Loggable withLogWaitTimeout(Integer logWaitTimeout) {
    return withReadyWaitTimeout(logWaitTimeout);
  }

  @Override
  public Loggable withReadyWaitTimeout(Integer timeout) {
    return new BuildOperationsImpl(getContext().withReadyWaitTimeout(timeout), context, version);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new BuildOperationsImpl(getContext().withPrettyOutput(true), context, version);
  }

  @Override
  public PrettyLoggable tailingLines(int tailingLines) {
    return new BuildOperationsImpl(getContext().withTailingLines(tailingLines), context, version);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new BuildOperationsImpl(getContext().withTerminatedStatus(true), context, version);
  }

  @Override
  public TailPrettyLoggable sinceTime(String sinceTimestamp) {
    return new BuildOperationsImpl(getContext().withSinceTimestamp(sinceTimestamp), context, version);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int sinceSeconds) {
    return new BuildOperationsImpl(getContext().withSinceSeconds(sinceSeconds), context, version);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new BuildOperationsImpl(getContext().withLimitBytes(limitBytes), context, version);
  }

  @Override
  public TimestampBytesLimitTerminateTimeTailPrettyLoggable withVersion(Integer version) {
    return new BuildOperationsImpl(getContext(), context, version);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new BuildOperationsImpl(getContext().withTimestamps(true), context, version);
  }

  private void waitUntilBuildPodBecomesReady(Build build) {
    List<PodResource> podOps = PodOperationUtil.getPodOperationsForController(context,
        operationContext, build.getMetadata().getUid(),
        getBuildPodLabels(build));

    waitForBuildPodToBecomeReady(podOps,
        operationContext.getReadyWaitTimeout() != null ? operationContext.getReadyWaitTimeout() : DEFAULT_POD_LOG_WAIT_TIMEOUT);
  }

  private static void waitForBuildPodToBecomeReady(List<PodResource> podOps, Integer podLogWaitTimeout) {
    for (PodResource podOp : podOps) {
      PodOperationUtil.waitUntilReadyOrSucceded(podOp, podLogWaitTimeout);
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
