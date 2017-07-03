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

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.DoneableCustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.TreeMap;

/**
 */
public class CustomResourceDefinitionOperationsImpl extends HasMetadataOperation<CustomResourceDefinition, CustomResourceDefinitionList, DoneableCustomResourceDefinition,
    Resource<CustomResourceDefinition, DoneableCustomResourceDefinition>> {
  public CustomResourceDefinitionOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null, null, null, null, null, false, null, "v1beta1", false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public CustomResourceDefinitionOperationsImpl(OkHttpClient client, Config config, String resourceT, String namespace, String name, Boolean cascading, CustomResourceDefinition item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, null, null, null, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  public CustomResourceDefinitionOperationsImpl(OkHttpClient client, Config config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, CustomResourceDefinition item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, notBlank(apiGroup, "apiextensions.k8s.io"), notBlank(apiVersion, "v1beta1"), notBlank(resourceT, "customresourcedefinitions"), namespace, name, cascading, item, notBlank(resourceVersion, "v1beta1"), reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  @Override
  public boolean isResourceNamespaced() {
      return false;
  }

  private static final String notBlank(String value, String defaultValue) {
    return (value != null && !value.isEmpty()) ? value : defaultValue;
  }

}
