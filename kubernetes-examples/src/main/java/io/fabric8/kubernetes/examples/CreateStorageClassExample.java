package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.StorageClass;
import io.fabric8.kubernetes.api.model.StorageClassBuilder;
import io.fabric8.kubernetes.api.model.StorageClassList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreateStorageClassExample {

  private static final Logger logger = LoggerFactory.getLogger(CreateStorageClassExample.class);

  public static void main(String[] args) {

    String master = "http://localhost:8080/";

    if (args.length == 1) {
      master = args[0];
    }

    io.fabric8.kubernetes.client.Config config = new io.fabric8.kubernetes.client.ConfigBuilder().withMasterUrl(master).build();

    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

      //list all storage classes
      StorageClassList storageClassList = client.storageClasses().list();
      logger.info("List of storage classes: {}", storageClassList.toString());

      //create new storage class

      ObjectMeta metadata = new ObjectMeta();
      metadata.setName(UUID.randomUUID().toString());

      Map<String, String> parameters = new HashMap<>();
      parameters.put("resturl", "http://192.168.10.100:8080");
      parameters.put("restuser", "");
      parameters.put("secretNamespace", "");
      parameters.put("secretName", "");

      StorageClass storageClass = new StorageClassBuilder().withApiVersion("storage.k8s.io/v1")
                                                            .withKind("StorageClass")
                                                            .withMetadata(metadata)
                                                            .withParameters(parameters)
                                                            .withProvisioner("k8s.io/minikube-hostpath")
                                                            .build();

      storageClass = client.storageClasses().create(storageClass);
      logger.info("Newly created storage class details: {}", storageClass.toString());

      //list all storage classes
      client.storageClasses().list();
      logger.info("List of storage classes: {}", storageClassList.toString());


    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }

  }
}
