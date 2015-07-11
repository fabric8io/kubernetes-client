package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.DefaultKubernetesClient;
import io.fabric8.kubernetes.KubernetesClient;
import io.fabric8.kubernetes.KubernetesClientException;
import io.fabric8.kubernetes.NamedResource;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateExamples {

  private static final Logger logger = LoggerFactory.getLogger(UpdateExamples.class);

  public static void main(String[] args) {
    KubernetesClient client = null;

    String master = "https://localhost:8443";
    if (args.length == 1) {
      master = args[0];
    }

    try {
      client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

      System.out.println(
        client.pods().inNamespace("default").withName("rabbitmq-pod").update(
          new NamedResource.Update<Pod>() {
            @Override
            public Pod update(Pod pod) {
              pod.getMetadata().getLabels().put("this", "works");
              return pod;
            }
          }
        )
      );

      System.out.println(
        client.pods().inNamespace("default").withName("rabbitmq-pod").update(
          new NamedResource.BuilderUpdate<Pod, PodBuilder>() {
            @Override
            public Pod update(PodBuilder builder) {
              return builder.editMetadata().addToLabels("i", "rock").endMetadata().build();
            }
          }
        )
      );

      System.out.println(
        client.replicationControllers().inNamespace("default").withName("nginx-controller").scale(0)
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
