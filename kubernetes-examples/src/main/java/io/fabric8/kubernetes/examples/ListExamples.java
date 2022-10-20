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

import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@SuppressWarnings("java:S106")
public class ListExamples {

  private static final Logger logger = LoggerFactory.getLogger(ListExamples.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      final String namespace = Optional.ofNullable(client.getNamespace()).orElse("default");

      System.out.println(
          client.namespaces().list());

      System.out.println(
          client.namespaces().withLabel("this", "works").list());

      System.out.println(
          client.pods().withLabel("this", "works").list());

      System.out.println(
          client.pods().inNamespace("test").withLabel("this", "works").list());

      System.out.println(
          client.pods().inNamespace("test").withName("testing").get());

      /*
       * The continue option should be set when retrieving more results from the server.
       * Since this value is server defined, clients may only use the continue value from
       * a previous query result with identical query parameters (except for the value of
       * continue) and the server may reject a continue value it does not recognize.
       */
      PodList podList = client.pods().inNamespace(namespace).list(new ListOptionsBuilder().withLimit(5L).build());
      podList.getItems().forEach(obj -> System.out.println(obj.getMetadata().getName()));

      podList = client.pods().inNamespace(namespace)
          .list(new ListOptionsBuilder().withLimit(5L).withContinue(podList.getMetadata().getContinue()).build());
      podList.getItems().forEach(obj -> System.out.println(obj.getMetadata().getName()));

      Integer services = client.services().inNamespace(namespace)
          .list(new ListOptionsBuilder().withLimit(1L).build()).getItems().size();

      client.services().inNamespace(namespace).list(new ListOptionsBuilder().withLimit(1L).withContinue(null).build());
      System.out.println(services);
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }

}
