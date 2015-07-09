package io.fabric8.kubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetExamples {

    private static final Logger logger = LoggerFactory.getLogger(GetExamples.class);

    public static void main(String[] args) {
        KubernetesClient client = null;

        try {
            client = new KubernetesClient("https://localhost:8443/api/v1/");

            System.out.println(
                    client.namespaces("fabric8").get()
            );

            System.out.println(
                    client.pods("rabbitmq-pod").inNamespace("default").get()
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
