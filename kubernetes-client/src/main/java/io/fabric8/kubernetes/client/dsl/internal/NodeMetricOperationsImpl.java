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

import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.NodeMetricOperation;

import java.util.Map;

public class NodeMetricOperationsImpl extends MetricOperationsImpl<NodeMetrics, NodeMetricsList>
    implements NodeMetricOperation {

  public NodeMetricOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  public NodeMetricOperationsImpl(OperationContext context) {
    super(context.withPlural("nodes"), NodeMetrics.class, NodeMetricsList.class);
  }

  @Override
  public NodeMetrics metrics(String nodeName) {
    return withName(nodeName).metric();
  }

  @Override
  public NodeMetricOperation withLabels(Map<String, String> labels) {
    return new NodeMetricOperationsImpl(context.withLabels(labels));
  }

  @Override
  public NodeMetricOperation withName(String name) {
    return new NodeMetricOperationsImpl(context.withName(name));
  }

  @Override
  public boolean isResourceNamespaced() {
    return false; // workaround until the class metadata is fixed
  }
}
