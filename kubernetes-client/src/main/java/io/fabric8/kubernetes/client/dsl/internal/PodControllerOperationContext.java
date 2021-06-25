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
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import java.util.Map;

public class PodControllerOperationContext extends OperationContext {
  protected String containerId;

  public PodControllerOperationContext() { }

  public PodControllerOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String containerId, String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels, Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, boolean reloadingFromServer, long gracePeriodSeconds, DeletionPropagation propagationPolicy, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean isNamespaceFromGlobalConfig, boolean dryRun) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, isNamespaceFromGlobalConfig, dryRun);
    this.containerId = containerId;
  }

  public String getContainerId() {
    return containerId;
  }

  @Override
  public PodControllerOperationContext withOkhttpClient(OkHttpClient client) {
    return new PodControllerOperationContext(client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withConfig(Config config) {
    return new PodControllerOperationContext(this.client, config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withPlural(String plural) {
    return new PodControllerOperationContext(this.client, this.config, plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withNamespace(String namespace) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withName(String name) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withApiGroupName(String apiGroupName) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withItem(Object item) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withCascading(boolean cascading) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withLabels(Map<String, String> labels) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withFields(Map<String, String> fields) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withResourceVersion(String resourceVersion) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }

  @Override
  public PodControllerOperationContext withDryRun(boolean dryRun) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, dryRun);
  }

  public PodControllerOperationContext withContainerId(String containerId) {
    return new PodControllerOperationContext(this.client, this.config, this.plural, this.namespace, this.name, containerId, this.apiGroupName,
      apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.watchRetryInitialBackoffMillis, this.watchRetryBackoffMultiplier,
      this.namespaceFromGlobalConfig, this.dryRun);
  }
}
