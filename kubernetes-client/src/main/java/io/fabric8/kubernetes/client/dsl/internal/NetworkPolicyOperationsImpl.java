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

import io.fabric8.kubernetes.client.dsl.Resource;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.extensions.DoneableNetworkPolicy;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicy;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicyList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

import java.util.Map;
import java.util.TreeMap;

public class NetworkPolicyOperationsImpl extends HasMetadataOperation<NetworkPolicy, NetworkPolicyList, DoneableNetworkPolicy, Resource<NetworkPolicy, DoneableNetworkPolicy>>{

  public NetworkPolicyOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(client, config, "v1beta1", namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public NetworkPolicyOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, NetworkPolicy item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, "extensions", apiVersion, "networkpolicies", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }
}
