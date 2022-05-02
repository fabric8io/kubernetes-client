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

@SuppressWarnings("java:S106")
public class ExecExampleWithTerminalSize {

  public static void main(String[] args) throws InterruptedException {
    if (args.length < 1) {
      System.out.println("Usage: podName [namespace] [columns] [lines]\n" +
          "Use env variable COLUMNS & LINES to initialize terminal size.");
      return;
    }

    String podName = args[0];
    String namespace = "default";
    String columns = "80";
    String lines = "24";

    if (args.length > 1) {
      namespace = args[1];
    }
    if (args.length > 2) {
      columns = args[2];
    }
    if (args.length > 3) {
      lines = args[3];
    }

    try (
        KubernetesClient client = new KubernetesClientBuilder().build();
        ExecWatch exec = newExecWatch(client, namespace, podName, columns, lines);) {
      exec.exitCode().join();
    }
  }

  private static ExecWatch newExecWatch(KubernetesClient client, String namespace, String podName, String columns,
      String lines) {
    return client.pods().inNamespace(namespace).withName(podName)
        .writingOutput(System.out)
        .writingError(System.err)
        .withTTY()
        .usingListener(new SimpleListener())
        .exec("env", "TERM=xterm", "COLUMNS=" + columns, "LINES=" + lines, "sh", "-c", "ls -la");
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
