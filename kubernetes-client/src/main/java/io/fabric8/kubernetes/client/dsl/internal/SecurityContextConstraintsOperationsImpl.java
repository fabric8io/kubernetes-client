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

import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.TreeMap;

public class SecurityContextConstraintsOperationsImpl  extends HasMetadataOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, Resource<SecurityContextConstraints, DoneableSecurityContextConstraints>> {
  public SecurityContextConstraintsOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null, null, null, true, null, null, false);
  }

  public SecurityContextConstraintsOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, SecurityContextConstraints item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, null, apiVersion, "securitycontextconstraints", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  public SecurityContextConstraintsOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, SecurityContextConstraints item, String resourceVersion, Boolean reloadingFromServer) {
    super(client, config, null, apiVersion, "securitycontextconstraints", namespace, name, cascading, item, resourceVersion, reloadingFromServer, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
