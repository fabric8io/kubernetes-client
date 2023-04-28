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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WaitUntilReadyExample {

  private static final Logger logger = LoggerFactory.getLogger(WaitUntilReadyExample.class);

  @SuppressWarnings("java:S106")
  public static void main(String[] args) throws InterruptedException {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      final String namespace = Optional.ofNullable(client.getNamespace()).orElse("default");
      final Pod pod = client.pods().inNamespace(namespace).resource(
          new PodBuilder()
              .withNewMetadata().withName("myapp-pod").withLabels(Collections.singletonMap("app", "myapp-pod")).endMetadata()
              .withNewSpec()
              .addNewContainer()
              .withName("myapp-container")
              .withImage("busybox:1.28")
              .withCommand("sh", "-c", "echo 'The app is running!'; sleep 10")
              .endContainer()
              .addNewInitContainer()
              .withName("init-myservice")
              .withImage("busybox:1.28")
              .withCommand("sh", "-c", "echo 'initializing...'; sleep 5")
              .endInitContainer()
              .endSpec()
              .build())
          .create();
      logger.info("Pod created, waiting for it to get ready...");
      client.resource(pod).inNamespace(namespace).waitUntilReady(10, TimeUnit.SECONDS);
      logger.info("Pod is ready now");
      final LogWatch lw = client.pods().inNamespace(namespace).withName(pod.getMetadata().getName()).watchLog(System.out);
      logger.info("Watching Pod logs for 10 seconds...");
      TimeUnit.SECONDS.sleep(10L);
      logger.info("Deleting Pod...");
      client.resource(pod).inNamespace(namespace).delete();
      logger.info("Closing Pod log watch");
      lw.close();
    }
  }
}
