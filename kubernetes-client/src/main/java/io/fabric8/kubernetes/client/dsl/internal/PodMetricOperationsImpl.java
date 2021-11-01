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

import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.http.HttpClient;

public class PodMetricOperationsImpl extends MetricOperationsImpl<PodMetrics, PodMetricsList> implements Namespaceable<PodMetricOperationsImpl> {
  public PodMetricOperationsImpl(HttpClient client, Config config) {
    super(client, config, null, null, "pods", null, PodMetrics.class, PodMetricsList.class);
  }

  private PodMetricOperationsImpl(HttpClient client, Config config, String name, String namespace) {
    super(client, config, name, namespace, "pods", null, PodMetrics.class, PodMetricsList.class);
  }

  /**
   * Get PodMetrics in a namespace with a name.
   *
   * @param namespace namespace of pod
   * @param podName name of pod
   * @return PodMetric corresponding to specified Pod
   */
  public PodMetrics metrics(String namespace, String podName) {
    return inNamespace(namespace).withName(podName).metric();
  }

  /**
   * Get PodMetricsList for a namespace.
   *
   * @param namespace namespace for which PodMetrics are queries
   * @return PodMetricsList for all pods in specified namespace
   */
  public PodMetricsList metrics(String namespace) {
    return inNamespace(namespace).metrics();
  }

  @Override
  public PodMetricOperationsImpl inNamespace(String namespace) {
    return new PodMetricOperationsImpl(client, config, null, namespace);
  }
}
