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
  import io.fabric8.kubernetes.client.dsl.ExecListener;
  import io.fabric8.kubernetes.client.dsl.ExecWatch;
  import io.fabric8.kubernetes.client.utils.InputStreamPumper;
  import io.fabric8.openshift.client.DefaultOpenShiftClient;
  import io.fabric8.openshift.client.OpenShiftClient;
  import okhttp3.Response;

  import java.io.IOException;
  import java.util.concurrent.CountDownLatch;
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;
  import java.util.concurrent.Future;
  import java.util.concurrent.ScheduledExecutorService;
  import java.util.concurrent.TimeUnit;

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

      Config config = new ConfigBuilder()
        .withMasterUrl(master)
        .build();

      ScheduledExecutorService executorService = Executors.newScheduledThreadPool(20);
      try (OpenShiftClient client = new DefaultOpenShiftClient(config)) {
        for (int i = 0; i < 10; System.out.println("i=" + i), i++) {
          ExecWatch watch = null;
          InputStreamPumper pump = null;
          final CountDownLatch latch = new CountDownLatch(1);
          watch = client.pods().withName(podName).redirectingOutput().usingListener(new ExecListener() {
            @Override
            public void onOpen(Response response) {
            }

            @Override
            public void onFailure(Throwable t, Response response) {
              latch.countDown();
            }

            @Override
            public void onClose(int code, String reason) {
              latch.countDown();
            }
          }).exec("date");
          pump = new InputStreamPumper(watch.getOutput(), new SystemOutCallback());
          executorService.submit(pump);
          Future<String> outPumpFuture = executorService.submit(pump, "Done");
          executorService.scheduleAtFixedRate(new FutureChecker("Pump " + (i + 1), outPumpFuture), 0, 2, TimeUnit.SECONDS);

          latch.await(5, TimeUnit.SECONDS);
          //We need to wait or the pumper (ws -> System.out) will not be able to print the message.
          //Thread.sleep(1000);
          watch.close();
          pump.close();

        }
      }

    executorService.shutdown();
    System.out.println("Done.");
  }

  private static class SystemOutCallback implements Callback<byte[]> {
    @Override
    public void call(byte[] data) {
      System.out.print(new String(data));
    }
  }

  private static class FutureChecker implements Runnable {
    private final String name;
    private final Future<String> future;

    private FutureChecker(String name, Future<String> future) {
      this.name = name;
      this.future = future;
    }

    @Override
    public void run() {
      if(!future.isDone()) {
        System.out.println("Future:[" + name + "] is not done yet");
      }
    }
  }
}
