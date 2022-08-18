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

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * This is an example of attaching to pod to access stdin, stdout, stderr
 */
public class AttachExample {

  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      System.out.println("Usage: podName [namespace]");
      return;
    }

    String podName = args[0];
    String namespace = "default";

    if (args.length > 1) {
      namespace = args[1];
    }

    CompletableFuture<Void> sessionFuture = new CompletableFuture<>();
    try (
        KubernetesClient client = new KubernetesClientBuilder().build();
        ExecWatch watch = attach(client, namespace, podName, sessionFuture)) {
      System.out.println("Type 'exit' to detach");
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      while (true) {
        String input = reader.readLine();
        if (input.equals("exit")) {
          return;
        }
        watch.getInput().write((input + "\n").getBytes(StandardCharsets.UTF_8));
        watch.getInput().flush();
        if (sessionFuture.isDone()) {
          System.out.println("Session closed");
          return;
        }
      }
    }
  }

  private static ExecWatch attach(KubernetesClient client, String namespace, String podName,
      CompletableFuture<Void> sessionFuture) {
    return client.pods().inNamespace(namespace).withName(podName)
        .redirectingInput()
        .writingOutput(System.out)
        .writingError(System.err)
        .withTTY()
        .usingListener(new ExecListener() {
          @Override
          public void onFailure(Throwable t, Response failureResponse) {
            sessionFuture.complete(null);
          }

          @Override
          public void onClose(int code, String reason) {
            sessionFuture.complete(null);
          }
        })
        .attach();
  }
}
