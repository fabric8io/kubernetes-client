package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenShiftExamples {

  private static final Logger logger = LoggerFactory.getLogger(OpenShiftExamples.class);

  public static void main(String[] args) {
    OpenShiftClient client = null;

    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      client = new DefaultKubernetesClient.OpenShiftBuilder().configFromSysPropsOrEnvVars().masterUrl(master).build();

      Namespace newNamespace = new NamespaceBuilder().withNewMetadata().withName("thisisnew").endMetadata().build();

      System.out.println(
        client.namespaces().create(newNamespace)
      );

      System.out.println(
        client.buildConfigs().list()
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
