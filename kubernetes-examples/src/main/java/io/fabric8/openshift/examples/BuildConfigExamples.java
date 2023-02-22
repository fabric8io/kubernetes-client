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
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildRequestBuilder;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.WebHookTriggerBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildConfigExamples {

  private static final Logger logger = LoggerFactory.getLogger(BuildConfigExamples.class);

  private static final String NAMESPACE = "this-is-a-test";

  @SuppressWarnings("java:S106")
  public static void main(String[] args) throws InterruptedException {
    try (KubernetesClient kubernetesClient = new KubernetesClientBuilder().build()) {
      final OpenShiftClient client = kubernetesClient.adapt(OpenShiftClient.class);
      final String namespace;
      if (client.getNamespace() != null) {
        namespace = client.getNamespace();
        logger.info("Using configured namespace: {}", namespace);
      } else {
        final Namespace ns = client.namespaces().resource(
            new NamespaceBuilder().withNewMetadata().withName(NAMESPACE).addToLabels("this", "rocks").endMetadata().build())
            .create();
        namespace = ns.getMetadata().getName();
        logger.info("Created namespace: {}", namespace);
      }

      client.serviceAccounts().inNamespace(namespace).resource(
          new ServiceAccountBuilder().withNewMetadata().withName("fabric8").endMetadata().build())
          .create();

      final ImageStream is = client.imageStreams().inNamespace(namespace).resource(new ImageStreamBuilder()
          .withNewMetadata()
          .withName("example-camel-cdi")
          .endMetadata()
          .withNewSpec()
          .addNewTag()
          .withName("latest")
          .endTag()
          .withDockerImageRepository("fabric8/example-camel-cdi")
          .endSpec()
          .withNewStatus().withDockerImageRepository("").endStatus()
          .build())
          .create();
      logger.info("Created image stream: {}", is.getMetadata().getName());

      final String buildConfigName = "custom-build-config";
      final BuildConfig buildConfig = client.buildConfigs().inNamespace(namespace).resource(new BuildConfigBuilder()
          .withNewMetadata()
          .withName(buildConfigName)
          .endMetadata()
          .withNewSpec()
          .withServiceAccount("fabric8")
          .withNewSource()
          .withType("Git")
          .withNewGit()
          .withUri("https://github.com/fabric8io/example-camel-cdi.git")
          .endGit()
          .endSource()
          .withNewResources()
          .addToLimits("mykey", new Quantity("10"))
          .addToRequests("mykey", new Quantity("10"))
          .endResources()
          .withNewStrategy()
          .withType("Source")
          .withNewSourceStrategy()
          .withNewFrom().withName("java-sti:latest").withKind("DockerImage").endFrom()
          .endSourceStrategy()
          .endStrategy()
          .withNewOutput()
          .withNewTo().withKind("DockerImage").withName("example-camel-cdi:latest").endTo()
          .endOutput()
          .addNewTrigger()
          .withType("GitHub")
          .withNewGithub()
          .withSecret("secret101")
          .endGithub()
          .endTrigger()
          .endSpec()
          .build())
          .create();
      logger.info("Created Build Config: {}", buildConfig.getMetadata().getName());

      final Build build = client.buildConfigs().inNamespace(namespace).withName("custom-build-config")
          .instantiate(new BuildRequestBuilder()
              .withNewMetadata().withName(buildConfigName).endMetadata()
              .build());
      logger.info("Instantiated Build: {}", build.getMetadata().getName());

      client.buildConfigs().inNamespace(namespace).withName(buildConfigName)
          .withSecret("secret101")
          .withType("github")
          .trigger(new WebHookTriggerBuilder()
              .withSecret("secret101")
              .build());
      logger.info("Triggered Build Config: {}", buildConfigName);

      Thread.sleep(6000);

      logger.info("Builds:");
      for (Build b : client.builds().inNamespace(namespace).list().getItems()) {
        logger.info("\t\t\t{}", b.getMetadata().getName());

        logger.info("\t\t\t\t\t Log:");
        client.builds().inNamespace(namespace).withName(b.getMetadata().getName()).watchLog(System.out);
      }

      logger.info("Done");
    }
  }
}
