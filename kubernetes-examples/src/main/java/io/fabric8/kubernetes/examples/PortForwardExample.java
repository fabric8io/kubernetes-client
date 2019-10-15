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
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.LocalPortForward;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class PortForwardExample {
  private static final Logger logger = LoggerFactory.getLogger(PortForwardExample.class);

  public static void main(String args[]) {
    String master = "https://localhost:8443";

    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
      String namespace = "default";
      log("namespace", namespace);
      Pod pod = client.pods().inNamespace(namespace).load(PortForwardExample.class.getResourceAsStream("/portforward-example-pod.yml")).get();
      client.pods().inNamespace(namespace).create(pod);
      log("Pod created");

      int containerPort =  pod.getSpec().getContainers().get(0).getPorts().get(0).getContainerPort();
      client.pods().inNamespace(namespace).withName("testpod").waitUntilReady(10, TimeUnit.SECONDS);

      LocalPortForward portForward = client.pods().inNamespace("default").withName("testpod").portForward(containerPort, 8080);
      log("Port forwarded for 60 seconds at http://127.0.0.1:" + portForward.getLocalPort());

      log("Checking forwarded port:-");
      Response response =  new OkHttpClient().newCall(new Request.Builder().get().url("http://127.0.0.1:" + portForward.getLocalPort()).build()).execute();
      log(response.body().string());
      Thread.sleep(60 * 1000);
    } catch (Exception e) {
      log("Exception occurred: ", e.getMessage());
      e.printStackTrace();
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
