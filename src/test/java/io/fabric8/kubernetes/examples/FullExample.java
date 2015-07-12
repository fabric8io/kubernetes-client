package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.DefaultKubernetesClient;
import io.fabric8.kubernetes.KubernetesClient;
import io.fabric8.kubernetes.KubernetesClientException;
import io.fabric8.kubernetes.api.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullExample {

  private static final Logger logger = LoggerFactory.getLogger(DeleteExamples.class);

  public static void main(String[] args) {
    KubernetesClient client = null;

    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      // Create our client
      client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

      // Create a namespace for all our stuff
      Namespace ns = new NamespaceBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks").endMetadata().build();
      log("Created namespace", client.namespaces().create(ns));

      try {

        // Get the namespace by name
        log("Get namespace by name", client.namespaces().withName("thisisatest").get());
        // Get the namespace by label
        log("Get namespace by label", client.namespaces().withLabel("this", "rocks").list());

        // Create an RC
        ReplicationController rc = new ReplicationControllerBuilder()
          .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
          .withNewSpec().withReplicas(0)
          .withNewTemplate()
          .withNewMetadata().addToLabels("server", "nginx").endMetadata()
          .withNewSpec()
          .addNewContainer().withName("nginx").withImage("nginx")
          .addToPorts(new ContainerPortBuilder().withContainerPort(80).build())
          .endContainer()
          .endSpec()
          .endTemplate()
          .endSpec().build();
        log("Created RC", client.replicationControllers().inNamespace("thisisatest").create(rc));
        // Get the RC by name in namespace
        log("Get RC by name in namespace", client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").get());
        // Get the RC by label
        log("Get RC by label", client.replicationControllers().withLabel("server", "nginx").list());
        // Get the RC by label in namespace
        log("Get RC by label in namespace", client.replicationControllers().inNamespace("thisisatest").withLabel("server", "nginx").list());
        // Clean up the RC
        client.replicationControllers().inNamespace("thisisatest").withName("nginx-controller").delete();
        log("Deleted RC");

        log("Created RC", client.replicationControllers().inNamespace("thisisatest").create(rc));
        client.replicationControllers().withLabel("server", "nginx").delete();
        log("Deleted RC by label");

        log("Created RC", client.replicationControllers().inNamespace("thisisatest").create(rc));
        client.replicationControllers().inNamespace("thisisatest").withField("metadata.name", "nginx-controller").delete();
        log("Deleted RC by field");

      } finally {
        // And finally clean up the namespace
        client.namespaces().withName("thisisatest").delete();
        log("Deleted namespace");
      }
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } finally {
      if (client != null) {
        client.close();
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
