package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateExamples {

    private static final Logger logger = LoggerFactory.getLogger(UpdateExamples.class);

    public static void main(String[] args) {
        KubernetesClient client = null;

        String master = "https://localhost:8443/api/v1/";
        if (args.length == 1) {
            master = args[0];
        }

        try {
            client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

            System.out.println(
                    client.pods("rabbitmq-pod").inNamespace("default").update(
                            new Resource.Update<Pod>() {
                                @Override
                                public Pod update(Pod pod) {
                                    pod.getMetadata().getLabels().put("this", "works");
                                    return pod;
                                }
                            }
                    )
            );

            System.out.println(
                    client.pods("rabbitmq-pod").inNamespace("default").update(
                            new Resource.BuilderUpdate<Pod, PodBuilder>() {
                                @Override
                                public Pod update(PodBuilder builder) {
                                    PodBuilder podBuilder = (PodBuilder) builder;
                                    return podBuilder.editMetadata().addToLabels("i", "rock").endMetadata().build();
                                }
                            }
                    )
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
