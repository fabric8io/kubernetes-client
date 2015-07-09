package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateExamples {

    private static final Logger logger = LoggerFactory.getLogger(UpdateExamples.class);

    public static void main(String[] args) {
        KubernetesClient client = null;

        try {
            client = new KubernetesClient("https://localhost:8443/api/v1/");

            System.out.println(
                    client.pods("rabbitmq-pod").inNamespace("default").update(new Resource.ResourceUpdate<Pod>() {

                        @Override
                        public Pod update(PodBuilder podBuilder) {
                            return podBuilder.
                                        editMetadata().
                                            addToLabels("jimmi", "rocks")
                                        .endMetadata()
                                    .build();
                        }

                    })
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
