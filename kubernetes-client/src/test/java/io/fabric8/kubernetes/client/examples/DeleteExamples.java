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
package io.fabric8.kubernetes.client.examples;

import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteExamples {

  private static final Logger logger = LoggerFactory.getLogger(DeleteExamples.class);

  public static void main(String[] args) {
    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    DefaultKubernetesClient.Config config = new DefaultKubernetesClient.ConfigBuilder().masterUrl(master).build();
    OpenShiftClient client = new DefaultKubernetesClient(config);
    try {
      log("Create namespace:", client.namespaces().create(new NamespaceBuilder().withNewMetadata().withName("thisisatest").endMetadata().build()));
      log("Deleted namespace:", client.namespaces().withName("test").deleteIfExists());
      log("Deleted testPod:", client.pods().inNamespace("thisisatest").withName("testpod").deleteIfExists());
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } finally {
      client.namespaces().withName("thisisatest").delete();
      client.close();
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }

}
