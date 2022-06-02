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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class OperationContext {

  protected Object item;
  protected String resourceVersion;
  protected String plural;

  protected String apiGroupName;
  protected String apiGroupVersion;

  protected String namespace;
  protected boolean defaultNamespace = true;
  protected String name;
  protected boolean reloadingFromServer;
  protected boolean dryRun;

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

  protected Client client;

  public OperationContext() {
  }

  public OperationContext(OperationContext other) {
    this(other.client, other.plural, other.namespace, other.name, other.apiGroupName, other.apiGroupVersion,
        other.item, other.labels, other.labelsNot, other.labelsIn, other.labelsNotIn, other.fields,
        other.fieldsNot, other.resourceVersion, other.reloadingFromServer, other.gracePeriodSeconds, other.propagationPolicy,
        other.dryRun, other.selectorAsString, other.defaultNamespace);
  }

  public OperationContext(Client client, String plural, String namespace, String name,
      String apiGroupName, String apiGroupVersion, Object item, Map<String, String> labels,
      Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn,
      Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, boolean reloadingFromServer,
      long gracePeriodSeconds, DeletionPropagation propagationPolicy,
      boolean dryRun, String selectorAsString, boolean defaultNamespace) {
    this.client = client;
    this.item = item;
    this.plural = plural;
    setNamespace(namespace, defaultNamespace);
    this.name = name;
    setApiGroupName(apiGroupName);
    setApiGroupVersion(apiGroupVersion);
    setLabels(labels);
    setLabelsNot(labelsNot);
    setLabelsIn(labelsIn);
    setLabelsNotIn(labelsNotIn);
    setFields(fields);
    setFieldsNot(fieldsNot);
    this.resourceVersion = resourceVersion;
    this.reloadingFromServer = reloadingFromServer;
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.propagationPolicy = propagationPolicy;
    this.dryRun = dryRun;
    this.selectorAsString = selectorAsString;
  }

  private void setFieldsNot(Map<String, String[]> fieldsNot) {
    this.fieldsNot = Utils.getNonNullOrElse(fieldsNot, new HashMap<>());
  }

  private void setFields(Map<String, String> fields) {
    this.fields = Utils.getNonNullOrElse(fields, new HashMap<>());
  }

  private void setLabelsNotIn(Map<String, String[]> labelsNotIn) {
    this.labelsNotIn = Utils.getNonNullOrElse(labelsNotIn, new HashMap<>());
  }

  private void setLabelsIn(Map<String, String[]> labelsIn) {
    this.labelsIn = Utils.getNonNullOrElse(labelsIn, new HashMap<>());
  }

  private void setLabelsNot(Map<String, String[]> labelsNot) {
    this.labelsNot = Utils.getNonNullOrElse(labelsNot, new HashMap<>());
  }

  private void setLabels(Map<String, String> labels) {
    this.labels = Utils.getNonNullOrElse(labels, new HashMap<>());
  }

  private void setApiGroupVersion(String apiGroupVersion) {
    this.apiGroupVersion = ApiVersionUtil.apiVersion(item, apiGroupVersion);
  }

  private void setApiGroupName(String apiGroupName) {
    this.apiGroupName = ApiVersionUtil.apiGroup(item, apiGroupName);
  }

  private void setNamespace(String namespace, boolean defaultNamespace) {
    Config config = getConfig();
    if (!defaultNamespace || Utils.isNotNullOrEmpty(namespace)) {
      this.namespace = namespace;
      this.defaultNamespace = defaultNamespace;
    } else if (config != null) {
      this.namespace = config.getNamespace();
      this.defaultNamespace = config.isDefaultNamespace();
    }
  }

  public Client getClient() {
    return client;
  }

  public HttpClient getHttpClient() {
    if (client == null) {
      return null;
    }
    return client.getHttpClient();
  }

  public Config getConfig() {
    if (client == null) {
      return null;
    }
    return client.getConfiguration();
  }

  public String getPlural() {
    return plural;
  }

  public String getNamespace() {
    return namespace;
  }

  public boolean isDefaultNamespace() {
    return defaultNamespace;
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

  public boolean getDryRun() {
    return dryRun;
  }

  public String getLabelQueryParam() {
    if (Utils.isNotNullOrEmpty(selectorAsString)) {
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

  private final static BiFunction<String, String, String> asKeyValuePair = (key, value) -> value != null ? key + "=" + value
      : key;
  private final static BiFunction<String, String[], String> asNotEqualToValues = (key, values) -> Utils.isNotNull(values)
      ? Arrays.stream(values).map(v -> key + "!=" + v).collect(Collectors.joining(","))
      : "!" + key;
  private final static BiFunction<String, String[], String> asInSet = getEntryProcessorFor("in");
  private final static BiFunction<String, String[], String> asNotInSet = getEntryProcessorFor("notin");

  private <T> void appendEntriesAsParam(StringBuilder sb, Map<String, T> entries,
      BiFunction<String, T, String> entryProcessor) {
    if (entries != null && !entries.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(",");
      }

      sb.append(entries.entrySet().stream()
          .map(entry -> entryProcessor.apply(entry.getKey(), entry.getValue()))
          .collect(Collectors.joining(",")));
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

  public OperationContext withClient(Client client) {
    if (this.client == client) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.client = client;
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
    if (Objects.equals(this.namespace, namespace) && !this.defaultNamespace) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setNamespace(namespace, false);
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
    context.setApiGroupName(apiGroupName);
    return context;
  }

  public OperationContext withApiGroupVersion(String apiGroupVersion) {
    if (Objects.equals(this.apiGroupVersion, apiGroupVersion)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setApiGroupVersion(apiGroupVersion);
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

  public OperationContext withLabels(Map<String, String> labels) {
    if (Objects.equals(this.labels, labels)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setLabels(labels);
    return context;
  }

  public OperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    if (Objects.equals(this.labelsIn, labelsIn)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setLabelsIn(labelsIn);
    return context;
  }

  public OperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    if (Objects.equals(this.labelsNot, labelsNot)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setLabelsNot(labelsNot);
    return context;
  }

  public OperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    if (Objects.equals(this.labelsNotIn, labelsNotIn)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setLabelsNotIn(labelsNotIn);
    return context;
  }

  public OperationContext withFields(Map<String, String> fields) {
    if (Objects.equals(this.fields, fields)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setFields(fields);
    return context;
  }

  public OperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    if (Objects.equals(this.fieldsNot, fieldsNot)) {
      return this;
    }
    final OperationContext context = new OperationContext(this);
    context.setFieldsNot(fieldsNot);
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

  public OperationContext withDryRun(boolean dryRun) {
    if (this.dryRun == dryRun) {
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

  <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> getHandler(T item) {
    return getClient().adapt(BaseClient.class).getHandlers().get(item, getClient());
  }

  public <C extends Client> C clientInWriteContext(Class<C> clazz) {
    // other than namespace these do not have values on the config, so we need to associate a default
    // operationcontext
    OperationContext newContext = HasMetadataOperationsImpl.defaultContext(client).withDryRun(getDryRun())
        .withGracePeriodSeconds(getGracePeriodSeconds()).withPropagationPolicy(getPropagationPolicy())
        .withReloadingFromServer(isReloadingFromServer());

    // check before setting to prevent flipping the default flag
    if (!Objects.equals(getNamespace(), newContext.getNamespace())
        || isDefaultNamespace() ^ newContext.isDefaultNamespace()) {
      newContext = newContext.withNamespace(getNamespace());
    }

    return getClient().adapt(BaseClient.class).newClient(newContext).adapt(clazz);
  }

  public Executor getExecutor() {
    return getClient().adapt(BaseClient.class).getExecutor();
  }

}
