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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Waitable;
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
  /*
   * This field is added in order to distinguish whether namespace is picked from global
   * Configuration(either your KUBECONFIG or /var/run/secrets/kubernetes.io/serviceaccount/namespace
   * if inside a Pod
   */
  protected boolean namespaceFromGlobalConfig;

  // Default to -1 to respect the value set in the resource or the Kubernetes default (30 seconds)
  protected long gracePeriodSeconds = -1L;
  protected DeletionPropagation propagationPolicy;

  protected long watchRetryInitialBackoffMillis = Waitable.DEFAULT_INITIAL_BACKOFF_MILLIS;
  protected double watchRetryBackoffMultiplier = Waitable.DEFAULT_BACKOFF_MULTIPLIER;

  protected Map<String, String> labels;
  protected Map<String, String[]> labelsNot;
  protected Map<String, String[]> labelsIn;
  protected Map<String, String[]> labelsNotIn;
  protected Map<String, String> fields;
  protected Map<String, String[]> fieldsNot;


  public OperationContext() {
  }

  public OperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels, Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, boolean reloadingFromServer, long gracePeriodSeconds, DeletionPropagation propagationPolicy, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean namespaceFromGlobalConfig) {
    this.client = client;
    this.config = config;
    this.plural = plural;
    this.name = name;
    this.cascading = cascading;
    this.labels = labels != null ? labels : new HashMap<>();
    this.labelsNot = labelsNot != null ? labelsNot : new HashMap<>();
    this.labelsIn = labelsIn != null ? labelsIn : new HashMap<>();
    this.labelsNotIn = labelsNotIn != null ? labelsNotIn : new HashMap<>();
    this.fields = fields != null ? fields : new HashMap<>();
    this.fieldsNot = fieldsNot != null ? fieldsNot : new HashMap<>();
    this.resourceVersion = resourceVersion;
    this.reloadingFromServer = reloadingFromServer;
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.propagationPolicy = propagationPolicy;
    this.watchRetryInitialBackoffMillis = watchRetryInitialBackoffMillis;
    this.watchRetryBackoffMultiplier = watchRetryBackoffMultiplier;
    this.item = item;
    this.apiGroupName =  ApiVersionUtil.apiGroup(item, apiGroupName);
    this.apiGroupVersion = ApiVersionUtil.apiVersion(item, apiGroupVersion);
    this.namespace = Utils.isNotNullOrEmpty(namespace) ? namespace : (config != null ? config.getNamespace() : null);
    this.namespaceFromGlobalConfig = namespaceFromGlobalConfig;
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

  public boolean getReloadingFromServer() {
    return reloadingFromServer;
  }

  public long getGracePeriodSeconds() {
    return gracePeriodSeconds;
  }

  public DeletionPropagation getPropagationPolicy() {
    return propagationPolicy;
  }

  public long getWatchRetryInitialBackoffMillis() {
    return watchRetryInitialBackoffMillis;
  }

  public double getWatchRetryBackoffMultiplier() {
    return watchRetryBackoffMultiplier;
  }

  public boolean isNamespaceFromGlobalConfig() {
    return namespaceFromGlobalConfig;
  }

  public OperationContext withOkhttpClient(OkHttpClient client) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withConfig(Config config) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withPlural(String plural) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withNamespace(String namespace) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withName(String name) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }


  public OperationContext withApiGroupName(String apiGroupName) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withApiGroupVersion(String apiGroupVersion) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withItem(Object item) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withCascading(boolean cascading) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withLabels(Map<String, String> labels) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withFields(Map<String, String> fields) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withResourceVersion(String resourceVersion) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withWatchRetryInitialBackoffMillis(long watchRetryInitialBackoffMillis) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withWatchRetryBackoffMultiplier(double watchRetryBackoffMultiplier) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  public OperationContext withIsNamespaceConfiguredFromGlobalConfig(boolean namespaceFromGlobalConfig) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig);
  }

  /**
   * Returns an OperationContext object merged with current object
   *
   * @param operationContext object with modifications
   * @return a merged object between passed argument and current object
   */
  public OperationContext withOperationContext(OperationContext operationContext) {
    OkHttpClient clientCloned = getClient();
    Config configCloned = getConfig();
    Object itemCloned = getItem();
    String resourceVersionCloned = getResourceVersion();
    String pluralCloned = getPlural();
    String apiGroupNameCloned = getApiGroupName();
    String apiGroupVersionCloned = getApiGroupVersion();
    String namespaceCloned = getNamespace();
    String nameCloned = getName();
    boolean cascadingCloned = getCascading();
    boolean reloadingFromServerCloned = getReloadingFromServer();
    boolean namespaceFromGlobalConfigCloned = isNamespaceFromGlobalConfig();
    long gracePeriodSecondsCloned = getGracePeriodSeconds();
    long watchRetryInitialBackoffMillis = getWatchRetryInitialBackoffMillis();
    double watchRetryBackoffMultiplier = getWatchRetryBackoffMultiplier();
    DeletionPropagation propagationPolicyCloned = getPropagationPolicy();
    Map<String, String> labelsCloned = getLabels();
    Map<String, String[]> labelsNotCloned = getLabelsNot();
    Map<String, String[]> labelsInCloned = getLabelsIn();
    Map<String, String[]> labelsNotInCloned = getLabelsNotIn();
    Map<String, String> fieldsCloned = getFields();
    Map<String, String[]> fieldsNotCloned = getFieldsNot();

    if (operationContext.getApiGroupVersion() != null) {
      apiGroupVersionCloned = operationContext.getApiGroupVersion();
    }

    if (operationContext.getClient() != null) {
      clientCloned = operationContext.getClient();
    }

    if (operationContext.getConfig() != null) {
      configCloned = operationContext.getConfig();
    }

    if (operationContext.getPlural() != null) {
      pluralCloned = operationContext.getPlural();
    }

    if (operationContext.getNamespace() != null) {
      namespaceCloned = operationContext.getNamespace();
    }

    if (operationContext.getName() != null) {
      nameCloned = operationContext.getName();
    }

    if (operationContext.getApiGroupName() != null) {
      apiGroupNameCloned = operationContext.getApiGroupName();
    }

    if (operationContext.getCascading()) {
      cascadingCloned = operationContext.getCascading();
    }

    if (operationContext.getItem() != null) {
      itemCloned = operationContext.getItem();
    }

    if (operationContext.getLabels() != null) {
      labelsCloned = operationContext.getLabels();
    }

    if (operationContext.getLabelsNot() != null) {
      labelsNotCloned = operationContext.getLabelsNot();
    }

    if (operationContext.getLabelsIn() != null) {
      labelsInCloned = operationContext.getLabelsIn();
    }

    if (operationContext.getLabelsNotIn() != null) {
      labelsNotInCloned = operationContext.getLabelsNotIn();
    }

    if (operationContext.getFields() != null) {
      fieldsCloned = operationContext.getFields();
    }

    if (operationContext.getFieldsNot() != null) {
      fieldsNotCloned = operationContext.getFieldsNot();
    }

    if (operationContext.getResourceVersion() != null) {
      resourceVersionCloned = operationContext.getResourceVersion();
    }

    if (operationContext.getReloadingFromServer()) {
      reloadingFromServerCloned = operationContext.getReloadingFromServer();
    }

    if (operationContext.getGracePeriodSeconds() > 0) {
      gracePeriodSecondsCloned = operationContext.getGracePeriodSeconds();
    }

    if (operationContext.getPropagationPolicy() != null) {
      propagationPolicyCloned = operationContext.getPropagationPolicy();
    }

    namespaceFromGlobalConfigCloned = operationContext.isNamespaceFromGlobalConfig();

    return new OperationContext(clientCloned, configCloned, pluralCloned, namespaceCloned, nameCloned, apiGroupNameCloned, apiGroupVersionCloned, cascadingCloned, itemCloned, labelsCloned, labelsNotCloned, labelsInCloned, labelsNotInCloned, fieldsCloned, fieldsNotCloned, resourceVersionCloned, reloadingFromServerCloned, gracePeriodSecondsCloned, propagationPolicyCloned, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfigCloned);
  }
}
