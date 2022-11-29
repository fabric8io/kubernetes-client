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

import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;

import java.util.Map;

public interface PodMetricOperation extends MetricOperation<PodMetrics, PodMetricsList>, Nameable<PodMetricOperation>,
    Namespaceable<PodMetricOperation> {

  @Override
  PodMetricOperation withLabels(Map<String, String> labels);

  /**
   * Get PodMetricsList for a namespace.
   *
   * @param namespace namespace for which PodMetrics are queries
   * @return PodMetricsList for all pods in specified namespace
   */
  PodMetricsList metrics(String namespace);

  /**
   * Get PodMetrics in a namespace with a name.
   *
   * @param namespace namespace of pod
   * @param podName name of pod
   * @return PodMetric corresponding to specified Pod
   */
  PodMetrics metrics(String namespace, String podName);

}
