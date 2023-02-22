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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullExample {

  private static final Logger logger = LoggerFactory.getLogger(FullExample.class);

  public static void main(String[] args) {
    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new KubernetesClientBuilder().withConfig(config).build()) {
      try (Watch watch = client.replicationControllers().inNamespace("thisisatest").withResourceVersion("0")
          .watch(new Watcher<ReplicationController>() {
            @Override
            public void eventReceived(Action action, ReplicationController resource) {
              logger.info("{}: {}", action, resource);
            }

            @Override
            public void onClose(WatcherException e) {
              if (e != null) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
              }
            }
          })) {
        // Create a namespace for all our stuff
        Namespace ns = new NamespaceBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks")
            .endMetadata().build();
        log("Created namespace", client.namespaces().resource(ns).create());

        // Get the namespace by name
        log("Get namespace by name", client.namespaces().withName("thisisatest").get());
        // Get the namespace by label
        log("Get namespace by label", client.namespaces().withLabel("this", "rocks").list());

        ResourceQuota quota = new ResourceQuotaBuilder().withNewMetadata().withName("pod-quota").endMetadata().withNewSpec()
            .addToHard("pods", new Quantity("10")).endSpec().build();
        log("Create resource quota", client.resourceQuotas().inNamespace("thisisatest").resource(quota).create());

        log("Get jobs in namespace", client.batch().v1().jobs().inNamespace("thisisatest").list());

        // Create an RC
        ReplicationController rc = new ReplicationControllerBuilder()
            .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
            .withNewSpec().withReplicas(3)
            .withNewTemplate()
            .withNewMetadata().addToLabels("server", "nginx").endMetadata()
            .withNewSpec()
            .addNewContainer().withName("nginx").withImage("nginx")
            .addNewPort().withContainerPort(80).endPort()
            .endContainer()
            .endSpec()
            .endTemplate()
            .endSpec().build();

        log("Created RC", client.replicationControllers().inNamespace("thisisatest").resource(rc).create());

        log("Created RC with inline DSL",
            client.replicationControllers().inNamespace("thisisatest").resource(new ReplicationControllerBuilder()
                .withNewMetadata().withName("nginx2-controller").addToLabels("server", "nginx").endMetadata()
                .withNewSpec().withReplicas(0)
                .withNewTemplate()
                .withNewMetadata().addToLabels("server", "nginx2").endMetadata()
                .withNewSpec()
                .addNewContainer().withName("nginx").withImage("nginx")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().build())
                .create());

        // Get the RC by name in namespace
        ReplicationController gotRc = client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller")
            .get();
        log("Get RC by name in namespace", gotRc);
        // Dump the RC as YAML
        log("Dump RC as YAML", Serialization.asYaml(gotRc));

        // Get the RC by label
        log("Get RC by label", client.replicationControllers().withLabel("server", "nginx").list());
        // Get the RC without label
        log("Get RC without label", client.replicationControllers().withoutLabel("server", "apache").list());
        // Get the RC with label in
        log("Get RC with label in", client.replicationControllers().withLabelIn("server", "nginx").list());
        // Get the RC with label in
        log("Get RC with label not in", client.replicationControllers().withLabelNotIn("server", "apache").list());
        // Get the RC by label in namespace
        log("Get RC by label in namespace",
            client.replicationControllers().inNamespace("thisisatest").withLabel("server", "nginx").list());
        // Update the RC
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller")
            .edit(r -> new ReplicationControllerBuilder(r).editMetadata().addToLabels("new", "label").endMetadata().build());

        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").scale(8);

        Thread.sleep(1000);

        // Update the RC - change the image to apache
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller")
            .edit(r -> new ReplicationControllerBuilder(r).editSpec().editTemplate().withNewSpec()
                .addNewContainer().withName("nginx").withImage("httpd")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().build());

        Thread.sleep(1000);

        // Update the RC - change the image back to nginx using a rolling update
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").updateImage("nginx");

        Thread.sleep(1000);

        // Update the RC via rolling update with inline builder
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller")
            .updateImage("nginx:stable-alpine");

        Thread.sleep(1000);

        //Update the RC inline
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller")
            .edit(r -> new ReplicationControllerBuilder(r)
                .editMetadata()
                .addToLabels("another", "label")
                .endMetadata()
                .build());

        log("Updated RC");
        // Clean up the RC
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").delete();
        client.replicationControllers().inNamespace("thisisatest").withName("nginx2-controller").delete();
        log("Deleted RCs");

        //Create another RC inline
        client.replicationControllers().inNamespace("thisisatest")
            .resource(new ReplicationControllerBuilder().withNewMetadata().withName("nginx-controller")
                .addToLabels("server", "nginx").endMetadata()
                .withNewSpec().withReplicas(3)
                .withNewTemplate()
                .withNewMetadata().addToLabels("server", "nginx").endMetadata()
                .withNewSpec()
                .addNewContainer().withName("nginx").withImage("nginx")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().build())
            .create();
        log("Created inline RC");

        Thread.sleep(1000);

        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").delete();
        log("Deleted RC");

        log("Created RC", client.replicationControllers().inNamespace("thisisatest").resource(rc).create());
        client.replicationControllers().inAnyNamespace().withLabel("server", "nginx").delete();
        log("Deleted RC by label");

        log("Created RC", client.replicationControllers().inNamespace("thisisatest").resource(rc).create());
        client.replicationControllers().inNamespace("thisisatest").withField("metadata.name", "nginx-controller").delete();
        log("Deleted RC by field");

        log("Created service",
            client.services().inNamespace("thisisatest").resource(new ServiceBuilder()
                .withNewMetadata().withName("testservice").endMetadata()
                .withNewSpec()
                .addNewPort().withPort(80).withNewTargetPort(80).endPort()
                .endSpec()
                .build())
                .create());
        log("Updated service", client.services().inNamespace("thisisatest").withName("testservice")
            .edit(s -> new ServiceBuilder(s).editMetadata().addToLabels("test", "label").endMetadata().build()));
        client.replicationControllers().inNamespace("thisisatest").withField("metadata.name", "testservice").delete();
        log("Deleted service by field");

        log("Root paths:", client.rootPaths());

      } finally {
        // And finally clean up the namespace
        client.namespaces().withName("thisisatest").delete();
        log("Deleted namespace");
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      Throwable[] suppressed = e.getSuppressed();
      if (suppressed != null) {
        for (Throwable t : suppressed) {
          logger.error(t.getMessage(), t);
        }
      }
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
