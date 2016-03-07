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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyList;
import io.fabric8.openshift.client.OpenShiftConfig;

public class PolicyOperationsImpl extends OpenShiftOperation<Policy, PolicyList, DoneablePolicy, ClientResource<Policy, DoneablePolicy>> {
  public PolicyOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1);
  }

  public PolicyOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, Policy item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds) {
    super(client, config, null, apiVersion, "policies", namespace, name, cascading, item, resourceVersion, reloadingFromServer, -1);
  }
}
