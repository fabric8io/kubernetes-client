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
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.metrics.v1beta1.ContainerMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TopExample {

  private static final Logger logger = LoggerFactory.getLogger(TopExample.class);

  public static void main(String[] args) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      NodeMetricsList nodeMetricList = client.top().nodes().metrics();

      log("name CPU(cores) CPU(%) Memory(Bytes) Memory(%)");
      for (NodeMetrics nodeMetrics : nodeMetricList.getItems()) {
        log(nodeMetrics.getMetadata().getName() +
          " " + nodeMetrics.getUsage().get("cpu") +
          " " + nodeMetrics.getUsage().get("memory"));
      }

      log("==== Pod Metrics ====");
      log("name CPU(cores) CPU(%) Memory(Bytes) Memory(%)");
      PodMetricsList podMetricsList = client.top().pods().metrics("default");
      for (PodMetrics podMetrics : podMetricsList.getItems()) {
        log(podMetrics.getMetadata().getName());

        List<ContainerMetrics> containerMetricsList = podMetrics.getContainers();
        for(ContainerMetrics containerMetric :  containerMetricsList) {
          log(podMetrics.getMetadata().getName() +
            " " + containerMetric.getUsage().get("cpu") +
            " " + containerMetric.getUsage().get("memory"));
        }
      }

      PodMetrics podMetrics = client.top().pods().metrics("default", "nginx-deployment-54f57cf6bf-gcvzx");
      log(" ===== Individual Pod Metrics =====");
      log("Pod Name: " + podMetrics.getMetadata().getName());
      List<ContainerMetrics> containerMetricsList = podMetrics.getContainers();
      for(ContainerMetrics containerMetric :  containerMetricsList) {
        log(podMetrics.getMetadata().getName() +
          " " + containerMetric.getUsage().get("cpu") +
          " " + containerMetric.getUsage().get("memory"));
      }

    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } finally {
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
