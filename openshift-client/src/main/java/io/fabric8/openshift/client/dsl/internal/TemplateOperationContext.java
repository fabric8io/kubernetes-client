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

import java.util.Map;

public class TemplateOperationContext extends OperationContext {

  private Map<String, String> parameters;

  public TemplateOperationContext() {
  }

  public TemplateOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, Boolean cascading, Object item, Map<String, String> labels, Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, DeletionPropagation propagationPolicy, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean namespaceFromGlobalConfig, Map<String, String> parameters, boolean dryRun) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, dryRun);
    this.parameters = parameters;
  }

  public Map<String, String> getParameters() {
    return parameters;
  }

  public TemplateOperationContext withOkhttpClient(OkHttpClient client) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withConfig(Config config) {
    return new TemplateOperationContext(client, OpenShiftConfig.wrap(config), plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withPlural(String plural) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withNamespace(String namespace) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withName(String name) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }


  public TemplateOperationContext withApiGroupName(String apiGroupName) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  @Override
  public TemplateOperationContext withItem(Object item) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withCascading(boolean cascading) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withLabels(Map<String, String> labels) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withFields(Map<String, String> fields) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withResourceVersion(String resourceVersion) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  public TemplateOperationContext withParameters(Map<String, String> parameters) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }

  @Override
  public TemplateOperationContext withDryRun(boolean dryRun) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, namespaceFromGlobalConfig, parameters, dryRun);
  }
}
