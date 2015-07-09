package io.fabric8.kubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class DeleteExamples {

    private static final Logger logger = LoggerFactory.getLogger(DeleteExamples.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException, KeyManagementException, NoSuchAlgorithmException, TimeoutException, KubernetesClientException {
        KubernetesClient client = new KubernetesClient("https://localhost:8443/api/v1/");
        try {
            System.out.println(
                    client.namespaces("fabric8").delete()
            );
        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        } finally {
            client.close();
        }
    }

}
