package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateExamples {

  private static final Logger logger = LoggerFactory.getLogger(CreateExamples.class);

  public static void main(String[] args) {
    KubernetesClient client = null;

    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

      Namespace newNamespace = new NamespaceBuilder().withNewMetadata().withName("thisisnew").endMetadata().build();
      System.out.println(
        client.newNamespace(newNamespace).create()
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
