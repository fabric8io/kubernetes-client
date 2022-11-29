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
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * This sample code is Java equivalent to `kubectl exec my-pod -- ls /`. It assumes that
 * a Pod with specified name exists in the cluster.
 */
public class PodExecEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(PodExecEquivalent.class);
  private static final CountDownLatch execLatch = new CountDownLatch(1);

  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ByteArrayOutputStream error = new ByteArrayOutputStream();

      ExecWatch execWatch = k8s.pods().inNamespace("default").withName("my-pod")
          .writingOutput(out)
          .writingError(error)
          .usingListener(new MyPodExecListener())
          .exec("ls", "/");

      boolean latchTerminationStatus = execLatch.await(5, TimeUnit.SECONDS);
      if (!latchTerminationStatus) {
        logger.warn("Latch could not terminate within specified time");
      }
      logger.info("Exec Output: {} ", out);
      execWatch.close();
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      logger.warn("Interrupted while waiting for the exec: {}", ie.getMessage());
    }
  }

  private static class MyPodExecListener implements ExecListener {
    @Override
    public void onOpen() {
      logger.info("Shell was opened");
    }

    @Override
    public void onFailure(Throwable t, Response failureResponse) {
      logger.info("Some error encountered");
      execLatch.countDown();
    }

    @Override
    public void onClose(int i, String s) {
      logger.info("Shell Closing");
      execLatch.countDown();
    }
  }
}
