package io.fabric8.kubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ListExamples {

    private static final Logger logger = LoggerFactory.getLogger(ListExamples.class);

    public static void main(String[] args) {
        KubernetesClient client = null;

        try {
            client = new KubernetesClient("https://localhost:8443/api/v1/");

            System.out.println(
                    client.namespaces()
                            .withLabel("test", "something")
                            .get().getItems().size()
            );

            System.out.println(
                    client.pods()
                            .withField("metadata.name", "rabbitmq-pod")
                            .withNamespace("default")
                            .get().getItems().size()
            );

            System.out.println(
                    client.replicationControllers()
                            .withField("metadata.name", "rabbitmq-rc")
                            .withNamespace("default")
                            .get().getItems().size()
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
