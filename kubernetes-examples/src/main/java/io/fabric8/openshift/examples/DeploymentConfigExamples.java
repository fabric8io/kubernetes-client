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

package io.fabric8.openshift.examples;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildRequestBuilder;
import io.fabric8.openshift.api.model.WebHookTriggerBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeploymentConfigExamples {
  private static final Logger logger = LoggerFactory.getLogger(DeploymentConfigExamples.class);

  public static void main(String[] args) throws InterruptedException {
    Config config = new ConfigBuilder().build();
    KubernetesClient kubernetesClient = new DefaultKubernetesClient(config);
    OpenShiftClient client = kubernetesClient.adapt(OpenShiftClient.class);

    try {
      // Create a namespace for all our stuff
      Namespace ns = new NamespaceBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks").endMetadata().build();
      log("Created namespace", client.namespaces().create(ns));

      ServiceAccount fabric8 = new ServiceAccountBuilder().withNewMetadata().withName("fabric8").endMetadata().build();

      client.serviceAccounts().inNamespace("thisisatest").create(fabric8);

      log("Created deployment", client.deploymentConfigs().inNamespace("thisisatest").createNew()
        .withNewMetadata()
          .withName("nginx")
        .endMetadata()
        .withNewSpec()
          .withReplicas(1)
          .addToSelector("app", "nginx")
          .withNewTemplate()
            .withNewMetadata()
              .addToLabels("app", "nginx")
            .endMetadata()
            .withNewSpec()
              .addNewContainer()
                .withName("nginx")
                .withImage("nginx")
                .addNewPort()
                  .withContainerPort(80)
                .endPort()
              .endContainer()
            .endSpec()
          .endTemplate()
        .endSpec()
        .done());


      client.deploymentConfigs().inNamespace("thisisatest").withName("nginx").scale(2, true);
      log("Created pods:", client.pods().inNamespace("thisisatest").list().getItems());
      client.deploymentConfigs().inNamespace("thisisatest").withName("nginx").scale(0);

      log("Done.");
    }finally {
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
