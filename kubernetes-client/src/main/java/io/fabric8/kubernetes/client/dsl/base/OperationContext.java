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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

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

  protected long gracePeriodSeconds;

  protected Map<String, String> labels;
  protected Map<String, String> labelsNot;
  protected Map<String, String[]> labelsIn;
  protected Map<String, String[]> labelsNotIn;
  protected Map<String, String> fields;


  public OperationContext() {
  }

  public OperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, String resourceVersion, boolean reloadingFromServer, long gracePeriodSeconds) {
    this.client = client;
    this.config = config;
    this.plural = plural;
    this.namespace = Utils.isNotNullOrEmpty(namespace) ? namespace : (config != null ? config.getNamespace() : null);
    this.name = name;
    this.cascading = cascading;
    this.labels = labels != null ? labels : new HashMap<>();
    this.labelsNot = labelsNot != null ? labelsNot : new HashMap<>();
    this.labelsIn = labelsIn != null ? labelsIn : new HashMap<>();
    this.labelsNotIn = labelsNotIn != null ? labelsNotIn : new HashMap<>();
    this.fields = fields != null ? fields : new HashMap<>();
    this.resourceVersion = resourceVersion;
    this.reloadingFromServer = reloadingFromServer;
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.item = item;
    this.apiGroupName =  ApiVersionUtil.apiGroup(item, apiGroupName);
    this.apiGroupVersion = ApiVersionUtil.apiVersion(item, apiGroupVersion);
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

  public Map<String, String> getLabelsNot() {
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

  public String getResourceVersion() {
    return resourceVersion;
  }

  public boolean getReloadingFromServer() {
    return reloadingFromServer;
  }

  public long getGracePeriodSeconds() {
    return gracePeriodSeconds;
  }


  public OperationContext withOkhttpClient(OkHttpClient client) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withConfig(Config config) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withPlural(String plural) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withNamespace(String namespace) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withName(String name) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }


  public OperationContext withApiGroupName(String apiGroupName) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withApiGroupVersion(String apiGroupVersion) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withItem(Object item) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withCascading(boolean cascading) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withLabels(Map<String, String> labels) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withLabelsNot(Map<String, String> labelsNot) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withFields(Map<String, String> fields) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withResourceVersion(String resourceVersion) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  public OperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new OperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }
}
