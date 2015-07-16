package io.fabric8.kubernetes.client.dsl.examples;

import io.fabric8.kubernetes.client.dsl.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.dsl.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListExamples {

  private static final Logger logger = LoggerFactory.getLogger(ListExamples.class);

  public static void main(String[] args) {
    KubernetesClient client = null;

    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      client = new DefaultKubernetesClient.Builder().masterUrl(master).build();

      System.out.println(
        client.namespaces().list()
      );

      System.out.println(
        client.namespaces().withLabel("this", "works").list()
      );

      System.out.println(
        client.pods().withLabel("this", "works").list()
      );

      System.out.println(
        client.pods().inNamespace("test").withLabel("this", "works").list()
      );

      System.out.println(
        client.pods().inNamespace("test").withName("testing").get()
      );
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } finally {
      if (client != null) {
        client.close();
      }
    }
  }

}
