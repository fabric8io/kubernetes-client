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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.client.dsl.BuildResource;
import okhttp3.OkHttpClient;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.DoneableBuild;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.BUILD;

public class BuildOperationsImpl extends OpenShiftOperation<Build, BuildList, DoneableBuild,
  BuildResource<Build, DoneableBuild, String, LogWatch>> implements
  BuildResource<Build, DoneableBuild, String, LogWatch> {

  private final InputStream in;
  private final OutputStream out;
  private final OutputStream err;

  private final PipedOutputStream inPipe;
  private final PipedInputStream outPipe;
  private final PipedInputStream errPipe;
  private final boolean withTTY;
  private final boolean withTerminatedStatus;
  private final boolean withTimestamps;
  private final String sinceTimestamp;
  private final Integer sinceSeconds;
  private final Integer withTailingLines;
  private final boolean withPrettyOutput;
  private final String version;
  private final Integer limitBytes;


  public BuildOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new BuildOperationContext().withOkhttpClient(client).withConfig(config));
  }

  public BuildOperationsImpl(BuildOperationContext context) {
    super(context.withApiGroupName(BUILD)
      .withPlural("builds"));
    this.type = Build.class;
    this.listType = BuildList.class;
    this.doneableType = DoneableBuild.class;

    this.in = context.getIn();
    this.out = context.getOut();
    this.err = context.getErr();
    this.inPipe = context.getInPipe();
    this.outPipe = context.getOutPipe();
    this.errPipe = context.getErrPipe();
    this.withTTY = context.isTty();
    this.withTerminatedStatus = context.isTerminatedStatus();
    this.withTimestamps = context.isTimestamps();
    this.sinceTimestamp = context.getSinceTimestamp();
    this.sinceSeconds = context.getSinceSeconds();
    this.withTailingLines = context.getTailingLines();
    this.withPrettyOutput = context.isPrettyOutput();
    this.version = context.getVersion();
    this.limitBytes = context.getLimitBytes();
  }

  @Override
  public BuildOperationsImpl newInstance(OperationContext context) {
    return new BuildOperationsImpl((BuildOperationContext) context);
  }

  BuildOperationContext getContext() {
    return (BuildOperationContext) context;
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

  protected ResponseBody doGetLog(){
    try {
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters()));
      Request.Builder requestBuilder = new Request.Builder().get().url(url);
      Request request = requestBuilder.build();
      Response response = client.newCall(request).execute();
      ResponseBody body = response.body();
      assertResponseCode(request, response);
      return body;
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("doGetLog"), t);
    }
  }

  @Override
  public String getLog() {
    try(ResponseBody body = doGetLog()) {
      return doGetLog().string();
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("getLog"), e);
    }
  }

  @Override
  public String getLog(Boolean isPretty) {
    return new BuildOperationsImpl(getContext().withPrettyOutput(isPretty)).getLog();
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader(){
    return doGetLog().charStream();
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    try {
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters() + "&follow=true"));
      Request request = new Request.Builder().url(url).get().build();
      final LogWatchCallback callback = new LogWatchCallback(out);
      OkHttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
      clone.newCall(request).enqueue(callback);
      callback.waitUntilReady();
      return callback;
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), t);
    }
  }


  @Override
  public Loggable<String, LogWatch> withPrettyOutput() {
    return new BuildOperationsImpl(getContext().withPrettyOutput(true));
  }

  @Override
  public PrettyLoggable<String, LogWatch> tailingLines(int tailingLines) {
    return new BuildOperationsImpl(getContext().withTailingLines(tailingLines));
  }

  @Override
  public TimeTailPrettyLoggable<String, LogWatch> terminated() {
    return new BuildOperationsImpl(getContext().withTerminatedStatus(true));
  }

  @Override
  public TailPrettyLoggable<String, LogWatch> sinceTime(String sinceTimestamp) {
    return new BuildOperationsImpl(getContext().withSinceTimestamp(sinceTimestamp));
  }

  @Override
  public TailPrettyLoggable<String, LogWatch> sinceSeconds(int sinceSeconds) {
    return new BuildOperationsImpl(getContext().withSinceSeconds(sinceSeconds));
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable<String, LogWatch> limitBytes(int limitBytes) {
    return new BuildOperationsImpl(getContext().withLimitBytes(limitBytes));
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable<String, LogWatch> usingTimestamps() {
    return new BuildOperationsImpl(getContext().withTimestamps(true));
  }
}
