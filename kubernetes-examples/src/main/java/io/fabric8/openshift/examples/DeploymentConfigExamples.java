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

import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeploymentConfigExamples {

  private static final Logger logger = LoggerFactory.getLogger(DeploymentConfigExamples.class);

  private static final String NAMESPACE = "this-is-a-test";
  private static final String IMAGE = "busybox";

  public static void main(String[] args) {
    try (KubernetesClient kubernetesClient = new KubernetesClientBuilder().build()) {
      final OpenShiftClient client = kubernetesClient.adapt(OpenShiftClient.class);

      final String project;
      if (client.getNamespace() != null) {
        project = client.getNamespace();
        logger.info("Using configured project: {}", project);
      } else {
        client.projectrequests().create(
            new ProjectRequestBuilder()
                .withNewMetadata()
                .withName(NAMESPACE)
                .endMetadata()
                .build());
        project = NAMESPACE;
        logger.info("Created project: {}", project);
      }

      ServiceAccount fabric8 = new ServiceAccountBuilder().withNewMetadata().withName("fabric8").endMetadata().build();

      client.serviceAccounts().inNamespace(project).resource(fabric8).createOrReplace();

      log("Created deployment", client.deploymentConfigs().inNamespace(project).resource(new DeploymentConfigBuilder()
          .withNewMetadata()
          .withName(IMAGE)
          .endMetadata()
          .withNewSpec()
          .withReplicas(1)
          .addNewTrigger()
          .withType("ConfigChange")
          .endTrigger()
          .addToSelector("app", IMAGE)
          .withNewTemplate()
          .withNewMetadata()
          .addToLabels("app", IMAGE)
          .endMetadata()
          .withNewSpec()
          .addNewContainer()
          .withName(IMAGE)
          .withImage(IMAGE)
          .addNewPort()
          .withContainerPort(80)
          .endPort()
          .endContainer()
          .endSpec()
          .endTemplate()
          .endSpec()
          .build()).createOrReplace());

      client.deploymentConfigs().inNamespace(project).withName(IMAGE).scale(2, true);
      log("Created pods:", client.pods().inNamespace(project).list().getItems());
      client.deploymentConfigs().inNamespace(project).withName(IMAGE).delete();
      log("Pods:", client.pods().inNamespace(project).list().getItems());
      log("Replication Controllers:", client.replicationControllers().inNamespace(project).list().getItems());

      log("Done.");
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
