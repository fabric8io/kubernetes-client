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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BuildConfigOperationContext extends OperationContext {
  
  private String secret;
  private String triggerType;

  private String authorName;
  private String authorEmail;
  private String committerName;
  private String committerEmail;
  private String commit;
  private String message;
  private String asFile;

  private long timeout;
  private TimeUnit timeoutUnit;

  public BuildConfigOperationContext() {
  }

  public BuildConfigOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, String resourceVersion, boolean reloadingFromServer, long gracePeriodSeconds, String secret, String triggerType, String authorName, String authorEmail, String committerName, String committerEmail, String commit, String message, String asFile, Long timeout, TimeUnit timeUnit) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
    this.secret = secret;
    this.triggerType = triggerType;
    this.authorName = authorName;
    this.authorEmail = authorEmail;
    this.committerName = committerName;
    this.committerEmail = committerEmail;
    this.commit = commit;
    this.message = message;
    this.asFile = asFile;
    this.timeout = timeout;
    this.timeoutUnit = timeUnit != null ? timeUnit : TimeUnit.MILLISECONDS;
  }

  public String getSecret() {
    return secret;
  }

  public String getTriggerType() {
    return triggerType;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getAuthorEmail() {
    return authorEmail;
  }

  public String getCommitterName() {
    return committerName;
  }

  public String getCommitterEmail() {
    return committerEmail;
  }

  public String getCommit() {
    return commit;
  }

  public String getMessage() {
    return message;
  }

  public String getAsFile() {
    return asFile;
  }

  public long getTimeout() {
    return timeout;
  }

  public TimeUnit getTimeoutUnit() {
    return timeoutUnit;
  }

  public BuildConfigOperationContext withOkhttpClient(OkHttpClient client) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withConfig(Config config) {
    return new BuildConfigOperationContext(client, OpenShiftConfig.wrap(config), plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withPlural(String plural) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withNamespace(String namespace) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withName(String name) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }


  public BuildConfigOperationContext withApiGroupName(String apiGroupName) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public BuildConfigOperationContext withItem(Object item) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withCascading(boolean cascading) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withLabels(Map<String, String> labels) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withLabelsNot(Map<String, String> labelsNot) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withFields(Map<String, String> fields) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withResourceVersion(String resourceVersion) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withSecret(String secret) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withTriggerType(String triggerType) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withAuthorName(String authorName) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withAuthorEmail(String authorEmail) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withCommitterName(String committerName) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withCommitterEmail(String committerEmail) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withCommit(String commit) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withMessage(String message) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withAsFile(String asFile) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withTimeout(long timeout) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  public BuildConfigOperationContext withTimeoutUnit(TimeUnit timeoutUnit) {
    return new BuildConfigOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }
}
