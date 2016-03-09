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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.DoneableNode;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

public class NodeOperationsImpl extends HasMetadataOperation<Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> {

  public NodeOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null, null, null, true, null, null, false, -1);
  }

  public NodeOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Node item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds) {
    super(client, config, null, apiVersion, "nodes", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
