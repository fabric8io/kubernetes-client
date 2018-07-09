/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassBuilder;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageClassExamples {

  private static final Logger logger = LoggerFactory.getLogger(StorageClassExamples.class);

  public static void main(String[] args) {

    String master = "http://localhost:8080/";

    if (args.length == 1) {
      master = args[0];
    }

    io.fabric8.kubernetes.client.Config config = new io.fabric8.kubernetes.client.ConfigBuilder().withMasterUrl(master).build();

    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

      //list all storage classes
      StorageClassList storageClassList = client.storage().storageClasses().list();
      logger.info("List of storage classes: {}", storageClassList.toString());

      //create new storage class

      String name = UUID.randomUUID().toString();
      ObjectMeta metadata = new ObjectMeta();
      metadata.setName(name);

      Map<String, String> parameters = new HashMap<>();
      parameters.put("resturl", "http://192.168.10.100:8080");
      parameters.put("restuser", "");
      parameters.put("secretNamespace", "");
      parameters.put("secretName", "");
      parameters.put("key", "value1");

      StorageClass storageClass = new StorageClassBuilder().withApiVersion("storage.k8s.io/v1")
                                                            .withKind("StorageClass")
                                                            .withMetadata(metadata)
                                                            .withParameters(parameters)
                                                            .withProvisioner("k8s.io/minikube-hostpath")
                                                            .build();

      storageClass = client.storage().storageClasses().create(storageClass);
      logger.info("Newly created storage class details: {}", storageClass.toString());

      //list all storage classes
      storageClassList = client.storage().storageClasses().list();
      logger.info("List of storage classes: {}", storageClassList.toString());

      //update storage class. add label
      storageClass = client.storage().storageClasses().withName(name).edit().editMetadata().addToLabels("testLabel", "testLabelValue").endMetadata().done();

      //list all storage classes
      storageClassList = client.storage().storageClasses().list();
      logger.info("List of storage classes: {}", storageClassList.toString());


      //delete storage class
      boolean isDeleteSuccessful = client.storage().storageClasses().delete(storageClass);
      logger.info("Storage Class resource successfully deleted: {}", isDeleteSuccessful);


    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }

  }
}
