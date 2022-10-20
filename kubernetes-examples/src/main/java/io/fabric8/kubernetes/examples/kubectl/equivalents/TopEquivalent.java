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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example is Java equivalent of getting Node metrics via kubectl: `kubectl top node `
 */
public class TopEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(TopEquivalent.class);

  public static void main(String[] args) {
    try (KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      NodeMetricsList nodeMetricsList = k8s.top().nodes().metrics();

      for (NodeMetrics nodeMetrics : nodeMetricsList.getItems()) {
        logger.info("{} {} {}", nodeMetrics.getMetadata().getName(),
            nodeMetrics.getUsage().get("cpu"),
            nodeMetrics.getUsage().get("memory"));
      }
    }
  }
}
