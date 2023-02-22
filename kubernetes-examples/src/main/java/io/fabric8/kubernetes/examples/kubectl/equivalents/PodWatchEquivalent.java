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
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * This sample code is Java equivalent to `kubectl get pods -w`. It watches
 * all the pods in specified namespace("default" in this case).
 */
public class PodWatchEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(PodWatchEquivalent.class.getSimpleName());

  public static void main(String[] args) {
    String namespace = "default";

    // Latch for Watch termination
    final CountDownLatch isWatchClosed = new CountDownLatch(1);
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      Watch watch = k8s.pods().inNamespace(namespace).watch(new Watcher<Pod>() {
        @Override
        public void eventReceived(Action action, Pod pod) {
          logger.info("{} {}", action.name(), pod.getMetadata().getName());
          switch (action) {
            case ADDED:
              logger.info("{} got added", pod.getMetadata().getName());
              break;
            case DELETED:
              logger.info("{} got deleted", pod.getMetadata().getName());
              break;
            case MODIFIED:
              logger.info("{} got modified", pod.getMetadata().getName());
              break;
            default:
              logger.error("Unrecognized event: {}", action.name());
          }
        }

        @Override
        public void onClose(WatcherException e) {
          logger.info("Closed");
          isWatchClosed.countDown();
        }
      });

      // Wait till watch gets closed
      isWatchClosed.await();
      watch.close();
    } catch (InterruptedException interruptedException) {
      logger.warn("Interrupted while waiting for the watch to close: {}", interruptedException.getMessage());
      Thread.currentThread().interrupt();
    }
  }
}
