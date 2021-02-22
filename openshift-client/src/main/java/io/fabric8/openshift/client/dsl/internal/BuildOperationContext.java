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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Map;

public class BuildOperationContext extends OperationContext {

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

  public BuildOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, Boolean cascading, Object item, Map<String, String> labels, Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Map<String, String[]> fieldsNot,String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, DeletionPropagation propagationPolicy, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean namespaceFromGlobalConfig, InputStream in, OutputStream out, OutputStream err, PipedOutputStream inPipe, PipedInputStream outPipe, PipedInputStream errPipe, Boolean tty, Boolean terminatedStatus, Boolean timestamps, String sinceTimestamp, Integer sinceSeconds, Integer tailingLines, Boolean prettyOutput, Integer limitBytes, String version, boolean dryRun) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun);
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


  public BuildOperationContext withOkhttpClient(OkHttpClient client) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withConfig(Config config) {
    return new BuildOperationContext(client, OpenShiftConfig.wrap(config), plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withPlural(String plural) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withNamespace(String namespace) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withName(String name) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withApiGroupName(String apiGroupName) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  @Override
  public BuildOperationContext withItem(Object item) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withCascading(boolean cascading) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withLabels(Map<String, String> labels) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withFields(Map<String, String> fields) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withResourceVersion(String resourceVersion) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }


  public BuildOperationContext withIn(InputStream in) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withOut(OutputStream out) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withErr(OutputStream err) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withInPipe(PipedOutputStream inPipe) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withOutPipe(PipedInputStream outPipe) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withErrPipe(PipedInputStream errPipe) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withTty(boolean tty) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withTerminatedStatus(boolean terminatedStatus) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withTimestamps(boolean timestamps) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withSinceTimestamp(String sinceTimestamp) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withSinceSeconds(Integer sinceSeconds) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withTailingLines(Integer tailingLines) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withPrettyOutput(boolean prettyOutput) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  public BuildOperationContext withLimitBytes(Integer limitBytes) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

  @Override
  public BuildOperationContext withDryRun(boolean dryRun) {
    return new BuildOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, in, out, err, inPipe, outPipe, errPipe, tty, terminatedStatus, timestamps, sinceTimestamp, sinceSeconds, tailingLines, prettyOutput, limitBytes, version, dryRun);
  }

}
