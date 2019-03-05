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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import okhttp3.Response;

public class ExecExampleWithTerminalSize {

    public static void main(String[] args) throws InterruptedException {
        if (args.length < 1) {
            System.out.println("Usage: podName [master] [namespace] [columns] [lines]\n" +
              "Use env variable COLUMNS & LINES to initialize terminal size.");
            return;
          }

        String podName = args[0];
        String namespace = "default";
        String master = "https://localhost:8443/";
        String columns = "80";
        String lines = "24";

        if (args.length > 1) {
            master = args[1];
          }
          if (args.length > 2) {
            namespace = args[2];
            if (args.length > 3) {
              columns = args[3];
              if (args.length > 4) {
                lines = args[4];
              }
            }
          }

        Config config = new ConfigBuilder().withMasterUrl(master).build();
        try (final KubernetesClient client = new DefaultKubernetesClient(config);
             ExecWatch watch = client.pods().inNamespace(namespace).withName(podName)
                .readingInput(System.in)
                .writingOutput(System.out)
                .writingError(System.err)
                .withTTY()
                .usingListener(new SimpleListener())
                .exec("env", "TERM%3Dxterm", "COLUMNS%3D" + columns, "LINES%3D" + lines, "bash")){

            Thread.sleep(10 * 1000);
        }
    }

    private static class SimpleListener implements ExecListener {

        @Override
        public void onOpen(Response response) {
            System.out.println("The shell will remain open for 10 seconds.");
        }

        @Override
        public void onFailure(Throwable t, Response response) {
            System.err.println("shell barfed");
        }

        @Override
        public void onClose(int code, String reason) {
            System.out.println("The shell will now close.");
        }
    }

}
