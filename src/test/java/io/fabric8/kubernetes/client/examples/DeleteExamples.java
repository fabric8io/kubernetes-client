package io.fabric8.kubernetes.client.examples;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
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
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

      client.namespaces().withName("test").delete();

    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }

}
