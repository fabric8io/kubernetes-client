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

import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class StorageClassExamples {

  private static final Logger logger = LoggerFactory.getLogger(StorageClassExamples.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      final String storageClassName = UUID.randomUUID().toString();
      logger.info("List of existent storage classes:");
      client.storage().v1().storageClasses().list().getItems()
          .forEach(sc -> logger.info(" - {}", sc.getMetadata().getName()));

      logger.info("Creating new Storage class");
      final StorageClass storageClass = client.storage().v1().storageClasses().resource(
          new StorageClassBuilder()
              .withNewMetadata().withName(storageClassName).endMetadata()
              .addToParameters("resturl", "http://localhost:8080")
              .addToParameters("restuser", "")
              .addToParameters("secretNamespace", "")
              .addToParameters("secretName", "")
              .addToParameters("key", "value1")
              .withProvisioner("k8s.io/minikube-hostpath")
              .build())
          .create();
      logger.info("Newly created storage class details:\n{}", storageClass);

      logger.info("Updated list of existent storage classes:");
      client.storage().v1().storageClasses().list().getItems()
          .forEach(sc -> logger.info(" - {}", sc.getMetadata().getName()));

      logger.info("Updating {} storage clas to add new label", storageClassName);
      final StorageClass updatedStorageClass = client.storage().v1().storageClasses().withName(storageClassName).edit(
          s -> new StorageClassBuilder(s).editMetadata().addToLabels("testLabel", "testLabelValue").endMetadata().build());
      logger.info("Updated storage class details:\n{}", updatedStorageClass);

      //delete storage class
      client.resource(storageClass).delete();
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
