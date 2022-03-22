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

import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.util.Optional;

public class TopExample {

  private static final Logger logger = LoggerFactory.getLogger(TopExample.class);

  private static final String CPU = "cpu";
  private static final String MEMORY = "memory";

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      if (!client.supports(NodeMetrics.class)) {
        logger.warn("Metrics API is not enabled in your cluster");
        return;
      }
      logger.info("==== Node Metrics  ====");
      client.top().nodes().metrics().getItems().forEach(nodeMetrics -> logger.info("{}\tCPU: {}{}\tMemory: {}{}",
          nodeMetrics.getMetadata().getName(),
          nodeMetrics.getUsage().get(CPU).getAmount(), nodeMetrics.getUsage().get(CPU).getFormat(),
          nodeMetrics.getUsage().get(MEMORY).getAmount(), nodeMetrics.getUsage().get(MEMORY).getFormat()));

      final String namespace = Optional.ofNullable(client.getNamespace()).orElse("default");
      logger.info("==== Pod Metrics ====");
      client.top().pods().metrics(namespace).getItems()
          .forEach(podMetrics -> podMetrics.getContainers()
              .forEach(containerMetrics -> logger.info("{}\t{}\tCPU: {}{}\tMemory: {}{}",
                  podMetrics.getMetadata().getName(), containerMetrics.getName(),
                  containerMetrics.getUsage().get(CPU).getAmount(), containerMetrics.getUsage().get(CPU).getFormat(),
                  containerMetrics.getUsage().get(MEMORY).getAmount(), containerMetrics.getUsage().get(MEMORY).getFormat())));

      client.pods().inNamespace(namespace).list().getItems().stream().findFirst().map(pod -> {
        logger.info("==== Individual Pod Metrics ({}) ====", pod.getMetadata().getName());
        try {
          return client.top().pods().metrics(namespace, pod.getMetadata().getName());
        } catch (KubernetesClientException ex) {
          if (ex.getCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            logger.info(" - Pod has not reported any metrics yet");
          } else {
            logger.warn(" - Error retrieving Pod metrics: {}", ex.getMessage());
          }
          return null;
        }
      }).ifPresent(podMetrics -> podMetrics.getContainers()
          .forEach(containerMetrics -> logger.info("{}\t{}\tCPU: {}{}\tMemory: {}{}",
              podMetrics.getMetadata().getName(), containerMetrics.getName(),
              containerMetrics.getUsage().get(CPU).getAmount(), containerMetrics.getUsage().get(CPU).getFormat(),
              containerMetrics.getUsage().get(MEMORY).getAmount(), containerMetrics.getUsage().get(MEMORY).getFormat())));

    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
