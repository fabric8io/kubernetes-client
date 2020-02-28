/**
 * Copyright (C) 2015 Fabric8 Authors.
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

public class TemplateOperationContext extends OperationContext {

  private Map<String, String> parameters;

  public TemplateOperationContext() {
  }

  public TemplateOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, Boolean cascading, Object item, Map<String, String> labels, Map<String, String[]> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, Map<String, String[]> fieldsNot, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, String propagationPolicy, Map<String, String> parameters) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot, resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy);
    this.parameters = parameters;
  }

  public Map<String, String> getParameters() {
    return parameters;
  }

  public TemplateOperationContext withOkhttpClient(OkHttpClient client) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withConfig(Config config) {
    return new TemplateOperationContext(client, OpenShiftConfig.wrap(config), plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withPlural(String plural) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withNamespace(String namespace) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withName(String name) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }


  public TemplateOperationContext withApiGroupName(String apiGroupName) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  @Override
  public TemplateOperationContext withItem(Object item) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withCascading(boolean cascading) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withLabels(Map<String, String> labels) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withLabelsNot(Map<String, String[]> labelsNot) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withFields(Map<String, String> fields) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withFieldsNot(Map<String, String[]> fieldsNot) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withResourceVersion(String resourceVersion) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withPropagationPolicy(String propagationPolicy) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }

  public TemplateOperationContext withParameters(Map<String, String> parameters) {
    return new TemplateOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, fieldsNot,resourceVersion, reloadingFromServer, gracePeriodSeconds, propagationPolicy, parameters);
  }
}
