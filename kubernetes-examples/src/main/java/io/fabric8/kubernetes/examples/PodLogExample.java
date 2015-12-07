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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PodLogExample {

  private static final Logger logger = LoggerFactory.getLogger(PodLogExample.class);

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Usage: podName [master] [namespace]");
      return;
    }
    String podName = args[0];
    String namespace = "default";
    String master = "https://localhost:8443/";

    if (args.length > 1) {
      master = args[1];
    }
    if (args.length > 2) {
      namespace = args[2];
    }

    System.out.println("Log of pod " + podName + " in " + namespace + " is:");
    System.out.println("----------------------------------------------------------------");

    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (KubernetesClient client = new DefaultKubernetesClient(config);
         LogWatch watch = client.pods().inNamespace(namespace).withName(podName).tailingLines(10).watchLog(System.out)) {
      Thread.sleep(5 * 1000);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }
}
