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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListExamples {

  private static final Logger logger = LoggerFactory.getLogger(ListExamples.class);

  public static void main(String[] args) {
    String master = "https://192.168.42.20:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

      System.out.println(
        client.namespaces().list()
      );

      System.out.println(
        client.namespaces().withLabel("this", "works").list()
      );

      System.out.println(
        client.pods().withLabel("this", "works").list()
      );

      System.out.println(
        client.pods().inNamespace("test").withLabel("this", "works").list()
      );

      System.out.println(
        client.pods().inNamespace("test").withName("testing").get()
      );

      /*
       * 	The continue option should be set when retrieving more results from the server.
       * 	Since this value is server defined, clients may only use the continue value from
       * 	a previous query result with identical query parameters (except for the value of
       * 	continue) and the server may reject a continue value it does not recognize.
       */
      PodList podList = client.pods().inNamespace("myproject").list(5, null);
      podList.getItems().forEach((obj) -> { System.out.println(obj.getMetadata().getName()); });

      podList = client.pods().inNamespace("myproject").list(5, podList.getMetadata().getContinue());
      podList.getItems().forEach((obj) -> { System.out.println(obj.getMetadata().getName()); });

      Integer services = client.services().inNamespace("myproject").list(1, null).getItems().size();
      System.out.println(services);
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }

}
