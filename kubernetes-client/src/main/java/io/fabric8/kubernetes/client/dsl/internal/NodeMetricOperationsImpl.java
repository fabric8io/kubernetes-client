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
import io.fabric8.kubernetes.client.Config;
import okhttp3.OkHttpClient;

public class NodeMetricOperationsImpl extends MetricOperationsImpl<NodeMetrics, NodeMetricsList> {
	public NodeMetricOperationsImpl(OkHttpClient client, Config config) {
		super(client, config, null, null, "nodes", null, NodeMetrics.class, NodeMetricsList.class);
	}

  /**
   * Get NodeMetric with specified name
   *
   * @param nodeName name of the node
   * @return NodeMetric fetched from ApiServer
   */
  public NodeMetrics metrics(String nodeName) {
	  return withName(nodeName).metric();
  }
}
