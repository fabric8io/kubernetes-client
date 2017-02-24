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

  import io.fabric8.kubernetes.client.Callback;
  import io.fabric8.kubernetes.client.Config;
  import io.fabric8.kubernetes.client.ConfigBuilder;
  import io.fabric8.kubernetes.client.KubernetesClientException;
  import io.fabric8.kubernetes.client.dsl.ExecWatch;
  import io.fabric8.kubernetes.client.utils.InputStreamPumper;
  import io.fabric8.openshift.client.DefaultOpenShiftClient;
  import io.fabric8.openshift.client.OpenShiftClient;

  import java.io.IOException;
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;

/**
 * @Author: Angel Misevski (https://github.com/amisevsk).
 */
public class ExecLoopExample {

  public static void main(String[] args) throws InterruptedException, IOException {
    String master = "https://localhost:8443/";
    String podName = null;

    if (args.length == 2) {
      master = args[0];
      podName = args[1];
    }
    if (args.length == 1) {
      podName = args[0];
    }

    Config config = new ConfigBuilder().withMasterUrl(master).build();

      try (OpenShiftClient client = new DefaultOpenShiftClient(config)) {
        for (int i = 0; i < 10; System.out.println("i=" + i), i++) {
          ExecutorService executorService = Executors.newSingleThreadExecutor();
          try (ExecWatch watch = client.pods().withName(podName).redirectingOutput().exec("date");
               InputStreamPumper pump = new InputStreamPumper(watch.getOutput(), new SystemOutCallback())) {
              executorService.submit(pump);
              Thread.sleep(2000);
          } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
          } finally {
            executorService.shutdown();
          }
        }
      }
    System.out.println("Done.");
  }

  private static class SystemOutCallback implements Callback<byte[]> {
    @Override
    public void call(byte[] data) {
      System.out.print(new String(data));
    }
  }
}
