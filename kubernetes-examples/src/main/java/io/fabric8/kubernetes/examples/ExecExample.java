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

/**
 * This is an example of entering a pod to execute a command.
 */
@SuppressWarnings("java:S106")
public class ExecExample {

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Usage: podName [namespace]");
      return;
    }

    String podName = args[0];
    String namespace = "default";

    if (args.length > 1) {
      namespace = args[1];
    }

    try (
        KubernetesClient client = new KubernetesClientBuilder().build();
        ExecWatch watch = newExecWatch(client, namespace, podName)) {
      watch.exitCode().join();
    }
  }

  private static ExecWatch newExecWatch(KubernetesClient client, String namespace, String podName) {
    return client.pods().inNamespace(namespace).withName(podName)
        .writingOutput(System.out)
        .writingError(System.err)
        .withTTY()
        .usingListener(new SimpleListener())
        .exec("sh", "-c", "echo 'Hello world!'");
  }

  private static class SimpleListener implements ExecListener {

    @Override
    public void onOpen() {
      System.out.println("The shell will remain open for 10 seconds.");
    }

    @Override
    public void onFailure(Throwable t, Response failureResponse) {
      System.err.println("shell barfed");
    }

    @Override
    public void onClose(int code, String reason) {
      System.out.println("The shell will now close.");
    }
  }

}
