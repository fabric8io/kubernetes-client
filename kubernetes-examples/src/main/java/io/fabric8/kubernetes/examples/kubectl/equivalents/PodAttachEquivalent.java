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
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * This sample code is Java equivalent to `kubectl attach my-pod`. It assumes that
 * a Pod with specified name exists in the cluster.
 */
public class PodAttachEquivalent {

  private static final Logger logger = LoggerFactory.getLogger(PodAttachEquivalent.class);

  public static void main(String[] args) throws IOException {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      MyAttachListener listener = new MyAttachListener();
      ExecWatch watch = client.pods().inNamespace("default").withName("my-pod")
          .redirectingInput()
          .writingOutput(System.out)
          .writingError(System.err)
          .withTTY()
          .usingListener(listener)
          .attach();

      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      while (!listener.getSessionCompletionFuture().isDone()) {
        String input = reader.readLine();
        watch.getInput().write((input + "\n").getBytes(StandardCharsets.UTF_8));
        watch.getInput().flush();
      }

      watch.close();
    }
  }

  private static class MyAttachListener implements ExecListener {

    @Getter
    private final CompletableFuture<Void> sessionCompletionFuture = new CompletableFuture<>();

    @Override
    public void onOpen() {
      logger.info("Attached to the pod");
    }

    @Override
    public void onFailure(Throwable t, Response failureResponse) {
      logger.warn("Error encountered", t);
      sessionCompletionFuture.complete(null);
    }

    @Override
    public void onClose(int i, String s) {
      logger.info("Session closed");
      sessionCompletionFuture.complete(null);
    }
  }
}
