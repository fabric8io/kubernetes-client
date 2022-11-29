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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * Java equivalent of `kubectl get pods --sort-by='.status.containerStatuses[0].restartCount'`. List pods Sorted by
 * Creation Timestamp
 */
public class PodSortByCreationTimestamp {
  private static final Logger logger = LoggerFactory.getLogger(PodSortByCreationTimestamp.class);

  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      List<Pod> podList = k8s.pods().inNamespace("default").list().getItems();

      // In kubectl sorting is done on client side; so we can sort list by ourselves in latest to oldest pod
      podList.sort((o1, o2) -> {
        long o1Timestamp = Instant.parse(o1.getMetadata().getCreationTimestamp()).getEpochSecond();
        long o2Timestamp = Instant.parse(o2.getMetadata().getCreationTimestamp()).getEpochSecond();
        return (int) (o2Timestamp - o1Timestamp);
      });

      // Check if list is sorted
      for (Pod pod : podList) {
        logger.info("{} : {} minutes old", pod.getMetadata().getName(),
            Duration.between(Instant.now(), Instant.parse(pod.getMetadata().getCreationTimestamp())).toMinutes());
      }
    }
  }
}
