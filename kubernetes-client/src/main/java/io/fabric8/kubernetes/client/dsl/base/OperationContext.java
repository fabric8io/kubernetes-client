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
package io.fabric8.kubernetes.client.dsl.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

public class OperationContext {

  protected OkHttpClient client;
  protected Config config;
  protected Object item;
  protected String resourceVersion;
  protected String plural;

  protected String apiGroupName;
  protected String apiGroupVersion;

  protected String namespace;
  protected String name;
  protected boolean cascading;
  protected boolean reloadingFromServer;
  protected boolean dryRun;
  /*
   * This field is added in order to distinguish whether namespace is picked from global
   * Configuration (either your KUBECONFIG or /var/run/secrets/kubernetes.io/serviceaccount/namespace)
   * if inside a Pod
   */
  protected boolean namespaceFromGlobalConfig;

  // Default to -1 to respect the value set in the resource or the Kubernetes default (30 seconds)
  protected long gracePeriodSeconds = -1L;
  protected DeletionPropagation propagationPolicy;

  protected Map<String, String> labels;
  protected Map<String, String[]> labelsNot;
  protected Map<String, String[]> labelsIn;
  protected Map<String, String[]> labelsNotIn;
  protected Map<String, String> fields;
  protected Map<String, String[]> fieldsNot;

  public OperationContext() {
  }

  public OperationContext(OkHttpClient client, Config config, String plural, String namespace, String name,
      String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels,
      Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn,
      Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, boolean reloadingFromServer,
      long gracePeriodSeconds, DeletionPropagation propagationPolicy, boolean namespaceFromGlobalConfig,
      boolean dryRun) {
    this.client = client;
    this.config = config;
    this.plural = plural;
    this.namespace = Utils.isNotNullOrEmpty(namespace) ? namespace : (config != null ? config.getNamespace() : null);
    this.name = name;
    this.apiGroupName = ApiVersionUtil.apiGroup(item, apiGroupName);
    this.apiGroupVersion = ApiVersionUtil.apiVersion(item, apiGroupVersion);
    this.cascading = cascading;
    this.item = item;
    this.labels = Utils.getNonNullOrElse(labels, new HashMap<>());
    this.labelsNot = Utils.getNonNullOrElse(labelsNot, new HashMap<>());
    this.labelsIn = Utils.getNonNullOrElse(labelsIn, new HashMap<>());
    this.labelsNotIn = Utils.getNonNullOrElse(labelsNotIn, new HashMap<>());
    this.fields = Utils.getNonNullOrElse(fields, new HashMap<>());
    this.fieldsNot = Utils.getNonNullOrElse(fieldsNot, new HashMap<>());
    this.resourceVersion = resourceVersion;
    this.reloadingFromServer = reloadingFromServer;
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.propagationPolicy = propagationPolicy;
    this.namespaceFromGlobalConfig = namespaceFromGlobalConfig;
    this.dryRun = dryRun;
  }

  public OkHttpClient getClient() {
    return client;
  }

  public Config getConfig() {
    return config;
  }

  public String getPlural() {
    return plural;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getName() {
    return name;
  }

  public String getApiGroupName() {
    return apiGroupName;
  }

  public String getApiGroupVersion() {
    return apiGroupVersion;
  }

  public boolean getCascading() {
    return cascading;
  }

  public Object getItem() {
    return item;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public Map<String, String[]> getLabelsNot() {
    return labelsNot;
  }

  public Map<String, String[]> getLabelsIn() {
    return labelsIn;
  }

  public Map<String, String[]> getLabelsNotIn() {
    return labelsNotIn;
  }

  public Map<String, String> getFields() {
    return fields;
  }

  public Map<String, String[]> getFieldsNot() {
    return fieldsNot;
  }

  public String getResourceVersion() {
    return resourceVersion;
  }

  public boolean isReloadingFromServer() {
    return reloadingFromServer;
  }

  public long getGracePeriodSeconds() {
    return gracePeriodSeconds;
  }

  public DeletionPropagation getPropagationPolicy() {
    return propagationPolicy;
  }

  public boolean isNamespaceFromGlobalConfig() {
    return namespaceFromGlobalConfig;
  }

  public boolean getDryRun() {
    return dryRun;
  }
  
  public OperationContext copy() {
    return new OperationContext(client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withOkhttpClient(OkHttpClient client) {
    if (this.client == client) {
      return this;
    }
    return new OperationContext(client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withConfig(Config config) {
    if (this.config == config) {
      return this;
    }
    return new OperationContext(this.client, config, this.plural, this.namespace, this.name, this.apiGroupName,
      this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
      this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
      this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withPlural(String plural) {
    if (Objects.equals(this.plural, plural)) {
      return this;
    }
    return new OperationContext(this.client, this.config, plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withNamespace(String namespace) {
    if (Objects.equals(this.namespace, namespace)) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withName(String name) {
    if (Objects.equals(this.name, name)) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withApiGroupName(String apiGroupName) {
    if (Objects.equals(this.apiGroupName, apiGroupName)) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withApiGroupVersion(String apiGroupVersion) {
    if (Objects.equals(this.apiGroupVersion, apiGroupVersion)) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withItem(Object item) {
    if (this.item == item) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withCascading(boolean cascading) {
    if (this.cascading == cascading) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withLabels(Map<String, String> labels) {
    if (this.labels == labels) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    if (this.labelsIn == labelsIn) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    if (this.labelsNot == labelsNot) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    if (this.labelsNotIn == labelsNotIn) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withFields(Map<String, String> fields) {
    if (this.fields == fields) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    if (this.fieldsNot == fieldsNot) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withResourceVersion(String resourceVersion) {
    if (Objects.equals(this.resourceVersion, resourceVersion)) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withReloadingFromServer(boolean reloadingFromServer) {
    if (this.reloadingFromServer == reloadingFromServer) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    if (this.gracePeriodSeconds == gracePeriodSeconds) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, gracePeriodSeconds,
        this.propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    if (this.propagationPolicy == propagationPolicy) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        propagationPolicy, this.namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withIsNamespaceConfiguredFromGlobalConfig(boolean namespaceFromGlobalConfig) {
    if (this.namespaceFromGlobalConfig == namespaceFromGlobalConfig) {
      return this;
    }
    return new OperationContext(this.client, this.config, this.plural, this.namespace, this.name, this.apiGroupName,
        this.apiGroupVersion, this.cascading, this.item, this.labels, this.labelsNot, this.labelsIn, this.labelsNotIn,
        this.fields, this.fieldsNot, this.resourceVersion, this.reloadingFromServer, this.gracePeriodSeconds,
        this.propagationPolicy, namespaceFromGlobalConfig, this.dryRun);
  }

  public OperationContext withDryRun(boolean dryRun) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, namespaceFromGlobalConfig, dryRun);
  }

  /**
   * Returns an OperationContext object merged with current object.
   *
   * @param context object with modifications
   * @return a merged object between passed argument and current object
   */
  public OperationContext withOperationContext(OperationContext context) {
    return new OperationContext(Utils.getNonNullOrElse(context.getClient(), getClient()),
      Utils.getNonNullOrElse(context.getConfig(), getConfig()),
      Utils.getNonNullOrElse(context.getPlural(), getPlural()),
      Utils.getNonNullOrElse(context.getNamespace(), getNamespace()),
      Utils.getNonNullOrElse(context.getName(), getName()),
      Utils.getNonNullOrElse(context.getApiGroupName(), getApiGroupName()),
      Utils.getNonNullOrElse(context.getApiGroupVersion(), getApiGroupVersion()),
      context.getCascading() ? context.getCascading() : getCascading(),
      Utils.getNonNullOrElse(context.getItem(), getItem()),
      Utils.getNonNullOrElse(context.getLabels(), getLabels()),
      Utils.getNonNullOrElse(context.getLabelsNot(), getLabelsNot()),
      Utils.getNonNullOrElse(context.getLabelsIn(), getLabelsIn()),
      Utils.getNonNullOrElse(context.getLabelsNotIn(), getLabelsNotIn()),
      Utils.getNonNullOrElse(context.getFields(), getFields()),
      Utils.getNonNullOrElse(context.getFieldsNot(), getFieldsNot()),
      Utils.getNonNullOrElse(context.getResourceVersion(), getResourceVersion()),
      context.isReloadingFromServer() ? context.isReloadingFromServer() : isReloadingFromServer(),
      context.getGracePeriodSeconds() > 0 ? context.getGracePeriodSeconds() : getGracePeriodSeconds(),
      Utils.getNonNullOrElse(context.getPropagationPolicy(), getPropagationPolicy()),
      context.isNamespaceFromGlobalConfig() ? context.isNamespaceFromGlobalConfig() : isNamespaceFromGlobalConfig(), context.getDryRun() ? context.getDryRun() : getDryRun());
  }

}
