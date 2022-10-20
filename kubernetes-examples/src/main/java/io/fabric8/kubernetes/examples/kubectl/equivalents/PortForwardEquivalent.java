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

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * This is Java equivalent for `kubectl port-forward my-pod 5000:6000`
 */
public class PortForwardEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(PortForwardEquivalent.class);

  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      CountDownLatch countDownLatch = new CountDownLatch(1);
      k8s.pods().inNamespace("default").withName("my-pod")
          .portForward(80, 8080); // (container port , localhost port)

      logger.info("Port forward open for 10 seconds");
      boolean latchTerminationStatus = countDownLatch.await(10, TimeUnit.SECONDS);
      if (!latchTerminationStatus) {
        logger.debug("latch terminated before it's count reaching zero");
      }
      logger.info("Closing port forward");
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      logger.warn("Interrupted while waiting for the port forward to be ready: {}", interruptedException.getMessage());
    }
  }
}
