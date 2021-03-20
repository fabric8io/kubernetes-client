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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Map;

public class PodOperationContext extends OperationContext {

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

  public PodOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels, Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, boolean reloadingFromServer, long gracePeriodSeconds, DeletionPropagation propagationPolicy, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean namespaceFromGlobalConfig, boolean dryRun, String containerId, InputStream in, OutputStream out, OutputStream err, OutputStream errChannel, PipedOutputStream inPipe, PipedInputStream outPipe, PipedInputStream errPipe, PipedInputStream errChannelPipe, Boolean tty, Boolean terminatedStatus, Boolean timestampes, String sinceTimestamp, Integer sinceSeconds, Integer tailingLines, Boolean prettyOutput, Integer limitBytes, Integer bufferSize, ExecListener execListener, String file, String dir, Integer logWaitTimeout) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun);
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

  public PodOperationContext withOkhttpClient(OkHttpClient client) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withConfig(Config config) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withPlural(String plural) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withNamespace(String namespace) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withName(String name) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withApiGroupName(String apiGroupName) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  @Override
  public PodOperationContext withItem(Object item) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withCascading(boolean cascading) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLabels(Map<String, String> labels) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withFields(Map<String, String> fields) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withResourceVersion(String resourceVersion) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }


  public PodOperationContext withContainerId(String containerId) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withIn(InputStream in) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withOut(OutputStream out) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErr(OutputStream err) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErrChannel(OutputStream errChannel) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withInPipe(PipedOutputStream inPipe) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withOutPipe(PipedInputStream outPipe) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErrPipe(PipedInputStream errPipe) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withErrChannelPipe(PipedInputStream errChannelPipe) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTty(boolean tty) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTimestamps(boolean timestamps) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withTailingLines(Integer tailingLines) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withPrettyOutput(boolean prettyOutput) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withExecListener(ExecListener execListener) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLimitBytes(Integer limitBytes) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withBufferSize(Integer bufferSize) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withFile(String file) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withDir(String dir) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  public PodOperationContext withLogWaitTimeout(Integer logWaitTimeout) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }

  @Override
  public PodOperationContext withDryRun(boolean dryRun) {
    return new PodOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun, containerId, in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, bufferSize, execListener, file, dir, logWaitTimeout);
  }
}
