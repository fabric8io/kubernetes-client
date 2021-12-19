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

import java.util.Map;

public interface MetricOperation<T, L> {

  String METRIC_ENDPOINT_URL = "apis/metrics.k8s.io/v1beta1/";

  MetricOperation<T, L> withName(String name);

  /**
   * Filter metrics via labels.
   *
   * @param labels labels as HashMap
   * @return {@link MetricOperation} with which you can call metrics() for getting filtered Metrics
   */
  MetricOperation<T, L> withLabels(Map<String, String> labels);

  /**
   * Get a list of metrics
   *
   * @return a list object for metrics
   */
  L metrics();

  /**
   * Get a single metric. name needs to be provided.
   *
   * @return a single metric
   */
  T metric();

  /**
   * Returns a list of metrics matching specified labels
   *
   * @param labelsMap labels as HashMap
   * @return list of metrics found matching provided label
   */
  L metrics(Map<String, Object> labelsMap);

}
