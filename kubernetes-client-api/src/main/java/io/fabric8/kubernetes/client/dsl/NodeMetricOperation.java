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

package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;

import java.util.Map;

public interface NodeMetricOperation
    extends MetricOperation<NodeMetrics, NodeMetricsList>, Nameable<NodeMetricOperation> {

  @Override
  NodeMetricOperation withLabels(Map<String, String> labels);

  /**
   * Get NodeMetric with specified name
   *
   * @param nodeName name of the node
   * @return NodeMetric fetched from ApiServer
   */
  NodeMetrics metrics(String nodeName);

}
