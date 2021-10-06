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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

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
  protected String selectorAsString;

  public OperationContext() {
  }

  public OperationContext(OperationContext other) {
    this(other.client, other.config, other.plural, other.namespace, other.name, other.apiGroupName, other.apiGroupVersion, other.cascading, other.item, other.labels, other.labelsNot, other.labelsIn, other.labelsNotIn, other.fields, other.fieldsNot, other.resourceVersion, other.reloadingFromServer, other.gracePeriodSeconds, other.propagationPolicy, other.namespaceFromGlobalConfig, other.dryRun, other.selectorAsString);
  }

  public OperationContext(OkHttpClient client, Config config, String plural, String namespace, String name,
                          String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels,
                          Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn,
                          Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, boolean reloadingFromServer,
                          long gracePeriodSeconds, DeletionPropagation propagationPolicy, boolean namespaceFromGlobalConfig,
                          boolean dryRun, String selectorAsString) {
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
    this.selectorAsString = selectorAsString;
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

  public String getLabelQueryParam() {
    if(Utils.isNotNullOrEmpty(selectorAsString)) {
      return selectorAsString;
    }
    
    StringBuilder sb = new StringBuilder(101);

    appendEntriesAsParam(sb, getLabels(), asKeyValuePair);
    appendEntriesAsParam(sb, getLabelsNot(), asNotEqualToValues);
    appendEntriesAsParam(sb, getLabelsIn(), asInSet);
    appendEntriesAsParam(sb, getLabelsNotIn(), asNotInSet);

    if (sb.length() > 0) {
      return sb.toString();
    }
    return null;
  }

  private static BiFunction<String, String[], String> getEntryProcessorFor(String operator) {
    return (key, values) -> key + " " + operator + " (" + String.join(",", values) + ")";
  }

  private final static BiFunction<String, String, String> asKeyValuePair =
    (key, value) -> value != null ? key + "=" + value : key;
  private final static BiFunction<String, String[], String> asNotEqualToValues =
    (key, values) -> Utils.isNotNull(values) ? Arrays.stream(values).map(v -> key + "!=" + v).collect(Collectors.joining(",")) : "!" + key;
  private final static BiFunction<String, String[], String> asInSet = getEntryProcessorFor("in");
  private final static BiFunction<String, String[], String> asNotInSet = getEntryProcessorFor("notin");

  private <T> void appendEntriesAsParam(StringBuilder sb, Map<String, T> entries, BiFunction<String, T, String> entryProcessor) {
    if (entries != null && !entries.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(",");
      }

      sb.append(entries.entrySet().stream()
        .map(entry -> entryProcessor.apply(entry.getKey(), entry.getValue()))
        .collect(Collectors.joining(","))
      );
    }
  }

  public String getFieldQueryParam() {
    StringBuilder sb = new StringBuilder(101);
    if (Utils.isNotNullOrEmpty(getName())) {
      sb.append("metadata.name").append("=").append(getName());
    }

    appendEntriesAsParam(sb, getFields(), asKeyValuePair);
    appendEntriesAsParam(sb, getFieldsNot(), asNotEqualToValues);

    if (sb.length() > 0) {
      return sb.toString();
    }
    return null;
  }


  public OperationContext copy() {
    return new OperationContext(this);
  }

  public OperationContext withOkhttpClient(OkHttpClient client) {
    if (this.client == client) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.client = client;
    return context;
  }

  public OperationContext withConfig(Config config) {
    if (this.config == config) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.config = config;
    return context;
  }

  public OperationContext withPlural(String plural) {
    if (Objects.equals(this.plural, plural)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.plural = plural;
    return context;
  }

  public OperationContext withNamespace(String namespace) {
    if (Objects.equals(this.namespace, namespace)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.namespace = namespace;
    return context;
  }

  public OperationContext withName(String name) {
    if (Objects.equals(this.name, name)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.name = name;
    return context;
  }

  public OperationContext withApiGroupName(String apiGroupName) {
    if (Objects.equals(this.apiGroupName, apiGroupName)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.apiGroupName = apiGroupName;
    return context;
  }

  public OperationContext withApiGroupVersion(String apiGroupVersion) {
    if (Objects.equals(this.apiGroupVersion, apiGroupVersion)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.apiGroupVersion = apiGroupVersion;
    return context;
  }

  public OperationContext withItem(Object item) {
    if (this.item == item) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.item = item;
    return context;
  }

  public OperationContext withCascading(boolean cascading) {
    if (this.cascading == cascading) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.cascading = cascading;
    return context;
  }

  public OperationContext withLabels(Map<String, String> labels) {
    if (Objects.equals(this.labels, labels)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.labels = labels;
    return context;
  }

  public OperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    if (Objects.equals(this.labelsIn, labelsIn)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.labelsIn = labelsIn;
    return context;
  }

  public OperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    if (Objects.equals(this.labelsNot, labelsNot)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.labelsNot = labelsNot;
    return context;
  }

  public OperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    if (Objects.equals(this.labelsNotIn, labelsNotIn)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.labelsNotIn = labelsNotIn;
    return context;
  }

  public OperationContext withFields(Map<String, String> fields) {
    if (Objects.equals(this.fields, fields)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.fields = fields;
    return context;
  }

  public OperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    if (Objects.equals(this.fieldsNot, fieldsNot)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.fieldsNot = fieldsNot;
    return context;
  }

  public OperationContext withResourceVersion(String resourceVersion) {
    if (Objects.equals(this.resourceVersion, resourceVersion)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.resourceVersion = resourceVersion;
    return context;
  }

  public OperationContext withReloadingFromServer(boolean reloadingFromServer) {
    if (this.reloadingFromServer == reloadingFromServer) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.reloadingFromServer = reloadingFromServer;
    return context;
  }

  public OperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    if (this.gracePeriodSeconds == gracePeriodSeconds) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.gracePeriodSeconds = gracePeriodSeconds;
    return context;
  }

  public OperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    if (this.propagationPolicy == propagationPolicy) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.propagationPolicy = propagationPolicy;
    return context;
  }

  public OperationContext withIsNamespaceConfiguredFromGlobalConfig(boolean namespaceFromGlobalConfig) {
    if (this.namespaceFromGlobalConfig == namespaceFromGlobalConfig) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.namespaceFromGlobalConfig = namespaceFromGlobalConfig;
    return context;
  }

  public OperationContext withDryRun(boolean dryRun) {
    if(this.dryRun == dryRun) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.dryRun = dryRun;
    return context;
  }

  public OperationContext withLabelSelector(String selectorAsString) {
    if (Objects.equals(this.selectorAsString, selectorAsString)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.selectorAsString = selectorAsString;
    return context;
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
      context.isNamespaceFromGlobalConfig() ? context.isNamespaceFromGlobalConfig() : isNamespaceFromGlobalConfig(), context.getDryRun() ? context.getDryRun() : getDryRun(),
      Utils.getNonNullOrElse(context.selectorAsString, selectorAsString)
    );
  }

}
