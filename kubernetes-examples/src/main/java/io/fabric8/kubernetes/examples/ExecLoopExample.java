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
import io.fabric8.kubernetes.client.utils.InputStreamPumper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Angel Misevski (https://github.com/amisevsk).
 */
@SuppressWarnings("java:S106")
public class ExecLoopExample {

  public static void main(String[] args) throws InterruptedException {
    if (args.length == 0) {
      System.out.println("Usage: podName [namespace]");
      return;
    }

    final String podName = args[0];
    String namespace = "default";

    if (args.length > 1) {
      namespace = args[1];
    }

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(20);
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      for (int i = 0; i < 10; System.out.println("i=" + i), i++) {
        ExecWatch watch = null;
        CompletableFuture<?> pump = null;
        final CountDownLatch latch = new CountDownLatch(1);
        watch = client.pods().inNamespace(namespace).withName(podName).redirectingOutput().usingListener(new ExecListener() {
          @Override
          public void onOpen() {
            System.out.println("Open");
          }

          @Override
          public void onFailure(Throwable t, Response failureResponse) {
            latch.countDown();
          }

          @Override
          public void onClose(int code, String reason) {
            latch.countDown();
          }
        }).exec("date");
        pump = InputStreamPumper.pump(watch.getOutput(), (b, o, l) -> System.out.print(new String(b, o, l)),
            executorService);
        executorService.scheduleAtFixedRate(new FutureChecker("Pump " + (i + 1), pump), 0, 2, TimeUnit.SECONDS);

        latch.await(5, TimeUnit.SECONDS);
        watch.close();
        pump.cancel(true);

      }
    }
    executorService.shutdown();
    System.out.println("Done.");
  }

  private static class FutureChecker implements Runnable {
    private final String name;
    private final Future<?> future;

    private FutureChecker(String name, Future<?> future) {
      this.name = name;
      this.future = future;
    }

    @Override
    public void run() {
      if (!future.isDone()) {
        System.out.println("Future:[" + name + "] is not done yet");
      }
    }
  }
}
