package io.fabric8.kubernetes.client.dsl.examples;

import io.fabric8.kubernetes.client.dsl.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.dsl.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteExamples {

  private static final Logger logger = LoggerFactory.getLogger(DeleteExamples.class);

  public static void main(String[] args) {
    KubernetesClient client = null;

    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

      client.namespaces().withName("test").delete();

    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    } finally {
      if (client != null) {
        client.close();
      }
    }
  }

}
