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
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.LocalPortForward;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class PortForwardExample {

  private static final Logger logger = LoggerFactory.getLogger(PortForwardExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      String namespace = "default";
      logger.info("Using namespace: {}", namespace);
      Pod pod = client.pods().inNamespace(namespace)
          .load(PortForwardExample.class.getResourceAsStream("/portforward-example-pod.yml")).item();
      final String podName = pod.getMetadata().getName();
      client.pods().inNamespace(namespace).resource(pod).create();
      logger.info("Pod {} created", podName);

      int containerPort = pod.getSpec().getContainers().get(0).getPorts().get(0).getContainerPort();
      client.pods().inNamespace(namespace).withName(podName).waitUntilReady(10, TimeUnit.SECONDS);

      InetAddress inetAddress = InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 });
      LocalPortForward portForward = client.pods().inNamespace("default").withName("testpod").portForward(containerPort,
          inetAddress, 8080);
      logger.info("Port forwarded for 60 seconds at http://127.0.0.1:{}", portForward.getLocalPort());

      logger.info("Checking forwarded port:-");
      final ResponseBody responseBody = new OkHttpClient()
          .newCall(new Request.Builder().get().url("http://127.0.0.1:" + portForward.getLocalPort()).build()).execute()
          .body();
      logger.info("Response: \n{}", responseBody != null ? responseBody.string() : "[Empty Body]");
      Thread.sleep(60 * 1000L);
      logger.info("Closing forwarded port");
      portForward.close();
    } catch (Exception e) {
      logger.error("Exception occurred: {}", e.getMessage(), e);
    }
  }
}
