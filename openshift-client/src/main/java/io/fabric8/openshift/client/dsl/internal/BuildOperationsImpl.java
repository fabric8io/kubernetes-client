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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
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

  public BuildOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, null, null, false, null, null);
  }

  public BuildOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, Build item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, null, namespace, name, cascading, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, false, false, false, null, null, null, false, null, null);
  }

  public BuildOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, Build item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, InputStream in, OutputStream out, OutputStream err, PipedOutputStream inPipe, PipedInputStream outPipe, PipedInputStream errPipe, boolean withTTY, boolean withTerminatedStatus, boolean withTimestamps, String sinceTimestamp, Integer sinceSeconds, Integer withTailingLines, boolean withPrettyOutput, String version, Integer limitBytes) {
    super(client, OpenShiftOperation.withApiGroup(client, BUILD, apiVersion, config), "builds", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    this.in = in;
    this.out = out;
    this.err = err;
    this.inPipe = inPipe;
    this.outPipe = outPipe;
    this.errPipe = errPipe;
    this.withTTY = withTTY;
    this.withTerminatedStatus = withTerminatedStatus;
    this.withTimestamps = withTimestamps;
    this.sinceTimestamp = sinceTimestamp;
    this.sinceSeconds = sinceSeconds;
    this.withTailingLines = withTailingLines;
    this.withPrettyOutput = withPrettyOutput;
    this.version = version;
    this.limitBytes = limitBytes;
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
    return sb.toString();
  }

  public String getLog() {
    try {
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters()));
      Request.Builder requestBuilder = new Request.Builder().get().url(url);
      Request request = requestBuilder.build();
      Response response = client.newCall(request).execute();
      try (ResponseBody body = response.body()) {
        assertResponseCode(request, response);
        return body.string();
      }
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("getLog"), t);
    }
  }

  @Override
  public String getLog(Boolean isPretty) {
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, version, limitBytes).getLog();
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
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, true, version, limitBytes);
  }

  @Override
  public PrettyLoggable<String, LogWatch> tailingLines(int withTailingLines) {
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, version, limitBytes);
  }

  @Override
  public TimeTailPrettyLoggable<String, LogWatch> terminated() {
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, version, limitBytes);
  }

  @Override
  public TailPrettyLoggable<String, LogWatch> sinceTime(String sinceTimestamp) {
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, version, limitBytes);
  }

  @Override
  public TailPrettyLoggable<String, LogWatch> sinceSeconds(int sinceSeconds) {
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, version, limitBytes);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable<String, LogWatch> limitBytes(int limitBytes) {
    return new BuildOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), in,out,err,inPipe, outPipe, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, version, limitBytes);
  }
}
