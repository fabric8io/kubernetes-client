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
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class WaitUntilReadyExample {
  private static Logger logger = LoggerFactory.getLogger(WaitUntilReadyExample.class);

  public static void main(String args[]) throws IOException, InterruptedException {
    try (final KubernetesClient client = new DefaultKubernetesClient()) {
      Pod pod = new PodBuilder()
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
        .withCommand("sh", "-c", "echo 'inititalizing...'; sleep 5")
        .endInitContainer()
        .endSpec()
        .build();

      String namespace = "default";
      pod = client.pods().inNamespace(namespace).create(pod);
      log("Pod created, waiting for it to get ready");
      client.resource(pod).inNamespace(namespace).waitUntilReady(10, TimeUnit.SECONDS);
      log("Pod is ready now.");
      client.pods().inNamespace(namespace).withName(pod.getMetadata().getName()).watchLog(System.out);
      client.resource(pod).inNamespace(namespace).delete();
    }
    System.exit(0);
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
