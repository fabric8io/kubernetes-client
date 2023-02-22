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

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This is an example of secret.
 */
public class SecretExamples {
  private static final Logger logger = LoggerFactory.getLogger(SecretExamples.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      final String secretName = UUID.randomUUID().toString();
      final String namespace = "default";
      logger.info("List of existent Secret:");
      client.secrets().inNamespace(namespace).list().getItems()
          .forEach(sc -> logger.info(" - {}", sc.getMetadata().getName()));

      logger.info("Creating new Secret");
      Map<String, String> data = new HashMap<>();
      data.put("tls.crt", "YWFh");
      data.put("tls.key", "YmJi");
      final Secret secret = new SecretBuilder()
          .withNewMetadata().withName(secretName).endMetadata()
          .withType("kubernetes.io/tls")
          .withImmutable(false)
          .addToData(data)
          .build();
      Secret secretCreated = client.secrets().inNamespace(namespace).resource(secret).create();
      logger.info("Newly created Secret details:\n{}", secretCreated);

      logger.info("Updated list of existent Secret:");
      client.secrets().inNamespace(namespace).list().getItems()
          .forEach(sc -> logger.info(" - {}", sc.getMetadata().getName()));

      logger.info("Updating {} Secret to add new label", secretName);
      final Secret updatedSecret = client.secrets().inNamespace(namespace).withName(secretName)
          .edit(s -> new SecretBuilder(s).editMetadata().addToLabels("testLabel", "testLabelValue").endMetadata().build());
      logger.info("Updated Secret details:\n{}", updatedSecret);

      //delete Secret
      client.resource(secret).inNamespace(namespace).delete();
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
