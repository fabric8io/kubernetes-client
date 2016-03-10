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

public class BuildConfigExamples {
  private static final Logger logger = LoggerFactory.getLogger(BuildConfigExamples.class);

  public static void main(String[] args) throws InterruptedException {
    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    Config config = new ConfigBuilder().build();
    KubernetesClient kubernetesClient = new DefaultKubernetesClient(config);
    OpenShiftClient client = kubernetesClient.adapt(OpenShiftClient.class);

    try {
      // Create a namespace for all our stuff
      Namespace ns = new NamespaceBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks").endMetadata().build();
      log("Created namespace", client.namespaces().create(ns));

      ServiceAccount fabric8 = new ServiceAccountBuilder().withNewMetadata().withName("fabric8").endMetadata().build();

      client.serviceAccounts().inNamespace("thisisatest").create(fabric8);

      log("Created image stream", client.imageStreams().inNamespace("thisisatest").createNew()
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
        .done());

      log("Created image stream", client.imageStreams().inNamespace("thisisatest").createNew()
        .withNewMetadata()
        .withName("java-sti")
        .endMetadata()
        .withNewSpec()
        .addNewTag()
        .withName("latest")
        .endTag()
        .withDockerImageRepository("fabric8/java-sti")
        .endSpec()
        .withNewStatus().withDockerImageRepository("").endStatus()
        .done());

      log("Created build config", client.buildConfigs().inNamespace("thisisatest").createNew()
        .withNewMetadata()
        .withName("custom-build-config")
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
        .done());

      client.buildConfigs().inNamespace("thisisatest").withName("custom-build-config").instantiate(new BuildRequestBuilder()
        .withNewMetadata().withName("custom-build-config").endMetadata()
        .build());

        client.buildConfigs().inNamespace("thisisatest").withName("custom-build-config")
          .withSecret("secret101")
          .withType("github")
          .trigger(new WebHookTriggerBuilder()
            .withSecret("secret101")
            .build());


      Thread.sleep(6000);

      log("Builds:");
      for (Build build: client.builds().inNamespace("thisisatest").list().getItems()) {
        log("\t\t\t"+build.getMetadata().getName());
      }


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
