package io.fabric8.kubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteExamples {

    private static final Logger logger = LoggerFactory.getLogger(DeleteExamples.class);

    public static void main(String[] args) {
        KubernetesClient client = null;

        String master = "https://localhost:8443/api/v1/";
        if (args.length == 1) {
            master = args[0];
        }

        try {
            client = new DefaultKubernetesClient.Builder().configFromSysPropsOrEnvVars().masterUrl(master).build();

            System.out.println(
                    client.namespaces("fabric8").delete()
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
